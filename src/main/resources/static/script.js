function getJSONAsTable(url, divId) {
    getJSON(url, function(json) {
        writeTable(divId, json);
    })
}