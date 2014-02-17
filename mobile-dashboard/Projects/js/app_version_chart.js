function getApplicationVersionData(view, dataType)
{
    var request = $.ajax({
    url: "http://127.0.0.1:5984/proto2/_design/app_version/_view/all",
    crossDomain: true,
    dataType: 'jsonp',

    contentType:'application/json',
    success:function(data){
                    applicationVersionChart(data, view);
        return data;
    },
    error: function(data, str, errorThrown){
        console.log(data.responseText+ "\n");
        console.log(str + "\n")
        var obj = jQuery.parseJSON(data.responseText);
    }
    });    
}

function applicationVersionChart(installedVersionData, view)
{
    // this returns 
    // {"Android 4.4": {date:count, date2:count2},
    // "Android 4.3": {date:count, date2:count2},...}
    var hashTable = splitByKeysToHash(installedVersionData, view);

    // data for chart series
    var seriesArray = [];
    // for the series name
    var seriesArrayName = [];

    // Need to loop through and pupulate the seriesArray from the hash
    for (var i in hashTable)
    {
        // i is the hash key "Android ersion 4.4"
        var currentHash = hashTable[i];
        var tempArray = [];
        // pull out the object from that parent object
        for (var j in currentHash)
        {
            tempArray.push([createNewDate(j), parseInt(currentHash[j])])
        }
        // push the key "Android 4.4" as the series name
        seriesArrayName.push(i);
        // push an array into the series data array
        seriesArray.push(tempArray);
    }

    // formulate the series for the chart
    var seriesData = [];
    for(var k in seriesArray)
    {
        seriesData.push({type:'scatter',
                    //name: view.friendlyName,
                    name: seriesArrayName[k],
                    data: seriesArray[k]});
    }

    $('#container').highcharts({
                title: {
                    text: view.friendlyName + " by WD Application Version",
                    x: -20 //center
                },
                subtitle: {
                    text: view.description,
                    x: -20
                },
                xAxis: {
                    //categories: parsedDataDateAsCatagories
                    type: 'datetime',
                    tickInterval: 4 * 7 * 24 * 36e5, // one week
                    labels: {
                        format: '{value:# %b/%Y}',
                    }
                },
                yAxis: {
                    min:0,
                    title: {
                        text: 'Total #'
                    },
                    plotLines: [{
                        value: 0,
                        width: 1,
                        color: '#808080'
                    }]
                },
                // Tooltip formatter
                tooltip: {
                    formatter: function() {
                        return  '<b>' + this.series.name +'</b><br/>' +
                            Highcharts.dateFormat('%e %b, %Y',
                                                  new Date(this.x))
                        + '  <br/>' + (this.series.name == 'App Version' ? "Version:": "Total:") + this.y + ' ';
                    }
                },
                // Does the area coverage shading
                plotOptions: {
                    area: {
                        fillColor: {
                            linearGradient: { x1: 0, y1: 0, x2: 0, y2: 1},
                            stops: [
                                [0, Highcharts.getOptions().colors[0]],
                                [1, Highcharts.Color(Highcharts.getOptions().colors[0]).setOpacity(0).get('rgba')]
                            ]
                        }
                    }
                },
                series: seriesData
            });
}