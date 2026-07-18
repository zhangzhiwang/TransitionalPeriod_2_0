<%--
  通用占位页片段生成说明见各页面；本文件为关于我们占位。
  （由 Curosr 自动生成）
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<c:set var="currentNav" value="about" scope="request"/>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>关于我们 · 曜岩智造</title>
  <link rel="stylesheet" href="${ctx}/css/site.css">
</head>
<body>
  <jsp:include page="/WEB-INF/jsp/header.jsp"/>
  <main class="placeholder-page">
    <h1>关于我们</h1>
    <p>页面开发中，敬请期待。</p>
    <p><a class="btn btn--primary" href="${ctx}/home">返回首页</a></p>
  </main>
  <jsp:include page="/WEB-INF/jsp/footer.jsp"/>
  <script src="${ctx}/js/site.js"></script>
</body>
</html>
