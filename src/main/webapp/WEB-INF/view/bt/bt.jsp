<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="/resource/bootstrap-4.3.1/css/bootstrap.css" rel="stylesheet">
<script type="text/javascript" src="/resource/bootstrap-4.3.1/js/bootstrap.js"></script>
<title>Insert title here</title>
</head>
<style>
	div {
		border:solid 1px 
	}
</style>

<body>
	<nav class="nav justify-content-end">
	  <a class="nav-link active" href="#">Active</a>
	  <a class="nav-link" href="#">Link</a>
	  <a class="nav-link" href="#">Link</a>
	  <a class="nav-link disabled" href="#" tabindex="-1" aria-disabled="true">Disabled</a>
	</nav>
	
	<div class="container">
		<div class="row">
			<div class="col-md-3" >1</div>
			<div class="col-md-2">2</div>
			<div class="col-md-4">3</div>
		</div>
		<div class="row">
			<div class="col-md-7">4</div>
			<div class="col-md-1">5</div>
			<div class="col-md-4">6</div>
		</div>
		<div class="row">
			<div class="col-md-6">7</div>
			<div class="col-md-5">8</div>
			<div class="col-md-1">9</div>
		</div>
	</div>

<div class="container-fluid">
	<h1>这是个人主页1</h1>
	<h2>这是个人主页2</h2>
	<h3>这是个人主页3</h3>
	<h4>这是个人主页4</h4>
	<div>
		<ul> <!-- unsorted list -->
			<li>这是一个无序列表1</li>
			<li>这是一个无序列表2</li>
			<li>这是一个无序列表3</li>
			<li>这是一个无序列表4</li>
		</ul>
	</div>
	
	<div>
		<ol> <!-- unsorted list -->
			<li>这是一个无序列表1</li>
			<li>这是一个无序列表2</li>
			<li>这是一个无序列表3</li>
			<li>
				<ul>
					<li>这是一个无序列表2</li>
					<li>这是一个无序列表3</li>
				</ul>
			</li>
		</ol>
	</div>
	
	<table class="table table-dark">
	<thead>
    	<tr>
      	<th scope="col">#</th>
      	<th scope="col">First</th>
    	</tr>
  	</thead>
  	
		<tr>
			<td>1</td>
			<td>2</td>
			</tr>
		<tr>
			<td>3</td>
			<td>4</td>
		</tr>
	</table>
	
	<div>
		<form action="" class="form">
			<input type="text"><input>
		</form>
	</div>
	
	<p class="lead">
  Vivamus sagittis lacus vel augue laoreet rutrum faucibus dolor auctor. Duis mollis, est non commodo luctus.
</p>
	</div>
</body>
</html>