var prefix = "/generator"
//生成用户数据
$('#mytab').bootstrapTable({
    method: 'get',
    contentType: "application/x-www-form-urlencoded",//必须要有！！！！
    url: "/generator/list",//要请求数据的文件路径
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
            field: 'tableName', // 列字段名
            title: '表名称',
            align: 'center',
            sortable: true
        },
        {
            field: 'engine',
            title: 'engine',
            align: 'center',
            sortable: true
        },
        {
            field: 'tableComment',
            title: '表描述',
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
                var e = '<a title="代码生成" href="javascript:void(0);" id="book"   onclick="code(\'' + row.tableName + '\')">代码生成</a> ';
                return e;
            }
        }
    ],
    locale: 'zh-CN'
})

//请求服务数据时所传参数
function queryParams(params) {
    var title = "";
    $(".search input").each(function () {
        title = $(this).val();
    });
    return {
        //每页多少条数据
        pageSize: this.pageSize,
        //请求第几页
        pageIndex: this.pageNumber,
        searchVal: title
    }
}

function reLoad() {
    $('#mytab').bootstrapTable('refresh', {url: '/generator/list'});
}

function code(tableName) {
    location.href = prefix + "/code/" + tableName;
}

function batchCode() {
    var rows = $('#exampleTable').bootstrapTable('getSelections'); // 返回所有选择的行，当没有选择的记录时，返回一个空数组
    if (rows.length == 0) {
        layer.msg("请选择要生成代码的表");
        return;
    }
    var tables = new Array();
    // 遍历所有选择的行数据，取每条数据对应的ID
    $.each(rows, function (i, row) {
        tables[i] = row['tableName'];
    });
    location.href = prefix + "/batchCode?tables=" + JSON.stringify(tables);
}

function edit() {
    console.log('打开配置页面');
    layer.open({
        type: 2,
        title: '增加',
        maxmin: true,
        shadeClose: false,
        area: ['800px', '520px'],
        content: prefix + '/edit'
    });
}