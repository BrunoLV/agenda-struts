<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib prefix="title" uri="http://struts.apache.org/tags-tiles"%>
<!DOCTYPE html>
<html:html>
<head>
<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" 
    	  content="IE=edge">
    <meta name="viewport" 
    	  content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" 
    	  content="">
    <meta name="author" 
    	  content="">
<title>
	<bean:message key="label.title.aplicacao" />
</title>
<tiles:useAttribute name="styleSheets" 
					id="listaCss"
					classname="java.util.List" />
<c:forEach var="css" 
		   items="${listaCss}">
	<link rel="stylesheet" 
		  type="text/css" 
		  media="all"
		  href="${pageContext.request.contextPath}<c:out value='${css}'/>">
</c:forEach>
</head>
<body>
	<div class="container">
		<tiles:insert attribute="header" flush="true" />
		<tiles:insert attribute="body" flush="true" />
	</div>
	<tiles:insert attribute="footer" flush="true" />
	<tiles:useAttribute name="javaScripts" id="listaScript"
		classname="java.util.List" />
	<c:forEach var="script" items="${listaScript}">
		<script type="text/javascript"
			src="${pageContext.request.contextPath}<c:out value='${script}'/>">
		</script>
	</c:forEach>
</body>

</html:html>