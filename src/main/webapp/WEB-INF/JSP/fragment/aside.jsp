<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"
		 isELIgnored="false"
%>


<div class="visible-xs-block xs-option-container">
	<a class="pull-right" data-toggle="collapse" href="#productCatalog">Product catalog <span class="caret"></span></a> 
	<a data-toggle="collapse" href="#findProducts">Find products <span class="caret"></span></a>
</div>
<!-- Search form -->
<form class="search" action="/search">
	<div id="findProducts" class="panel panel-success collapse">
		<div class= "panel-heading">Поиск товара</div>
		<div class="panel-body">
			<div class="input-group">
				<input type="text" name="query" class="form-control" placeholder="Введите название товара">
				<span class="input-group-btn">
                    <a id="goSearch" class="btn btn-default">Go!</a>
                  </span>
			</div>
			<div class="more-options">
				<a data-toggle="collapse" href="#searchOptions">Фильтр<span class="caret"></span></a>
			</div>
		</div>
		<div id="searchOptions" class="collapse">
			<div class= "panel-heading">Категория</div>
			<div class="panel-body categories">
				<label> <input type="checkbox" id="allCategories">Все</label>
				<div class="form-group">
					<div class="checkbox">
						<label><input type="checkbox" name="category" value="1" class="search-option">Бакалея (14)</label>
					</div>
				</div>
				<div class="form-group">
					<div class="checkbox">
						<label><input type="checkbox" name="category" value="2" class="search-option">Фрукты (14)</label>
					</div>
				</div>
			</div>
			<div class= "panel-heading">Страна производитель</div>
			<div class="panel-body producers">
				<label> <input type="checkbox" id="allProducers">Все</label>
				<div class="form-group">
					<div class="checkbox">
						<label><input type="checkbox" name="producer" value="1" class="search-option">Россия (14)</label>
					</div>
				</div>
				<div class="form-group">
					<div class="checkbox">
						<label><input type="checkbox" name="producer" value="2" class="search-option">Чили (14)</label>
					</div>
				</div>
			</div>
		</div>
	</div>
</form>
<!-- /Search form -->
<!-- Categories -->
<div id="productCatalog" class="panel panel-success collapse">
	<div class="panel-heading">Каталог товаров</div>
	<div class="list-group">
		<a href="/products" class="list-group-item"> <span class="badge">14</span> Бакалея
		</a> <a href="/products" class="list-group-item"> <span class="badge">14</span> Мясо
		</a> <a href="/products" class="list-group-item"> <span class="badge">14</span> Напитки
		</a> <a href="/products" class="list-group-item"> <span class="badge">14</span> Фрукты
		</a> <a href="/products" class="list-group-item"> <span class="badge">14</span> Овощи
		</a>
	</div>
</div>
<!-- /Categories -->