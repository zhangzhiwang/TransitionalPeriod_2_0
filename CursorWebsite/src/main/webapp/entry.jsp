<%--
  根路径入口：重定向到 HomePageServlet，保证首页数据被加载。
  （由 Curosr 自动生成）
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    response.sendRedirect(request.getContextPath() + "/home");
%>
