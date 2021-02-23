<%@ page contentType="text/html;charset=cp1251" %>
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
    <div class="header">
       <a href="index.jsp"><img id="logo" src="images/logo.gif" alt=""></a>
       <p class="mainText">Log in to participate in our events</p>
        <nav class="navigationBar">
            <a class="links" href="index.jsp">Main page</a>
            <a class="links" href="showConferences}">Events</a>
        </nav>
        <nav id="notHiddenLinks">
            <a class="links" href="RegistrationPage.jsp">Sign up</a>
            <a class="current" href="LogInPage.jsp">Log in</a>
        </nav>
        <nav id="hiddenLinks">
            <a class="links" href="profile">Profile</a>
            <a class="changeOnClick links" href="index.jsp">Log out</a>
        </nav>
    </div>
    <div align="center" class="content">
        <form action="logIn" method="post" class="wrapper">
           <h1 class="form-name">Log in</h1>
            <div class="field">
                <label>Email: </label>
                <p class="required"><input name="email" required type="email" placeholder="Enter email" size = 30> *</p>
            </div>
            <div class="field">
                <label>Password: </label>
                <p class="required"><input name="password" required type="password" placeholder="Enter password" size = 30> *</p>
            </div>
            <div class="buttons">
                <p class="buttons"><button name="button" type="submit" class="button changeOnClick">Log in</button> <button type="reset" name="clearButton" class="button">Reset fields</button></p>
            </div>
        </form>
    </div>
</body>
</html>