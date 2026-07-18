<%--
  联系我们占位页，待后续按设计图实现。
  （由 Curosr 自动生成）
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<c:set var="currentNav" value="contact" scope="request"/>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>联系我们 · 曜岩智造</title>
  <link rel="stylesheet" href="${ctx}/css/site.css">
</head>
<body>
  <jsp:include page="/WEB-INF/jsp/header.jsp"/>
  <main class="placeholder-page">
    <h1>联系我们</h1>
    <p>页面开发中，敬请期待。</p>
    <p><a class="btn btn--primary" href="${ctx}/home">返回首页</a></p>
  </main>
  <jsp:include page="/WEB-INF/jsp/footer.jsp"/>
  <script src="${ctx}/js/site.js"></script>
</body>
</html>
