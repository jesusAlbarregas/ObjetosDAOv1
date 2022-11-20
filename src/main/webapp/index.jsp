<%-- 
    Document   : index
    Created on : 14-nov-2022, 20:11:19
    Author     : jesus
--%>

<jsp:directive.page contentType="text/html" pageEncoding="UTF-8"/>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="es">
    <head>
        <c:url var="estilo" value="/CSS/estilo.css" scope="application" />
        <c:set var="contexto" value="${pageContext.request.contextPath}" scope="application"/>
        <c:import url="INC/cabecera.jsp">
            <c:param name="titulo" value="DAO" />
            <c:param name="estilo" value="${estilo}" />
        </c:import>
    </head>
    <body>
    <body>
        <div id="principal">
            <h2>Listado de opciones</h2>
            <form method="post" action="FrontController">

                <input type="radio" name="all" value="alumnos" />Alumnos
                <br/>
                <br/>
                <input type="radio" name="all" value="alumnos_equipos" />Alumnos - Equipo
                <br/>
                <br/>
                <input type="radio" name="all" value="equipo_alumnos" />Equipo - Alumnos (por programación)
                <br/>
                <br/>
                <input type="radio" name="all" value="equipo_alumnos2" />Equipo - Alumnos (por SQL)
                <br/>
                <br/>
                <input type="radio" name="all" value="equipo_sinalumnos" />Equipo sin alumnos
                <br/>
                <br/>
                <input type="submit" name="Enviar" value="Enviar" />
            </form>
        </div>
    </body>
</body>
</html>
