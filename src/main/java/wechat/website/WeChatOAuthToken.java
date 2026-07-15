package wechat.website;

/**
 * 通过 code 换取的网站应用 OAuth 凭证结果。
 *
 * （由 Curosr 自动生成）
 */
public class WeChatOAuthToken {

    /**
     * 接口调用凭证 access_token。
     *
     * （由 Curosr 自动生成）
     */
    private String accessToken;

    /**
     * access_token 有效期（秒）。
     *
     * （由 Curosr 自动生成）
     */
    private int expiresIn;

    /**
     * 用于刷新 access_token 的 refresh_token。
     *
     * （由 Curosr 自动生成）
     */
    private String refreshToken;

    /**
     * 授权用户在本应用下的唯一标识 openid。
     *
     * （由 Curosr 自动生成）
     */
    private String openid;

    /**
     * 用户授权作用域，多个用逗号分隔。
     *
     * （由 Curosr 自动生成）
     */
    private String scope;

    /**
     * 开放平台账号下同一用户的统一标识，绑定开放平台账号后才会返回。
     *
     * （由 Curosr 自动生成）
     */
    private String unionid;

    /**
     * 获取 access_token。
     *
     * @return access_token
     *
     * （由 Curosr 自动生成）
     */
    public String getAccessToken() {
        return accessToken;
    }

    /**
     * 设置 access_token。
     *
     * @param accessToken 接口调用凭证
     *
     * （由 Curosr 自动生成）
     */
    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    /**
     * 获取凭证过期时间（秒）。
     *
     * @return expiresIn
     *
     * （由 Curosr 自动生成）
     */
    public int getExpiresIn() {
        return expiresIn;
    }

    /**
     * 设置凭证过期时间（秒）。
     *
     * @param expiresIn 过期秒数
     *
     * （由 Curosr 自动生成）
     */
    public void setExpiresIn(int expiresIn) {
        this.expiresIn = expiresIn;
    }

    /**
     * 获取 refresh_token。
     *
     * @return refresh_token
     *
     * （由 Curosr 自动生成）
     */
    public String getRefreshToken() {
        return refreshToken;
    }

    /**
     * 设置 refresh_token。
     *
     * @param refreshToken 刷新凭证
     *
     * （由 Curosr 自动生成）
     */
    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    /**
     * 获取用户 openid。
     *
     * @return openid
     *
     * （由 Curosr 自动生成）
     */
    public String getOpenid() {
        return openid;
    }

    /**
     * 设置用户 openid。
     *
     * @param openid 用户唯一标识
     *
     * （由 Curosr 自动生成）
     */
    public void setOpenid(String openid) {
        this.openid = openid;
    }

    /**
     * 获取授权 scope。
     *
     * @return scope
     *
     * （由 Curosr 自动生成）
     */
    public String getScope() {
        return scope;
    }

    /**
     * 设置授权 scope。
     *
     * @param scope 授权作用域
     *
     * （由 Curosr 自动生成）
     */
    public void setScope(String scope) {
        this.scope = scope;
    }

    /**
     * 获取 unionid。
     *
     * @return unionid
     *
     * （由 Curosr 自动生成）
     */
    public String getUnionid() {
        return unionid;
    }

    /**
     * 设置 unionid。
     *
     * @param unionid 开放平台统一用户标识
     *
     * （由 Curosr 自动生成）
     */
    public void setUnionid(String unionid) {
        this.unionid = unionid;
    }

    /**
     * 便于调试的字符串表示。
     *
     * @return 对象摘要
     *
     * （由 Curosr 自动生成）
     */
    @Override
    public String toString() {
        return "WeChatOAuthToken{"
                + "accessToken='" + accessToken + '\''
                + ", expiresIn=" + expiresIn
                + ", refreshToken='" + refreshToken + '\''
                + ", openid='" + openid + '\''
                + ", scope='" + scope + '\''
                + ", unionid='" + unionid + '\''
                + '}';
    }
}
