function getJSONAsTable(url, divId, metaPath, additional) {
    console.log("getJSONAsTable");
    getJSON(url, function(json) {
        writeTable(divId, json);
        metalizeTable("tablein:" + divId, metaPath);
        console.log("addidtionals doing now!!!!!!");
        additional();
    })
}

function addTableLink(divId, imgSrc, actionFunctionName) {
    console.log("addTableLink for " + divId);
    var link = document.createElement("a");
    link.href="#";
    link.setAttribute("onclick", actionFunctionName + "(this.parentNode.parentNode.childNodes[0].innerText);");

    var img = document.createElement("img");
    img.src = imgSrc;
    link.appendChild(img);

    addColumn("tablein:" + divId, "", link);
}

function showUsers() {
    getJSONAsTable("/user", "users_table", "user", function() {
        addTableLink("users_table", "acc.png", "showAccounts");
    });
}

function showAccounts(userId) {
    console.log("showAccounts() called");
    showTable("account", "/account", userId, "showTransactions", "trans+mreq.png");
}

function helloworld() {
    console.log("action did");
}

function showTransactions(accountId) {
    var div = element("transactions_table");
    var heading = document.createElement("h2");
    heading.innerText = "Transactions of " + accountId;
    div.innerHTML="";
    div.appendChild(heading);

    getJSONAsTable("/transaction/" + accountId, "transactions_table", "transaction", function(){});
}

function showTable(name, mapping, id, linkingFunctionName, imgSrc) {
    console.log("linkingFunctionName: " + linkingFunctionName);
    var divId = name + "s_table";
    console.log(divId);
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