$().ready(function(){
	$("#orderForm").validate({
		errorPlacement : function(error, element) {
			var errorplace = element.parent().next();
			errorplace.text("");
			error.appendTo( errorplace );
		},
        submitHandler:function(form){
			form.submit();
        },
		rules: {
			"order.checkindate": {
				required : true,
				dateISO : true
			},
			"order.checkoutdate": {
				required : true,
				dateISO : true
			}
		},
        messages: {
			"order.checkindate": {
				required : "<span class='validatorMsg validatorError'>请输入入住时间</span>",
				dateISO : "<span class='validatorMsg validatorError'>日期格式:yyyy-mm-dd</span>"
			},
			"order.checkoutdate": {
				required : "<span class='validatorMsg validatorError'>请输入退房时间</span>",
				dateISO : "<span class='validatorMsg validatorError'>日期格式:yyyy-mm-dd</span>"
			}
		}
    });
});


