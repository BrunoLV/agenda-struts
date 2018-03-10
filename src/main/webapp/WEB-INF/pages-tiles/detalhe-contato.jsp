<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<tiles:insert definition="layout-detalhe-contato">
	<tiles:put name="body-1" value="/WEB-INF/pages/detalhe-contato-body.jsp" />
	<tiles:put name="body-2" value="/WEB-INF/pages/listagem-telefones-body.jsp" />
</tiles:insert>