<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"
		 isELIgnored="false"
%>

<%@ taglib prefix="shop" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div class="row">
	<div class="col-xs-12 col-sm-6 col-md-4 col-lg-3">
		<!--PRODUCT DATA-->
		<div id="product1" class="panel panel-default product">
			<div class="panel-body">
				<div class="thumbnail">
					<img src="/media/абрикос.jpg" alt="Абрикос">
					<div class="desc">
						<div class="cell">
							<p><span class="title">О товаре</span>Срок годности: 10 сут. /Условия хранения: хранить в холодильнике/ Абрикосы 300 г</p>
						</div>
					</div>
				</div>
				<h4 class="name">Абрикосы</h4>
				<div class="price">79 руб.</div>
				<a class="btn btn-success buy-btn" data-id-product="1">Добавить в корзину</a>
				<ul class="list-group">
					<li class="list-group-item"><small>Категория: </small><span class="category">Фрукты</span></li>
					<li class="list-group-item"><small>Cтрана производитель: </small><span class="producer">Турция</span></li>
				</ul>
			</div>
		</div>
	</div>
	<div class="col-xs-12 col-sm-6 col-md-4 col-lg-3">
		<!--PRODUCT DATA-->
		<div id="product2" class="panel panel-default product">
			<div class="panel-body">
				<div class="thumbnail">
					<img src="/media/авокадо.jpg" alt="Авокадо">
					<div class="desc">
						<div class="cell">
							<p><span class="title">О товаре</span>Срок годности: 150 сут. /Условия хранения: хранить в холодильнике/ Авокадо 1 шт.</p>
						</div>
					</div>
				</div>
				<h4 class="name">Авокадо</h4>
				<div class="price">147 руб.</div>
				<a class="btn btn-success buy-btn" data-id-product="2">Добавить в корзину</a>
				<ul class="list-group">
					<li class="list-group-item"><small>Категория: </small><span class="category">Фрукты</span></li>
					<li class="list-group-item"><small>Cтрана производитель: </small><span class="producer">Перу </span></li>
				</ul>
			</div>
		</div>
	</div>
	<div class="col-xs-12 col-sm-6 col-md-4 col-lg-3">
		<!--PRODUCT DATA-->
		<div id="product3" class="panel panel-default product">
			<div class="panel-body">
				<div class="thumbnail">
					<img src="/media/ананас.jpg" alt="Ананас">
					<div class="desc">
						<div class="cell">
							<p><span class="title">О товаре</span>Срок годности: 21 сут. /Условия хранения: хранить в холодильнике/ Ананас 1 шт.</p>
						</div>
					</div>
				</div>
				<h4 class="name">Ананас</h4>
				<div class="price">475 руб.</div>
				<a class="btn btn-success buy-btn" data-id-product="3">Добавить в корзину</a>
				<ul class="list-group">
					<li class="list-group-item"><small>Категория: </small><span class="category">Фрукты</span></li>
					<li class="list-group-item"><small>Cтрана производитель: </small><span class="producer">Коста-Рика</span></li>
				</ul>
			</div>
		</div>
	</div>
	<div class="col-xs-12 col-sm-6 col-md-4 col-lg-3">
		<!--PRODUCT DATA-->
		<div id="product4" class="panel panel-default product">
			<div class="panel-body">
				<div class="thumbnail">
					<img src="/media/арбуз.jpg" alt="Арбуз">
					<div class="desc">
						<div class="cell">
							<p><span class="title">О товаре</span>Срок годности: 21 сут. /Условия хранения: хранить в холодильнике/ Арбуз 1 шт. Россия</p>
						</div>
					</div>
				</div>
				<h4 class="name">Арбуз</h4>
				<div class="price">264 руб.</div>
				<a class="btn btn-success buy-btn" data-id-product="4">Добавить в корзину</a>
				<ul class="list-group">
					<li class="list-group-item"><small>Категория: </small><span class="category">Фрукты</span></li>
					<li class="list-group-item"><small>Cтрана производитель: </small><span class="producer">Россия</span></li>
				</ul>
			</div>
		</div>
	</div>
	<div class="col-xs-12 col-sm-6 col-md-4 col-lg-3">
		<!--PRODUCT DATA-->
		<div id="product5" class="panel panel-default product">
			<div class="panel-body">
				<div class="thumbnail">
					<img src="/media/белый-виног.jpg" alt="Белый Виноград">
					<div class="desc">
						<div class="cell">
							<p><span class="title">О товаре</span>Срок годности: 21 сут. /Условия хранения: хранить в холодильнике/ Белый виноград 1 кг Чили</p>
						</div>
					</div>
				</div>
				<h4 class="name">Белый виноград</h4>
				<div class="price">298 руб.</div>
				<a class="btn btn-success buy-btn" data-id-product="5">Добавить в корзину</a>
				<ul class="list-group">
					<li class="list-group-item"><small>Категория: </small><span class="category">Фрукты</span></li>
					<li class="list-group-item"><small>Cтрана производитель: </small><span class="producer">Чили</span></li>
				</ul>
			</div>
		</div>
	</div>
	<div class="col-xs-12 col-sm-6 col-md-4 col-lg-3">
		<!--PRODUCT DATA-->
		<div id="product6" class="panel panel-default product">
			<div class="panel-body">
				<div class="thumbnail">
					<img src="/media/виноград.jpg" alt="Виноград">
					<div class="desc">
						<div class="cell">
							<p><span class="title">О товаре</span>Срок годности: 21 сут. /Условия хранения: хранить в холодильнике/ Черный виноград 1 кг Узбекистан</p>
						</div>
					</div>
				</div>
				<h4 class="name">Черный виноград</h4>
				<div class="price">326 руб.</div>
				<a class="btn btn-success buy-btn" data-id-product="6">Добавить в корзину</a>
				<ul class="list-group">
					<li class="list-group-item"><small>Категория: </small><span class="category">Фрукты</span></li>
					<li class="list-group-item"><small>Cтрана производитель: </small><span class="producer">Узбекистан</span></li>
				</ul>
			</div>
		</div>
	</div>
	<div class="col-xs-12 col-sm-6 col-md-4 col-lg-3">
		<!--PRODUCT DATA-->
		<div id="product7" class="panel panel-default product">
			<div class="panel-body">
				<div class="thumbnail">
					<img src="/media/гранат.jpg" alt="Гранат">
					<div class="desc">
						<div class="cell">
							<p><span class="title">О товаре</span>Срок годности: 15 сут. /Условия хранения: хранить в холодильнике/ Гранат 1 кг. Турция</p>
						</div>
					</div>
				</div>
				<h4 class="name">Гранат</h4>
				<div class="price">415 руб.</div>
				<a class="btn btn-success buy-btn" data-id-product="7">Добавить в корзину</a>
				<ul class="list-group">
					<li class="list-group-item"><small>Категория: </small><span class="category">Фрукты</span></li>
					<li class="list-group-item"><small>Cтрана производитель: </small><span class="producer">Турця</span></li>
				</ul>
			</div>
		</div>
	</div>
	<div class="col-xs-12 col-sm-6 col-md-4 col-lg-3">
		<!--PRODUCT DATA-->
		<div id="product8" class="panel panel-default product">
			<div class="panel-body">
				<div class="thumbnail">
					<img src="/media/груши.jpg" alt="Груши">
					<div class="desc">
						<div class="cell">
							<p><span class="title">О товаре</span>Срок годности: 30 сут. /Условия хранения: хранить в холодильнике/ Груши 1 кг. Аргентина</p>
						</div>
					</div>
				</div>
				<h4 class="name">Груши Вильямс</h4>
				<div class="price">198 руб.</div>
				<a class="btn btn-success buy-btn" data-id-product="8">Добавить в корзину</a>
				<ul class="list-group">
					<li class="list-group-item"><small>Категория: </small><span class="category">Фрукты</span></li>
					<li class="list-group-item"><small>Cтрана производитель: </small><span class="producer">Аргентина</span></li>
				</ul>
			</div>
		</div>
	</div>
	<div class="col-xs-12 col-sm-6 col-md-4 col-lg-3">
		<!--PRODUCT DATA-->
		<div id="product9" class="panel panel-default product">
			<div class="panel-body">
				<div class="thumbnail">
					<img src="/media/клубника.jpg" alt="Клубника">
					<div class="desc">
						<div class="cell">
							<p><span class="title">О товаре</span>Срок годности: 8 сут. /Условия хранения: хранить в холодильнике/ Клубника 500 г Россия</p>
						</div>
					</div>
				</div>
				<h4 class="name">Клубника свежая</h4>
				<div class="price">398 руб.</div>
				<a class="btn btn-success buy-btn" data-id-product="9">Добавить в корзину</a>
				<ul class="list-group">
					<li class="list-group-item"><small>Категория: </small><span class="category">Фрукты</span></li>
					<li class="list-group-item"><small>Cтрана производитель: </small><span class="producer">Россия</span></li>
				</ul>
			</div>
		</div>
	</div>
	<div class="col-xs-12 col-sm-6 col-md-4 col-lg-3">
		<!--PRODUCT DATA-->
		<div id="product10" class="panel panel-default product">
			<div class="panel-body">
				<div class="thumbnail">
					<img src="/media/лимон.jpg" alt="Лимон">
					<div class="desc">
						<div class="cell">
							<p><span class="title">О товаре</span>Срок годности: 10 сут. /Условия хранения: хранить в холодильнике/ Лимон 1 шт. Аргентина</p>
						</div>
					</div>
				</div>
				<h4 class="name">Лимон</h4>
				<div class="price">32 руб.</div>
				<a class="btn btn-success buy-btn" data-id-product="10">Добавить в корзину</a>
				<ul class="list-group">
					<li class="list-group-item"><small>Категория: </small><span class="category">Фрукты</span></li>
					<li class="list-group-item"><small>Cтрана производитель: </small><span class="producer">Аргентина</span></li>
				</ul>
			</div>
		</div>
	</div>
	<div class="col-xs-12 col-sm-6 col-md-4 col-lg-3">
		<!--PRODUCT DATA-->
		<div id="product111" class="panel panel-default product">
			<div class="panel-body">
				<div class="thumbnail">
					<img src="/media/черника.jpg" alt="Черника">
					<div class="desc">
						<div class="cell">
							<p><span class="title">О товаре</span>Срок годности: 10 сут. /Условия хранения: хранить в холодильнике/ Рекомендации по приготовлению:  Голубика 510 г Аргентина</p>
						</div>
					</div>
				</div>
				<h4 class="name">Черника</h4>
				<div class="price">498 руб.</div>
				<a class="btn btn-success buy-btn" data-id-product="11">Добавить в корзину</a>
				<ul class="list-group">
					<li class="list-group-item"><small>Категория: </small><span class="category">Фрукты</span></li>
					<li class="list-group-item"><small>Cтрана производитель: </small><span class="producer">Россия</span></li>
				</ul>
			</div>
		</div>
	</div>
	<div class="col-xs-12 col-sm-6 col-md-4 col-lg-3">
		<!--PRODUCT DATA-->
		<div id="product12" class="panel panel-default product">
			<div class="panel-body">
				<div class="thumbnail">
					<img src="/media/яблоко.jpg" alt="Яблоко">
					<div class="desc">
						<div class="cell">
							<p><span class="title">О товаре</span>Срок годности: 10 сут. /Условия хранения: хранить в холодильнике/ Яблоки «Фуджи» 1 кг. Республика Сербия</p>
						</div>
					</div>
				</div>
				<h4 class="name">Яблоки «Фуджи»</h4>
				<div class="price">268 руб.</div>
				<a class="btn btn-success buy-btn" data-id-product="12">Добавить в корзину</a>
				<ul class="list-group">
					<li class="list-group-item"><small>Категория: </small><span class="category">Фрукты</span></li>
					<li class="list-group-item"><small>Cтрана производитель: </small><span class="producer">Сербия</span></li>
				</ul>
			</div>
		</div>
	</div>
</div>
