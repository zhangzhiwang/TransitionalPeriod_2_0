package cursor.website.service;

import cursor.website.dao.interfaces.GuestbookDao;
import cursor.website.model.Guestbook;
import cursor.website.model.GuestbookListPage;
import cursor.website.model.GuestbookSubmitRequest;
import cursor.website.service.interfaces.GuestbookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Pattern;

/**
 * 网站留言业务服务实现：列表、提交校验、敏感词与 IP 限流。
 * （由 Curosr 自动生成）
 */
@Service
@RequiredArgsConstructor
public class GuestbookServiceImpl implements GuestbookService {

    /** 同一 IP 最短提交间隔（毫秒）。 */
    private static final long RATE_LIMIT_MS = 60_000L;

    /** 简单敏感词列表。 */
    private static final List<String> SENSITIVE_WORDS =
            Arrays.asList("赌博", "色情", "代开发票", "加微信刷单");

    /** 邮箱格式校验。 */
    private static final Pattern EMAIL_PATTERN =
            Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");

    /** IP 最近提交时间。 */
    private final ConcurrentHashMap<String, Long> lastSubmitByIp = new ConcurrentHashMap<String, Long>();

    /** 留言 Dao。 */
    private final GuestbookDao guestbookDao;

    /**
     * {@inheritDoc}
     * （由 Curosr 自动生成）
     */
    @Override
    public GuestbookListPage buildListPage(int page, int size) {
        if (page < 1) {
            page = 1;
        }
        if (size < 1) {
            size = 10;
        }
        int offset = (page - 1) * size;
        List<Guestbook> raw = guestbookDao.listApproved(offset, size);
        List<Guestbook> items = new ArrayList<Guestbook>();
        for (Guestbook item : raw) {
            items.add(toPublicView(item));
        }
        long total = guestbookDao.countApproved();
        GuestbookListPage result = new GuestbookListPage();
        result.setItems(items);
        result.setPage(page);
        result.setSize(size);
        result.setHasMore(offset + items.size() < total);
        return result;
    }

    /**
     * {@inheritDoc}
     * （由 Curosr 自动生成）
     */
    @Override
    public void submit(GuestbookSubmitRequest request, String clientIp) {
        if (request == null) {
            throw new IllegalArgumentException("请填写留言内容");
        }
        String nickname = trimToNull(request.getNickname());
        String content = trimToNull(request.getContent());
        String email = trimToNull(request.getEmail());

        if (!StringUtils.hasText(nickname)) {
            throw new IllegalArgumentException("请填写昵称");
        }
        if (nickname.length() > 50) {
            throw new IllegalArgumentException("昵称不能超过 50 字");
        }
        if (!StringUtils.hasText(content)) {
            throw new IllegalArgumentException("请填写留言内容");
        }
        if (content.length() > 1000) {
            throw new IllegalArgumentException("留言内容不能超过 1000 字");
        }
        if (email != null) {
            if (email.length() > 100 || !EMAIL_PATTERN.matcher(email).matches()) {
                throw new IllegalArgumentException("邮箱格式不正确");
            }
        }
        if (containsSensitive(nickname) || containsSensitive(content)) {
            throw new IllegalArgumentException("内容包含不当用语，请修改后重试");
        }

        String ip = StringUtils.hasText(clientIp) ? clientIp : "unknown";
        assertRateLimit(ip);

        Guestbook entity = new Guestbook();
        entity.setNickname(nickname);
        entity.setEmail(email);
        entity.setContent(content);
        entity.setClientIp(ip);
        entity.setStatus("pending");
        entity.setCreatedAt(LocalDateTime.now());
        guestbookDao.insert(entity);
        lastSubmitByIp.put(ip, System.currentTimeMillis());
    }

    /**
     * 转为公开视图：清除邮箱与 IP。
     * （由 Curosr 自动生成）
     *
     * @param source 原始实体
     * @return 公开视图
     */
    private Guestbook toPublicView(Guestbook source) {
        Guestbook view = new Guestbook();
        view.setId(source.getId());
        view.setNickname(source.getNickname());
        view.setContent(source.getContent());
        view.setReply(source.getReply());
        view.setReplyTime(source.getReplyTime());
        view.setStatus(source.getStatus());
        view.setCreatedAt(source.getCreatedAt());
        view.setEmail(null);
        view.setClientIp(null);
        return view;
    }

    /**
     * 检查是否包含敏感词。
     * （由 Curosr 自动生成）
     *
     * @param text 文本
     * @return 是否命中
     */
    private boolean containsSensitive(String text) {
        if (!StringUtils.hasText(text)) {
            return false;
        }
        for (String word : SENSITIVE_WORDS) {
            if (text.contains(word)) {
                return true;
            }
        }
        return false;
    }

    /**
     * IP 短时限流校验。
     * （由 Curosr 自动生成）
     *
     * @param ip 客户端 IP
     */
    private void assertRateLimit(String ip) {
        Long last = lastSubmitByIp.get(ip);
        if (last != null && System.currentTimeMillis() - last < RATE_LIMIT_MS) {
            throw new IllegalStateException("提交过于频繁，请稍后再试");
        }
    }

    /**
     * 去除空白，空则返回 null。
     * （由 Curosr 自动生成）
     *
     * @param value 原始字符串
     * @return 处理后的字符串
     */
    private String trimToNull(String value) {
        if (!StringUtils.hasText(value)) {
            return null;
        }
        return value.trim();
    }
}
