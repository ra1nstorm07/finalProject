<%@ page contentType="text/html;charset=cp1251"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <meta charset = "cp1251">
    <title>Welcome!</title>
    <style><%@include file="/WEB-INF/css/MainPageStyle.css"%></style>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/script.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/adminPageScript.js"></script>
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
            <a class="links" href="mainPage?id=${idVal}"><fmt:message key="main_page_text"/></a>
            <a class="links" href="showConferences?id=${idVal}"><fmt:message key="events_text"/></a>
        </nav>
        <nav id="notHiddenLinks">
            <a class="links" href="RegistrationPage.jsp"><fmt:message key="sign_up_text"/></a>
            <a class="links" href="LogInPage.jsp"><fmt:message key="log_in_text"/></a>
        </nav>
        <nav id="hiddenLinks">
            <c:if test="${idVal == 1}">
                <a class="current" id="adminLink" href="admin?id=${idVal}"><fmt:message key="administration_text"/></a>
            </c:if>
            <a class="links" href="profile?id=${idVal}"><fmt:message key="profile_text"/></a>
            <a class="changeOnClick links" href="mainPage"><fmt:message key="log_out_text"/></a>
        </nav>
    </div>
    <form action="" class="selectModeForm">
            <p><select>
                <option disabled><fmt:message key="choose_display_mode"/></option>
                <option selected value="users"><fmt:message key="all_users_text"/></option>
                <option value="conferences"><fmt:message key="all_conferences_text"/></option>
                <option value="common_topics"><fmt:message key="all_topics_text"/></option>
                <option value="topics"><fmt:message key="all_subtopics"/></option>
                <option value="speakers"><fmt:message key="all_speakers"/></option>
                <option value="user_conference"><fmt:message key="users_conferences"/></option>
            </select></p>
            <p class="buttons"><button class="togglePanels button" type="button"><fmt:message key="submit_button"/></button></p>
    </form>
    <div class="updatePanel">
            <h1 class="form-name" align="center"><fmt:message key="all_users_text"/></h1>
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
                         <td class="adminButton"><form action="admin?id=${idVal}&objectType=delete&objectId=${user.id}&selectedObject=user" method="post"><p class="buttons"><button type="button" class="button" onclick="displayBlock1('${user.name}', '${user.surname}', '${user.address}', '${user.email}', '${user.password}', '${user.admin_privilegies}', '${idVal}')"><fmt:message key="edit_button"/></button><button type="submit" style="margin-left: 10px;" class="button"><fmt:message key="delete_button"/></button></p></form></td>
                    </tr>
                </c:forEach>
            </table>
            <p class="buttons"><button class="button" onclick="addBlock1(${idVal})"><fmt:message key="add_button"/></button></p>
        </div>
        <div class="updatePanel2">
               <h1 class="form-name" align="center"><fmt:message key="all_conferences_text"/></h1>
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
                        <td class="adminButton"><p class="buttons"><form action="admin?id=${idVal}&objectType=delete&objectId=${conf.id}&selectedObject=conference" method="post"><button type="button" class="button" onclick="displayBlock2('${conf.name}', '${conf.common_topic_id}', '${conf.date}', '${conf.location}', '${idVal}');"><fmt:message key="edit_button"/></button><button type="submit" style="margin-left: 10px;" class="button"><fmt:message key="delete_button"/></button></form></p></td>
                   </tr>
               </c:forEach>
            </table>
            <p class="buttons"><button class="button" onclick="addBlock2(${idVal})"><fmt:message key="add_button"/></button></p>
        </div>
        <div class="updatePanel3">
            <h1 class="form-name" align="center"><fmt:message key="all_topics_text"/></h1>
            <table class="updateTable3">
               <tr>
                   <th>id</th>
                   <th>name</th>
               </tr>
                <c:forEach var="commonTopic" items="${commonTopicList}">
                    <tr>
                         <td>${commonTopic.id}</td><td>${commonTopic.name}</td>
                         <td class="adminButton"><p class="buttons"><form action="admin?id=${idVal}&objectType=delete&objectId=${commonTopic.id}&selectedObject=commonTopic" method="post"><button type="button" onclick="displayBlock3('${commonTopic.name}', '${idVal}');" class="button"><fmt:message key="edit_button"/></button>
                         <button type="submit" style="margin-left: 10px;" class="button"><fmt:message key="delete_button"/></button></form></p></td>
                    </tr>
                </c:forEach>
            </table>
            <p class="buttons"><button class="button" onclick="addBlock3(${idVal})"><fmt:message key="add_button"/></button></p>
        </div>
        <div class="updatePanel4">
            <h1 class="form-name" align="center"><fmt:message key="all_subtopics"/></h1>
            <table class="updateTable4">
               <tr>
                   <th>id</th>
                   <th>name</th>
                   <th>common_topic_id</th>
               </tr>
                <c:forEach var="topic" items="${topicList}">
                    <tr>
                         <td>${topic.id}</td><td>${topic.name}</td><td>${topic.common_topic_id}</td>
                         <td class="adminButton"><p class="buttons"><form action="admin?id=${idVal}&objectType=delete&objectId=${topic.id}&selectedObject=topic" method="post"><button type="button" onclick="displayBlock4('${topic.name}', '${topic.common_topic_id}', '${idVal}');" class="button"><fmt:message key="edit_button"/></button>
                         <button type="submit" style="margin-left: 10px;" class="button"><fmt:message key="delete_button"/></button></form></p></td>
                    </tr>
                </c:forEach>
            </table>
            <p class="buttons"><button class="button" onclick="addBlock4(${idVal})"><fmt:message key="add_button"/></button></p>
        </div>
        <div class="updatePanel5">
            <h1 class="form-name" align="center"><fmt:message key="all_speakers"/></h1>
            <table class="updateTable5">
               <tr>
                   <th>id</th>
                   <th>user_id</th>
                   <th>topic_id</th>
               </tr>
                <c:forEach var="speaker" items="${speakerList}">
                    <tr>
                         <td>${speaker.id}</td><td>${speaker.user_id}</td><td>${speaker.topic_id}</td>
                         <td class="adminButton"><p class="buttons"><form action="admin?id=${idVal}&objectType=delete&objectId=${speaker.id}&selectedObject=speaker" method="post">
                         <input name="topic_id" type="hidden" value="${speaker.topic_id}">
                         <button type="button" onclick="displayBlock5('${speaker.user_id}', '${speaker.topic_id}', '${idVal}');" class="button"><fmt:message key="edit_button"/></button>
                         <button type="submit" style="margin-left: 10px;" class="button"><fmt:message key="delete_button"/></button></form></p></td>
                    </tr>
                </c:forEach>
            </table>
            <p class="buttons"><button class="button" onclick="addBlock5(${idVal})"><fmt:message key="add_button"/></button></p>
        </div>
        <div class="updatePanel6">
            <h1 class="form-name" align="center"><fmt:message key="users_conferences"/></h1>
            <table class="updateTable6">
               <tr>
                   <th>id</th>
                   <th>user_id</th>
                   <th>conference_id</th>
                   <th>isArrived</th>
               </tr>
                <c:forEach var="userConference" items="${userConferenceList}">
                    <tr>
                         <td>${userConference.id}</td><td>${userConference.user_id}</td><td>${userConference.conference_id}</td><td>${userConference.isArrived()}</td>
                         <td class="adminButton"><p class="buttons"><form action="admin?id=${idVal}&objectType=delete&objectId=${userConference.id}&selectedObject=userConference" method="post">
                         <button type="button" onclick="displayBlock6('${userConference.user_id}', '${userConference.conference_id}', '${userConference.isArrived()}', '${idVal}');" class="button"><fmt:message key="edit_button"/></button>
                         <button type="submit" style="margin-left: 10px;" class="button"><fmt:message key="delete_button"/></button></form></p></td>
                    </tr>
                </c:forEach>
            </table>
            <p class="buttons"><button class="button" onclick="addBlock6(${idVal})"><fmt:message key="add_button"/></button></p>
        </div>
        <div id = "hidden"></div>
</body>
</html>