function getJSONAsTable(url, divId, additional) {
    console.log("getJSONAsTable");
    getJSON(url, function(json) {
        writeTable(divId, json);
        metalizeTable("tablein:" + divId);
        additional();
    })
}

function addTableLink(divId, imgSrc, action) {
    console.log("addTableLink for " + divId);
    var link = document.createElement("a");
    link.href="#";
    link.onclick = action;

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