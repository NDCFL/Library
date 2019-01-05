/*
 Navicat Premium Data Transfer

 Source Server         : mysql
 Source Server Type    : MySQL
 Source Server Version : 50553
 Source Host           : localhost:3306
 Source Schema         : library

 Target Server Type    : MySQL
 Target Server Version : 50553
 File Encoding         : 65001

 Date: 05/01/2019 20:16:11
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for oa_notify
-- ----------------------------
DROP TABLE IF EXISTS `oa_notify`;
CREATE TABLE `oa_notify`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `type` char(1) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '类型',
  `title` varchar(200) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '标题',
  `content` varchar(2000) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '内容',
  `files` varchar(2000) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '附件',
  `status` char(1) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '状态',
  `create_by` bigint(20) NULL DEFAULT NULL COMMENT '创建者',
  `create_date` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '更新者',
  `update_date` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `remarks` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '备注信息',
  `del_flag` char(1) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT '0' COMMENT '删除标记',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `oa_notify_del_flag`(`del_flag`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 51 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '通知通告' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of oa_notify
-- ----------------------------
INSERT INTO `oa_notify` VALUES (42, '3', '苹果发布新手机了', '有全面屏的iphoneX', '', '1', 1, NULL, NULL, '2017-10-10 18:51:14', '', NULL);
INSERT INTO `oa_notify` VALUES (43, '3', '十九大要消灭贫困人口', '我还只有两三年的活头了', '', '1', 1, NULL, NULL, '2017-10-11 09:56:35', '', NULL);
INSERT INTO `oa_notify` VALUES (44, '3', '骑士又输了', '捉急', '', '1', 1, NULL, NULL, '2017-10-26 13:59:34', '', NULL);
INSERT INTO `oa_notify` VALUES (45, '1', '火箭5连败', '没有保罗不行呀', '', '1', 1, NULL, NULL, '2017-12-30 12:10:20', '', NULL);
INSERT INTO `oa_notify` VALUES (48, '3', 'asddd', 'dddddddd', NULL, '1', 1, NULL, NULL, '2018-10-16 16:34:11', 'asdsad', NULL);
INSERT INTO `oa_notify` VALUES (49, '3', '1111', '11111', NULL, '1', 1, NULL, NULL, '2019-01-05 18:49:49', '', NULL);
INSERT INTO `oa_notify` VALUES (50, '1', '开会', '开会', NULL, '1', 1, NULL, NULL, '2019-01-05 19:43:07', '', NULL);

-- ----------------------------
-- Table structure for oa_notify_record
-- ----------------------------
DROP TABLE IF EXISTS `oa_notify_record`;
CREATE TABLE `oa_notify_record`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `notify_id` bigint(20) NULL DEFAULT NULL COMMENT '通知通告ID',
  `user_id` bigint(20) NULL DEFAULT NULL COMMENT '接受人',
  `is_read` tinyint(1) NULL DEFAULT 0 COMMENT '阅读标记',
  `read_date` date NULL DEFAULT NULL COMMENT '阅读时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `oa_notify_record_notify_id`(`notify_id`) USING BTREE,
  INDEX `oa_notify_record_user_id`(`user_id`) USING BTREE,
  INDEX `oa_notify_record_read_flag`(`is_read`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 30 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '通知通告发送记录' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of oa_notify_record
-- ----------------------------
INSERT INTO `oa_notify_record` VALUES (19, 42, 1, 1, '2018-12-05');
INSERT INTO `oa_notify_record` VALUES (20, 43, 136, 0, NULL);
INSERT INTO `oa_notify_record` VALUES (21, 43, 133, 0, NULL);
INSERT INTO `oa_notify_record` VALUES (22, 43, 130, 0, NULL);
INSERT INTO `oa_notify_record` VALUES (23, 43, 1, 1, '2017-10-26');
INSERT INTO `oa_notify_record` VALUES (24, 44, 1, 1, '2018-12-16');
INSERT INTO `oa_notify_record` VALUES (25, 45, 1, 1, '2018-12-16');
INSERT INTO `oa_notify_record` VALUES (26, 45, 135, 0, NULL);
INSERT INTO `oa_notify_record` VALUES (27, 48, 137, 0, NULL);
INSERT INTO `oa_notify_record` VALUES (28, 49, 1, 1, '2019-01-05');
INSERT INTO `oa_notify_record` VALUES (29, 50, 1, 1, '2019-01-05');

-- ----------------------------
-- Table structure for sys_book
-- ----------------------------
DROP TABLE IF EXISTS `sys_book`;
CREATE TABLE `sys_book`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '图书编号',
  `book_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图书名称',
  `book_imei` bigint(20) NULL DEFAULT NULL COMMENT '图书序列号',
  `author` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '作者',
  `public_time` datetime NULL DEFAULT NULL COMMENT '发布时间',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '图书表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_book
-- ----------------------------
INSERT INTO `sys_book` VALUES (1, '1111', 111, '111', '2018-12-20 14:04:04', '2018-12-20 14:04:04');
INSERT INTO `sys_book` VALUES (2, '1', 1, '1', '2018-09-09 00:00:00', '2018-09-09 00:00:00');
INSERT INTO `sys_book` VALUES (3, '1', 1, '1', '2018-09-09 00:00:00', '2018-09-09 00:00:00');

-- ----------------------------
-- Table structure for sys_dept
-- ----------------------------
DROP TABLE IF EXISTS `sys_dept`;
CREATE TABLE `sys_dept`  (
  `dept_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `parent_id` bigint(20) NULL DEFAULT NULL COMMENT '上级部门ID，一级部门为0',
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '部门名称',
  `order_num` int(11) NULL DEFAULT NULL COMMENT '排序',
  `del_flag` tinyint(4) NULL DEFAULT 0 COMMENT '是否删除  -1：已删除  0：正常',
  PRIMARY KEY (`dept_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 16 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '部门管理' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_dept
-- ----------------------------
INSERT INTO `sys_dept` VALUES (6, 0, '图书馆3', 1, 1);
INSERT INTO `sys_dept` VALUES (7, 6, '研發一部', 1, 1);
INSERT INTO `sys_dept` VALUES (8, 6, '研发二部', 2, 1);
INSERT INTO `sys_dept` VALUES (9, 0, '图书馆2', 2, 1);
INSERT INTO `sys_dept` VALUES (10, 9, '销售一部', 1, 1);
INSERT INTO `sys_dept` VALUES (11, 0, '智能图书馆', 3, 1);
INSERT INTO `sys_dept` VALUES (12, 11, '产品一部', 1, 1);
INSERT INTO `sys_dept` VALUES (13, 0, '图书馆1', 5, 1);
INSERT INTO `sys_dept` VALUES (14, 13, '测试一部', 1, 1);
INSERT INTO `sys_dept` VALUES (15, 13, '测试二部', 2, 1);

-- ----------------------------
-- Table structure for sys_dict
-- ----------------------------
DROP TABLE IF EXISTS `sys_dict`;
CREATE TABLE `sys_dict`  (
  `id` bigint(64) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `name` varchar(100) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '标签名',
  `value` varchar(100) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '数据值',
  `type` varchar(100) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '类型',
  `description` varchar(100) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '描述',
  `sort` decimal(10, 0) NULL DEFAULT NULL COMMENT '排序（升序）',
  `parent_id` bigint(64) NULL DEFAULT 0 COMMENT '父级编号',
  `create_by` int(64) NULL DEFAULT NULL COMMENT '创建者',
  `create_date` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` bigint(64) NULL DEFAULT NULL COMMENT '更新者',
  `update_date` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `remarks` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '备注信息',
  `del_flag` char(1) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT '0' COMMENT '删除标记',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `sys_dict_value`(`value`) USING BTREE,
  INDEX `sys_dict_label`(`name`) USING BTREE,
  INDEX `sys_dict_del_flag`(`del_flag`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 123 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '字典表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_dict
-- ----------------------------
INSERT INTO `sys_dict` VALUES (1, '正常', '0', 'del_flag', '删除标记', 10, 0, 1, NULL, 1, NULL, NULL, '0');
INSERT INTO `sys_dict` VALUES (3, '显示', '1', 'show_hide', '显示/隐藏', 10, 0, 1, NULL, 1, NULL, NULL, '0');
INSERT INTO `sys_dict` VALUES (4, '隐藏', '0', 'show_hide', '显示/隐藏', 20, 0, 1, NULL, 1, NULL, NULL, '0');
INSERT INTO `sys_dict` VALUES (5, '是', '1', 'yes_no', '是/否', 10, 0, 1, NULL, 1, NULL, NULL, '0');
INSERT INTO `sys_dict` VALUES (6, '否', '0', 'yes_no', '是/否', 20, 0, 1, NULL, 1, NULL, NULL, '0');
INSERT INTO `sys_dict` VALUES (7, '红色', 'red', 'color', '颜色值', 10, 0, 1, NULL, 1, NULL, NULL, '0');
INSERT INTO `sys_dict` VALUES (8, '绿色', 'green', 'color', '颜色值', 20, 0, 1, NULL, 1, NULL, NULL, '0');
INSERT INTO `sys_dict` VALUES (9, '蓝色', 'blue', 'color', '颜色值', 30, 0, 1, NULL, 1, NULL, NULL, '0');
INSERT INTO `sys_dict` VALUES (10, '黄色', 'yellow', 'color', '颜色值', 40, 0, 1, NULL, 1, NULL, NULL, '0');
INSERT INTO `sys_dict` VALUES (11, '橙色', 'orange', 'color', '颜色值', 50, 0, 1, NULL, 1, NULL, NULL, '0');
INSERT INTO `sys_dict` VALUES (12, '默认主题', 'default', 'theme', '主题方案', 10, 0, 1, NULL, 1, NULL, NULL, '0');
INSERT INTO `sys_dict` VALUES (13, '天蓝主题', 'cerulean', 'theme', '主题方案', 20, 0, 1, NULL, 1, NULL, NULL, '0');
INSERT INTO `sys_dict` VALUES (14, '橙色主题', 'readable', 'theme', '主题方案', 30, 0, 1, NULL, 1, NULL, NULL, '0');
INSERT INTO `sys_dict` VALUES (15, '红色主题', 'united', 'theme', '主题方案', 40, 0, 1, NULL, 1, NULL, NULL, '0');
INSERT INTO `sys_dict` VALUES (16, 'Flat主题', 'flat', 'theme', '主题方案', 60, 0, 1, NULL, 1, NULL, NULL, '0');
INSERT INTO `sys_dict` VALUES (17, '国家', '1', 'sys_area_type', '区域类型', 10, 0, 1, NULL, 1, NULL, NULL, '0');
INSERT INTO `sys_dict` VALUES (18, '省份、直辖市', '2', 'sys_area_type', '区域类型', 20, 0, 1, NULL, 1, NULL, NULL, '0');
INSERT INTO `sys_dict` VALUES (19, '地市', '3', 'sys_area_type', '区域类型', 30, 0, 1, NULL, 1, NULL, NULL, '0');
INSERT INTO `sys_dict` VALUES (20, '区县', '4', 'sys_area_type', '区域类型', 40, 0, 1, NULL, 1, NULL, NULL, '0');
INSERT INTO `sys_dict` VALUES (21, '公司', '1', 'sys_office_type', '机构类型', 60, 0, 1, NULL, 1, NULL, NULL, '0');
INSERT INTO `sys_dict` VALUES (22, '部门', '2', 'sys_office_type', '机构类型', 70, 0, 1, NULL, 1, NULL, NULL, '0');
INSERT INTO `sys_dict` VALUES (23, '小组', '3', 'sys_office_type', '机构类型', 80, 0, 1, NULL, 1, NULL, NULL, '0');
INSERT INTO `sys_dict` VALUES (24, '其它', '4', 'sys_office_type', '机构类型', 90, 0, 1, NULL, 1, NULL, NULL, '0');
INSERT INTO `sys_dict` VALUES (25, '综合部', '1', 'sys_office_common', '快捷通用部门', 30, 0, 1, NULL, 1, NULL, NULL, '0');
INSERT INTO `sys_dict` VALUES (26, '开发部', '2', 'sys_office_common', '快捷通用部门', 40, 0, 1, NULL, 1, NULL, NULL, '0');
INSERT INTO `sys_dict` VALUES (27, '人力部', '3', 'sys_office_common', '快捷通用部门', 50, 0, 1, NULL, 1, NULL, NULL, '0');
INSERT INTO `sys_dict` VALUES (28, '一级', '1', 'sys_office_grade', '机构等级', 10, 0, 1, NULL, 1, NULL, NULL, '0');
INSERT INTO `sys_dict` VALUES (29, '二级', '2', 'sys_office_grade', '机构等级', 20, 0, 1, NULL, 1, NULL, NULL, '0');
INSERT INTO `sys_dict` VALUES (30, '三级', '3', 'sys_office_grade', '机构等级', 30, 0, 1, NULL, 1, NULL, NULL, '0');
INSERT INTO `sys_dict` VALUES (31, '四级', '4', 'sys_office_grade', '机构等级', 40, 0, 1, NULL, 1, NULL, NULL, '0');
INSERT INTO `sys_dict` VALUES (32, '所有数据', '1', 'sys_data_scope', '数据范围', 10, 0, 1, NULL, 1, NULL, NULL, '0');
INSERT INTO `sys_dict` VALUES (33, '所在公司及以下数据', '2', 'sys_data_scope', '数据范围', 20, 0, 1, NULL, 1, NULL, NULL, '0');
INSERT INTO `sys_dict` VALUES (34, '所在公司数据', '3', 'sys_data_scope', '数据范围', 30, 0, 1, NULL, 1, NULL, NULL, '0');
INSERT INTO `sys_dict` VALUES (35, '所在部门及以下数据', '4', 'sys_data_scope', '数据范围', 40, 0, 1, NULL, 1, NULL, NULL, '0');
INSERT INTO `sys_dict` VALUES (36, '所在部门数据', '5', 'sys_data_scope', '数据范围', 50, 0, 1, NULL, 1, NULL, NULL, '0');
INSERT INTO `sys_dict` VALUES (37, '仅本人数据', '8', 'sys_data_scope', '数据范围', 90, 0, 1, NULL, 1, NULL, NULL, '0');
INSERT INTO `sys_dict` VALUES (38, '按明细设置', '9', 'sys_data_scope', '数据范围', 100, 0, 1, NULL, 1, NULL, NULL, '0');
INSERT INTO `sys_dict` VALUES (39, '系统管理', '1', 'sys_user_type', '用户类型', 10, 0, 1, NULL, 1, NULL, NULL, '0');
INSERT INTO `sys_dict` VALUES (40, '部门经理', '2', 'sys_user_type', '用户类型', 20, 0, 1, NULL, 1, NULL, NULL, '0');
INSERT INTO `sys_dict` VALUES (41, '普通用户', '3', 'sys_user_type', '用户类型', 30, 0, 1, NULL, 1, NULL, NULL, '0');
INSERT INTO `sys_dict` VALUES (42, '基础主题', 'basic', 'cms_theme', '站点主题', 10, 0, 1, NULL, 1, NULL, NULL, '0');
INSERT INTO `sys_dict` VALUES (43, '蓝色主题', 'blue', 'cms_theme', '站点主题', 20, 0, 1, NULL, 1, NULL, NULL, '1');
INSERT INTO `sys_dict` VALUES (44, '红色主题', 'red', 'cms_theme', '站点主题', 30, 0, 1, NULL, 1, NULL, NULL, '1');
INSERT INTO `sys_dict` VALUES (45, '文章模型', 'article', 'cms_module', '栏目模型', 10, 0, 1, NULL, 1, NULL, NULL, '0');
INSERT INTO `sys_dict` VALUES (46, '图片模型', 'picture', 'cms_module', '栏目模型', 20, 0, 1, NULL, 1, NULL, NULL, '1');
INSERT INTO `sys_dict` VALUES (47, '下载模型', 'download', 'cms_module', '栏目模型', 30, 0, 1, NULL, 1, NULL, NULL, '1');
INSERT INTO `sys_dict` VALUES (48, '链接模型', 'link', 'cms_module', '栏目模型', 40, 0, 1, NULL, 1, NULL, NULL, '0');
INSERT INTO `sys_dict` VALUES (49, '专题模型', 'special', 'cms_module', '栏目模型', 50, 0, 1, NULL, 1, NULL, NULL, '1');
INSERT INTO `sys_dict` VALUES (50, '默认展现方式', '0', 'cms_show_modes', '展现方式', 10, 0, 1, NULL, 1, NULL, NULL, '0');
INSERT INTO `sys_dict` VALUES (51, '首栏目内容列表', '1', 'cms_show_modes', '展现方式', 20, 0, 1, NULL, 1, NULL, NULL, '0');
INSERT INTO `sys_dict` VALUES (52, '栏目第一条内容', '2', 'cms_show_modes', '展现方式', 30, 0, 1, NULL, 1, NULL, NULL, '0');
INSERT INTO `sys_dict` VALUES (53, '发布', '0', 'cms_del_flag', '内容状态', 10, 0, 1, NULL, 1, NULL, NULL, '0');
INSERT INTO `sys_dict` VALUES (54, '删除', '1', 'cms_del_flag', '内容状态', 20, 0, 1, NULL, 1, NULL, NULL, '0');
INSERT INTO `sys_dict` VALUES (55, '审核', '2', 'cms_del_flag', '内容状态', 15, 0, 1, NULL, 1, NULL, NULL, '0');
INSERT INTO `sys_dict` VALUES (56, '首页焦点图', '1', 'cms_posid', '推荐位', 10, 0, 1, NULL, 1, NULL, NULL, '0');
INSERT INTO `sys_dict` VALUES (57, '栏目页文章推荐', '2', 'cms_posid', '推荐位', 20, 0, 1, NULL, 1, NULL, NULL, '0');
INSERT INTO `sys_dict` VALUES (58, '咨询', '1', 'cms_guestbook', '留言板分类', 10, 0, 1, NULL, 1, NULL, NULL, '0');
INSERT INTO `sys_dict` VALUES (59, '建议', '2', 'cms_guestbook', '留言板分类', 20, 0, 1, NULL, 1, NULL, NULL, '0');
INSERT INTO `sys_dict` VALUES (60, '投诉', '3', 'cms_guestbook', '留言板分类', 30, 0, 1, NULL, 1, NULL, NULL, '0');
INSERT INTO `sys_dict` VALUES (61, '其它', '4', 'cms_guestbook', '留言板分类', 40, 0, 1, NULL, 1, NULL, NULL, '0');
INSERT INTO `sys_dict` VALUES (62, '公休', '1', 'oa_leave_type', '请假类型', 10, 0, 1, NULL, 1, NULL, NULL, '0');
INSERT INTO `sys_dict` VALUES (63, '病假', '2', 'oa_leave_type', '请假类型', 20, 0, 1, NULL, 1, NULL, NULL, '0');
INSERT INTO `sys_dict` VALUES (64, '事假', '3', 'oa_leave_type', '请假类型', 30, 0, 1, NULL, 1, NULL, NULL, '0');
INSERT INTO `sys_dict` VALUES (65, '调休', '4', 'oa_leave_type', '请假类型', 40, 0, 1, NULL, 1, NULL, NULL, '0');
INSERT INTO `sys_dict` VALUES (66, '婚假', '5', 'oa_leave_type', '请假类型', 60, 0, 1, NULL, 1, NULL, NULL, '0');
INSERT INTO `sys_dict` VALUES (67, '接入日志', '1', 'sys_log_type', '日志类型', 30, 0, 1, NULL, 1, NULL, NULL, '0');
INSERT INTO `sys_dict` VALUES (68, '异常日志', '2', 'sys_log_type', '日志类型', 40, 0, 1, NULL, 1, NULL, NULL, '0');
INSERT INTO `sys_dict` VALUES (69, '请假流程', 'leave', 'act_type', '流程类型', 10, 0, 1, NULL, 1, NULL, NULL, '0');
INSERT INTO `sys_dict` VALUES (70, '审批测试流程', 'test_audit', 'act_type', '流程类型', 20, 0, 1, NULL, 1, NULL, NULL, '0');
INSERT INTO `sys_dict` VALUES (71, '分类1', '1', 'act_category', '流程分类', 10, 0, 1, NULL, 1, NULL, NULL, '0');
INSERT INTO `sys_dict` VALUES (72, '分类2', '2', 'act_category', '流程分类', 20, 0, 1, NULL, 1, NULL, NULL, '0');
INSERT INTO `sys_dict` VALUES (73, '增删改查', 'crud', 'gen_category', '代码生成分类', 10, 0, 1, NULL, 1, NULL, NULL, '1');
INSERT INTO `sys_dict` VALUES (74, '增删改查（包含从表）', 'crud_many', 'gen_category', '代码生成分类', 20, 0, 1, NULL, 1, NULL, NULL, '1');
INSERT INTO `sys_dict` VALUES (75, '树结构', 'tree', 'gen_category', '代码生成分类', 30, 0, 1, NULL, 1, NULL, NULL, '1');
INSERT INTO `sys_dict` VALUES (76, '=', '=', 'gen_query_type', '查询方式', 10, 0, 1, NULL, 1, NULL, NULL, '1');
INSERT INTO `sys_dict` VALUES (77, '!=', '!=', 'gen_query_type', '查询方式', 20, 0, 1, NULL, 1, NULL, NULL, '1');
INSERT INTO `sys_dict` VALUES (78, '&gt;', '&gt;', 'gen_query_type', '查询方式', 30, 0, 1, NULL, 1, NULL, NULL, '1');
INSERT INTO `sys_dict` VALUES (79, '&lt;', '&lt;', 'gen_query_type', '查询方式', 40, 0, 1, NULL, 1, NULL, NULL, '1');
INSERT INTO `sys_dict` VALUES (80, 'Between', 'between', 'gen_query_type', '查询方式', 50, 0, 1, NULL, 1, NULL, NULL, '1');
INSERT INTO `sys_dict` VALUES (81, 'Like', 'like', 'gen_query_type', '查询方式', 60, 0, 1, NULL, 1, NULL, NULL, '1');
INSERT INTO `sys_dict` VALUES (82, 'Left Like', 'left_like', 'gen_query_type', '查询方式', 70, 0, 1, NULL, 1, NULL, NULL, '1');
INSERT INTO `sys_dict` VALUES (83, 'Right Like', 'right_like', 'gen_query_type', '查询方式', 80, 0, 1, NULL, 1, NULL, NULL, '1');
INSERT INTO `sys_dict` VALUES (84, '文本框', 'input', 'gen_show_type', '字段生成方案', 10, 0, 1, NULL, 1, NULL, NULL, '1');
INSERT INTO `sys_dict` VALUES (85, '文本域', 'textarea', 'gen_show_type', '字段生成方案', 20, 0, 1, NULL, 1, NULL, NULL, '1');
INSERT INTO `sys_dict` VALUES (86, '下拉框', 'select', 'gen_show_type', '字段生成方案', 30, 0, 1, NULL, 1, NULL, NULL, '1');
INSERT INTO `sys_dict` VALUES (87, '复选框', 'checkbox', 'gen_show_type', '字段生成方案', 40, 0, 1, NULL, 1, NULL, NULL, '1');
INSERT INTO `sys_dict` VALUES (88, '单选框', 'radiobox', 'gen_show_type', '字段生成方案', 50, 0, 1, NULL, 1, NULL, NULL, '1');
INSERT INTO `sys_dict` VALUES (89, '日期选择', 'dateselect', 'gen_show_type', '字段生成方案', 60, 0, 1, NULL, 1, NULL, NULL, '1');
INSERT INTO `sys_dict` VALUES (90, '人员选择', 'userselect', 'gen_show_type', '字段生成方案', 70, 0, 1, NULL, 1, NULL, NULL, '1');
INSERT INTO `sys_dict` VALUES (91, '部门选择', 'officeselect', 'gen_show_type', '字段生成方案', 80, 0, 1, NULL, 1, NULL, NULL, '1');
INSERT INTO `sys_dict` VALUES (92, '区域选择', 'areaselect', 'gen_show_type', '字段生成方案', 90, 0, 1, NULL, 1, NULL, NULL, '1');
INSERT INTO `sys_dict` VALUES (93, 'String', 'String', 'gen_java_type', 'Java类型', 10, 0, 1, NULL, 1, NULL, NULL, '1');
INSERT INTO `sys_dict` VALUES (94, 'Long', 'Long', 'gen_java_type', 'Java类型', 20, 0, 1, NULL, 1, NULL, NULL, '1');
INSERT INTO `sys_dict` VALUES (95, '仅持久层', 'dao', 'gen_category', '代码生成分类', 40, 0, 1, NULL, 1, NULL, NULL, '1');
INSERT INTO `sys_dict` VALUES (96, '男', '1', 'sex', '性别', 10, 0, 1, NULL, 1, NULL, NULL, '0');
INSERT INTO `sys_dict` VALUES (97, '女', '2', 'sex', '性别', 20, 0, 1, NULL, 1, NULL, NULL, '0');
INSERT INTO `sys_dict` VALUES (98, 'Integer', 'Integer', 'gen_java_type', 'Java类型', 30, 0, 1, NULL, 1, NULL, NULL, '1');
INSERT INTO `sys_dict` VALUES (99, 'Double', 'Double', 'gen_java_type', 'Java类型', 40, 0, 1, NULL, 1, NULL, NULL, '1');
INSERT INTO `sys_dict` VALUES (100, 'Date', 'java.util.Date', 'gen_java_type', 'Java类型', 50, 0, 1, NULL, 1, NULL, NULL, '1');
INSERT INTO `sys_dict` VALUES (104, 'Custom', 'Custom', 'gen_java_type', 'Java类型', 90, 0, 1, NULL, 1, NULL, NULL, '1');
INSERT INTO `sys_dict` VALUES (105, '会议通告', '1', 'oa_notify_type', '通知通告类型', 10, 0, 1, NULL, 1, NULL, NULL, '0');
INSERT INTO `sys_dict` VALUES (106, '奖惩通告', '2', 'oa_notify_type', '通知通告类型', 20, 0, 1, NULL, 1, NULL, NULL, '0');
INSERT INTO `sys_dict` VALUES (107, '活动通告', '3', 'oa_notify_type', '通知通告类型', 30, 0, 1, NULL, 1, NULL, NULL, '0');
INSERT INTO `sys_dict` VALUES (108, '草稿', '0', 'oa_notify_status', '通知通告状态', 10, 0, 1, NULL, 1, NULL, NULL, '0');
INSERT INTO `sys_dict` VALUES (109, '发布', '1', 'oa_notify_status', '通知通告状态', 20, 0, 1, NULL, 1, NULL, NULL, '0');
INSERT INTO `sys_dict` VALUES (110, '未读', '0', 'oa_notify_read', '通知通告状态', 10, 0, 1, NULL, 1, NULL, NULL, '0');
INSERT INTO `sys_dict` VALUES (111, '已读', '1', 'oa_notify_read', '通知通告状态', 20, 0, 1, NULL, 1, NULL, NULL, '0');
INSERT INTO `sys_dict` VALUES (112, '草稿', '0', 'oa_notify_status', '通知通告状态', 10, 0, 1, NULL, 1, NULL, '', '0');
INSERT INTO `sys_dict` VALUES (113, '删除', '0', 'del_flag', '删除标记', NULL, NULL, NULL, NULL, NULL, NULL, '', '');
INSERT INTO `sys_dict` VALUES (118, '关于', 'about', 'blog_type', '博客类型', NULL, NULL, NULL, NULL, NULL, NULL, '全url是:/blog/open/page/about', '');
INSERT INTO `sys_dict` VALUES (119, '交流', 'communication', 'blog_type', '博客类型', NULL, NULL, NULL, NULL, NULL, NULL, '', '');
INSERT INTO `sys_dict` VALUES (120, '文章', 'article', 'blog_type', '博客类型', NULL, NULL, NULL, NULL, NULL, NULL, '', '');
INSERT INTO `sys_dict` VALUES (121, '编码', 'code', 'hobby', '爱好', NULL, NULL, NULL, NULL, NULL, NULL, '', '');
INSERT INTO `sys_dict` VALUES (122, '绘画', 'painting', 'hobby', '爱好', NULL, NULL, NULL, NULL, NULL, NULL, '', '');

-- ----------------------------
-- Table structure for sys_file
-- ----------------------------
DROP TABLE IF EXISTS `sys_file`;
CREATE TABLE `sys_file`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `type` int(11) NULL DEFAULT NULL COMMENT '文件类型',
  `url` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'URL地址',
  `create_date` datetime NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 147 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '文件上传' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_file
-- ----------------------------
INSERT INTO `sys_file` VALUES (145, 0, '/files/e431506c-0411-4b2b-81b8-3d375dd7c93b.jpg', '2018-12-16 09:50:03');
INSERT INTO `sys_file` VALUES (146, 0, '/files/438e6906-4969-4f01-b1da-eecae02d7775.jpg', '2018-12-16 09:50:14');

-- ----------------------------
-- Table structure for sys_log
-- ----------------------------
DROP TABLE IF EXISTS `sys_log`;
CREATE TABLE `sys_log`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NULL DEFAULT NULL COMMENT '用户id',
  `username` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `operation` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户操作',
  `time` int(11) NULL DEFAULT NULL COMMENT '响应时间',
  `method` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '请求方法',
  `params` varchar(5000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '请求参数',
  `ip` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'IP地址',
  `gmt_create` datetime NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 891 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '系统日志' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_log
-- ----------------------------
INSERT INTO `sys_log` VALUES (1, 1, 'admin', '登录', 12, 'com.bootdo.system.controller.LoginController.ajaxLogin()', NULL, '127.0.0.1', '2018-09-29 09:54:18');
INSERT INTO `sys_log` VALUES (2, 1, 'admin', '请求访问主页', 36, 'com.bootdo.system.controller.LoginController.index()', NULL, '127.0.0.1', '2018-09-29 09:54:18');
INSERT INTO `sys_log` VALUES (3, 1, 'admin', '登录', 17, 'com.bootdo.system.controller.LoginController.ajaxLogin()', NULL, '127.0.0.1', '2018-09-29 13:37:29');
INSERT INTO `sys_log` VALUES (4, 1, 'admin', '请求访问主页', 31, 'com.bootdo.system.controller.LoginController.index()', NULL, '127.0.0.1', '2018-09-29 13:37:29');
INSERT INTO `sys_log` VALUES (5, 1, 'admin', '登录', 30, 'com.bootdo.system.controller.LoginController.ajaxLogin()', NULL, '127.0.0.1', '2018-09-29 14:54:27');
INSERT INTO `sys_log` VALUES (6, 1, 'admin', '请求访问主页', 15, 'com.bootdo.system.controller.LoginController.index()', NULL, '127.0.0.1', '2018-09-29 14:54:27');
INSERT INTO `sys_log` VALUES (7, 1, 'admin', '登录', 4, 'com.bootdo.system.controller.LoginController.ajaxLogin()', NULL, '127.0.0.1', '2018-09-29 14:54:40');
INSERT INTO `sys_log` VALUES (8, 1, 'admin', '请求访问主页', 9, 'com.bootdo.system.controller.LoginController.index()', NULL, '127.0.0.1', '2018-09-29 14:54:40');
INSERT INTO `sys_log` VALUES (9, 1, 'admin', '编辑菜单', 4, 'com.bootdo.system.controller.MenuController.edit()', NULL, '127.0.0.1', '2018-09-29 14:55:23');
INSERT INTO `sys_log` VALUES (10, 1, 'admin', '更新菜单', 57, 'com.bootdo.system.controller.MenuController.update()', NULL, '127.0.0.1', '2018-09-29 14:55:32');
INSERT INTO `sys_log` VALUES (11, 1, 'admin', '登录', 5, 'com.bootdo.system.controller.LoginController.ajaxLogin()', NULL, '127.0.0.1', '2018-09-29 14:56:42');
INSERT INTO `sys_log` VALUES (12, 1, 'admin', '请求访问主页', 7, 'com.bootdo.system.controller.LoginController.index()', NULL, '127.0.0.1', '2018-09-29 14:56:42');
INSERT INTO `sys_log` VALUES (13, 1, 'admin', '登录', 61, 'com.bootdo.system.controller.LoginController.ajaxLogin()', NULL, '127.0.0.1', '2018-10-10 09:30:27');
INSERT INTO `sys_log` VALUES (14, 1, 'admin', '请求访问主页', 148, 'com.bootdo.system.controller.LoginController.index()', NULL, '127.0.0.1', '2018-10-10 09:30:27');
INSERT INTO `sys_log` VALUES (15, 1, 'admin', '编辑用户', 49, 'com.bootdo.system.controller.UserController.edit()', NULL, '127.0.0.1', '2018-10-10 09:30:52');
INSERT INTO `sys_log` VALUES (16, 1, 'admin', '请求更改用户密码', 0, 'com.bootdo.system.controller.UserController.resetPwd()', NULL, '127.0.0.1', '2018-10-10 09:31:06');
INSERT INTO `sys_log` VALUES (17, 1, 'admin', '登录', 5, 'com.bootdo.system.controller.LoginController.ajaxLogin()', NULL, '127.0.0.1', '2018-10-10 09:36:44');
INSERT INTO `sys_log` VALUES (18, 1, 'admin', '请求访问主页', 10, 'com.bootdo.system.controller.LoginController.index()', NULL, '127.0.0.1', '2018-10-10 09:36:44');
INSERT INTO `sys_log` VALUES (19, 1, 'admin', '登录', 4, 'com.bootdo.system.controller.LoginController.ajaxLogin()', NULL, '127.0.0.1', '2018-10-10 10:19:31');
INSERT INTO `sys_log` VALUES (20, 1, 'admin', '请求访问主页', 8, 'com.bootdo.system.controller.LoginController.index()', NULL, '127.0.0.1', '2018-10-10 10:19:31');
INSERT INTO `sys_log` VALUES (21, 1, 'admin', '编辑菜单', 4, 'com.bootdo.system.controller.MenuController.edit()', NULL, '127.0.0.1', '2018-10-10 10:21:51');
INSERT INTO `sys_log` VALUES (22, 1, 'admin', '更新菜单', 47, 'com.bootdo.system.controller.MenuController.update()', NULL, '127.0.0.1', '2018-10-10 10:22:08');
INSERT INTO `sys_log` VALUES (23, 1, 'admin', '编辑菜单', 3, 'com.bootdo.system.controller.MenuController.edit()', NULL, '127.0.0.1', '2018-10-10 10:22:21');
INSERT INTO `sys_log` VALUES (24, 1, 'admin', '添加菜单', 2, 'com.bootdo.system.controller.MenuController.add()', NULL, '127.0.0.1', '2018-10-10 10:22:45');
INSERT INTO `sys_log` VALUES (25, 1, 'admin', '编辑角色', 2, 'com.bootdo.system.controller.RoleController.edit()', NULL, '127.0.0.1', '2018-10-10 10:24:00');
INSERT INTO `sys_log` VALUES (26, 1, 'admin', '登录', 48, 'com.bootdo.system.controller.LoginController.ajaxLogin()', NULL, '127.0.0.1', '2018-10-11 16:14:44');
INSERT INTO `sys_log` VALUES (27, 1, 'admin', '请求访问主页', 114, 'com.bootdo.system.controller.LoginController.index()', NULL, '127.0.0.1', '2018-10-11 16:14:44');
INSERT INTO `sys_log` VALUES (28, 1, 'admin', '登录', 17, 'com.bootdo.system.controller.LoginController.ajaxLogin()', NULL, '127.0.0.1', '2018-10-12 14:41:32');
INSERT INTO `sys_log` VALUES (29, 1, 'admin', '请求访问主页', 30, 'com.bootdo.system.controller.LoginController.index()', NULL, '127.0.0.1', '2018-10-12 14:41:32');
INSERT INTO `sys_log` VALUES (30, 1, 'admin', '添加角色', 1, 'com.bootdo.system.controller.RoleController.add()', NULL, '127.0.0.1', '2018-10-12 14:41:43');
INSERT INTO `sys_log` VALUES (31, 1, 'admin', '保存角色', 51, 'com.bootdo.system.controller.RoleController.save()', NULL, '127.0.0.1', '2018-10-12 14:42:04');
INSERT INTO `sys_log` VALUES (32, 1, 'admin', '编辑角色', 2, 'com.bootdo.system.controller.RoleController.edit()', NULL, '127.0.0.1', '2018-10-12 14:48:48');
INSERT INTO `sys_log` VALUES (33, 1, 'admin', '编辑用户', 10, 'com.bootdo.system.controller.UserController.edit()', NULL, '127.0.0.1', '2018-10-12 14:48:59');
INSERT INTO `sys_log` VALUES (34, 1, 'admin', '更新用户', 56, 'com.bootdo.system.controller.UserController.update()', NULL, '127.0.0.1', '2018-10-12 14:49:07');
INSERT INTO `sys_log` VALUES (35, -1, '获取用户信息为空', '登录', 3, 'com.bootdo.system.controller.LoginController.ajaxLogin()', NULL, '127.0.0.1', '2018-10-12 14:50:02');
INSERT INTO `sys_log` VALUES (36, 137, 'test2', '登录', 3, 'com.bootdo.system.controller.LoginController.ajaxLogin()', NULL, '127.0.0.1', '2018-10-12 14:50:07');
INSERT INTO `sys_log` VALUES (37, 137, 'test2', '请求访问主页', 7, 'com.bootdo.system.controller.LoginController.index()', NULL, '127.0.0.1', '2018-10-12 14:50:07');
INSERT INTO `sys_log` VALUES (38, 1, 'admin', '登录', 3, 'com.bootdo.system.controller.LoginController.ajaxLogin()', NULL, '127.0.0.1', '2018-10-12 14:50:20');
INSERT INTO `sys_log` VALUES (39, 1, 'admin', '请求访问主页', 6, 'com.bootdo.system.controller.LoginController.index()', NULL, '127.0.0.1', '2018-10-12 14:50:20');
INSERT INTO `sys_log` VALUES (40, 1, 'admin', '请求访问主页', 4, 'com.bootdo.system.controller.LoginController.index()', NULL, '127.0.0.1', '2018-10-12 14:50:37');
INSERT INTO `sys_log` VALUES (41, 1, 'admin', '请求访问主页', 4, 'com.bootdo.system.controller.LoginController.index()', NULL, '127.0.0.1', '2018-10-12 14:50:39');
INSERT INTO `sys_log` VALUES (42, 1, 'admin', '登录', 18, 'com.bootdo.system.controller.LoginController.ajaxLogin()', NULL, '127.0.0.1', '2018-10-12 17:02:20');
INSERT INTO `sys_log` VALUES (43, 1, 'admin', '请求访问主页', 74, 'com.bootdo.system.controller.LoginController.index()', NULL, '127.0.0.1', '2018-10-12 17:02:20');
INSERT INTO `sys_log` VALUES (44, 137, 'test2', '登录', 4, 'com.bootdo.system.controller.LoginController.ajaxLogin()', NULL, '127.0.0.1', '2018-10-12 17:04:26');
INSERT INTO `sys_log` VALUES (45, 137, 'test2', '请求访问主页', 11, 'com.bootdo.system.controller.LoginController.index()', NULL, '127.0.0.1', '2018-10-12 17:04:26');
INSERT INTO `sys_log` VALUES (46, 137, 'test2', '请求访问主页', 5, 'com.bootdo.system.controller.LoginController.index()', NULL, '127.0.0.1', '2018-10-12 17:04:35');
INSERT INTO `sys_log` VALUES (47, 137, 'test2', '请求访问主页', 8, 'com.bootdo.system.controller.LoginController.index()', NULL, '127.0.0.1', '2018-10-12 17:04:36');
INSERT INTO `sys_log` VALUES (48, 1, 'admin', '登录', 66, 'com.bootdo.system.controller.LoginController.ajaxLogin()', NULL, '127.0.0.1', '2018-10-15 11:32:26');
INSERT INTO `sys_log` VALUES (49, 1, 'admin', '请求访问主页', 164, 'com.bootdo.system.controller.LoginController.index()', NULL, '127.0.0.1', '2018-10-15 11:32:26');
INSERT INTO `sys_log` VALUES (50, 1, 'admin', '编辑菜单', 4, 'com.bootdo.system.controller.MenuController.edit()', NULL, '127.0.0.1', '2018-10-15 11:32:42');
INSERT INTO `sys_log` VALUES (51, 1, 'admin', '登录', 59, 'com.bootdo.system.controller.LoginController.ajaxLogin()', NULL, '127.0.0.1', '2018-10-15 15:30:40');
INSERT INTO `sys_log` VALUES (52, 1, 'admin', '请求访问主页', 68, 'com.bootdo.system.controller.LoginController.index()', NULL, '127.0.0.1', '2018-10-15 15:30:40');
INSERT INTO `sys_log` VALUES (53, 1, 'admin', '登录', 84, 'com.bootdo.system.controller.LoginController.ajaxLogin()', NULL, '127.0.0.1', '2018-10-15 16:35:47');
INSERT INTO `sys_log` VALUES (54, 1, 'admin', '请求访问主页', 30, 'com.bootdo.system.controller.LoginController.index()', NULL, '127.0.0.1', '2018-10-15 16:35:47');
INSERT INTO `sys_log` VALUES (55, 1, 'admin', '登录', 12, 'com.bootdo.system.controller.LoginController.ajaxLogin()', NULL, '127.0.0.1', '2018-10-15 16:47:44');
INSERT INTO `sys_log` VALUES (56, 1, 'admin', '请求访问主页', 10, 'com.bootdo.system.controller.LoginController.index()', NULL, '127.0.0.1', '2018-10-15 16:47:44');
INSERT INTO `sys_log` VALUES (57, 1, 'admin', '添加菜单', 0, 'com.bootdo.system.controller.MenuController.add()', NULL, '127.0.0.1', '2018-10-15 16:47:52');
INSERT INTO `sys_log` VALUES (58, 1, 'admin', '保存菜单', 48, 'com.bootdo.system.controller.MenuController.save()', NULL, '127.0.0.1', '2018-10-15 16:48:00');
INSERT INTO `sys_log` VALUES (59, 1, 'admin', '添加菜单', 0, 'com.bootdo.system.controller.MenuController.add()', NULL, '127.0.0.1', '2018-10-15 16:48:02');
INSERT INTO `sys_log` VALUES (60, 1, 'admin', '保存菜单', 49, 'com.bootdo.system.controller.MenuController.save()', NULL, '127.0.0.1', '2018-10-15 16:48:06');
INSERT INTO `sys_log` VALUES (61, 1, 'admin', '添加菜单', 1, 'com.bootdo.system.controller.MenuController.add()', NULL, '127.0.0.1', '2018-10-15 16:48:09');
INSERT INTO `sys_log` VALUES (62, 1, 'admin', '保存菜单', 32, 'com.bootdo.system.controller.MenuController.save()', NULL, '127.0.0.1', '2018-10-15 16:48:12');
INSERT INTO `sys_log` VALUES (63, 1, 'admin', '添加菜单', 0, 'com.bootdo.system.controller.MenuController.add()', NULL, '127.0.0.1', '2018-10-15 16:48:15');
INSERT INTO `sys_log` VALUES (64, 1, 'admin', '保存菜单', 48, 'com.bootdo.system.controller.MenuController.save()', NULL, '127.0.0.1', '2018-10-15 16:48:21');
INSERT INTO `sys_log` VALUES (65, 1, 'admin', '添加菜单', 1, 'com.bootdo.system.controller.MenuController.add()', NULL, '127.0.0.1', '2018-10-15 16:48:23');
INSERT INTO `sys_log` VALUES (66, 1, 'admin', '保存菜单', 42, 'com.bootdo.system.controller.MenuController.save()', NULL, '127.0.0.1', '2018-10-15 16:48:26');
INSERT INTO `sys_log` VALUES (67, 1, 'admin', '添加菜单', 0, 'com.bootdo.system.controller.MenuController.add()', NULL, '127.0.0.1', '2018-10-15 16:48:28');
INSERT INTO `sys_log` VALUES (68, 1, 'admin', '保存菜单', 23, 'com.bootdo.system.controller.MenuController.save()', NULL, '127.0.0.1', '2018-10-15 16:48:32');
INSERT INTO `sys_log` VALUES (69, 1, 'admin', '添加菜单', 0, 'com.bootdo.system.controller.MenuController.add()', NULL, '127.0.0.1', '2018-10-15 16:48:34');
INSERT INTO `sys_log` VALUES (70, 1, 'admin', '保存菜单', 44, 'com.bootdo.system.controller.MenuController.save()', NULL, '127.0.0.1', '2018-10-15 16:48:37');
INSERT INTO `sys_log` VALUES (71, 1, 'admin', '添加菜单', 1, 'com.bootdo.system.controller.MenuController.add()', NULL, '127.0.0.1', '2018-10-15 16:48:43');
INSERT INTO `sys_log` VALUES (72, 1, 'admin', '保存菜单', 30, 'com.bootdo.system.controller.MenuController.save()', NULL, '127.0.0.1', '2018-10-15 16:48:47');
INSERT INTO `sys_log` VALUES (73, 1, 'admin', '添加菜单', 0, 'com.bootdo.system.controller.MenuController.add()', NULL, '127.0.0.1', '2018-10-15 16:48:49');
INSERT INTO `sys_log` VALUES (74, 1, 'admin', '保存菜单', 28, 'com.bootdo.system.controller.MenuController.save()', NULL, '127.0.0.1', '2018-10-15 16:48:53');
INSERT INTO `sys_log` VALUES (75, 1, 'admin', '添加菜单', 1, 'com.bootdo.system.controller.MenuController.add()', NULL, '127.0.0.1', '2018-10-15 16:48:55');
INSERT INTO `sys_log` VALUES (76, 1, 'admin', '保存菜单', 35, 'com.bootdo.system.controller.MenuController.save()', NULL, '127.0.0.1', '2018-10-15 16:48:59');
INSERT INTO `sys_log` VALUES (77, 1, 'admin', '添加菜单', 0, 'com.bootdo.system.controller.MenuController.add()', NULL, '127.0.0.1', '2018-10-15 16:49:01');
INSERT INTO `sys_log` VALUES (78, 1, 'admin', '保存菜单', 37, 'com.bootdo.system.controller.MenuController.save()', NULL, '127.0.0.1', '2018-10-15 16:49:03');
INSERT INTO `sys_log` VALUES (79, 1, 'admin', '添加菜单', 0, 'com.bootdo.system.controller.MenuController.add()', NULL, '127.0.0.1', '2018-10-15 16:49:06');
INSERT INTO `sys_log` VALUES (80, 1, 'admin', '保存菜单', 29, 'com.bootdo.system.controller.MenuController.save()', NULL, '127.0.0.1', '2018-10-15 16:49:08');
INSERT INTO `sys_log` VALUES (81, 1, 'admin', '添加菜单', 0, 'com.bootdo.system.controller.MenuController.add()', NULL, '127.0.0.1', '2018-10-15 16:49:16');
INSERT INTO `sys_log` VALUES (82, 1, 'admin', '保存菜单', 33, 'com.bootdo.system.controller.MenuController.save()', NULL, '127.0.0.1', '2018-10-15 16:49:19');
INSERT INTO `sys_log` VALUES (83, 1, 'admin', '登录', 4, 'com.bootdo.system.controller.LoginController.ajaxLogin()', NULL, '127.0.0.1', '2018-10-15 16:56:22');
INSERT INTO `sys_log` VALUES (84, 1, 'admin', '请求访问主页', 8, 'com.bootdo.system.controller.LoginController.index()', NULL, '127.0.0.1', '2018-10-15 16:56:22');
INSERT INTO `sys_log` VALUES (85, 1, 'admin', '登录', 4, 'com.bootdo.system.controller.LoginController.ajaxLogin()', NULL, '127.0.0.1', '2018-10-15 16:59:02');
INSERT INTO `sys_log` VALUES (86, 1, 'admin', '请求访问主页', 9, 'com.bootdo.system.controller.LoginController.index()', NULL, '127.0.0.1', '2018-10-15 16:59:02');
INSERT INTO `sys_log` VALUES (87, 1, 'admin', '添加菜单', 1, 'com.bootdo.system.controller.MenuController.add()', NULL, '127.0.0.1', '2018-10-15 16:59:06');
INSERT INTO `sys_log` VALUES (88, 1, 'admin', '登录', 4, 'com.bootdo.system.controller.LoginController.ajaxLogin()', NULL, '127.0.0.1', '2018-10-15 17:16:17');
INSERT INTO `sys_log` VALUES (89, 1, 'admin', '请求访问主页', 8, 'com.bootdo.system.controller.LoginController.index()', NULL, '127.0.0.1', '2018-10-15 17:16:17');
INSERT INTO `sys_log` VALUES (90, 1, 'admin', '添加菜单', 0, 'com.bootdo.system.controller.MenuController.add()', NULL, '127.0.0.1', '2018-10-15 17:16:24');
INSERT INTO `sys_log` VALUES (91, 1, 'admin', '登录', 5, 'com.bootdo.system.controller.LoginController.ajaxLogin()', NULL, '127.0.0.1', '2018-10-15 17:34:32');
INSERT INTO `sys_log` VALUES (92, 1, 'admin', '请求访问主页', 6, 'com.bootdo.system.controller.LoginController.index()', NULL, '127.0.0.1', '2018-10-15 17:34:32');
INSERT INTO `sys_log` VALUES (93, 1, 'admin', '添加菜单', 0, 'com.bootdo.system.controller.MenuController.add()', NULL, '127.0.0.1', '2018-10-15 17:34:37');
INSERT INTO `sys_log` VALUES (94, 1, 'admin', '登录', 3, 'com.bootdo.system.controller.LoginController.ajaxLogin()', NULL, '127.0.0.1', '2018-10-15 17:52:28');
INSERT INTO `sys_log` VALUES (95, 1, 'admin', '请求访问主页', 7, 'com.bootdo.system.controller.LoginController.index()', NULL, '127.0.0.1', '2018-10-15 17:52:28');
INSERT INTO `sys_log` VALUES (96, 1, 'admin', '编辑菜单', 4, 'com.bootdo.system.controller.MenuController.edit()', NULL, '127.0.0.1', '2018-10-15 17:52:36');
INSERT INTO `sys_log` VALUES (97, 1, 'admin', '更新菜单', 80, 'com.bootdo.system.controller.MenuController.update()', NULL, '127.0.0.1', '2018-10-15 17:52:41');
INSERT INTO `sys_log` VALUES (98, 1, 'admin', '添加菜单', 0, 'com.bootdo.system.controller.MenuController.add()', NULL, '127.0.0.1', '2018-10-15 17:52:49');
INSERT INTO `sys_log` VALUES (99, 1, 'admin', '保存菜单', 34, 'com.bootdo.system.controller.MenuController.save()', NULL, '127.0.0.1', '2018-10-15 17:52:55');
INSERT INTO `sys_log` VALUES (100, 1, 'admin', '删除菜单', 45, 'com.bootdo.system.controller.MenuController.remove()', NULL, '127.0.0.1', '2018-10-15 17:52:58');
INSERT INTO `sys_log` VALUES (101, 1, 'admin', '请求访问主页', 5, 'com.bootdo.system.controller.LoginController.index()', NULL, '127.0.0.1', '2018-10-15 17:54:07');
INSERT INTO `sys_log` VALUES (102, 1, 'admin', '登录', 3, 'com.bootdo.system.controller.LoginController.ajaxLogin()', NULL, '127.0.0.1', '2018-10-15 17:57:25');
INSERT INTO `sys_log` VALUES (103, 1, 'admin', '请求访问主页', 6, 'com.bootdo.system.controller.LoginController.index()', NULL, '127.0.0.1', '2018-10-15 17:57:25');
INSERT INTO `sys_log` VALUES (104, 1, 'admin', '添加菜单', 2, 'com.bootdo.system.controller.MenuController.add()', NULL, '127.0.0.1', '2018-10-15 17:57:30');
INSERT INTO `sys_log` VALUES (105, 1, 'admin', '登录', 5, 'com.bootdo.system.controller.LoginController.ajaxLogin()', NULL, '127.0.0.1', '2018-10-15 18:03:03');
INSERT INTO `sys_log` VALUES (106, 1, 'admin', '请求访问主页', 6, 'com.bootdo.system.controller.LoginController.index()', NULL, '127.0.0.1', '2018-10-15 18:03:03');
INSERT INTO `sys_log` VALUES (107, 1, 'admin', '添加菜单', 0, 'com.bootdo.system.controller.MenuController.add()', NULL, '127.0.0.1', '2018-10-15 18:03:09');
INSERT INTO `sys_log` VALUES (108, 1, 'admin', '请求访问主页', 7, 'com.bootdo.system.controller.LoginController.index()', NULL, '127.0.0.1', '2018-10-15 18:07:33');
INSERT INTO `sys_log` VALUES (109, 1, 'admin', '登录', 13, 'top.cflwork.system.controller.LoginController.ajaxLogin()', NULL, '127.0.0.1', '2018-10-16 16:27:45');
INSERT INTO `sys_log` VALUES (110, 1, 'admin', '请求访问主页', 61, 'top.cflwork.system.controller.LoginController.index()', NULL, '127.0.0.1', '2018-10-16 16:27:45');
INSERT INTO `sys_log` VALUES (111, 1, 'admin', '登录', 3, 'top.cflwork.system.controller.LoginController.ajaxLogin()', NULL, '127.0.0.1', '2018-10-16 16:30:14');
INSERT INTO `sys_log` VALUES (112, 1, 'admin', '请求访问主页', 7, 'top.cflwork.system.controller.LoginController.index()', NULL, '127.0.0.1', '2018-10-16 16:30:14');
INSERT INTO `sys_log` VALUES (113, 1, 'admin', 'error', NULL, 'http://localhost:8088/oa/notify/save', 'org.springframework.jdbc.UncategorizedSQLException: \r\n### Error updating database.  Cause: java.sql.SQLException: sql injection violation, syntax error: syntax error, expect \')\' : insert into oa_notify_record\n		(\n		`notify_id`,\n		`user_id`,\n		`is_read`,\n		`read_date`\n		)\n		values\r\n### SQL: insert into oa_notify_record   (   `notify_id`,   `user_id`,   `is_read`,   `read_date`   )   values\r\n### Cause: java.sql.SQLException: sql injection violation, syntax error: syntax error, expect \')\' : insert into oa_notify_record\n		(\n		`notify_id`,\n		`user_id`,\n		`is_read`,\n		`read_date`\n		)\n		values\n; uncategorized SQLException; SQL state [null]; error code [0]; sql injection violation, syntax error: syntax error, expect \')\' : insert into oa_notify_record\n		(\n		`notify_id`,\n		`user_id`,\n		`is_read`,\n		`read_date`\n		)\n		values; nested exception is java.sql.SQLException: sql injection violation, syntax error: syntax error, expect \')\' : insert into oa_notify_record\n		(\n		`notify_id`,\n		`user_id`,\n		`is_read`,\n		`read_date`\n		)\n		values', NULL, '2018-10-16 16:33:48');
INSERT INTO `sys_log` VALUES (114, 1, 'admin', 'error', NULL, 'http://localhost:8088/oa/notify/save', 'org.springframework.jdbc.UncategorizedSQLException: \r\n### Error updating database.  Cause: java.sql.SQLException: sql injection violation, syntax error: syntax error, expect \')\' : insert into oa_notify_record\n		(\n		`notify_id`,\n		`user_id`,\n		`is_read`,\n		`read_date`\n		)\n		values\r\n### SQL: insert into oa_notify_record   (   `notify_id`,   `user_id`,   `is_read`,   `read_date`   )   values\r\n### Cause: java.sql.SQLException: sql injection violation, syntax error: syntax error, expect \')\' : insert into oa_notify_record\n		(\n		`notify_id`,\n		`user_id`,\n		`is_read`,\n		`read_date`\n		)\n		values\n; uncategorized SQLException; SQL state [null]; error code [0]; sql injection violation, syntax error: syntax error, expect \')\' : insert into oa_notify_record\n		(\n		`notify_id`,\n		`user_id`,\n		`is_read`,\n		`read_date`\n		)\n		values; nested exception is java.sql.SQLException: sql injection violation, syntax error: syntax error, expect \')\' : insert into oa_notify_record\n		(\n		`notify_id`,\n		`user_id`,\n		`is_read`,\n		`read_date`\n		)\n		values', NULL, '2018-10-16 16:33:55');
INSERT INTO `sys_log` VALUES (115, 1, 'admin', '登录', 17, 'com.bootdo.system.controller.LoginController.ajaxLogin()', NULL, '127.0.0.1', '2018-10-16 18:16:17');
INSERT INTO `sys_log` VALUES (116, 1, 'admin', '请求访问主页', 79, 'com.bootdo.system.controller.LoginController.index()', NULL, '127.0.0.1', '2018-10-16 18:16:17');
INSERT INTO `sys_log` VALUES (117, 1, 'admin', '添加菜单', 1, 'com.bootdo.system.controller.MenuController.add()', NULL, '127.0.0.1', '2018-10-16 18:16:27');
INSERT INTO `sys_log` VALUES (118, 1, 'admin', '保存菜单', 42, 'com.bootdo.system.controller.MenuController.save()', NULL, '127.0.0.1', '2018-10-16 18:16:33');
INSERT INTO `sys_log` VALUES (119, 1, 'admin', '删除菜单', 42, 'com.bootdo.system.controller.MenuController.remove()', NULL, '127.0.0.1', '2018-10-16 18:16:45');
INSERT INTO `sys_log` VALUES (120, 1, 'admin', '登录', 58, 'com.bootdo.system.controller.LoginController.ajaxLogin()', NULL, '127.0.0.1', '2018-10-17 11:15:38');
INSERT INTO `sys_log` VALUES (121, 1, 'admin', '请求访问主页', 170, 'com.bootdo.system.controller.LoginController.index()', NULL, '127.0.0.1', '2018-10-17 11:15:39');
INSERT INTO `sys_log` VALUES (122, 1, 'admin', '编辑用户', 10, 'com.bootdo.system.controller.UserController.edit()', NULL, '127.0.0.1', '2018-10-17 11:16:08');
INSERT INTO `sys_log` VALUES (123, 1, 'admin', '编辑角色', 2, 'com.bootdo.system.controller.RoleController.edit()', NULL, '127.0.0.1', '2018-10-17 11:16:14');
INSERT INTO `sys_log` VALUES (124, 1, 'admin', '登录', 4, 'com.bootdo.system.controller.LoginController.ajaxLogin()', NULL, '127.0.0.1', '2018-10-17 11:20:47');
INSERT INTO `sys_log` VALUES (125, 1, 'admin', '请求访问主页', 7, 'com.bootdo.system.controller.LoginController.index()', NULL, '127.0.0.1', '2018-10-17 11:20:47');
INSERT INTO `sys_log` VALUES (126, 1, 'admin', '编辑角色', 1, 'com.bootdo.system.controller.RoleController.edit()', NULL, '127.0.0.1', '2018-10-17 11:20:55');
INSERT INTO `sys_log` VALUES (127, 1, 'admin', '登录', 5, 'com.bootdo.system.controller.LoginController.ajaxLogin()', NULL, '127.0.0.1', '2018-10-17 11:47:36');
INSERT INTO `sys_log` VALUES (128, 1, 'admin', '请求访问主页', 9, 'com.bootdo.system.controller.LoginController.index()', NULL, '127.0.0.1', '2018-10-17 11:47:36');
INSERT INTO `sys_log` VALUES (129, 1, 'admin', '编辑角色', 2, 'com.bootdo.system.controller.RoleController.edit()', NULL, '127.0.0.1', '2018-10-17 11:47:42');
INSERT INTO `sys_log` VALUES (130, 1, 'admin', '登录', 11, 'com.bootdo.system.controller.LoginController.ajaxLogin()', NULL, '127.0.0.1', '2018-10-22 14:15:34');
INSERT INTO `sys_log` VALUES (131, 1, 'admin', '请求访问主页', 46, 'com.bootdo.system.controller.LoginController.index()', NULL, '127.0.0.1', '2018-10-22 14:15:35');
INSERT INTO `sys_log` VALUES (132, 1, 'admin', '登录', 13, 'com.bootdo.system.controller.LoginController.ajaxLogin()', NULL, '127.0.0.1', '2018-10-22 14:38:16');
INSERT INTO `sys_log` VALUES (133, 1, 'admin', '请求访问主页', 28, 'com.bootdo.system.controller.LoginController.index()', NULL, '127.0.0.1', '2018-10-22 14:38:16');
INSERT INTO `sys_log` VALUES (134, 1, 'admin', '添加菜单', 1, 'com.bootdo.system.controller.MenuController.add()', NULL, '127.0.0.1', '2018-10-22 14:38:31');
INSERT INTO `sys_log` VALUES (135, 1, 'admin', '保存菜单', 33, 'com.bootdo.system.controller.MenuController.save()', NULL, '127.0.0.1', '2018-10-22 14:40:28');
INSERT INTO `sys_log` VALUES (136, 1, 'admin', '编辑菜单', 4, 'com.bootdo.system.controller.MenuController.edit()', NULL, '127.0.0.1', '2018-10-22 14:40:34');
INSERT INTO `sys_log` VALUES (137, 1, 'admin', '更新菜单', 93, 'com.bootdo.system.controller.MenuController.update()', NULL, '127.0.0.1', '2018-10-22 14:40:37');
INSERT INTO `sys_log` VALUES (138, 1, 'admin', '编辑菜单', 3, 'com.bootdo.system.controller.MenuController.edit()', NULL, '127.0.0.1', '2018-10-22 14:40:43');
INSERT INTO `sys_log` VALUES (139, 1, 'admin', '编辑菜单', 5, 'com.bootdo.system.controller.MenuController.edit()', NULL, '127.0.0.1', '2018-10-22 14:40:59');
INSERT INTO `sys_log` VALUES (140, 1, 'admin', '编辑菜单', 5, 'com.bootdo.system.controller.MenuController.edit()', NULL, '127.0.0.1', '2018-10-22 14:41:30');
INSERT INTO `sys_log` VALUES (141, 1, 'admin', '编辑菜单', 10, 'com.bootdo.system.controller.MenuController.edit()', NULL, '127.0.0.1', '2018-10-22 14:41:43');
INSERT INTO `sys_log` VALUES (142, 1, 'admin', '添加菜单', 3, 'com.bootdo.system.controller.MenuController.add()', NULL, '127.0.0.1', '2018-10-22 14:41:50');
INSERT INTO `sys_log` VALUES (143, 1, 'admin', '保存菜单', 31, 'com.bootdo.system.controller.MenuController.save()', NULL, '127.0.0.1', '2018-10-22 14:42:54');
INSERT INTO `sys_log` VALUES (144, 1, 'admin', '请求访问主页', 5, 'com.bootdo.system.controller.LoginController.index()', NULL, '127.0.0.1', '2018-10-22 14:43:46');
INSERT INTO `sys_log` VALUES (145, 1, 'admin', '编辑角色', 2, 'com.bootdo.system.controller.RoleController.edit()', NULL, '127.0.0.1', '2018-10-22 14:43:57');
INSERT INTO `sys_log` VALUES (146, 1, 'admin', '更新角色', 106, 'com.bootdo.system.controller.RoleController.update()', NULL, '127.0.0.1', '2018-10-22 14:44:01');
INSERT INTO `sys_log` VALUES (147, 1, 'admin', '请求访问主页', 4, 'com.bootdo.system.controller.LoginController.index()', NULL, '127.0.0.1', '2018-10-22 14:44:03');
INSERT INTO `sys_log` VALUES (148, 1, 'admin', '编辑菜单', 2, 'com.bootdo.system.controller.MenuController.edit()', NULL, '127.0.0.1', '2018-10-22 14:44:33');
INSERT INTO `sys_log` VALUES (149, 1, 'admin', '更新菜单', 33, 'com.bootdo.system.controller.MenuController.update()', NULL, '127.0.0.1', '2018-10-22 14:44:35');
INSERT INTO `sys_log` VALUES (150, 1, 'admin', '请求访问主页', 5, 'com.bootdo.system.controller.LoginController.index()', NULL, '127.0.0.1', '2018-10-22 14:45:37');
INSERT INTO `sys_log` VALUES (151, 1, 'admin', '编辑菜单', 4, 'com.bootdo.system.controller.MenuController.edit()', NULL, '127.0.0.1', '2018-10-22 14:46:04');
INSERT INTO `sys_log` VALUES (152, 1, 'admin', '更新菜单', 39, 'com.bootdo.system.controller.MenuController.update()', NULL, '127.0.0.1', '2018-10-22 14:46:10');
INSERT INTO `sys_log` VALUES (153, 1, 'admin', '请求访问主页', 4, 'com.bootdo.system.controller.LoginController.index()', NULL, '127.0.0.1', '2018-10-22 14:46:11');
INSERT INTO `sys_log` VALUES (154, 1, 'admin', '删除菜单', 27, 'com.bootdo.system.controller.MenuController.remove()', NULL, '127.0.0.1', '2018-10-22 14:46:33');
INSERT INTO `sys_log` VALUES (155, 1, 'admin', '添加菜单', 2, 'com.bootdo.system.controller.MenuController.add()', NULL, '127.0.0.1', '2018-10-22 14:46:50');
INSERT INTO `sys_log` VALUES (156, 1, 'admin', '保存菜单', 44, 'com.bootdo.system.controller.MenuController.save()', NULL, '127.0.0.1', '2018-10-22 14:47:30');
INSERT INTO `sys_log` VALUES (157, 1, 'admin', '请求访问主页', 6, 'com.bootdo.system.controller.LoginController.index()', NULL, '127.0.0.1', '2018-10-22 14:47:42');
INSERT INTO `sys_log` VALUES (158, 1, 'admin', '编辑角色', 1, 'com.bootdo.system.controller.RoleController.edit()', NULL, '127.0.0.1', '2018-10-22 14:47:49');
INSERT INTO `sys_log` VALUES (159, 1, 'admin', '更新角色', 104, 'com.bootdo.system.controller.RoleController.update()', NULL, '127.0.0.1', '2018-10-22 14:47:53');
INSERT INTO `sys_log` VALUES (160, 1, 'admin', '请求访问主页', 5, 'com.bootdo.system.controller.LoginController.index()', NULL, '127.0.0.1', '2018-10-22 14:47:57');
INSERT INTO `sys_log` VALUES (161, 1, 'admin', '编辑菜单', 4, 'com.bootdo.system.controller.MenuController.edit()', NULL, '127.0.0.1', '2018-10-22 14:49:01');
INSERT INTO `sys_log` VALUES (162, 1, 'admin', '添加菜单', 2, 'com.bootdo.system.controller.MenuController.add()', NULL, '127.0.0.1', '2018-10-22 14:50:22');
INSERT INTO `sys_log` VALUES (163, 1, 'admin', '保存菜单', 30, 'com.bootdo.system.controller.MenuController.save()', NULL, '127.0.0.1', '2018-10-22 14:50:48');
INSERT INTO `sys_log` VALUES (164, 1, 'admin', '请求访问主页', 5, 'com.bootdo.system.controller.LoginController.index()', NULL, '127.0.0.1', '2018-10-22 14:51:08');
INSERT INTO `sys_log` VALUES (165, 1, 'admin', '编辑菜单', 4, 'com.bootdo.system.controller.MenuController.edit()', NULL, '127.0.0.1', '2018-10-22 14:52:00');
INSERT INTO `sys_log` VALUES (166, 1, 'admin', '编辑菜单', 3, 'com.bootdo.system.controller.MenuController.edit()', NULL, '127.0.0.1', '2018-10-22 14:52:09');
INSERT INTO `sys_log` VALUES (167, 1, 'admin', '更新菜单', 34, 'com.bootdo.system.controller.MenuController.update()', NULL, '127.0.0.1', '2018-10-22 14:52:25');
INSERT INTO `sys_log` VALUES (168, 1, 'admin', '添加菜单', 2, 'com.bootdo.system.controller.MenuController.add()', NULL, '127.0.0.1', '2018-10-22 14:52:42');
INSERT INTO `sys_log` VALUES (169, 1, 'admin', '保存菜单', 36, 'com.bootdo.system.controller.MenuController.save()', NULL, '127.0.0.1', '2018-10-22 14:53:00');
INSERT INTO `sys_log` VALUES (170, 1, 'admin', '请求访问主页', 3, 'com.bootdo.system.controller.LoginController.index()', NULL, '127.0.0.1', '2018-10-22 14:53:02');
INSERT INTO `sys_log` VALUES (171, 1, 'admin', '请求访问主页', 3, 'com.bootdo.system.controller.LoginController.index()', NULL, '127.0.0.1', '2018-10-22 14:53:02');
INSERT INTO `sys_log` VALUES (172, 1, 'admin', '请求访问主页', 5, 'com.bootdo.system.controller.LoginController.index()', NULL, '127.0.0.1', '2018-10-22 14:53:03');
INSERT INTO `sys_log` VALUES (173, 1, 'admin', '请求访问主页', 3, 'com.bootdo.system.controller.LoginController.index()', NULL, '127.0.0.1', '2018-10-22 14:53:03');
INSERT INTO `sys_log` VALUES (174, 1, 'admin', '请求访问主页', 3, 'com.bootdo.system.controller.LoginController.index()', NULL, '127.0.0.1', '2018-10-22 14:53:03');
INSERT INTO `sys_log` VALUES (175, 1, 'admin', '编辑角色', 2, 'com.bootdo.system.controller.RoleController.edit()', NULL, '127.0.0.1', '2018-10-22 14:53:28');
INSERT INTO `sys_log` VALUES (176, 1, 'admin', '更新角色', 89, 'com.bootdo.system.controller.RoleController.update()', NULL, '127.0.0.1', '2018-10-22 14:53:34');
INSERT INTO `sys_log` VALUES (177, 1, 'admin', '请求访问主页', 4, 'com.bootdo.system.controller.LoginController.index()', NULL, '127.0.0.1', '2018-10-22 14:53:37');
INSERT INTO `sys_log` VALUES (178, 1, 'admin', '请求访问主页', 4, 'com.bootdo.system.controller.LoginController.index()', NULL, '127.0.0.1', '2018-10-22 14:53:56');
INSERT INTO `sys_log` VALUES (179, 1, 'admin', '请求访问主页', 6, 'com.bootdo.system.controller.LoginController.index()', NULL, '127.0.0.1', '2018-10-22 14:53:56');
INSERT INTO `sys_log` VALUES (180, 1, 'admin', '请求访问主页', 3, 'com.bootdo.system.controller.LoginController.index()', NULL, '127.0.0.1', '2018-10-22 14:53:57');
INSERT INTO `sys_log` VALUES (181, 1, 'admin', '请求访问主页', 3, 'com.bootdo.system.controller.LoginController.index()', NULL, '127.0.0.1', '2018-10-22 14:53:57');
INSERT INTO `sys_log` VALUES (182, 1, 'admin', '请求访问主页', 3, 'com.bootdo.system.controller.LoginController.index()', NULL, '127.0.0.1', '2018-10-22 14:53:57');
INSERT INTO `sys_log` VALUES (183, 1, 'admin', '请求访问主页', 3, 'com.bootdo.system.controller.LoginController.index()', NULL, '127.0.0.1', '2018-10-22 14:53:57');
INSERT INTO `sys_log` VALUES (184, 1, 'admin', '请求访问主页', 4, 'com.bootdo.system.controller.LoginController.index()', NULL, '127.0.0.1', '2018-10-22 14:53:57');
INSERT INTO `sys_log` VALUES (185, 1, 'admin', '请求访问主页', 5, 'com.bootdo.system.controller.LoginController.index()', NULL, '127.0.0.1', '2018-10-22 14:53:57');
INSERT INTO `sys_log` VALUES (186, 1, 'admin', '请求访问主页', 3, 'com.bootdo.system.controller.LoginController.index()', NULL, '127.0.0.1', '2018-10-22 14:53:58');
INSERT INTO `sys_log` VALUES (187, 1, 'admin', '请求访问主页', 3, 'com.bootdo.system.controller.LoginController.index()', NULL, '127.0.0.1', '2018-10-22 14:53:58');
INSERT INTO `sys_log` VALUES (188, 1, 'admin', '编辑角色', 1, 'com.bootdo.system.controller.RoleController.edit()', NULL, '127.0.0.1', '2018-10-22 14:54:15');
INSERT INTO `sys_log` VALUES (189, 1, 'admin', '编辑角色', 1, 'com.bootdo.system.controller.RoleController.edit()', NULL, '127.0.0.1', '2018-10-22 14:54:19');
INSERT INTO `sys_log` VALUES (190, 1, 'admin', '登录', 2, 'com.bootdo.system.controller.LoginController.ajaxLogin()', NULL, '127.0.0.1', '2018-10-22 14:54:50');
INSERT INTO `sys_log` VALUES (191, 1, 'admin', '请求访问主页', 5, 'com.bootdo.system.controller.LoginController.index()', NULL, '127.0.0.1', '2018-10-22 14:54:50');
INSERT INTO `sys_log` VALUES (192, 1, 'admin', '添加菜单', 2, 'com.bootdo.system.controller.MenuController.add()', NULL, '127.0.0.1', '2018-10-22 14:56:59');
INSERT INTO `sys_log` VALUES (193, 1, 'admin', '保存菜单', 29, 'com.bootdo.system.controller.MenuController.save()', NULL, '127.0.0.1', '2018-10-22 14:57:18');
INSERT INTO `sys_log` VALUES (194, 1, 'admin', '添加菜单', 1, 'com.bootdo.system.controller.MenuController.add()', NULL, '127.0.0.1', '2018-10-22 14:57:24');
INSERT INTO `sys_log` VALUES (195, 1, 'admin', '保存菜单', 434, 'com.bootdo.system.controller.MenuController.save()', NULL, '127.0.0.1', '2018-10-22 14:57:50');
INSERT INTO `sys_log` VALUES (196, 1, 'admin', '编辑角色', 1, 'com.bootdo.system.controller.RoleController.edit()', NULL, '127.0.0.1', '2018-10-22 14:58:11');
INSERT INTO `sys_log` VALUES (197, 1, 'admin', '更新角色', 90, 'com.bootdo.system.controller.RoleController.update()', NULL, '127.0.0.1', '2018-10-22 14:58:16');
INSERT INTO `sys_log` VALUES (198, 1, 'admin', '登录', 2, 'com.bootdo.system.controller.LoginController.ajaxLogin()', NULL, '127.0.0.1', '2018-10-22 14:58:22');
INSERT INTO `sys_log` VALUES (199, 1, 'admin', '请求访问主页', 5, 'com.bootdo.system.controller.LoginController.index()', NULL, '127.0.0.1', '2018-10-22 14:58:22');
INSERT INTO `sys_log` VALUES (200, 1, 'admin', '登录', 14, 'com.bootdo.system.controller.LoginController.ajaxLogin()', NULL, '127.0.0.1', '2018-10-22 15:35:33');
INSERT INTO `sys_log` VALUES (201, 1, 'admin', '请求访问主页', 30, 'com.bootdo.system.controller.LoginController.index()', NULL, '127.0.0.1', '2018-10-22 15:35:33');
INSERT INTO `sys_log` VALUES (202, 1, 'admin', '登录', 41, 'com.bootdo.system.controller.LoginController.ajaxLogin()', NULL, '127.0.0.1', '2018-10-23 09:35:52');
INSERT INTO `sys_log` VALUES (203, 1, 'admin', '请求访问主页', 146, 'com.bootdo.system.controller.LoginController.index()', NULL, '127.0.0.1', '2018-10-23 09:35:52');
INSERT INTO `sys_log` VALUES (204, 1, 'admin', '登录', 38, 'com.bootdo.system.controller.LoginController.ajaxLogin()', NULL, '127.0.0.1', '2018-10-24 14:59:23');
INSERT INTO `sys_log` VALUES (205, 1, 'admin', '请求访问主页', 131, 'com.bootdo.system.controller.LoginController.index()', NULL, '127.0.0.1', '2018-10-24 14:59:23');
INSERT INTO `sys_log` VALUES (206, 1, 'admin', '登录', 60, 'com.bootdo.system.controller.LoginController.ajaxLogin()', NULL, '127.0.0.1', '2018-10-25 16:17:36');
INSERT INTO `sys_log` VALUES (207, 1, 'admin', '请求访问主页', 169, 'com.bootdo.system.controller.LoginController.index()', NULL, '127.0.0.1', '2018-10-25 16:17:36');
INSERT INTO `sys_log` VALUES (208, 1, 'admin', 'error', NULL, 'http://localhost:8088/system/book/lookDoc', 'org.apache.poi.poifs.filesystem.OfficeXmlFileException: The supplied data appears to be in the Office 2007+ XML. You are calling the part of POI that deals with OLE2 Office Documents. You need to call a different part of POI to process this data (eg XSSF instead of HSSF)', NULL, '2018-10-25 16:18:17');
INSERT INTO `sys_log` VALUES (209, 1, 'admin', 'error', NULL, 'http://localhost:8088/system/book/lookDoc', 'org.apache.poi.poifs.filesystem.OfficeXmlFileException: The supplied data appears to be in the Office 2007+ XML. You are calling the part of POI that deals with OLE2 Office Documents. You need to call a different part of POI to process this data (eg XSSF instead of HSSF)', NULL, '2018-10-25 16:18:50');
INSERT INTO `sys_log` VALUES (210, 1, 'admin', '登录', 13, 'com.bootdo.system.controller.LoginController.ajaxLogin()', NULL, '127.0.0.1', '2018-10-25 16:22:20');
INSERT INTO `sys_log` VALUES (211, 1, 'admin', '请求访问主页', 33, 'com.bootdo.system.controller.LoginController.index()', NULL, '127.0.0.1', '2018-10-25 16:22:20');
INSERT INTO `sys_log` VALUES (212, 1, 'admin', 'error', NULL, 'http://localhost:8088/system/book/lookDoc', 'org.apache.poi.poifs.filesystem.OfficeXmlFileException: The supplied data appears to be in the Office 2007+ XML. You are calling the part of POI that deals with OLE2 Office Documents. You need to call a different part of POI to process this data (eg XSSF instead of HSSF)', NULL, '2018-10-25 16:22:27');
INSERT INTO `sys_log` VALUES (213, 1, 'admin', 'error', NULL, 'http://localhost:8088/system/book/lookDoc', 'org.springframework.web.util.NestedServletException: Handler dispatch failed; nested exception is java.lang.NoSuchMethodError: org.apache.poi.POIDocument.<init>(Lorg/apache/poi/poifs/filesystem/DirectoryNode;Lorg/apache/poi/poifs/filesystem/POIFSFileSystem;)V', NULL, '2018-10-25 16:23:39');
INSERT INTO `sys_log` VALUES (214, 1, 'admin', 'error', NULL, 'http://localhost:8088/system/book/lookDoc', 'org.springframework.web.util.NestedServletException: Handler dispatch failed; nested exception is java.lang.NoSuchMethodError: org.apache.poi.POIDocument.<init>(Lorg/apache/poi/poifs/filesystem/DirectoryNode;Lorg/apache/poi/poifs/filesystem/POIFSFileSystem;)V', NULL, '2018-10-25 16:25:42');
INSERT INTO `sys_log` VALUES (215, 1, 'admin', 'error', NULL, 'http://localhost:8088/system/book/lookDoc', 'org.springframework.web.util.NestedServletException: Handler dispatch failed; nested exception is java.lang.NoSuchMethodError: org.apache.poi.POIDocument.<init>(Lorg/apache/poi/poifs/filesystem/DirectoryNode;Lorg/apache/poi/poifs/filesystem/POIFSFileSystem;)V', NULL, '2018-10-25 16:27:55');
INSERT INTO `sys_log` VALUES (216, 1, 'admin', '登录', 11, 'com.bootdo.system.controller.LoginController.ajaxLogin()', NULL, '127.0.0.1', '2018-10-25 16:31:35');
INSERT INTO `sys_log` VALUES (217, 1, 'admin', '请求访问主页', 32, 'com.bootdo.system.controller.LoginController.index()', NULL, '127.0.0.1', '2018-10-25 16:31:35');
INSERT INTO `sys_log` VALUES (218, 1, 'admin', 'error', NULL, 'http://localhost:8088/system/book/lookPpt', 'org.apache.poi.poifs.filesystem.OfficeXmlFileException: The supplied data appears to be in the Office 2007+ XML. POI only supports OLE2 Office documents', NULL, '2018-10-25 16:32:07');
INSERT INTO `sys_log` VALUES (219, 1, 'admin', '登录', 58, 'com.bootdo.system.controller.LoginController.ajaxLogin()', NULL, '127.0.0.1', '2018-10-30 10:45:09');
INSERT INTO `sys_log` VALUES (220, 1, 'admin', '请求访问主页', 166, 'com.bootdo.system.controller.LoginController.index()', NULL, '127.0.0.1', '2018-10-30 10:45:10');
INSERT INTO `sys_log` VALUES (221, 1, 'admin', '登录', 82, 'com.bootdo.system.controller.LoginController.ajaxLogin()', NULL, '127.0.0.1', '2018-11-09 16:11:54');
INSERT INTO `sys_log` VALUES (222, 1, 'admin', '请求访问主页', 165, 'com.bootdo.system.controller.LoginController.index()', NULL, '127.0.0.1', '2018-11-09 16:11:54');
INSERT INTO `sys_log` VALUES (223, 1, 'admin', 'error', NULL, 'http://localhost:8088/system/book/list', 'java.lang.IllegalArgumentException: Cannot find cache named \'bookList\' for Builder[public com.bootdo.common.utils.PageUtils com.bootdo.system.controller.BookController.list(java.util.Map)] caches=[bookList] | key=\'\' | keyGenerator=\'\' | cacheManager=\'\' | cacheResolver=\'\' | condition=\'\' | unless=\'\' | sync=\'false\'', NULL, '2018-11-09 16:12:01');
INSERT INTO `sys_log` VALUES (224, 1, 'admin', 'error', NULL, 'http://localhost:8088/system/book/list', 'java.lang.IllegalArgumentException: Cannot find cache named \'bookList\' for Builder[public com.bootdo.common.utils.PageUtils com.bootdo.system.controller.BookController.list(java.util.Map)] caches=[bookList] | key=\'\' | keyGenerator=\'\' | cacheManager=\'\' | cacheResolver=\'\' | condition=\'\' | unless=\'\' | sync=\'false\'', NULL, '2018-11-09 16:12:30');
INSERT INTO `sys_log` VALUES (225, 1, 'admin', '请求访问主页', 9, 'com.bootdo.system.controller.LoginController.index()', NULL, '127.0.0.1', '2018-11-09 16:12:36');
INSERT INTO `sys_log` VALUES (226, 1, 'admin', 'error', NULL, 'http://localhost:8088/system/book/list', 'java.lang.IllegalArgumentException: Cannot find cache named \'bookList\' for Builder[public com.bootdo.common.utils.PageUtils com.bootdo.system.controller.BookController.list(java.util.Map)] caches=[bookList] | key=\'\' | keyGenerator=\'\' | cacheManager=\'\' | cacheResolver=\'\' | condition=\'\' | unless=\'\' | sync=\'false\'', NULL, '2018-11-09 16:12:39');
INSERT INTO `sys_log` VALUES (227, 1, 'admin', 'error', NULL, 'http://localhost:8088/system/book/list', 'java.lang.IllegalArgumentException: Cannot find cache named \'bookList\' for Builder[public com.bootdo.common.utils.PageUtils com.bootdo.system.controller.BookController.list(java.util.Map)] caches=[bookList] | key=\'\' | keyGenerator=\'\' | cacheManager=\'\' | cacheResolver=\'\' | condition=\'\' | unless=\'\' | sync=\'false\'', NULL, '2018-11-09 16:13:01');
INSERT INTO `sys_log` VALUES (228, 1, 'admin', '登录', 13, 'com.bootdo.system.controller.LoginController.ajaxLogin()', NULL, '127.0.0.1', '2018-11-09 16:14:17');
INSERT INTO `sys_log` VALUES (229, 1, 'admin', '请求访问主页', 31, 'com.bootdo.system.controller.LoginController.index()', NULL, '127.0.0.1', '2018-11-09 16:14:17');
INSERT INTO `sys_log` VALUES (230, 1, 'admin', 'error', NULL, 'http://localhost:8088/system/book/list', 'java.lang.IllegalArgumentException: Cannot find cache named \'bookList\' for Builder[public com.bootdo.common.utils.PageUtils com.bootdo.system.controller.BookController.list(java.util.Map)] caches=[bookList] | key=\'\' | keyGenerator=\'\' | cacheManager=\'\' | cacheResolver=\'\' | condition=\'\' | unless=\'\'', NULL, '2018-11-09 16:14:20');
INSERT INTO `sys_log` VALUES (231, 1, 'admin', 'error', NULL, 'http://localhost:8088/system/book/list', 'java.lang.IllegalArgumentException: Cannot find cache named \'bookList\' for Builder[public com.bootdo.common.utils.PageUtils com.bootdo.system.controller.BookController.list(java.util.Map)] caches=[bookList] | key=\'\' | keyGenerator=\'\' | cacheManager=\'\' | cacheResolver=\'\' | condition=\'\' | unless=\'\'', NULL, '2018-11-09 16:15:04');
INSERT INTO `sys_log` VALUES (232, 1, 'admin', 'error', NULL, 'http://localhost:8088/system/book/list', 'java.lang.IllegalArgumentException: Cannot find cache named \'bookList\' for Builder[public com.bootdo.common.utils.PageUtils com.bootdo.system.controller.BookController.list(java.util.Map)] caches=[bookList] | key=\'\' | keyGenerator=\'\' | cacheManager=\'\' | cacheResolver=\'\' | condition=\'\' | unless=\'\'', NULL, '2018-11-09 16:15:14');
INSERT INTO `sys_log` VALUES (233, 1, 'admin', '登录', 17, 'com.bootdo.system.controller.LoginController.ajaxLogin()', NULL, '127.0.0.1', '2018-11-09 16:25:50');
INSERT INTO `sys_log` VALUES (234, 1, 'admin', '请求访问主页', 35, 'com.bootdo.system.controller.LoginController.index()', NULL, '127.0.0.1', '2018-11-09 16:25:50');
INSERT INTO `sys_log` VALUES (235, 1, 'admin', 'error', NULL, 'http://localhost:8088/system/book/list', 'java.lang.IllegalArgumentException: Cannot find cache named \'bookLists\' for Builder[public com.bootdo.common.utils.PageUtils com.bootdo.system.controller.BookController.list(java.util.Map)] caches=[bookLists] | key=\'\' | keyGenerator=\'\' | cacheManager=\'\' | cacheResolver=\'\' | condition=\'\' | unless=\'\'', NULL, '2018-11-09 16:25:52');
INSERT INTO `sys_log` VALUES (236, 1, 'admin', '登录', 13, 'com.bootdo.system.controller.LoginController.ajaxLogin()', NULL, '127.0.0.1', '2018-11-09 16:28:47');
INSERT INTO `sys_log` VALUES (237, 1, 'admin', '请求访问主页', 35, 'com.bootdo.system.controller.LoginController.index()', NULL, '127.0.0.1', '2018-11-09 16:28:47');
INSERT INTO `sys_log` VALUES (238, 1, 'admin', 'error', NULL, 'http://localhost:8088/system/book/list', 'java.lang.IllegalArgumentException: Cannot find cache named \'bookLists\' for Builder[public java.util.List com.bootdo.system.service.impl.BookServiceImpl.list(java.util.Map)] caches=[bookLists] | key=\'\' | keyGenerator=\'\' | cacheManager=\'\' | cacheResolver=\'\' | condition=\'\' | unless=\'\'', NULL, '2018-11-09 16:28:51');
INSERT INTO `sys_log` VALUES (239, 1, 'admin', '登录', 16, 'com.bootdo.system.controller.LoginController.ajaxLogin()', NULL, '127.0.0.1', '2018-11-09 16:33:44');
INSERT INTO `sys_log` VALUES (240, 1, 'admin', '请求访问主页', 34, 'com.bootdo.system.controller.LoginController.index()', NULL, '127.0.0.1', '2018-11-09 16:33:44');
INSERT INTO `sys_log` VALUES (241, 1, 'admin', 'error', NULL, 'http://localhost:8088/system/book/list', 'java.lang.IllegalArgumentException: Cannot find cache named \'bookLists\' for Builder[public java.util.List com.bootdo.system.service.impl.BookServiceImpl.list(java.util.Map)] caches=[bookLists] | key=\'#bookList\' | keyGenerator=\'\' | cacheManager=\'\' | cacheResolver=\'\' | condition=\'\' | unless=\'\'', NULL, '2018-11-09 16:33:47');
INSERT INTO `sys_log` VALUES (242, 1, 'admin', '登录', 17, 'com.bootdo.system.controller.LoginController.ajaxLogin()', NULL, '127.0.0.1', '2018-11-09 16:41:50');
INSERT INTO `sys_log` VALUES (243, 1, 'admin', '请求访问主页', 34, 'com.bootdo.system.controller.LoginController.index()', NULL, '127.0.0.1', '2018-11-09 16:41:50');
INSERT INTO `sys_log` VALUES (244, 1, 'admin', 'error', NULL, 'http://localhost:8088/system/book/edit/3', 'java.lang.IllegalArgumentException: Cannot find cache named \'book\' for Builder[public com.bootdo.system.domain.BookDO com.bootdo.system.service.impl.BookServiceImpl.get(java.lang.Long)] caches=[book] | key=\'\' | keyGenerator=\'\' | cacheManager=\'\' | cacheResolver=\'\' | condition=\'\' | unless=\'\'', NULL, '2018-11-09 16:41:56');
INSERT INTO `sys_log` VALUES (245, 1, 'admin', '登录', 21, 'com.bootdo.system.controller.LoginController.ajaxLogin()', NULL, '127.0.0.1', '2018-11-09 16:52:08');
INSERT INTO `sys_log` VALUES (246, 1, 'admin', '请求访问主页', 36, 'com.bootdo.system.controller.LoginController.index()', NULL, '127.0.0.1', '2018-11-09 16:52:08');
INSERT INTO `sys_log` VALUES (247, 1, 'admin', 'error', NULL, 'http://localhost:8088/system/book/list', 'java.lang.IllegalArgumentException: Cannot find cache named \'list\' for Builder[public java.util.List com.bootdo.system.service.impl.BookServiceImpl.list(java.util.Map)] caches=[list] | key=\'\' | keyGenerator=\'\' | cacheManager=\'\' | cacheResolver=\'\' | condition=\'\' | unless=\'\'', NULL, '2018-11-09 16:52:11');
INSERT INTO `sys_log` VALUES (248, 1, 'admin', '登录', 13, 'com.bootdo.system.controller.LoginController.ajaxLogin()', NULL, '127.0.0.1', '2018-11-09 16:56:57');
INSERT INTO `sys_log` VALUES (249, 1, 'admin', '请求访问主页', 33, 'com.bootdo.system.controller.LoginController.index()', NULL, '127.0.0.1', '2018-11-09 16:56:57');
INSERT INTO `sys_log` VALUES (250, 1, 'admin', 'error', NULL, 'http://localhost:8088/system/book/list', 'java.lang.IllegalArgumentException: Cannot find cache named \'accountCache\' for Builder[public java.util.List com.bootdo.system.service.impl.BookServiceImpl.list(java.util.Map)] caches=[accountCache] | key=\'\' | keyGenerator=\'\' | cacheManager=\'\' | cacheResolver=\'\' | condition=\'\' | unless=\'\' | sync=\'false\'', NULL, '2018-11-09 16:57:00');
INSERT INTO `sys_log` VALUES (251, 1, 'admin', 'error', NULL, 'http://localhost:8088/system/book/list', 'java.lang.NullPointerException', NULL, '2018-11-09 16:57:08');
INSERT INTO `sys_log` VALUES (252, 1, 'admin', '登录', 14, 'com.bootdo.system.controller.LoginController.ajaxLogin()', NULL, '127.0.0.1', '2018-11-09 17:10:58');
INSERT INTO `sys_log` VALUES (253, 1, 'admin', '请求访问主页', 34, 'com.bootdo.system.controller.LoginController.index()', NULL, '127.0.0.1', '2018-11-09 17:10:58');
INSERT INTO `sys_log` VALUES (254, 1, 'admin', 'error', NULL, 'http://localhost:8088/system/book/list', 'java.lang.IllegalArgumentException: Cannot find cache named \'accountCache\' for Builder[public java.util.List com.bootdo.system.service.impl.BookServiceImpl.list(java.util.Map)] caches=[accountCache] | key=\'\' | keyGenerator=\'\' | cacheManager=\'\' | cacheResolver=\'\' | condition=\'\' | unless=\'\' | sync=\'false\'', NULL, '2018-11-09 17:11:10');
INSERT INTO `sys_log` VALUES (255, 1, 'admin', '登录', 13, 'com.bootdo.system.controller.LoginController.ajaxLogin()', NULL, '127.0.0.1', '2018-11-09 17:14:53');
INSERT INTO `sys_log` VALUES (256, 1, 'admin', '请求访问主页', 31, 'com.bootdo.system.controller.LoginController.index()', NULL, '127.0.0.1', '2018-11-09 17:14:53');
INSERT INTO `sys_log` VALUES (257, 1, 'admin', 'error', NULL, 'http://localhost:8088/system/book/list', 'java.lang.IllegalArgumentException: Cannot find cache named \'accountCache\' for Builder[public java.util.List com.bootdo.system.service.impl.BookServiceImpl.list(java.util.Map)] caches=[accountCache] | key=\'accountCache\' | keyGenerator=\'\' | cacheManager=\'\' | cacheResolver=\'\' | condition=\'\' | unless=\'\'', NULL, '2018-11-09 17:15:09');
INSERT INTO `sys_log` VALUES (258, 1, 'admin', '登录', 12, 'com.bootdo.system.controller.LoginController.ajaxLogin()', NULL, '127.0.0.1', '2018-11-09 17:17:16');
INSERT INTO `sys_log` VALUES (259, 1, 'admin', '请求访问主页', 35, 'com.bootdo.system.controller.LoginController.index()', NULL, '127.0.0.1', '2018-11-09 17:17:16');
INSERT INTO `sys_log` VALUES (260, 1, 'admin', 'error', NULL, 'http://localhost:8088/system/book/list', 'java.lang.IllegalArgumentException: Cannot find cache named \'accountCache\' for Builder[public java.util.List com.bootdo.system.service.impl.BookServiceImpl.list(java.util.Map)] caches=[accountCache] | key=\'accountCache\' | keyGenerator=\'\' | cacheManager=\'\' | cacheResolver=\'\' | condition=\'\' | unless=\'\'', NULL, '2018-11-09 17:17:29');
INSERT INTO `sys_log` VALUES (261, 1, 'admin', '登录', 14, 'com.bootdo.system.controller.LoginController.ajaxLogin()', NULL, '127.0.0.1', '2018-11-09 17:20:19');
INSERT INTO `sys_log` VALUES (262, 1, 'admin', '请求访问主页', 33, 'com.bootdo.system.controller.LoginController.index()', NULL, '127.0.0.1', '2018-11-09 17:20:19');
INSERT INTO `sys_log` VALUES (263, 1, 'admin', 'error', NULL, 'http://localhost:8088/system/book/list', 'java.lang.IllegalArgumentException: Cannot find cache named \'accountCache\' for Builder[public java.util.List com.bootdo.system.service.impl.BookServiceImpl.list(java.util.Map)] caches=[accountCache] | key=\'accountCache\' | keyGenerator=\'\' | cacheManager=\'\' | cacheResolver=\'\' | condition=\'\' | unless=\'\'', NULL, '2018-11-09 17:20:21');
INSERT INTO `sys_log` VALUES (264, 1, 'admin', '登录', 13, 'com.bootdo.system.controller.LoginController.ajaxLogin()', NULL, '127.0.0.1', '2018-11-09 17:23:07');
INSERT INTO `sys_log` VALUES (265, 1, 'admin', '请求访问主页', 30, 'com.bootdo.system.controller.LoginController.index()', NULL, '127.0.0.1', '2018-11-09 17:23:07');
INSERT INTO `sys_log` VALUES (266, 1, 'admin', 'error', NULL, 'http://localhost:8088/system/book/list', 'java.lang.IllegalArgumentException: Cannot find cache named \'accountCache\' for Builder[public java.util.List com.bootdo.system.service.impl.BookServiceImpl.list(java.util.Map)] caches=[accountCache] | key=\'accountCache\' | keyGenerator=\'\' | cacheManager=\'\' | cacheResolver=\'\' | condition=\'\' | unless=\'\'', NULL, '2018-11-09 17:23:14');
INSERT INTO `sys_log` VALUES (267, 1, 'admin', '登录', 14, 'com.bootdo.system.controller.LoginController.ajaxLogin()', NULL, '127.0.0.1', '2018-11-09 17:25:44');
INSERT INTO `sys_log` VALUES (268, 1, 'admin', '请求访问主页', 30, 'com.bootdo.system.controller.LoginController.index()', NULL, '127.0.0.1', '2018-11-09 17:25:44');
INSERT INTO `sys_log` VALUES (269, 1, 'admin', 'error', NULL, 'http://localhost:8088/system/book/list', 'java.lang.IllegalArgumentException: Cannot find cache named \'accountCache\' for Builder[public java.util.List com.bootdo.system.service.impl.BookServiceImpl.list(java.util.Map)] caches=[accountCache] | key=\'accountCache\' | keyGenerator=\'\' | cacheManager=\'\' | cacheResolver=\'\' | condition=\'\' | unless=\'\'', NULL, '2018-11-09 17:25:46');
INSERT INTO `sys_log` VALUES (270, 1, 'admin', '登录', 13, 'com.bootdo.system.controller.LoginController.ajaxLogin()', NULL, '127.0.0.1', '2018-11-09 17:32:27');
INSERT INTO `sys_log` VALUES (271, 1, 'admin', '请求访问主页', 32, 'com.bootdo.system.controller.LoginController.index()', NULL, '127.0.0.1', '2018-11-09 17:32:27');
INSERT INTO `sys_log` VALUES (272, 1, 'admin', '登录', 13, 'com.bootdo.system.controller.LoginController.ajaxLogin()', NULL, '127.0.0.1', '2018-11-09 17:36:30');
INSERT INTO `sys_log` VALUES (273, 1, 'admin', '请求访问主页', 32, 'com.bootdo.system.controller.LoginController.index()', NULL, '127.0.0.1', '2018-11-09 17:36:30');
INSERT INTO `sys_log` VALUES (274, 1, 'admin', '登录', 66, 'com.bootdo.system.controller.LoginController.ajaxLogin()', NULL, '127.0.0.1', '2018-11-26 14:29:30');
INSERT INTO `sys_log` VALUES (275, 1, 'admin', '请求访问主页', 157, 'com.bootdo.system.controller.LoginController.index()', NULL, '127.0.0.1', '2018-11-26 14:29:31');
INSERT INTO `sys_log` VALUES (276, 1, 'admin', '登录', 71, 'com.bootdo.system.controller.LoginController.ajaxLogin()', NULL, '127.0.0.1', '2018-11-30 10:21:30');
INSERT INTO `sys_log` VALUES (277, 1, 'admin', '请求访问主页', 149, 'com.bootdo.system.controller.LoginController.index()', NULL, '127.0.0.1', '2018-11-30 10:21:30');
INSERT INTO `sys_log` VALUES (278, NULL, NULL, 'error', NULL, 'http://localhost:8088/blog/open/list', 'org.apache.ibatis.binding.BindingException: Invalid bound statement (not found): com.bootdo.system.dao.ContentDao.list', NULL, '2018-12-04 19:15:23');
INSERT INTO `sys_log` VALUES (279, NULL, NULL, 'error', NULL, 'http://localhost:8088/blog/open/list', 'org.apache.ibatis.binding.BindingException: Invalid bound statement (not found): com.bootdo.system.dao.ContentDao.list', NULL, '2018-12-04 19:16:11');
INSERT INTO `sys_log` VALUES (280, 1, 'admin', '登录', 64, 'com.bootdo.system.controller.LoginController.ajaxLogin()', NULL, '127.0.0.1', '2018-12-04 19:23:20');
INSERT INTO `sys_log` VALUES (281, 1, 'admin', '请求访问主页', 137, 'com.bootdo.system.controller.LoginController.index()', NULL, '127.0.0.1', '2018-12-04 19:23:20');
INSERT INTO `sys_log` VALUES (282, 1, 'admin', '登录', 11, 'top.cflwork.controller.LoginController.ajaxLogin()', NULL, '127.0.0.1', '2018-12-05 10:09:04');
INSERT INTO `sys_log` VALUES (283, 1, 'admin', '请求访问主页', 80, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2018-12-05 10:09:05');
INSERT INTO `sys_log` VALUES (284, 1, 'admin', '登录', 14, 'top.cflwork.controller.LoginController.ajaxLogin()', NULL, '127.0.0.1', '2018-12-05 10:20:11');
INSERT INTO `sys_log` VALUES (285, 1, 'admin', '请求访问主页', 35, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2018-12-05 10:20:11');
INSERT INTO `sys_log` VALUES (286, 1, 'admin', '编辑用户', 14, 'top.cflwork.controller.UserController.edit()', NULL, '127.0.0.1', '2018-12-05 10:21:58');
INSERT INTO `sys_log` VALUES (287, 1, 'admin', '编辑角色', 3, 'top.cflwork.controller.RoleController.edit()', NULL, '127.0.0.1', '2018-12-05 10:22:16');
INSERT INTO `sys_log` VALUES (288, 1, 'admin', '登录', 16, 'top.cflwork.controller.LoginController.ajaxLogin()', NULL, '127.0.0.1', '2018-12-05 10:48:15');
INSERT INTO `sys_log` VALUES (289, 1, 'admin', '请求访问主页', 33, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2018-12-05 10:48:16');
INSERT INTO `sys_log` VALUES (290, 1, 'admin', '登录', 4, 'top.cflwork.controller.LoginController.ajaxLogin()', NULL, '127.0.0.1', '2018-12-05 10:49:37');
INSERT INTO `sys_log` VALUES (291, 1, 'admin', '请求访问主页', 9, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2018-12-05 10:49:37');
INSERT INTO `sys_log` VALUES (292, 1, 'admin', '登录', 57, 'top.cflwork.controller.LoginController.ajaxLogin()', NULL, '127.0.0.1', '2018-12-16 09:19:15');
INSERT INTO `sys_log` VALUES (293, 1, 'admin', '请求访问主页', 164, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2018-12-16 09:19:16');
INSERT INTO `sys_log` VALUES (294, 1, 'admin', '登录', 18, 'top.cflwork.controller.LoginController.ajaxLogin()', NULL, '127.0.0.1', '2018-12-16 09:28:00');
INSERT INTO `sys_log` VALUES (295, 1, 'admin', '请求访问主页', 30, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2018-12-16 09:28:00');
INSERT INTO `sys_log` VALUES (296, 1, 'admin', '登录', 3, 'top.cflwork.controller.LoginController.ajaxLogin()', NULL, '127.0.0.1', '2018-12-16 09:33:32');
INSERT INTO `sys_log` VALUES (297, 1, 'admin', '请求访问主页', 8, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2018-12-16 09:33:32');
INSERT INTO `sys_log` VALUES (298, 1, 'admin', '编辑菜单', 9, 'top.cflwork.controller.MenuController.edit()', NULL, '127.0.0.1', '2018-12-16 09:33:47');
INSERT INTO `sys_log` VALUES (299, 1, 'admin', '更新菜单', 57, 'top.cflwork.controller.MenuController.update()', NULL, '127.0.0.1', '2018-12-16 09:33:52');
INSERT INTO `sys_log` VALUES (300, 1, 'admin', '更新用户', 45, 'top.cflwork.controller.UserController.updatePeronal()', NULL, '127.0.0.1', '2018-12-16 09:34:59');
INSERT INTO `sys_log` VALUES (301, 1, 'admin', '提交更改用户密码', 2, 'top.cflwork.controller.UserController.resetPwd()', NULL, '127.0.0.1', '2018-12-16 09:36:38');
INSERT INTO `sys_log` VALUES (302, 1, 'admin', '提交更改用户密码', 44, 'top.cflwork.controller.UserController.resetPwd()', NULL, '127.0.0.1', '2018-12-16 09:39:02');
INSERT INTO `sys_log` VALUES (303, -1, '获取用户信息为空', '登录', 3, 'top.cflwork.controller.LoginController.ajaxLogin()', NULL, '127.0.0.1', '2018-12-16 09:39:10');
INSERT INTO `sys_log` VALUES (304, 1, 'admin', '登录', 2, 'top.cflwork.controller.LoginController.ajaxLogin()', NULL, '127.0.0.1', '2018-12-16 09:39:14');
INSERT INTO `sys_log` VALUES (305, 1, 'admin', '请求访问主页', 4, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2018-12-16 09:39:14');
INSERT INTO `sys_log` VALUES (306, 1, 'admin', '提交更改用户密码', 42, 'top.cflwork.controller.UserController.resetPwd()', NULL, '127.0.0.1', '2018-12-16 09:39:26');
INSERT INTO `sys_log` VALUES (307, 1, 'admin', '登录', 14, 'top.cflwork.controller.LoginController.ajaxLogin()', NULL, '127.0.0.1', '2018-12-16 09:48:22');
INSERT INTO `sys_log` VALUES (308, 1, 'admin', '请求访问主页', 31, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2018-12-16 09:48:22');
INSERT INTO `sys_log` VALUES (309, 1, 'admin', '请求访问主页', 6, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2018-12-16 09:51:37');
INSERT INTO `sys_log` VALUES (310, 1, 'admin', '请求访问主页', 6, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2018-12-16 09:51:38');
INSERT INTO `sys_log` VALUES (311, 1, 'admin', '请求访问主页', 5, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2018-12-16 09:51:38');
INSERT INTO `sys_log` VALUES (312, 1, 'admin', '请求访问主页', 4, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2018-12-16 09:51:38');
INSERT INTO `sys_log` VALUES (313, 1, 'admin', '请求访问主页', 6, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2018-12-16 09:51:38');
INSERT INTO `sys_log` VALUES (314, 1, 'admin', '请求访问主页', 4, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2018-12-16 09:51:39');
INSERT INTO `sys_log` VALUES (315, 1, 'admin', '请求访问主页', 7, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2018-12-16 09:51:39');
INSERT INTO `sys_log` VALUES (316, 1, 'admin', '请求访问主页', 5, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2018-12-16 09:51:39');
INSERT INTO `sys_log` VALUES (317, 1, 'admin', '登录', 15, 'top.cflwork.controller.LoginController.ajaxLogin()', NULL, '127.0.0.1', '2018-12-16 09:53:10');
INSERT INTO `sys_log` VALUES (318, 1, 'admin', '请求访问主页', 34, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2018-12-16 09:53:10');
INSERT INTO `sys_log` VALUES (319, 1, 'admin', '登录', 17, 'top.cflwork.controller.LoginController.ajaxLogin()', NULL, '127.0.0.1', '2018-12-16 09:54:37');
INSERT INTO `sys_log` VALUES (320, 1, 'admin', '请求访问主页', 32, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2018-12-16 09:54:37');
INSERT INTO `sys_log` VALUES (321, 1, 'admin', '请求访问主页', 7, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2018-12-16 09:54:55');
INSERT INTO `sys_log` VALUES (322, 1, 'admin', '请求访问主页', 7, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2018-12-16 09:54:56');
INSERT INTO `sys_log` VALUES (323, 1, 'admin', '请求访问主页', 6, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2018-12-16 09:54:56');
INSERT INTO `sys_log` VALUES (324, 1, 'admin', '登录', 13, 'top.cflwork.controller.LoginController.ajaxLogin()', NULL, '127.0.0.1', '2018-12-16 09:57:19');
INSERT INTO `sys_log` VALUES (325, 1, 'admin', '请求访问主页', 35, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2018-12-16 09:57:19');
INSERT INTO `sys_log` VALUES (326, 1, 'admin', '请求访问主页', 8, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2018-12-16 09:58:02');
INSERT INTO `sys_log` VALUES (327, 1, 'admin', '请求访问主页', 7, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2018-12-16 09:58:03');
INSERT INTO `sys_log` VALUES (328, 1, 'admin', '请求访问主页', 7, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2018-12-16 09:58:04');
INSERT INTO `sys_log` VALUES (329, 1, 'admin', '请求访问主页', 6, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2018-12-16 09:58:04');
INSERT INTO `sys_log` VALUES (330, 1, 'admin', '请求访问主页', 6, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2018-12-16 09:58:16');
INSERT INTO `sys_log` VALUES (331, 1, 'admin', '登录', 16, 'top.cflwork.controller.LoginController.ajaxLogin()', NULL, '127.0.0.1', '2018-12-16 10:01:39');
INSERT INTO `sys_log` VALUES (332, 1, 'admin', '请求访问主页', 37, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2018-12-16 10:01:39');
INSERT INTO `sys_log` VALUES (333, 1, 'admin', '请求访问主页', 8, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2018-12-16 10:02:11');
INSERT INTO `sys_log` VALUES (334, 1, 'admin', '登录', 15, 'top.cflwork.controller.LoginController.ajaxLogin()', NULL, '127.0.0.1', '2018-12-16 10:02:40');
INSERT INTO `sys_log` VALUES (335, 1, 'admin', '请求访问主页', 32, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2018-12-16 10:02:40');
INSERT INTO `sys_log` VALUES (336, 1, 'admin', '请求访问主页', 12, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2018-12-16 10:05:42');
INSERT INTO `sys_log` VALUES (337, 1, 'admin', '登录', 16, 'top.cflwork.controller.LoginController.ajaxLogin()', NULL, '127.0.0.1', '2018-12-16 10:07:35');
INSERT INTO `sys_log` VALUES (338, 1, 'admin', '请求访问主页', 35, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2018-12-16 10:07:35');
INSERT INTO `sys_log` VALUES (339, 1, 'admin', '请求访问主页', 8, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2018-12-16 10:08:33');
INSERT INTO `sys_log` VALUES (340, 1, 'admin', '请求访问主页', 8, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2018-12-16 10:08:34');
INSERT INTO `sys_log` VALUES (341, 1, 'admin', '请求访问主页', 7, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2018-12-16 10:08:34');
INSERT INTO `sys_log` VALUES (342, 1, 'admin', '登录', 16, 'top.cflwork.controller.LoginController.ajaxLogin()', NULL, '127.0.0.1', '2018-12-16 10:11:42');
INSERT INTO `sys_log` VALUES (343, 1, 'admin', '请求访问主页', 32, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2018-12-16 10:11:42');
INSERT INTO `sys_log` VALUES (344, 1, 'admin', '请求访问主页', 9, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2018-12-16 10:13:01');
INSERT INTO `sys_log` VALUES (345, 1, 'admin', '登录', 14, 'top.cflwork.controller.LoginController.ajaxLogin()', NULL, '127.0.0.1', '2018-12-16 10:17:59');
INSERT INTO `sys_log` VALUES (346, 1, 'admin', '请求访问主页', 34, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2018-12-16 10:17:59');
INSERT INTO `sys_log` VALUES (347, 1, 'admin', '请求访问主页', 10, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2018-12-16 10:19:34');
INSERT INTO `sys_log` VALUES (348, 1, 'admin', '请求访问主页', 7, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2018-12-16 10:20:05');
INSERT INTO `sys_log` VALUES (349, 1, 'admin', '请求访问主页', 5, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2018-12-16 10:20:16');
INSERT INTO `sys_log` VALUES (350, 1, 'admin', '请求访问主页', 9, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2018-12-16 10:21:55');
INSERT INTO `sys_log` VALUES (351, 1, 'admin', '请求访问主页', 6, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2018-12-16 10:26:49');
INSERT INTO `sys_log` VALUES (352, 1, 'admin', '请求访问主页', 5, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2018-12-16 10:27:13');
INSERT INTO `sys_log` VALUES (353, 1, 'admin', '请求访问主页', 7, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2018-12-16 10:27:58');
INSERT INTO `sys_log` VALUES (354, 1, 'admin', '请求访问主页', 7, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2018-12-16 10:28:21');
INSERT INTO `sys_log` VALUES (355, 1, 'admin', '请求访问主页', 5, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2018-12-16 10:28:54');
INSERT INTO `sys_log` VALUES (356, 1, 'admin', '请求访问主页', 5, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2018-12-16 10:30:08');
INSERT INTO `sys_log` VALUES (357, 1, 'admin', '请求访问主页', 7, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2018-12-16 10:30:41');
INSERT INTO `sys_log` VALUES (358, 1, 'admin', '请求访问主页', 4, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2018-12-16 10:30:59');
INSERT INTO `sys_log` VALUES (359, 1, 'admin', '请求访问主页', 4, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2018-12-16 10:31:34');
INSERT INTO `sys_log` VALUES (360, 1, 'admin', '请求访问主页', 4, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2018-12-16 10:31:55');
INSERT INTO `sys_log` VALUES (361, 1, 'admin', '请求访问主页', 7, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2018-12-16 10:32:35');
INSERT INTO `sys_log` VALUES (362, 1, 'admin', '请求访问主页', 3, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2018-12-16 10:33:08');
INSERT INTO `sys_log` VALUES (363, 1, 'admin', '请求访问主页', 4, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2018-12-16 10:33:20');
INSERT INTO `sys_log` VALUES (364, 1, 'admin', '请求访问主页', 6, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2018-12-16 10:33:35');
INSERT INTO `sys_log` VALUES (365, 1, 'admin', '请求访问主页', 4, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2018-12-16 10:34:22');
INSERT INTO `sys_log` VALUES (366, 1, 'admin', '请求访问主页', 6, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2018-12-16 10:34:45');
INSERT INTO `sys_log` VALUES (367, 1, 'admin', '编辑用户', 10, 'top.cflwork.controller.UserController.edit()', NULL, '127.0.0.1', '2018-12-16 10:35:58');
INSERT INTO `sys_log` VALUES (368, 1, 'admin', '请求更改用户密码', 0, 'top.cflwork.controller.UserController.resetPwd()', NULL, '127.0.0.1', '2018-12-16 10:36:08');
INSERT INTO `sys_log` VALUES (369, 1, 'admin', '请求更改用户密码', 0, 'top.cflwork.controller.UserController.resetPwd()', NULL, '127.0.0.1', '2018-12-16 10:36:13');
INSERT INTO `sys_log` VALUES (370, 1, 'admin', '登录', 3, 'top.cflwork.controller.LoginController.ajaxLogin()', NULL, '127.0.0.1', '2018-12-16 10:41:56');
INSERT INTO `sys_log` VALUES (371, 1, 'admin', '请求访问主页', 6, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2018-12-16 10:41:56');
INSERT INTO `sys_log` VALUES (372, 1, 'admin', '请求访问主页', 5, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2018-12-16 10:44:10');
INSERT INTO `sys_log` VALUES (373, 1, 'admin', '请求访问主页', 5, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2018-12-16 10:44:32');
INSERT INTO `sys_log` VALUES (374, 1, 'admin', '请求访问主页', 4, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2018-12-16 10:44:40');
INSERT INTO `sys_log` VALUES (375, 1, 'admin', '请求访问主页', 4, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2018-12-16 10:44:41');
INSERT INTO `sys_log` VALUES (376, 1, 'admin', '请求访问主页', 3, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2018-12-16 10:44:41');
INSERT INTO `sys_log` VALUES (377, 1, 'admin', '请求访问主页', 3, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2018-12-16 10:44:41');
INSERT INTO `sys_log` VALUES (378, 1, 'admin', '请求访问主页', 6, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2018-12-16 10:44:41');
INSERT INTO `sys_log` VALUES (379, 1, 'admin', '请求访问主页', 4, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2018-12-16 10:44:42');
INSERT INTO `sys_log` VALUES (380, 1, 'admin', '请求访问主页', 3, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2018-12-16 10:44:42');
INSERT INTO `sys_log` VALUES (381, 1, 'admin', '请求访问主页', 3, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2018-12-16 10:44:42');
INSERT INTO `sys_log` VALUES (382, 1, 'admin', '请求访问主页', 3, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2018-12-16 10:44:42');
INSERT INTO `sys_log` VALUES (383, 1, 'admin', '请求访问主页', 3, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2018-12-16 10:44:42');
INSERT INTO `sys_log` VALUES (384, 1, 'admin', '请求访问主页', 3, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2018-12-16 10:44:42');
INSERT INTO `sys_log` VALUES (385, 1, 'admin', '请求访问主页', 2, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2018-12-16 10:44:43');
INSERT INTO `sys_log` VALUES (386, 1, 'admin', '请求访问主页', 2, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2018-12-16 10:44:43');
INSERT INTO `sys_log` VALUES (387, 1, 'admin', '请求访问主页', 3, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2018-12-16 10:44:43');
INSERT INTO `sys_log` VALUES (388, 1, 'admin', '请求访问主页', 3, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2018-12-16 10:44:43');
INSERT INTO `sys_log` VALUES (389, 1, 'admin', '请求访问主页', 3, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2018-12-16 10:44:43');
INSERT INTO `sys_log` VALUES (390, 1, 'admin', '请求访问主页', 3, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2018-12-16 10:44:43');
INSERT INTO `sys_log` VALUES (391, 1, 'admin', '请求访问主页', 3, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2018-12-16 10:44:44');
INSERT INTO `sys_log` VALUES (392, 1, 'admin', '请求访问主页', 5, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2018-12-16 11:04:49');
INSERT INTO `sys_log` VALUES (393, 1, 'admin', '请求访问主页', 4, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2018-12-16 11:06:22');
INSERT INTO `sys_log` VALUES (394, 1, 'admin', '请求访问主页', 4, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2018-12-16 11:06:28');
INSERT INTO `sys_log` VALUES (395, 1, 'admin', '登录', 16, 'top.cflwork.controller.LoginController.ajaxLogin()', NULL, '127.0.0.1', '2018-12-16 11:06:59');
INSERT INTO `sys_log` VALUES (396, 1, 'admin', '请求访问主页', 32, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2018-12-16 11:06:59');
INSERT INTO `sys_log` VALUES (397, 1, 'admin', '请求访问主页', 8, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2018-12-16 11:07:52');
INSERT INTO `sys_log` VALUES (398, 1, 'admin', '登录', 15, 'top.cflwork.controller.LoginController.ajaxLogin()', NULL, '127.0.0.1', '2018-12-16 11:08:50');
INSERT INTO `sys_log` VALUES (399, 1, 'admin', '请求访问主页', 31, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2018-12-16 11:08:50');
INSERT INTO `sys_log` VALUES (400, 1, 'admin', '请求访问主页', 6, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2018-12-16 11:09:07');
INSERT INTO `sys_log` VALUES (401, 1, 'admin', '登录', 4, 'top.cflwork.controller.LoginController.ajaxLogin()', NULL, '127.0.0.1', '2018-12-16 11:09:17');
INSERT INTO `sys_log` VALUES (402, 1, 'admin', '请求访问主页', 7, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2018-12-16 11:09:17');
INSERT INTO `sys_log` VALUES (403, 1, 'admin', '请求访问主页', 5, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2018-12-16 11:10:23');
INSERT INTO `sys_log` VALUES (404, 1, 'admin', '请求访问主页', 7, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2018-12-16 11:11:01');
INSERT INTO `sys_log` VALUES (405, 1, 'admin', '登录', 14, 'top.cflwork.controller.LoginController.ajaxLogin()', NULL, '127.0.0.1', '2018-12-16 11:12:49');
INSERT INTO `sys_log` VALUES (406, 1, 'admin', '请求访问主页', 57, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2018-12-16 11:12:49');
INSERT INTO `sys_log` VALUES (407, 1, 'admin', '请求访问主页', 8, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2018-12-16 11:13:17');
INSERT INTO `sys_log` VALUES (408, 1, 'admin', '请求访问主页', 8, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2018-12-16 11:13:18');
INSERT INTO `sys_log` VALUES (409, 1, 'admin', '请求访问主页', 6, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2018-12-16 11:13:19');
INSERT INTO `sys_log` VALUES (410, 1, 'admin', '请求访问主页', 5, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2018-12-16 11:13:19');
INSERT INTO `sys_log` VALUES (411, 1, 'admin', '请求访问主页', 5, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2018-12-16 11:14:16');
INSERT INTO `sys_log` VALUES (412, 1, 'admin', '请求访问主页', 6, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2018-12-16 11:14:28');
INSERT INTO `sys_log` VALUES (413, 1, 'admin', '请求访问主页', 5, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2018-12-16 11:14:54');
INSERT INTO `sys_log` VALUES (414, 1, 'admin', '请求访问主页', 5, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2018-12-16 11:15:27');
INSERT INTO `sys_log` VALUES (415, 1, 'admin', '请求访问主页', 4, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2018-12-16 11:15:42');
INSERT INTO `sys_log` VALUES (416, 1, 'admin', '请求访问主页', 5, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2018-12-16 11:16:09');
INSERT INTO `sys_log` VALUES (417, 1, 'admin', '请求访问主页', 5, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2018-12-16 11:16:10');
INSERT INTO `sys_log` VALUES (418, 1, 'admin', '请求访问主页', 6, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2018-12-16 11:16:11');
INSERT INTO `sys_log` VALUES (419, 1, 'admin', '请求访问主页', 4, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2018-12-16 11:16:11');
INSERT INTO `sys_log` VALUES (420, 1, 'admin', '请求访问主页', 4, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2018-12-16 11:16:12');
INSERT INTO `sys_log` VALUES (421, 1, 'admin', '请求访问主页', 5, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2018-12-16 11:16:12');
INSERT INTO `sys_log` VALUES (422, 1, 'admin', '请求访问主页', 4, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2018-12-16 11:17:24');
INSERT INTO `sys_log` VALUES (423, 1, 'admin', '登录', 16, 'top.cflwork.controller.LoginController.ajaxLogin()', NULL, '127.0.0.1', '2018-12-16 11:20:37');
INSERT INTO `sys_log` VALUES (424, 1, 'admin', '请求访问主页', 60, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2018-12-16 11:20:37');
INSERT INTO `sys_log` VALUES (425, 1, 'admin', '请求访问主页', 7, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2018-12-16 11:21:31');
INSERT INTO `sys_log` VALUES (426, 1, 'admin', 'error', NULL, 'http://localhost:8088/index', 'org.springframework.web.HttpRequestMethodNotSupportedException: Request method \'POST\' not supported', NULL, '2018-12-16 11:23:30');
INSERT INTO `sys_log` VALUES (427, 1, 'admin', '请求访问主页', 7, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2018-12-16 11:23:36');
INSERT INTO `sys_log` VALUES (428, 1, 'admin', 'error', NULL, 'http://localhost:8088/index', 'org.springframework.web.HttpRequestMethodNotSupportedException: Request method \'POST\' not supported', NULL, '2018-12-16 11:23:43');
INSERT INTO `sys_log` VALUES (429, 1, 'admin', '请求访问主页', 6, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2018-12-16 11:25:15');
INSERT INTO `sys_log` VALUES (430, 1, 'admin', 'error', NULL, 'http://localhost:8088/sys/user/list', 'org.springframework.jdbc.BadSqlGrammarException: \r\n### Error querying database.  Cause: com.mysql.jdbc.exceptions.jdbc4.MySQLSyntaxErrorException: Unknown column \'id\' in \'field list\'\r\n### The error may exist in file [F:\\idea\\cflworks\\target\\classes\\mybatis\\UserMapper.xml]\r\n### The error may involve defaultParameterMap\r\n### The error occurred while setting parameters\r\n### SQL: select count(id) from sys_user\r\n### Cause: com.mysql.jdbc.exceptions.jdbc4.MySQLSyntaxErrorException: Unknown column \'id\' in \'field list\'\n; bad SQL grammar []; nested exception is com.mysql.jdbc.exceptions.jdbc4.MySQLSyntaxErrorException: Unknown column \'id\' in \'field list\'', NULL, '2018-12-16 11:25:21');
INSERT INTO `sys_log` VALUES (431, 1, 'admin', '请求访问主页', 6, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2018-12-16 11:25:35');
INSERT INTO `sys_log` VALUES (432, 1, 'admin', '请求访问主页', 5, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2018-12-16 11:25:37');
INSERT INTO `sys_log` VALUES (433, 1, 'admin', '登录', 19, 'top.cflwork.controller.LoginController.ajaxLogin()', NULL, '127.0.0.1', '2018-12-16 11:33:43');
INSERT INTO `sys_log` VALUES (434, 1, 'admin', '请求访问主页', 63, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2018-12-16 11:33:43');
INSERT INTO `sys_log` VALUES (435, 1, 'admin', '请求访问主页', 9, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2018-12-16 11:33:51');
INSERT INTO `sys_log` VALUES (436, 1, 'admin', '请求访问主页', 7, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2018-12-16 11:33:53');
INSERT INTO `sys_log` VALUES (437, 1, 'admin', '请求访问主页', 5, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2018-12-16 11:33:53');
INSERT INTO `sys_log` VALUES (438, 1, 'admin', '请求访问主页', 6, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2018-12-16 11:33:54');
INSERT INTO `sys_log` VALUES (439, 1, 'admin', '请求访问主页', 4, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2018-12-16 11:33:54');
INSERT INTO `sys_log` VALUES (440, 1, 'admin', '请求访问主页', 4, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2018-12-16 11:33:55');
INSERT INTO `sys_log` VALUES (441, 1, 'admin', '请求访问主页', 4, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2018-12-16 11:33:55');
INSERT INTO `sys_log` VALUES (442, 1, 'admin', '请求访问主页', 10, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2018-12-16 11:33:55');
INSERT INTO `sys_log` VALUES (443, 1, 'admin', '请求访问主页', 6, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2018-12-16 11:34:09');
INSERT INTO `sys_log` VALUES (444, 1, 'admin', '请求访问主页', 5, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2018-12-16 11:35:00');
INSERT INTO `sys_log` VALUES (445, 1, 'admin', '请求访问主页', 5, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2018-12-16 11:35:01');
INSERT INTO `sys_log` VALUES (446, 1, 'admin', '请求访问主页', 4, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2018-12-16 11:35:01');
INSERT INTO `sys_log` VALUES (447, 1, 'admin', '请求访问主页', 3, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2018-12-16 11:35:02');
INSERT INTO `sys_log` VALUES (448, 1, 'admin', '请求访问主页', 4, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2018-12-16 11:35:02');
INSERT INTO `sys_log` VALUES (449, 1, 'admin', '登录', 19, 'top.cflwork.controller.LoginController.ajaxLogin()', NULL, '127.0.0.1', '2018-12-16 11:35:41');
INSERT INTO `sys_log` VALUES (450, 1, 'admin', '请求访问主页', 62, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2018-12-16 11:35:41');
INSERT INTO `sys_log` VALUES (451, 1, 'admin', '请求访问主页', 8, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2018-12-16 11:35:48');
INSERT INTO `sys_log` VALUES (452, 1, 'admin', '请求访问主页', 5, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2018-12-16 11:35:50');
INSERT INTO `sys_log` VALUES (453, 1, 'admin', '请求访问主页', 7, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2018-12-16 11:36:02');
INSERT INTO `sys_log` VALUES (454, 1, 'admin', '请求访问主页', 5, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2018-12-16 11:36:35');
INSERT INTO `sys_log` VALUES (455, 1, 'admin', '请求访问主页', 5, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2018-12-16 11:37:19');
INSERT INTO `sys_log` VALUES (456, 1, 'admin', '请求访问主页', 5, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2018-12-16 11:37:22');
INSERT INTO `sys_log` VALUES (457, 1, 'admin', '登录', 15, 'top.cflwork.controller.LoginController.ajaxLogin()', NULL, '127.0.0.1', '2018-12-16 11:37:58');
INSERT INTO `sys_log` VALUES (458, 1, 'admin', '请求访问主页', 53, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2018-12-16 11:37:58');
INSERT INTO `sys_log` VALUES (459, 1, 'admin', '请求访问主页', 7, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2018-12-16 11:38:03');
INSERT INTO `sys_log` VALUES (460, 1, 'admin', '请求访问主页', 7, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2018-12-16 11:38:50');
INSERT INTO `sys_log` VALUES (461, 1, 'admin', '请求访问主页', 5, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2018-12-16 11:38:51');
INSERT INTO `sys_log` VALUES (462, 1, 'admin', '请求访问主页', 5, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2018-12-16 11:38:51');
INSERT INTO `sys_log` VALUES (463, 1, 'admin', '请求访问主页', 6, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2018-12-16 11:38:51');
INSERT INTO `sys_log` VALUES (464, 1, 'admin', '请求访问主页', 6, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2018-12-16 11:38:52');
INSERT INTO `sys_log` VALUES (465, 1, 'admin', '登录', 17, 'top.cflwork.controller.LoginController.ajaxLogin()', NULL, '127.0.0.1', '2018-12-16 11:39:18');
INSERT INTO `sys_log` VALUES (466, 1, 'admin', '请求访问主页', 63, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2018-12-16 11:39:18');
INSERT INTO `sys_log` VALUES (467, 1, 'admin', '请求访问主页', 8, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2018-12-16 11:40:23');
INSERT INTO `sys_log` VALUES (468, 1, 'admin', '请求访问主页', 6, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2018-12-16 11:40:25');
INSERT INTO `sys_log` VALUES (469, 1, 'admin', '请求访问主页', 5, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2018-12-16 11:40:26');
INSERT INTO `sys_log` VALUES (470, 1, 'admin', '请求访问主页', 6, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2018-12-16 11:40:26');
INSERT INTO `sys_log` VALUES (471, 1, 'admin', '登录', 2, 'top.cflwork.controller.LoginController.ajaxLogin()', NULL, '127.0.0.1', '2018-12-16 11:40:29');
INSERT INTO `sys_log` VALUES (472, 1, 'admin', '请求访问主页', 4, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2018-12-16 11:40:30');
INSERT INTO `sys_log` VALUES (473, 1, 'admin', '登录', 15, 'top.cflwork.controller.LoginController.ajaxLogin()', NULL, '127.0.0.1', '2018-12-16 11:41:00');
INSERT INTO `sys_log` VALUES (474, 1, 'admin', '请求访问主页', 62, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2018-12-16 11:41:01');
INSERT INTO `sys_log` VALUES (475, 1, 'admin', '请求访问主页', 6, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2018-12-16 11:41:27');
INSERT INTO `sys_log` VALUES (476, 1, 'admin', '请求访问主页', 6, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2018-12-16 11:41:43');
INSERT INTO `sys_log` VALUES (477, 1, 'admin', '请求访问主页', 5, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2018-12-16 11:41:44');
INSERT INTO `sys_log` VALUES (478, 1, 'admin', '请求访问主页', 6, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2018-12-16 11:41:44');
INSERT INTO `sys_log` VALUES (479, 1, 'admin', '请求访问主页', 4, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2018-12-16 11:41:44');
INSERT INTO `sys_log` VALUES (480, 1, 'admin', '请求访问主页', 5, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2018-12-16 11:41:45');
INSERT INTO `sys_log` VALUES (481, 1, 'admin', '请求访问主页', 5, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2018-12-16 11:41:45');
INSERT INTO `sys_log` VALUES (482, 1, 'admin', '请求访问主页', 11, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2018-12-16 11:41:45');
INSERT INTO `sys_log` VALUES (483, 1, 'admin', '请求访问主页', 6, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2018-12-16 11:41:46');
INSERT INTO `sys_log` VALUES (484, 1, 'admin', '请求访问主页', 5, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2018-12-16 11:41:46');
INSERT INTO `sys_log` VALUES (485, 1, 'admin', '请求访问主页', 3, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2018-12-16 11:41:47');
INSERT INTO `sys_log` VALUES (486, 1, 'admin', '请求访问主页', 5, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2018-12-16 11:41:47');
INSERT INTO `sys_log` VALUES (487, 1, 'admin', '请求访问主页', 3, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2018-12-16 11:41:47');
INSERT INTO `sys_log` VALUES (488, 1, 'admin', '请求访问主页', 3, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2018-12-16 11:41:48');
INSERT INTO `sys_log` VALUES (489, 1, 'admin', '请求访问主页', 3, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2018-12-16 11:41:48');
INSERT INTO `sys_log` VALUES (490, 1, 'admin', '请求访问主页', 3, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2018-12-16 11:41:49');
INSERT INTO `sys_log` VALUES (491, 1, 'admin', '请求访问主页', 4, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2018-12-16 11:41:49');
INSERT INTO `sys_log` VALUES (492, 1, 'admin', '请求访问主页', 3, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2018-12-16 11:41:49');
INSERT INTO `sys_log` VALUES (493, 1, 'admin', '请求访问主页', 3, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2018-12-16 11:41:50');
INSERT INTO `sys_log` VALUES (494, 1, 'admin', '请求访问主页', 4, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2018-12-16 11:41:50');
INSERT INTO `sys_log` VALUES (495, 1, 'admin', '请求访问主页', 2, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2018-12-16 11:41:51');
INSERT INTO `sys_log` VALUES (496, 1, 'admin', '请求访问主页', 4, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2018-12-16 11:41:51');
INSERT INTO `sys_log` VALUES (497, 1, 'admin', '请求访问主页', 4, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2018-12-16 11:41:51');
INSERT INTO `sys_log` VALUES (498, 1, 'admin', '登录', 3, 'top.cflwork.controller.LoginController.ajaxLogin()', NULL, '127.0.0.1', '2018-12-16 11:41:55');
INSERT INTO `sys_log` VALUES (499, 1, 'admin', '请求访问主页', 5, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2018-12-16 11:41:55');
INSERT INTO `sys_log` VALUES (500, 1, 'admin', '登录', 14, 'top.cflwork.controller.LoginController.ajaxLogin()', NULL, '127.0.0.1', '2018-12-16 11:42:25');
INSERT INTO `sys_log` VALUES (501, 1, 'admin', '请求访问主页', 56, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2018-12-16 11:42:25');
INSERT INTO `sys_log` VALUES (502, 1, 'admin', '登录', 16, 'top.cflwork.controller.LoginController.ajaxLogin()', NULL, '127.0.0.1', '2018-12-16 11:43:50');
INSERT INTO `sys_log` VALUES (503, 1, 'admin', '请求访问主页', 58, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2018-12-16 11:43:50');
INSERT INTO `sys_log` VALUES (504, 1, 'admin', '请求访问主页', 7, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2018-12-16 11:44:20');
INSERT INTO `sys_log` VALUES (505, 1, 'admin', '请求访问主页', 7, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2018-12-16 11:44:56');
INSERT INTO `sys_log` VALUES (506, 1, 'admin', '登录', 15, 'top.cflwork.controller.LoginController.ajaxLogin()', NULL, '127.0.0.1', '2018-12-16 11:45:53');
INSERT INTO `sys_log` VALUES (507, 1, 'admin', '请求访问主页', 55, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2018-12-16 11:45:53');
INSERT INTO `sys_log` VALUES (508, 1, 'admin', '登录', 19, 'top.cflwork.controller.LoginController.ajaxLogin()', NULL, '127.0.0.1', '2018-12-16 11:47:47');
INSERT INTO `sys_log` VALUES (509, 1, 'admin', '请求访问主页', 59, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2018-12-16 11:47:47');
INSERT INTO `sys_log` VALUES (510, 1, 'admin', '请求访问主页', 11, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2018-12-16 11:48:09');
INSERT INTO `sys_log` VALUES (511, 1, 'admin', '登录', 20, 'top.cflwork.controller.LoginController.ajaxLogin()', NULL, '127.0.0.1', '2018-12-16 11:48:35');
INSERT INTO `sys_log` VALUES (512, 1, 'admin', '请求访问主页', 59, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2018-12-16 11:48:35');
INSERT INTO `sys_log` VALUES (513, 1, 'admin', '请求访问主页', 7, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2018-12-16 11:48:48');
INSERT INTO `sys_log` VALUES (514, 1, 'admin', '登录', 17, 'top.cflwork.controller.LoginController.ajaxLogin()', NULL, '127.0.0.1', '2018-12-16 11:49:40');
INSERT INTO `sys_log` VALUES (515, 1, 'admin', '请求访问主页', 63, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2018-12-16 11:49:40');
INSERT INTO `sys_log` VALUES (516, 1, 'admin', '请求访问主页', 7, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2018-12-16 11:50:10');
INSERT INTO `sys_log` VALUES (517, 1, 'admin', '请求访问主页', 6, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2018-12-16 11:51:08');
INSERT INTO `sys_log` VALUES (518, 1, 'admin', '请求访问主页', 8, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2018-12-16 11:51:20');
INSERT INTO `sys_log` VALUES (519, 1, 'admin', '请求访问主页', 6, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2018-12-16 11:51:43');
INSERT INTO `sys_log` VALUES (520, 1, 'admin', '请求访问主页', 6, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2018-12-16 11:54:04');
INSERT INTO `sys_log` VALUES (521, 1, 'admin', '请求访问主页', 5, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2018-12-16 11:56:54');
INSERT INTO `sys_log` VALUES (522, 1, 'admin', '请求访问主页', 5, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2018-12-16 11:58:56');
INSERT INTO `sys_log` VALUES (523, 1, 'admin', '请求访问主页', 15, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2018-12-16 11:59:14');
INSERT INTO `sys_log` VALUES (524, 1, 'admin', '请求访问主页', 4, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2018-12-16 11:59:35');
INSERT INTO `sys_log` VALUES (525, 1, 'admin', '请求访问主页', 5, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2018-12-16 11:59:45');
INSERT INTO `sys_log` VALUES (526, 1, 'admin', '请求访问主页', 4, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2018-12-16 11:59:54');
INSERT INTO `sys_log` VALUES (527, 1, 'admin', '请求访问主页', 4, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2018-12-16 12:00:03');
INSERT INTO `sys_log` VALUES (528, 1, 'admin', '登录', 63, 'top.cflwork.controller.LoginController.ajaxLogin()', NULL, '127.0.0.1', '2018-12-17 13:45:11');
INSERT INTO `sys_log` VALUES (529, 1, 'admin', '请求访问主页', 156, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2018-12-17 13:45:11');
INSERT INTO `sys_log` VALUES (530, 1, 'admin', '登录', 17, 'top.cflwork.controller.LoginController.ajaxLogin()', NULL, '127.0.0.1', '2018-12-17 13:48:18');
INSERT INTO `sys_log` VALUES (531, 1, 'admin', '请求访问主页', 56, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2018-12-17 13:48:18');
INSERT INTO `sys_log` VALUES (532, 1, 'admin', '登录', 17, 'top.cflwork.controller.LoginController.ajaxLogin()', NULL, '127.0.0.1', '2018-12-17 13:50:38');
INSERT INTO `sys_log` VALUES (533, 1, 'admin', '请求访问主页', 48, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2018-12-17 13:50:38');
INSERT INTO `sys_log` VALUES (534, 1, 'admin', '登录', 15, 'top.cflwork.controller.LoginController.ajaxLogin()', NULL, '127.0.0.1', '2018-12-17 13:51:16');
INSERT INTO `sys_log` VALUES (535, 1, 'admin', '请求访问主页', 53, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2018-12-17 13:51:16');
INSERT INTO `sys_log` VALUES (536, 1, 'admin', '登录', 14, 'top.cflwork.controller.LoginController.ajaxLogin()', NULL, '127.0.0.1', '2018-12-17 13:55:35');
INSERT INTO `sys_log` VALUES (537, 1, 'admin', '请求访问主页', 53, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2018-12-17 13:55:36');
INSERT INTO `sys_log` VALUES (538, 1, 'admin', '登录', 170, 'top.cflwork.controller.LoginController.ajaxLogin()', NULL, '127.0.0.1', '2018-12-17 14:01:36');
INSERT INTO `sys_log` VALUES (539, 1, 'admin', '请求访问主页', 418, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2018-12-17 14:01:36');
INSERT INTO `sys_log` VALUES (540, 1, 'admin', '登录', 142, 'top.cflwork.controller.LoginController.ajaxLogin()', NULL, '127.0.0.1', '2018-12-17 14:03:27');
INSERT INTO `sys_log` VALUES (541, 1, 'admin', '请求访问主页', 486, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2018-12-17 14:03:28');
INSERT INTO `sys_log` VALUES (542, 1, 'admin', 'error', NULL, 'http://localhost:8088/v2/api-docs', 'java.lang.NullPointerException', NULL, '2018-12-17 14:03:33');
INSERT INTO `sys_log` VALUES (543, 1, 'admin', 'error', NULL, 'http://localhost:8088/v2/api-docs', 'java.lang.NullPointerException', NULL, '2018-12-17 14:04:19');
INSERT INTO `sys_log` VALUES (544, 1, 'admin', 'error', NULL, 'http://localhost:8088/v2/api-docs', 'java.lang.NullPointerException', NULL, '2018-12-17 14:04:20');
INSERT INTO `sys_log` VALUES (545, 1, 'admin', 'error', NULL, 'http://localhost:8088/v2/api-docs', 'java.lang.NullPointerException', NULL, '2018-12-17 14:04:21');
INSERT INTO `sys_log` VALUES (546, 1, 'admin', 'error', NULL, 'http://localhost:8088/v2/api-docs', 'java.lang.NullPointerException', NULL, '2018-12-17 14:04:21');
INSERT INTO `sys_log` VALUES (547, 1, 'admin', 'error', NULL, 'http://localhost:8088/v2/api-docs', 'java.lang.NullPointerException', NULL, '2018-12-17 14:04:22');
INSERT INTO `sys_log` VALUES (548, 1, 'admin', 'error', NULL, 'http://localhost:8088/v2/api-docs', 'java.lang.NullPointerException', NULL, '2018-12-17 14:04:22');
INSERT INTO `sys_log` VALUES (549, 1, 'admin', 'error', NULL, 'http://localhost:8088/v2/api-docs', 'java.lang.NullPointerException', NULL, '2018-12-17 14:04:22');
INSERT INTO `sys_log` VALUES (550, 1, 'admin', 'error', NULL, 'http://localhost:8088/v2/api-docs', 'java.lang.NullPointerException', NULL, '2018-12-17 14:04:22');
INSERT INTO `sys_log` VALUES (551, 1, 'admin', 'error', NULL, 'http://localhost:8088/v2/api-docs', 'java.lang.NullPointerException', NULL, '2018-12-17 14:04:22');
INSERT INTO `sys_log` VALUES (552, 1, 'admin', 'error', NULL, 'http://localhost:8088/v2/api-docs', 'java.lang.NullPointerException', NULL, '2018-12-17 14:04:23');
INSERT INTO `sys_log` VALUES (553, 1, 'admin', 'error', NULL, 'http://localhost:8088/v2/api-docs', 'java.lang.NullPointerException', NULL, '2018-12-17 14:04:23');
INSERT INTO `sys_log` VALUES (554, 1, 'admin', 'error', NULL, 'http://localhost:8088/v2/api-docs', 'java.lang.NullPointerException', NULL, '2018-12-17 14:04:23');
INSERT INTO `sys_log` VALUES (555, 1, 'admin', 'error', NULL, 'http://localhost:8088/v2/api-docs', 'java.lang.NullPointerException', NULL, '2018-12-17 14:04:23');
INSERT INTO `sys_log` VALUES (556, 1, 'admin', 'error', NULL, 'http://localhost:8088/v2/api-docs', 'java.lang.NullPointerException', NULL, '2018-12-17 14:04:23');
INSERT INTO `sys_log` VALUES (557, 1, 'admin', 'error', NULL, 'http://localhost:8088/v2/api-docs', 'java.lang.NullPointerException', NULL, '2018-12-17 14:04:24');
INSERT INTO `sys_log` VALUES (558, 1, 'admin', 'error', NULL, 'http://localhost:8088/v2/api-docs', 'java.lang.NullPointerException', NULL, '2018-12-17 14:04:24');
INSERT INTO `sys_log` VALUES (559, 1, 'admin', 'error', NULL, 'http://localhost:8088/v2/api-docs', 'java.lang.NullPointerException', NULL, '2018-12-17 14:04:24');
INSERT INTO `sys_log` VALUES (560, 1, 'admin', '登录', 14, 'top.cflwork.controller.LoginController.ajaxLogin()', NULL, '127.0.0.1', '2018-12-17 14:05:29');
INSERT INTO `sys_log` VALUES (561, 1, 'admin', '请求访问主页', 50, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2018-12-17 14:05:29');
INSERT INTO `sys_log` VALUES (562, 1, 'admin', 'error', NULL, 'http://localhost:8088/v2/api-docs', 'java.lang.NullPointerException', NULL, '2018-12-17 14:05:34');
INSERT INTO `sys_log` VALUES (563, 1, 'admin', '登录', 16, 'top.cflwork.controller.LoginController.ajaxLogin()', NULL, '127.0.0.1', '2018-12-17 14:08:49');
INSERT INTO `sys_log` VALUES (564, 1, 'admin', '请求访问主页', 53, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2018-12-17 14:08:50');
INSERT INTO `sys_log` VALUES (565, 1, 'admin', 'error', NULL, 'http://localhost:8088/v2/api-docs', 'java.lang.NullPointerException', NULL, '2018-12-17 14:08:54');
INSERT INTO `sys_log` VALUES (566, 1, 'admin', 'error', NULL, 'http://localhost:8088/v2/api-docs', 'java.lang.NullPointerException', NULL, '2018-12-17 14:09:56');
INSERT INTO `sys_log` VALUES (567, 1, 'admin', '登录', 12, 'top.cflwork.controller.LoginController.ajaxLogin()', NULL, '127.0.0.1', '2018-12-17 14:15:46');
INSERT INTO `sys_log` VALUES (568, 1, 'admin', '请求访问主页', 61, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2018-12-17 14:15:46');
INSERT INTO `sys_log` VALUES (569, 1, 'admin', 'error', NULL, 'http://localhost:8088/v2/api-docs', 'java.lang.NullPointerException', NULL, '2018-12-17 14:15:51');
INSERT INTO `sys_log` VALUES (570, 1, 'admin', '登录', 15, 'top.cflwork.controller.LoginController.ajaxLogin()', NULL, '127.0.0.1', '2018-12-17 14:17:06');
INSERT INTO `sys_log` VALUES (571, 1, 'admin', '请求访问主页', 54, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2018-12-17 14:17:06');
INSERT INTO `sys_log` VALUES (572, 1, 'admin', 'error', NULL, 'http://localhost:8088/v2/api-docs', 'java.lang.NullPointerException', NULL, '2018-12-17 14:17:09');
INSERT INTO `sys_log` VALUES (573, 1, 'admin', '登录', 16, 'top.cflwork.controller.LoginController.ajaxLogin()', NULL, '127.0.0.1', '2018-12-17 14:28:10');
INSERT INTO `sys_log` VALUES (574, 1, 'admin', '请求访问主页', 55, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2018-12-17 14:28:11');
INSERT INTO `sys_log` VALUES (575, 1, 'admin', 'error', NULL, 'http://localhost:8088/v2/api-docs', 'java.lang.NullPointerException', NULL, '2018-12-17 14:28:15');
INSERT INTO `sys_log` VALUES (576, 1, 'admin', '登录', 15, 'top.cflwork.controller.LoginController.ajaxLogin()', NULL, '127.0.0.1', '2018-12-17 14:31:53');
INSERT INTO `sys_log` VALUES (577, 1, 'admin', '请求访问主页', 54, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2018-12-17 14:31:53');
INSERT INTO `sys_log` VALUES (578, 1, 'admin', 'error', NULL, 'http://localhost:8088/v2/api-docs', 'java.lang.NullPointerException', NULL, '2018-12-17 14:32:03');
INSERT INTO `sys_log` VALUES (579, 1, 'admin', 'error', NULL, 'http://localhost:8088/v2/api-docs', 'java.lang.NullPointerException', NULL, '2018-12-17 14:32:33');
INSERT INTO `sys_log` VALUES (580, 1, 'admin', 'error', NULL, 'http://localhost:8088/v2/api-docs', 'java.lang.NullPointerException', NULL, '2018-12-17 14:32:35');
INSERT INTO `sys_log` VALUES (581, 1, 'admin', 'error', NULL, 'http://localhost:8088/v2/api-docs', 'java.lang.NullPointerException', NULL, '2018-12-17 14:32:36');
INSERT INTO `sys_log` VALUES (582, 1, 'admin', 'error', NULL, 'http://localhost:8088/v2/api-docs', 'java.lang.NullPointerException', NULL, '2018-12-17 14:32:37');
INSERT INTO `sys_log` VALUES (583, 1, 'admin', 'error', NULL, 'http://localhost:8088/v2/api-docs', 'java.lang.NullPointerException', NULL, '2018-12-17 14:32:37');
INSERT INTO `sys_log` VALUES (584, 1, 'admin', 'error', NULL, 'http://localhost:8088/v2/api-docs', 'java.lang.NullPointerException', NULL, '2018-12-17 14:32:43');
INSERT INTO `sys_log` VALUES (585, 1, 'admin', 'error', NULL, 'http://localhost:8088/v2/api-docs', 'java.lang.NullPointerException', NULL, '2018-12-17 14:32:52');
INSERT INTO `sys_log` VALUES (586, 1, 'admin', 'error', NULL, 'http://localhost:8088/v2/api-docs', 'java.lang.NullPointerException', NULL, '2018-12-17 14:32:55');
INSERT INTO `sys_log` VALUES (587, 1, 'admin', '登录', 15, 'top.cflwork.controller.LoginController.ajaxLogin()', NULL, '127.0.0.1', '2018-12-17 14:36:07');
INSERT INTO `sys_log` VALUES (588, 1, 'admin', '请求访问主页', 51, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2018-12-17 14:36:07');
INSERT INTO `sys_log` VALUES (589, 1, 'admin', '登录', 16, 'top.cflwork.controller.LoginController.ajaxLogin()', NULL, '127.0.0.1', '2018-12-17 14:44:07');
INSERT INTO `sys_log` VALUES (590, 1, 'admin', '请求访问主页', 53, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2018-12-17 14:44:07');
INSERT INTO `sys_log` VALUES (591, 1, 'admin', '登录', 18, 'top.cflwork.controller.LoginController.ajaxLogin()', NULL, '127.0.0.1', '2018-12-17 14:46:14');
INSERT INTO `sys_log` VALUES (592, 1, 'admin', '请求访问主页', 59, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2018-12-17 14:46:14');
INSERT INTO `sys_log` VALUES (593, 1, 'admin', '请求访问主页', 7, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2018-12-17 14:47:53');
INSERT INTO `sys_log` VALUES (594, 1, 'admin', '登录', 17, 'top.cflwork.controller.LoginController.ajaxLogin()', NULL, '127.0.0.1', '2018-12-17 14:48:38');
INSERT INTO `sys_log` VALUES (595, 1, 'admin', '请求访问主页', 55, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2018-12-17 14:48:38');
INSERT INTO `sys_log` VALUES (596, 1, 'admin', '登录', 3, 'top.cflwork.controller.LoginController.ajaxLogin()', NULL, '127.0.0.1', '2018-12-17 14:54:30');
INSERT INTO `sys_log` VALUES (597, 1, 'admin', '请求访问主页', 7, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2018-12-17 14:54:30');
INSERT INTO `sys_log` VALUES (598, 1, 'admin', '请求访问主页', 6, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2018-12-17 14:57:57');
INSERT INTO `sys_log` VALUES (599, 1, 'admin', '请求访问主页', 38, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2018-12-17 14:58:01');
INSERT INTO `sys_log` VALUES (600, 1, 'admin', '请求访问主页', 4, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2018-12-17 14:58:02');
INSERT INTO `sys_log` VALUES (601, 1, 'admin', '请求访问主页', 9, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2018-12-17 14:58:02');
INSERT INTO `sys_log` VALUES (602, 1, 'admin', '请求访问主页', 6, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2018-12-17 14:58:03');
INSERT INTO `sys_log` VALUES (603, 1, 'admin', '登录', 15, 'top.cflwork.controller.LoginController.ajaxLogin()', NULL, '127.0.0.1', '2018-12-17 14:58:27');
INSERT INTO `sys_log` VALUES (604, 1, 'admin', '请求访问主页', 60, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2018-12-17 14:58:27');
INSERT INTO `sys_log` VALUES (605, 1, 'admin', '登录', 3, 'top.cflwork.controller.LoginController.ajaxLogin()', NULL, '127.0.0.1', '2018-12-17 14:59:58');
INSERT INTO `sys_log` VALUES (606, 1, 'admin', '请求访问主页', 6, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2018-12-17 14:59:58');
INSERT INTO `sys_log` VALUES (607, 1, 'admin', '请求访问主页', 5, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2018-12-17 15:02:37');
INSERT INTO `sys_log` VALUES (608, 1, 'admin', '登录', 14, 'top.cflwork.controller.LoginController.ajaxLogin()', NULL, '127.0.0.1', '2018-12-17 15:04:50');
INSERT INTO `sys_log` VALUES (609, 1, 'admin', '请求访问主页', 59, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2018-12-17 15:04:50');
INSERT INTO `sys_log` VALUES (610, 1, 'admin', '请求访问主页', 6, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2018-12-17 15:06:36');
INSERT INTO `sys_log` VALUES (611, 1, 'admin', 'error', NULL, 'http://localhost:8088/user/list', 'java.lang.NullPointerException', NULL, '2018-12-17 15:07:12');
INSERT INTO `sys_log` VALUES (612, 1, 'admin', '请求访问主页', 6, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2018-12-17 15:12:07');
INSERT INTO `sys_log` VALUES (613, 1, 'admin', '添加菜单', 3, 'top.cflwork.controller.MenuController.add()', NULL, '127.0.0.1', '2018-12-17 15:12:36');
INSERT INTO `sys_log` VALUES (614, 1, 'admin', '请求访问主页', 13, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2018-12-17 15:37:05');
INSERT INTO `sys_log` VALUES (615, 1, 'admin', '请求访问主页', 6, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2018-12-17 15:37:18');
INSERT INTO `sys_log` VALUES (616, 1, 'admin', '登录', 2, 'top.cflwork.controller.LoginController.ajaxLogin()', NULL, '127.0.0.1', '2018-12-17 15:37:24');
INSERT INTO `sys_log` VALUES (617, 1, 'admin', '请求访问主页', 5, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2018-12-17 15:37:24');
INSERT INTO `sys_log` VALUES (618, 1, 'admin', '登录', 16, 'top.cflwork.controller.LoginController.ajaxLogin()', NULL, '127.0.0.1', '2018-12-17 15:38:49');
INSERT INTO `sys_log` VALUES (619, 1, 'admin', '请求访问主页', 57, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2018-12-17 15:38:49');
INSERT INTO `sys_log` VALUES (620, 1, 'admin', '登录', 16, 'top.cflwork.controller.LoginController.ajaxLogin()', NULL, '127.0.0.1', '2018-12-17 15:39:51');
INSERT INTO `sys_log` VALUES (621, 1, 'admin', '请求访问主页', 57, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2018-12-17 15:39:51');
INSERT INTO `sys_log` VALUES (622, 1, 'admin', '请求访问主页', 7, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2018-12-17 15:43:18');
INSERT INTO `sys_log` VALUES (623, 1, 'admin', '登录', 17, 'top.cflwork.controller.LoginController.ajaxLogin()', NULL, '127.0.0.1', '2018-12-17 15:44:00');
INSERT INTO `sys_log` VALUES (624, 1, 'admin', '请求访问主页', 56, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2018-12-17 15:44:00');
INSERT INTO `sys_log` VALUES (625, 1, 'admin', 'error', NULL, 'http://localhost:8088/user/list', 'org.springframework.jdbc.BadSqlGrammarException: \r\n### Error querying database.  Cause: com.mysql.jdbc.exceptions.jdbc4.MySQLSyntaxErrorException: Unknown column \'id\' in \'field list\'\r\n### The error may exist in file [F:\\idea\\cflworks\\target\\classes\\mybatis\\UserMapper.xml]\r\n### The error may involve defaultParameterMap\r\n### The error occurred while setting parameters\r\n### SQL: select count(id) from sys_user\r\n### Cause: com.mysql.jdbc.exceptions.jdbc4.MySQLSyntaxErrorException: Unknown column \'id\' in \'field list\'\n; bad SQL grammar []; nested exception is com.mysql.jdbc.exceptions.jdbc4.MySQLSyntaxErrorException: Unknown column \'id\' in \'field list\'', NULL, '2018-12-17 15:44:02');
INSERT INTO `sys_log` VALUES (626, 1, 'admin', 'error', NULL, 'http://localhost:8088/user/list', 'org.springframework.jdbc.BadSqlGrammarException: \r\n### Error querying database.  Cause: com.mysql.jdbc.exceptions.jdbc4.MySQLSyntaxErrorException: Unknown column \'id\' in \'field list\'\r\n### The error may exist in file [F:\\idea\\cflworks\\target\\classes\\mybatis\\UserMapper.xml]\r\n### The error may involve defaultParameterMap\r\n### The error occurred while setting parameters\r\n### SQL: select count(id) from sys_user     WHERE  dept_id = ?\r\n### Cause: com.mysql.jdbc.exceptions.jdbc4.MySQLSyntaxErrorException: Unknown column \'id\' in \'field list\'\n; bad SQL grammar []; nested exception is com.mysql.jdbc.exceptions.jdbc4.MySQLSyntaxErrorException: Unknown column \'id\' in \'field list\'', NULL, '2018-12-17 15:44:10');
INSERT INTO `sys_log` VALUES (627, 1, 'admin', 'error', NULL, 'http://localhost:8088/user/list', 'org.springframework.jdbc.BadSqlGrammarException: \r\n### Error querying database.  Cause: com.mysql.jdbc.exceptions.jdbc4.MySQLSyntaxErrorException: Unknown column \'id\' in \'field list\'\r\n### The error may exist in file [F:\\idea\\cflworks\\target\\classes\\mybatis\\UserMapper.xml]\r\n### The error may involve defaultParameterMap\r\n### The error occurred while setting parameters\r\n### SQL: select count(id) from sys_user     WHERE  dept_id = ?\r\n### Cause: com.mysql.jdbc.exceptions.jdbc4.MySQLSyntaxErrorException: Unknown column \'id\' in \'field list\'\n; bad SQL grammar []; nested exception is com.mysql.jdbc.exceptions.jdbc4.MySQLSyntaxErrorException: Unknown column \'id\' in \'field list\'', NULL, '2018-12-17 15:44:10');
INSERT INTO `sys_log` VALUES (628, 1, 'admin', 'error', NULL, 'http://localhost:8088/user/list', 'org.springframework.jdbc.BadSqlGrammarException: \r\n### Error querying database.  Cause: com.mysql.jdbc.exceptions.jdbc4.MySQLSyntaxErrorException: Unknown column \'id\' in \'field list\'\r\n### The error may exist in file [F:\\idea\\cflworks\\target\\classes\\mybatis\\UserMapper.xml]\r\n### The error may involve defaultParameterMap\r\n### The error occurred while setting parameters\r\n### SQL: select count(id) from sys_user     WHERE  dept_id = ?\r\n### Cause: com.mysql.jdbc.exceptions.jdbc4.MySQLSyntaxErrorException: Unknown column \'id\' in \'field list\'\n; bad SQL grammar []; nested exception is com.mysql.jdbc.exceptions.jdbc4.MySQLSyntaxErrorException: Unknown column \'id\' in \'field list\'', NULL, '2018-12-17 15:44:11');
INSERT INTO `sys_log` VALUES (629, 1, 'admin', 'error', NULL, 'http://localhost:8088/user/list', 'org.springframework.jdbc.BadSqlGrammarException: \r\n### Error querying database.  Cause: com.mysql.jdbc.exceptions.jdbc4.MySQLSyntaxErrorException: Unknown column \'id\' in \'field list\'\r\n### The error may exist in file [F:\\idea\\cflworks\\target\\classes\\mybatis\\UserMapper.xml]\r\n### The error may involve defaultParameterMap\r\n### The error occurred while setting parameters\r\n### SQL: select count(id) from sys_user     WHERE  dept_id = ?\r\n### Cause: com.mysql.jdbc.exceptions.jdbc4.MySQLSyntaxErrorException: Unknown column \'id\' in \'field list\'\n; bad SQL grammar []; nested exception is com.mysql.jdbc.exceptions.jdbc4.MySQLSyntaxErrorException: Unknown column \'id\' in \'field list\'', NULL, '2018-12-17 15:44:11');
INSERT INTO `sys_log` VALUES (630, 1, 'admin', 'error', NULL, 'http://localhost:8088/user/list', 'org.springframework.jdbc.BadSqlGrammarException: \r\n### Error querying database.  Cause: com.mysql.jdbc.exceptions.jdbc4.MySQLSyntaxErrorException: Unknown column \'id\' in \'field list\'\r\n### The error may exist in file [F:\\idea\\cflworks\\target\\classes\\mybatis\\UserMapper.xml]\r\n### The error may involve defaultParameterMap\r\n### The error occurred while setting parameters\r\n### SQL: select count(id) from sys_user     WHERE  dept_id = ?\r\n### Cause: com.mysql.jdbc.exceptions.jdbc4.MySQLSyntaxErrorException: Unknown column \'id\' in \'field list\'\n; bad SQL grammar []; nested exception is com.mysql.jdbc.exceptions.jdbc4.MySQLSyntaxErrorException: Unknown column \'id\' in \'field list\'', NULL, '2018-12-17 15:44:12');
INSERT INTO `sys_log` VALUES (631, 1, 'admin', 'error', NULL, 'http://localhost:8088/user/list', 'org.springframework.jdbc.BadSqlGrammarException: \r\n### Error querying database.  Cause: com.mysql.jdbc.exceptions.jdbc4.MySQLSyntaxErrorException: Unknown column \'id\' in \'field list\'\r\n### The error may exist in file [F:\\idea\\cflworks\\target\\classes\\mybatis\\UserMapper.xml]\r\n### The error may involve defaultParameterMap\r\n### The error occurred while setting parameters\r\n### SQL: select count(id) from sys_user     WHERE  dept_id = ?\r\n### Cause: com.mysql.jdbc.exceptions.jdbc4.MySQLSyntaxErrorException: Unknown column \'id\' in \'field list\'\n; bad SQL grammar []; nested exception is com.mysql.jdbc.exceptions.jdbc4.MySQLSyntaxErrorException: Unknown column \'id\' in \'field list\'', NULL, '2018-12-17 15:44:12');
INSERT INTO `sys_log` VALUES (632, 1, 'admin', 'error', NULL, 'http://localhost:8088/user/list', 'org.springframework.jdbc.BadSqlGrammarException: \r\n### Error querying database.  Cause: com.mysql.jdbc.exceptions.jdbc4.MySQLSyntaxErrorException: Unknown column \'id\' in \'field list\'\r\n### The error may exist in file [F:\\idea\\cflworks\\target\\classes\\mybatis\\UserMapper.xml]\r\n### The error may involve defaultParameterMap\r\n### The error occurred while setting parameters\r\n### SQL: select count(id) from sys_user     WHERE  dept_id = ?\r\n### Cause: com.mysql.jdbc.exceptions.jdbc4.MySQLSyntaxErrorException: Unknown column \'id\' in \'field list\'\n; bad SQL grammar []; nested exception is com.mysql.jdbc.exceptions.jdbc4.MySQLSyntaxErrorException: Unknown column \'id\' in \'field list\'', NULL, '2018-12-17 15:44:12');
INSERT INTO `sys_log` VALUES (633, 1, 'admin', 'error', NULL, 'http://localhost:8088/user/list', 'org.springframework.jdbc.BadSqlGrammarException: \r\n### Error querying database.  Cause: com.mysql.jdbc.exceptions.jdbc4.MySQLSyntaxErrorException: Unknown column \'id\' in \'field list\'\r\n### The error may exist in file [F:\\idea\\cflworks\\target\\classes\\mybatis\\UserMapper.xml]\r\n### The error may involve defaultParameterMap\r\n### The error occurred while setting parameters\r\n### SQL: select count(id) from sys_user\r\n### Cause: com.mysql.jdbc.exceptions.jdbc4.MySQLSyntaxErrorException: Unknown column \'id\' in \'field list\'\n; bad SQL grammar []; nested exception is com.mysql.jdbc.exceptions.jdbc4.MySQLSyntaxErrorException: Unknown column \'id\' in \'field list\'', NULL, '2018-12-17 15:44:15');
INSERT INTO `sys_log` VALUES (634, 1, 'admin', '登录', 17, 'top.cflwork.controller.LoginController.ajaxLogin()', NULL, '127.0.0.1', '2018-12-17 15:48:22');
INSERT INTO `sys_log` VALUES (635, 1, 'admin', '请求访问主页', 61, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2018-12-17 15:48:22');
INSERT INTO `sys_log` VALUES (636, 1, 'admin', '登录', 15, 'top.cflwork.controller.LoginController.ajaxLogin()', NULL, '127.0.0.1', '2018-12-17 15:53:34');
INSERT INTO `sys_log` VALUES (637, 1, 'admin', '请求访问主页', 55, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2018-12-17 15:53:34');
INSERT INTO `sys_log` VALUES (638, 1, 'admin', '编辑用户', 12, 'top.cflwork.controller.UserController.edit()', NULL, '127.0.0.1', '2018-12-17 15:54:25');
INSERT INTO `sys_log` VALUES (639, 1, 'admin', '编辑用户', 5, 'top.cflwork.controller.UserController.edit()', NULL, '127.0.0.1', '2018-12-17 15:54:36');
INSERT INTO `sys_log` VALUES (640, 1, 'admin', '登录', 16, 'top.cflwork.controller.LoginController.ajaxLogin()', NULL, '127.0.0.1', '2018-12-17 15:56:28');
INSERT INTO `sys_log` VALUES (641, 1, 'admin', '请求访问主页', 57, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2018-12-17 15:56:28');
INSERT INTO `sys_log` VALUES (642, 1, 'admin', '编辑用户', 8, 'top.cflwork.controller.UserController.edit()', NULL, '127.0.0.1', '2018-12-17 15:56:50');
INSERT INTO `sys_log` VALUES (643, 1, 'admin', '更新用户', 64, 'top.cflwork.controller.UserController.update()', NULL, '127.0.0.1', '2018-12-17 15:56:56');
INSERT INTO `sys_log` VALUES (644, 1, 'admin', '编辑用户', 7, 'top.cflwork.controller.UserController.edit()', NULL, '127.0.0.1', '2018-12-17 15:57:00');
INSERT INTO `sys_log` VALUES (645, 1, 'admin', '请求访问主页', 6, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2018-12-17 15:57:37');
INSERT INTO `sys_log` VALUES (646, 1, 'admin', '编辑用户', 6, 'top.cflwork.controller.UserController.edit()', NULL, '127.0.0.1', '2018-12-17 15:57:40');
INSERT INTO `sys_log` VALUES (647, 1, 'admin', '更新用户', 43, 'top.cflwork.controller.UserController.update()', NULL, '127.0.0.1', '2018-12-17 15:57:47');
INSERT INTO `sys_log` VALUES (648, 1, 'admin', '编辑用户', 7, 'top.cflwork.controller.UserController.edit()', NULL, '127.0.0.1', '2018-12-17 15:57:49');
INSERT INTO `sys_log` VALUES (649, 1, 'admin', '编辑用户', 6, 'top.cflwork.controller.UserController.edit()', NULL, '127.0.0.1', '2018-12-17 15:57:55');
INSERT INTO `sys_log` VALUES (650, 1, 'admin', '更新用户', 45, 'top.cflwork.controller.UserController.update()', NULL, '127.0.0.1', '2018-12-17 15:57:57');
INSERT INTO `sys_log` VALUES (651, 1, 'admin', '编辑用户', 6, 'top.cflwork.controller.UserController.edit()', NULL, '127.0.0.1', '2018-12-17 15:58:05');
INSERT INTO `sys_log` VALUES (652, 1, 'admin', '更新用户', 52, 'top.cflwork.controller.UserController.update()', NULL, '127.0.0.1', '2018-12-17 15:58:07');
INSERT INTO `sys_log` VALUES (653, 1, 'admin', '添加用户', 2, 'top.cflwork.controller.UserController.add()', NULL, '127.0.0.1', '2018-12-17 15:58:18');
INSERT INTO `sys_log` VALUES (654, 1, 'admin', '编辑用户', 6, 'top.cflwork.controller.UserController.edit()', NULL, '127.0.0.1', '2018-12-17 15:58:23');
INSERT INTO `sys_log` VALUES (655, 1, 'admin', '请求访问主页', 7, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2018-12-17 15:58:40');
INSERT INTO `sys_log` VALUES (656, 1, 'admin', '编辑用户', 6, 'top.cflwork.controller.UserController.edit()', NULL, '127.0.0.1', '2018-12-17 15:58:45');
INSERT INTO `sys_log` VALUES (657, 1, 'admin', '添加用户', 2, 'top.cflwork.controller.UserController.add()', NULL, '127.0.0.1', '2018-12-17 15:58:47');
INSERT INTO `sys_log` VALUES (658, 1, 'admin', '保存用户', 49, 'top.cflwork.controller.UserController.save()', NULL, '127.0.0.1', '2018-12-17 15:59:15');
INSERT INTO `sys_log` VALUES (659, 1, 'admin', '请求更改用户密码', 0, 'top.cflwork.controller.UserController.resetPwd()', NULL, '127.0.0.1', '2018-12-17 15:59:18');
INSERT INTO `sys_log` VALUES (660, 1, 'admin', 'admin提交更改用户密码', 99, 'top.cflwork.controller.UserController.adminResetPwd()', NULL, '127.0.0.1', '2018-12-17 15:59:20');
INSERT INTO `sys_log` VALUES (661, 1, 'admin', '删除用户', 41, 'top.cflwork.controller.UserController.remove()', NULL, '127.0.0.1', '2018-12-17 15:59:24');
INSERT INTO `sys_log` VALUES (662, 1, 'admin', '登录', 14, 'top.cflwork.controller.LoginController.ajaxLogin()', NULL, '127.0.0.1', '2018-12-17 16:05:37');
INSERT INTO `sys_log` VALUES (663, 1, 'admin', '请求访问主页', 55, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2018-12-17 16:05:37');
INSERT INTO `sys_log` VALUES (664, 1, 'admin', '请求访问主页', 8, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2018-12-17 16:06:01');
INSERT INTO `sys_log` VALUES (665, 1, 'admin', '编辑角色', 4, 'top.cflwork.controller.RoleController.edit()', NULL, '127.0.0.1', '2018-12-17 16:06:05');
INSERT INTO `sys_log` VALUES (666, 1, 'admin', '请求访问主页', 6, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2018-12-17 16:06:32');
INSERT INTO `sys_log` VALUES (667, 1, 'admin', '编辑角色', 1, 'top.cflwork.controller.RoleController.edit()', NULL, '127.0.0.1', '2018-12-17 16:06:40');
INSERT INTO `sys_log` VALUES (668, 1, 'admin', '更新角色', 121, 'top.cflwork.controller.RoleController.update()', NULL, '127.0.0.1', '2018-12-17 16:06:46');
INSERT INTO `sys_log` VALUES (669, 1, 'admin', '编辑角色', 2, 'top.cflwork.controller.RoleController.edit()', NULL, '127.0.0.1', '2018-12-17 16:06:48');
INSERT INTO `sys_log` VALUES (670, 1, 'admin', '编辑角色', 3, 'top.cflwork.controller.RoleController.edit()', NULL, '127.0.0.1', '2018-12-17 16:07:07');
INSERT INTO `sys_log` VALUES (671, 1, 'admin', '更新角色', 122, 'top.cflwork.controller.RoleController.update()', NULL, '127.0.0.1', '2018-12-17 16:07:13');
INSERT INTO `sys_log` VALUES (672, 1, 'admin', '登录', 17, 'top.cflwork.controller.LoginController.ajaxLogin()', NULL, '127.0.0.1', '2018-12-17 16:10:16');
INSERT INTO `sys_log` VALUES (673, 1, 'admin', '请求访问主页', 54, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2018-12-17 16:10:16');
INSERT INTO `sys_log` VALUES (674, 1, 'admin', '登录', 16, 'top.cflwork.controller.LoginController.ajaxLogin()', NULL, '127.0.0.1', '2018-12-17 16:12:33');
INSERT INTO `sys_log` VALUES (675, 1, 'admin', '请求访问主页', 60, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2018-12-17 16:12:33');
INSERT INTO `sys_log` VALUES (676, 1, 'admin', '登录', 4, 'top.cflwork.controller.LoginController.ajaxLogin()', NULL, '127.0.0.1', '2018-12-17 16:14:03');
INSERT INTO `sys_log` VALUES (677, 1, 'admin', '请求访问主页', 7, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2018-12-17 16:14:03');
INSERT INTO `sys_log` VALUES (678, 1, 'admin', 'error', NULL, 'http://localhost:8088/menu/edit/103', 'java.lang.NullPointerException', NULL, '2018-12-17 16:14:15');
INSERT INTO `sys_log` VALUES (679, 1, 'admin', '添加菜单', 3, 'top.cflwork.controller.MenuController.add()', NULL, '127.0.0.1', '2018-12-17 16:14:31');
INSERT INTO `sys_log` VALUES (680, 1, 'admin', 'error', NULL, 'http://localhost:8088/menu/edit/103', 'java.lang.NullPointerException', NULL, '2018-12-17 16:14:35');
INSERT INTO `sys_log` VALUES (681, 1, 'admin', '编辑菜单', 2, 'top.cflwork.controller.MenuController.edit()', NULL, '127.0.0.1', '2018-12-17 16:15:14');
INSERT INTO `sys_log` VALUES (682, 1, 'admin', '编辑菜单', 8, 'top.cflwork.controller.MenuController.edit()', NULL, '127.0.0.1', '2018-12-17 16:15:21');
INSERT INTO `sys_log` VALUES (683, 1, 'admin', 'error', NULL, 'http://localhost:8088/menu/edit/103', 'java.lang.NullPointerException', NULL, '2018-12-17 16:15:23');
INSERT INTO `sys_log` VALUES (684, 1, 'admin', '删除菜单', 39, 'top.cflwork.controller.MenuController.remove()', NULL, '127.0.0.1', '2018-12-17 16:15:59');
INSERT INTO `sys_log` VALUES (685, 1, 'admin', '添加菜单', 3, 'top.cflwork.controller.MenuController.add()', NULL, '127.0.0.1', '2018-12-17 16:16:14');
INSERT INTO `sys_log` VALUES (686, 1, 'admin', '保存菜单', 40, 'top.cflwork.controller.MenuController.save()', NULL, '127.0.0.1', '2018-12-17 16:16:21');
INSERT INTO `sys_log` VALUES (687, 1, 'admin', '编辑菜单', 4, 'top.cflwork.controller.MenuController.edit()', NULL, '127.0.0.1', '2018-12-17 16:16:26');
INSERT INTO `sys_log` VALUES (688, 1, 'admin', '更新菜单', 68, 'top.cflwork.controller.MenuController.update()', NULL, '127.0.0.1', '2018-12-17 16:16:29');
INSERT INTO `sys_log` VALUES (689, 1, 'admin', '删除菜单', 41, 'top.cflwork.controller.MenuController.remove()', NULL, '127.0.0.1', '2018-12-17 16:16:36');
INSERT INTO `sys_log` VALUES (690, 1, 'admin', '添加菜单', 0, 'top.cflwork.controller.MenuController.add()', NULL, '127.0.0.1', '2018-12-17 16:16:44');
INSERT INTO `sys_log` VALUES (691, 1, 'admin', '保存菜单', 67, 'top.cflwork.controller.MenuController.save()', NULL, '127.0.0.1', '2018-12-17 16:16:53');
INSERT INTO `sys_log` VALUES (692, 1, 'admin', '添加菜单', 2, 'top.cflwork.controller.MenuController.add()', NULL, '127.0.0.1', '2018-12-17 16:16:56');
INSERT INTO `sys_log` VALUES (693, 1, 'admin', '保存菜单', 31, 'top.cflwork.controller.MenuController.save()', NULL, '127.0.0.1', '2018-12-17 16:17:03');
INSERT INTO `sys_log` VALUES (694, 1, 'admin', '删除菜单', 64, 'top.cflwork.controller.MenuController.remove()', NULL, '127.0.0.1', '2018-12-17 16:17:08');
INSERT INTO `sys_log` VALUES (695, 1, 'admin', '删除菜单', 42, 'top.cflwork.controller.MenuController.remove()', NULL, '127.0.0.1', '2018-12-17 16:17:11');
INSERT INTO `sys_log` VALUES (696, 1, 'admin', '登录', 20, 'top.cflwork.controller.LoginController.ajaxLogin()', NULL, '127.0.0.1', '2018-12-17 16:34:06');
INSERT INTO `sys_log` VALUES (697, 1, 'admin', '请求访问主页', 192, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2018-12-17 16:34:06');
INSERT INTO `sys_log` VALUES (698, 1, 'admin', '登录', 43, 'top.cflwork.controller.LoginController.ajaxLogin()', NULL, '127.0.0.1', '2018-12-17 16:41:02');
INSERT INTO `sys_log` VALUES (699, 1, 'admin', '请求访问主页', 242, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2018-12-17 16:41:02');
INSERT INTO `sys_log` VALUES (700, 1, 'admin', '登录', 186, 'top.cflwork.controller.LoginController.ajaxLogin()', NULL, '127.0.0.1', '2018-12-17 16:52:38');
INSERT INTO `sys_log` VALUES (701, 1, 'admin', '请求访问主页', 674, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2018-12-17 16:52:39');
INSERT INTO `sys_log` VALUES (702, 1, 'admin', '登录', 14, 'top.cflwork.controller.LoginController.ajaxLogin()', NULL, '127.0.0.1', '2018-12-17 16:55:45');
INSERT INTO `sys_log` VALUES (703, 1, 'admin', '请求访问主页', 292, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2018-12-17 16:55:46');
INSERT INTO `sys_log` VALUES (704, 1, 'admin', 'error', NULL, 'http://localhost:8088/user/getInfo', 'org.springframework.web.HttpRequestMethodNotSupportedException: Request method \'POST\' not supported', NULL, '2018-12-17 16:55:46');
INSERT INTO `sys_log` VALUES (705, 1, 'admin', '登录', 15, 'top.cflwork.controller.LoginController.ajaxLogin()', NULL, '127.0.0.1', '2018-12-17 16:57:38');
INSERT INTO `sys_log` VALUES (706, 1, 'admin', '请求访问主页', 53, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2018-12-17 16:57:38');
INSERT INTO `sys_log` VALUES (707, 1, 'admin', '登录', 82, 'top.cflwork.controller.LoginController.ajaxLogin()', NULL, '127.0.0.1', '2018-12-24 18:36:07');
INSERT INTO `sys_log` VALUES (708, 1, 'admin', '请求访问主页', 223, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2018-12-24 18:36:07');
INSERT INTO `sys_log` VALUES (709, 1, 'admin', '请求访问主页', 8, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2018-12-24 18:36:20');
INSERT INTO `sys_log` VALUES (710, 1, 'admin', '登录', 863, 'top.cflwork.controller.LoginController.ajaxLogin()', NULL, '127.0.0.1', '2018-12-24 19:17:34');
INSERT INTO `sys_log` VALUES (711, 1, 'admin', '请求访问主页', 234, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2018-12-24 19:17:35');
INSERT INTO `sys_log` VALUES (712, 1, 'admin', '登录', 79, 'top.cflwork.controller.LoginController.ajaxLogin()', NULL, '127.0.0.1', '2019-01-03 12:26:18');
INSERT INTO `sys_log` VALUES (713, 1, 'admin', '请求访问主页', 193, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2019-01-03 12:26:18');
INSERT INTO `sys_log` VALUES (714, 1, 'admin', '登录', 63, 'top.cflwork.controller.LoginController.ajaxLogin()', NULL, '127.0.0.1', '2019-01-04 18:06:33');
INSERT INTO `sys_log` VALUES (715, 1, 'admin', '请求访问主页', 170, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2019-01-04 18:06:33');
INSERT INTO `sys_log` VALUES (716, 1, 'admin', '请求访问主页', 9, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2019-01-04 18:33:32');
INSERT INTO `sys_log` VALUES (717, 1, 'admin', '请求访问主页', 9, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2019-01-04 18:38:36');
INSERT INTO `sys_log` VALUES (718, 1, 'admin', '登录', 16, 'top.cflwork.controller.LoginController.ajaxLogin()', NULL, '127.0.0.1', '2019-01-04 18:38:59');
INSERT INTO `sys_log` VALUES (719, 1, 'admin', '请求访问主页', 50, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2019-01-04 18:38:59');
INSERT INTO `sys_log` VALUES (720, 1, 'admin', '请求访问主页', 8, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2019-01-04 18:41:03');
INSERT INTO `sys_log` VALUES (721, 1, 'admin', '请求访问主页', 8, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2019-01-04 18:46:02');
INSERT INTO `sys_log` VALUES (722, 1, 'admin', '请求访问主页', 10, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2019-01-04 19:20:40');
INSERT INTO `sys_log` VALUES (723, 1, 'admin', '登录', 15, 'top.cflwork.controller.LoginController.ajaxLogin()', NULL, '127.0.0.1', '2019-01-04 19:21:48');
INSERT INTO `sys_log` VALUES (724, 1, 'admin', '请求访问主页', 57, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2019-01-04 19:21:48');
INSERT INTO `sys_log` VALUES (725, 1, 'admin', 'error', NULL, 'http://localhost:8088/common/generator/code/sys_user', 'java.lang.NullPointerException: name', NULL, '2019-01-04 19:21:53');
INSERT INTO `sys_log` VALUES (726, 1, 'admin', 'error', NULL, 'http://localhost:8088/common/generator/code/sys_user', 'java.lang.NullPointerException: name', NULL, '2019-01-04 19:22:16');
INSERT INTO `sys_log` VALUES (727, 1, 'admin', '请求访问主页', 7, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2019-01-04 19:32:47');
INSERT INTO `sys_log` VALUES (728, 1, 'admin', '登录', 15, 'top.cflwork.controller.LoginController.ajaxLogin()', NULL, '127.0.0.1', '2019-01-04 19:33:57');
INSERT INTO `sys_log` VALUES (729, 1, 'admin', '请求访问主页', 57, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2019-01-04 19:33:58');
INSERT INTO `sys_log` VALUES (730, 1, 'admin', 'error', NULL, 'http://localhost:8088/common/generator/code/sys_user', 'java.lang.NullPointerException: name', NULL, '2019-01-04 19:34:02');
INSERT INTO `sys_log` VALUES (731, 1, 'admin', '登录', 15, 'top.cflwork.controller.LoginController.ajaxLogin()', NULL, '127.0.0.1', '2019-01-04 19:38:09');
INSERT INTO `sys_log` VALUES (732, 1, 'admin', '请求访问主页', 57, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2019-01-04 19:38:09');
INSERT INTO `sys_log` VALUES (733, 1, 'admin', '登录', 15, 'top.cflwork.controller.LoginController.ajaxLogin()', NULL, '127.0.0.1', '2019-01-04 19:40:47');
INSERT INTO `sys_log` VALUES (734, 1, 'admin', '请求访问主页', 55, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2019-01-04 19:40:47');
INSERT INTO `sys_log` VALUES (735, 1, 'admin', '登录', 16, 'top.cflwork.controller.LoginController.ajaxLogin()', NULL, '127.0.0.1', '2019-01-04 19:45:00');
INSERT INTO `sys_log` VALUES (736, 1, 'admin', '请求访问主页', 60, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2019-01-04 19:45:00');
INSERT INTO `sys_log` VALUES (737, 1, 'admin', '请求访问主页', 8, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2019-01-04 19:46:40');
INSERT INTO `sys_log` VALUES (738, 1, 'admin', '请求访问主页', 6, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2019-01-04 19:48:17');
INSERT INTO `sys_log` VALUES (739, 1, 'admin', '登录', 14, 'top.cflwork.controller.LoginController.ajaxLogin()', NULL, '127.0.0.1', '2019-01-04 19:53:01');
INSERT INTO `sys_log` VALUES (740, 1, 'admin', '请求访问主页', 61, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2019-01-04 19:53:01');
INSERT INTO `sys_log` VALUES (741, 1, 'admin', '请求访问主页', 8, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2019-01-04 19:54:29');
INSERT INTO `sys_log` VALUES (742, 1, 'admin', 'error', NULL, 'http://localhost:8088/user/list', 'org.springframework.web.HttpRequestMethodNotSupportedException: Request method \'POST\' not supported', NULL, '2019-01-04 19:54:31');
INSERT INTO `sys_log` VALUES (743, 1, 'admin', '登录', 121, 'top.cflwork.controller.LoginController.ajaxLogin()', NULL, '127.0.0.1', '2019-01-05 18:05:22');
INSERT INTO `sys_log` VALUES (744, 1, 'admin', '请求访问主页', 59, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2019-01-05 18:05:22');
INSERT INTO `sys_log` VALUES (745, 1, 'admin', '登录', 133, 'top.cflwork.controller.LoginController.ajaxLogin()', NULL, '127.0.0.1', '2019-01-05 18:08:08');
INSERT INTO `sys_log` VALUES (746, 1, 'admin', '请求访问主页', 66, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2019-01-05 18:08:09');
INSERT INTO `sys_log` VALUES (747, 1, 'admin', '删除菜单', 117, 'top.cflwork.controller.MenuController.remove()', NULL, '127.0.0.1', '2019-01-05 18:08:46');
INSERT INTO `sys_log` VALUES (748, 1, 'admin', '删除菜单', 45, 'top.cflwork.controller.MenuController.remove()', NULL, '127.0.0.1', '2019-01-05 18:08:51');
INSERT INTO `sys_log` VALUES (749, 1, 'admin', '删除菜单', 91, 'top.cflwork.controller.MenuController.remove()', NULL, '127.0.0.1', '2019-01-05 18:09:00');
INSERT INTO `sys_log` VALUES (750, 1, 'admin', '删除菜单', 45, 'top.cflwork.controller.MenuController.remove()', NULL, '127.0.0.1', '2019-01-05 18:09:02');
INSERT INTO `sys_log` VALUES (751, 1, 'admin', '删除菜单', 42, 'top.cflwork.controller.MenuController.remove()', NULL, '127.0.0.1', '2019-01-05 18:09:04');
INSERT INTO `sys_log` VALUES (752, 1, 'admin', '删除菜单', 35, 'top.cflwork.controller.MenuController.remove()', NULL, '127.0.0.1', '2019-01-05 18:09:06');
INSERT INTO `sys_log` VALUES (753, 1, 'admin', '删除菜单', 49, 'top.cflwork.controller.MenuController.remove()', NULL, '127.0.0.1', '2019-01-05 18:09:08');
INSERT INTO `sys_log` VALUES (754, 1, 'admin', '删除菜单', 32, 'top.cflwork.controller.MenuController.remove()', NULL, '127.0.0.1', '2019-01-05 18:09:10');
INSERT INTO `sys_log` VALUES (755, 1, 'admin', '删除菜单', 46, 'top.cflwork.controller.MenuController.remove()', NULL, '127.0.0.1', '2019-01-05 18:09:15');
INSERT INTO `sys_log` VALUES (756, 1, 'admin', '删除菜单', 43, 'top.cflwork.controller.MenuController.remove()', NULL, '127.0.0.1', '2019-01-05 18:09:18');
INSERT INTO `sys_log` VALUES (757, 1, 'admin', '删除菜单', 26, 'top.cflwork.controller.MenuController.remove()', NULL, '127.0.0.1', '2019-01-05 18:09:21');
INSERT INTO `sys_log` VALUES (758, 1, 'admin', '删除菜单', 41, 'top.cflwork.controller.MenuController.remove()', NULL, '127.0.0.1', '2019-01-05 18:09:25');
INSERT INTO `sys_log` VALUES (759, 1, 'admin', '删除菜单', 41, 'top.cflwork.controller.MenuController.remove()', NULL, '127.0.0.1', '2019-01-05 18:09:29');
INSERT INTO `sys_log` VALUES (760, 1, 'admin', '删除菜单', 42, 'top.cflwork.controller.MenuController.remove()', NULL, '127.0.0.1', '2019-01-05 18:09:31');
INSERT INTO `sys_log` VALUES (761, 1, 'admin', '删除菜单', 52, 'top.cflwork.controller.MenuController.remove()', NULL, '127.0.0.1', '2019-01-05 18:09:33');
INSERT INTO `sys_log` VALUES (762, 1, 'admin', '删除菜单', 44, 'top.cflwork.controller.MenuController.remove()', NULL, '127.0.0.1', '2019-01-05 18:09:35');
INSERT INTO `sys_log` VALUES (763, 1, 'admin', '删除菜单', 45, 'top.cflwork.controller.MenuController.remove()', NULL, '127.0.0.1', '2019-01-05 18:09:37');
INSERT INTO `sys_log` VALUES (764, 1, 'admin', '删除菜单', 39, 'top.cflwork.controller.MenuController.remove()', NULL, '127.0.0.1', '2019-01-05 18:09:40');
INSERT INTO `sys_log` VALUES (765, 1, 'admin', '删除菜单', 42, 'top.cflwork.controller.MenuController.remove()', NULL, '127.0.0.1', '2019-01-05 18:09:42');
INSERT INTO `sys_log` VALUES (766, 1, 'admin', '删除菜单', 42, 'top.cflwork.controller.MenuController.remove()', NULL, '127.0.0.1', '2019-01-05 18:09:44');
INSERT INTO `sys_log` VALUES (767, 1, 'admin', '删除菜单', 101, 'top.cflwork.controller.MenuController.remove()', NULL, '127.0.0.1', '2019-01-05 18:09:49');
INSERT INTO `sys_log` VALUES (768, 1, 'admin', '删除菜单', 58, 'top.cflwork.controller.MenuController.remove()', NULL, '127.0.0.1', '2019-01-05 18:09:52');
INSERT INTO `sys_log` VALUES (769, 1, 'admin', '删除菜单', 43, 'top.cflwork.controller.MenuController.remove()', NULL, '127.0.0.1', '2019-01-05 18:09:54');
INSERT INTO `sys_log` VALUES (770, 1, 'admin', '请求访问主页', 4, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2019-01-05 18:10:07');
INSERT INTO `sys_log` VALUES (771, 1, 'admin', '添加菜单', 3, 'top.cflwork.controller.MenuController.add()', NULL, '127.0.0.1', '2019-01-05 18:11:42');
INSERT INTO `sys_log` VALUES (772, 1, 'admin', '保存菜单', 39, 'top.cflwork.controller.MenuController.save()', NULL, '127.0.0.1', '2019-01-05 18:12:03');
INSERT INTO `sys_log` VALUES (773, 1, 'admin', '编辑角色', 4, 'top.cflwork.controller.RoleController.edit()', NULL, '127.0.0.1', '2019-01-05 18:12:07');
INSERT INTO `sys_log` VALUES (774, 1, 'admin', '更新角色', 100, 'top.cflwork.controller.RoleController.update()', NULL, '127.0.0.1', '2019-01-05 18:12:14');
INSERT INTO `sys_log` VALUES (775, 1, 'admin', '登录', 2, 'top.cflwork.controller.LoginController.ajaxLogin()', NULL, '127.0.0.1', '2019-01-05 18:12:17');
INSERT INTO `sys_log` VALUES (776, 1, 'admin', '请求访问主页', 4, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2019-01-05 18:12:17');
INSERT INTO `sys_log` VALUES (777, 1, 'admin', '登录', 121, 'top.cflwork.controller.LoginController.ajaxLogin()', NULL, '127.0.0.1', '2019-01-05 18:36:42');
INSERT INTO `sys_log` VALUES (778, 1, 'admin', '请求访问主页', 57, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2019-01-05 18:36:42');
INSERT INTO `sys_log` VALUES (779, 1, 'admin', 'error', NULL, 'http://localhost:8088/oa/notify/message', 'java.lang.NullPointerException', NULL, '2019-01-05 18:36:42');
INSERT INTO `sys_log` VALUES (780, 1, 'admin', '请求访问主页', 5, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2019-01-05 18:38:25');
INSERT INTO `sys_log` VALUES (781, 1, 'admin', 'error', NULL, 'http://localhost:8088/oa/notify/message', 'java.lang.NullPointerException', NULL, '2019-01-05 18:38:25');
INSERT INTO `sys_log` VALUES (782, 1, 'admin', '编辑角色', 3, 'top.cflwork.controller.RoleController.edit()', NULL, '127.0.0.1', '2019-01-05 18:38:38');
INSERT INTO `sys_log` VALUES (783, 1, 'admin', '更新角色', 113, 'top.cflwork.controller.RoleController.update()', NULL, '127.0.0.1', '2019-01-05 18:38:42');
INSERT INTO `sys_log` VALUES (784, 1, 'admin', '请求访问主页', 4, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2019-01-05 18:38:43');
INSERT INTO `sys_log` VALUES (785, 1, 'admin', 'error', NULL, 'http://localhost:8088/oa/notify/message', 'java.lang.NullPointerException', NULL, '2019-01-05 18:38:43');
INSERT INTO `sys_log` VALUES (786, 1, 'admin', 'error', NULL, 'http://localhost:8088/oa/notify/selfList', 'java.lang.NullPointerException', NULL, '2019-01-05 18:38:45');
INSERT INTO `sys_log` VALUES (787, 1, 'admin', 'error', NULL, 'http://localhost:8088/oa/notify/list', 'java.lang.NullPointerException', NULL, '2019-01-05 18:38:48');
INSERT INTO `sys_log` VALUES (788, 1, 'admin', '请求访问主页', 5, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2019-01-05 18:39:26');
INSERT INTO `sys_log` VALUES (789, 1, 'admin', 'error', NULL, 'http://localhost:8088/oa/notify/message', 'java.lang.NullPointerException', NULL, '2019-01-05 18:39:26');
INSERT INTO `sys_log` VALUES (790, 1, 'admin', 'error', NULL, 'http://localhost:8088/oa/notify/selfList', 'java.lang.NullPointerException', NULL, '2019-01-05 18:39:28');
INSERT INTO `sys_log` VALUES (791, 1, 'admin', '登录', 132, 'top.cflwork.controller.LoginController.ajaxLogin()', NULL, '127.0.0.1', '2019-01-05 18:41:46');
INSERT INTO `sys_log` VALUES (792, 1, 'admin', '请求访问主页', 63, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2019-01-05 18:41:46');
INSERT INTO `sys_log` VALUES (793, 1, 'admin', 'error', NULL, 'http://localhost:8088/oa/notify/message', 'java.lang.NullPointerException', NULL, '2019-01-05 18:41:46');
INSERT INTO `sys_log` VALUES (794, 1, 'admin', 'error', NULL, 'http://localhost:8088/oa/notify/selfList', 'java.lang.NullPointerException', NULL, '2019-01-05 18:41:51');
INSERT INTO `sys_log` VALUES (795, 1, 'admin', 'error', NULL, 'http://localhost:8088/oa/notify/list', 'java.lang.NullPointerException', NULL, '2019-01-05 18:41:53');
INSERT INTO `sys_log` VALUES (796, 1, 'admin', 'error', NULL, 'http://localhost:8088/oa/notify/list', 'java.lang.NullPointerException', NULL, '2019-01-05 18:41:59');
INSERT INTO `sys_log` VALUES (797, 1, 'admin', '登录', 5, 'top.cflwork.controller.LoginController.ajaxLogin()', NULL, '127.0.0.1', '2019-01-05 18:42:52');
INSERT INTO `sys_log` VALUES (798, 1, 'admin', '请求访问主页', 6, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2019-01-05 18:42:52');
INSERT INTO `sys_log` VALUES (799, 1, 'admin', 'error', NULL, 'http://localhost:8088/oa/notify/message', 'java.lang.NullPointerException', NULL, '2019-01-05 18:42:52');
INSERT INTO `sys_log` VALUES (800, 1, 'admin', 'error', NULL, 'http://localhost:8088/oa/notify/selfList', 'java.lang.NullPointerException', NULL, '2019-01-05 18:42:55');
INSERT INTO `sys_log` VALUES (801, 1, 'admin', 'error', NULL, 'http://localhost:8088/oa/notify/list', 'java.lang.NullPointerException', NULL, '2019-01-05 18:42:56');
INSERT INTO `sys_log` VALUES (802, 1, 'admin', 'error', NULL, 'http://localhost:8088/oa/notify/list', 'java.lang.NullPointerException', NULL, '2019-01-05 18:43:04');
INSERT INTO `sys_log` VALUES (803, 1, 'admin', '登录', 125, 'top.cflwork.controller.LoginController.ajaxLogin()', NULL, '127.0.0.1', '2019-01-05 18:43:56');
INSERT INTO `sys_log` VALUES (804, 1, 'admin', '请求访问主页', 62, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2019-01-05 18:43:56');
INSERT INTO `sys_log` VALUES (805, 1, 'admin', 'error', NULL, 'http://localhost:8088/oa/notify/message', 'java.lang.NullPointerException', NULL, '2019-01-05 18:43:57');
INSERT INTO `sys_log` VALUES (806, 1, 'admin', '登录', 139, 'top.cflwork.controller.LoginController.ajaxLogin()', NULL, '127.0.0.1', '2019-01-05 18:47:09');
INSERT INTO `sys_log` VALUES (807, 1, 'admin', '请求访问主页', 72, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2019-01-05 18:47:09');
INSERT INTO `sys_log` VALUES (808, 1, 'admin', 'error', NULL, 'http://localhost:8088/oa/notify/message', 'java.lang.NullPointerException', NULL, '2019-01-05 18:47:10');
INSERT INTO `sys_log` VALUES (809, 1, 'admin', '登录', 135, 'top.cflwork.controller.LoginController.ajaxLogin()', NULL, '127.0.0.1', '2019-01-05 18:48:50');
INSERT INTO `sys_log` VALUES (810, 1, 'admin', '请求访问主页', 68, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2019-01-05 18:48:50');
INSERT INTO `sys_log` VALUES (811, 1, 'admin', 'error', NULL, 'http://localhost:8088/oa/notify/message', 'java.lang.NullPointerException', NULL, '2019-01-05 18:48:50');
INSERT INTO `sys_log` VALUES (812, 1, 'admin', '登录', 4, 'top.cflwork.controller.LoginController.ajaxLogin()', NULL, '127.0.0.1', '2019-01-05 18:49:22');
INSERT INTO `sys_log` VALUES (813, 1, 'admin', '请求访问主页', 5, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2019-01-05 18:49:22');
INSERT INTO `sys_log` VALUES (814, 1, 'admin', 'error', NULL, 'http://localhost:8088/oa/notify/message', 'java.lang.NullPointerException', NULL, '2019-01-05 18:49:22');
INSERT INTO `sys_log` VALUES (815, 1, 'admin', 'error', NULL, 'http://localhost:8088/oa/notify/message', 'java.lang.NullPointerException', NULL, '2019-01-05 18:49:49');
INSERT INTO `sys_log` VALUES (816, 1, 'admin', 'error', NULL, 'http://localhost:8088/oa/notify/message', 'java.lang.NullPointerException', NULL, '2019-01-05 18:49:50');
INSERT INTO `sys_log` VALUES (817, 1, 'admin', '编辑菜单', 3, 'top.cflwork.controller.MenuController.edit()', NULL, '127.0.0.1', '2019-01-05 18:50:26');
INSERT INTO `sys_log` VALUES (818, 1, 'admin', '更新菜单', 63, 'top.cflwork.controller.MenuController.update()', NULL, '127.0.0.1', '2019-01-05 18:50:32');
INSERT INTO `sys_log` VALUES (819, 1, 'admin', '请求访问主页', 4, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2019-01-05 18:50:34');
INSERT INTO `sys_log` VALUES (820, 1, 'admin', 'error', NULL, 'http://localhost:8088/oa/notify/message', 'java.lang.NullPointerException', NULL, '2019-01-05 18:50:35');
INSERT INTO `sys_log` VALUES (821, 1, 'admin', '请求访问主页', 5, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2019-01-05 18:51:31');
INSERT INTO `sys_log` VALUES (822, 1, 'admin', 'error', NULL, 'http://localhost:8088/oa/notify/message', 'java.lang.NullPointerException', NULL, '2019-01-05 18:51:31');
INSERT INTO `sys_log` VALUES (823, 1, 'admin', '请求访问主页', 4, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2019-01-05 18:52:34');
INSERT INTO `sys_log` VALUES (824, 1, 'admin', 'error', NULL, 'http://localhost:8088/oa/notify/message', 'java.lang.NullPointerException', NULL, '2019-01-05 18:52:34');
INSERT INTO `sys_log` VALUES (825, 1, 'admin', '请求访问主页', 5, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2019-01-05 18:53:45');
INSERT INTO `sys_log` VALUES (826, 1, 'admin', 'error', NULL, 'http://localhost:8088/oa/notify/message', 'java.lang.NullPointerException', NULL, '2019-01-05 18:53:45');
INSERT INTO `sys_log` VALUES (827, 1, 'admin', '请求访问主页', 4, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2019-01-05 18:53:58');
INSERT INTO `sys_log` VALUES (828, 1, 'admin', 'error', NULL, 'http://localhost:8088/oa/notify/message', 'java.lang.NullPointerException', NULL, '2019-01-05 18:53:58');
INSERT INTO `sys_log` VALUES (829, 1, 'admin', '请求访问主页', 3, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2019-01-05 18:54:31');
INSERT INTO `sys_log` VALUES (830, 1, 'admin', 'error', NULL, 'http://localhost:8088/oa/notify/message', 'java.lang.NullPointerException', NULL, '2019-01-05 18:54:31');
INSERT INTO `sys_log` VALUES (831, 1, 'admin', '登录', 122, 'top.cflwork.controller.LoginController.ajaxLogin()', NULL, '127.0.0.1', '2019-01-05 18:58:07');
INSERT INTO `sys_log` VALUES (832, 1, 'admin', '请求访问主页', 58, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2019-01-05 18:58:07');
INSERT INTO `sys_log` VALUES (833, 1, 'admin', 'error', NULL, 'http://localhost:8088/oa/notify/message', 'java.lang.NullPointerException', NULL, '2019-01-05 18:58:07');
INSERT INTO `sys_log` VALUES (834, 1, 'admin', '请求访问主页', 5, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2019-01-05 18:58:43');
INSERT INTO `sys_log` VALUES (835, 1, 'admin', 'error', NULL, 'http://localhost:8088/oa/notify/message', 'java.lang.NullPointerException', NULL, '2019-01-05 18:58:43');
INSERT INTO `sys_log` VALUES (836, 1, 'admin', '请求访问主页', 5, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2019-01-05 19:02:49');
INSERT INTO `sys_log` VALUES (837, 1, 'admin', 'error', NULL, 'http://localhost:8088/oa/notify/message', 'java.lang.NullPointerException', NULL, '2019-01-05 19:02:49');
INSERT INTO `sys_log` VALUES (838, 1, 'admin', '登录', 122, 'top.cflwork.controller.LoginController.ajaxLogin()', NULL, '127.0.0.1', '2019-01-05 19:04:06');
INSERT INTO `sys_log` VALUES (839, 1, 'admin', '请求访问主页', 59, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2019-01-05 19:04:07');
INSERT INTO `sys_log` VALUES (840, 1, 'admin', 'error', NULL, 'http://localhost:8088/oa/notify/message', 'java.lang.NullPointerException', NULL, '2019-01-05 19:04:07');
INSERT INTO `sys_log` VALUES (841, 1, 'admin', '登录', 7, 'top.cflwork.controller.LoginController.ajaxLogin()', NULL, '127.0.0.1', '2019-01-05 19:17:03');
INSERT INTO `sys_log` VALUES (842, 1, 'admin', '请求访问主页', 7, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2019-01-05 19:17:03');
INSERT INTO `sys_log` VALUES (843, 1, 'admin', 'error', NULL, 'http://localhost:8088/oa/notify/message', 'java.lang.NullPointerException', NULL, '2019-01-05 19:17:03');
INSERT INTO `sys_log` VALUES (844, 1, 'admin', '编辑角色', 3, 'top.cflwork.controller.RoleController.edit()', NULL, '127.0.0.1', '2019-01-05 19:17:18');
INSERT INTO `sys_log` VALUES (845, 1, 'admin', '更新角色', 134, 'top.cflwork.controller.RoleController.update()', NULL, '127.0.0.1', '2019-01-05 19:17:25');
INSERT INTO `sys_log` VALUES (846, 1, 'admin', '请求访问主页', 4, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2019-01-05 19:17:55');
INSERT INTO `sys_log` VALUES (847, 1, 'admin', 'error', NULL, 'http://localhost:8088/oa/notify/message', 'java.lang.NullPointerException', NULL, '2019-01-05 19:17:55');
INSERT INTO `sys_log` VALUES (848, 1, 'admin', '登录', 3, 'top.cflwork.controller.LoginController.ajaxLogin()', NULL, '127.0.0.1', '2019-01-05 19:18:33');
INSERT INTO `sys_log` VALUES (849, 1, 'admin', '请求访问主页', 4, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2019-01-05 19:18:33');
INSERT INTO `sys_log` VALUES (850, 1, 'admin', 'error', NULL, 'http://localhost:8088/oa/notify/message', 'java.lang.NullPointerException', NULL, '2019-01-05 19:18:33');
INSERT INTO `sys_log` VALUES (851, 1, 'admin', '请求访问主页', 4, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2019-01-05 19:19:06');
INSERT INTO `sys_log` VALUES (852, 1, 'admin', 'error', NULL, 'http://localhost:8088/oa/notify/message', 'java.lang.NullPointerException', NULL, '2019-01-05 19:19:06');
INSERT INTO `sys_log` VALUES (853, 1, 'admin', '编辑角色', 1, 'top.cflwork.controller.RoleController.edit()', NULL, '127.0.0.1', '2019-01-05 19:19:25');
INSERT INTO `sys_log` VALUES (854, 1, 'admin', '登录', 2, 'top.cflwork.controller.LoginController.ajaxLogin()', NULL, '127.0.0.1', '2019-01-05 19:19:58');
INSERT INTO `sys_log` VALUES (855, 1, 'admin', '请求访问主页', 5, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2019-01-05 19:19:58');
INSERT INTO `sys_log` VALUES (856, 1, 'admin', 'error', NULL, 'http://localhost:8088/oa/notify/message', 'java.lang.NullPointerException', NULL, '2019-01-05 19:19:58');
INSERT INTO `sys_log` VALUES (857, 1, 'admin', '请求访问主页', 4, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2019-01-05 19:20:28');
INSERT INTO `sys_log` VALUES (858, 1, 'admin', 'error', NULL, 'http://localhost:8088/oa/notify/message', 'java.lang.NullPointerException', NULL, '2019-01-05 19:20:28');
INSERT INTO `sys_log` VALUES (859, 1, 'admin', '登录', 2, 'top.cflwork.controller.LoginController.ajaxLogin()', NULL, '127.0.0.1', '2019-01-05 19:20:49');
INSERT INTO `sys_log` VALUES (860, 1, 'admin', '请求访问主页', 4, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2019-01-05 19:20:49');
INSERT INTO `sys_log` VALUES (861, 1, 'admin', 'error', NULL, 'http://localhost:8088/oa/notify/message', 'java.lang.NullPointerException', NULL, '2019-01-05 19:20:49');
INSERT INTO `sys_log` VALUES (862, 1, 'admin', '请求访问主页', 5, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2019-01-05 19:21:37');
INSERT INTO `sys_log` VALUES (863, 1, 'admin', 'error', NULL, 'http://localhost:8088/oa/notify/message', 'java.lang.NullPointerException', NULL, '2019-01-05 19:21:38');
INSERT INTO `sys_log` VALUES (864, 1, 'admin', '登录', 4, 'top.cflwork.controller.LoginController.ajaxLogin()', NULL, '127.0.0.1', '2019-01-05 19:21:39');
INSERT INTO `sys_log` VALUES (865, 1, 'admin', '请求访问主页', 4, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2019-01-05 19:21:39');
INSERT INTO `sys_log` VALUES (866, 1, 'admin', 'error', NULL, 'http://localhost:8088/oa/notify/message', 'java.lang.NullPointerException', NULL, '2019-01-05 19:21:40');
INSERT INTO `sys_log` VALUES (867, 1, 'admin', '登录', 143, 'top.cflwork.controller.LoginController.ajaxLogin()', NULL, '127.0.0.1', '2019-01-05 19:22:03');
INSERT INTO `sys_log` VALUES (868, 1, 'admin', '请求访问主页', 59, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2019-01-05 19:22:03');
INSERT INTO `sys_log` VALUES (869, 1, 'admin', 'error', NULL, 'http://localhost:8088/oa/notify/message', 'java.lang.NullPointerException', NULL, '2019-01-05 19:22:03');
INSERT INTO `sys_log` VALUES (870, 1, 'admin', '编辑角色', 4, 'top.cflwork.controller.RoleController.edit()', NULL, '127.0.0.1', '2019-01-05 19:22:48');
INSERT INTO `sys_log` VALUES (871, 1, 'admin', '请求访问主页', 5, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2019-01-05 19:23:32');
INSERT INTO `sys_log` VALUES (872, 1, 'admin', 'error', NULL, 'http://localhost:8088/oa/notify/message', 'java.lang.NullPointerException', NULL, '2019-01-05 19:23:32');
INSERT INTO `sys_log` VALUES (873, 1, 'admin', '登录', 177, 'top.cflwork.controller.LoginController.ajaxLogin()', NULL, '127.0.0.1', '2019-01-05 19:34:40');
INSERT INTO `sys_log` VALUES (874, 1, 'admin', '请求访问主页', 70, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2019-01-05 19:34:40');
INSERT INTO `sys_log` VALUES (875, 1, 'admin', '登录', 124, 'top.cflwork.controller.LoginController.ajaxLogin()', NULL, '127.0.0.1', '2019-01-05 19:35:31');
INSERT INTO `sys_log` VALUES (876, 1, 'admin', '请求访问主页', 60, 'top.cflwork.controller.LoginController.index()', NULL, '127.0.0.1', '2019-01-05 19:35:31');
INSERT INTO `sys_log` VALUES (877, 1, 'admin', 'error', NULL, 'http://localhost:8088/oa/notify/message', 'java.lang.NullPointerException', NULL, '2019-01-05 19:35:31');
INSERT INTO `sys_log` VALUES (878, 1, 'admin', '登录', 125, 'top.cflwork.controller.LoginController.ajaxLogin()', '\"admin\"', '127.0.0.1', '2019-01-05 19:36:23');
INSERT INTO `sys_log` VALUES (879, 1, 'admin', '请求访问主页', 59, 'top.cflwork.controller.LoginController.index()', '{\"headIcon\":\"http://pjo4e6qjr.bkt.clouddn.com/upload/faceImg/2018/1224/f0a733a382b84db1.jpg\"}', '127.0.0.1', '2019-01-05 19:36:23');
INSERT INTO `sys_log` VALUES (880, 1, 'admin', 'error', NULL, 'http://localhost:8088/oa/notify/message', 'java.lang.NullPointerException', NULL, '2019-01-05 19:36:23');
INSERT INTO `sys_log` VALUES (881, 1, 'admin', '登录', 126, 'top.cflwork.controller.LoginController.ajaxLogin()', '[\"admin\",\"111111\"]', '127.0.0.1', '2019-01-05 19:37:13');
INSERT INTO `sys_log` VALUES (882, 1, 'admin', '请求访问主页', 61, 'top.cflwork.controller.LoginController.index()', '[{\"headIcon\":\"http://pjo4e6qjr.bkt.clouddn.com/upload/faceImg/2018/1224/f0a733a382b84db1.jpg\"}]', '127.0.0.1', '2019-01-05 19:37:13');
INSERT INTO `sys_log` VALUES (883, 1, 'admin', 'error', NULL, 'http://localhost:8088/oa/notify/message', 'java.lang.NullPointerException', NULL, '2019-01-05 19:37:13');
INSERT INTO `sys_log` VALUES (884, 1, 'admin', '登录', 166, 'top.cflwork.controller.LoginController.ajaxLogin()', '[\"admin\",\"111111\"]', '127.0.0.1', '2019-01-05 19:39:34');
INSERT INTO `sys_log` VALUES (885, 1, 'admin', '登录', 128, 'top.cflwork.controller.LoginController.ajaxLogin()', '[\"admin\",\"111111\"]', '127.0.0.1', '2019-01-05 19:40:08');
INSERT INTO `sys_log` VALUES (886, 1, 'admin', '请求访问主页', 63, 'top.cflwork.controller.LoginController.index()', '[{\"headIcon\":\"http://pjo4e6qjr.bkt.clouddn.com/upload/faceImg/2018/1224/f0a733a382b84db1.jpg\"}]', '127.0.0.1', '2019-01-05 19:40:08');
INSERT INTO `sys_log` VALUES (887, 1, 'admin', 'error', NULL, 'http://localhost:8088/oa/notify/message', 'java.lang.NullPointerException', NULL, '2019-01-05 19:40:08');
INSERT INTO `sys_log` VALUES (888, 1, 'admin', '登录', 126, 'top.cflwork.controller.LoginController.ajaxLogin()', '[\"admin\",\"111111\"]', '127.0.0.1', '2019-01-05 19:41:27');
INSERT INTO `sys_log` VALUES (889, 1, 'admin', '请求访问主页', 58, 'top.cflwork.controller.LoginController.index()', '[{\"headIcon\":\"http://pjo4e6qjr.bkt.clouddn.com/upload/faceImg/2018/1224/f0a733a382b84db1.jpg\"}]', '127.0.0.1', '2019-01-05 19:41:28');
INSERT INTO `sys_log` VALUES (890, 1, 'admin', '请求访问主页', 5, 'top.cflwork.controller.LoginController.index()', '[{\"headIcon\":\"http://pjo4e6qjr.bkt.clouddn.com/upload/faceImg/2018/1224/f0a733a382b84db1.jpg\"}]', '127.0.0.1', '2019-01-05 19:44:27');

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu`  (
  `menu_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `parent_id` bigint(20) NULL DEFAULT NULL COMMENT '父菜单ID，一级菜单为0',
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '菜单名称',
  `url` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '菜单URL',
  `perms` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '授权(多个用逗号分隔，如：user:list,user:create)',
  `type` int(11) NULL DEFAULT NULL COMMENT '类型   0：目录   1：菜单   2：按钮',
  `icon` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '菜单图标',
  `order_num` int(11) NULL DEFAULT NULL COMMENT '排序',
  `gmt_create` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `gmt_modified` datetime NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`menu_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 110 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '菜单管理' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES (1, 0, '基础管理', '', '', 0, 'fa fa-toggle-right', 6, '2017-08-09 22:49:47', NULL);
INSERT INTO `sys_menu` VALUES (2, 3, '系统菜单', '/menu/menuPage/', 'menu:menu', 1, 'fa fa-th-list', 2, '2017-08-09 22:55:15', NULL);
INSERT INTO `sys_menu` VALUES (3, 0, '系统管理', '', '', 0, 'fa fa-desktop', 2, '2017-08-09 23:06:55', '2017-08-14 14:13:43');
INSERT INTO `sys_menu` VALUES (6, 3, '用户管理', '/user/userPage/', 'user:userPage', 1, 'fa fa-user', 0, '2017-08-10 14:12:11', NULL);
INSERT INTO `sys_menu` VALUES (7, 3, '角色管理', '/role/rolePage/', 'role:role', 1, 'fa fa-paw', 1, '2017-08-10 14:13:19', NULL);
INSERT INTO `sys_menu` VALUES (12, 6, '新增', '', 'user:add', 2, '', 0, '2017-08-14 10:51:35', NULL);
INSERT INTO `sys_menu` VALUES (13, 6, '编辑', '', 'user:edit', 2, '', 0, '2017-08-14 10:52:06', NULL);
INSERT INTO `sys_menu` VALUES (14, 6, '删除', NULL, 'user:remove', 2, NULL, 0, '2017-08-14 10:52:24', NULL);
INSERT INTO `sys_menu` VALUES (15, 7, '新增', '', 'role:add', 2, '', 0, '2017-08-14 10:56:37', NULL);
INSERT INTO `sys_menu` VALUES (20, 2, '新增', '', 'menu:add', 2, '', 0, '2017-08-14 10:59:32', NULL);
INSERT INTO `sys_menu` VALUES (21, 2, '编辑', '', 'menu:edit', 2, '', 0, '2017-08-14 10:59:56', NULL);
INSERT INTO `sys_menu` VALUES (22, 2, '删除', '', 'menu:remove', 2, '', 0, '2017-08-14 11:00:26', NULL);
INSERT INTO `sys_menu` VALUES (24, 6, '批量删除', '', 'user:batchRemove', 2, '', 0, '2017-08-14 17:27:18', NULL);
INSERT INTO `sys_menu` VALUES (25, 6, '停用', NULL, 'user:disable', 2, NULL, 0, '2017-08-14 17:27:43', NULL);
INSERT INTO `sys_menu` VALUES (26, 6, '重置密码', '', 'user:resetPwd', 2, '', 0, '2017-08-14 17:28:34', NULL);
INSERT INTO `sys_menu` VALUES (27, 91, '系统日志', '/log/logPage', 'log:logPage', 1, 'fa fa-warning', 0, '2017-08-14 22:11:53', NULL);
INSERT INTO `sys_menu` VALUES (28, 27, '刷新', NULL, 'sys:log:list', 2, NULL, 0, '2017-08-14 22:30:22', NULL);
INSERT INTO `sys_menu` VALUES (29, 27, '删除', NULL, 'sys:log:remove', 2, NULL, 0, '2017-08-14 22:30:43', NULL);
INSERT INTO `sys_menu` VALUES (30, 27, '清空', NULL, 'sys:log:clear', 2, NULL, 0, '2017-08-14 22:31:02', NULL);
INSERT INTO `sys_menu` VALUES (48, 77, '代码生成', '/generator/generatorPage', 'generator:generatorPage', 1, 'fa fa-code', 3, NULL, NULL);
INSERT INTO `sys_menu` VALUES (55, 7, '编辑', '', 'role:edit', 2, '', NULL, NULL, NULL);
INSERT INTO `sys_menu` VALUES (56, 7, '删除', '', 'role:remove', 2, NULL, NULL, NULL, NULL);
INSERT INTO `sys_menu` VALUES (57, 91, '运行监控', '/druid/index.html', '', 1, 'fa fa-caret-square-o-right', 1, NULL, NULL);
INSERT INTO `sys_menu` VALUES (61, 2, '批量删除', '', 'menu:batchRemove', 2, NULL, NULL, NULL, NULL);
INSERT INTO `sys_menu` VALUES (62, 7, '批量删除', '', 'role:batchRemove', 2, NULL, NULL, NULL, NULL);
INSERT INTO `sys_menu` VALUES (71, 1, '文件管理', '/sysFile/sysFilePage', 'sysFile:list', 1, 'fa fa-folder-open', 2, NULL, NULL);
INSERT INTO `sys_menu` VALUES (73, 3, '部门管理', '/sysDept/sysDeptPage', 'sysDept:sysDeptPage', 1, 'fa fa-users', 3, NULL, NULL);
INSERT INTO `sys_menu` VALUES (74, 73, '增加', '/sysDept/add', 'sysDept:add', 2, NULL, 1, NULL, NULL);
INSERT INTO `sys_menu` VALUES (75, 73, '刪除', '/sysDept/remove', 'sysDept:remove', 2, NULL, 2, NULL, NULL);
INSERT INTO `sys_menu` VALUES (76, 73, '编辑', '/sysDept/edit', 'sysDept:edit', 2, NULL, 3, NULL, NULL);
INSERT INTO `sys_menu` VALUES (77, 0, '系统工具', '', '', 0, 'fa fa-gear', 4, NULL, NULL);
INSERT INTO `sys_menu` VALUES (78, 1, '数据字典', '/dict/dictPage', 'dict:dictPage', 1, 'fa fa-book', 1, NULL, NULL);
INSERT INTO `sys_menu` VALUES (79, 78, '增加', '/dict/add', 'dict:add', 2, 'fa fa-times-rectangle', 2, NULL, NULL);
INSERT INTO `sys_menu` VALUES (80, 78, '编辑', '/dict/edit', 'dict:edit', 2, NULL, 2, NULL, NULL);
INSERT INTO `sys_menu` VALUES (81, 78, '删除', '/dict/remove', 'dict:remove', 2, '', 3, NULL, NULL);
INSERT INTO `sys_menu` VALUES (83, 78, '批量删除', '/dict/batchRemove', 'dict:batchRemove', 2, '', 4, NULL, NULL);
INSERT INTO `sys_menu` VALUES (84, 0, '消息管理', '', '', 0, 'fa fa-laptop', 5, NULL, NULL);
INSERT INTO `sys_menu` VALUES (85, 84, '通知公告', 'oa/notify', 'oa:notify:notify', 1, 'fa fa-pencil-square', NULL, NULL, NULL);
INSERT INTO `sys_menu` VALUES (86, 85, '新增', 'oa/notify/add', 'oa:notify:add', 2, 'fa fa-plus', 1, NULL, NULL);
INSERT INTO `sys_menu` VALUES (87, 85, '编辑', 'oa/notify/edit', 'oa:notify:edit', 2, 'fa fa-pencil-square-o', 2, NULL, NULL);
INSERT INTO `sys_menu` VALUES (88, 85, '删除', 'oa/notify/remove', 'oa:notify:remove', 2, 'fa fa-minus', NULL, NULL, NULL);
INSERT INTO `sys_menu` VALUES (89, 85, '批量删除', 'oa/notify/batchRemove', 'oa:notify:batchRemove', 2, '', NULL, NULL, NULL);
INSERT INTO `sys_menu` VALUES (90, 84, '我的通知', 'oa/notify/selfNotify', '', 1, 'fa fa-envelope-square', NULL, NULL, NULL);
INSERT INTO `sys_menu` VALUES (91, 0, '系统监控', '', '', 0, 'fa fa-video-camera', 5, NULL, NULL);
INSERT INTO `sys_menu` VALUES (92, 91, '在线用户', '/online/onlinePage', '', 1, 'fa fa-user', NULL, NULL, NULL);
INSERT INTO `sys_menu` VALUES (109, 78, '查询列表', '/dict/list', 'dict:list', 2, '', NULL, NULL, NULL);

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role`  (
  `role_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色名称',
  `role_sign` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色标识',
  `remark` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  `user_id_create` bigint(255) NULL DEFAULT NULL COMMENT '创建用户id',
  `gmt_create` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `gmt_modified` datetime NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`role_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '角色' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES (1, '开发', 'admin', '拥有最高权限', 2, '2017-08-12 00:43:52', '2017-08-12 19:14:59');
INSERT INTO `sys_role` VALUES (2, '普通管理员', NULL, '普通管理员', NULL, NULL, NULL);

-- ----------------------------
-- Table structure for sys_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_menu`;
CREATE TABLE `sys_role_menu`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_id` bigint(20) NULL DEFAULT NULL COMMENT '角色ID',
  `menu_id` bigint(20) NULL DEFAULT NULL COMMENT '菜单ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3535 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '角色与菜单对应关系' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_role_menu
-- ----------------------------
INSERT INTO `sys_role_menu` VALUES (367, 44, 1);
INSERT INTO `sys_role_menu` VALUES (368, 44, 32);
INSERT INTO `sys_role_menu` VALUES (369, 44, 33);
INSERT INTO `sys_role_menu` VALUES (370, 44, 34);
INSERT INTO `sys_role_menu` VALUES (371, 44, 35);
INSERT INTO `sys_role_menu` VALUES (372, 44, 28);
INSERT INTO `sys_role_menu` VALUES (373, 44, 29);
INSERT INTO `sys_role_menu` VALUES (374, 44, 30);
INSERT INTO `sys_role_menu` VALUES (375, 44, 38);
INSERT INTO `sys_role_menu` VALUES (376, 44, 4);
INSERT INTO `sys_role_menu` VALUES (377, 44, 27);
INSERT INTO `sys_role_menu` VALUES (378, 45, 38);
INSERT INTO `sys_role_menu` VALUES (379, 46, 3);
INSERT INTO `sys_role_menu` VALUES (380, 46, 20);
INSERT INTO `sys_role_menu` VALUES (381, 46, 21);
INSERT INTO `sys_role_menu` VALUES (382, 46, 22);
INSERT INTO `sys_role_menu` VALUES (383, 46, 23);
INSERT INTO `sys_role_menu` VALUES (384, 46, 11);
INSERT INTO `sys_role_menu` VALUES (385, 46, 12);
INSERT INTO `sys_role_menu` VALUES (386, 46, 13);
INSERT INTO `sys_role_menu` VALUES (387, 46, 14);
INSERT INTO `sys_role_menu` VALUES (388, 46, 24);
INSERT INTO `sys_role_menu` VALUES (389, 46, 25);
INSERT INTO `sys_role_menu` VALUES (390, 46, 26);
INSERT INTO `sys_role_menu` VALUES (391, 46, 15);
INSERT INTO `sys_role_menu` VALUES (392, 46, 2);
INSERT INTO `sys_role_menu` VALUES (393, 46, 6);
INSERT INTO `sys_role_menu` VALUES (394, 46, 7);
INSERT INTO `sys_role_menu` VALUES (598, 50, 38);
INSERT INTO `sys_role_menu` VALUES (632, 38, 42);
INSERT INTO `sys_role_menu` VALUES (737, 51, 38);
INSERT INTO `sys_role_menu` VALUES (738, 51, 39);
INSERT INTO `sys_role_menu` VALUES (739, 51, 40);
INSERT INTO `sys_role_menu` VALUES (740, 51, 41);
INSERT INTO `sys_role_menu` VALUES (741, 51, 4);
INSERT INTO `sys_role_menu` VALUES (742, 51, 32);
INSERT INTO `sys_role_menu` VALUES (743, 51, 33);
INSERT INTO `sys_role_menu` VALUES (744, 51, 34);
INSERT INTO `sys_role_menu` VALUES (745, 51, 35);
INSERT INTO `sys_role_menu` VALUES (746, 51, 27);
INSERT INTO `sys_role_menu` VALUES (747, 51, 28);
INSERT INTO `sys_role_menu` VALUES (748, 51, 29);
INSERT INTO `sys_role_menu` VALUES (749, 51, 30);
INSERT INTO `sys_role_menu` VALUES (750, 51, 1);
INSERT INTO `sys_role_menu` VALUES (1064, 54, 53);
INSERT INTO `sys_role_menu` VALUES (1095, 55, 2);
INSERT INTO `sys_role_menu` VALUES (1096, 55, 6);
INSERT INTO `sys_role_menu` VALUES (1097, 55, 7);
INSERT INTO `sys_role_menu` VALUES (1098, 55, 3);
INSERT INTO `sys_role_menu` VALUES (1099, 55, 50);
INSERT INTO `sys_role_menu` VALUES (1100, 55, 49);
INSERT INTO `sys_role_menu` VALUES (1101, 55, 1);
INSERT INTO `sys_role_menu` VALUES (1856, 53, 28);
INSERT INTO `sys_role_menu` VALUES (1857, 53, 29);
INSERT INTO `sys_role_menu` VALUES (1858, 53, 30);
INSERT INTO `sys_role_menu` VALUES (1859, 53, 27);
INSERT INTO `sys_role_menu` VALUES (1860, 53, 57);
INSERT INTO `sys_role_menu` VALUES (1861, 53, 71);
INSERT INTO `sys_role_menu` VALUES (1862, 53, 48);
INSERT INTO `sys_role_menu` VALUES (1863, 53, 72);
INSERT INTO `sys_role_menu` VALUES (1864, 53, 1);
INSERT INTO `sys_role_menu` VALUES (1865, 53, 7);
INSERT INTO `sys_role_menu` VALUES (1866, 53, 55);
INSERT INTO `sys_role_menu` VALUES (1867, 53, 56);
INSERT INTO `sys_role_menu` VALUES (1868, 53, 62);
INSERT INTO `sys_role_menu` VALUES (1869, 53, 15);
INSERT INTO `sys_role_menu` VALUES (1870, 53, 2);
INSERT INTO `sys_role_menu` VALUES (1871, 53, 61);
INSERT INTO `sys_role_menu` VALUES (1872, 53, 20);
INSERT INTO `sys_role_menu` VALUES (1873, 53, 21);
INSERT INTO `sys_role_menu` VALUES (1874, 53, 22);
INSERT INTO `sys_role_menu` VALUES (2084, 56, 68);
INSERT INTO `sys_role_menu` VALUES (2085, 56, 60);
INSERT INTO `sys_role_menu` VALUES (2086, 56, 59);
INSERT INTO `sys_role_menu` VALUES (2087, 56, 58);
INSERT INTO `sys_role_menu` VALUES (2088, 56, 51);
INSERT INTO `sys_role_menu` VALUES (2089, 56, 50);
INSERT INTO `sys_role_menu` VALUES (2090, 56, 49);
INSERT INTO `sys_role_menu` VALUES (2243, 48, 72);
INSERT INTO `sys_role_menu` VALUES (2247, 63, -1);
INSERT INTO `sys_role_menu` VALUES (2248, 63, 84);
INSERT INTO `sys_role_menu` VALUES (2249, 63, 85);
INSERT INTO `sys_role_menu` VALUES (2250, 63, 88);
INSERT INTO `sys_role_menu` VALUES (2251, 63, 87);
INSERT INTO `sys_role_menu` VALUES (2252, 64, 84);
INSERT INTO `sys_role_menu` VALUES (2253, 64, 89);
INSERT INTO `sys_role_menu` VALUES (2254, 64, 88);
INSERT INTO `sys_role_menu` VALUES (2255, 64, 87);
INSERT INTO `sys_role_menu` VALUES (2256, 64, 86);
INSERT INTO `sys_role_menu` VALUES (2257, 64, 85);
INSERT INTO `sys_role_menu` VALUES (2258, 65, 89);
INSERT INTO `sys_role_menu` VALUES (2259, 65, 88);
INSERT INTO `sys_role_menu` VALUES (2260, 65, 86);
INSERT INTO `sys_role_menu` VALUES (2262, 67, 48);
INSERT INTO `sys_role_menu` VALUES (2263, 68, 88);
INSERT INTO `sys_role_menu` VALUES (2264, 68, 87);
INSERT INTO `sys_role_menu` VALUES (2265, 69, 89);
INSERT INTO `sys_role_menu` VALUES (2266, 69, 88);
INSERT INTO `sys_role_menu` VALUES (2267, 69, 86);
INSERT INTO `sys_role_menu` VALUES (2268, 69, 87);
INSERT INTO `sys_role_menu` VALUES (2269, 69, 85);
INSERT INTO `sys_role_menu` VALUES (2270, 69, 84);
INSERT INTO `sys_role_menu` VALUES (2271, 70, 85);
INSERT INTO `sys_role_menu` VALUES (2272, 70, 89);
INSERT INTO `sys_role_menu` VALUES (2273, 70, 88);
INSERT INTO `sys_role_menu` VALUES (2274, 70, 87);
INSERT INTO `sys_role_menu` VALUES (2275, 70, 86);
INSERT INTO `sys_role_menu` VALUES (2276, 70, 84);
INSERT INTO `sys_role_menu` VALUES (2277, 71, 87);
INSERT INTO `sys_role_menu` VALUES (2278, 72, 59);
INSERT INTO `sys_role_menu` VALUES (2279, 73, 48);
INSERT INTO `sys_role_menu` VALUES (2280, 74, 88);
INSERT INTO `sys_role_menu` VALUES (2281, 74, 87);
INSERT INTO `sys_role_menu` VALUES (2282, 75, 88);
INSERT INTO `sys_role_menu` VALUES (2283, 75, 87);
INSERT INTO `sys_role_menu` VALUES (2284, 76, 85);
INSERT INTO `sys_role_menu` VALUES (2285, 76, 89);
INSERT INTO `sys_role_menu` VALUES (2286, 76, 88);
INSERT INTO `sys_role_menu` VALUES (2287, 76, 87);
INSERT INTO `sys_role_menu` VALUES (2288, 76, 86);
INSERT INTO `sys_role_menu` VALUES (2289, 76, 84);
INSERT INTO `sys_role_menu` VALUES (2292, 78, 88);
INSERT INTO `sys_role_menu` VALUES (2293, 78, 87);
INSERT INTO `sys_role_menu` VALUES (2294, 78, NULL);
INSERT INTO `sys_role_menu` VALUES (2295, 78, NULL);
INSERT INTO `sys_role_menu` VALUES (2296, 78, NULL);
INSERT INTO `sys_role_menu` VALUES (2308, 80, 87);
INSERT INTO `sys_role_menu` VALUES (2309, 80, 86);
INSERT INTO `sys_role_menu` VALUES (2310, 80, -1);
INSERT INTO `sys_role_menu` VALUES (2311, 80, 84);
INSERT INTO `sys_role_menu` VALUES (2312, 80, 85);
INSERT INTO `sys_role_menu` VALUES (2328, 79, 72);
INSERT INTO `sys_role_menu` VALUES (2329, 79, 48);
INSERT INTO `sys_role_menu` VALUES (2330, 79, 77);
INSERT INTO `sys_role_menu` VALUES (2331, 79, 84);
INSERT INTO `sys_role_menu` VALUES (2332, 79, 89);
INSERT INTO `sys_role_menu` VALUES (2333, 79, 88);
INSERT INTO `sys_role_menu` VALUES (2334, 79, 87);
INSERT INTO `sys_role_menu` VALUES (2335, 79, 86);
INSERT INTO `sys_role_menu` VALUES (2336, 79, 85);
INSERT INTO `sys_role_menu` VALUES (2337, 79, -1);
INSERT INTO `sys_role_menu` VALUES (2338, 77, 89);
INSERT INTO `sys_role_menu` VALUES (2339, 77, 88);
INSERT INTO `sys_role_menu` VALUES (2340, 77, 87);
INSERT INTO `sys_role_menu` VALUES (2341, 77, 86);
INSERT INTO `sys_role_menu` VALUES (2342, 77, 85);
INSERT INTO `sys_role_menu` VALUES (2343, 77, 84);
INSERT INTO `sys_role_menu` VALUES (2344, 77, 72);
INSERT INTO `sys_role_menu` VALUES (2345, 77, -1);
INSERT INTO `sys_role_menu` VALUES (2346, 77, 77);
INSERT INTO `sys_role_menu` VALUES (2974, 57, 93);
INSERT INTO `sys_role_menu` VALUES (2975, 57, 99);
INSERT INTO `sys_role_menu` VALUES (2976, 57, 95);
INSERT INTO `sys_role_menu` VALUES (2977, 57, 101);
INSERT INTO `sys_role_menu` VALUES (2978, 57, 96);
INSERT INTO `sys_role_menu` VALUES (2979, 57, 94);
INSERT INTO `sys_role_menu` VALUES (2980, 57, -1);
INSERT INTO `sys_role_menu` VALUES (2981, 58, 93);
INSERT INTO `sys_role_menu` VALUES (2982, 58, 99);
INSERT INTO `sys_role_menu` VALUES (2983, 58, 95);
INSERT INTO `sys_role_menu` VALUES (2984, 58, 101);
INSERT INTO `sys_role_menu` VALUES (2985, 58, 96);
INSERT INTO `sys_role_menu` VALUES (2986, 58, 94);
INSERT INTO `sys_role_menu` VALUES (2987, 58, -1);
INSERT INTO `sys_role_menu` VALUES (3325, 2, 98);
INSERT INTO `sys_role_menu` VALUES (3326, 2, 101);
INSERT INTO `sys_role_menu` VALUES (3327, 2, 99);
INSERT INTO `sys_role_menu` VALUES (3328, 2, 95);
INSERT INTO `sys_role_menu` VALUES (3329, 2, 97);
INSERT INTO `sys_role_menu` VALUES (3330, 2, 96);
INSERT INTO `sys_role_menu` VALUES (3331, 2, 94);
INSERT INTO `sys_role_menu` VALUES (3332, 2, 93);
INSERT INTO `sys_role_menu` VALUES (3333, 2, -1);
INSERT INTO `sys_role_menu` VALUES (3488, 1, 92);
INSERT INTO `sys_role_menu` VALUES (3489, 1, 57);
INSERT INTO `sys_role_menu` VALUES (3490, 1, 30);
INSERT INTO `sys_role_menu` VALUES (3491, 1, 29);
INSERT INTO `sys_role_menu` VALUES (3492, 1, 28);
INSERT INTO `sys_role_menu` VALUES (3493, 1, 90);
INSERT INTO `sys_role_menu` VALUES (3494, 1, 89);
INSERT INTO `sys_role_menu` VALUES (3495, 1, 88);
INSERT INTO `sys_role_menu` VALUES (3496, 1, 87);
INSERT INTO `sys_role_menu` VALUES (3497, 1, 86);
INSERT INTO `sys_role_menu` VALUES (3498, 1, 48);
INSERT INTO `sys_role_menu` VALUES (3499, 1, 76);
INSERT INTO `sys_role_menu` VALUES (3500, 1, 75);
INSERT INTO `sys_role_menu` VALUES (3501, 1, 74);
INSERT INTO `sys_role_menu` VALUES (3502, 1, 62);
INSERT INTO `sys_role_menu` VALUES (3503, 1, 56);
INSERT INTO `sys_role_menu` VALUES (3504, 1, 55);
INSERT INTO `sys_role_menu` VALUES (3505, 1, 15);
INSERT INTO `sys_role_menu` VALUES (3506, 1, 26);
INSERT INTO `sys_role_menu` VALUES (3507, 1, 25);
INSERT INTO `sys_role_menu` VALUES (3508, 1, 24);
INSERT INTO `sys_role_menu` VALUES (3509, 1, 14);
INSERT INTO `sys_role_menu` VALUES (3510, 1, 13);
INSERT INTO `sys_role_menu` VALUES (3511, 1, 12);
INSERT INTO `sys_role_menu` VALUES (3512, 1, 61);
INSERT INTO `sys_role_menu` VALUES (3513, 1, 22);
INSERT INTO `sys_role_menu` VALUES (3514, 1, 21);
INSERT INTO `sys_role_menu` VALUES (3515, 1, 20);
INSERT INTO `sys_role_menu` VALUES (3516, 1, 109);
INSERT INTO `sys_role_menu` VALUES (3517, 1, 83);
INSERT INTO `sys_role_menu` VALUES (3518, 1, 81);
INSERT INTO `sys_role_menu` VALUES (3519, 1, 80);
INSERT INTO `sys_role_menu` VALUES (3520, 1, 79);
INSERT INTO `sys_role_menu` VALUES (3521, 1, 71);
INSERT INTO `sys_role_menu` VALUES (3522, 1, 27);
INSERT INTO `sys_role_menu` VALUES (3523, 1, 91);
INSERT INTO `sys_role_menu` VALUES (3524, 1, 85);
INSERT INTO `sys_role_menu` VALUES (3525, 1, 84);
INSERT INTO `sys_role_menu` VALUES (3526, 1, 77);
INSERT INTO `sys_role_menu` VALUES (3527, 1, 73);
INSERT INTO `sys_role_menu` VALUES (3528, 1, 7);
INSERT INTO `sys_role_menu` VALUES (3529, 1, 6);
INSERT INTO `sys_role_menu` VALUES (3530, 1, 2);
INSERT INTO `sys_role_menu` VALUES (3531, 1, 3);
INSERT INTO `sys_role_menu` VALUES (3532, 1, 78);
INSERT INTO `sys_role_menu` VALUES (3533, 1, 1);
INSERT INTO `sys_role_menu` VALUES (3534, 1, -1);

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`  (
  `user_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
  `dept_id` bigint(20) NULL DEFAULT NULL,
  `email` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `mobile` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手机号',
  `status` tinyint(255) NULL DEFAULT NULL COMMENT '状态 0:禁用，1:正常',
  `user_id_create` bigint(255) NULL DEFAULT NULL COMMENT '创建用户id',
  `gmt_create` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `gmt_modified` datetime NULL DEFAULT NULL COMMENT '修改时间',
  `sex` bigint(32) NULL DEFAULT NULL COMMENT '性别',
  `birth` datetime NULL DEFAULT NULL COMMENT '出身日期',
  `head_icon` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `live_address` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '现居住地',
  `hobby` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '爱好',
  `province` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '省份',
  `city` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '所在城市',
  `district` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '所在地区',
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 138 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES (1, 'admin', '超级管理员', '27bd386e70f280e24c2f4f2a549b82cf', 6, 'admin@example.com', '17699999999', 1, 1, '2017-08-15 21:40:39', '2017-08-15 21:41:00', 96, '2017-12-14 00:00:00', '/upload/faceImg/2018/1224/f0a733a382b84db1.jpg', 'ccc', '121;', '北京市', '北京市市辖区', '东城区');
INSERT INTO `sys_user` VALUES (2, 'test', '临时用户', '6cf3bb3deba2aadbd41ec9a22511084e', 6, 'test@bootdo.com', NULL, 1, 1, '2017-08-14 13:43:05', '2017-08-14 21:15:36', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (36, 'ldh', '刘德华', 'bfd9394475754fbe45866eba97738c36', 7, 'ldh@bootdo.com', NULL, 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (123, 'zxy', '张学友', '35174ba93f5fe7267f1fb3c1bf903781', 6, 'zxy@bootdo', NULL, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (124, 'wyf', '吴亦凡', 'e179e6f687bbd57b9d7efc4746c8090a', 6, 'wyf@bootdo.com', NULL, 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (130, 'lh', '鹿晗', '7924710cd673f68967cde70e188bb097', 9, 'lh@bootdo.com', NULL, 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (131, 'lhc', '令狐冲', 'd515538e17ecb570ba40344b5618f5d4', 6, 'lhc@bootdo.com', NULL, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (132, 'lyf', '刘亦菲', '7fdb1d9008f45950c1620ba0864e5fbd', 13, 'lyf@bootdo.com', NULL, 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (134, 'lyh', '李彦宏', 'dc26092b3244d9d432863f2738180e19', 8, 'lyh@bootdo.com', NULL, 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (135, 'wjl', '王健林', '3967697dfced162cf6a34080259b83aa', 6, 'wjl@bootod.com', NULL, 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (136, 'gdg', '郭德纲', '3bb1bda86bc02bf6478cd91e42135d2f', 9, 'gdg@bootdo.com', NULL, 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (137, 'test22', '测试用户222', '649169898e69272c0e5bc899baf1e904', 12, 'test2@bootdo.com', NULL, 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for sys_user_plus
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_plus`;
CREATE TABLE `sys_user_plus`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NOT NULL,
  `payment` double NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NULL DEFAULT NULL COMMENT '用户ID',
  `role_id` bigint(20) NULL DEFAULT NULL COMMENT '角色ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 146 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户与角色对应关系' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES (73, 30, 48);
INSERT INTO `sys_user_role` VALUES (74, 30, 49);
INSERT INTO `sys_user_role` VALUES (75, 30, 50);
INSERT INTO `sys_user_role` VALUES (76, 31, 48);
INSERT INTO `sys_user_role` VALUES (77, 31, 49);
INSERT INTO `sys_user_role` VALUES (78, 31, 52);
INSERT INTO `sys_user_role` VALUES (79, 32, 48);
INSERT INTO `sys_user_role` VALUES (80, 32, 49);
INSERT INTO `sys_user_role` VALUES (81, 32, 50);
INSERT INTO `sys_user_role` VALUES (82, 32, 51);
INSERT INTO `sys_user_role` VALUES (83, 32, 52);
INSERT INTO `sys_user_role` VALUES (84, 33, 38);
INSERT INTO `sys_user_role` VALUES (85, 33, 49);
INSERT INTO `sys_user_role` VALUES (86, 33, 52);
INSERT INTO `sys_user_role` VALUES (87, 34, 50);
INSERT INTO `sys_user_role` VALUES (88, 34, 51);
INSERT INTO `sys_user_role` VALUES (89, 34, 52);
INSERT INTO `sys_user_role` VALUES (106, 124, 1);
INSERT INTO `sys_user_role` VALUES (111, 2, 1);
INSERT INTO `sys_user_role` VALUES (113, 131, 48);
INSERT INTO `sys_user_role` VALUES (117, 135, 1);
INSERT INTO `sys_user_role` VALUES (120, 134, 1);
INSERT INTO `sys_user_role` VALUES (121, 134, 48);
INSERT INTO `sys_user_role` VALUES (123, 130, 1);
INSERT INTO `sys_user_role` VALUES (124, NULL, 48);
INSERT INTO `sys_user_role` VALUES (125, 132, 52);
INSERT INTO `sys_user_role` VALUES (126, 132, 49);
INSERT INTO `sys_user_role` VALUES (127, 123, 48);
INSERT INTO `sys_user_role` VALUES (132, 36, 48);
INSERT INTO `sys_user_role` VALUES (143, 137, 2);
INSERT INTO `sys_user_role` VALUES (145, 1, 1);

SET FOREIGN_KEY_CHECKS = 1;
