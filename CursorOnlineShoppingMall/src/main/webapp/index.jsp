<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--
  根路径占位：转发到 Spring 首页 /home。
  （由 Curosr 自动生成）
--%>
<%
  response.sendRedirect(request.getContextPath() + "/home");
%>
