<%@ page contentType="text/html;charset=cp1251"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
            <a class="current" href="showConferences"><fmt:message key="events_text"/></a>
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
    <script>
        function displayBlock(conference_id, idVal) {
            let div = document.createElement('div');
            div.id = "hiddenWindow";
            div.innerHTML = "<div style='font-size: 50px; text-align: right; padding-right: 20px;'>\n" +
                                         "  <button id ='closeWindow' type='button' onclick = 'close_window()'>\n" +
                                         "  <img src='images/close.png' width='35px'></button></div>\n" +
                                         "  <div align = 'center' id='content'>\n" +
                                         "      <form name='myForm' action='joinConference?id=" + idVal + "&conference_id=" + conference_id + "' method='post' class='wrapper'>\n" +
                                         "          <div id='radioForm'>\n" +
                                         "              <p><fmt:message key='join_as'/>: </p>\n" +
                                         "              <p><input class='radioFormField' name='userType' type='radio' value='speaker' size = 30><fmt:message key='speaker'/></p>\n" +
                                         "              <p><input class='radioFormField' name='userType' type='radio' value='user' size = 30><fmt:message key='user'/></p>\n" +
                                         "              <p class='buttons' style='text-align: center;'><button type='button' onclick='setUserType(userType.value)' class='button'><fmt:message key='confirm_button'/></button></p>\n" +
                                         "          </div>\n" +
                                         "      </form>\n" +
                                         "</div>";
            document.body.append(div);
            document.getElementById("hidden").style.display = 'block';
            document.getElementById("hiddenWindow").style.display = 'block';

        }
        function setUserType(userType) {
            if(userType == "user")
                document.forms["myForm"].requestSubmit();
            else {
                document.getElementById("radioForm").innerHTML="<label><fmt:message key='topic_name'/>: </label>" +
                                "<input name='userType' type='hidden' value='" + userType + "'>" +
                                "<p><input name='topic' id='topic' type='text' size = 30></p><p class='buttons' style='text-align: center;'><button name='button' type='submit' class='button'>Confirm</button></p>";
            }
        }
    </script>
    <form action="showConferences?id=${idVal}" method="post" class="sortForm">
        <p><select name="option">
            <option disabled><fmt:message key="sort_by"/></option>
            <option value="dateDesc"><fmt:message key="date_desc"/></option>
            <option value="date"><fmt:message key="date"/></option>
            <option value="topicsDesc"><fmt:message key="topics_number_desc"/></option>
            <option value="topics"><fmt:message key="topics_number"/></option>
            <option value="usersDesc"><fmt:message key="users_number_desc"/></option>
            <option value="users"><fmt:message key="users_number"/></option>
        </select></p>
        <p class="buttons"><button class="button" type="submit"><fmt:message key="submit_button"/></button></p>
    </form>
    <div class="conferences_list">
    <c:if test="${pageList.size() > 1}">
        <div class="pagination">
            <c:forEach var="pages" items="${pageList}">
                <c:if test="${pages != currentPage}">
                    <a class="paginationLink" href="showConferences?id=${idVal}&page=${pages}">${pages}</a>
                </c:if>
                <c:if test="${pages == currentPage}">
                    <a class="paginationCurrentLink" href="showConferences?id=${idVal}&page=${pages}">${pages}</a>
                </c:if>
            </c:forEach>
        </div>
    </c:if>
    <c:forEach var="conf" items="${confList}" end="8">
            <div class="conference">
                <p class="conf_date">${conf.getDate()}</p>
                <a class="conf_link" href="">${conf.getName()}</a>
                <p><fmt:message key="conference_topic"/>: ${conf.getCommonTopic()}</p>
                <p><fmt:message key="conference_location"/>: ${conf.getLocation()}</p>
                <c:if test="${idVal != ''}">
                    <p class="buttons"><button name="button" type="button" class="button" onclick="displayBlock(${conf.id}, ${idVal})"><fmt:message key="join_conference_button"/></button></p>
                </c:if>
            </div>
    </c:forEach>
    </div>
    <div id = "hidden"></div>
</body>
</html>