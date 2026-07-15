package wechat.website;

/**
 * 微信开放平台「网站应用」登录相关配置。
 * 在开放平台创建并审核通过网站应用后填写 AppID、AppSecret 与授权回调域名对应的 redirectUri。
 *
 * （由 Curosr 自动生成）
 */
public class WeChatWebsiteLoginConfig {

    /**
     * 网站应用 AppID。
     *
     * （由 Curosr 自动生成）
     */
    private final String appId;

    /**
     * 网站应用 AppSecret，仅应保存在服务端。
     *
     * （由 Curosr 自动生成）
     */
    private final String appSecret;

    /**
     * 授权回调地址，需与开放平台配置的授权回调域名匹配，并已做 URL Encode 前的原始值。
     *
     * （由 Curosr 自动生成）
     */
    private final String redirectUri;

    /**
     * 构造网站应用登录配置。
     *
     * @param appId       应用 AppID
     * @param appSecret   应用 AppSecret
     * @param redirectUri 授权成功后的回调地址
     *
     * （由 Curosr 自动生成）
     */
    public WeChatWebsiteLoginConfig(String appId, String appSecret, String redirectUri) {
        this.appId = appId;
        this.appSecret = appSecret;
        this.redirectUri = redirectUri;
    }

    /**
     * 获取 AppID。
     *
     * @return AppID
     *
     * （由 Curosr 自动生成）
     */
    public String getAppId() {
        return appId;
    }

    /**
     * 获取 AppSecret。
     *
     * @return AppSecret
     *
     * （由 Curosr 自动生成）
     */
    public String getAppSecret() {
        return appSecret;
    }

    /**
     * 获取授权回调地址。
     *
     * @return redirectUri
     *
     * （由 Curosr 自动生成）
     */
    public String getRedirectUri() {
        return redirectUri;
    }
}
