//生成用户数据
var path = "http://file.mykefang.com/";
$('#mytab').bootstrapTable({
    method: 'post',
    contentType: "application/x-www-form-urlencoded",//必须要有！！！！
    url: "/readUser/list",//要请求数据的文件路径
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
                return '<img style="width: 60px;height: 60px;border-radius: 100%" src="' + path + value + '"/>';
            }
        },
        {
            field: 'name',
            title: '读者姓名',
            align: 'center',
            sortable: true
        },
        {
            field: 'cardNum',
            title: '读者证号',
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
            field: 'phone',
            title: '读者手机号',
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
                    return '<span class="label label-primary">男</span>';
                } else{
                    return '<span class="label label-danger">女</span>';
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
            field: 'email',
            title: '邮箱',
            align: 'center',
            sortable: true
        },
        {
            field: 'isActive',
            title: '状态',
            align: 'center',
            sortable: true,
            formatter: function (value, row, index) {
                if (value == 0) {
                    //表示启用状态
                    return '<span style="color: green" >启用</span>';
                } else {
                    //表示启用状态
                    return '<span style="color: red" >停用</span>';
                }
            }
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
                var e = '<a title="修改" href="javascript:void(0);" id="readUser"  data-toggle="modal" data-id="\'' + row.id + '\'" data-target="#myModal" onclick="return edit(\'' + row.id + '\')"><i class="glyphicon glyphicon-pencil" alt="修改" style="color:green">修改</i></a> ';
                var d = '<a title="删除" href="javascript:void(0);" onclick="del(\'' + row.id + '\',' + row.isActive + ')"><i class="glyphicon glyphicon-trash" alt="删除" style="color:red">删除</i></a> ';
                var p = '<a title="重置密码" href="javascript:void(0);" onclick="resetPwd(\'' + row.id + '\')"><i class="glyphicon glyphicon-trash" alt="重置密码" style="color:red">重置密码</i></a>';
                var f = '';
                if (row.isActive == 1) {
                    f = '<a title="启用" role="menuitem" tabindex="-1"  href="javascript:void(0);" onclick="updatestatus(\'' + row.id + '\',' + 0 + ')"><i class="glyphicon glyphicon-ok-sign" style="color:green">启用</i></a> ';
                } else if (row.isActive == 0) {
                    f = '<a title="停用" role="menuitem" tabindex="-1"  href="javascript:void(0);" onclick="updatestatus(\'' + row.id + '\',' + 1 + ')"><i class="glyphicon glyphicon-remove-sign"  style="color:red">停用</i></a> ';
                }
                var menu = '<div class="dropdown">\n' +
                    '    <button type="button" class="btn dropdown-toggle" id="dropdownMenu1" data-toggle="dropdown">操作\n' +
                    '        <span class="caret"></span>\n' +
                    '    </button>\n' +
                    '    <ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu1">\n' +
                    '        <li role="presentation">\n' +
                    '            <a role="menuitem" tabindex="-1" title="修改" href="javascript:void(0);" id="readUser"  data-toggle="modal" data-id="' + row.id + '" data-target="#myModal" onclick="return edit(\'' + row.id + '\')"><i class="glyphicon glyphicon-pencil" alt="修改" style="color:green">修改</i></a>\n' +
                    '        </li>\n' +
                    '        <li role="presentation">\n' +
                    '            <a role="menuitem" tabindex="-1" title="删除" href="javascript:void(0);" onclick="del(\'' + row.id + '\',' + row.isActive + ')"><i class="glyphicon glyphicon-trash" alt="删除" style="color:red">删除</i></a>\n' +
                    '        </li>\n' +
                    '        <li role="presentation">\n' +
                    '            <a role="menuitem" tabindex="-1" title="重置密码" href="javascript:void(0);" onclick="resetPwd(\'' + row.id + '\')"><i class="glyphicon glyphicon-repeat" alt="重置密码" style="color:green">重置密码</i></a>\n' +
                    '        </li>\n' +
                    '        <li role="presentation">' + f + '</li>' +
                    '        <li role="presentation" class="divider"></li>\n' +
                    '        <li role="presentation">\n' +
                    '            <a role="menuitem" tabindex="-1" data-toggle="modal" data-id="\' + row.id + \'" data-target="#love_item_list" onclick="return love(\'' + row.id + '\')"><i class="glyphicon glyphicon-th-list" alt="兴趣爱好" style="color:green" >兴趣爱好</i></a>\n' +
                    '        </li>\n' +
                    '        <li role="presentation">\n' +
                    '            <a role="menuitem" tabindex="-1"  data-toggle="modal" data-id="\' + row.id + \'" data-target="#order_item_list" onclick="return address(\'' + row.id + '\')"><i class="glyphicon glyphicon-th-large" alt="收货地址" style="color:green" >收货地址</i></a>\n' +
                    '        </li>\n' +
                    '    </ul>\n' +
                    '</div>';
                return menu;
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
        $.post("/readUser/remove",
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
    $.get("/readUser/edit/" + name,
        function (data) {
            $("#updateform").autofill(data);
            $("#password_").val(data.password);
        },
        "json"
    );
}

function resetPwd(id) {
    $.get("/readUser/resetPwd/" + id,
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

function add() {
    //初始化校验
    $("#formadd").data('bootstrapValidator').destroy();
}

function updatestatus(id, status) {
    $.post("/readUser/update",
        {
            "id": id,
            "isActive": status
        },
        function (data) {
            if (status == 0) {
                if (data.code == 0) {
                    layer.alert("已启用", {icon: 1});
                } else {
                    layer.alert("操作失败", {icon: 2});
                }
            } else {
                if (data.code == 0) {
                    layer.alert("已停用", {icon: 1});
                } else {
                    layer.alert("操作失败", {icon: 2});
                }
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
        url: '/readUser/list',
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
        url: '/readUser/list',
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
            message: '读者姓名验证失败',
            validators: {
                notEmpty: {
                    message: '读者姓名不能为空'
                },
                stringLength: {
                    min: 2,
                    max: 10,
                    message: '读者姓名长度必须在2到10位之间'
                }
            }
        },
        cardNum: {
            message: '读者证号验证失败',
            validators: {
                notEmpty: {
                    message: '读者证号不能为空'
                }
            }
        },
        phone: {
            message: '读者手机号验证失败',
            validators: {
                notEmpty: {
                    message: '读者手机号不能为空'
                },
                stringLength: {
                    min: 11,
                    max: 11,
                    message: '读者手机号长度必须是11位'
                }
            }
        },
        password: {
            message: '读者登录密码验证失败',
            validators: {
                notEmpty: {
                    message: '读者登录密码不能为空'
                }
            }
        },
    }
});
$("#update").click(function () {
    $('#updateform').data('bootstrapValidator').validate();
    if (!$('#updateform').data('bootstrapValidator').isValid()) {
        return;
    }
    $.post(
        "/readUser/update",
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
            message: '读者姓名验证失败',
            validators: {
                notEmpty: {
                    message: '读者姓名不能为空'
                },
                stringLength: {
                    min: 2,
                    max: 10,
                    message: '读者姓名长度必须在2到10位之间'
                }
            }
        },
        cardNum: {
            message: '读者证号验证失败',
            validators: {
                notEmpty: {
                    message: '读者证号不能为空'
                }
            }
        },
        phone: {
            message: '读者手机号验证失败',
            validators: {
                notEmpty: {
                    message: '读者手机号不能为空'
                },
                stringLength: {
                    min: 11,
                    max: 11,
                    message: '读者手机号长度必须是11位'
                }
            }
        },
        password: {
            message: '读者登录密码验证失败',
            validators: {
                notEmpty: {
                    message: '读者登录密码不能为空'
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
        "/readUser/save",
        $('#formadd').serialize(),
        function (result) {
            if (result.code == 0) {
                layer.alert(result.msg, {icon: 1});
                $("#webAdd").modal('hide');
                $("#formadd").data('bootstrapValidator').destroy();
                $('#formadd')[0].reset();
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
            "/readUser/batchRemove",
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
            "/readUser/deleteManyReadUser",
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
            resetAddress();
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
            resetLove();
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