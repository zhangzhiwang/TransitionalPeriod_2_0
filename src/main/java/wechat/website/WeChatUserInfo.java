package wechat.website;

/**
 * 网站应用授权后通过 /sns/userinfo 获取的用户基本信息。
 *
 * （由 Curosr 自动生成）
 */
public class WeChatUserInfo {

    /**
     * 用户在本应用下的 openid。
     *
     * （由 Curosr 自动生成）
     */
    private String openid;

    /**
     * 用户昵称。
     *
     * （由 Curosr 自动生成）
     */
    private String nickname;

    /**
     * 性别：1 男，2 女，0 未知。
     *
     * （由 Curosr 自动生成）
     */
    private int sex;

    /**
     * 省份。
     *
     * （由 Curosr 自动生成）
     */
    private String province;

    /**
     * 城市。
     *
     * （由 Curosr 自动生成）
     */
    private String city;

    /**
     * 国家。
     *
     * （由 Curosr 自动生成）
     */
    private String country;

    /**
     * 用户头像 URL。
     *
     * （由 Curosr 自动生成）
     */
    private String headimgurl;

    /**
     * 开放平台统一用户标识。
     *
     * （由 Curosr 自动生成）
     */
    private String unionid;

    /**
     * 获取 openid。
     *
     * @return openid
     *
     * （由 Curosr 自动生成）
     */
    public String getOpenid() {
        return openid;
    }

    /**
     * 设置 openid。
     *
     * @param openid 用户标识
     *
     * （由 Curosr 自动生成）
     */
    public void setOpenid(String openid) {
        this.openid = openid;
    }

    /**
     * 获取昵称。
     *
     * @return nickname
     *
     * （由 Curosr 自动生成）
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * 设置昵称。
     *
     * @param nickname 昵称
     *
     * （由 Curosr 自动生成）
     */
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    /**
     * 获取性别。
     *
     * @return sex
     *
     * （由 Curosr 自动生成）
     */
    public int getSex() {
        return sex;
    }

    /**
     * 设置性别。
     *
     * @param sex 性别编码
     *
     * （由 Curosr 自动生成）
     */
    public void setSex(int sex) {
        this.sex = sex;
    }

    /**
     * 获取省份。
     *
     * @return province
     *
     * （由 Curosr 自动生成）
     */
    public String getProvince() {
        return province;
    }

    /**
     * 设置省份。
     *
     * @param province 省份
     *
     * （由 Curosr 自动生成）
     */
    public void setProvince(String province) {
        this.province = province;
    }

    /**
     * 获取城市。
     *
     * @return city
     *
     * （由 Curosr 自动生成）
     */
    public String getCity() {
        return city;
    }

    /**
     * 设置城市。
     *
     * @param city 城市
     *
     * （由 Curosr 自动生成）
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * 获取国家。
     *
     * @return country
     *
     * （由 Curosr 自动生成）
     */
    public String getCountry() {
        return country;
    }

    /**
     * 设置国家。
     *
     * @param country 国家
     *
     * （由 Curosr 自动生成）
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * 获取头像地址。
     *
     * @return headimgurl
     *
     * （由 Curosr 自动生成）
     */
    public String getHeadimgurl() {
        return headimgurl;
    }

    /**
     * 设置头像地址。
     *
     * @param headimgurl 头像 URL
     *
     * （由 Curosr 自动生成）
     */
    public void setHeadimgurl(String headimgurl) {
        this.headimgurl = headimgurl;
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
     * @param unionid 统一用户标识
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
        return "WeChatUserInfo{"
                + "openid='" + openid + '\''
                + ", nickname='" + nickname + '\''
                + ", sex=" + sex
                + ", province='" + province + '\''
                + ", city='" + city + '\''
                + ", country='" + country + '\''
                + ", headimgurl='" + headimgurl + '\''
                + ", unionid='" + unionid + '\''
                + '}';
    }
}
