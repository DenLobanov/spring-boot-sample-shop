<%@ tag pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="u" uri="/WEB-INF/tags.tld"%>

<%@ attribute name="classes" required="false" type="java.lang.String"%>

<form action="/sign-in" method="post">
	<c:if test="${fn:startsWith(CURRENT_REQUEST_URL,'/search') or fn:startsWith(CURRENT_REQUEST_URL, '/products') or 
						CURRENT_REQUEST_URL == '/shopping-cart' }">
	<u:urlEncode url="${CURRENT_REQUEST_URL }" var="encodedUrl"/>
	<input type="hidden" name="target" value="${encodedUrl }">
	</c:if>
	<button type="submit" class="btn btn-primary ${classes }"><i class="fa fa-facebook-official" aria-hidden="true"></i> Войти</button>
</form>