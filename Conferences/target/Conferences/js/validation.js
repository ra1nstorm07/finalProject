function checkEmail(){
    var name = document.getElementById("email").value;
    var name_regV = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$";

    if (name.match(name_regV) == null){
     document.getElementById("email").style.border="2px solid red";
    }

    else {
     document.getElementById("email").style.border="2px solid black";
        return true;
    }
}

function checkPassword(){
    var name = document.getElementById("password").value;
    var name_regV = "(?=^.{6,}$)((?=.*\\d)|(?=.*\\W+))(?![.\\n])(?=.*[A-Za-z]).*$";

    if (name.match(name_regV) == null){
     document.getElementById("password").style.border="2px solid red";
    }

    else {
     document.getElementById("password").style.border="2px solid black";
        return true;
    }
}

function checkName(){
    var name = document.getElementById("name").value;
    var name_regV = "[A-Za-zР-пр-џ]+";

    if (name.match(name_regV) == null){
     document.getElementById("name").style.border="2px solid red";
    }

    else {
     document.getElementById("name").style.border="2px solid black";
        return true;
    }
}


function checkSurname(){
    var name = document.getElementById("surname").value;
    var name_regV = "[A-Za-zР-пр-џ]+";

    if (name.match(name_regV) == null){
     document.getElementById("surname").style.border="2px solid red";
    }

    else {
     document.getElementById("surname").style.border="2px solid black";
        return true;
    }
}

function checkAddress(){
    var name = document.getElementById("address").value;
    var name_regV = "/^[р-џ\\s.]+?\\d+/i";

    if (name.match(name_regV) == null){
     document.getElementById("address").style.border="2px solid red";
    }

    else {
     document.getElementById("address").style.border="2px solid black";
        return true;
    }
}

function checkSignUpFields() {
    if(checkEmail() && checkName() && checkSurname() && checkPassword())
        document.forms["myForm"].requestSubmit();
}

function checkLogInFields() {
    if(checkEmail() && checkPassword()){
            document.forms["myForm"].requestSubmit();
            document.getElementById("notHiddenLinks").style.display = (document.getElementById("notHiddenLinks").style.display !== "none") ? "none" : "block";
            document.getElementById("hiddenLinks").style.display = (document.getElementById("hiddenLinks").style.display !== "block") ? "block" : "none";
    }
}