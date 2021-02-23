<%@ page contentType="text/html;charset=cp1251" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset = "cp1251">
    <title>Events</title>
    <style><%@include file="/WEB-INF/css/MainPageStyle.css"%></style>
    <style><%@include file="/WEB-INF/css/EventsPageStyle.css"%></style>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/script.js"></script>
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Big+Shoulders+Display:wght@700&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@300&display=swap" rel="stylesheet">
</head>
<body>
    <%
        if(request.getParameter("id") != null){
            String idParam = request.getParameter("id");
            request.setAttribute("idVal", idParam);
        }
        else
            request.setAttribute("idVal", request.getAttribute("id"));
    %>
    <div class="header">
       <a href="index.jsp?id=${idVal}"><img id="logo" src="images/logo.gif" alt=""></a>
       <p class="mainText">Our events for you</p>
        <nav class="navigationBar">
            <a class="links" href="index.jsp?id=${idVal}">Main page</a>
            <a class="current" href="showConferences">Events</a>
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
    <div class="conferences_list">
    <c:forEach var="conf" items="${confList}">
            <div class="conference">
                <p class="conf_date">${conf.getDate()}</p>
                <a class="conf_link" href="">${conf.getName()}</a>
                <p>Conference topic: ${conf.getCommon_topic_id()}</p>
                <p>Conference location: ${conf.getLocation()}</p>
            </div>
    </c:forEach>
    </div>
</body>
</html>