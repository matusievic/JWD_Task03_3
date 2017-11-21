<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Main - XML Parser</title>
</head>
<body>
<form action="/controller" method="get">
    <input type="hidden" name="command" value="PARSE">
    <input type="submit" name="parser" value="SAX">
    <input type="submit" name="parser" value="StAX">
    <input type="submit" name="parser" value="DOM">
</form>
</body>
</html>
