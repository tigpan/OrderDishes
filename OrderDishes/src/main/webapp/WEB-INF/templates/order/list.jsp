<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<link
	href="https://cdn.bootcss.com/bootstrap/3.0.1/css/bootstrap.min.css"
	rel="stylesheet">
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
							<th>订单id</th>
							<th>姓名</th>
							<th>手机号</th>
							<th>地址</th>
							<th>金额</th>
							<th>订单状态</th>
							<th>支付状态</th>
							<th>创建时间</th>
							<th colspan="2">操作</th>
						</tr>
					</thead>
					<tbody id="tbody1">
						<c:forEach items="${requestScope.pageInfo.getList()}"
							var="orderDTO">
							<tr>
								<td><c:out value="${orderDTO.getOrderId()}" /></td>
								<td><c:out value="${orderDTO.getBuyerName()}" /></td>
								<td><c:out value="${orderDTO.getBuyerPhone()}" /></td>
								<td><c:out value="${orderDTO.getBuyerAddress()}" /></td>
								<%-- <td><c:out value="${orderDTO.getBuyerOpenid()}" /></td> --%>
								<td><c:out value="${orderDTO.getOrderAmount()}" /></td>
								<td><c:out
										value="${orderDTO.getOrderStatusEnum().statusMessage}" /></td>
								<td><c:out
										value="${orderDTO.getPayStatusEnum().payStatusMessage}" /></td>
								<td><c:out value="${orderDTO.getCreateTime()}" /></td>
								<%-- <td><c:out value="${orderDTO.getOrderStatusEnum()}" /></td>
								<td><c:out value="${orderDTO.getPayStatusEnum()}" /></td> --%>
								<td><a href="detail?orderId=${orderDTO.getOrderId()}">详情</a></td>
								<td><c:if
										test='${orderDTO.getOrderStatusEnum().statusMessage =="新订单"}'>
										<a href="cancel?orderId=${orderDTO.getOrderId()}">取消</a>
									</c:if></td>
								<!-- //<td>orderDTO.get</td> -->
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			<ul class="pagination">
				<li><a
					href="list?pageNum= 1 &pageSize=${requestScope.pageInfo.getPageSize()}">首页</a></li>
				<li><a
					href="list?pageNum= ${requestScope.pageInfo.getPrePage()} &pageSize=${requestScope.pageInfo.getPageSize()}">上一页</a></li>
				<li><a href="" style="color: grey">${requestScope.pageInfo.getPageNum()}</a></li>
				<li><a
					href="list?pageNum= ${requestScope.pageInfo.getNextPage()} &pageSize=${requestScope.pageInfo.getPageSize()}">下一页</a></li>
			</ul>
		</div>
	</div>
	<script type="text/javascript"
		src="http://cdn.bootcss.com/jquery/3.1.0/jquery.min.js"></script>
	<script type="text/javascript"
		src="http://cdn.bootcss.com/sockjs-client/1.1.1/sockjs.js"></script>
	<script type="text/javascript">
		function WebSocketTest() {
			if ("WebSocket" in window) {
				alert("您的浏览器支持 WebSocket!");
				// 打开一个 web socket
				var ws = new WebSocket("ws://localhost:8080/OrderDishes/websocket/socketServer.do");
				ws.onopen = function() {
					console.log('建立连接');
					// Web Socket 已连接上，使用 send() 方法发送数据
					ws.send("发送数据");
				};
				ws.onmessage = function(evt) {
					var received_msg = evt.data;
					alert("数据已接收...");
				};
				ws.onclose = function() {
					// 关闭 websocket
					alert("连接已关闭...");
				};
			}
			else {
				// 浏览器不支持 WebSocket
				alert("您的浏览器不支持 WebSocket!");
			}
		}
	</script>
</body>

</html>