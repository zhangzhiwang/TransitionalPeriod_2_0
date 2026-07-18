<%--
  根路径备用入口：跳转到 Spring 首页控制器，避免误用其它 index.jsp。
  （由 Curosr 自动生成）
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    response.sendRedirect(request.getContextPath() + "/home");
%>
