<%@ page contentType="text/html;charset=cp1251" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <meta charset = "cp1251">
    <title>Log in</title>
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
        if(request.getParameter("id") != null){
            String idParam = request.getParameter("id");
            request.setAttribute("idVal", idParam);
        }
        else
            request.setAttribute("idVal", request.getAttribute("id"));
    %>
    <div class="header">
       <a href="mainPage?id=${idVal}"><img id="logo" src="images/logo.gif" alt=""></a>
       <nav class="languageLinks">
            <a class="links" href="language?language=en">En</a>
            <a class="links" href="language?language=ru">Ru</a>
       </nav>
       <p class="mainText"><fmt:message key="events_page_header_text"/></p>
        <nav class="navigationBar">
            <a class="links" href="mainPage?id=${idVal}"><fmt:message key="main_page_text"/></a>
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
            <a class="current" href="profile"><fmt:message key="profile_text"/></a>
            <a class="changeOnClick links" href="mainPage"><fmt:message key="log_out_text"/></a>
        </nav>
    </div>
    <div class="profile">
            <div class="userInformation">
                 <img class="profileImage" src="images/no-avatar-empty.png">
                 <div class="personalInformation">
                     <p class="userInfoTitle informationField"><fmt:message key="user_information_text"/></p>
                     <p class="informationField"><fmt:message key="name_text"/>: ${user.getName()}</p>
                     <p class="informationField"><fmt:message key="surname_text"/>: ${user.getSurname()}</p>
                     <p class="informationField"><fmt:message key="address_text"/>: ${user.getAddress()}</p>
                     <p class="informationField"><fmt:message key="email_text"/>: ${user.getEmail()}</p>
                     <button class="button" id="editButton" type="button" onclick="displayBlock1()"><fmt:message key="edit_information_button"/></button>
                 </div>
            </div>
            <div class="participationInConfs">
               <p class="confInfoTitle informationField"><fmt:message key="participation_information_text"/></p>
                <div class="confPartList">
                    <c:forEach var="conf" items="${confList}">
                        <div class="participationInfo">
                            <p class="informationField">${conf.date}</p>
                            <p class="informationField">${conf.name}</p>
                            <p class="informationField">${conf.location}</p>
                        </div>
                    </c:forEach>
                </div>
            </div>
            <div id = "hidden"></div>
                <div id = "hiddenWindow">
                        <div style="font-size: 50px; text-align: right; padding-right: 20px;">
                        <button id ="closeWindow" type="button" onclick = "close_window()">
                        <img src="images/close.png" width="35px"></button></div>
                        <div align = "center" id="content">
                            <h1 class="form-name"><fmt:message key="edit_information_button"/></h1>
                            <form action="editInformation?id=${idVal}" method="post" class="wrapper">
                                <div class="field">
                                    <label><fmt:message key="name_text"/>: </label>
                                    <p><input name="name" id="name" type="text" value="${user.getName()}" size = 30></p>
                                </div>
                                <div class="field">
                                    <label><fmt:message key="surname_text"/>: </label>
                                    <p><input name="surname" id="surname" type="text" value="${user.getSurname()}" size = 30></p>
                                </div>
                                <div class="field">
                                    <label><fmt:message key="address_text"/>: </label>
                                    <p><input name="address" id="address" type="text" value="${user.getAddress()}" size = 30></p>
                                </div>
                                <div class="field">
                                    <label><fmt:message key="password_text"/>: </label>
                                    <p><input name="password" id="password" type="password" value="${user.getPassword()}" size = 30></p>
                                </div>
                                <div class="buttons">
                                    <p class="buttons"><button name="button" type="submit"  id="changeOnClick" class="button"><fmt:message key="confirm_button"/></button></p>
                                </div>
                            </form>
                        </div>
                </div>
    </div>
</body>
</html>