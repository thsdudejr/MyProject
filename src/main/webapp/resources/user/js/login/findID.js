/**
 * 
 */
$(".find-id-btn").on("click", function() {
	if($('#phone').val() == ''){
		alert('핸드폰 번호를 입력해주세요');
		return;
	}	
	
	$.ajax({
		type:'post',
		url: 'ufindID',
		data: {'phone' : $('#phone').val()},
		success:function(res){
			if(res.email != null){
				$('.result-id').html(res.email);
				$('.result').show();
				return;
			}
			alert('email을 찾을 수 없습니다');
		},
		error:function(){
			alert('Sever Error');
		}
	});
});

