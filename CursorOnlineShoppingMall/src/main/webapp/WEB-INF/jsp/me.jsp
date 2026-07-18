<%--
  「我的」页：已登录显示昵称/退出；游客显示登录+注册（需求 0.4 / 4.2）。
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
  <title>我的 · CursorOnlineShoppingMall</title>
  <link rel="stylesheet" href="${ctx}/css/mall.css">
</head>
<body class="page-me">
  <header class="me-header">
    <c:choose>
      <c:when test="${user != null && user.loggedIn}">
        <div class="me-profile">
          <c:choose>
            <c:when test="${not empty user.avatarUrl}">
              <img class="me-avatar" src="${user.avatarUrl}" alt="头像">
            </c:when>
            <c:otherwise>
              <div class="me-avatar me-avatar--default" aria-hidden="true"></div>
            </c:otherwise>
          </c:choose>
          <div class="me-profile__text">
            <div class="me-nickname" id="meNickname">
              <c:out value="${not empty user.nickname ? user.nickname : user.username}"/>
            </div>
            <div class="me-welcome">欢迎回来</div>
          </div>
        </div>
      </c:when>
      <c:otherwise>
        <div class="me-profile me-profile--guest">
          <div class="me-avatar me-avatar--default" aria-hidden="true"></div>
          <div class="me-guest-actions">
            <a class="me-btn me-btn--primary" href="${ctx}/login">登 录</a>
            <a class="me-btn me-btn--ghost" href="${ctx}/register">注 册</a>
          </div>
        </div>
      </c:otherwise>
    </c:choose>
  </header>

  <main class="mall-main me-main">
    <c:if test="${user != null && user.loggedIn}">
      <section class="me-menu">
        <a class="me-menu__item" href="${ctx}/orders">
          <span>我的订单</span>
          <span class="me-menu__arrow">›</span>
        </a>
        <a class="me-menu__item" href="${ctx}/addresses">
          <span>收货地址</span>
          <span class="me-menu__arrow">›</span>
        </a>
      </section>

      <div class="me-logout-wrap">
        <button type="button" class="me-btn me-btn--logout" id="logoutBtn">退出登录</button>
      </div>
    </c:if>
  </main>

  <jsp:include page="/WEB-INF/jsp/tabbar.jsp"/>
  <div class="toast" id="mallToast" hidden></div>
  <script>
    window.MALL_CTX = '${ctx}';
  </script>
  <script src="${ctx}/js/mall.js"></script>
</body>
</html>
