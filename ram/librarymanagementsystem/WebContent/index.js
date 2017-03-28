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
    userValidation();
    emailValidation();
    passwordValidation();
});
function nameValidation(){
var regexForName = /^[A-Za-z]{3,20}$/;
var name = document.getElementsByClassName("name");
for(var nameIndex=0;nameIndex<name.length;nameIndex++){
if(!regexForName.test(name[nameIndex].value)){
 name[nameIndex].setCustomValidity("please enter name only with characters more than 2 less than 20");
 flag=false;
}else{
        name[nameIndex].setCustomValidity("");
     }

  }
}
function userValidation(){
  var regexForUserName = /^[A-Za-z0-9]{3,20}$/;
  var userName = document.getElementById('userName');
  if(!regexForUserName.test(userName.value)){
    userName.setCustomValidity("please create username only with characters and numbers");
    flag=false;
  }else{
    userName.setCustomValidity("");
  }
}
function emailValidation(){
  var regexForUserEmail = /^\w.+@[a-zA-Z_]+?\.[a-zA-Z]{2,3}$/
  var email = document.getElementById('email');
  if(email.value.length>35 || !regexForUserEmail.test(email.value)){
    email.setCustomValidity("please enter valid email address");
    flag=false;
  }else{
    email.setCustomValidity("");
  }
}
function passwordValidation() {
  var password = document.getElementById("password");
  var confrim_password = document.getElementById("confirm_password");
 if(password.value.length>25){
     password.setCustomValidity("password length is less than 25 characters");
     flag = false;
   }else if(password.value!=confrim_password.value){
	 confrim_password.setCustomValidity(" These passwords don't match. Try again?");
	 flag = false;
      }else{
    	     confrim_password.setCustomValidity("");
      }
}
document.getElementById("signUpForm").addEventListener("submit",function(event){
    if(!flag){
      event.preventDafault();
      flag = true;
    }
}); 
