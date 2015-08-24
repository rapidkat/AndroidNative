var dataType = {"overall":"overall", "androidVersion":"os", "applicationVersion":"ApplicationVersion"};

var summaryCharts = [];
summaryCharts["current_device_installs"] = {"viewKey":"current_device_installs", "friendlyName" : "Current Device Installs", "description":" the number of active devices on which the application is currently installed - it excludes any devices where the application was uninstalled or any devices that are no longer active."};
summaryCharts["daily_device_installs"] = {"viewKey":"daily_device_installs", "friendlyName" : "Daily Device Installs", "description" : "the number of new devices on which the app was installed for the first time during that day."};
summaryCharts["current_user_installs"] = {"viewKey":"current_user_installs", "friendlyName" : "Current User Installs", "description" :"the number of users who have the app currently installed on at least one active device."};
summaryCharts["daily_device_uninstalls"] = {"viewKey":"daily_device_uninstalls", "friendlyName" : "Daily Device Uninstalls", "description" :"the number of unique devices which uninstalled the app in the past day."};
summaryCharts["daily_device_upgrades"] = {"viewKey":"daily_device_upgrades", "friendlyName" : "Daily Device Upgrades", "description" :"the number of unique devices upgraded from an older version to the latest version of the app in the past day."};
summaryCharts["daily_user_installs"] = {"viewKey":"daily_user_installs", "friendlyName" : "Daily User Installs", "description" :" the number of unique users who installed this app for the the first time during that day."};
summaryCharts["daily_user_uninstalls"] = {"viewKey":"daily_user_uninstalls", "friendlyName" : "Daily User Uninstalls", "description" :"the number of unique users who uninstalled the app from all devices during that day."};
summaryCharts["total_user_installs"] = {"viewKey":"total_user_installs", "friendlyName" : "Total User Installs", "description" :"the total number of unique users that have ever installed this app. We only count one install regardless of how many different devices they installed it on. It includes the users who have later uninstalled the app."};

var publicationDates = [];
publicationDates.push([createNewDate("20130529"), 1]);
publicationDates.push([createNewDate("20130622"), 2]);
publicationDates.push([createNewDate("20130727"), 3]);
publicationDates.push([createNewDate("20131121"), 4]);
publicationDates.push([createNewDate("20131123"), 5]);
publicationDates.push([createNewDate("20131123"), 7]);
publicationDates.push([createNewDate("20140101"), 8]);
