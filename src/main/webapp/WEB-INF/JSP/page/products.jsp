<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"
		 isELIgnored="false"
%>

<%@ taglib prefix="shop" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<div id="productList" data-page-count="${pageCount}" data-page-number="1">
	<div class="row">
		<jsp:include page="../fragment/product-list.jsp" />
	</div>
	<c:if test="${pageCount > 1 }">
		<div class="text-center hidden-print">
			<a id="loadMore" class="btn btn-success">Показать больше</a>
		</div>
	</c:if>
</div>
<shop:add-product-popup />