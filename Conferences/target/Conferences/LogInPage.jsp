<%@ page contentType="text/html;charset=cp1251" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <meta charset = "cp1251">
    <title>Log in</title>
    <style><%@include file="/WEB-INF/css/MainPageStyle.css"%></style>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/script.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/validation.js"></script>
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Big+Shoulders+Display:wght@700&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@300&display=swap" rel="stylesheet">
</head>
<body>
    <fmt:setLocale value="${language}"/>
    <fmt:setBundle basename="res"/>
    <div class="header">
       <a href="mainPage"><img id="logo" src="images/logo.gif" alt=""></a>
        <nav class="languageLinks">
            <a class="links" href="language?language=en">En</a>
            <a class="links" href="language?language=ru">Ru</a>
       </nav>
       <p class="mainText"><fmt:message key="log_in_page_header_text"/></p>
        <nav class="navigationBar">
            <a class="links" href="mainPage"><fmt:message key="main_page_text"/></a>
            <a class="links" href="showConferences?id="><fmt:message key="events_text"/></a>
        </nav>
        <nav id="notHiddenLinks">
            <a class="links" href="RegistrationPage.jsp"><fmt:message key="sign_up_text"/></a>
            <a class="current" href="LogInPage.jsp"><fmt:message key="log_in_text"/></a>
        </nav>
        <nav id="hiddenLinks">
            <c:if test="${idVal == 1}">
                <a class="links" id="adminLink" href="admin?id=${idVal}"><fmt:message key="administration_text"/></a>
            </c:if>
            <a class="links" href="profile?id=${idVal}"><fmt:message key="profile_text"/></a>
            <a class="changeOnClick links" href="mainPage"><fmt:message key="log_out_text"/></a>
        </nav>
    </div>
    <div align="center" class="content">
        <form action="logIn" method="post" class="wrapper" name="myForm">
           <h1 class="form-name"><fmt:message key="log_in_text"/></h1>
            <div class="field">
                <label><fmt:message key="email_text"/>: </label>
                <fmt:message key='enter_email_text' var="enter_email"/>
                <p class="required"><input name="email" id="email" required type="email" onblur="checkEmail()"  placeholder="${enter_email}" size = 30> *</p>
            </div>
            <div class="field">
                <fmt:message key='enter_password_text' var="enter_password"/>
                <label><fmt:message key="password_text"/>: </label>
                <p class="required"><input name="password" id="password" required type="password" onblur="checkPassword()" placeholder="${enter_password}" size = 30> *</p>
            </div>
            <div class="buttons">
                <p class="buttons"><button name="button" type="button" onclick="checkLogInFields()" class="button"><fmt:message key="log_in_text"/></button> <button type="reset" name="clearButton" class="button"><fmt:message key="reset_fields_button"/></button></p>
            </div>
        </form>
    </div>
</body>
</html>