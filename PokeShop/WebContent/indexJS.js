var total = 0;
var cPokemon = [];
var cCost = [];
//ajax call to pull 151 pokemon
$.ajax({url:"http://pokeapi.co/api/v2/pokemon/?limit=151",
	success: function(data){
		 //builds table string from api call
		var tableString = "<table class='table table-hover'>" +
			"<thead>" +
					"<tr>" +
							"<th>Name</th>" +
							"<th>Price</th>" +
							"<th>Add to Cart </th>"+
					"<tr>" +
			"</thead>" +
		"<tbody>";
	//add a price for each pokemon using math.random
	//sets up id to be pokemon name
	//set up button to have onclick passing name and price
	for(var x = 0; x < data.results.length; x++){
		var num = 
			((Math.random() * 100) + 0.01).toFixed(2);
			tableString += "<tr id='" + data.results[x].name + "'>" +
					"<td>" + data.results[x].name + "</td>" +
					"<td>$" + num + "</td>" +
					"<td><button class='btn btn-success' id=\"btn" + 
						data.results[x].name + "\"onclick='addToCart(&apos;" +
						data.results[x].name.valueOf().toString() + "&#39;," +
						num + ")'> Add to Cart </button>" +
						"</td>" +
				"</tr>"
		}
		tableString += "</tbody></table>";
		//appends table to the html page
		$('#pokemon').html(tableString);
	}
});

//adds a pokemon to the cart
var addToCart = function(name, price){
	//clear cart for new entries
	$('#cart').empty();
	
    //pushes pokemon and price into arrays
	cPokemon.push(name);
	cCost.push(price);

	//creates item for the cart with remove button
	for(var y = 0; y < cPokemon.length; y++){
		$('#cart').append("<tr>" + 
						"<td>" + cPokemon[y] + "</td>" +
						"<td>" + cCost[y] + "</td>" +
						"<td>" +
					"<button class='btn btn-link' style='color:red;'" +
						"onClick='removeFromCart(&apos;" + cPokemon[y] +
						"&apos;)'> &#10060;</button></td></tr>"
					)
	}
	//increase total
	total += price;
	//change total amount on page along with css for pokemon on list
	$('#total').text("Total: $" + total.toFixed(2));
	$('#' + name).css("background-color", "yellow");
	$('#btn' + name).prop("disabled", true);

}


//remove pokemon from cart
//reactivate button
//change color back to white
removeFromCart = function(name){
	//reset list
	$("#" + name).css("background-color","white");
	$("#btn" + name).prop("disabled", false);
	
	//remove item from array and rebuild list
	for(var r = 0; r < cPokemon.length; r++){
		if(cPokemon[r] == name){
			total = total - cCost[r];
			cPokemon.splice(r,1);
			cCost.splice(r,1);
			$("#total").text("Total: $" + total.toFixed(2));
		}
		//clear div for new data
		$("#cart").empty();
		
		//create new list
		for(var a = 0; a < cPokemon.length; a++){
			$("#cart").append("<tr>" +
					"<td>" + cPokemon[a] +"</td>" +
					"<td>" + cCost[a] + "</td>" +
					"<td>" + "<button class='btn btn-link' style='color:red;'" + 
					"onClick='removeFromCart(&apos;" + cPokemon[a] + "&apos;)'>&#10060;" +
					"</button>" +
					"</td>" +
					"</tr>");
			
		}
	}
}


 

//reset page for new purchase
//checkout fn
checkout = function(){
	for(var c = 0; c  < cPokemon.length; c++){
		total = 0;
		$('#cart').empty();
		$('#total').text("Total: $");
		$("#btn"+cPokemon[c]).prop("disabled",false);
	
	}
	cPokemon=[];
	cCost=[];
}