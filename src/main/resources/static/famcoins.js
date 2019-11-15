function getJSONAsTable(url, divId, metaPath, additional) {
    getJSON(url, function(json) {
        writeTable(divId, json);
        metalizeTable("tablein:" + divId, metaPath);
        
        var div = element(divId);
        div.className = "border";

        var table = element("tablein:" + divId);
        if (table.childNodes.length == 0) {
            div.removeChild(table);
            var warning = document.createElement("span");
            warning.className = "border warning";
            warning.innerText = "Nothing to show!";
            div.appendChild(warning);
        } else additional();
    })
}

function addTableLink(divId, imgSrc, actionFunctionName) {
    var link = document.createElement("a");
    link.href="#";
    link.setAttribute("onclick", actionFunctionName + "(this.parentNode.parentNode.childNodes[0].innerText);");

    var img = document.createElement("img");
    img.src = imgSrc;
    link.appendChild(img);

    addColumn("tablein:" + divId, "", link);
}

function showTable(name, mapping, id, linkingFunctionName, imgSrc) {
    var divId = name + "s_table";
    var div = element(divId);
    var heading = document.createElement("h2");
    heading.innerText = makeUpperCase(name) + "s of " + id;
    div.innerHTML = "";
    div.appendChild(heading);

    var linking = function() {
        addTableLink(name + "s_table", imgSrc, linkingFunctionName);
    }

    getJSONAsTable(mapping + "/" + id, divId, name, linking);
}

function makeUpperCase(str) {
    return str[0].toUpperCase() + str.slice(1);
}