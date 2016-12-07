<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div>
	<div class="panel panel-default">
		<div class="panel-heading">
			<bean:message key="label.title.cadastro.telefones" />
		</div>

		<div class="panel-body">
			<html:form action="salvar-telefone.do" method="post">

				<html:messages id="errors">
					<c:forEach items="${errors}" var="error">
						<div class="alert alert-danger">
							<span class="glyphicon glyphicon-warning-sign"></span>
							<c:out value="${error}" escapeXml="false" />
						</div>
					</c:forEach>
				</html:messages>

				<html:hidden property="id" value="${telefone.id}" />
				<html:hidden property="idContato" value="${sessionScope.contatoDetalhado.id}" />
				<html:hidden property="acao" value="CADASTRAR" />
				
				<div class="row">
					<div class="col-md-1">
						<div class="form-group">
							<label><bean:message key="label.form.codigo" /></label>
							<html:text styleClass="form-control" property="codigo" value="${telefone.codigo}" />
						</div>
					</div>
					<div class="col-md-3">
						<div class="form-group">
							<label><bean:message key="label.form.numero" /></label>
							<html:text styleClass="form-control" property="numero" value="${telefone.numero}" />
						</div>
					</div>
					<div class="col-md-2">
						<label><bean:message key="label.form.tipoTelefone" /></label>
						<!-- Setando valor das opcoes de tipo de telefone --> 
						<c:set var="opcaoResidencial">
							<bean:message key='label.option.residencial' />
						</c:set>
						<c:set var="opcaoCelular">
							<bean:message key='label.option.celular' />
						</c:set>
						<c:set var="opcaoComercial">
							<bean:message key='label.option.comercial' />
						</c:set> 
						<!-- Fim --> 
						<html:select property="tipoTelefone" styleClass="form-control">
							<html:option key="label.option.selecione" value="" />
							<html:option key="label.option.residencial" value="${opcaoResidencial}" />
							<html:option key="label.option.celular" value="${opcaoCelular}" />
							<html:option key="label.option.comercial" value="${opcaoComercial}" />
						</html:select>
					</div>
				</div>
				<button type="submit" class="btn btn-primary" data-toggle="tooltip" title="Salvar">
					<span class="glyphicon glyphicon-floppy-disk"></span>
				</button>
			</html:form>
		</div>
	</div>

</div>