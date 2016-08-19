/**
 * addClaim.js
 */


$(document).ready(function(){
	$("#amount").keyup(function(){
		var moneyTest = /^\d*(\.\d{2})$/;
		var amount = $("#amount").val();
		var valid = true;
		
		valid = moneyTest.test(amount);
		
		if(amount == null|| amount < 0 || valid == false || amount.length > 38){
			$("#amountV").text("Invalid numeric entry. Make sure to use decimal point.");
			$("#amountV").css("color","red");
			$("#addBtn").attr("disabled", true);
		}else{
			$("#amountV").text("");
			$("#addBtn").attr("disabled", false);
		}
	})
});

//$(document).ready(function(){
//	$("#desc").keyup(function(){
//		var desc = $("#desc").val();
//		var limit = desc.length;
//		
//		if(limit >= 250 || limit < 0 || limit == null){
//			$("#descV").text("Exceeded limit.");
//			$("#descV").css("color", "red");
//			$("#addBtn").attr("disabled", true);
//			
//		}else{
//			$("#descV").text("");
//			$("#addBtn").attr("disabled", false);
//		}
//	})
//});


