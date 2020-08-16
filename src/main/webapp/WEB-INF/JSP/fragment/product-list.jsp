<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"
		 isELIgnored="false"
%>

<%@ taglib prefix="shop" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:forEach var="p" items="${products}">
	<div class="col-xs-12 col-sm-6 col-md-4 col-lg-3">
			<div id="product${p.id}" class="panel panel-default product">
				<div class="panel-body">
					<div class="thumbnail">
						<img src="${p.imageLink}" alt="${p.name}">
						<div class="desc">
							<div class="cell">
								<p><span class="title">О товаре</span>${p.description}</p>
							</div>
						</div>
					</div>
					<h4 class="name">${p.name}</h4>
					<div class="price">${p.price} руб.</div>
					<a class="btn btn-success buy-btn" data-id-product="${p.id}">Добавить в корзину</a>
					<ul class="list-group">
						<li class="list-group-item"><small>Категория: </small><span class="category">${p.category}</span></li>
						<li class="list-group-item"><small>Cтрана производитель: </small><span class="producer">${p.producer}</span></li>
					</ul>
				</div>
			</div>
	</div>
</c:forEach>

