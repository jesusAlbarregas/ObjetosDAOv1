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
            <c:param name="titulo" value="aviso" />
            <c:param name="estilo" value="${estilo}" />
        </c:import>
    </head>
        <body>
            
            <div id="principal">
                <p><c:out value="${aviso}" /></p>
                        
            </div>
                <p><a href="${contexto}/Volver">Volver</a></p>
        </body>
    </html>
