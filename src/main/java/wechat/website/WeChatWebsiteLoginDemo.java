package wechat.website;

import java.io.IOException;
import java.util.UUID;

/**
 * 微信开放平台网站应用登录后端用法示例。
 * 演示：生成扫码授权链接 → 用回调 code 换 token 并拉取用户信息。
 * 实际项目中通常把回调逻辑放到 Controller/Servlet，此处用 main 方便本地理解流程。
 *
 * （由 Curosr 自动生成）
 */
public class WeChatWebsiteLoginDemo {

    /**
     * 示例入口：请先替换为你在开放平台审核通过的真实配置再运行。
     *
     * @param args 命令行参数；args[0] 可传回调 code，有 code 时走换票逻辑
     * @throws IOException 调用微信接口失败时抛出
     *
     * （由 Curosr 自动生成）
     */
    public static void main(String[] args) throws IOException {
        WeChatWebsiteLoginConfig config = new WeChatWebsiteLoginConfig(
                "你的AppID",
                "你的AppSecret",
                "https://your.domain.com/wechat/callback"
        );
        WeChatWebsiteLoginClient client = new WeChatWebsiteLoginClient(config);

        if (args.length == 0) {
            // 第一步：生成授权 URL，把它返回给前端跳转（或在浏览器打开扫码）
            String state = UUID.randomUUID().toString().replace("-", "");
            String authorizeUrl = client.buildQrConnectUrl(state);
            System.out.println("请将 state 存入 Session 后跳转：");
            System.out.println("state = " + state);
            System.out.println("authorizeUrl = " + authorizeUrl);
            System.out.println();
            System.out.println("用户扫码授权后，微信会回调：");
            System.out.println(config.getRedirectUri() + "?code=CODE&state=" + state);
            System.out.println("拿到 code 后可执行：java ... WeChatWebsiteLoginDemo <code>");
            return;
        }

        // 第二步：回调拿到 code 后，服务端换 token 并取用户信息
        String code = args[0];
        WeChatOAuthToken token = client.exchangeCode(code);
        System.out.println("token = " + token);

        WeChatUserInfo userInfo = client.getUserInfo(token.getAccessToken(), token.getOpenid());
        System.out.println("userInfo = " + userInfo);

        // 第三步：在你自己的系统里按 openid/unionid 建登录态（Session / JWT 等）
        System.out.println("登录成功，可据此建立本站会话，openid=" + userInfo.getOpenid());
    }

    /**
     * 近似「回调接口」的处理逻辑，可直接拷到 Spring Controller 中使用。
     *
     * @param client        登录客户端
     * @param code          回调参数 code
     * @param state         回调参数 state
     * @param expectedState 登录前放入 Session 的 state
     * @return 微信用户信息
     * @throws IOException              微信接口失败
     * @throws IllegalArgumentException state 校验失败
     *
     * （由 Curosr 自动生成）
     */
    public static WeChatUserInfo handleCallback(WeChatWebsiteLoginClient client,
                                                String code,
                                                String state,
                                                String expectedState) throws IOException {
        if (expectedState == null || !expectedState.equals(state)) {
            throw new IllegalArgumentException("state 校验失败，可能存在 CSRF 风险");
        }
        if (code == null || code.trim().isEmpty()) {
            throw new IllegalArgumentException("缺少 code");
        }
        return client.loginByCode(code);
    }
}
