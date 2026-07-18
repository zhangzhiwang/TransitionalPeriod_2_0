<%--
  底部导航：首页 / 分类 / 购物车 / 我的。
  依赖 request 属性 currentTab（home|category|cart|me）。
  （由 Curosr 自动生成）
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<nav class="tabbar" aria-label="主导航">
  <a class="tabbar__item ${currentTab == 'home' ? 'is-active' : ''}" href="${ctx}/home">
    <span class="tabbar__icon tabbar__icon--home" aria-hidden="true"></span>
    <span class="tabbar__text">首页</span>
  </a>
  <a class="tabbar__item ${currentTab == 'category' ? 'is-active' : ''}" href="${ctx}/category">
    <span class="tabbar__icon tabbar__icon--category" aria-hidden="true"></span>
    <span class="tabbar__text">分类</span>
  </a>
  <a class="tabbar__item ${currentTab == 'cart' ? 'is-active' : ''}" href="${ctx}/cart">
    <span class="tabbar__icon tabbar__icon--cart" aria-hidden="true"></span>
    <span class="tabbar__text">购物车</span>
  </a>
  <a class="tabbar__item ${currentTab == 'me' ? 'is-active' : ''}" href="${ctx}/me">
    <span class="tabbar__icon tabbar__icon--me" aria-hidden="true"></span>
    <span class="tabbar__text">我的</span>
  </a>
</nav>
