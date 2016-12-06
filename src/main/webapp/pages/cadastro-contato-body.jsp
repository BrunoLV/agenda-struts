<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div>
	<div class="panel panel-default">
		<div class="panel-heading">
			<bean:message key="label.title.cadastro.contatos" />
		</div>
		<div class="panel-body">
			<html:form action="salvar-contato.do" method="post">
				
				<html:messages id="errors">
					<c:forEach items="${errors}" var="error">
						<div class="alert alert-danger">
							<span class="glyphicon glyphicon-warning-sign"></span>
							<c:out value="${error}" escapeXml="false" />
						</div>
					</c:forEach>
				</html:messages>
				
				<html:hidden property="id" value="${contato.id}" />
				<html:hidden property="acao" value="CADASTRAR" />
				
				<div class="row">
					<div class="col-md-6">
						<div class="form-group">
							<label><bean:message key="label.form.nome" /></label>
							<html:text styleClass="form-control" property="nome"
								value="${contato.nome}" />
						</div>
					</div>
				</div>
				<button type="submit" class="btn btn-primary">
					<span class="glyphicon glyphicon-floppy-disk"></span>
				</button>
			</html:form>
		</div>
	</div>
</div>