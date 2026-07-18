<%--
  新闻详情页：标题元信息、封面、正文、相关阅读。
  数据由 NewsPageFilter（直访本页）或 NewsController（/news/detail 转发）注入 detailPage。
  （由 Curosr 自动生成）
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<c:set var="article" value="${detailPage.article}"/>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>${fn:escapeXml(article.title)} · 新闻中心 · 曜岩智造</title>
  <meta name="description" content="${fn:escapeXml(article.summary)}">
  <link rel="stylesheet" href="${ctx}/css/site.css">
</head>
<body>
  <jsp:include page="/WEB-INF/jsp/header.jsp"/>

  <main class="news-article">
    <header class="news-article__header">
      <p class="news-article__category">${fn:escapeXml(article.category)}</p>
      <h1 class="news-article__title">${fn:escapeXml(article.title)}</h1>
      <p class="news-article__meta">
        <time datetime="${article.publishDate}">${article.publishDate}</time>
        <c:if test="${not empty article.author}"> · ${fn:escapeXml(article.author)}</c:if>
        <c:if test="${not empty article.viewCount}"> · 阅读 ${article.viewCount}</c:if>
      </p>
    </header>

    <c:if test="${not empty article.coverUrl}">
      <figure class="news-article__cover">
        <img src="${article.coverUrl}" alt="${fn:escapeXml(article.title)}">
      </figure>
    </c:if>

    <article class="news-article__body">
      ${article.content}
    </article>

    <div class="news-article__actions">
      <a class="news-article__back" href="${ctx}/news.jsp">‹ 返回列表</a>
    </div>

    <c:if test="${not empty detailPage.related}">
      <section class="news-related" aria-labelledby="related-heading">
        <h2 id="related-heading" class="news-related__title">相关阅读</h2>
        <ul class="news-related__list">
          <c:forEach var="rel" items="${detailPage.related}">
            <li>
              <a href="${ctx}/news-detail.jsp?id=${rel.id}">
                <span class="news-related__item-title">${fn:escapeXml(rel.title)}</span>
                <span class="news-related__item-meta">${rel.publishDate}</span>
              </a>
            </li>
          </c:forEach>
        </ul>
      </section>
    </c:if>
  </main>

  <jsp:include page="/WEB-INF/jsp/footer.jsp"/>
  <script src="${ctx}/js/site.js"></script>
</body>
</html>
