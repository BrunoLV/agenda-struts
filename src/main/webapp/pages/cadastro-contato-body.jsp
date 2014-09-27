<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div>

    <h3><bean:message key="label.title.cadastro.contatos"/></h3>

    <font color="red">
        <p class="error"><html:errors/></p>
    </font>

    <br/>
    <html:form action="salvar-contato.do" method="post">
        <html:hidden property="id" value="${contato.id}"/>
        <html:hidden property="acao" value="CADASTRAR"/>
        <table class="tableForm">
            <tr>
                <td class="tableForm">
                    <bean:message key="label.form.nome"/>
                </td>
                <td class="tableForm">
                    <html:text styleClass="textForm" property="nome" value="${contato.nome}"/>
                </td>
            </tr>
        </table>
        <br/>
        <html:submit styleClass="buttonAcoes">
            <bean:message key="label.button.salvar"/>
        </html:submit>
    </html:form>
</div>