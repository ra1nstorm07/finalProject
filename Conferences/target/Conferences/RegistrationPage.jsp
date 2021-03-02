<%@ page contentType="text/html;charset=cp1251" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <meta charset = "cp1251">
    <title>Registration</title>
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
        <p class="mainText"><fmt:message key="sign_up_page_header_text"/></p>
        <nav class="navigationBar">
            <a class="links" href="mainPage"><fmt:message key="main_page_text"/></a>
            <a class="links" href="showConferences?id="><fmt:message key="events_text"/></a>
        </nav>
        <nav id="notHiddenLinks">
            <a class="current" href="RegistrationPage.jsp"><fmt:message key="sign_up_text"/></a>
            <a class="links" href="LogInPage.jsp"><fmt:message key="log_in_text"/></a>
        </nav>
        <nav id="hiddenLinks">
            <a class="links" id="profile" href="profile"><fmt:message key="profile_text"/></a>
            <a class="changeOnClick links" href="mainPage"><fmt:message key="log_out_text"/></a>
        </nav>
    </div>
    <div align = "center" class="content">
        <form action="registration" method="post" class="wrapper" name="myForm">
           <h1 class="form-name"><fmt:message key="sign_up_text"/></h1>
            <div class="field">
                <fmt:message key="enter_name_text" var="enter_name"/>
                <label><fmt:message key="name_text"/>: </label>
                <p class="required"><input name="Name" id="name" required type="text" onblur="checkName()" placeholder="${enter_name}" size = 30> *</p>
            </div>
            <div class="field">
                <fmt:message key="enter_surname_text" var="enter_surname"/>
                <label><fmt:message key="surname_text"/>: </label>
                <p class="required"><input name="Surname" id="surname" required type="text" onblur="checkSurname()" placeholder="${enter_surname}" size = 30> *</p>
            </div>
            <div class="field">
                <fmt:message key="enter_your_address_text" var="enter_your_address"/>
                <label><fmt:message key="address_text"/>: </label>
                <p class="nonRequired"><input name="Address" id="address" type="address" placeholder="${enter_your_address}" size = 30> *</p>
            </div>
            <div class="field">
                <fmt:message key="enter_email_text" var="enter_email"/>
                <label><fmt:message key="email_text"/>: </label>
                <p class="required"><input name="Email" id="email" required type="email" onblur="checkEmail()" placeholder="${enter_email}" size = 30> *</p>
            </div>
            <div class="field">
                <fmt:message key="enter_password_text" var="enter_password"/>
                <label><fmt:message key="password_text"/>: </label>
                <p class="required"><input name="Password" id="password" required type="password" onblur="checkPassword()" placeholder="${enter_password}" size = 30> *</p>
            </div>
            <div class="buttons">
                <p class="buttons"><button name="button" type="submit" onclick="checkSignUpFields" class="button"><fmt:message key="sign_up_text"/></button> <button type="reset" name="clearButton" class="button"><fmt:message key="reset_fields_button"/></button></p>
            </div>
        </form>
    </div>
</body>
</html>