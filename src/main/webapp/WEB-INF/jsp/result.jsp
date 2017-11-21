<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Result - XML parser</title>
</head>
<body>
<table>
    <tr>
        <td>id</td>
        <td>is wasSent</td>
        <td>country</td>
        <td>year</td>
        <td>authors</td>
        <td>is author known</td>
        <td>theme</td>
        <td>valuable</td>
        <td>type</td>
    </tr>
    <c:forEach var="card" items="${cardList}">
        <tr>
            <td><c:out value="${card.id}"/></td>
            <td><c:out value="${card.wasSent}"/></td>
            <td><c:out value="${card.country}"/></td>
            <td><c:out value="${card.year}"/></td>
            <td>
                <c:forEach var="author" items="${card.authors}">
                    <c:out value="${author.name} ${author.surname}"/><br>
                </c:forEach>
            </td>
            <td><c:out value="${card.authorKnown}"/></td>
            <td><c:out value="${card.theme}"/></td>
            <td><c:out value="${card.valuable}"/></td>
            <td><c:out value="${card.type}"/></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
