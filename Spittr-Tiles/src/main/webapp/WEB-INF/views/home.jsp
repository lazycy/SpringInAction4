<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ page session="false" %>
    <h1><s:message code="spittr.welcome" /></h1>

    <a href="<s:url value="/spittles" />">Spittles</a> | 
    <a href="<s:url value="/spitter/register" />">Register</a>
