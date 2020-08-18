<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"
		 isELIgnored="false"
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="shop" tagdir="/WEB-INF/tags"%>


<div class="visible-xs-block xs-option-container">
	<a class="pull-right" data-toggle="collapse" href="#productCatalog">Product catalog <span class="caret"></span></a> 
	<a data-toggle="collapse" href="#findProducts">Найти продукт <span class="caret"></span></a>
</div>
<form class="search" action="/search">
	<div id="findProducts" class="panel panel-success collapse">
		<div class="panel-heading">Найти продукт</div>
		<div class="panel-body">
			<div class="input-group">
				<input type="text" name="query" class="form-control" placeholder="Search query" value="${searchForm.query }">
				<span class="input-group-btn">
					<a id="goSearch" class="btn btn-default">Найти</a>
				</span>
			</div>
			<div class="more-options">
				<a data-toggle="collapse" href="#searchOptions">Показать больше<span class="caret"></span></a>
			</div>
		</div>
		<div id="searchOptions" class="collapse ${searchForm.categoriesNotEmpty or searchForm.producersNotEmpty ? 'in' : ''}">
			<shop:category-filter categories="${CATEGORY_LIST }" searchForm="${searchForm}" />
			<shop:producer-filter producers="${PRODUCER_LIST }" searchForm="${searchForm}" />
		</div>
	</div>
</form>
<div id="productCatalog" class="panel panel-success collapse">
	<div class="panel-heading">Каталог товаров</div>
	<div class="list-group">
		<c:forEach var="category" items="${CATEGORY_LIST }">
			<a href="/products${category.url }" class="list-group-item ${selectedCategoryUrl == category.url ? 'success' : '' }">
				<span class="badge">${category.productCount}</span> ${category.name}
			</a>
		</c:forEach>
	</div>
</div>
