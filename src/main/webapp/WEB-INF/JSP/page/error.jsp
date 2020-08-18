<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="alert alert-danger hidden-print" role="alert">
    <h1>Code: ${statusCode }</h1>
    <c:choose>
        <c:when test="${statusCode == 403}">You don't have permissions to view this resource</c:when>
        <c:when test="${statusCode == 404}">Requested resource not found</c:when>
        <c:otherwise>Can't process this request! Try again later...</c:otherwise>
    </c:choose>
</div>