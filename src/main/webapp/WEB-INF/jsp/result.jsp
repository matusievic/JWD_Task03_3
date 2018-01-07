<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Result - XML parser</title>
</head>
<body>
<table border="1" cellpadding="5" cellspacing="5">
    <tr>
        <td>id</td>
        <td>is sent</td>
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
            <td><c:out value="${card.sent}"/></td>
            <td><c:out value="${card.country}"/></td>
            <td><c:out value="${card.year}"/></td>
            <td>
                <c:forEach var="author" items="${card.authors}">
                    <c:out value="${author.name} ${author.surname}"/><br>
                </c:forEach>
            </td>
            <td><c:out value="${card.hasAuthor}"/></td>
            <td><c:out value="${card.theme}"/></td>
            <td><c:out value="${card.valuable}"/></td>
            <td><c:out value="${card.type}"/></td>
        </tr>
    </c:forEach>
</table>

<%--Display Previous link--%>
<c:if test="${currentPage != 1}">
    <td><a href="/controller?page=${currentPage - 1}&command=DISPLAY">Previous</a></td>
</c:if>

<%--Display numbers--%>
<table border="1" cellpadding="5" cellspacing="5">
    <tr>
        <c:forEach begin="1" end="${pageCount + 1}" var="i">
            <c:choose>
                <c:when test="${currentPage eq i}">
                    <td>${i}</td>
                </c:when>
                <c:otherwise>
                    <td><a href="/controller?page=${i}&command=DISPLAY">${i}</a></td>
                </c:otherwise>
            </c:choose>
        </c:forEach>
    </tr>
</table>

<%--Display Next link--%>
<c:if test="${currentPage lt pageCount + 1}">
    <td><a href="/controller?page=${currentPage + 1}&command=DISPLAY">Next</a></td>
</c:if>

<br><br>
<a href="/">Go back</a>
</body>
</html>
