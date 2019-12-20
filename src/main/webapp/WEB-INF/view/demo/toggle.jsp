<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="/resource/bootstrap-4.3.1/css/bootstrap.css" rel="stylesheet">
<script type="text/javascript" src="/resource/js/jquery-3.2.1/jquery.js" ></script>
<script type="text/javascript" src="/resource/bootstrap-4.3.1/js/bootstrap.js"></script>
<script type="text/javascript" src="/resource/js/jqueryvalidate/jquery.validate.js"></script>
<script type="text/javascript" src="/resource/js/jqueryvalidate/localization/messages_zh.js"></script>
<link href="https://cdn.jsdelivr.net/gh/gitbrent/bootstrap4-toggle@3.6.1/css/bootstrap4-toggle.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/gh/gitbrent/bootstrap4-toggle@3.6.1/js/bootstrap4-toggle.min.js"></script>
<title>toggle</title>
</head>
<body>
	<div>
		<input id="test" type="checkbox" checked data-toggle="toggle" data-onstyle="primary">
		<input type="checkbox" data-toggle="toggle" data-onstyle="primary">
		<input type="checkbox" checked data-toggle="toggle" data-onstyle="secondary">
		
		<input type="checkbox" checked data-toggle="toggle" data-onstyle="primary" data-offstyle="secondary">
<input type="checkbox" checked data-toggle="toggle" data-onstyle="secondary" data-offstyle="success">
<input type="checkbox" checked data-toggle="toggle" data-onstyle="success" data-offstyle="danger">
<input type="checkbox" checked data-toggle="toggle" data-onstyle="danger" data-offstyle="warning">
<input type="checkbox" checked data-toggle="toggle" data-onstyle="warning" data-offstyle="info">
<input type="checkbox" checked data-toggle="toggle" data-onstyle="info" data-offstyle="light">
<input type="checkbox" checked data-toggle="toggle" data-onstyle="light" data-offstyle="dark" data-style="border">
<input type="checkbox" checked data-toggle="toggle" data-onstyle="dark" data-offstyle="light" data-style="border">

	</div>
	<script type="text/javascript">
	 	$('[type=checkbox]').change(function() {
	 		alert($(this).prop('checked'))
	        // $('#console-event').html('Toggle: ' + $(this).prop('checked'))
	    })
	    
		/*  $("[type=checkbox]").click(function(){
			console.log($(this.prop('checked')))
			 //$(this).prop("checked",!$(this).prop("checked"))
		})  */
	</script>

</body>
</html>