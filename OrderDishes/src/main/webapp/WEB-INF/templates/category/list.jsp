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
	商品类目页面
	<div class="container-fluid">
		<div class="row clearfix">
			<c:import url="../common/nav.jsp"></c:import>
			<div class="col-md-9 column">
				<table class="table table-striped">
					<thead>
						<tr>
							<th>类目id</th>
							<th>名称</th>
							<th>type</th>
							<th>创建时间</th>
							<th>修改时间</th>
							<th>操作</th>
						</tr>
					</thead>
					<tbody id="tbody1">
						<c:forEach items="${productCategoryList}" var="productCategory">
							<tr>
								<td><c:out value="${productCategory.categoryId}" /></td>
								<td><c:out value="${productCategory.categoryName}" /></td>
								<td><c:out value="${productCategory.categoryType}" /></td>
								<td><c:out value="${productCategory.createTime}" /></td>
								<td><c:out value="${productCategory.updateTime}" /></td>
								<td><a
									href="index?categoryId=${productCategory.categoryId}">修改</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</body>
</html>