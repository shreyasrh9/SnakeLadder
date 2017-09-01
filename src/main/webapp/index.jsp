<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/js/bootstrap.min.js" integrity="sha384-vBWWzlZJ8ea9aCX4pEW3rVHjgjt7zpkNpZk+02D9phzyeVkE+jo0ieGizqPLForn" crossorigin="anonymous"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css" integrity="sha384-rwoIResjU2yc3z8GV/NPeZWAv56rSmLldC3R/AZzGRnGxQQKnKkoFVhFQhNUwEyJ" crossorigin="anonymous">


<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/css/toastr.css">

<link rel="stylesheet" type="text/css" href="http://ajax.aspnetcdn.com/ajax/jquery.dataTables/1.9.4/css/jquery.dataTables.css">

<script type="text/javascript" charset="utf8" src="http://ajax.aspnetcdn.com/ajax/jquery.dataTables/1.9.4/jquery.dataTables.min.js"></script>

<script src="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/js/toastr.min.js"></script>




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

ul li{
  display: inline;
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
								<div class="panel-heading" style="font-weight: bold;">Snake
									& Ladder</div>
								<div class="panel-body">

									
									
									
									
									<div class="form-group">
										<div class="row" style="margin-top: 2em">	
											<div class="col-xs-4" style="margin-left: 13%;">
												<div class="form-group">
													<label>Number of squares</label> <input id="numberOfSquares"
														type="number" class="form-control">
												</div>
											</div>
											
											<div class="col-xs-4" style="margin-left:10px">
												<div class="form-group">
													<label>Memory square</label> <input id="memorySquare"
														type="text" class="form-control">
												</div>
											</div>
											
											
											<div class="col-xs-4" style="margin-left:10px">
												<div class="form-group">
													<label>Magic square</label> <input id="magicSquare"
														type="text" class="form-control">
												</div>
											</div>
											
											
											


										</div>
									</div>
									
									
									<div class="form-group">
										<div class="row" style="margin-top: 2em">	
											<div class="col-xs-4" style="margin-left: 13%;">
												<div class="form-group">
													<label>Trampoline square</label> <input id="trampolineSquare"
														type="text" class="form-control">
												</div>
											</div>
											
											<div class="col-xs-4" style="margin-left:10px">
												<div class="form-group">
													<label>Elevator square</label> <input id="elevatorSquare"
														type="text" class="form-control">
												</div>
											</div>
											
											
											<div class="col-xs-4" style="margin-left:10px">
												<div class="form-group">
													<label>Pitstop square</label> <input id="pitStopSquare"
														type="text" class="form-control">
												</div>
											</div>
											
											
											


										</div>
									</div>
									

									<div class="form-group">
										<div class="row" style="margin-top: 2em">	
											<div class="col-xs-4" id="snake_input_fields_wrap" style="margin-left: 26%;">
												<div class="title-action">
													<label class="error" id="snakeError" style="display: none;">Remove
														from descending order.</label> <a href="#"
														 onclick="addSnakes(); return false;"
														class="btn btn-primary">Add Snake</a>
												</div>
												<div class="form-group">
													<label>Snake 1</label> <input id="snake1" name="snake[]"
														type="text" class="form-control">
												</div>
											</div>
											
											
											
											<div class="col-xs-4" id="ladder_input_fields_wrap" style="margin-left:10px">
												<div class="title-action">
													<label class="error" id="ladderError" style="display: none;">Remove
														from descending order.</label> <a href="#"
														onclick="addLadders(); return false;"
														class="btn btn-primary">Add Ladder</a>
												</div>
												<div class="form-group">
													<label>Ladder 1</label> <input id="ladder1" name="ladder[]"
														type="text" class="form-control">
												</div>
											</div>

											
										</div>
									</div>
<button type="button" onclick="generateGameBoard()"
													class="btn btn-success">Generate Game Board</button>
								</div>
							</div>
						</div>
					</div>

<span id="p1Magic" style="color:red"></span>
<span id="p2Magic" style="color:red"></span>

<div class="wrappers" id="gameBoard">
        
    </div>







				</div>
  </div>
   <div class="Adds col-sm-3" style="">                        
   		       <h1>Click below!</h1>
		<div id="dice" style="width:300px; height:400px; border:solid 1px black;"></div>
		
		<br />
		<button type="button" id="btn_roll" onclick="diceRolled()">Roll the dice to </button>
		<input type="text" id="rollValue" value = "5" />
		or
		<button type="button" id="btn_randRoll" onclick="diceRolled()">Random!</button>
		
		<input id="test" type = "text" />
   

		
		<h1>Player1 details</h1>
			<span id="p1En" style="color:green"></span>
				<table id="p1Details">
					<thead>
						<tr style="font-size: 14px;">
							<th>#</th>
							<th>Position</th>
						</tr>
					</thead>

					<tbody id="p1DetailsBody" style="font-size: 12px;">
						
					</tbody>	
				</table>
				
				<h1>Player2 details</h1>
				<span id="p2En" style="color:green"></span>
				<table id="p2Details">
					<thead>
						<tr style="font-size: 14px;">
							<th>#</th>
							<th>Position</th>
						</tr>
					</thead>

					<tbody id="p2DetailsBody" style="font-size: 12px;">
						
					</tbody>	
				</table>
   </div>
   
   
      <div class="Adds col-sm-3" style="">                        
   		       
   	  </div>
   	  
   	  <div class="Adds col-sm-3" style="">                        
   		       
   	  </div>
   
   
   
</div>
  
</div><!-- /.container -->


<script type="text/javascript">

var snake = [];
var ladder = [];
var gameModel;
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
				
				
				
				$('#numberOfSquares').val("64");

				$('#memorySquare').val("6,4");
				$('#magicSquare').val("10,6");
				$('#trampolineSquare').val("12,5");
				$('#elevatorSquare').val("14,9");
				$('#pitStopSquare').val("16-5,56-8");
				$('#snake1').val("22 8-4~39 28-6");
				$('#ladder1').val("7 54~15 48");
				
				$('#p1Details').dataTable();
				
				$('#p2Details').dataTable(); 
				
			});
			
	var snakeNext = 1;	
	function addSnakes() {
	            console.log("add more stages "+snakeNext);
	            snakeNext = snakeNext + 1;
	            //if(x < max_fields){ //max input box allowed
	               // x++; //text box increment
	                var htmld = "<div class='form-group' id='snakeDiv"+snakeNext+"'>";
	                		htmld += "<label>Snake "+snakeNext+"</label>";                    	                                  
	                		htmld += "<div class='input-group'><input id='snake"+snakeNext+"' name='snake[]' type='text' class='form-control'>";	
	                		htmld += "<span class='input-group-btn'><button class='btn btn-danger btn-remove' onclick='removeSnakeStage("+snakeNext+")' type='button'>";
	                			htmld += "<span class='glyphicon glyphicon-minus'></span>";
	                		htmld += "</button></span></div>";
	                	htmld += "</div>";
	                	$("#snake_input_fields_wrap").append(htmld);
	                       
	    }	
	            
	            
	    var ladderNext = 1;        
	    function addLadders() {
            console.log("add more stages "+ladderNext);
            ladderNext = ladderNext + 1;
            
                var htmld = "<div class='form-group' id='ladderDiv"+ladderNext+"'>";
                		htmld += "<label>Ladder "+ladderNext+"</label>";                    	                                  
                		htmld += "<div class='input-group'><input id='ladder"+ladderNext+"' name='ladder[]' type='text' class='form-control'>";	
                		htmld += "<span class='input-group-btn'><button class='btn btn-danger btn-remove' onclick='removeLadderStage("+ladderNext+")' type='button'>";
                			htmld += "<span class='glyphicon glyphicon-minus'></span>";
                		htmld += "</button></span></div>";
                	htmld += "</div>";
                	$("#ladder_input_fields_wrap").append(htmld);
                       
    }           
	
	

    function removeSnakeStage(id) {
        console.log(id);
		var stageid = "#snakeDiv"+id;
		if(id<snakeNext) {
			//alert("remove stages from descending order!");
			$("#snakeError").show();
			//$('#stageError').delay(5000).fadeOut('slow');
			setTimeout(function() {
				  $('#snakeError').fadeOut('slow');
				}, 5000);
		} else {
			snakeNext = snakeNext - 1;
			$(stageid).remove();
		}
    }
    
    function removeLadderStage(id) {
        console.log(id);
		var stageid = "#ladderDiv"+id;
		if(id<ladderNext) {
			//alert("remove stages from descending order!");
			$("#ladderError").show();
			//$('#stageError').delay(5000).fadeOut('slow');
			setTimeout(function() {
				  $('#ladderError').fadeOut('slow');
				}, 5000);
		} else {
			ladderNext = ladderNext - 1;
			$(stageid).remove();
		}
    }
			
			
	
	function generateGameBoard() {
		
		var num = $('#numberOfSquares').val();

		var memorySquare = $('#memorySquare').val();
		var magicSquare = $('#magicSquare').val();
		var trampolineSquare = $('#trampolineSquare').val();
		var elevatorSquare = $('#elevatorSquare').val();
		var pitStopSquare = $('#pitStopSquare').val();
		var snakeSquare = $('#snake1').val();
		var ladderSquare = $('#ladder1').val();
		
		var dataObj = {
				
				'numberOfSquares' : num,
				'memorySqaure' : memorySquare,
				'magicSquare' : magicSquare,
				'trampoline' : trampolineSquare,
				'elevator' : elevatorSquare,
				'pitStopSquare' : pitStopSquare,
				'elevatorSquare' : elevatorSquare,
				'snakes' : snakeSquare,
				'ladders' : ladderSquare
				
		}
		var gameDetails = JSON.stringify(dataObj);
		
		console.log(gameDetails);
		
		$.ajax({
			type : "POST",
			url : '/SnakeLadder/gameBoard',
			data : gameDetails,
			contentType : 'application/json;charset=UTF-8',
			success : function(response) {
				console.log(response);
				
				gameModel = response;

				console.log(response.gameHtml);
				
				if(response.message != ""){
					toastr.warning(gameModel.message);
					return;
				}

				$('#gameBoard').html(response.gameHtml);
				
				$('#player1Loc_'+response.userLocation).show();
				
				$('#player2Loc_'+response.compLocation).show();

			}
		});
		
	}
	
	function diceRolled(){
		setTimeout(
				  function() 
				  {
		var diceValue = $('#test').val();
		console.log(diceValue);
		gameModel["diceValue"] = diceValue;
		var gameDetails = JSON.stringify(gameModel);
		
		
		
		console.log(gameDetails);	
		
		$.ajax({
			type : "POST",
			url : '/SnakeLadder/diceRolled',
			data : gameDetails,
			contentType : 'application/json;charset=UTF-8',
			success : function(response) {
				
				
				gameModel = response;
				
				
				
				
				if(gameModel.p2Chance){
					$('#p1En').html("P1 Energy :"+gameModel.p1Energy);
					
					var p1Table=""; 
					
					
					$.each(gameModel.p1GameStep, function( index, value ) {
							p1Table+="<tr><td>"+index+"</td><td>"+value+"</td></tr>";
						});
					
					$('#p1DetailsBody').html(p1Table);
					$('#p1Details').dataTable();
				}else{
					$('#p2En').html("P2 Energy :"+gameModel.p2Energy);
				
					var p2Table=""; 
					
					$.each(gameModel.p2GameStep, function( index, value ) {
							p2Table+="<tr><td>"+index+"</td><td>"+value+"</td></tr>";
						});
					$('#p2DetailsBody').html(p2Table);
					$('#p2Details').dataTable(); 
				}
				
				if(gameModel.message != ""){
					toastr.warning(gameModel.message);
				}

				
				if(gameModel.p1Magic){
					$('#p1Magic').html("P1- Magic is on.");
				}else{
					$('#p1Magic').html("");
				}
				
				if(gameModel.p2Magic){
					$('#p2Magic').html("P2- Magic is on.");
				}else{
					$('#p2Magic').html("");
				}

				$('#gameBoard').html(response.gameHtml);
				
				
	$.each(gameModel.snakeMap, function(index, value) {

						$('#ene_' + index).html("E-" + gameModel.snakeEnergy);
						
						$('#ene_' + value).html("E-" + gameModel.snakeEnergy);

					});

					$('#player1Loc_' + response.userLocation).show();

					$('#player2Loc_' + response.compLocation).show();

					if (gameModel.successMessage != "") {
						toastr.success(gameModel.successMessage);
						$('#gameBoard').html("");
					}

				}
			});
		}, 2000);

	}
</script>
</body>
</html>
