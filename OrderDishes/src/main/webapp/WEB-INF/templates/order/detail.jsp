<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link
	href="https://cdn.bootcss.com/bootstrap/3.0.1/css/bootstrap.min.css"
	rel="stylesheet">
<title>订单详情</title>
</head>
<body>
	<div class="container-fluid">
		<div class="row clearfix">
			<c:import url="../common/nav.jsp"></c:import>
			<div class="col-md-4 column">
				<table class="table">
					<thead>
						<tr>
							<th>订单</th>
							<th>订单总金额</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>${orderDTO.orderId }</td>
							<td>${orderDTO.orderAmount }</td>
						</tr>
					</tbody>
				</table>
			</div>
			<div class="col-md-9 column">
				<table class="table table-hover table-striped">
					<thead>
						<tr class="success">
							<th>商品id</th>
							<th>商品名称</th>
							<th>单价</th>
							<th>数量</th>
							<th>总额</th>
						</tr>
					<tbody>
						<c:forEach items="${orderDetailList}" var="orderDetail">
							<tr class="warning">
								<td>${orderDetail.productId}</td>
								<td>${orderDetail.productName}</td>
								<td>${orderDetail.productPrice}</td>
								<td>${orderDetail.productQuantity}</td>
								<td>${orderDetail.productQuantity*orderDetail.productPrice}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
		<div class="col-md-12 column">
			<c:if test='${orderDTO.getOrderStatusEnum().statusMessage=="新订单"}'>
				<a href="finish?orderId=${orderDTO.getOrderId()}" type="button"
					class="btn btn-default btn-danger">完结订单 </a>
				<a href="cancel?orderId=${orderDTO.getOrderId()}" type="button"
					class="btn btn-default btn-primary">取消订单 </a>
			</c:if>
		</div>
	</div>
</body>
</html>