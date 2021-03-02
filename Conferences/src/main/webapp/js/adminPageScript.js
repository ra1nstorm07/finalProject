function displayBlock1(name, surname, address, email, password, admin_privilegies, idVal) {
        let div = document.createElement('div');
        div.id = "hiddenWindow";
        div.innerHTML = "<div style='font-size: 50px; text-align: right; padding-right: 20px;'>" +
                                        "<button id ='closeWindow' type='button' onclick = 'close_window()'>" +
                                        "<img src='images/close.png' width='35px'></button></div>" +
                                        "<div align = 'center' id='content'>" +
                                           "<h1 class='form-name'>Edit information</h1>" +
                                            "<form action='admin?id=" + idVal + "&objectType=user' method='post' class='wrapper'>" +
                                                "<input name='objectName' id='objectName' type='hidden' value='" + email + "'>" +
                                                "<div class='field'>" +
                                                    "<label>Name: </label>" +
                                                    "<p><input name='name' id='name' type='text' value='" + name + "' size = 30></p>" +
                                                "</div>" +
                                                "<div class='field'>" +
                                                    "<label>Surname: </label>" +
                                                    "<p><input name='surname' id='surname' type='text' value='" + surname + "' size = 30></p>" +
                                                "</div>" +
                                                "<div class='field'>" +
                                                    "<label>Address: </label>" +
                                                    "<p><input name='address' id='address' type='text' value='" + address + "' size = 30></p>" +
                                                "</div>" +
                                                "<div class='field'>" +
                                                    "<label>Email: </label>" +
                                                    "<p><input name='email' id='email' type='text' value='" + email + "' size = 30></p>" +
                                                "</div>" +
                                                "<div class='field'>" +
                                                    "<label>Password: </label>" +
                                                    "<p><input name='password' id='password' type='text' value='" + password + "' size = 30></p>" +
                                                "</div>" +
                                                "<div class='field'>" +
                                                    "<label>Admin_privilegies: </label>" +
                                                    "<p><input name='admin_privilegies' id='admin_privilegies' type='text' value='" + admin_privilegies + "' size = 30></p>" +
                                                "</div>" +
                                                "<div class='buttons'>" +
                                                    "<p class='buttons'><button name='button' type='submit' class='button'>Confirm</button></p></div></form></div>";
        document.body.append(div);
        document.getElementById("hidden").style.display = 'block';
        document.getElementById("hiddenWindow").style.display = 'block';
}

function displayBlock2(name, common_topic_id, date, location, idVal) {
    let div = document.createElement('div');
    div.id = "hiddenWindow2";
    div.innerHTML = "<div style='font-size: 50px; text-align: right; padding-right: 20px;'>"+
                                    "<button id ='closeWindow' type='button' onclick = 'close_window()'>"+
                                    "<img src='images/close.png' width='35px'></button></div>"+
                                    "<div align = 'center' id='content'>"+
                                        "<h1 class='form-name'>Edit information</h1>"+
                                        "<form action='admin?id=" + idVal + "&objectType=conference' method='post' class='wrapper'>"+
                                            "<input name='objectName' id='objectName' type='hidden' value='" + name + "'>" +
                                            "<div class='field'>"+
                                                "<label>Name: </label>"+
                                                "<p><input name='name' id='name' type='text' value='" + name + "' size = 30></p>"+
                                            "</div>"+
                                            "<div class='field'>"+
                                                "<label>Common_topic_id: </label>"+
                                                "<p><input name='common_topic_id' id='common_topic_id' type='text' value='" + common_topic_id + "' size = 30></p>"+
                                            "</div>"+
                                            "<div class='field'>"+
                                                "<label>Date: </label>"+
                                                "<p><input name='date' id='date' type='text' value='" + date + "' size = 30></p>"+
                                            "</div>"+
                                            "<div class='field'>"+
                                                "<label>Location: </label>"+
                                                "<p><input name='location' id='location' type='text' value='" + location + "' size = 30></p>"+
                                            "</div>"+
                                            "<div class='buttons'>"+
                                                "<p class='buttons'><button name='button' type='submit' class='button'>Confirm</button></p></div></form></div>";
    document.body.append(div);
    document.getElementById("hidden").style.display = 'block';
    document.getElementById("hiddenWindow2").style.display = 'block';
}

function displayBlock3(name, idVal) {
    let div = document.createElement('div');
    div.id = "hiddenWindow3";
    div.innerHTML = "<div style='font-size: 50px; text-align: right; padding-right: 20px;'>"+
    "<button id ='closeWindow' type='button' onclick = 'close_window()'><img src='images/close.png' width='35px'>"+
    "</button></div><div align = 'center' id='content'><h1 class='form-name'>Edit information</h1>"+
    "<form action='admin?id=" + idVal + "&objectType=commonTopic' method='post' class='wrapper'>"+
    "<input name='objectName' id='objectName' type='hidden' value='" + name + "'>" +
    "<div class='field'><label>Name: </label><p><input name='name' id='name' type='text' value='" + name + "' size = 30></p></div><div class='buttons'>"+
    "<p class='buttons'><button name='button' type='submit' class='button'>Confirm</button></p></div></form></div>";
    document.body.append(div);
    document.getElementById("hidden").style.display = 'block';
    document.getElementById("hiddenWindow3").style.display = 'block';
}

function displayBlock4(name, common_topic_id, idVal) {
    let div = document.createElement('div');
    div.id = "hiddenWindow4";
    div.innerHTML = "<div style='font-size: 50px; text-align: right; padding-right: 20px;'>"+
                                    "<button id ='closeWindow' type='button' onclick = 'close_window()'>"+
                                    "<img src='images/close.png' width='35px'></button></div>"+
                                    "<div align = 'center' id='content'>"+
                                        "<h1 class='form-name'>Edit information</h1>"+
                                        "<form action='admin?id=" + idVal + "&objectType=topic' method='post' class='wrapper'>"+
                                            "<input name='objectName' id='objectName' type='hidden' value='" + name + "'>" +
                                            "<div class='field'>"+
                                                "<label>Name: </label>"+
                                                "<p><input name='name' id='name' type='text' value='" + name + "' size = 30></p>"+
                                            "</div>"+
                                            "<div class='field'>"+
                                                "<label>Common_topic_id: </label>"+
                                                "<p><input name='common_topic_id' id='common_topic_id' type='text' value='" + common_topic_id + "' size = 30></p>"+
                                            "</div>"+
                                            "<div class='buttons'>"+
                                                "<p class='buttons'><button name='button' type='submit' class='button'>Confirm</button></p></div></form></div>";
    document.body.append(div);
    document.getElementById("hidden").style.display = 'block';
    document.getElementById("hiddenWindow4").style.display = 'block';
}

function displayBlock5(user_id, topic_id, idVal) {
    let div = document.createElement('div');
    div.id = "hiddenWindow5";
    div.innerHTML = "<div style='font-size: 50px; text-align: right; padding-right: 20px;'>"+
                                    "<button id ='closeWindow' type='button' onclick = 'close_window()'>"+
                                    "<img src='images/close.png' width='35px'></button></div>"+
                                    "<div align = 'center' id='content'>"+
                                        "<h1 class='form-name'>Edit information</h1>"+
                                        "<form action='admin?id=" + idVal + "&objectType=speaker' method='post' class='wrapper'>"+
                                            "<input name='objectValue1' id='objectValue1' type='hidden' value='" + user_id + "'>" +
                                            "<input name='objectValue2' id='objectValue2' type='hidden' value='" + topic_id + "'>" +
                                            "<div class='field'>"+
                                                "<label>User_id: </label>"+
                                                "<p><input name='user_id' id='user_id' type='text' value='" + user_id + "' size = 30></p>"+
                                            "</div>"+
                                            "<div class='field'>"+
                                                "<label>Topic_id: </label>"+
                                                "<p><input name='topic_id' id='topic_id' type='text' value='" + topic_id + "' size = 30></p>"+
                                            "</div>"+
                                            "<div class='buttons'>"+
                                                "<p class='buttons'><button name='button' type='submit' class='button'>Confirm</button></p></div></form></div>";
    document.body.append(div);
    document.getElementById("hidden").style.display = 'block';
    document.getElementById("hiddenWindow5").style.display = 'block';
}

function displayBlock6(user_id, conference_id, isArrived, idVal) {
    let div = document.createElement('div');
    div.id = "hiddenWindow6";
    div.innerHTML = "<div style='font-size: 50px; text-align: right; padding-right: 20px;'>"+
                                    "<button id ='closeWindow' type='button' onclick = 'close_window()'>"+
                                    "<img src='images/close.png' width='35px'></button></div>"+
                                    "<div align = 'center' id='content'>"+
                                        "<h1 class='form-name'>Edit information</h1>"+
                                        "<form action='admin?id=" + idVal + "&objectType=user_conference' method='post' class='wrapper'>"+
                                            "<input name='objectValue1' id='objectValue1' type='hidden' value='" + user_id + "'>" +
                                            "<input name='objectValue2' id='objectValue2' type='hidden' value='" + conference_id + "'>" +
                                            "<div class='field'>"+
                                                "<label>User_id: </label>"+
                                                "<p><input name='user_id' id='user_id' type='text' value='" + user_id + "' size = 30></p>"+
                                            "</div>"+
                                            "<div class='field'>"+
                                                "<label>Conference_id: </label>"+
                                                "<p><input name='conference_id' id='conference_id' type='text' value='" + conference_id + "' size = 30></p>"+
                                            "</div>"+
                                            "<div class='field'>"+
                                                "<label>isArrived: </label>"+
                                                "<p><input name='isArrived' id='isArrived' type='text' value='" + isArrived + "' size = 30></p>"+
                                            "</div>"+
                                            "<div class='buttons'>"+
                                                "<p class='buttons'><button name='button' type='submit' class='button'>Confirm</button></p></div></form></div>";
    document.body.append(div);
    document.getElementById("hidden").style.display = 'block';
    document.getElementById("hiddenWindow6").style.display = 'block';
}

function addBlock1(idVal) {
        let div = document.createElement('div');
        div.id = "hiddenWindow";
        div.innerHTML = "<div style='font-size: 50px; text-align: right; padding-right: 20px;'>" +
                                        "<button id ='closeWindow' type='button' onclick = 'close_window()'>" +
                                        "<img src='images/close.png' width='35px'></button></div>" +
                                        "<div align = 'center' id='content'>" +
                                           "<h1 class='form-name'>Edit user</h1>" +
                                            "<form action='admin?id=" + idVal + "&objectType=add&selectedObject=user' method='post' class='wrapper'>" +
                                                "<div class='field'>" +
                                                    "<label>Name: </label>" +
                                                    "<p><input name='name' id='name' type='text' value='' size = 30></p>" +
                                                "</div>" +
                                                "<div class='field'>" +
                                                    "<label>Surname: </label>" +
                                                    "<p><input name='surname' id='surname' type='text' value='' size = 30></p>" +
                                                "</div>" +
                                                "<div class='field'>" +
                                                    "<label>Address: </label>" +
                                                    "<p><input name='address' id='address' type='text' value='' size = 30></p>" +
                                                "</div>" +
                                                "<div class='field'>" +
                                                    "<label>Email: </label>" +
                                                    "<p><input name='email' id='email' type='text' value='' size = 30></p>" +
                                                "</div>" +
                                                "<div class='field'>" +
                                                    "<label>Password: </label>" +
                                                    "<p><input name='password' id='password' type='text' value='' size = 30></p>" +
                                                "</div>" +
                                                "<div class='field'>" +
                                                    "<label>Admin_privilegies: </label>" +
                                                    "<p><input name='admin_privilegies' id='admin_privilegies' type='text' value='' size = 30></p>" +
                                                "</div>" +
                                                "<div class='buttons'>" +
                                                    "<p class='buttons'><button name='button' type='submit' class='button'>Confirm</button></p></div></form></div>";
        document.body.append(div);
        document.getElementById("hidden").style.display = 'block';
        document.getElementById("hiddenWindow").style.display = 'block';
}

function addBlock2(idVal) {
    let div = document.createElement('div');
    div.id = "hiddenWindow2";
    div.innerHTML = "<div style='font-size: 50px; text-align: right; padding-right: 20px;'>"+
                                    "<button id ='closeWindow' type='button' onclick = 'close_window()'>"+
                                    "<img src='images/close.png' width='35px'></button></div>"+
                                    "<div align = 'center' id='content'>"+
                                        "<h1 class='form-name'>Edit information</h1>"+
                                        "<form action='admin?id=" + idVal + "&objectType=add&selectedObject=conference' method='post' class='wrapper'>"+
                                            "<div class='field'>"+
                                                "<label>Name: </label>"+
                                                "<p><input name='name' id='name' type='text' value='' size = 30></p>"+
                                            "</div>"+
                                            "<div class='field'>"+
                                                "<label>Common_topic_id: </label>"+
                                                "<p><input name='common_topic_id' id='common_topic_id' type='text' value='' size = 30></p>"+
                                            "</div>"+
                                            "<div class='field'>"+
                                                "<label>Date: </label>"+
                                                "<p><input name='date' id='date' type='text' value='' size = 30></p>"+
                                            "</div>"+
                                            "<div class='field'>"+
                                                "<label>Location: </label>"+
                                                "<p><input name='location' id='location' type='text' value='' size = 30></p>"+
                                            "</div>"+
                                            "<div class='buttons'>"+
                                                "<p class='buttons'><button name='button' type='submit' class='button'>Confirm</button></p></div></form></div>";
    document.body.append(div);
    document.getElementById("hidden").style.display = 'block';
    document.getElementById("hiddenWindow2").style.display = 'block';
}

function addBlock3(idVal) {
    let div = document.createElement('div');
    div.id = "hiddenWindow3";
    div.innerHTML = "<div style='font-size: 50px; text-align: right; padding-right: 20px;'>"+
    "<button id ='closeWindow' type='button' onclick = 'close_window()'><img src='images/close.png' width='35px'>"+
    "</button></div><div align = 'center' id='content'><h1 class='form-name'>Edit information</h1><form action='admin?id=" + idVal + "&objectType=add&selectedObject=commonTopic' method='post' class='wrapper'>"+
    "<div class='field'><label>Name: </label><p><input name='name' id='name' type='text' value='' size = 30></p></div><div class='buttons'>"+
    "<p class='buttons'><button name='button' type='submit' class='button'>Confirm</button></p></div></form></div>";
    document.body.append(div);
    document.getElementById("hidden").style.display = 'block';
    document.getElementById("hiddenWindow3").style.display = 'block';
}

function addBlock4(idVal) {
    let div = document.createElement('div');
    div.id = "hiddenWindow4";
    div.innerHTML = "<div style='font-size: 50px; text-align: right; padding-right: 20px;'>"+
                                    "<button id ='closeWindow' type='button' onclick = 'close_window()'>"+
                                    "<img src='images/close.png' width='35px'></button></div>"+
                                    "<div align = 'center' id='content'>"+
                                        "<h1 class='form-name'>Edit information</h1>"+
                                        "<form action='admin?id=" + idVal + "&objectType=add&selectedObject=topic' method='post' class='wrapper'>"+
                                            "<div class='field'>"+
                                                "<label>Name: </label>"+
                                                "<p><input name='name' id='name' type='text' value='' size = 30></p>"+
                                            "</div>"+
                                            "<div class='field'>"+
                                                "<label>Common_topic_id: </label>"+
                                                "<p><input name='common_topic_id' id='common_topic_id' type='text' value='' size = 30></p>"+
                                            "</div>"+
                                            "<div class='buttons'>"+
                                                "<p class='buttons'><button name='button' type='submit' class='button'>Confirm</button></p></div></form></div>";
    document.body.append(div);
    document.getElementById("hidden").style.display = 'block';
    document.getElementById("hiddenWindow4").style.display = 'block';
}

function addBlock5(idVal) {
    let div = document.createElement('div');
    div.id = "hiddenWindow5";
    div.innerHTML = "<div style='font-size: 50px; text-align: right; padding-right: 20px;'>"+
                                    "<button id ='closeWindow' type='button' onclick = 'close_window()'>"+
                                    "<img src='images/close.png' width='35px'></button></div>"+
                                    "<div align = 'center' id='content'>"+
                                        "<h1 class='form-name'>Edit information</h1>"+
                                        "<form action='admin?id=" + idVal + "&objectType=add&selectedObject=speaker' method='post' class='wrapper'>"+
                                            "<div class='field'>"+
                                                "<label>User_id: </label>"+
                                                "<p><input name='user_id' id='user_id' type='text' value='' size = 30></p>"+
                                            "</div>"+
                                            "<div class='field'>"+
                                                "<label>Topic_id: </label>"+
                                                "<p><input name='topic_id' id='topic_id' type='text' value='' size = 30></p>"+
                                            "</div>"+
                                            "<div class='buttons'>"+
                                                "<p class='buttons'><button name='button' type='submit' class='button'>Confirm</button></p></div></form></div>";
    document.body.append(div);
    document.getElementById("hidden").style.display = 'block';
    document.getElementById("hiddenWindow5").style.display = 'block';
}

function addBlock6(idVal) {
    let div = document.createElement('div');
    div.id = "hiddenWindow6";
    div.innerHTML = "<div style='font-size: 50px; text-align: right; padding-right: 20px;'>"+
                                    "<button id ='closeWindow' type='button' onclick = 'close_window()'>"+
                                    "<img src='images/close.png' width='35px'></button></div>"+
                                    "<div align = 'center' id='content'>"+
                                        "<h1 class='form-name'>Edit information</h1>"+
                                        "<form action='admin?id=" + idVal + "&objectType=add&selectedObject=user_conference' method='post' class='wrapper'>"+
                                            "<div class='field'>"+
                                                "<label>User_id: </label>"+
                                                "<p><input name='user_id' id='user_id' type='text' value='' size = 30></p>"+
                                            "</div>"+
                                            "<div class='field'>"+
                                                "<label>Conference_id: </label>"+
                                                "<p><input name='conference_id' id='conference_id' type='text' value='' size = 30></p>"+
                                            "</div>"+
                                            "<div class='field'>"+
                                                "<label>isArrived: </label>"+
                                                "<p><input name='isArrived' id='isArrived' type='text' value='' size = 30></p>"+
                                            "</div>"+
                                            "<div class='buttons'>"+
                                                "<p class='buttons'><button name='button' type='submit' class='button'>Confirm</button></p></div></form></div>";
    document.body.append(div);
    document.getElementById("hidden").style.display = 'block';
    document.getElementById("hiddenWindow6").style.display = 'block';
}

function close_window() {
    document.getElementById("hidden").style.display = 'none';
    if(document.getElementById("hiddenWindow") != null)
        document.getElementById("hiddenWindow").remove();
    if(document.getElementById("hiddenWindow2") != null)
        document.getElementById("hiddenWindow2").remove();
    if(document.getElementById("hiddenWindow3") != null)
        document.getElementById("hiddenWindow3").remove();
    if(document.getElementById("hiddenWindow4") != null)
        document.getElementById("hiddenWindow4").remove();
    if(document.getElementById("hiddenWindow5") != null)
        document.getElementById("hiddenWindow5").remove();
    if(document.getElementById("hiddenWindow6") != null)
        document.getElementById("hiddenWindow6").remove();
}

window.addEventListener("load",function(){
    if(localStorage.getItem("updatePanel1_style"))
        document.getElementsByClassName("updatePanel")[0].style.display = localStorage.getItem("updatePanel1_style");
    if(localStorage.getItem("updatePanel2_style"))
        document.getElementsByClassName("updatePanel2")[0].style.display = localStorage.getItem("updatePanel2_style");
    if(localStorage.getItem("updatePanel3_style"))
        document.getElementsByClassName("updatePanel3")[0].style.display = localStorage.getItem("updatePanel3_style");
    if(localStorage.getItem("updatePanel4_style"))
        document.getElementsByClassName("updatePanel4")[0].style.display = localStorage.getItem("updatePanel4_style");
    if(localStorage.getItem("updatePanel5_style"))
        document.getElementsByClassName("updatePanel5")[0].style.display = localStorage.getItem("updatePanel5_style");
    if(localStorage.getItem("updatePanel6_style"))
        document.getElementsByClassName("updatePanel6")[0].style.display = localStorage.getItem("updatePanel6_style");

    document.getElementsByClassName('togglePanels')[0].addEventListener('click', function () {
            if(document.getElementsByTagName("select")[0].value == "users"){
                    document.getElementsByClassName("updatePanel")[0].style.display = 'block';
                    document.getElementsByClassName("updatePanel2")[0].style.display = 'none';
                    document.getElementsByClassName("updatePanel3")[0].style.display = 'none';
                    document.getElementsByClassName("updatePanel4")[0].style.display = 'none';
                    document.getElementsByClassName("updatePanel5")[0].style.display = 'none';
                    document.getElementsByClassName("updatePanel6")[0].style.display = 'none';
                }
                else if(document.getElementsByTagName("select")[0].value == "conferences"){
                    document.getElementsByClassName("updatePanel")[0].style.display = 'none';
                    document.getElementsByClassName("updatePanel2")[0].style.display = 'block';
                    document.getElementsByClassName("updatePanel3")[0].style.display = 'none';
                    document.getElementsByClassName("updatePanel4")[0].style.display = 'none';
                    document.getElementsByClassName("updatePanel5")[0].style.display = 'none';
                    document.getElementsByClassName("updatePanel6")[0].style.display = 'none';
                }
                else if(document.getElementsByTagName("select")[0].value == "common_topics"){
                    document.getElementsByClassName("updatePanel")[0].style.display = 'none';
                    document.getElementsByClassName("updatePanel2")[0].style.display = 'none';
                    document.getElementsByClassName("updatePanel3")[0].style.display = 'block';
                    document.getElementsByClassName("updatePanel4")[0].style.display = 'none';
                    document.getElementsByClassName("updatePanel5")[0].style.display = 'none';
                    document.getElementsByClassName("updatePanel6")[0].style.display = 'none';
                }
                else if(document.getElementsByTagName("select")[0].value == "topics"){
                    document.getElementsByClassName("updatePanel")[0].style.display = 'none';
                    document.getElementsByClassName("updatePanel2")[0].style.display = 'none';
                    document.getElementsByClassName("updatePanel3")[0].style.display = 'none';
                    document.getElementsByClassName("updatePanel4")[0].style.display = 'block';
                    document.getElementsByClassName("updatePanel5")[0].style.display = 'none';
                    document.getElementsByClassName("updatePanel6")[0].style.display = 'none';
                }
                else if(document.getElementsByTagName("select")[0].value == "speakers"){
                    document.getElementsByClassName("updatePanel")[0].style.display = 'none';
                    document.getElementsByClassName("updatePanel2")[0].style.display = 'none';
                    document.getElementsByClassName("updatePanel3")[0].style.display = 'none';
                    document.getElementsByClassName("updatePanel4")[0].style.display = 'none';
                    document.getElementsByClassName("updatePanel5")[0].style.display = 'block';
                    document.getElementsByClassName("updatePanel6")[0].style.display = 'none';
                }
                else {
                    document.getElementsByClassName("updatePanel")[0].style.display = 'none';
                    document.getElementsByClassName("updatePanel2")[0].style.display = 'none';
                    document.getElementsByClassName("updatePanel3")[0].style.display = 'none';
                    document.getElementsByClassName("updatePanel4")[0].style.display = 'none';
                    document.getElementsByClassName("updatePanel5")[0].style.display = 'none';
                    document.getElementsByClassName("updatePanel6")[0].style.display = 'block';
                }
    });

    window.addEventListener("click",function(){
        localStorage.setItem("updatePanel1_style", document.getElementsByClassName("updatePanel")[0].style.display);
        localStorage.setItem("updatePanel2_style", document.getElementsByClassName("updatePanel2")[0].style.display);
        localStorage.setItem("updatePanel3_style", document.getElementsByClassName("updatePanel3")[0].style.display);
        localStorage.setItem("updatePanel4_style", document.getElementsByClassName("updatePanel4")[0].style.display);
        localStorage.setItem("updatePanel5_style", document.getElementsByClassName("updatePanel5")[0].style.display);
        localStorage.setItem("updatePanel6_style", document.getElementsByClassName("updatePanel6")[0].style.display);
    });
});