<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"
		 isELIgnored="false"
%>

<%@ taglib prefix="shop" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<div id="productList">
	<jsp:include page="../fragment/product-list.jsp" />
	<div class="text-center">
		<img id="loadMoreIndicator" src="/static/img/loading.gif" class="hidden" alt="Loading...">
		<a id="loadMore" class="btn btn-success">Показать больше</a>
	</div>
</div>
<shop:add-product-popup />