$().ready(function() {
	validateRule();
});

$.validator.setDefaults({
	submitHandler : function() {
		save();
	}
});
function save() {
	var time = $("#startTime").val();
	$("#startTime").val(time.substring(0,19));
	$("#endTime").val(time.substring(21,time.length));
	$.ajax({
		cache : true,
		type : "POST",
		url : "/activity/save",
		data : $('#signupForm').serialize(),// 你的formid
		async : false,
		error : function(request) {
			parent.layer.alert("Connection error");
		},
		success : function(data) {
			if (data.code == 0) {
				parent.layer.msg("操作成功");
				parent.reLoad();
				var index = parent.layer.getFrameIndex(window.name); // 获取窗口索引
				parent.layer.close(index);

			} else {
				parent.layer.alert(data.msg)
			}

		}
	});

}
function validateRule() {
	var icon = "<i class='fa fa-times-circle'></i> ";
	$("#signupForm").validate({
		rules : {
            title : {
				required : true
			},
            location : {
                required : true
            },
            peopleNum : {
                required : true
            },
            startTime: {
                required : true
            }
		},
		messages : {
            title : {
				required : icon + "请输入活动标题"
			},
            location : {
                required : icon + "请输入活动位置"
            },
            peopleNum : {
                required : icon + "请输入活动容纳人数"
            },
            startTime : {
                required : icon + "请输入活动时间"
            }
		}
	})
}