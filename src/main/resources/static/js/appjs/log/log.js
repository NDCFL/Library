var prefix = "/log"
//生成用户数据
$('#mytab').bootstrapTable({
    method: 'get',
    contentType: "application/x-www-form-urlencoded",//必须要有！！！！
    url: "/log/list",//要请求数据的文件路径
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
            field: 'userId',
            title: '用户Id',
            align: 'center',
            sortable: true
        },
        {
            field: 'username',
            title: '用户名',
            align: 'center',
            sortable: true
        },
        {
            field: 'operation',
            title: '操作',
            align: 'center',
            sortable: true
        },
        {
            field: 'time',
            title: '用时',
            align: 'center',
            sortable: true
        },
        {
            field: 'method',
            title: '方法',
            align: 'center',
            sortable: true
        },
        {
            field: 'params',
            title: '参数',
            align: 'center',
            sortable: true
            // formatter: function (value, row, index) {
            //         return '<a   data-toggle="modal"  title="点击查看详情" alt="点击查看详情" data-id="\'' + row.id + '\'" data-target="#remarks_modal" onclick="return remarkss(' + row + ')">'+"..."+'</a>';
            //
            // }
        },
        {
            field: 'ip',
            title: 'IP地址',
            align: 'center',
            sortable: true
        },
        {
            field: 'gmtCreate',
            title: '创建时间',
            align: 'center',
            sortable: true
        },
        {
            title: '操作',
            align: 'center',
            field: '',
            formatter: function (value, row, index) {
                var d = '<a title="删除" href="javascript:void(0);" onclick="remove(\'' + row.id+'\')"><i class="glyphicon glyphicon-trash" alt="删除" style="color:red">删除</i></a> ';
                return d;
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
        'pager.sort': 'gmt_create',
        'pager.order': 'desc',
        operation: $("#searchOperation").val(),
        username: $("#searchUsername").val(),

    }
}
function reLoad() {
    $('#mytab').bootstrapTable('refresh',{"url":"/log/list"});
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
            beforeSend: function (request) {
                index = layer.load();
            },
            success: function (r) {
                if (r.code == 0) {
                    layer.close(index);
                    layer.msg(r.msg);
                    reLoad();
                } else {
                    layer.msg(r.msg);
                }
            }
        });
    })
}

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
function remarkss(val) {
    console.log(JSON.stringify(val)+"=============");
    $("#showParams").html(val.params);
}