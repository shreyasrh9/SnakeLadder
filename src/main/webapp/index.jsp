<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/js/bootstrap.min.js" integrity="sha384-vBWWzlZJ8ea9aCX4pEW3rVHjgjt7zpkNpZk+02D9phzyeVkE+jo0ieGizqPLForn" crossorigin="anonymous"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css" integrity="sha384-rwoIResjU2yc3z8GV/NPeZWAv56rSmLldC3R/AZzGRnGxQQKnKkoFVhFQhNUwEyJ" crossorigin="anonymous">
<script type="text/javascript" src="js/jquery.dice.js"></script>    
<style type="text/css">
.Rectangle-2 {
	height: auto;
	margin-top: 10px;
	border-radius: 5px;
	background-color: #ffffff;
	box-shadow: -2px -2px 12.5px 0 rgba(0, 0, 0, 0.5);
}
.Welcome-Screen {
	/* background-color: #f1ece1; */
	background: #f5f5f5 url(images/subtle_white_feathers.png)
}
.WelcomeNav{
	background: #f5f5f5 url(images/dark-pattern-backgrounds-wallpaper-2.jpg)
}

#dice{
	background: #f5f5f5 url(images/dark-pattern-backgrounds-wallpaper-2.jpg)
}
.Oval {
	width: 30px;
	height: 39.8px;
	background-color: #6bc5ce;
	box-shadow: 0 1px 2px 0 rgba(0, 0, 0, 0.5), inset 0 0.5px 1.5px 0
		rgba(0, 0, 0, 0.5);
	border: solid 0.5px #979797;
}
.Oval-2 {
	width: 15px;
	height: 15px;
	background-color: #c0d8be;
	border: solid 0.5px #979797;
}
.Adds {
	background-color: white;
	margin-top: 10px;
	border-left: 1px solid lightblue;
	margin-left: 10px;
	box-shadow: -2px -2px 12.5px 0 rgba(0, 0, 0, 0.5);
	border-radius: 5px;
}
.nav-link{
	color: white !important;
}
.navbar-light .navbar-toggler-icon{
	background-image: url(images/Combined Shape_nav.svg)
}

.square {
  width: 40%;
}

.square:after {
  content: "";
  display: block;
  padding-bottom: 100%;
}

.content {
  width: 25%;
  height: 30%;
  border: solid;
}

.flex-container li {
  list-style: none;
  width: 10%;
  float: left;
  height: 80px;
  box-sizing: border-box;
  border: 2px solid #fff;
  background: #ccc
}

* {
  margin: 0;
  padding: 0;
}
html, body, .wrappers, .flex-container {
  height: 100%
}
</style>    
    
</head>
<body class="Welcome-Screen">
<nav class="WelcomeNav navbar navbar-toggleable-md navbar-light bg-faded">
  <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <a class="navbar-brand" href="#">Navbar</a>
  <div class="collapse navbar-collapse" id="navbarNav">
    <ul class="navbar-nav">
      <li class="nav-item active">
        
      </li>
</ul>    
  </div>
</nav>

<div class="container-fluid">
  <div class="row">
  <div class="Rectangle-2 col col-sm-8">
  
	
 
    <div style="text-align: center;" ><img src="images/Combined Shape.svg" style="margin-top: -10px;"/>

					<div id="eventFormRow" class="row">
						<!-- Third row after page header -->
						<div class="col-lg-12">
							<div class="panel panel-default" style="">
								<div class="panel-heading" style="font-weight: bold;">Sanek
									& Ladder</div>
								<div class="panel-body">

									<div class="form-group">
										<div class="row" style="margin-top: 2em">


											<div class="col-xs-4" id="from_column">
												<label class="control-label">Number of squares</label> <input
													id="numberOfSquares" type="number" data-toggle="tooltip"
													title="Should be divisible by 3 and be a multiple of 10" />

												<button type="button" onclick="generateGameBoard()"
													class="btn btn-success">Generate Game Board</button>

											</div>
										</div>
									</div>

								</div>
							</div>
						</div>
					</div>


<div class="wrappers">
        <ul id="gameBoard" class="flex-container">
            
        </ul>
    </div>







				</div>
  </div>
   <div class="Adds col-sm-3" style="">                        
   		       <h1>Click below!</h1>
		<div id="dice" style="width:300px; height:400px; border:solid 1px black;"></div>
		
		<br />
		<button type="button" id="btn_roll">Roll the dice to </button>
		<input type="text" id="rollValue" value = "5" />
		or
		<button type="button" id="btn_randRoll">Random!</button>
		
		<input id="test" type = "text"/>
   </div>
</div>
  
</div><!-- /.container -->


<script type="text/javascript">
		
			$(function(){
				$("#dice").dice();
				$("#dice, #btn_randRoll").click(function(){
					$("#dice").dice("roll");
					
					
				});
				$("#btn_roll").click(function(){
					$("#dice").dice("roll", $("#rollValue").val());
				});
				$("#btn_setSize").click(function(){
					$("#dice").dice("option", {diceSize:$("#dsize").val()});
				});
				
			});
			
			
	function generateGameBoard() {
		var num = $('#numberOfSquares').val();

		if (num % 3 != 0 && num % 10 != 0) {
			if (num % 2 != 0) {
				alert("Only even multiples of 10 and divisible by 3 is  allowed.");
			}
			return;
		}
		$.ajax({
			contentType : 'application/json;charset=UTF-8',
			url : '/SnakeLadder/gameBoard/' + $('#numberOfSquares').val(),
			type : 'GET',
			cache : false, // Force requested pages not to be cached by the browser

			success : function(response) {
				console.log(response);

				console.log(response.gameHtml);

				$('#gameBoard').html(response.gameHtml);
			}
		});
	}
</script>
</body>
</html>
