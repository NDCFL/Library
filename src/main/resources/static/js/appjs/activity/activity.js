var statusMap = ['同意申请','拒绝申请','请求处理'];
var prefix = "/activity"
//生成用户数据
$('#mytab').bootstrapTable({
    method: 'POST',
    contentType: "application/x-www-form-urlencoded",//必须要有！！！！
    url: prefix + "/list",//要请求数据的文件路径
    toolbar: '#toolbar',//指定工具栏
    striped: true, //是否显示行间隔色
    dataField: "res",
    sortable: true, //是否启用排序 sortOrder: "ID asc",
    sortOrder: "ID asc",
    pagination: true,//是否分页
    queryParamsType: 'pageSize',//查询参数组织方式
    queryParams: queryParams,//请求服务器时所传的参数
    sidePagination: 'server',//指定服务器端分页
    pageNumber: 1, //初始化加载第一页，默认第一页
    pageSize: 10,//单页记录数
    pageList: [10, 20, 30, 40, 50, 60, 70, 80, 90, 100],//分页步进值
    showRefresh: true,//刷新按钮
    showColumns: true,
    clickToSelect: true,//是否启用点击选中行
    toolbarAlign: 'right',//工具栏对齐方式
    buttonsAlign: 'right',//按钮对齐方式
    toolbar: '#toolbar', search: true,
    uniqueId: "id",                     //每一行的唯一标识，一般为主键列
    showExport: true,
    exportDataType: 'all',
    columns: [
        {
            title: '全选',
            field: 'select',
            //复选框
            checkbox: true,
            width: 25,
            align: 'center',
            valign: 'middle'
        },
        {
            field: 'title',
            title: '活动标题',
            align: 'center',
            valign: 'middle'
        },
        {
            field: 'location',
            title: '位置',
            align: 'center',
            valign: 'middle'
        },
        {
            field: 'peopleNum',
            title: '容纳人数',
            align: 'center',
            valign: 'middle'
        },
        {
            field: 'startTime',
            title: '时间范围',
            align: 'center',
            valign: 'middle',
            formatter: function (value, row, index) {
                return '<span>'+row.startTime+'-'+row.endTime+'</span>';
            }
        },
        {
            field: 'status',
            title: '状态',
            align: 'center',
            valign: 'center',
            formatter: function (value, row, index) {
                if(value==0){
                    value = 1;

                }
                return '<span style="color: green" >'+statusMap[value-1]+'</span>';
            }
        },
        {
            field: 'createTime',
            title: '创建时间',
            align: 'center',
            valign: 'middle'
        },
        {
            title: '操作',
            field: 'id',
            align: 'center',
            formatter: function (value, row, index) {
                var e = '<a class=" ' + s_edit_h + '" href="#" mce_href="#" title="修改" onclick="edit(\''
                    + row.id
                    + '\')"><i class="glyphicon glyphicon-pencil" alt="修改" style="color:green">修改</i></a> ';
                var d = '<a class=" ' + s_remove_h + '" href="#" title="删除"  mce_href="#" onclick="remove(\''
                    + row.id
                    + '\')"><i class="glyphicon glyphicon-trash" alt="删除" style="color:red">删除</i></a> ';
                var f =  '<a title="同意申请" href="javascript:void(0);" onclick="updatestatus(\'' + row.id + '\',' + 1 + ')"><i class="glyphicon glyphicon-ok-sign" style="color:green">同意申请</i></a> ';
                var f1 = '<a title="拒绝申请" href="javascript:void(0);" onclick="updatestatus(\'' + row.id + '\',' + 2 + ')"><i class="glyphicon glyphicon-remove-sign"  style="color:red">拒绝申请</i></a> ';
                if(row.status!=1){
                    return f + f1;
                }
            }
        }],
    locale: 'zh-CN',//中文支持,
    responseHandler: function (res) {
        if (res) {
            return {
                "res": res.rows,
                "total": res.total
            };
        } else {
            return {
                "rows": [],
                "total": 0
            };
        }
    }
});
//请求服务数据时所传参数
function queryParams(params) {
    var title = "";
    $(".search input").each(function () {
        title = $(this).val();
    });
    return {
        //每页多少条数据
        'pager.pageSize': this.pageSize,
        //请求第几页
        'pager.pageIndex': this.pageNumber,
        name: $('#searchName').val(),
        'pager.sort': 'create_time',
        'pager.order': 'desc',
        operation: $("#searchOperation").val(),
        username: $("#searchUsername").val(),

    }
}

function reLoad() {
    $('#mytab').bootstrapTable('refresh', {url: prefix+'/list'})
}

function add() {
    location.href = prefix + '/add';
}

function edit(id) {
    location.href=prefix + '/edit/' + id
}

function remove(id) {
    layer.confirm('确定要删除选中的记录？', {
        btn: ['确定', '取消']
    }, function () {
        $.ajax({
            url: prefix + "/remove",
            type: "post",
            data: {
                'id': id
            },
            success: function (r) {
                if (r.code == 0) {
                    layer.msg(r.msg);
                    reLoad();
                } else {
                    layer.msg(r.msg);
                }
            }
        });
    })
}
function updatestatus(id, status) {
    $.post(
        "/activity/update/",
        {
          "id":id,
          "status":status
        },
        function (data) {
            if (status == 0) {
                if (data.code == 0) {
                    layer.alert("已启用", {icon: 6});
                } else {
                    layer.alert("操作失败", {icon: 6});
                }
            } else {
                if (data.code == 0) {
                    layer.alert("已停用", {icon: 5});
                } else {
                    layer.alert("操作失败", {icon: 5});
                }
            }
            reLoad();
        },
        "json"
    );
}
$("#update").click(function () {
    var title = $("#title").val();
    var location = $("#location").val();
    var peopleNum = $("#peopleNum").val();
    var time = $("#startTime").val();
    var time = $("#startTime").val();
    if(!title){
        layer.msg("活动不能为空");
        return;
    }
    if(!location){
        layer.msg("活动不能为空");
        return;
    }
    if(!peopleNum){
        layer.msg("活动容纳人数");
        return;
    }
    if(isNaN(peopleNum)){
        layer.msg("活动容纳人数只能是数字");
        return;
    }
    if(!time){
        layer.msg("活动时间不能为空");
        return;
    }
    $("#startTime").val(time.substring(0,19));
    $("#endTime").val(time.substring(21,time.length));
    $.post(
        "/activity/update",
        $("#formupdate").serialize(),
        function (data) {
            if (data.code == 0) {
                layer.confirm('修改成功，是否回到列表页？', function (index) {
                    $("#back").click();
                });
            } else {
                layer.alert(data.msg, {icon: 2});
                refush();
            }
        }, "json"
    );
});
$("#add").click(function () {

    var title = $("#title").val();
    var location = $("#location").val();
    var peopleNum = $("#peopleNum").val();
    var time = $("#startTime").val();
    if(!title){
        layer.msg("活动不能为空");
        return;
    }
    if(!location){
        layer.msg("活动不能为空");
        return;
    }
    if(!peopleNum){
        layer.msg("活动容纳人数");
        return;
    }
    if(isNaN(peopleNum)){
        layer.msg("活动容纳人数只能是数字");
        return;
    }
    if(!time){
        layer.msg("活动时间不能为空");
        return;
    }
    $("#startTime").val(time.substring(0,19));
    $("#endTime").val(time.substring(21,time.length));
    $.post(
        "/activity/save",
        $("#formadd").serialize(),
        function (data) {
            if (data.code == 0) {
                layer.confirm('新增成功，是否回到列表页？', function (index) {
                    $("#back").click();
                });
            } else {
                layer.alert(data.msg, {icon: 2});
                refush();
            }
        }, "json"
    );
});
function batchRemove() {
    var rows = $('#mytab').bootstrapTable('getSelections'); // 返回所有选择的行，当没有选择的记录时，返回一个空数组
    if (rows.length == 0) {
        layer.msg("请选择要删除的数据");
        return;
    }
    layer.confirm("确认要删除选中的'" + rows.length + "'条数据吗?", {
        btn: ['确定', '取消']
        // 按钮
    }, function () {
        var ids = new Array();
        // 遍历所有选择的行数据，取每条数据对应的ID
        $.each(rows, function (i, row) {
            ids[i] = row['id'];
        });
        $.ajax({
            type: 'POST',
            data: {
                "ids": ids
            },
            url: prefix + '/batchRemove',
            success: function (r) {
                if (r.code == 0) {
                    layer.msg(r.msg);
                    reLoad();
                } else {
                    layer.msg(r.msg);
                }
            }
        });
    }, function () {

    });
}