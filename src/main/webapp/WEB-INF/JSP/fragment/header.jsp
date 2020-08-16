<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"
		 isELIgnored="false"
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<nav class="navbar navbar-default">
	<div class="container-fluid">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#ishopNav" aria-expanded="false">
				<span class="sr-only">Toggle navigation</span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="/products">Лидер вкуса</a>
		</div>
		<div class="collapse navbar-collapse" id="ishopNav">
			<ul id="currentShoppingCart" class="nav navbar-nav navbar-right">
				<li class="dropdown">
					<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">
						Корзина (<span class="total-count">${CURRENT_SHOPPING_CART.totalCount}</span>)
						<span class="caret"></span></a>
					<div class="dropdown-menu">
						<div class="shopping-cart-desc">
							Количество: <span class="total-count">${CURRENT_SHOPPING_CART.totalCount}</span><br>
							Сумма: <span class="total-count">${CURRENT_SHOPPING_CART.totalCost}</span><br>
							<a href="/shopping-cart" class="btn btn-success btn-block">Покупки</a>
						</div>
					</div>
				</li>
			</ul>
			<c:choose>
				<c:when test="${CURRENT_ACCOUNT != null }">
					<ul class="nav navbar-nav navbar-right">
						<li><a>Welcome ${CURRENT_ACCOUNT.description }</a></li>
						<li><a href="/my-orders">Мои заказы</a></li>
						<li><a href="/sign-out"><Выйти></Выйти></a></li>
					</ul>
				</c:when>
				<c:otherwise>
					<form action="/sign-in" method="post">
						<button type="submit" class="btn btn-primary navbar-btn navbar-right sign-in">
							<i class="fa fa-facebook-official" aria-hidden="true"></i> Войти
						</button>
					</form>
				</c:otherwise>
			</c:choose>
		</div>
	</div>
</nav>