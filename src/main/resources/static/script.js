function helloworld() {
    get("/helloworld", function(msg) {
        element("out").innerText = msg;
    });
}


// document functions

function element(id) {
    return document.getElementById(id);
}

function value(id) {
    return element(id).value;
}

// http.js

function get(path, handling) {
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {
            handling(this.responseText);
        }
    }
    xhttp.open("GET", path);
    xhttp.send();
}

function post(path) {
    var xhttp = new XMLHttpRequest();
    xhttp.open("POST", path);
    xhttp.send();
}

function hyperlink(url) {
    window.location.href = url;
}