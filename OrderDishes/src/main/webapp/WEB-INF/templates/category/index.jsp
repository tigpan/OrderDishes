<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<link
	href="https://cdn.bootcss.com/bootstrap/3.0.1/css/bootstrap.min.css"
	rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品类目</title>
</head>
<body>
	<div class="row clearfix">
		<c:import url="../common/nav.jsp"></c:import>
		<div class="col-md-9 column">
			<form role="form" method="post"
				action="/OrderDishes/seller/category/save">
				<div class="form-group">
					<label for="exampleInputEmail1">名称</label><input name="categoryName"
						type="text" value="${(productCategory.categoryName)}"
						class="form-control" id="exampleInputEmail1" />
				</div>
				<div class="form-group">
					<label for="exampleInputEmail1">类目编号</label><input name="categoryType"
						type="text" value="${(productCategory.categoryType)}"
						class="form-control" id="exampleInputEmail1" />
				</div>
				<input hidden type="number" name="categoryType" value="2" /> <input
					hidden type="text" name="categoryId"
					value="${productCategory.categoryId}" />
				<button name="submit" type="submit" class="btn btn-default">提交</button>
			</form>
			
		</div>
	</div>
</body>
</html>
