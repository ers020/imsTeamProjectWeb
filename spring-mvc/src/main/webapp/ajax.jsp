<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
</head>
<body>
<div class="container container-fluid">
	<div>
	<h2>Add Person</h2>
		Name: <input id="name" type="text" /><br/>
		Age: <input id="age" type="text" /><br/>
		Email: <input id="email" type="text" /><br/>
		<input id="add" type="button" value="Add" /><br />
	</div>
	<div>
	<h2>Peeps</h2>
		<table id="peeps" class="table table-hover">
			<tr>
				<th>Name</th><th>Age</th><th>Email</th>
			</tr>
		</table>
	</div>
</div>
</body>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){

	setInterval(function(){
		$.ajax({
			//add accept header... funny.
			headers:{"Accept" : "application/json"},
			url:"http://localhost:7001/spring-mvc/getAll.do",
			method:"GET",
			success: function(resp){
				$("#peeps").html("<tr><th>Name</th><th>Age</th><th>Email</th></tr>");
				$.each(resp, function(i, item){
					$("#peeps").append(
					"<tr><td>" 		+ item.name
					+ "</td><td>" 	+ item.age 
					+ "</td><td>" 	+ item.email 
					+ "</td></tr>");
				});
			}
			
		});
	}, 10000);

	$("#Add").click(function(){
		var name = $("#name").val();
		var age = $("#age").val();
		var email = $("#email").val();
		$("#name").val("");
		$("#age").val("");
		$("#email").val("");
		
		$.ajax({
			//add "content-type" header to say application/json
			headers: {
				"Content-Type": "application/json; charset=utf-8"	
			},
			url:"http://localhost:7001/spring-mvc/insert.do",
			method:"POST",
			data:JSON.stringify({name : name, age : age, email : email}),
			success: function(){
				alert("Added person successfully!");
			}
		});
		
		});
});
</script>
</html>