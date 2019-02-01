var prefix = "/oa/notify"
//生成用户数据
$('#mytab').bootstrapTable({
    method: 'get',
    contentType: "application/x-www-form-urlencoded",//必须要有！！！！
    url: prefix+"/list",//要请求数据的文件路径
    toolbar: '#toolbar',//指定工具栏
    striped: true, //是否显示行间隔色
    dataField: "res",
    sortable: true, //是否启用排序 sortOrder: "ID asc",
    sortOrder: "ID asc",
    pagination: true,//是否分页
    queryParamsType: 'pageSize',//查询参数组织方式
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
            visible :false,
            field : 'type',
            title : '类型',
            align: 'center',
            sortable: true
        },
        {
            field : 'title',
            width: '20%',
            title : '标题',
            formatter:function (value,row,index) {
                return '<a href="#" onclick="read(\''+ row.id+ '\')">'+row.title+'</a>';
            }
        },
        {
            field : 'content',
            width: '30%',
            title : '内容',
            align: 'center',
            sortable: true
        },
        {
            visible : false,
            field : 'files',
            title : '附件',
            align: 'center',
            sortable: true
        },
        {
            field : 'isRead',
            title : '状态',
            align :'center',
            formatter : function(value, row, index){
                if(value==0){
                    return '<span class="label label-warning">未读</span>';
                }else if(value==1){
                    return '<span class="label label-primary">已读</span>';
                }
            }
        },
        {
            visible : false,
            field : 'createBy',
            title : '创建者',
            align: 'center',
            sortable: true
        },
        {
            visible : false,
            field : 'createDate',
            title : '创建时间',
            align: 'center',
            sortable: true
        },
        {
            visible : false,
            field : 'updateBy',
            title : '更新者',
            align: 'center',
            sortable: true
        },
        {
            visible : false,
            field : 'updateDate',
            title : '更新时间',
            align: 'center',
            sortable: true
        },
        {
            field : 'remarks',
            title : '备注信息',
            align: 'center',
            sortable: true
        },
        {
            visible : false,
            field : 'delFlag',
            title : '删除标记'
        },
        {
            title: '操作',
            align: 'center',
            field: '',
            formatter: function (value, row, index) {
                var e = '<a class="btn btn-primary btn-sm" href="#" mce_href="#" title="打开" onclick="read(\''
                    + row.id
                    + '\')"><i class="fa fa-book"></i></a> ';
                var d = '<a class="btn btn-warning btn-sm ' + s_remove_h + '" href="#" title="删除"  mce_href="#" onclick="remove(\''
                    + row.id
                    + '\')"><i class="fa fa-remove"></i></a> ';
                var f = '<a class="btn btn-success btn-sm" href="#" title="备用"  mce_href="#" onclick="resetPwd(\''
                    + row.id
                    + '\')"><i class="fa fa-key"></i></a> ';
                return e ;
            }
        }
    ],
    locale: 'zh-CN',//中文支持
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
        searchVal: title
    }
}

function reLoad() {
    $('#mytab').bootstrapTable('refresh',{url:prefix+"/list"});
}
function read(id) {
    layer.open({
        type : 2,
        title : '查看',
        maxmin : true,
        shadeClose : false, // 点击遮罩关闭层
        area : [ '800px', '520px' ],
        content : prefix + '/read/' + id // iframe的url
    });
}
function add() {
    layer.open({
        type : 2,
        title : '增加',
        maxmin : true,
        shadeClose : false, // 点击遮罩关闭层
        area : [ '800px', '520px' ],
        content : prefix + '/add' // iframe的url
    });
}
function edit(id) {
    layer.open({
        type : 2,
        title : '编辑',
        maxmin : true,
        shadeClose : false, // 点击遮罩关闭层
        area : [ '800px', '520px' ],
        content : prefix + '/edit/' + id // iframe的url
    });
}
function remove(id) {
    layer.confirm('确定要删除选中的记录？', {
        btn : [ '确定', '取消' ]
    }, function() {
        $.ajax({
            url : prefix + "/remove",
            type : "post",
            data : {
                'id' : id
            },
            success : function(r) {
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

function resetPwd(id) {
}
function batchRemove() {
    var rows = $('#mytab').bootstrapTable('getSelections'); // 返回所有选择的行，当没有选择的记录时，返回一个空数组
    if (rows.length == 0) {
        layer.msg("请选择要删除的数据");
        return;
    }
    layer.confirm("确认要删除选中的'" + rows.length + "'条数据吗?", {
        btn : [ '确定', '取消' ]
        // 按钮
    }, function() {
        var ids = new Array();
        // 遍历所有选择的行数据，取每条数据对应的ID
        $.each(rows, function(i, row) {
            ids[i] = row['id'];
        });
        $.ajax({
            type : 'POST',
            data : {
                "ids" : ids
            },
            url : prefix + '/batchRemove',
            success : function(r) {
                if (r.code == 0) {
                    layer.msg(r.msg);
                    reLoad();
                } else {
                    layer.msg(r.msg);
                }
            }
        });
    }, function() {});
}