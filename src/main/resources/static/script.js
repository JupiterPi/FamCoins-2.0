function getJSONAsTable(url, divId, additional) {
    console.log("getJSONAsTable");
    getJSON(url, function(json) {
        writeTable(divId, json);
        metalizeTable("tablein:" + divId);
        console.log("addidtionals doing now!!!!!!");
        additional();
    })
}

function addTableLink(divId, imgSrc, action) {
    console.log("addTableLink for " + divId);
    var link = document.createElement("a");
    link.href="#";
    link.onclick = action;
    console.log("action:::" + action);

    var img = document.createElement("img");
    img.src = imgSrc;
    link.appendChild(img);

    addColumn("tablein:" + divId, "", link);
}

function showUsers() {
    getJSONAsTable("/user", "users_table", function() {
        addTableLink("users_table", "acc.png", function() {showAccounts(this.parentNode.parentNode.childNodes[0].innerText);});
    });
}

function showAccounts(userId) {
    var div = element("accounts_table");
    var heading = document.createElement("h2");
    heading.innerText = "Accounts of " + userId;
    div.innerHTML="";
    div.appendChild(heading);

    getJSONAsTable("/account/" + userId, "accounts_table", function() {
        var action = function() {
            showTransactions(this.parentNode.parentNode.childNodes[0].innerText);
        }
        addTableLink("accounts_table", "trans+mreq.png", action);
    });
}

function showTransactions(accountId) {
    var div = element("transactions_table");
    var heading = document.createElement("h2");
    heading.innerText = "Transactions of " + accountId;
    div.innerHTML="";
    div.appendChild(heading);

    getJSONAsTable("/transaction/" + accountId, "transactions_table", function(){});
}

function showTable(name, mapping, id, linkingFunction, imgSrc) {
    var divId = name + "s_table";
    console.log(divId);
    var div = element(divId);
    var heading = document.createElement("h2");
    heading.innerText = makeUpperCase(name) + "s of " + id;
    div.innerHTML = "";
    div.appendChild(heading);

    var linking = function() {
        console.log("linking dig mit test: " + name);
        var action = function() {
            console.log("action did");
            linkingFunction(this.parentNode.parentNode.childNodes[0].innerText);
        }
        addTableLink(name + "s_table", imgSrc, action);
    }

    getJSONAsTable(mapping + "/" + id, divId, linking);
}

function makeUpperCase(str) {
    return str[0].toUpperCase() + str.slice(1);
}