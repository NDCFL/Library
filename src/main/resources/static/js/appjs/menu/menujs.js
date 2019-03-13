var prefix = "/menu";
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
            treeIdName: 'menuId',
            treePidName: 'parentId',
            treeDefaultClose:true,
            elem: '#auth-table',
            url: '/menu/list',
            page: false,
            cols: [
                [{
                    type: 'numbers'
                },
                    {
                        field: 'name',
                        minWidth: 180,
                        title: '权限名称'
                    },
                    {
                        field: 'perms',
                        title: '权限标识'
                    },
                    {
                        field: 'url',
                        title: '菜单url'
                    },
                    {
                        field: 'orderNum',
                        width: 60,
                        align: 'center',
                        title: '排序号'
                    },
                    {
                        field: 'type',
                        width: 80,
                        align: 'center',
                        templet: function(d) {
                            if(d.type == 0) {
                                return '<span class="layui-badge layui-bg-red">目录</span>';
                            }
                            if(d.type == 1) {
                                return '<span class="layui-badge layui-bg-blue">菜单</span>';
                            } else {
                                return '<span class="layui-badge-rim">按钮</span>';
                            }
                        },
                        title: '类型'
                    },
                    {
                        field: 'icon',
                        width: 80,
                        align: 'center',
                        templet: function(d) {
                            return '<i class="'+d.icon+'"></i>';
                        },
                        title: '图标'
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
                                + item.menuId
                                + '\')">编辑</a> ';
                            var p = '<a class="layui-badge layui-bg-blue'
                                + s_add_h
                                + '" href="#" mce_href="#" title="添加下级" onclick="add(\''
                                + item.menuId
                                + '\')">新增</a> ';
                            var d = '<a class="layui-badge layui-bg-red '
                                + s_remove_h
                                + '" href="#" title="删除"  mce_href="#" onclick="remove(\''
                                + item.menuId
                                + '\')">删除</a> ';
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
        type: 2,
        title: '增加菜单',
        maxmin: true,
        shadeClose: false, // 点击遮罩关闭层
        area: ['800px', '520px'],
        content: prefix + '/add/' + pId // iframe的url
    });
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
            success: function (data) {
                if (data.code == 0) {
                    layer.msg("删除成功");
                    refush();
                } else {
                    layer.msg(data.msg);
                }
            }
        });
    })
}

function edit(id) {
    layer.open({
        type: 2,
        title: '菜单修改',
        maxmin: true,
        shadeClose: false, // 点击遮罩关闭层
        area: ['800px', '520px'],
        content: prefix + '/edit/' + id // iframe的url
    });
}
