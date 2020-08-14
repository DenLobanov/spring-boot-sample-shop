<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"
		 isELIgnored="false"
%>


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
			<ul id="currentShoppingCart" class="nav navbar-nav navbar-right hidden">
				<li class="dropdown">
					<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">
						Корзина (<span class="total-count">0</span>)
						<span class="caret"></span></a>
					<div class="dropdown-menu">
						<div class="shopping-cart-desc">
							Количество: <span class="total-count">0</span><br>
							Сумма: <span class="total-count">0</span><br>
							<a href="/shopping-cart" class="btn btn-success btn-block">Покупки</a>
						</div>
					</div>
				</li>
			</ul>
			<a href="#" class="btn btn-light navbar-btn navbar-right">Войти</a>
		</div>
	</div>
</nav>