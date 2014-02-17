function createNewDate(str)
{
    if(str)
    {
        return Date.UTC(str.substr(0,4), (str.substr(4,2)-1), str.substr(6,2));
    }

}
function dedup(dataObj, view)
{
    var localHash = {};
    for(var i=0; i < dataObj.rows.length; i++)
    {
        if(!localHash[dataObj.rows[i].key])
        {
           localHash[dataObj.rows[i].key] = dataObj.rows[i].value[view.viewKey];
        }
    }
    return localHash;   
}

function splitByKeysToHash(dataObj, view)
{
    var localHash = {};
    // splits a flat json with key embedded with
    // date and key, ie "20140104:Android 4.2" 
    for(var i=0; i < dataObj.rows.length; i++)
    {
        var key = dataObj.rows[i].key;
        var keys = key.split(":");
        console.log("Keys " + keys[0] + ":" + keys[1]);
        if(!localHash[keys[1]])
        {
            localHash[keys[1]] = {};
        }
            var date = keys[0];
            var data = dataObj.rows[i].value[view.viewKey];
            var obj = localHash[keys[1]];
            obj[date] = data;
    }
    return localHash
}