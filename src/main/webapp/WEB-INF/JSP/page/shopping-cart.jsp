<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="shop" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div id="shoppingCart">
	<c:if test="${CURRENT_ACCOUNT == null }">
		<div class="alert alert-warning hidden-print" role="alert">Для заказ необходимо войти</div>
	</c:if>
	<shop:product-table items="${CURRENT_SHOPPING_CART.items }" totalCost="${CURRENT_SHOPPING_CART.totalCost }" showActionColumn="true" />
	<div class="row hidden-print">
		<div class="col-md-4 col-md-offset-4 col-lg-2 col-lg-offset-5">
			<c:choose>
				<c:when test="${CURRENT_ACCOUNT != null }">
					<a href="javascript:void(0);" class="post-request btn btn-primary btn-block" data-url="/order">Сделайте заказ</a>
				</c:when>
				<c:otherwise>
					<shop:sign-in classes="btn-block" />
				</c:otherwise>
			</c:choose>
		</div>
	</div>
</div>