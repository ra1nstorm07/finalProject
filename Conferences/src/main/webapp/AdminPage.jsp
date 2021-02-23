<%@ page contentType="text/html;charset=cp1251" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
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
            <a class="links" href="index.jsp?id=${idVal}">Main page</a>
            <a class="links" href="showConferences?id=${idVal}">Events</a>
        </nav>
        <nav id="notHiddenLinks">
            <a class="links" href="RegistrationPage.jsp">Sign up</a>
            <a class="links" href="LogInPage.jsp">Log in</a>
        </nav>
        <nav id="hiddenLinks">
            <a class="current" id="adminLink" href="admin?id=${idVal}">Administration</a>
            <a class="links" href="profile?id=${idVal}">Profile</a>
            <a class="changeOnClick links" href="index.jsp">Log out</a>
        </nav>
    </div>
    <form action="" class="selectModeForm">
            <p><select>
                <option disabled>Choose showmode</option>
                <option selected value="users">All users</option>
                <option value="conferences">All conferences</option>
                <option value="topics">All topics</option>
            </select></p>
            <p class="buttons"><button class="togglePanels button" type="button">Submit</button></p>
    </form>
    <script>
            document.getElementsByClassName('togglePanels')[0].addEventListener('click', function () {
                    if(document.getElementsByTagName("select")[0].value == "users"){
                        document.getElementsByClassName("updatePanel")[0].style.display = 'block';
                        document.getElementsByClassName("updatePanel2")[0].style.display = 'none';
                        document.getElementsByClassName("updatePanel3")[0].style.display = 'none';
                    }
                    else if(document.getElementsByTagName("select")[0].value == "conferences"){
                        document.getElementsByClassName("updatePanel")[0].style.display = 'none';
                        document.getElementsByClassName("updatePanel2")[0].style.display = 'block';
                        document.getElementsByClassName("updatePanel3")[0].style.display = 'none';
                    }
                    else {
                        document.getElementsByClassName("updatePanel")[0].style.display = 'none';
                        document.getElementsByClassName("updatePanel2")[0].style.display = 'none';
                        document.getElementsByClassName("updatePanel3")[0].style.display = 'block';
                    }
                });
        </script>
    <div class="updatePanel">
            <h1 class="form-name" align="center">All users</h1>
            <table class="updateTable">
               <tr>
                   <th>id</th>
                   <th>name</th>
                   <th>surname</th>
                   <th>address</th>
                   <th>email</th>
                   <th>password</th>
                   <th>admin_privilegies</th>
               </tr>
                <c:forEach var="user" items="${usersList}">
                    <tr>
                         <td>${user.id}</td><td>${user.name}</td><td>${user.surname}</td><td>${user.address}</td><td>${user.email}</td><td>${user.password}</td><td>${user.admin_privilegies}</td>
                         <td class="adminButton"><p class="buttons"><form action="adminEdit?id=${idVal}&elementType=user&elementId=${user.id}" method="post"><button type="submit" class="button" onclick="displayBlock1(${user.id})">Edit</button><button style="margin-left: 10px;" class="button">Delete</button></form></p></td>
                    </tr>
                </c:forEach>
            </table>
        </div>
        <div class="updatePanel2">
               <h1 class="form-name" align="center">All conferences</h1>
               <table class="updateTable2">
                  <tr>
                      <th>id</th>
                      <th>name</th>
                      <th>common_topic_id</th>
                      <th>date</th>
                      <th>location</th>
                  </tr>
               <c:forEach var="conf" items="${confList}">
                   <tr>
                        <td>${conf.id}</td><td>${conf.name}</td><td>${conf.common_topic_id}</td><td>${conf.date}</td><td>${conf.location}</td>
                        <td class="adminButton"><p class="buttons"><button class="button" onclick="displayBlock2(${conf.id})">Edit</button><button style="margin-left: 10px;" class="button">Delete</button></p></td>
                   </tr>
               </c:forEach>
            </table>
        </div>
        <div class="updatePanel3">
            <h1 class="form-name" align="center">All users</h1>
            <table class="updateTable3">
               <tr>
                   <th>id</th>
                   <th>name</th>
               </tr>
                <c:forEach var="commonTopic" items="${commonTopicList}">
                    <tr>
                         <td>${commonTopic.id}</td><td>${commonTopic.name}</td>
                         <td class="adminButton"><p class="buttons"><button class="button" onclick="displayBlock3(${commonTopic.id})">Edit</button><button style="margin-left: 10px;" class="button">Delete</button></p></td>
                    </tr>
                </c:forEach>
            </table>
        </div>
        <div id = "hidden"></div>
           <div id = "hiddenWindow">
               <div style="font-size: 50px; text-align: right; padding-right: 20px;">
               <button id ="closeWindow" type="button" onclick = "close_window()">
               <img src="images/close.png" width="35px"></button></div>
               <div align = "center" id="content">
                   <h1 class="form-name">Edit information</h1>
                   <form action="" method="post" class="wrapper">
                       <div class="field">
                           <label>Name: </label>
                           <p><input name="name" class="name" type="text" value="${formUser.getName()}" size = 30></p>
                       </div>
                       <div class="field">
                           <label>Surname: </label>
                           <p><input name="surname" id="surname" type="text" value="${formUser.getSurname()}" size = 30></p>
                       </div>
                       <div class="field">
                           <label>Address: </label>
                           <p><input name="address" id="address" type="text" value="${formUser.getAddress()}" size = 30></p>
                       </div>
                       <div class="field">
                           <label>Email: </label>
                           <p><input name="email" id="email" type="text" value="${formUser.getEmail()}" size = 30></p>
                       </div>
                       <div class="field">
                           <label>Password: </label>
                           <p><input name="password" id="password" type="password" value="${formUser.getPassword()}" size = 30></p>
                       </div>
                       <div class="field">
                           <label>Admin_privilegies: </label>
                           <p><input name="admin_privilegies" id="admin_privilegies" type="text" value="${formUser.getAdmin_privilegies()}" size = 30></p>
                       </div>
                       <div class="buttons">
                           <p class="buttons"><button name="button" type="submit" class="button">Confirm</button></p>
                       </div>
                   </form>
               </div>
           </div>
           <div id = "hiddenWindow2">
               <div style="font-size: 50px; text-align: right; padding-right: 20px;">
               <button id ="closeWindow" type="button" onclick = "close_window()">
               <img src="images/close.png" width="35px"></button></div>
               <div align = "center" id="content">
                   <h1 class="form-name">Edit information</h1>
                   <form action="" method="post" class="wrapper">
                       <div class="field">
                           <label>Name: </label>
                           <p><input name="name" class="name" type="text" value="${formConf.getName()}" size = 30></p>
                       </div>
                       <div class="field">
                           <label>Common_topic_id: </label>
                           <p><input name="common_topic_id" id="common_topic_id" type="text" value="${formConf.getSurname()}" size = 30></p>
                       </div>
                       <div class="field">
                           <label>Date: </label>
                           <p><input name="date" id="date" type="text" value="${formConf.getAddress()}" size = 30></p>
                       </div>
                       <div class="field">
                           <label>Location: </label>
                           <p><input name="location" id="location" type="password" value="${formConf.getPassword()}" size = 30></p>
                       </div>
                       <div class="buttons">
                           <p class="buttons"><button name="button" type="submit" class="button">Confirm</button></p>
                       </div>
                   </form>
               </div>
           </div>
            <div id = "hiddenWindow3">
               <div style="font-size: 50px; text-align: right; padding-right: 20px;">
               <button id ="closeWindow" type="button" onclick = "close_window()">
               <img src="images/close.png" width="35px"></button></div>
               <div align = "center" id="content">
                   <h1 class="form-name">Edit information</h1>
                   <form action="" method="post" class="wrapper">
                       <div class="field">
                           <label>Name: </label>
                           <p><input name="name" class="name" type="text" value="${formTopic.getName()}" size = 30></p>
                       </div>
                       <div class="buttons">
                           <p class="buttons"><button name="button" type="submit" class="button">Confirm</button></p>
                       </div>
                   </form>
               </div>
           </div>
           <script>
               function displayBlock1(id) {
                   document.getElementById("hidden").style.display = 'block';
                   document.getElementById("hiddenWindow").style.display = 'block';
                   document.getElementsByClassName("wrapper")[0].setAttribute("action", "admin?id=${idVal}&elementType=user&elementId="+id);
               }

               function displayBlock2(id) {
                   document.getElementById("hidden").style.display = 'block';
                   document.getElementById("hiddenWindow2").style.display = 'block';
                   document.getElementsByClassName("wrapper")[1].setAttribute("action", "admin?id=${idVal}&elementType=conference&elementId="+id);
               }

               function displayBlock3(id) {
                   document.getElementById("hidden").style.display = 'block';
                   document.getElementById("hiddenWindow3").style.display = 'block';
                   document.getElementsByClassName("wrapper")[2].setAttribute("action", "admin?id=${idVal}&elementType=commonTopic&elementId="+id);

               }

               function close_window() {
                   document.getElementById("hidden").style.display = 'none';
                   document.getElementById("hiddenWindow").style.display = 'none';
                   document.getElementById("hiddenWindow2").style.display = 'none';
                   document.getElementById("hiddenWindow3").style.display = 'none';
               }
           </script>
</body>
</html>