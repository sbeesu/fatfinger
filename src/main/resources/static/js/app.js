$(".storedPin-warning").hide();

$(".keypad .myButton").click(function() {
	
	if($("#storedPin").is(":valid")){
		var enteredKey = $(this).attr("id");
		$(".keyContent").append(enteredKey);
		$(".pinEntered").html("");
		
		if (checkLength() == 4) {
			
			var enteredPin = $(".keyContent").html();
			var storedPin = $("#storedPin").val();
			
			var formInput = enteredPin + ":" + storedPin;
			
			if(enteredPin.trim().length == 4 && $("#storedPin").is(":valid")){
				
				$.ajax({
					url : "validatePin/" + formInput
				}).done(function(msg) {

					if(msg === "VALID"){
						$(".pinEntered").html("<div class='alert alert-success'>Your Entered PIN '"+enteredPin+"' is <strong>"+msg+"</strong>.</div>");
					}
					else{
						$(".pinEntered").html("<div class='alert alert-danger'>Your Entered PIN '"+enteredPin+"' is <strong>"+msg+"</strong>.</div>");
					}
					
					
					$(".keyContent").html("");
					
				});
				
				
			}
			
		}
		
	}
	else{
		$(".storedPin-warning").shake(2, 20, 1);
	}

});

function checkLength() {
	return $(".keyContent").html().length;
}

$("#storedPin").on("input", function(){
	$(".storedPin-warning").show();
	
	if($("#storedPin").is(":valid"))
		$(".storedPin-warning").hide();
});

jQuery.fn.shake = function(intShakes, intDistance, intDuration) {
    this.each(function() {
        $(this).css("position","relative"); 
        for (var x=1; x<=intShakes; x++) {
        $(this).animate({left:(intDistance*-1)}, (((intDuration/intShakes)/4)))
    .animate({left:intDistance}, ((intDuration/intShakes)/2))
    .animate({left:0}, (((intDuration/intShakes)/4)));
    }
  });
return this;
};


