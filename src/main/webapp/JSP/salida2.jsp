<%-- 
    Document   : salida
    Created on : 07-nov-2017, 10:49:06
    Author     : Jesus
--%>

<jsp:directive.page contentType="text/html" pageEncoding="UTF-8"/>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="es">
    <head>
        <c:import url="../INC/cabecera.jsp">
            <c:param name="titulo" value="alumnos-equipos" />
            <c:param name="estilo" value="${estilo}" />
        </c:import>
    </head>
        <body>
            <div id="principal">
                <h2>Listado de alumnos y su equipos asociados</h2>
            <table>
                <thead>
                    <tr>
                        <th>Nombre</th>
                        <th>Equipo</th>
                        <th>Nº serie</th>
                    </tr>
                </thead>
                <tbody>
                    
                    <c:forEach var="alumno" items="${alumnos}">
                        <tr>
                            <td><c:out value="${alumno.nombre}" /></td>
                            <c:choose>
                                <c:when test="${alumno.equipo.marca != null}">
                                    <td><c:out value="${alumno.equipo.marca}" /></td>
                            <td><c:out value="${alumno.equipo.numSerie}" /></td>
                                </c:when>
                                <c:otherwise>
                                    <td colspan="2">Sin equipo asociado</td>
                                </c:otherwise>
                            
                            </c:choose>
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
