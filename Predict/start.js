var $ = require("cheerio");
var fs = require('fs')

var htmlString = fs.readFileSync('index.html').toString();

var parsedHTML = $.load(htmlString)

// query for all elements with class 'foo' and loop over them
/*
parsedHTML('.tag_even > tr > td > a > span').map(function(i, foo) {
  // the foo html element into a cheerio object (same pattern as jQuery)
	foo = $(foo);

	console.log(foo.text());
});
*/
var finalHash = {};

parsedHTML('.tag_even > tr').map(function(i, foo) {
  // the foo html element into a cheerio object (same pattern as jQuery)
	foo = $(foo);
	var stringOfNumbers = foo.text();
	//console.log(stringOfNumbers);
	var counter = 0;
	var arrayToParse = stringOfNumbers.split("-").map(function(val){
		counter++;
		//console.log(counter + "\n");
		//console.log(val + "\n");
		if(counter % 2 == 0)
		{
			var newValue = val.match(/\d+/g);
			console.log("Str length:" + newValue.length + "\n");
			finalHash[newValue[0]+""] = {"numbers":newValue[1], "mega" : newValue[2]}			
		}
		// now parse 5 numbers and the final value.
	})
})

for (i in finalHash)
{
	var localObj = finalHash[i];
	console.log("Draw number: "+ i + " num:" + localObj.numbers + " mega: " + localObj.mega);
}

// Now lets get the frequency of numbers.
var megaHash = {};
var winningHash = {};
for (i in finalHash)
{
	var localObj = finalHash[i];
	console.log("Draw number: "+ i + " num:" + localObj.numbers + " mega: " + localObj.mega);
	// Mega Frequency
	if(!megaHash[localObj.mega])
	{
		megaHash[localObj.mega] = 1;	
	} 
	else
	{
		megaHash[localObj.mega]++;
	}

	// Winning numbers frequency
	var winningNumbersStr = localObj.numbers;
	var win1 = [];
	win1.push(winningNumbersStr.substr(0,2));
	win1.push(winningNumbersStr.substr(2,2));
	win1.push(winningNumbersStr.substr(4,2));
	win1.push(winningNumbersStr.substr(6,2));
	win1.push(winningNumbersStr.substr(8,2));

	for(var i=0; i<win1.length; i++)
	{
		console.log(win1[i] + "\n");
		if(!winningHash[win1[i]])
		{
			winningHash[win1[i]] = 1;	
		} 
		else
		{
			winningHash[win1[i]]++;
		}		
	}
}

for(i in megaHash)
{
	console.log("Mega Number: " + i + " frequency: " + megaHash[i]);
}

for(i in winningHash)
{
	console.log("Winning Number: " + i + " frequency: " + winningHash[i]);
}


