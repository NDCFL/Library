var statusMap = ['可抢单','已抢单','已送达','已评分','未送达','申请已取消'];
//生成用户数据
$('#mytab').bootstrapTable({
    method: 'post',
    contentType: "application/x-www-form-urlencoded",//必须要有！！！！
    url: "/paperExpress/list",//要请求数据的文件路径
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
            field: 'readUserName',
            title: '读者名字',
            align: 'center',
            sortable: true
        },
        {
            field: 'readUserCardNum',
            title: '读者卡号',
            align: 'center',
            sortable: true
        },
        {
            field: 'isbn',
            title: 'isbn/issn',
            align: 'center',
            sortable: true
        },
        {
            field: 'bookName',
            title: '书籍名称',
            align: 'center',
            sortable: true
        },
        {
            field: 'status',
            title: '状态',
            align: 'center',
            sortable: true,
            formatter: function (value, row, index) {
                // 1：可抢单 2：已抢单 3：已送达 4：已评分 5：未送达 6：申请已取消
                return '<span style="color: green" >'+statusMap[parseInt(value)-1]+'</span>';
            }
        },
        {
            field: 'score',
            title: '评分',
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
                var e = '<a title="编辑" href="javascript:void(0);" id="paperExpress"  data-toggle="modal" data-id="\'' + row.id + '\'" data-target="#myModal" onclick="return edit(\'' + row.id + '\')"><i class="glyphicon glyphicon-pencil" alt="修改" style="color:green">修改</i></a> ';
                var d = '<a title="删除" href="javascript:void(0);" onclick="del(\'' + row.id + '\',' + row.isActive + ')"><i class="glyphicon glyphicon-trash" alt="删除" style="color:red">删除</i></a> ';
                var f = '<a title="评分"  data-toggle="modal"data-target="#updateStatus" onclick="return scores(\'' + row.id + '\')"><i class="glyphicon glyphicon-ok-sign" style="color:green">评分</i></a> ';
                return d + f;
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
    var times = $("#test_2").val();
    var start, end;
    if (!times) {
        start = null;
        end = null;
    } else {
        start = times.substring(0, 11) + "00:00:00";
        end = times.substring(13, times.length) + " 23:59:59";
    }
    return {
        //每页多少条数据
        'pager.pageSize': this.pageSize,
        //请求第几页
        'pager.pageIndex': this.pageNumber,
        //排序字段
        'pager.sort': 'create_time',
        //排序方式
        'pager.order': 'desc',
        createTime: start,
        endTime: end,
        readUserName: $("#readUserName__").val(),
        readUserCardNum: $("#readUserCardNum__").val(),
        isbn: $("#isbn__").val(),
        bookName: $("#bookName__").val()
    }
}

function scores(id) {
    $("#idvalue").val(id);
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
        $.post("/paperExpress/remove",
            {
                "id": id
            },
            function (data) {
                if (data.code ==0) {
                    layer.alert(data.msg, {icon: 1});
                } else {
                    layer.alert(data.msg, {icon: 2});
                }
                refush();
            },
            "json"
        );
    });
}
$("#updateScope").click(function () {
    $.post("/paperExpress/update",
        $("#forms").serialize(),
        function (data) {
            if (data.code == 0) {
                layer.alert("评分成功", {icon: 1});
            } else {
                layer.alert("评分失败", {icon: 2});
            }
            refush();
        },
        "json"
    );
});
function edit(name) {
    $.get("/paperExpress/edit/" + name,
        function (data) {
            $("#updateform").autofill(data);
        },
        "json"
    );
}

function updatestatus(id, status) {
    $.post("/paperExpress/update",
        {
            "id": id,
            "status": status
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
    var times = $("#test_2").val();
    var start, end;
    if (!times) {
        start = null;
        end = null;
    } else {
        start = times.substring(0, 11) + "00:00:00";
        end = times.substring(13, times.length) + " 23:59:59";
    }
    $('#mytab').bootstrapTable('refresh', {url: '/paperExpress/list' ,
        query: {
            createTime: start,
            endTime: end,
            readUserName: $("#readUserName__").val(),
            readUserCardNum: $("#readUserCardNum__").val(),
            isbn: $("#isbn__").val(),
            bookName: $("#bookName__").val()
        }
    });
})

function refush() {
    var times = $("#test_2").val();
    var start, end;
    if (!times) {
        start = null;
        end = null;
    } else {
        start = times.substring(0, 11) + "00:00:00";
        end = times.substring(13, times.length) + " 23:59:59";
    }
    $('#mytab').bootstrapTable('refresh', {url: '/paperExpress/list' ,
        query: {
            createTime: start,
            endTime: end,
            readUserName: $("#readUserName__").val(),
            readUserCardNum: $("#readUserCardNum__").val(),
            isbn: $("#isbn__").val(),
            bookName: $("#bookName__").val()
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
        "/paperExpress/update",
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
        "/paperExpress/save",
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
            "/paperExpress/batchRemove",
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
            "/paperExpress/deleteManyPaperExpress",
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