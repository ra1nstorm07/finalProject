<%@ page contentType="text/html;charset=cp1251" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
    <fmt:setLocale value="${language}"/>
    <fmt:setBundle basename="res"/>
    <%
        String idParam = request.getParameter("id");
        request.setAttribute("idVal", idParam);
    %>
    <div class="header">
       <a href="mainPage?id=${idVal}"><img id="logo" src="images/logo.gif" alt=""></a>
        <nav class="languageLinks">
            <a class="links" href="language?language=en">En</a>
            <a class="links" href="language?language=ru">Ru</a>
       </nav>
       <p class="mainText"><fmt:message key="main_page_header_text"/></p>
        <nav class="navigationBar">
            <a class="current" href="mainPage"><fmt:message key="main_page_text"/></a>
            <a class="links" href="showConferences?id=${idVal}"><fmt:message key="events_text"/></a>
        </nav>
        <nav id="notHiddenLinks">
            <a class="links" href="RegistrationPage.jsp"><fmt:message key="sign_up_text"/></a>
            <a class="links" href="LogInPage.jsp"><fmt:message key="log_in_text"/></a>
        </nav>
        <nav id="hiddenLinks">
            <c:if test="${idVal == 1}">
                <a class="links" id="adminLink" href="admin?id=${idVal}"><fmt:message key="administration_text"/></a>
            </c:if>
            <a class="links" href="profile?id=${idVal}"><fmt:message key="profile_text"/></a>
            <a class="changeOnClick links" href="mainPage"><fmt:message key="log_out_text"/></a>
        </nav>
    </div>
    <div class="conferences_list">
        <c:forEach var="conf" items="${confList}" varStatus="loop">
            <c:if test="${loop.index < 3}">
                <div class="conference">
                    <p class="conf_date">${conf.getDate()}</p>
                    <a class="conf_link" href="">${conf.getName()}</a>
                    <p><fmt:message key="conference_topic"/>: ${conf.getCommonTopic()}</p>
                    <p><fmt:message key="conference_location"/>: ${conf.getLocation()}</p>
                </div>
            </c:if>
            <c:if test="${loop.index == 2}">
                <div align="center">
                    <form action="showConferences?id=${idVal}" method="post">
                        <p class="buttons"><button name="button" type="submit" class="button"><fmt:message key="show_more_button"/></button></p>
                    </form>
                </div>
            </c:if>
        </c:forEach>
    </div>
</body>
</html>
