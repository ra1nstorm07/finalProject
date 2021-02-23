<%@ page contentType="text/html;charset=cp1251" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
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
            <a class="links" href="showConferences?id=${idVal}">Events</a>
        </nav>
        <nav id="notHiddenLinks">
            <a class="links" href="RegistrationPage.jsp">Sign up</a>
            <a class="links" href="LogInPage.jsp">Log in</a>
        </nav>
        <nav id="hiddenLinks">
            <a class="links" id="adminLink" href="admin?id=${idVal}">Administration</a>
            <a class="current" href="profile">Profile</a>
            <a class="changeOnClick links" href="index.jsp">Log out</a>
        </nav>
    </div>
    <div class="profile">
            <div class="userInformation">
                 <img class="profileImage" src="images/no-avatar-empty.png">
                 <div class="personalInformation">
                     <p class="userInfoTitle informationField">User information</p>
                     <p class="informationField">Name: ${user.getName()}</p>
                     <p class="informationField">Surname: ${user.getSurname()}</p>
                     <p class="informationField">Address: ${user.getAddress()}</p>
                     <p class="informationField">Email: ${user.getEmail()}</p>
                     <p class="informationField">Type of user: speaker</p>
                     <button class="button" id="editButton" type="button" onclick="displayBlock1()">Edit information</button>
                 </div>
            </div>
            <div class="participationInConfs">
               <p class="confInfoTitle informationField">Participation information</p>
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
                            <h1 class="form-name">Edit information</h1>
                            <form action="editInformation?id=${idVal}" method="post" class="wrapper">
                                <div class="field">
                                    <label>Name: </label>
                                    <p><input name="name" id="name" type="text" value="${user.getName()}" size = 30></p>
                                </div>
                                <div class="field">
                                    <label>Surname: </label>
                                    <p><input name="surname" id="surname" type="text" value="${user.getSurname()}" size = 30></p>
                                </div>
                                <div class="field">
                                    <label>Address: </label>
                                    <p><input name="address" id="address" type="text" value="${user.getAddress()}" size = 30></p>
                                </div>
                                <div class="field">
                                    <label>Password: </label>
                                    <p><input name="password" id="password" type="password" value="${user.getPassword()}" size = 30></p>
                                </div>
                                <div class="buttons">
                                    <p class="buttons"><button name="button" type="submit"  id="changeOnClick" class="button">Confirm</button></p>
                                </div>
                            </form>
                        </div>
                </div>
    </div>
    <script>
        function displayBlock1() {
            document.getElementById("hidden").style.display = 'block';
            document.getElementById("hiddenWindow").style.display = 'block';
        }
        function close_window() {
            document.getElementById("hidden").style.display = 'none';
            document.getElementById("hiddenWindow").style.display = 'none';
        }
    </script>
</body>
</html>