<%--
  网站首页：Hero、亮点 ×3、最新动态、底部 CTA。
  数据由 HomeController 注入 request 属性 home。
  （由 Curosr 自动生成）
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>${home.brandName} · 首页</title>
  <meta name="description" content="${home.heroSubtitle}">
  <link rel="stylesheet" href="${ctx}/css/site.css">
</head>
<body>
  <jsp:include page="/WEB-INF/jsp/header.jsp"/>

  <section class="hero">
    <p class="hero__brand">${home.brandName}</p>
    <h1 class="hero__headline">${home.heroHeadline}</h1>
    <p class="hero__subtitle">${home.heroSubtitle}</p>
    <div class="hero__actions">
      <a class="btn btn--primary" href="#feature-1">了解更多</a>
      <a class="btn btn--link" href="${ctx}/products.jsp">立即体验 ›</a>
    </div>
    <div class="hero__visual">
      <img src="${home.heroImageUrl}" alt="${home.brandName} 主视觉" fetchpriority="high">
    </div>
  </section>

  <c:forEach var="feature" items="${home.features}" varStatus="st">
    <section class="feature ${feature.dark ? 'feature--dark' : 'feature--light'}"
             id="feature-${st.index + 1}">
      <h2 class="feature__title">${feature.title}</h2>
      <p class="feature__desc">${feature.description}</p>
      <div class="feature__visual">
        <img src="${feature.imageUrl}" alt="${feature.title}" loading="lazy">
      </div>
    </section>
  </c:forEach>

  <section class="news" id="latest-news">
    <div class="news__inner">
      <div class="news__header">
        <h2 class="news__title">最新动态</h2>
        <a class="news__more" href="${ctx}/news.jsp">查看全部 ›</a>
      </div>
      <ul class="news__grid">
        <c:forEach var="item" items="${home.latestNews}">
          <li>
            <a class="news-card" href="${ctx}/news-detail.jsp?id=${item.id}">
              <img class="news-card__cover" src="${item.coverUrl}" alt="${item.title}" loading="lazy">
              <div class="news-card__body">
                <p class="news-card__meta">${item.category} · ${item.publishDate}</p>
                <h3 class="news-card__name">${item.title}</h3>
                <p class="news-card__summary">${item.summary}</p>
              </div>
            </a>
          </li>
        </c:forEach>
      </ul>
    </div>
  </section>

  <section class="cta">
    <h2 class="cta__title">准备好升级你的产线了吗？</h2>
    <div class="cta__actions">
      <a class="btn btn--primary" href="${ctx}/contact.jsp">联系我们</a>
    </div>
  </section>

  <jsp:include page="/WEB-INF/jsp/footer.jsp"/>
  <script src="${ctx}/js/site.js"></script>
</body>
</html>
