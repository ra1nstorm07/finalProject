window.addEventListener("load",function(){
    if(localStorage.getItem("hiddenLinksStyle"))
        document.getElementById("hiddenLinks").style.display = localStorage.getItem("hiddenLinksStyle");
    if(localStorage.getItem("notHiddenLinksStyle"))
        document.getElementById("notHiddenLinks").style.display = localStorage.getItem("notHiddenLinksStyle");

    for (var i = 0; i < document.getElementsByClassName('changeOnClick').length; i++){
        document.getElementsByClassName('changeOnClick')[i].addEventListener('click', function () {
            document.getElementById("notHiddenLinks").style.display = (document.getElementById("notHiddenLinks").style.display !== "none") ? "none" : "block";
            document.getElementById("hiddenLinks").style.display = (document.getElementById("hiddenLinks").style.display !== "block") ? "block" : "none";
        }, false);
    }

    window.addEventListener("click",function(){
        localStorage.setItem("hiddenLinksStyle", document.getElementById("hiddenLinks").style.display);
        localStorage.setItem("notHiddenLinksStyle", document.getElementById("notHiddenLinks").style.display);
    }); // перезаписываем страницу при каждом клике
});

function displayBlock1() {
    document.getElementById("hidden").style.display = 'block';
    document.getElementById("hiddenWindow").style.display = 'block';
}

function displayBlock2() {
    document.getElementById("hidden").style.display = 'block';
    document.getElementById("hiddenWindow2").style.display = 'block';
}

function displayBlock3() {
    document.getElementById("hidden").style.display = 'block';
    document.getElementById("hiddenWindow3").style.display = 'block';
}

function close_window() {
    document.getElementById("hidden").style.display = 'none';
    document.getElementById("hiddenWindow").style.display = 'none';
    document.getElementById("hiddenWindow2").style.display = 'none';
    document.getElementById("hiddenWindow3").style.display = 'none';
}