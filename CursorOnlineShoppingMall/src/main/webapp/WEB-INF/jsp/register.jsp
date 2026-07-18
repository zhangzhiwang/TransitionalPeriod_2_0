<%--
  注册页：用户名、密码、确认密码、邮箱、6 位验证码。
  （由 Curosr 自动生成）
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
  <title>注册 · CursorOnlineShoppingMall</title>
  <link rel="stylesheet" href="${ctx}/css/mall.css">
</head>
<body class="page-auth">
  <main class="auth-main">
    <div class="auth-card">
      <a class="auth-back" href="${ctx}/login">← 返回登录</a>
      <h1 class="auth-title">注册账号</h1>
      <form id="registerForm" class="auth-form" novalidate>
        <label class="auth-label" for="username">用户名</label>
        <input class="auth-input" id="username" name="username" type="text"
               autocomplete="username" maxlength="50" placeholder="3–50 位字母数字下划线" required>

        <label class="auth-label" for="password">密码</label>
        <input class="auth-input" id="password" name="password" type="password"
               autocomplete="new-password" maxlength="64" placeholder="至少 6 位" required>

        <label class="auth-label" for="confirmPassword">确认密码</label>
        <input class="auth-input" id="confirmPassword" name="confirmPassword" type="password"
               autocomplete="new-password" maxlength="64" placeholder="再次输入密码" required>

        <label class="auth-label" for="email">邮箱</label>
        <input class="auth-input" id="email" name="email" type="email"
               autocomplete="email" maxlength="100" placeholder="用于接收 6 位验证码" required>

        <label class="auth-label" for="verifyCode">邮箱验证码</label>
        <div class="auth-code-row">
          <input class="auth-input auth-input--code" id="verifyCode" name="verifyCode" type="text"
                 inputmode="numeric" maxlength="6" placeholder="请输入 6 位验证码" required>
          <button class="auth-code-btn" type="button" id="sendCodeBtn">获取验证码</button>
        </div>

        <p class="auth-error" id="registerError" hidden></p>

        <button class="auth-btn" type="submit" id="registerSubmit">注 册</button>
      </form>
      <p class="auth-link">
        已有账号？<a href="${ctx}/login">去登录 →</a>
      </p>
      <p class="auth-hint">提示：先获取邮箱验证码，校验通过后再完成注册。</p>
    </div>
  </main>
  <div class="toast" id="mallToast" hidden></div>
  <script>
    window.MALL_CTX = '${ctx}';
  </script>
  <script src="${ctx}/js/mall.js"></script>
</body>
</html>
