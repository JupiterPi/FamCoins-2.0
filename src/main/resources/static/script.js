function showUsers() {
    getJSONAsTable("/user", "users_table", "user", function() {
        addTableLink("users_table", "acc.png", "showAccounts");
    });
}

function showAccounts(userId) {
    showTable("account", "/account", userId, "showTransactionsAndMoneyRequests", "trans+mreq.png");
}

function showTransactionsAndMoneyRequests(accountId) {
    showTransactions(accountId);
    showMoneyRequests(accountId);
}

function showTransactions(accountId) {
    var div = element("transactions_table");
    var heading = document.createElement("h2");
    heading.innerText = "Transactions of " + accountId;
    div.innerHTML="";
    div.appendChild(heading);

    getJSONAsTable("/transaction/" + accountId, "transactions_table", "transaction", function(){});
}

function showMoneyRequests(accountId) {
    var div = element("moneyrequests_table");
    var heading = document.createElement("h2");
    heading.innerText = "Money Requests of " + accountId;
    div.innerHTML="";
    div.appendChild(heading);

    getJSONAsTable("/moneyrequest/" + accountId, "moneyrequests_table", "moneyrequest", function(){});
}