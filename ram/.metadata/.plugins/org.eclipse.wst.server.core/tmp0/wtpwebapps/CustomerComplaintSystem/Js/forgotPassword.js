
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
document.getElementById("done").addEventListener("click",function(event){
   
	emailValidation();
    answerValidation();
});
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
function answerValidation(){
	var answer = document.getElementById("answer");
	if(answer.value.length>25){
		answer.setCustomValidity("please enter answer less than 25 characters");
		flag=false;
	}else{
		answer.setCustomValidity("");	
	}
}
document.getElementById("forgotPasswordForm").addEventListener("submit",function(event){
    if(!flag){
      event.preventDafault();
      flag = true;
    }
}); 