<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div>

    <h3><bean:message key="label.title.cadastro.telefones"/></h3>

    <font color="red">
        <p class="error"><html:errors/></p>
    </font>

    <br/>
    <html:form action="salvar-telefone.do" method="post">
        <html:hidden property="id" value="${telefone.id}"/>
        <html:hidden property="idContato" value="${sessionScope.contatoDetalhado.id}"/>
        <html:hidden property="acao" value="CADASTRAR"/>
        <table class="tableForm">
            <tr>
                <td class="tableForm">
                    <bean:message key="label.form.codigo"/>
                </td>
                <td class="tableForm">
                    <html:text styleClass="textForm" property="codigo" value="${telefone.codigo}"/>
                </td>
            </tr>
            <tr>
                <td class="tableForm">
                    <bean:message key="label.form.numero"/>
                </td>
                <td class="tableForm">
                    <html:text styleClass="textForm" property="numero" value="${telefone.numero}"/>
                </td>
            </tr>
            <tr>
                <td class="tableForm">
                    <bean:message key="label.form.tipoTelefone"/>
                </td>
                <td class="tableForm">

                    <!-- Setando valor das opcoes de tipo de telefone -->
                    <c:set var="opcaoResidencial">
                        <bean:message key='label.option.residencial'/>
                    </c:set>
                    <c:set var="opcaoCelular">
                        <bean:message key='label.option.celular'/>
                    </c:set>
                    <c:set var="opcaoComercial">
                        <bean:message key='label.option.comercial'/>
                    </c:set>
                    <!-- Fim -->

                    <html:select property="tipoTelefone" styleClass="textForm">
                        <html:option key="label.option.selecione" value=""/>
                        <html:option key="label.option.residencial" value="${opcaoResidencial}"/>
                        <html:option key="label.option.celular" value="${opcaoCelular}"/>
                        <html:option key="label.option.comercial" value="${opcaoComercial}"/>
                    </html:select>
                </td>
            </tr>
        </table>
        <br/>
        <html:submit styleClass="buttonAcoes">
            <bean:message key='label.button.salvar'/>
        </html:submit>
    </html:form>
</div>