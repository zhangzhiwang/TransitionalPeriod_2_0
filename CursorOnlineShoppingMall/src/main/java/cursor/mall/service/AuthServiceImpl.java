package cursor.mall.service;

import cursor.mall.common.SessionKeys;
import cursor.mall.dao.interfaces.MallUserDao;
import cursor.mall.model.LoginRequest;
import cursor.mall.model.MallUser;
import cursor.mall.model.RegisterRequest;
import cursor.mall.model.UserSessionView;
import cursor.mall.service.interfaces.AuthService;
import cursor.mall.util.PasswordHasher;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.util.regex.Pattern;

/**
 * 登录注册业务实现：邮箱 6 位验证码校验后真实写入 mall_user。
 * （由 Curosr 自动生成）
 */
@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    /** 邮箱格式。 */
    private static final Pattern EMAIL_PATTERN =
            Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$");

    /** 用户名：字母数字下划线，3–50 位。 */
    private static final Pattern USERNAME_PATTERN =
            Pattern.compile("^[A-Za-z0-9_]{3,50}$");

    /** 用户 Dao。 */
    private final MallUserDao mallUserDao;

    /** 注册验证码存储与发送。 */
    private final RegisterCodeStore registerCodeStore;

    /**
     * {@inheritDoc}
     * （由 Curosr 自动生成）
     */
    @Override
    public void sendRegisterCode(String email) {
        String normalized = trimToNull(email);
        if (!StringUtils.hasText(normalized)) {
            throw new IllegalArgumentException("请填写邮箱");
        }
        if (normalized.length() > 100 || !EMAIL_PATTERN.matcher(normalized).matches()) {
            throw new IllegalArgumentException("邮箱格式不正确");
        }
        registerCodeStore.sendCode(normalized);
    }

    /**
     * {@inheritDoc}
     * （由 Curosr 自动生成）
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public UserSessionView register(RegisterRequest request) {
        if (request == null) {
            throw new IllegalArgumentException("请填写注册信息");
        }
        String username = trimToNull(request.getUsername());
        String password = request.getPassword() == null ? "" : request.getPassword();
        String confirmPassword = request.getConfirmPassword() == null ? "" : request.getConfirmPassword();
        String email = trimToNull(request.getEmail());
        String verifyCode = request.getVerifyCode() == null ? "" : request.getVerifyCode().trim();

        if (!StringUtils.hasText(username)) {
            throw new IllegalArgumentException("请填写用户名");
        }
        if (!USERNAME_PATTERN.matcher(username).matches()) {
            throw new IllegalArgumentException("用户名需为 3–50 位字母、数字或下划线");
        }
        if (!StringUtils.hasText(password)) {
            throw new IllegalArgumentException("请填写密码");
        }
        if (password.length() < 6 || password.length() > 64) {
            throw new IllegalArgumentException("密码长度需为 6–64 位");
        }
        if (!password.equals(confirmPassword)) {
            throw new IllegalArgumentException("两次密码不一致");
        }
        if (!StringUtils.hasText(email)) {
            throw new IllegalArgumentException("请填写邮箱");
        }
        if (email.length() > 100 || !EMAIL_PATTERN.matcher(email).matches()) {
            throw new IllegalArgumentException("邮箱格式不正确");
        }
        email = email.toLowerCase();
        // 先校验验证码（一次性消费），再写库
        registerCodeStore.consumeValidCode(email, verifyCode);

        if (mallUserDao.findByUsername(username) != null) {
            throw new IllegalArgumentException("用户名已存在");
        }
        if (mallUserDao.findByEmail(email) != null) {
            throw new IllegalArgumentException("邮箱已被注册");
        }

        LocalDateTime now = LocalDateTime.now();
        MallUser user = new MallUser();
        user.setUsername(username);
        user.setPasswordHash(PasswordHasher.sha256Hex(password));
        user.setEmail(email);
        user.setNickname(username);
        user.setAvatarUrl(null);
        user.setWechatOpenid(null);
        user.setStatus(1);
        user.setCreatedAt(now);
        user.setUpdatedAt(now);

        try {
            int rows = mallUserDao.insert(user);
            if (rows != 1 || user.getId() == null) {
                throw new IllegalStateException("注册失败，请稍后重试");
            }
        } catch (DuplicateKeyException ex) {
            throw new IllegalArgumentException("用户名或邮箱已存在");
        }

        UserSessionView view = new UserSessionView();
        view.setUserId(user.getId());
        view.setUsername(user.getUsername());
        view.setNickname(user.getNickname());
        view.setAvatarUrl(user.getAvatarUrl());
        view.setLoggedIn(false);
        return view;
    }

    /**
     * {@inheritDoc}
     * （由 Curosr 自动生成）
     */
    @Override
    public UserSessionView login(LoginRequest request, HttpSession session) {
        if (request == null) {
            throw new IllegalArgumentException("请填写登录信息");
        }
        String username = trimToNull(request.getUsername());
        String password = request.getPassword() == null ? "" : request.getPassword();
        if (!StringUtils.hasText(username) || !StringUtils.hasText(password)) {
            throw new IllegalArgumentException("请输入用户名和密码");
        }

        MallUser user = mallUserDao.findByUsername(username);
        if (user == null) {
            throw new IllegalArgumentException("用户名或密码错误");
        }
        if (user.getStatus() == null || user.getStatus() != 1) {
            throw new IllegalArgumentException("账号已禁用");
        }
        String inputHash = PasswordHasher.sha256Hex(password);
        if (!PasswordHasher.matches(user.getPasswordHash(), inputHash)) {
            throw new IllegalArgumentException("用户名或密码错误");
        }

        UserSessionView view = toView(user, true);
        session.setAttribute(SessionKeys.LOGIN_USER, view);
        return view;
    }

    /**
     * {@inheritDoc}
     * （由 Curosr 自动生成）
     */
    @Override
    public void logout(HttpSession session) {
        if (session != null) {
            session.removeAttribute(SessionKeys.LOGIN_USER);
            session.invalidate();
        }
    }

    /**
     * {@inheritDoc}
     * （由 Curosr 自动生成）
     */
    @Override
    public UserSessionView currentUser(HttpSession session) {
        if (session == null) {
            return guestView();
        }
        Object attr = session.getAttribute(SessionKeys.LOGIN_USER);
        if (!(attr instanceof UserSessionView)) {
            return guestView();
        }
        UserSessionView cached = (UserSessionView) attr;
        if (cached.getUserId() == null) {
            return guestView();
        }
        MallUser user = mallUserDao.findById(cached.getUserId());
        if (user == null || user.getStatus() == null || user.getStatus() != 1) {
            session.removeAttribute(SessionKeys.LOGIN_USER);
            return guestView();
        }
        UserSessionView fresh = toView(user, true);
        session.setAttribute(SessionKeys.LOGIN_USER, fresh);
        return fresh;
    }

    /**
     * 实体转会话视图。
     * （由 Curosr 自动生成）
     *
     * @param user     用户实体
     * @param loggedIn 是否已登录
     * @return 视图
     */
    private UserSessionView toView(MallUser user, boolean loggedIn) {
        UserSessionView view = new UserSessionView();
        view.setUserId(user.getId());
        view.setUsername(user.getUsername());
        view.setNickname(user.getNickname());
        view.setAvatarUrl(user.getAvatarUrl());
        view.setLoggedIn(loggedIn);
        return view;
    }

    /**
     * 游客视图。
     * （由 Curosr 自动生成）
     *
     * @return loggedIn=false 的视图
     */
    private UserSessionView guestView() {
        UserSessionView view = new UserSessionView();
        view.setLoggedIn(false);
        return view;
    }

    /**
     * 去空白，空则 null。
     * （由 Curosr 自动生成）
     *
     * @param value 原字符串
     * @return 处理后的值
     */
    private String trimToNull(String value) {
        if (value == null) {
            return null;
        }
        String trimmed = value.trim();
        return trimmed.isEmpty() ? null : trimmed;
    }
}
