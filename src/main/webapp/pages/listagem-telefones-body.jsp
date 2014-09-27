<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html" %>

<div>

    <h3 class="subTitulo"><bean:message key="label.subtitle.telefones.contato"/></h3>

    <form id="listagemTelefones" method="post">
        <button class="buttonAcoes" onclick="javascript:direcionarInclusaoTelefone();"><bean:message
                key="label.button.novo"/></button>
        <input type="hidden" id="acao" name="acao">
        <input type="hidden" id="id" name="id">
        <br/><br/>

        <font color="blue">
            <logic:messagesPresent message="true">
                <html:messages id="messages" message="true">
                    <p class="messages"><bean:write name="messages"/></p>
                </html:messages>
            </logic:messagesPresent>
        </font>

        <c:if test="${empty telefones}">
            <h4 class="erro"><bean:message key="label.message.empty"/></h4>
        </c:if>
        <c:if test="${not empty telefones}">
            <table>
                <tr>
                    <th><bean:message key="label.table.header.id"/></th>
                    <th><bean:message key="label.table.header.codigo"/></th>
                    <th><bean:message key="label.table.header.numero"/></th>
                    <th><bean:message key="label.table.header.tipoTelefone"/></th>
                </tr>
                <c:forEach items="${telefones}" var="telefone">
                    <tr>
                        <td>${telefone.id}</td>
                        <td>${telefone.codigo}</td>
                        <td>${telefone.numero}</td>
                        <td>${telefone.tipo}</td>
                        <td>
                            <button class="buttonAcoes"
                                    onclick="javascript:submeterManipulacaoTelefone('REMOVER', '${telefone.id}');">
                                <bean:message key="label.button.remover"/>
                            </button>
                        </td>
                        <td>
                            <button class="buttonAcoes"
                                    onclick="javascript:submeterManipulacaoTelefone('EDITAR', '${telefone.id}');">
                                <bean:message key="label.button.editar"/>
                            </button>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </c:if>
    </form>
</div>