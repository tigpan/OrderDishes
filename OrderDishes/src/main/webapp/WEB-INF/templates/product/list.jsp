<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<link
	href="https://cdn.bootcss.com/bootstrap/3.0.1/css/bootstrap.min.css"
	rel="stylesheet">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>我是list.jsp</title>

</head>
<body>
	<div class="container-fluid">
		<div class="row clearfix">
			<c:import url="../common/nav.jsp"></c:import>
			<div class="col-md-9 column">
				<table class="table table-striped">
					<thead>
						<tr>
							<th>商品id</th>
							<th>名称</th>
							<th>图片</th>
							<th>单价</th>
							<th>库存</th>
							<th>描述</th>
							<th>类目</th>
							<th colspan="2">操作</th>
						</tr>
					</thead>
					<tbody id="tbody1">
						<c:forEach items="${pageInfo.getList()}" var="productInfo">
							<tr>
								<td><c:out value="${productInfo.productId}" /></td>
								<td><c:out value="${productInfo.productName}" /></td>
								<td><c:out value="${productInfo.productIcon}" /></td>
								<td><c:out value="${productInfo.productPrice}" /></td>
								<%-- <td><c:out value="${productInfo.getBuyerOpenid()}" /></td> --%>
								<td><c:out value="${productInfo.productStock}" /></td>
								<td><c:out value="${productInfo.productDescription}" /></td>
								<td><c:out value="${productInfo.categoryType}" /></td>
								<%-- <text>${productInfo.getProductStatusEnum().message}</text> --%>
								<td><a href="index?productId=${productInfo.productId}">修改</a></td>
								<td><c:choose>
										<c:when
											test="${productInfo.getProductStatusEnum().message=='在架'}">
											<a href="offSale?productId=${productInfo.productId}">下架</a>
										</c:when>
										<c:when
											test='${productInfo.getProductStatusEnum().message=="下架"}'>
											<a href="onSale?productId=${productInfo.productId}">上架</a>
										</c:when>
										<c:otherwise>
									商品状态异常									</c:otherwise>
									</c:choose></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			<ul class="pagination">
				<li><a
					href="list?pageNum= 1 &pageSize=${pageInfo.getPageSize()}">首页</a></li>
				<li><a
					href="list?pageNum= ${pageInfo.getPrePage()} &pageSize=${pageInfo.getPageSize()}">上一页</a></li>
				<li><a href="" style="color: grey">${requestScope.pageInfo.getPageNum()}</a></li>
				<li><a
					href="list?pageNum= ${pageInfo.getNextPage()} &pageSize=${pageInfo.getPageSize()}">下一页</a></li>
			</ul>
		</div>
	</div>
</body>
</html>