<%--
  Created by IntelliJ IDEA.
  User: MAIN
  Date: 14.03.2020
  Time: 15:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
    <%@ taglib prefix="title" uri="http://tiles.apache.org/tags-tiles" %>
    <%@ taglib prefix="tites" uri="http://tiles.apache.org/tags-tiles" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <!DOCTYPE html>
    <html>
<head>

    <link href="<c:url value="/resources/css/default.css" />" rel="stylesheet">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/v/dt/jq-3.3.1/dt-1.10.20/datatables.min.css"/>
    <script type="text/javascript" src="https://cdn.datatables.net/v/dt/jq-3.3.1/dt-1.10.20/datatables.min.js"></script>
    <script src="<c:url value="/resources/js/default.js" />"></script>


   <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title><title:getAsString name="title"></title:getAsString></title>
</head>
<body>

    <h1 class="text-light">Elektroniczna Informacja Kontrahentów</h1>

    <tites:insertAttribute name="body"/>
    <br><br>

    <tiles:insertAttribute name="footer"/>

</body>
</html>
