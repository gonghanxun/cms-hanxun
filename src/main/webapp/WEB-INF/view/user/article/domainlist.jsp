<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<table class="table">
		<!-- articlePage -->
	
	  <thead>
          <tr>
            <th>主键</th>
            <th>收藏夹文本</th>
            <th>收藏夹地址</th>
            <th>所属用户</th>
            <th>添加时间</th>
          </tr>
        </thead>
        <tbody>
        	<c:forEach items="${list}" var="domain">
        		<tr>
        			<td>${domain.id}</td>
        			<td>${domain.text}</td>
        			<td>${domain.url}</td>
        			<td>${domain.user_id}</td>
        			<td><fmt:formatDate value="${domain.created}" pattern="yyyy年MM月dd日"/></td>
        		</tr>
        	</c:forEach>
        </tbody>
      </table>
</body>
</html>