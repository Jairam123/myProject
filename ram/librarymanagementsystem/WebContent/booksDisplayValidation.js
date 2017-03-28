
var isSubmit = true;
document.getElementById('borrow').addEventListener("click", function() {
	clearErrorsMsg();
	bookAvailable();
});

document.getElementById('return').addEventListener("click", function() {
	clearErrorsMsg();
	 checkBoxesCheckedValidation();
});

function bookAvailable() {
	var x = document.myForm.checkBoxes;
	var status = false;
	for (var i = 0; i < x.length; i++) {
		if ((x[i].checked)) {
			status = true;
			if (document.getElementById("bookTable").rows[i + 1].cells.item(3).innerHTML == 0) {
				document.getElementById('error_not_available').style.display = 'block';
				isSubmit = false;
				break;
			}
		}
	}

	if (!status) {
		document.getElementById('msg').style.display = 'block';
		isSubmit = false;
	}
}
function checkBoxesCheckedValidation(){
	var x = document.myForm.checkBoxes;
	var status = false;
	for (var i = 0; i < x.length; i++) {
		if ((x[i].checked)) {
			status = true;
		}
	}

	if (!status) {
		document.getElementById('msg').style.display = 'block';
		isSubmit = false;
	}
}
function clearErrorsMsg() {
	document.getElementById('error_not_available').style.display = 'none';
	document.getElementById('msg').style.display = 'none';

}

document.getElementById("form").addEventListener("submit", function(event) {
	if (!isSubmit)
{
	event.preventDefault();
	isSubmit = true;
}
	
});
