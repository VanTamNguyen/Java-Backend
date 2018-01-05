<%@ include file="WEB-INF/jsp/include.jsp"%>

<html>
    <head><title>Hello :: Spring Application</title></head>
    <body>
        <h1>Hello - Spring Application</h1>
        <p>Greetings <% out.println(request.getLocalAddr()); %> </p>
        <p>It is now: <c:out value="${now}" /></p>
    </body>
</html>