
$('.form').find('input, textarea').on('keyup blur focus', function (e) {
 
  var $this = $(this),
      label = $this.prev('label');

	  if (e.type === 'keyup') {
			if ($this.val() === '') {
          label.removeClass('active highlight');
        } else {
          label.addClass('active highlight');
        }
    } else if (e.type === 'blur') {
    	if( $this.val() === '' ) {
    		label.removeClass('active highlight'); 
			} else {
		    label.removeClass('highlight');   
			}   
    } else if (e.type === 'focus') {
      
      if( $this.val() === '' ) {
    		label.removeClass('highlight'); 
			} 
      else if( $this.val() !== '' ) {
		    label.addClass('highlight');
			}
    }

});

$('.tab a').on('click', function (e) {
  
  e.preventDefault();
  
  $(this).parent().addClass('active');
  $(this).parent().siblings().removeClass('active');
  
  target = $(this).attr('href');
 
  
  $('.tab-content > div').not(target).hide();
  
  $(target).fadeIn(600);
  
});
var flag=true;
document.getElementById("signUp").addEventListener("click",function(event){
	
    nameValidation();
    emailValidation();
    mobileNumberValidation();
    passwordValidation();
    answerValidation();
});
function nameValidation(){
var regexForName = /^[A-Za-z]{3,20}$/;
var name = document.getElementById("name");
if(!regexForName.test(name.value)){
    name.setCustomValidity("please enter name only with characters more than 2 less than 20");
    flag=false;
}else{
        name.setCustomValidity("");
     }
  }
function  mobileNumberValidation(){
  var regexForMobileNUmber = /^[0-9]{10}$/;
  var mobileNumber = document.getElementById('mobileNumber');

  if(  mobileNumber.value.length >10 || mobileNumber.value.length <10){
    mobileNumber.setCustomValidity("please enter valid mobilenumber");
    flag=false;
  }else if(!regexForMobileNUmber.test(mobileNumber.value)){
	 
	  mobileNumber.setCustomValidity("please enter valid mobilenumber");
	    flag=false;  
  }
  else{
	  mobileNumber.setCustomValidity("");
  }
}
function emailValidation(){
  var regexForUserEmail = /^\w.+@[a-zA-Z_]+?\.[a-zA-Z]{2,3}$/
  var email = document.getElementById('email');
  if(email.value.length>40 || !regexForUserEmail.test(email.value)){
    email.setCustomValidity("please enter valid email address");
    flag=false;
  }else{
    email.setCustomValidity("");
  }
}
function passwordValidation() {
  var password = document.getElementById("password");
  var confrim_password = document.getElementById("confirm_password");
 if(password.value.length>30){
     password.setCustomValidity("password length should be less than 30 characters");
     flag = false;
   }else if(password.value!=confrim_password.value){
	 confrim_password.setCustomValidity(" These passwords don't match. Try again?");
	 flag = false;
      }else{
    	     confrim_password.setCustomValidity("");
      }
}
function answerValidation(){
	var answer = document.getElementById("answer");
	if(answer.value.length>25){
		answer.setCustomValidity("please enter answer less than 25 characters");
		flag=false;
	}else{
		answer.setCustomValidity("");	
	}
}
document.getElementById("signUpForm").addEventListener("submit",function(event){
    if(!flag){
      event.preventDafault();
      flag = true;
    }
}); 