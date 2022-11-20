<%-- 
    Document   : salida
    Created on : 07-nov-2017, 10:49:06
    Author     : Jesus
--%>

<jsp:directive.page contentType="text/html" pageEncoding="UTF-8"/>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <c:import url="../INC/cabecera.jsp">
            <c:param name="titulo" value="equipo-alumnos" />
            <c:param name="estilo" value="${estilo}" />
        </c:import>
    </head>
    <body>
        <div id="principal">
            <h2>Listado de equipos con alumnos asignados</h2>
            <table>
                <thead>
                    <tr>
                        <th>Marca</th>
                        <th>Nombre</th>

                    </tr>
                </thead>
                <tbody>

                    <c:forEach var="auxiliar" items="${listado}">
                        <tr>
                            <td rowspan="${fn:length(auxiliar.alumnos)}"><c:out value="${auxiliar.nombreEquipo}" /></td>
                            <c:forEach var="nombre" items="${auxiliar.alumnos}" varStatus="i">
                                <c:if test="${i.count != 1}">
                                <tr>
                                </c:if>
                                <td>${nombre}</td>
                            </tr>
                        </c:forEach>
                        </tr>
                    </c:forEach>
                </tbody>
                <tr>
                    <td colspan="3" style="text-align: center;"><p><a href="${contexto}/Volver">Volver</a></p></td>
                </tr>
            </table>

        </div>
    </body>
</html>
