function helloworld() {
    alert("helloworld");
}


// document functions

function element(id) {
    return document.getElementById(id);
}

function value(id) {
    return element(id).value;
}

// table functions

function addRows(tableid, rows) {
    console.log(rows);
    var table = element(tableid);
    for (var r = 0; r < rows.length; r++) {
        var row = rows[r];
        console.log(row);
        var rowObject = document.createElement("tr");
        for (var f = 0; f < rows[r].length; f++) {
            var field = row[f];
            console.log(row[r][f]);
            var fieldObject = document.createElement("td");
            fieldObject.innerText = field;
            rowObject.appendChild(fieldObject);
        }
        table.appendChild(rowObject);
    }
}

function addRow(tableid, fields) {
    var table = element(tableid);
    var row = document.createElement("tr");
    for (field in fields) {
        var fieldObject = document.createElement("td");
        fieldObject.innerText = field;
        row.appendChild(fieldObject);
    }
    table.appendChild(row);
}

function createTableFromJSON(objs) {
    console.log(objs);
    var table = document.createElement("table");

    var headingsObject = document.createElement("tr");
    var headings = Object.keys(objs[0]);
    console.log(headings);
    for (heading in headings) {
        console.log(headings[heading]);
        var headingObject = document.createElement("th");
        headingObject.innerText = headings[heading];
        headingsObject.appendChild(headingObject);
    }
    table.appendChild(headingsObject);

    for (obj in objs) {
        var row = objs[obj];
        var rowObject = document.createElement("tr");
        for (prop in row) {
            var field = document.createElement("td");
            console.log(row[prop]);
            field.innerText = row[prop];
            rowObject.appendChild(field);
        }
        table.appendChild(rowObject);
    }

    return table;
}

function createArrayFromJSON(json) {
    var array = [];
    for (field in json) {
        array.push(field);
    }
    return array;
}

function writeTable(divid, json) {
    console.log("writeTable");
    var div = element(divid);
    var table = createTableFromJSON(json);
    table.setAttribute("id", "tablein:" + divid);
    div.appendChild(table);
}


// tables meta data

function metalizeTable(tableId) {
    console.log("metalizeTable");
    var table = element(tableId);
    getJSON("/removementsMeta/user", function(meta) {
        console.log("meta:::" + meta);
        removeHeadings(table, meta);
        getJSON("/namesMeta/user", function(meta) {
            formatHeadings(table, meta);
        });
    });
    
}

function removeHeadings(table, removesMeta) {
    console.log("removeHeadings");
    console.log("removeHeadings: table = " + table);
    var rows = table.childNodes;
    var headingObjects = rows[0].childNodes;
    console.log("headingObjects: " + headingObjects);
    var removeColumns = [];
    for (a in removesMeta) {
        var removeMeta = removesMeta[a];
        for (b in headingObjects) {
            var headingObject = headingObjects[b];
            console.log("headingObject: " + headingObject);
            if (headingObject.innerText == removeMeta) removeColumns.push(b);
        }
    }
    for (a in removeColumns) {
        var removeColumn = removeColumns[a];
        for (b in rows) {
            console.log("removeHeadings.final.b: " + b);
            var row = rows[b];
            console.log("removeHeadings.final.row: " + row);
            var field = row.childNodes[removeColumn];
            row.removeChild(field);
        }
    }
}

function formatHeadings(table, namesMeta) {
    console.log("formatHeadings");
    var headingObjects = table.childNodes[0].childNodes;
    for (a in namesMeta) {
        var nameMeta = namesMeta[a];
        for (b in headingObjects) {
            var headingObject = headingObjects[b];
            if (headingObject.innerText == nameMeta.from) headingObject.innerText = nameMeta.to;
        }
    }
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

function getJSON(path, handling) {
    console.log("getJSON");
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {
            console.log("got response from: " + path);
            handling(JSON.parse(this.responseText));
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