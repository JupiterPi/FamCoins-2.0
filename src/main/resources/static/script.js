function getJSONAsTable(url, divId) {
    console.log("getJSONAsTable");
    getJSON(url, function(json) {
        writeTable(divId, json);
        metalizeTable("tablein:" + divId);
    })
}