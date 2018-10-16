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
<title>商品主界面</title>
</head>
<body>
	<div class="row clearfix">
		<c:import url="../common/nav.jsp"></c:import>
		<div class="col-md-9 column">
			<form role="form" method="post"
				action="/OrderDishes/seller/product/save">
				<div class="form-group">
					<label for="exampleInputEmail1">名称</label><input name="productName"
						type="text" value="${(productInfo.productName)}"
						class="form-control" id="exampleInputEmail1" />
				</div>
				<div class="form-group">
					<label for="exampleInputPassword1">价格</label><input
						name="productPrice" type="number" step="0.01"
						value="${(productInfo.productPrice)}" class="form-control" />
				</div>
				<div class="form-group">
					<label for="exampleInputPassword1">库存</label><input
						name="productStock" type="number"
						value="${(productInfo.productStock)}" class="form-control" />
				</div>
				<div class="form-group">
					<label for="exampleInputPassword1">描述</label><input
						name="productDescription" type="text"
						value="${(productInfo.productDescription)}" class="form-control" />
				</div>
				<div class="form-group">
					<label for="exampleInputPassword1">类别</label> <select>
						<c:forEach items="${productCategoryList}" var="productCategory">
							<option value="${productCategory.categoryType}"
								<c:if  test="${productInfo.categoryType==productCategory.categoryType}">
							name="categoryType" vaule="${productCategory.categoryType}" selected
							</c:if>>${productCategory.categoryName}</option>
						</c:forEach>
					</select>
					<!--  ! Failed to convert property value of type [java.lang.String] to required type [java.lang.Integer] 
					for property 'categoryType'; nested exception is java.lang.NumberFormatException: For input s-->
				</div>
				<div class="form-group">
					<label for="exampleInputFile">图片</label> <input name="productIcon"
						type="file" id="exampleInputFile" accept="image/png,image/gif" />
					<p class="help-block">选择商品图片文件</p>
				</div>
				<div class="checkbox">
					<label><input type="checkbox" />Check me out</label>
				</div>
				<input hidden type="number" name="categoryType" 
					value="2"/> <input hidden type="text"
					name="productId" value="${productInfo.productId}" />
				<button name="submit" type="submit" class="btn btn-default">提交</button>
			</form>
		</div>
	</div>
</body>
</html>
