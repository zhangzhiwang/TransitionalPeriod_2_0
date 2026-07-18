<%--
  公共顶栏：平铺五项 + 「更多」折叠五项；移动端抽屉。
  （由 Curosr 自动生成）
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<header class="site-header">
  <div class="site-header__inner">
    <a class="brand" href="${ctx}/home">
      <span class="brand__dot" aria-hidden="true"></span>
      <span>曜岩智造</span>
    </a>

    <ul class="nav-main">
      <li><a class="${currentNav == 'home' ? 'is-active' : ''}" href="${ctx}/home">首页</a></li>
      <li><a class="${currentNav == 'about' ? 'is-active' : ''}" href="${ctx}/about.jsp">关于我们</a></li>
      <li><a class="${currentNav == 'products' ? 'is-active' : ''}" href="${ctx}/products.jsp">产品中心</a></li>
      <li><a class="${currentNav == 'news' ? 'is-active' : ''}" href="${ctx}/news.jsp">新闻中心</a></li>
      <li><a class="${currentNav == 'contact' ? 'is-active' : ''}" href="${ctx}/contact.jsp">联系我们</a></li>
    </ul>

    <div class="nav-more">
      <button type="button" class="nav-more__btn" aria-haspopup="true">更多 ▾</button>
      <ul class="nav-more__menu">
        <li><a href="${ctx}/join.jsp">加入我们</a></li>
        <li><a href="${ctx}/links.jsp">友情链接</a></li>
        <li><a href="${ctx}/sitemap.jsp">网站地图</a></li>
        <li><a href="${ctx}/stats.jsp">网站统计</a></li>
        <li><a href="${ctx}/messages.jsp">网站留言</a></li>
      </ul>
    </div>

    <button type="button" class="nav-toggle" aria-label="打开菜单">☰</button>
  </div>

  <nav class="nav-drawer" aria-label="移动端导航">
    <a href="${ctx}/home">首页</a>
    <a href="${ctx}/about.jsp">关于我们</a>
    <a href="${ctx}/products.jsp">产品中心</a>
    <a href="${ctx}/news.jsp">新闻中心</a>
    <a href="${ctx}/contact.jsp">联系我们</a>
    <a href="${ctx}/join.jsp">加入我们</a>
    <a href="${ctx}/links.jsp">友情链接</a>
    <a href="${ctx}/sitemap.jsp">网站地图</a>
    <a href="${ctx}/stats.jsp">网站统计</a>
    <a href="${ctx}/messages.jsp">网站留言</a>
  </nav>
</header>
