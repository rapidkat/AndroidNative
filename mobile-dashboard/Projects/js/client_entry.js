window.onload = function()
{
    getOverallData(summaryCharts["current_device_installs"], dataType.overall);

    // Register click handlers   
    $("#current_device_installs").click(function() {
        // clear chart 
      getOverallData(summaryCharts["current_device_installs"], dataType.overall);
        //
    });

    $( "#daily_device_installs" ).click(function() {

        getOverallData(summaryCharts["daily_device_installs"], dataType.overall);

    });
    $( "#current_user_installs" ).click(function() {

        getOverallData(summaryCharts["current_user_installs"], dataType.overall);

    });

    $( "#daily_device_uninstalls" ).click(function() {

        getOverallData(summaryCharts["daily_device_uninstalls"], dataType.overall);

    });
    $( "#daily_device_upgrades" ).click(function() {

        getOverallData(summaryCharts["daily_device_upgrades"], dataType.overall);

    });

    $( "#daily_user_installs" ).click(function() {

        getOverallData(summaryCharts["daily_user_installs"], dataType.overall);

    });

    $( "#daily_user_uninstalls" ).click(function() {

        getOverallData(summaryCharts["daily_user_uninstalls"], dataType.overall);

    });

    $( "#total_user_installs" ).click(function() {

        getOverallData(summaryCharts["total_user_installs"], dataType.overall);

    });

    $( "#current_user_android_os" ).click(function() {

        getOsData(summaryCharts["current_device_installs"], dataType.androidVersion);

    });

    $( "#current_user_app_version" ).click(function() {

        getApplicationVersionData(summaryCharts["current_device_installs"], dataType.applicationVersion);

    });




    $( "#Devices" ).click(function() {
        alert( "Handler for .click() called." );
    });

}
