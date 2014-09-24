<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div>
    <h3><bean:message key="label.title.detalhes.contato"/></h3>

    <h3 class="subTitulo"><bean:message key="label.subtitle.dados.contato"/></h3>
    <table>
        <tr>
            <th><bean:message key="label.table.header.id"/></th>
            <th><bean:message key="label.table.header.nome"/></th>
        </tr>
        <tr>
            <td><c:out value="${sessionScope.contatoDetalhado.id}" /></td>
            <td><c:out value="${sessionScope.contatoDetalhado.nome}" /></td>
        </tr>
    </table>
</div>