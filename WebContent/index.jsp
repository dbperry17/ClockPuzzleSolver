<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>FFXIII-2 Clock Puzzle Solver</title>
<script type="text/javascript" src='resources/js/jquery-3.5.1.min.js'></script>
<script type="text/javascript">
    var jsArray = [];
	
    function printArray()
    {
        document.getElementById('numList').innerHTML = jsArray;
        console.log("New Array: " + jsArray);
    }
    
    function storeVar(btn)
	{
		var amount = btn.value;
		console.log("New number: " + amount);
		jsArray.push(amount);
		
		printArray();
	}
    
    function deleteLast()
    {
        console.log("Deleted number: " + jsArray.pop());
        printArray();
    }
    
    function restart()
    {
    	jsArray = [];
    	console.log("\nNew List")
    	printArray();
    }
</script>
</head>
<body>
    <script>
        
    </script>
    <h1>Clock Puzzle Solver for FFXIII-2</h1>
    <button type="button" class='btn' id='btn1' onclick='storeVar(this)' value='1'>1</button>
    <button type="button" class='btn' id='btn2' onclick='storeVar(this)' value='2'>2</button>
    <button type="button" class='btn' id='btn3' onclick='storeVar(this)' value='3'>3</button>
    <button type="button" class='btn' id='btn4' onclick='storeVar(this)' value='4'>4</button>
    <button type="button" class='btn' id='btn5' onclick='storeVar(this)' value='5'>5</button>
    <button type="button" class='btn' id='btn6' onclick='storeVar(this)' value='6'>6</button>
    <p><button type="button" class='btn' id='btnDel' onclick='deleteLast()'>Delete last number</button>
    <button type="button" class='btn' id='btnRes' onclick='restart()'>Clear</button></p>
    <form action="helloServlet" method="post">
        <input type="submit" value="Call Servlet" />
    </form>
    
    <p id='numList'>Your numbers will appear here.</p>
</body>
</html>