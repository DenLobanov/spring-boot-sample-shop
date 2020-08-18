<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="shop" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<h4 class="text-center">Мои заказы</h4>
<hr />
<table id="myOrders" class="table table-bordered" data-page-number="1" data-page-count="${pageCount }">
    <thead>
    <tr>
        <th>Order id</th>
        <th>Date</th>
    </tr>
    </thead>
    <tbody>
    <c:if test="${empty orders }">
        <tr>
            <td colspan="2" class="text-center">Не найдено</td>
        </tr>
    </c:if>
    <jsp:include page="../fragment/my-orders-tbody.jsp" />
    </tbody>
</table>
<div class="text-center hidden-print">
    <c:if test="${pageCount > 1 }">
        <a id="loadMoreMyOrders" class="btn btn-success">Загрузить больше заказов</a>
    </c:if>
</div>