//生成用户数据
var path = "http://file.mykefang.com/";
$('#mytab').bootstrapTable({
    method: 'post',
    contentType: "application/x-www-form-urlencoded",//必须要有！！！！
    url: "/readUserExpress/list",//要请求数据的文件路径
    toolbar: '#toolbar',//指定工具栏
    striped: true, //是否显示行间隔色
    dataField: "res",
    sortable: true, //是否启用排序 sortOrder: "ID asc",
    sortOrder: "ID asc",
    pagination: true,//是否分页
    queryParamsType: 'limit',//查询参数组织方式
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
    toolbar: '#toolbar',
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
            field: 'faceImg',
            title: '用户头像',
            align: 'center',
            sortable: true,
            formatter: function (value, row, index) {
                return '<img style="width: 80px;height: 80px;border-radius: 100%" src="' + path + value + '"/>';
            }
        },
        {
            field: 'name',
            title: '读者姓名',
            align: 'center',
            sortable: true
        },
        {
            field: 'idCard',
            title: '身份证号',
            align: 'center',
            sortable: true
        },
        {
            field: 'sex',
            title: '性别',
            align: 'center',
            sortable: true,
            formatter: function (value, row, index) {
                if (value == 0) {
                    //表示启用状态
                    return '<span style="color: green" >男</span>';
                } else {
                    //表示启用状态
                    return '<span style="color: red" >女</span>';
                }
            }
        },
        {
            field: 'workAdress',
            title: '工作单位',
            align: 'center',
            sortable: true
        },
        {
            field: 'phone',
            title: '快递员手机号',
            align: 'center',
            sortable: true
        },
        {
            field: 'express',
            title: '身份',
            align: 'center',
            sortable: true,
            formatter: function (value, row, index) {
                if (value == 0) {
                    //表示启用状态
                    return '<span style="color: red" >读者</span>';
                } else {
                    //表示启用状态
                    return '<span style="color: green" >快递员</span>';
                }
            }
        },
        {
            field: 'expressStatus',
            title: '快递员资格',
            align: 'center',
            sortable: true,
            formatter: function (value, row, index) {
                if (value == 0) {
                    //表示启用状态
                    return '<span style="color: red" >禁用</span>';
                } else {
                    //表示启用状态
                    return '<span style="color: green" >启用</span>';
                }
            }
        },
        {
            title: '操作', 
            align: 'center',
            field: '',
            formatter: function (value, row, index) {
                var f='';
                if (row.express == 1) {
                    f = '<a title="取消快递资格" role="menuitem" tabindex="-1"  href="javascript:void(0);" onclick="updatestatus(\'' + row.id + '\',' + 0 + ')"><i class="glyphicon glyphicon-ok-sign" style="color:green">取消快递资格</i></a> ';
                } else if (row.express == 0) {
                    f = '<a title="恢复快递资格" role="menuitem" tabindex="-1"  href="javascript:void(0);" onclick="updatestatus(\'' + row.id + '\',' + 1 + ')"><i class="glyphicon glyphicon-remove-sign"  style="color:red">恢复快递资格</i></a> ';
                }

                var p='';
                if (row.expressStatus == 1) {
                    p = '<a title="冻结快递资格" role="menuitem" tabindex="-1"  href="javascript:void(0);" onclick="updateexpressstatus(\'' + row.id + '\',' + 0 + ')"><i class="glyphicon glyphicon-ok-sign" style="color:green">冻结快递资格</i></a> ';
                } else if (row.expressStatus == 0) {
                    p = '<a title="解冻快递资格" role="menuitem" tabindex="-1"  href="javascript:void(0);" onclick="updateexpressstatus(\'' + row.id + '\',' + 1 + ')"><i class="glyphicon glyphicon-remove-sign"  style="color:red">解冻快递资格</i></a> ';
                }
                if(row.express==1){
                    return f+p;
                }else{
                    return f;
                }
            }
        }
    ],
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
})

//请求服务数据时所传参数
function queryParams(params) {
    // var times = $("#test_2").val();
    // var start, end;
    // if (!times) {
    //     start = null;
    //     end = null;
    // } else {
    //     start = times.substring(0, 11) + "00:00:00";
    //     end = times.substring(13, times.length) + " 23:59:59";
    // }
    return {
        //每页多少条数据
        'pager.pageSize': this.pageSize,
        //请求第几页
        'pager.pageIndex': this.pageNumber,
        //排序字段
        'pager.sort': 'create_time',
        //排序方式
        'pager.order': 'desc',
        // createTime: start,
        // endTime: end,
        name: $("#name__").val(),
        cardNum: $("#cardNum__").val(),
        idCard: $("#idCard__").val(),
        phone: $("#phone__").val(),
    }
}

function formattime(value) {
    var date = new Date(value);
    var y = date.getFullYear();
    var m = date.getMonth() + 1;
    var d = date.getDate();
    var h = date.getHours();
    var mi = date.getMinutes();
    var ss = date.getSeconds();
    return y + '-' + (m < 10 ? "0" + m : m) + '-' + (d < 10 ? "0" + d : d) + ' ' + (h < 10 ? "0" + h : h) + ':' + (mi < 10 ? "0" + mi : mi) + ':' + (ss < 10 ? "0" + ss : ss);
}

function formattimes(value) {
    var date = new Date(value);
    var y = date.getFullYear();
    var m = date.getMonth() + 1;
    var d = date.getDate();
    var h = date.getHours();
    var mi = date.getMinutes();
    var ss = date.getSeconds();
    return y + '-' + (m < 10 ? "0" + m : m) + '-' + (d < 10 ? "0" + d : d);
}

function del(id, status) {
    if (status == 0) {
        layer.msg("删除失败，已经启用的不允许删除!", {icon: 2, time: 1000});
        return;
    }
    layer.confirm('确认要删除吗？', function (index) {
        $.post("/readUserExpress/remove",
            {
                "id": id
            },
            function (data) {
                if (data.msg == "ok") {
                    layer.alert(data.msg, {icon: 5});
                } else {
                    layer.alert(data.msg, {icon: 6});
                }
                refush();
            },
            "json"
        );
    });
}

function edit(name) {
    $.get("/readUserExpress/edit/" + name,
        function (data) {
            $("#updateform").autofill(data);
        },
        "json"
    );
}

function resetPwd(id) {
    $.get("/readUserExpress/resetPwd/" + id,
        function (data) {
            if (data.code == 0) {
                layer.alert(data.msg, {icon: 1});
            } else {
                layer.alert(data.msg, {icon: 2});
            }
        },
        "json"
    );
}

function updatestatus(id, status) {
    $.post("/readUserExpress/update",
        {
            "id": id,
            "express": status
        },
        function (data) {
            if (data.code == 0) {
                layer.alert("操作成功", {icon: 1});
            } else {
                layer.alert("操作失败", {icon: 2});
            }
            refush();
        },
        "json"
    );
}

function updateexpressstatus(id, status) {
    $.post("/readUserExpress/update",
        {
            "id": id,
            "expressStatus": status
        },
        function (data) {
            if (data.code == 0) {
                layer.alert("操作成功", {icon: 1});
            } else {
                layer.alert("操作失败", {icon: 2});
            }
            refush();
        },
        "json"
    );
}
//查询按钮事件
$('#search_btn').click(function () {
    // var times = $("#test_2").val();
    // var start, end;
    // if (!times) {
    //     start = null;
    //     end = null;
    // } else {
    //     start = times.substring(0, 11) + "00:00:00";
    //     end = times.substring(13, times.length) + " 23:59:59";
    // }
    $('#mytab').bootstrapTable('refresh', {
        url: '/readUserExpress/list',
        query: {
            // createTime: start,
            // endTime: end,
            name: $("#name__").val(),
            cardNum: $("#cardNum__").val(),
            idCard: $("#idCard__").val(),
            phone: $("#phone__").val(),
        }
    });
})

function refush() {
    // var times = $("#test_2").val();
    // var start, end;
    // if (!times) {
    //     start = null;
    //     end = null;
    // } else {
    //     start = times.substring(0, 11) + "00:00:00";
    //     end = times.substring(13, times.length) + " 23:59:59";
    // }
    $('#mytab').bootstrapTable('refresh', {
        url: '/readUserExpress/list',
        query: {
            // createTime: start,
            // endTime: end,
            name: $("#name__").val(),
            cardNum: $("#cardNum__").val(),
            idCard: $("#idCard__").val(),
            phone: $("#phone__").val(),
        }
    });
}

$('#updateform').bootstrapValidator({
    message: 'This value is not valid',
    feedbackIcons: {
        valid: 'glyphicon glyphicon-ok',
        invalid: 'glyphicon glyphicon-remove',
        validating: 'glyphicon glyphicon-refresh'
    },
    fields: {
        name: {
            message: '用户名验证失败',
            validators: {
                notEmpty: {
                    message: '用户名称不能为空'
                },
                stringLength: {
                    min: 2,
                    max: 30,
                    message: '分类名称长度必须在2到30位之间'
                }
            }
        }
    }
});
$("#update").click(function () {
    $('#updateform').data('bootstrapValidator').validate();
    if (!$('#updateform').data('bootstrapValidator').isValid()) {
        return;
    }
    $.post(
        "/readUserExpress/update",
        $('#updateform').serialize(),
        function (result) {
            if (result.code == 0) {
                layer.alert(result.msg, {icon: 1});
                $("#myModal").modal('hide');
            } else {
                layer.alert(result.msg, {icon: 2});
            }
            refush();
        },
        "json"
    );
});
$('#formadd').bootstrapValidator({
    message: 'This value is not valid',
    feedbackIcons: {
        valid: 'glyphicon glyphicon-ok',
        invalid: 'glyphicon glyphicon-remove',
        validating: 'glyphicon glyphicon-refresh'
    },
    fields: {
        name: {
            message: '用户名验证失败',
            validators: {
                notEmpty: {
                    message: '分类名称不能为空'
                },
                stringLength: {
                    min: 2,
                    max: 30,
                    message: '分类名称长度必须在2到30位之间'
                }
            }
        }
    }
});
$("#add").click(function () {
    $('#formadd').data('bootstrapValidator').validate();
    if (!$('#formadd').data('bootstrapValidator').isValid()) {
        return;
    }
    $.post(
        "/readUserExpress/save",
        $('#formadd').serialize(),
        function (result) {
            if (result.code == 0) {
                layer.alert(result.msg, {icon: 1});
                $("#webAdd").modal('hide');
            } else {
                layer.alert(result.msg, {icon: 2});
            }
            refush();
        },
        "json"
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
        $.post(
            "/readUserExpress/batchRemove",
            {
                "ids": ids
            }, function (data) {
                if (data.code == 0) {
                    layer.alert(data.msg, {icon: 1});
                } else {
                    layer.alert(data.msg, {icon: 2});
                }
                refush();
            }, "json"
        );
    }, function () {

    });
}

function deleteMany() {
    var isactivity = "";
    var row = $.map($("#mytab").bootstrapTable('getSelections'), function (row) {
        if (row.isActive == 0) {
            isactivity += row.isActive;
        }
        return row.id;
    });
    if (row == "") {
        layer.msg('修改失败，请勾选数据!', {
            icon: 2,
            time: 3000
        });
        return;
    }
    $("#statusId").val(row);
    $("#updateStatus").modal('show');

}

$("#updateSta").click(function () {
    layer.confirm('确认要执行批量修改状态吗？', function (index) {
        $.post(
            "/readUserExpress/deleteManyReadUser",
            {
                "manyId": $("#statusId").val(),
                "status": $("#status").val()
            },
            function (data) {
                if (data.msg == "修改成功!") {
                    layer.alert(data.msg, {icon: 6});
                    refush();
                } else {
                    layer.alert(data.msg, {icon: 6});
                    refush();
                }
            }, "json"
        );
    });
});
function refushAdress(id) {
    $('#mytab2').bootstrapTable('refresh', {
        url: '/address/findList/' + id
    });
}
var idValue = '';
function address(id) {
    idValue = id;
    refushAdress(id);
}
$("#add_add").click(function () {
    $("#readUserId_add").val(idValue);
    $.post(
        "/address/saveOrUpdate",
        $('#form_add').serialize(),
        function (data) {
            if (data.msg == "操作成功") {
                layer.alert(data.msg, {icon: 6});
                refushAdress(idValue);
            } else {
                layer.alert(data.msg, {icon: 6});
                refushAdress(idValue);
            }
        }, "json"
    );
});
function editAddress(id) {

    $.get("/address/edit/" + id,
        function (data) {
            $("#form_add").autofill(data);
            $("#add_add").html("确认修改");
        },
        "json"
    );
}
function resetAddress() {
    $("#id_add").val("");
    $("#readUserId_add").val(idValue);
    $("#add_add").html("确认新增");
}
$('#order_item_list').on('hide.bs.modal', function () {
    $("#reset_add").trigger("click");
});
function delAdress(id) {

    layer.confirm('确认要删除吗？', function (index) {
        $.post("/address/remove",
            {
                "id": id
            },
            function (data) {
                if (data.msg == "ok") {
                    layer.alert(data.msg, {icon: 5});
                } else {
                    layer.alert(data.msg, {icon: 6});
                }
                refushAdress(idValue);
            },
            "json"
        );
    });
}
//生成用户数据
$('#mytab2').bootstrapTable({
    method: 'post',
    contentType: "application/x-www-form-urlencoded",//必须要有！！！！
    url: "/address/findList/1",//要请求数据的文件路径
    toolbar: '#toolbar1',//指定工具栏
    striped: true, //是否显示行间隔色
    dataField: "res",
    sortable: true, //是否启用排序 sortOrder: "ID asc",
    sortOrder: "ID asc",
    pagination: true,//是否分页
    queryParamsType: 'limit',//查询参数组织方式
    queryParams: queryParams,//请求服务器时所传的参数
    sidePagination: 'client',//指定服务器端分页
    pageNumber: 1, //初始化加载第一页，默认第一页
    pageSize: 10,//单页记录数
    pageList: [10, 20, 30, 40, 50, 60, 70, 80, 90, 100],//分页步进值
    showRefresh: true,//刷新按钮
    showColumns: true,
    clickToSelect: true,//是否启用点击选中行
    toolbarAlign: 'right',//工具栏对齐方式
    buttonsAlign: 'right',//按钮对齐方式
    toolbar: '#toolbar1', search: true,
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
            field: 'name',
            title: '联系人',
            align: 'center',
            sortable: true
        },
        {
            field: 'phone',
            title: '联系方式',
            align: 'center',
            sortable: true
        },
        {
            field: 'adress',
            title: '地址',
            align: 'center',
            sortable: true
        },
        {
            field: 'isOften',
            title: '是否默认地址',
            align: 'center',
            sortable: true,
            formatter: function (value, row, index) {
                if (value == 0) {
                    //表示启用状态
                    return '<span style="color: green" >是</span>';
                } else {
                    //表示启用状态
                    return '<span style="color: red" >否</span>';
                }
            }
        },
        {
            field: 'updateTime',
            title: '修改时间',
            align: 'center',
            sortable: true
        },
        {
            field: 'createTime',
            title: '创建时间',
            align: 'center',
            sortable: true
        },
        {
            title: '操作',
            align: 'center',
            field: '',
            formatter: function (value, row, index) {
                var e = '<a title="编辑" href="javascript:void(0);" id="address"  onclick="return editAddress(\'' + row.id + '\')"><i class="glyphicon glyphicon-pencil" alt="修改" style="color:green">修改</i></a> ';
                var d = '<a title="删除" href="javascript:void(0);" onclick="delAdress(\'' + row.id + '\')"><i class="glyphicon glyphicon-trash" alt="删除" style="color:red">删除</i></a> ';
                var f = '';
                if (row.isActive == 1) {
                    f = '<a title="启用" href="javascript:void(0);" onclick="updatestatus(\'' + row.id + '\',' + 0 + ')"><i class="glyphicon glyphicon-ok-sign" style="color:green">启用</i></a> ';
                } else if (row.isActive == 0) {
                    f = '<a title="停用" href="javascript:void(0);" onclick="updatestatus(\'' + row.id + '\',' + 1 + ')"><i class="glyphicon glyphicon-remove-sign"  style="color:red">停用</i></a> ';
                }

                return e + d;
            }
        }
    ],
    locale: 'zh-CN',

})


function refushLove(id) {
    $('#mytab3').bootstrapTable('refresh', {
        url: '/readUserBehave/findList/' + id
    });
}
var idValues = '';
function love(id) {
    idValues = id;
    refushLove(id);
}
$("#add_add_love").click(function () {
    $("#readUserId_add_love").val(idValues);
    $.post(
        "/readUserBehave/saveOrUpdate",
        $('#form_add_love').serialize(),
        function (data) {
            if (data.msg == "操作成功") {
                layer.alert(data.msg, {icon: 6});
                refushLove(idValues);
            } else {
                layer.alert(data.msg, {icon: 6});
                refushLove(idValues);
            }
        }, "json"
    );
});
function editLove(id) {

    $.get("/readUserBehave/edit/" + id,
        function (data) {
            $("#form_add_love").autofill(data);
            $("#add_add_love").html("确认修改");
        },
        "json"
    );
}
function resetLove() {
    $("#id_add_love").val("");
    $("#readUserId_add_love").val(idValues);
    $("#add_add_love").html("确认新增");
}
$('#love_item_list').on('hide.bs.modal', function () {
    $("#reset_add_love").trigger("click");
});
function loveDel(id) {

    layer.confirm('确认要删除吗？', function (index) {
        $.post("/readUserBehave/remove",
            {
                "id": id
            },
            function (data) {
                if (data.msg == "ok") {
                    layer.alert(data.msg, {icon: 5});
                } else {
                    layer.alert(data.msg, {icon: 6});
                }
                refushLove(idValues);
            },
            "json"
        );
    });
}
//生成用户数据
$('#mytab3').bootstrapTable({
    method: 'post',
    contentType: "application/x-www-form-urlencoded",//必须要有！！！！
    url: "/readUserBehave/findList/1",//要请求数据的文件路径
    toolbar: '#toolbar2',//指定工具栏
    striped: true, //是否显示行间隔色
    dataField: "res",
    sortable: true, //是否启用排序 sortOrder: "ID asc",
    sortOrder: "ID asc",
    pagination: true,//是否分页
    queryParamsType: 'limit',//查询参数组织方式
    queryParams: queryParams,//请求服务器时所传的参数
    sidePagination: 'client',//指定服务器端分页
    pageNumber: 1, //初始化加载第一页，默认第一页
    pageSize: 10,//单页记录数
    pageList: [10, 20, 30, 40, 50, 60, 70, 80, 90, 100],//分页步进值
    showRefresh: true,//刷新按钮
    showColumns: true,
    clickToSelect: true,//是否启用点击选中行
    toolbarAlign: 'right',//工具栏对齐方式
    buttonsAlign: 'right',//按钮对齐方式
    toolbar: '#toolbar2', search: true,
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
            field: 'id',
            title: '兴趣爱好编号',
            align: 'center',
            sortable: true
        },
        {
            field: 'readUserId',
            title: '读者编号',
            align: 'center',
            sortable: true
        },
        {
            field: 'title',
            title: '兴趣名称',
            align: 'center',
            sortable: true
        },
        {
            field: 'createTime',
            title: '创建时间',
            align: 'center',
            sortable: true
        },
        {
            title: '操作',
            align: 'center',
            field: '',
            formatter: function (value, row, index) {
                var e = '<a title="编辑" href="javascript:void(0);" id="readUserBehave"  onclick="return editLove(\'' + row.id + '\')"><i class="glyphicon glyphicon-pencil" alt="修改" style="color:green">修改</i></a> ';
                var d = '<a title="删除" href="javascript:void(0);" onclick="loveDel(\'' + row.id + '\',' + row.isActive + ')"><i class="glyphicon glyphicon-trash" alt="删除" style="color:red">删除</i></a> ';
                var f = '';
                if (row.isActive == 1) {
                    f = '<a title="启用" href="javascript:void(0);" onclick="updatestatus(\'' + row.id + '\',' + 0 + ')"><i class="glyphicon glyphicon-ok-sign" style="color:green">启用</i></a> ';
                } else if (row.isActive == 0) {
                    f = '<a title="停用" href="javascript:void(0);" onclick="updatestatus(\'' + row.id + '\',' + 1 + ')"><i class="glyphicon glyphicon-remove-sign"  style="color:red">停用</i></a> ';
                }

                return e + d;
            }
        }
    ],
    locale: 'zh-CN',

})