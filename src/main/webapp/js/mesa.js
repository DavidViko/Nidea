var checkColor = document.getElementById("custom");
var inputColor = document.getElementById("color");

showColor();

function showColor(){
	if(checkColor.checked){
		inputColor.style.display = "inline-block";
	} 
	else{
		inputColor.style.display = "none";
	}
}