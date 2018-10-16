<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link
	href="https://cdn.bootcss.com/bootstrap/3.0.1/css/bootstrap.min.css"
	rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>取消错误</title>
</head>
<body>

	<div class="container">
		<div class="row clearfix">
			<div class="col-md-12 column">
				<div class="alert alert-dismissable alert-danger">
					<button type="button" class="close" data-dismiss="alert"
						aria-hidden="true">×</button>
					<h4>错误!</h4>
					<strong>注意!</strong> ${msg} <a href="${url}" class="alert-link">3s后自动返回</a>
				</div>
			</div>
		</div>
	</div>
</body>
<script>
	//setTimeout('location.href="${url}"', 3000);
</script>
</html>