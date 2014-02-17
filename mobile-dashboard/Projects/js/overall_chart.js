function getOverallData(view, dataType)
{
    var request = $.ajax({
    url: "http://127.0.0.1:5984/proto2/_design/overall/_view/" + view.viewKey,
    crossDomain: true,
    dataType: 'jsonp',

    contentType:'application/json',
    success:function(data){
                    overallChart(data, view);

        return data;
    },
    error: function(data, str, errorThrown){
        console.log(data.responseText+ "\n");
        console.log(str + "\n")
        var obj = jQuery.parseJSON(data.responseText);
    }
    });    
}

function overallChart(installedVersionData, view)
{console.log("******* view: " + view.viewKey);
    var hashTable = dedup(installedVersionData, view);

    var parsedDataDateAsCatagories = []; 
    var parsedDataDateUTCAsCatagories = []; 
    var parsedDataCurrentDeviceInstalls = [];
    var arr = installedVersionData.rows;
    for(var i in hashTable)
    {
        parsedDataDateAsCatagories.push(i);
        var date = createNewDate(i);
        var dataPointObj = hashTable[i];
        var dataPoint = parseInt(dataPointObj);
        parsedDataCurrentDeviceInstalls.push([date, dataPoint]);
    }


$('#container').highcharts({
            title: {
                text: view.friendlyName,
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
            series: [{
                type:'area',
                name: view.friendlyName,
                data: parsedDataCurrentDeviceInstalls
                /*,
                            pointStart: Date.UTC(2012, 0, 6),
                    pointInterval: 24 * 3600 * 1000 // one day
                    */
            },
            {   
                name: "App Version",
                type: 'scatter',
                data: publicationDates,
                marker: {
                        radius: 5
                    }
            }
            ]
        });
}