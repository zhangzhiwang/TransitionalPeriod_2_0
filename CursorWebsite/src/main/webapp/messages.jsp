<%--
  网站留言页：左侧发表表单，右侧已审核留言列表。
  数据由 GuestbookPageFilter 或 GuestbookController 注入 guestbookPage。
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
  <title>网站留言 · 曜岩智造</title>
  <meta name="description" content="写下你的想法。请保持友善与尊重。">
  <link rel="stylesheet" href="${ctx}/css/site.css">
</head>
<body>
  <jsp:include page="/WEB-INF/jsp/header.jsp"/>

  <main class="guestbook"
        data-ctx="${ctx}"
        data-page="${guestbookPage.page}"
        data-size="${guestbookPage.size}"
        data-has-more="${guestbookPage.hasMore}">
    <section class="guestbook__hero">
      <h1 class="guestbook__title">网站留言</h1>
      <p class="guestbook__subtitle">写下你的想法。请保持友善与尊重。</p>
    </section>

    <div class="guestbook__layout">
      <section class="guestbook-form-panel" aria-labelledby="guestbook-form-heading">
        <h2 id="guestbook-form-heading" class="guestbook-panel__title">发表留言</h2>
        <form id="guestbook-form" class="guestbook-form" novalidate>
          <label class="field">
            <span class="field__label">昵称 <abbr title="必填">*</abbr></span>
            <input class="field__input" type="text" name="nickname" maxlength="50" required
                   placeholder="怎么称呼你">
          </label>
          <label class="field">
            <span class="field__label">邮箱<span class="field__hint">（可选，不公开）</span></span>
            <input class="field__input" type="email" name="email" maxlength="100"
                   placeholder="仅用于必要时联系">
          </label>
          <label class="field">
            <span class="field__label">留言内容 <abbr title="必填">*</abbr></span>
            <textarea class="field__input field__input--area" name="content" rows="6"
                      maxlength="1000" required placeholder="分享你的想法或建议"></textarea>
          </label>
          <p class="guestbook-form__note">提交后需审核，通过后才会公开展示。</p>
          <p class="guestbook-form__feedback" id="guestbook-feedback" hidden></p>
          <button type="submit" class="btn btn--primary" id="guestbook-submit">提交留言</button>
        </form>
        <p class="guestbook-form__biz">
          商务合作请前往 <a href="${ctx}/contact.jsp">联系我们</a>。
        </p>
      </section>

      <section class="guestbook-list-panel" aria-labelledby="guestbook-list-heading">
        <h2 id="guestbook-list-heading" class="guestbook-panel__title">最近留言</h2>
        <ul class="guestbook-list" id="guestbook-list">
          <c:choose>
            <c:when test="${empty guestbookPage.items}">
              <li class="guestbook-empty" id="guestbook-empty">还没有留言，来写第一条吧</li>
            </c:when>
            <c:otherwise>
              <c:forEach var="item" items="${guestbookPage.items}">
                <li class="guestbook-item">
                  <div class="guestbook-item__head">
                    <span class="guestbook-item__avatar" aria-hidden="true">${fn:substring(item.nickname, 0, 1)}</span>
                    <div class="guestbook-item__meta">
                      <span class="guestbook-item__name">${fn:escapeXml(item.nickname)}</span>
                      <time class="guestbook-item__time" datetime="${item.createdAt}">${item.createdAtText}</time>
                    </div>
                  </div>
                  <p class="guestbook-item__content">${fn:escapeXml(item.content)}</p>
                  <c:if test="${not empty item.reply}">
                    <div class="guestbook-item__reply">
                      <span class="guestbook-item__reply-tag">回复</span>
                      <p>${fn:escapeXml(item.reply)}</p>
                    </div>
                  </c:if>
                </li>
              </c:forEach>
            </c:otherwise>
          </c:choose>
        </ul>
        <div class="guestbook-list__more">
          <button type="button"
                  class="news-more-btn ${guestbookPage.hasMore ? '' : 'is-hidden'}"
                  id="guestbook-more-btn"
                  ${guestbookPage.hasMore ? '' : 'hidden'}>显示更多</button>
        </div>
      </section>
    </div>
  </main>

  <jsp:include page="/WEB-INF/jsp/footer.jsp"/>
  <script src="${ctx}/js/site.js"></script>
</body>
</html>
