<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div>
	<html:messages id="errors">
		<c:forEach items="${errors}" var="error">
			<div class="alert alert-danger">
				<span class="glyphicon glyphicon-warning-sign"></span>
				<c:out value="${error}" escapeXml="false" />
			</div>
		</c:forEach>
	</html:messages>
	<br />
	<logic:present name="mensagem">
		<div class="alert alert-error">
			<bean:write name="mensagem" />
		</div>
	</logic:present>
</div>