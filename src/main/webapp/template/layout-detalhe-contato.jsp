<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html:html>
<head>
    <title>
        <bean:message key="label.title.aplicacao"/>
    </title>
    <tiles:useAttribute name="styleSheets" id="listaCss" classname="java.util.List" />
    <c:forEach var="css" items="${listaCss}">
        <link rel="stylesheet" type="text/css" media="all" href="${pageContext.request.contextPath}<c:out value='${css}'/>">
    </c:forEach>
</head>
<body>
<div>
<tiles:insert attribute="header"/>
<tiles:insert attribute="body-1"/>
<tiles:insert attribute="body-2"/>
<tiles:insert attribute="footer"/>
</div>
<tiles:useAttribute name="javaScripts" id="listaScript" classname="java.util.List" />
<c:forEach var="script" items="${listaScript}">
    <script src="${pageContext.request.contextPath}<c:out value='${script}'/>"></script>
</c:forEach>
</body>

</html:html>