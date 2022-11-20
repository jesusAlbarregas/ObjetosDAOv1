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
            <h2>Listado de equipos sin alumnos asignados</h2>
            <table>
                <thead>
                    <tr>
                        <th>Marca</th>
                        <th>Número de serie</th>

                    </tr>
                </thead>
                <tbody>

                    <c:forEach var="equipo" items="${equipos}">
                        <tr>
                            <td>${equipo.marca}</td> 
                            <td>${equipo.numSerie}</td>
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
