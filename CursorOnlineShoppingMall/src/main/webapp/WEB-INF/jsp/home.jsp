<%--
  商城首页：轮播、推荐商品、分类预览 + 底栏。
  数据由 HomeController 注入 home / currentTab。
  （由 Curosr 自动生成）
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
  <title>${home.mallName} · 首页</title>
  <link rel="stylesheet" href="${ctx}/css/mall.css">
</head>
<body class="page-home">
  <header class="mall-topbar">
    <div class="mall-topbar__inner">
      <h1 class="mall-topbar__title">${home.mallName}</h1>
      <div class="mall-topbar__search" aria-hidden="true">搜索商品</div>
    </div>
  </header>

  <main class="mall-main">
    <%-- 轮播 --%>
    <section class="banner" id="homeBanner" data-interval="4000">
      <div class="banner__track">
        <c:forEach var="b" items="${home.banners}" varStatus="st">
          <a class="banner__slide ${st.index == 0 ? 'is-active' : ''}"
             href="${ctx}${b.linkUrl}"
             data-index="${st.index}">
            <img src="${b.imageUrl}" alt="轮播 ${st.index + 1}" fetchpriority="${st.index == 0 ? 'high' : 'low'}">
          </a>
        </c:forEach>
      </div>
      <div class="banner__dots" role="tablist">
        <c:forEach var="b" items="${home.banners}" varStatus="st">
          <button type="button"
                  class="banner__dot ${st.index == 0 ? 'is-active' : ''}"
                  data-index="${st.index}"
                  aria-label="第 ${st.index + 1} 张"></button>
        </c:forEach>
      </div>
    </section>

    <%-- 推荐商品 --%>
    <section class="panel">
      <div class="panel__head">
        <h2 class="panel__title">推荐商品</h2>
      </div>
      <div class="product-grid">
        <c:forEach var="p" items="${home.recommendProducts}">
          <article class="product-card">
            <a class="product-card__media" href="${ctx}/product/${p.id}">
              <img src="${p.imageUrl}" alt="${p.name}" loading="lazy">
            </a>
            <a class="product-card__name" href="${ctx}/product/${p.id}">${p.name}</a>
            <p class="product-card__price">¥<fmt:formatNumber value="${p.price}" minFractionDigits="2" maxFractionDigits="2"/></p>
            <p class="product-card__stock">库存：${p.stock}</p>
            <button type="button"
                    class="btn-cart js-add-cart"
                    data-product-id="${p.id}"
                    data-product-name="${p.name}">加入购物车</button>
          </article>
        </c:forEach>
      </div>
    </section>

    <%-- 分类预览块 --%>
    <c:forEach var="block" items="${home.categoryBlocks}">
      <section class="panel">
        <a class="panel__head panel__head--link"
           href="${ctx}/category/${block.categoryId}/products">
          <h2 class="panel__title">${block.categoryName}</h2>
          <span class="panel__more">›</span>
        </a>
        <div class="product-grid product-grid--3">
          <c:forEach var="p" items="${block.products}">
            <article class="product-card">
              <a class="product-card__media" href="${ctx}/product/${p.id}">
                <img src="${p.imageUrl}" alt="${p.name}" loading="lazy">
              </a>
              <a class="product-card__name" href="${ctx}/product/${p.id}">${p.name}</a>
              <p class="product-card__price">¥<fmt:formatNumber value="${p.price}" minFractionDigits="2" maxFractionDigits="2"/></p>
              <p class="product-card__stock">库存：${p.stock}</p>
              <button type="button"
                      class="btn-cart js-add-cart"
                      data-product-id="${p.id}"
                      data-product-name="${p.name}">加入购物车</button>
            </article>
          </c:forEach>
        </div>
      </section>
    </c:forEach>
  </main>

  <jsp:include page="/WEB-INF/jsp/tabbar.jsp"/>
  <div class="toast" id="mallToast" hidden></div>
  <script src="${ctx}/js/mall.js"></script>
</body>
</html>
