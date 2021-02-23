<%@ page contentType="text/html;charset=cp1251" %>
<html>
<head>
    <meta charset = "cp1251">
    <title>Welcome!</title>
    <style><%@include file="/WEB-INF/css/MainPageStyle.css"%></style>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/script.js"></script>
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Big+Shoulders+Display:wght@700&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@300&display=swap" rel="stylesheet">
</head>
<body>
    <%
        String idParam = request.getParameter("id");
        request.setAttribute("idVal", idParam);
    %>
    <div class="header">
       <a href="index.jsp?id=${idVal}"><img id="logo" src="images/logo.gif" alt=""></a>
       <p class="mainText">Welcome to conferences site!</p>
        <nav class="navigationBar">
            <a class="current" href="index.jsp">Main page</a>
            <a class="links" href="showConferences?id=${idVal}">Events</a>
        </nav>
        <nav id="notHiddenLinks">
            <a class="links" href="RegistrationPage.jsp">Sign up</a>
            <a class="links" href="LogInPage.jsp">Log in</a>
        </nav>
        <nav id="hiddenLinks">
            <a class="links" id="adminLink" href="admin?id=${idVal}">Administration</a>
            <a class="links" href="profile?id=${idVal}">Profile</a>
            <a class="changeOnClick links" href="index.jsp">Log out</a>
        </nav>
    </div>
</body>
</html>
