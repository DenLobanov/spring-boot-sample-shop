<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="alert alert-info">
  <p>Найден <strong>${productCount }</strong> продукт</p>
</div>

<jsp:include page="products.jsp" />