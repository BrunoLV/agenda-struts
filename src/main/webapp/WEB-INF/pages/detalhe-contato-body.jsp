<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div>
	<div class="panel panel-default">
		<div class="panel-heading">
			<bean:message key="label.title.detalhes.contato" />
		</div>
		<div class="panel-body">
			<table class="table table-striped table-bordered table-hover table-condensed">
				<tr>
					<th><bean:message key="label.table.header.id" /></th>
					<th><bean:message key="label.table.header.nome" /></th>
				</tr>
				<tr>
					<td><c:out value="${sessionScope.contatoDetalhado.id}" /></td>
					<td><c:out value="${sessionScope.contatoDetalhado.nome}" /></td>
				</tr>
			</table>
		</div>
	</div>
</div>