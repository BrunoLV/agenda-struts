<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div>
    <h3><bean:message key="label.title.listagem.contatos"/></h3>

    <form method="post">
        <button class="buttonAcoes" onclick="javascript:direcionarInclusao();">
            <bean:message key="label.button.novo"/>
        </button>
        <input type="hidden" id="acao" name="acao">
        <input type="hidden" id="id" name="id">
        <br/><br/>

        <font color="blue">
            <logic:messagesPresent message="true">
                <html:messages id="messages" message="true">
                    <p class="messages"><bean:write name="messages"/></p>
                </html:messages>
                <br/>
            </logic:messagesPresent>
        </font>

        <c:if test="${empty contatos}">
            <h4 class="erro"><bean:message key="label.message.empty"/></h4>
        </c:if>
        <c:if test="${not empty contatos}">
            <table>
                <tr>
                    <th>
                        <bean:message key="label.table.header.id"/>
                    </th>
                    <th>
                        <bean:message key="label.table.header.nome"/>
                    </th>
                </tr>
                <c:forEach items="${contatos}" var="contato">
                    <tr>
                        <td><c:out value="${contato.id}"/></td>
                        <td><c:out value="${contato.nome}"/></td>
                        <td>
                            <button class="buttonAcoes"
                                    onclick="javascript:submeterManipulacao('REMOVER', '${contato.id}');">
                                <bean:message key="label.button.remover"/>
                            </button>
                        </td>
                        <td>
                            <button class="buttonAcoes"
                                    onclick="javascript:submeterManipulacao('EDITAR', '${contato.id}');">
                                <bean:message key="label.button.editar"/>
                            </button>
                        </td>
                        <td>
                            <button class="buttonAcoes"
                                    onclick="javascript:submeterManipulacao('DETALHAR', '${contato.id}');">
                                <bean:message key="label.button.detalhar"/>
                            </button>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </c:if>
    </form>
</div>