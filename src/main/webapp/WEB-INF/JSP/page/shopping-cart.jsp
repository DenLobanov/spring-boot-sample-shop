<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="shop" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div id="shoppingCart">
	<div class="alert alert-warning" role="alert">Для оформления заказа, необходимо авторизоваться</div>
	<table class="table table-bordered">
		<thead>
		<tr>
			<th>Продукт</th>
			<th>Цена</th>
			<th>Количество</th>
			<th>Изменение корзины</th>
		</tr>
		</thead>
		<tbody>
		<c:forEach var="item" items="${CURRENT_SHOPPING_CART.items }">
			<tr id="product${item.product.id }" class="item">
				<td class="text-center"><img class="small" src="${item.product.imageLink}" alt="${item.product.name}"><br>${item.product.name}</td>
				<td class="price">$ ${item.product.price }</td>
				<td class="count">${item.count}</td>
				<td class="hidden-print">
					<a class="btn btn-danger remove-product" data-id-product="${item.product.id }" data-count="1">Удалить</a>
				</td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="2" class="text-right"><strong>Total:</strong></td>
			<td colspan="2" class="total">$ ${CURRENT_SHOPPING_CART.totalCost}</td>
		</tr>
		</tbody>
	</table>
	<div class="row">
		<div>
			<a class="btn btn-light btn-block">Заказ</a>
		</div>
	</div>
</div>