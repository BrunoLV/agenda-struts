<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="panel panel-default">
	<div class="panel-heading">
		<bean:message key="label.title.listagem.contatos" />
	</div>
	<div class="panel-body">
		<form method="post">
		
			<logic:messagesPresent message="true">
				<html:messages id="messages" message="true">
					<div class="alert alert-success">
						<span class="glyphicon glyphicon-info-sign"></span>
						<bean:write name="messages" />
					</div>
				</html:messages>
			</logic:messagesPresent>
		
			<button class="btn btn-primary" onclick="javascript:direcionarInclusao();">
				<span class="glyphicon glyphicon-plus"></span>
			</button>
			
			<br/>
			<br/>
			
			<input type="hidden" id="acao" name="acao"> 
			<input type="hidden" id="id" name="id"> 

			<c:if test="${empty contatos}">
				<h4 class="erro">
					<bean:message key="label.message.empty" />
				</h4>
			</c:if>
			<c:if test="${not empty contatos}">
				<table class="table table-striped table-bordered table-hover table-condensed">
					<tr>
						<th><bean:message key="label.table.header.id" /></th>
						<th><bean:message key="label.table.header.nome" /></th>
						<th colspan="3"></th>
					</tr>
					<c:forEach items="${contatos}" var="contato">
						<tr>
							<td><c:out value="${contato.id}" /></td>
							<td><c:out value="${contato.nome}" /></td>
							<td style="width: 5%">
								<button class="btn btn-danger" onclick="javascript:submeterManipulacao('REMOVER', '${contato.id}');">
									<span class="glyphicon glyphicon-trash"></span>
								</button>
							</td>
							<td style="width: 5%">
								<button class="btn btn-default" onclick="javascript:submeterManipulacao('EDITAR', '${contato.id}');">
									<span class="glyphicon glyphicon-pencil"></span>
								</button>
							</td>
							<td style="width: 5%">
								<button class="btn btn-success" onclick="javascript:submeterManipulacao('DETALHAR', '${contato.id}');">
									<span class="glyphicon glyphicon-list"></span>
								</button>
							</td>
						</tr>
					</c:forEach>
				</table>
			</c:if>
		</form>
	</div>
</div>