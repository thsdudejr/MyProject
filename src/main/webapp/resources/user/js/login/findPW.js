/**
 * 
 */
$(".find-pw-btn").on("click",function(){
	var email = $('#userID').val();
	if(email == null){
		alert('이메일을 입력해주세요');
		return;
	}
	
	$.ajax({
		type:'post',
		url:'ufindPW',
		data : {'email' : email},
		success:function(res){
			if(res.email != null){
				$('#send-email').attr("href", "sendEmail?email="+res.email)
				$(".result").show();
			}
		},
		error:function(){
			alert('Server Error');
		}
	});
});