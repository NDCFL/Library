var prefix = "/sysDept";
var refush = '';
layui.config({
    base: '/module/'
}).extend({
    treetable: 'treetable-lay/treetable'
}).use(['table', 'treetable'], function() {
    var $ = layui.jquery;
    var table = layui.table;
    var treetable = layui.treetable;

    refush = function () {
        // 渲染表格
        layer.load(2);
        treetable.render({
            treeColIndex: 1,
            treeSpid: 0,
            treeIdName: 'deptId',
            treePidName: 'parentId',
            treeDefaultClose:true,
            elem: '#auth-table',
            url: '/sysDept/list',
            page: false,
            cols: [
                [{
                    type: 'numbers'
                },
                    {
                        field : 'name',
                        title : '部门名称',
                        valign : 'center',
                        witth :20
                    },
                    {
                        field : 'orderNum',
                        title : '排序',
                        align : 'center',
                        valign : 'center',
                    },
                    {
                        field : 'delFlag',
                        title : '状态',
                        align : 'center',
                        valign : 'center',
                        templet : function(item, index) {
                            if (item.delFlag == '0') {
                                return '<span class="label label-danger">禁用</span>';
                            } else if (item.delFlag == '1') {
                                return '<span class="label label-primary">正常</span>';
                            }
                        }
                    },
                    {
                        templet: '#auth-state',
                        width: 180,
                        align: 'center',
                        title: '操作',
                        templet: function(item) {
                            var e = '<a class="layui-badge layui-bg-green'
                                + s_edit_h
                                + '" href="#" mce_href="#" title="编辑" onclick="edit(\''
                                + item.deptId
                                + '\')"><i class="fa fa-edit"></i>编辑</a> ';
                            var p = '<a class="layui-badge layui-bg-blue'
                                + s_add_h
                                + '" href="#" mce_href="#" title="添加下级" onclick="add(\''
                                + item.deptId
                                + '\')"><i class="fa fa-plus"></i>新增</a> ';
                            var d = '<a class="layui-badge layui-bg-red '
                                + s_remove_h
                                + '" href="#" title="删除"  mce_href="#" onclick="remove(\''
                                + item.deptId
                                + '\')"><i class="fa fa-remove"></i>删除</a> ';
                            return e + d + p;
                        },
                    }
                ]
            ],
            done: function() {
                layer.closeAll('loading');
            }
        });
    }
    refush();
    $('#btn-expand').click(function() {
        treetable.expandAll('#auth-table');
    });

    $('#btn-fold').click(function() {
        treetable.foldAll('#auth-table');
    });
});
function reLoad() {
    refush();
}
function add(pId) {
    layer.open({
        type : 2,
        title : '增加',
        maxmin : true,
        shadeClose : false, // 点击遮罩关闭层
        area : [ '800px', '520px' ],
        content : prefix + '/add/' + pId
    });
}
function edit(id) {
    alert(id);
    layer.open({
        type : 2,
        title : '编辑',
        maxmin : true,
        shadeClose : false, // 点击遮罩关闭层
        area : [ '800px', '520px' ],
        content : prefix + '/edit/' + id // iframe的url
    });
}
function removeone(id) {
    layer.confirm('确定要删除选中的记录？', {
        btn : [ '确定', '取消' ]
    }, function() {
        $.ajax({
            url : prefix + "/remove",
            type : "post",
            data : {
                'deptId' : id
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
    var rows = $('#auth-table').bootstrapTable('getSelections'); // 返回所有选择的行，当没有选择的记录时，返回一个空数组
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
            ids[i] = row['deptId'];
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