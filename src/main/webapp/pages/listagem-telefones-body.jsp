<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html"%>

<div>

	<div class="panel panel-default">

		<div class="panel-heading">
			<bean:message key="label.subtitle.telefones.contato" />
		</div>

		<div class="panel-body">
			<form id="listagemTelefones" method="post">

				<logic:messagesPresent message="true">
					<html:messages id="messages" message="true">
						<div class="alert alert-success">
							<span class="glyphicon glyphicon-info-sign"></span>
							<bean:write name="messages" />
						</div>
					</html:messages>
				</logic:messagesPresent>

				<button class="btn btn-primary"
					onclick="javascript:direcionarInclusaoTelefone();"
					data-toggle="tooltip" title="Novo">
					<span class="glyphicon glyphicon-plus"></span>
				</button>

				<input type="hidden" id="acao" name="acao"> <input
					type="hidden" id="id" name="id"> <br /> <br />

				<c:if test="${empty telefones}">
					<div class="alert alert-warning">
						<span class="glyphicon glyphicon-exclamation-sign"></span>
						<bean:message key="label.message.empty" />
					</div>
				</c:if>
				<c:if test="${not empty telefones}">
					<table
						class="table table-striped table-bordered table-hover table-condensed">
						<tr>
							<th><bean:message key="label.table.header.id" /></th>
							<th><bean:message key="label.table.header.codigo" /></th>
							<th><bean:message key="label.table.header.numero" /></th>
							<th><bean:message key="label.table.header.tipoTelefone" /></th>
							<th colspan="2"></th>
						</tr>
						<c:forEach items="${telefones}" var="telefone">
							<tr>
								<td>${telefone.id}</td>
								<td>${telefone.codigo}</td>
								<td>${telefone.numero}</td>
								<td>${telefone.tipo}</td>
								<td style="width: 5%">
									<button class="btn btn-danger"
										onclick="javascript:submeterManipulacaoTelefone('REMOVER', '${telefone.id}');"
										data-toggle="tooltip" title="Remover">
										<span class="glyphicon glyphicon-trash"></span>
									</button>
								</td>
								<td style="width: 5%">
									<button class="btn btn-default"
										onclick="javascript:submeterManipulacaoTelefone('EDITAR', '${telefone.id}');"
										data-toggle="tooltip" title="Editar">
										<span class="glyphicon glyphicon-pencil"></span>
									</button>
								</td>
							</tr>
						</c:forEach>
					</table>
				</c:if>
			</form>
		</div>

	</div>
</div>