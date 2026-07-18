<%--
  新闻中心列表页：标题区、分类 Tab、头条精选、网格列表、显示更多。
  数据由 NewsPageFilter（直访本页）或 NewsController（/news 转发）注入 newsPage。
  （由 Curosr 自动生成）
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>新闻中心 · 曜岩智造</title>
  <meta name="description" content="了解最新动态与观点">
  <link rel="stylesheet" href="${ctx}/css/site.css">
</head>
<body>
  <jsp:include page="/WEB-INF/jsp/header.jsp"/>

  <main class="news-center"
        data-ctx="${ctx}"
        data-category="${newsPage.category}"
        data-page="${newsPage.page}"
        data-size="${newsPage.size}"
        data-has-more="${newsPage.hasMore}">
    <section class="news-center__hero">
      <h1 class="news-center__title">新闻中心</h1>
      <p class="news-center__subtitle">了解最新动态与观点</p>
    </section>

    <nav class="news-tabs" aria-label="新闻分类">
      <a class="news-tabs__item ${newsPage.category == 'all' || empty newsPage.category ? 'is-active' : ''}"
         href="${ctx}/news.jsp?category=all"
         data-category="all">全部</a>
      <c:forEach var="cat" items="${newsPage.categories}">
        <a class="news-tabs__item ${newsPage.category == cat ? 'is-active' : ''}"
           href="${ctx}/news.jsp?category=${fn:escapeXml(cat)}"
           data-category="${fn:escapeXml(cat)}">${fn:escapeXml(cat)}</a>
      </c:forEach>
    </nav>

    <c:if test="${not empty newsPage.featured}">
      <article class="news-featured">
        <a class="news-featured__link" href="${ctx}/news-detail.jsp?id=${newsPage.featured.id}">
          <c:if test="${not empty newsPage.featured.coverUrl}">
            <img class="news-featured__cover"
                 src="${newsPage.featured.coverUrl}"
                 alt="${fn:escapeXml(newsPage.featured.title)}"
                 fetchpriority="high">
          </c:if>
          <div class="news-featured__body">
            <h2 class="news-featured__title">${fn:escapeXml(newsPage.featured.title)}</h2>
            <p class="news-featured__meta">
              <time datetime="${newsPage.featured.publishDate}">${newsPage.featured.publishDate}</time>
              <c:if test="${not empty newsPage.featured.category}">
                · ${fn:escapeXml(newsPage.featured.category)}
              </c:if>
            </p>
            <p class="news-featured__summary">${fn:escapeXml(newsPage.featured.summary)}</p>
            <span class="news-featured__cta">阅读全文 ›</span>
          </div>
        </a>
      </article>
    </c:if>

    <ul class="news-feed" id="news-feed">
      <c:forEach var="item" items="${newsPage.items}">
        <li class="news-feed__item">
          <a class="news-feed-card" href="${ctx}/news-detail.jsp?id=${item.id}">
            <c:if test="${not empty item.coverUrl}">
              <img class="news-feed-card__cover"
                   src="${item.coverUrl}"
                   alt="${fn:escapeXml(item.title)}"
                   loading="lazy">
            </c:if>
            <div class="news-feed-card__body">
              <h3 class="news-feed-card__title">${fn:escapeXml(item.title)}</h3>
              <p class="news-feed-card__meta">
                <time datetime="${item.publishDate}">${item.publishDate}</time>
                <c:if test="${not empty item.category}"> · ${fn:escapeXml(item.category)}</c:if>
              </p>
            </div>
          </a>
        </li>
      </c:forEach>
    </ul>

    <div class="news-center__more">
      <button type="button"
              class="news-more-btn ${newsPage.hasMore ? '' : 'is-hidden'}"
              id="news-more-btn"
              ${newsPage.hasMore ? '' : 'hidden'}>显示更多</button>
    </div>
  </main>

  <jsp:include page="/WEB-INF/jsp/footer.jsp"/>
  <script src="${ctx}/js/site.js"></script>
</body>
</html>
