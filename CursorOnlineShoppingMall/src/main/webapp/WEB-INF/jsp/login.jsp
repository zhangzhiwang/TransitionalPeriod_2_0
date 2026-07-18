<%--
  登录页：用户名 + 密码，AJAX 提交 /api/auth/login。
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
  <title>登录 · CursorOnlineShoppingMall</title>
  <link rel="stylesheet" href="${ctx}/css/mall.css">
</head>
<body class="page-auth">
  <main class="auth-main">
    <div class="auth-card">
      <div class="auth-brand">商城</div>
      <h1 class="auth-title">欢迎登录</h1>
      <form id="loginForm" class="auth-form" novalidate>
        <label class="auth-label" for="username">用户名</label>
        <input class="auth-input" id="username" name="username" type="text"
               autocomplete="username" maxlength="50" placeholder="请输入用户名" required>

        <label class="auth-label" for="password">密码</label>
        <input class="auth-input" id="password" name="password" type="password"
               autocomplete="current-password" maxlength="64" placeholder="请输入密码" required>

        <p class="auth-error" id="loginError" hidden></p>

        <button class="auth-btn" type="submit" id="loginSubmit">登 录</button>
      </form>
      <p class="auth-link">
        还没有账号？<a href="${ctx}/register">去注册 →</a>
      </p>
      <p class="auth-hint">演示账号：demo / 123456（需先导入 data.sql）</p>
    </div>
  </main>
  <div class="toast" id="mallToast" hidden></div>
  <script>
    window.MALL_CTX = '${ctx}';
  </script>
  <script src="${ctx}/js/mall.js"></script>
</body>
</html>
