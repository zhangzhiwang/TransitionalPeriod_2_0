package cursor.wechat.website;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 微信开放平台网站应用扫码登录客户端。
 * 封装授权链接生成、code 换 token、刷新 token、拉取用户信息等服务端调用。
 *
 * （由 Curosr 自动生成）
 */
public class WeChatWebsiteLoginClient {

    /**
     * PC 扫码授权页地址前缀。
     *
     * （由 Curosr 自动生成）
     */
    private static final String QR_CONNECT_URL = "https://open.weixin.qq.com/connect/qrconnect";

    /**
     * 用 code 换取 access_token 的接口。
     *
     * （由 Curosr 自动生成）
     */
    private static final String ACCESS_TOKEN_URL = "https://api.weixin.qq.com/sns/oauth2/access_token";

    /**
     * 刷新 access_token 的接口。
     *
     * （由 Curosr 自动生成）
     */
    private static final String REFRESH_TOKEN_URL = "https://api.weixin.qq.com/sns/oauth2/refresh_token";

    /**
     * 校验 access_token 是否有效的接口。
     *
     * （由 Curosr 自动生成）
     */
    private static final String AUTH_URL = "https://api.weixin.qq.com/sns/auth";

    /**
     * 拉取用户个人信息的接口。
     *
     * （由 Curosr 自动生成）
     */
    private static final String USER_INFO_URL = "https://api.weixin.qq.com/sns/userinfo";

    /**
     * 网站应用登录配置。
     *
     * （由 Curosr 自动生成）
     */
    private final WeChatWebsiteLoginConfig config;

    /**
     * 使用指定配置构造登录客户端。
     *
     * @param config 网站应用配置
     *
     * （由 Curosr 自动生成）
     */
    public WeChatWebsiteLoginClient(WeChatWebsiteLoginConfig config) {
        this.config = config;
    }

    /**
     * 生成带 state 的扫码登录授权 URL，前端可直接 302 跳转或新开窗口打开。
     *
     * @param state 防 CSRF 随机串，回调时原样带回，建议存入 session 校验
     * @return 完整授权链接
     *
     * （由 Curosr 自动生成）
     */
    public String buildQrConnectUrl(String state) {
        try {
            String encodedRedirect = URLEncoder.encode(config.getRedirectUri(), "UTF-8");
            return QR_CONNECT_URL
                    + "?appid=" + urlEncode(config.getAppId())
                    + "&redirect_uri=" + encodedRedirect
                    + "&response_type=code"
                    + "&scope=snsapi_login"
                    + "&state=" + urlEncode(state == null ? "" : state)
                    + "#wechat_redirect";
        } catch (UnsupportedEncodingException e) {
            throw new IllegalStateException("UTF-8 编码不可用", e);
        }
    }

    /**
     * 用授权回调拿到的 code 换取 access_token / openid / unionid。
     * 必须在服务端调用，且 code 只能使用一次，约 10 分钟内有效。
     *
     * @param code 微信回调携带的 code
     * @return OAuth 凭证
     * @throws IOException 网络异常或微信返回错误时抛出
     *
     * （由 Curosr 自动生成）
     */
    public WeChatOAuthToken exchangeCode(String code) throws IOException {
        String url = ACCESS_TOKEN_URL
                + "?appid=" + urlEncode(config.getAppId())
                + "&secret=" + urlEncode(config.getAppSecret())
                + "&code=" + urlEncode(code)
                + "&grant_type=authorization_code";
        String body = httpGet(url);
        assertNoWeChatError(body);
        return parseToken(body);
    }

    /**
     * 使用 refresh_token 刷新 access_token。
     *
     * @param refreshToken 此前换到的 refresh_token
     * @return 新的 OAuth 凭证
     * @throws IOException 网络异常或微信返回错误时抛出
     *
     * （由 Curosr 自动生成）
     */
    public WeChatOAuthToken refreshToken(String refreshToken) throws IOException {
        String url = REFRESH_TOKEN_URL
                + "?appid=" + urlEncode(config.getAppId())
                + "&grant_type=refresh_token"
                + "&refresh_token=" + urlEncode(refreshToken);
        String body = httpGet(url);
        assertNoWeChatError(body);
        return parseToken(body);
    }

    /**
     * 校验 access_token 是否仍然有效。
     *
     * @param accessToken 接口调用凭证
     * @param openid      用户 openid
     * @return true 表示有效
     * @throws IOException 网络异常时抛出
     *
     * （由 Curosr 自动生成）
     */
    public boolean isAccessTokenValid(String accessToken, String openid) throws IOException {
        String url = AUTH_URL
                + "?access_token=" + urlEncode(accessToken)
                + "&openid=" + urlEncode(openid);
        String body = httpGet(url);
        String errcode = readJsonString(body, "errcode");
        return "0".equals(errcode);
    }

    /**
     * 根据 access_token 与 openid 拉取用户基本信息（昵称、头像等）。
     *
     * @param accessToken 接口调用凭证
     * @param openid      用户 openid
     * @return 用户信息
     * @throws IOException 网络异常或微信返回错误时抛出
     *
     * （由 Curosr 自动生成）
     */
    public WeChatUserInfo getUserInfo(String accessToken, String openid) throws IOException {
        String url = USER_INFO_URL
                + "?access_token=" + urlEncode(accessToken)
                + "&openid=" + urlEncode(openid);
        String body = httpGet(url);
        assertNoWeChatError(body);
        return parseUserInfo(body);
    }

    /**
     * 一次完成：code → token → 用户信息，适合作为登录回调接口的核心逻辑。
     *
     * @param code 回调 code
     * @return 用户信息
     * @throws IOException 调用微信接口失败时抛出
     *
     * （由 Curosr 自动生成）
     */
    public WeChatUserInfo loginByCode(String code) throws IOException {
        WeChatOAuthToken token = exchangeCode(code);
        return getUserInfo(token.getAccessToken(), token.getOpenid());
    }

    /**
     * 将 JSON 响应解析为 OAuth 凭证对象。
     *
     * @param json 微信返回的 JSON
     * @return 凭证对象
     *
     * （由 Curosr 自动生成）
     */
    private WeChatOAuthToken parseToken(String json) {
        WeChatOAuthToken token = new WeChatOAuthToken();
        token.setAccessToken(readJsonString(json, "access_token"));
        token.setRefreshToken(readJsonString(json, "refresh_token"));
        token.setOpenid(readJsonString(json, "openid"));
        token.setScope(readJsonString(json, "scope"));
        token.setUnionid(readJsonString(json, "unionid"));
        String expiresIn = readJsonNumber(json, "expires_in");
        if (expiresIn != null && !expiresIn.isEmpty()) {
            token.setExpiresIn(Integer.parseInt(expiresIn));
        }
        return token;
    }

    /**
     * 将 JSON 响应解析为用户信息对象。
     *
     * @param json 微信返回的 JSON
     * @return 用户信息
     *
     * （由 Curosr 自动生成）
     */
    private WeChatUserInfo parseUserInfo(String json) {
        WeChatUserInfo info = new WeChatUserInfo();
        info.setOpenid(readJsonString(json, "openid"));
        info.setNickname(readJsonString(json, "nickname"));
        info.setProvince(readJsonString(json, "province"));
        info.setCity(readJsonString(json, "city"));
        info.setCountry(readJsonString(json, "country"));
        info.setHeadimgurl(readJsonString(json, "headimgurl"));
        info.setUnionid(readJsonString(json, "unionid"));
        String sex = readJsonNumber(json, "sex");
        if (sex != null && !sex.isEmpty()) {
            info.setSex(Integer.parseInt(sex));
        }
        return info;
    }

    /**
     * 若响应中含有非 0 的 errcode，则视为失败并抛出异常。
     *
     * @param json 原始响应
     * @throws IOException 业务错误时抛出
     *
     * （由 Curosr 自动生成）
     */
    private void assertNoWeChatError(String json) throws IOException {
        String errcode = readJsonNumber(json, "errcode");
        if (errcode != null && !errcode.isEmpty() && !"0".equals(errcode)) {
            String errmsg = readJsonString(json, "errmsg");
            throw new IOException("微信接口错误 errcode=" + errcode + ", errmsg=" + errmsg + ", body=" + json);
        }
    }

    /**
     * 从简单扁平 JSON 中读取字符串字段值。
     *
     * @param json JSON 文本
     * @param key  字段名
     * @return 字段值，不存在时返回 null
     *
     * （由 Curosr 自动生成）
     */
    private String readJsonString(String json, String key) {
        Pattern pattern = Pattern.compile("\"" + Pattern.quote(key) + "\"\\s*:\\s*\"((?:\\\\.|[^\"\\\\])*)\"");
        Matcher matcher = pattern.matcher(json);
        if (!matcher.find()) {
            return null;
        }
        return unescapeJson(matcher.group(1));
    }

    /**
     * 从简单扁平 JSON 中读取数字字段值。
     *
     * @param json JSON 文本
     * @param key  字段名
     * @return 数字字符串，不存在时返回 null
     *
     * （由 Curosr 自动生成）
     */
    private String readJsonNumber(String json, String key) {
        Pattern pattern = Pattern.compile("\"" + Pattern.quote(key) + "\"\\s*:\\s*(-?\\d+)");
        Matcher matcher = pattern.matcher(json);
        return matcher.find() ? matcher.group(1) : null;
    }

    /**
     * 还原 JSON 字符串中的常见转义。
     *
     * @param text 原始转义文本
     * @return 还原后的文本
     *
     * （由 Curosr 自动生成）
     */
    private String unescapeJson(String text) {
        return text.replace("\\\"", "\"")
                .replace("\\\\", "\\")
                .replace("\\/", "/")
                .replace("\\n", "\n")
                .replace("\\r", "\r")
                .replace("\\t", "\t");
    }

    /**
     * 对查询参数做 UTF-8 URL 编码。
     *
     * @param value 原始值
     * @return 编码后的值
     *
     * （由 Curosr 自动生成）
     */
    private String urlEncode(String value) {
        try {
            return URLEncoder.encode(value == null ? "" : value, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new IllegalStateException("UTF-8 编码不可用", e);
        }
    }

    /**
     * 发起 HTTP GET 并读取响应体。
     *
     * @param urlString 完整请求 URL
     * @return 响应正文
     * @throws IOException 请求失败时抛出
     *
     * （由 Curosr 自动生成）
     */
    private String httpGet(String urlString) throws IOException {
        HttpURLConnection connection = null;
        try {
            URL url = new URL(urlString);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(8000);
            connection.setReadTimeout(8000);
            connection.setRequestProperty("Accept", "application/json");

            int status = connection.getResponseCode();
            InputStream stream = status >= 400 ? connection.getErrorStream() : connection.getInputStream();
            if (stream == null) {
                throw new IOException("微信接口无响应体, HTTP " + status);
            }
            String body = readFully(stream);
            if (status >= 400) {
                throw new IOException("HTTP " + status + ": " + body);
            }
            return body;
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }
    }

    /**
     * 将输入流按 UTF-8 读成字符串。
     *
     * @param inputStream 输入流
     * @return 文本内容
     * @throws IOException 读取失败时抛出
     *
     * （由 Curosr 自动生成）
     */
    private String readFully(InputStream inputStream) throws IOException {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(inputStream, StandardCharsets.UTF_8))) {
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
        }
        return sb.toString();
    }
}
