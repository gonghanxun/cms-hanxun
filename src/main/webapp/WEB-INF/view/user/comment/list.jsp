<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
        
        	<c:forEach items="${list}" var="domain">
        		<tr>
        			<td>${domain.id}</td>
        			<td>${domain.text}</td>
        			<td>${domain.url}</td>
        			<td>${domain.user_id}</td>
        			<td><fmt:formatDate value="${domain.created}2020年02月13日" pattern="yyyy年MM月dd日"/></td>
        		</tr>
        	</c:forEach>
        	
        	<tr>
        		<td>1</td>
        		<td>de</td>
        		<td>www.huge.com</td>
        		<td>2</td>
        		<td>2020年02月13日</td>
        	</tr>
        	
        	<tr>
        		<td>2</td>
        		<td>wu</td>
        		<td>www.wuwu.com</td>
        		<td>4</td>
        		<td>2019年02月13日</td>
        	</tr>
        	<tr>
        		<td>3</td>
        		<td>啦啦啦</td>
        		<td>www.lalala.com</td>
        		<td>6</td>
        		<td>2006年02月13日</td>
        	</tr>
        	<tr>
        		<td>4</td>
        		<td>哈哈吧</td>
        		<td>www.hahaba.com</td>
        		<td>9</td>
        		<td>2010年02月13日</td>
        	</tr>
        	<tr>
        		<td>5</td>
        		<td>wu</td>
        		<td>www.wuwu.com</td>
        		<td>4</td>
        		<td>2019年02月13日</td>
        	</tr>
        	<tr>
        		<td>6</td>
        		<td>wu</td>
        		<td>www.wuwu.com</td>
        		<td>4</td>
        		<td>2019年02月13日</td>
        	</tr>
        	<tr>
        		<td>7</td>
        		<td>wu</td>
        		<td>www.wuwu.com</td>
        		<td>4</td>
        		<td>2019年02月13日</td>
        	</tr>
        	<tr>
        		<td>8</td>
        		<td>wu</td>
        		<td>www.wuwu.com</td>
        		<td>4</td>
        		<td>2019年02月13日</td>
        	</tr>
        	<tr>
        		<td>9</td>
        		<td>wu</td>
        		<td>www.wuwu.com</td>
        		<td>4</td>
        		<td>2019年02月13日</td>
        	</tr>
        	<tr>
        		<td>10</td>
        		<td>wu</td>
        		<td>www.wuwu.com</td>
        		<td>4</td>
        		<td>2019年02月13日</td>
        	</tr>
      </table>
</body>
</html>