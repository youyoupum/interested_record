/*
 Navicat Premium Dump SQL

 Source Server         : root
 Source Server Type    : MySQL
 Source Server Version : 80039 (8.0.39)
 Source Host           : localhost:3306
 Source Schema         : interest_record

 Target Server Type    : MySQL
 Target Server Version : 80039 (8.0.39)
 File Encoding         : 65001

 Date: 03/12/2024 19:02:27
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for comments
-- ----------------------------
DROP TABLE IF EXISTS `comments`;
CREATE TABLE `comments`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '评论的唯一标识符',
  `user_id` int NULL DEFAULT NULL COMMENT '发表评论的用户的 ID，外键关联到 Users 表',
  `is_author` tinyint(1) NULL DEFAULT 0 COMMENT '表示发表评论的用户是否为商家，默认为 FALSE',
  `praise` int NULL DEFAULT 0 COMMENT '评论的点赞数，默认为 0',
  `comment_content` text CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL COMMENT '评论的内容',
  `create_at` datetime NULL DEFAULT NULL COMMENT '评论的时间',
  `note_id` int NOT NULL COMMENT '评价帖子',
  `user_img` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '用户图片',
  `nickname` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '用户名',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `noteid`(`note_id` ASC) USING BTREE,
  CONSTRAINT `noteid` FOREIGN KEY (`note_id`) REFERENCES `note` (`id`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 84 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci COMMENT = '存储评论信息的表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of comments
-- ----------------------------
INSERT INTO `comments` VALUES (5, 1, 0, 50, '这是一个测试评论sadsadsadsadsadsadsadsadsadsadsadsadasdsa', '2023-04-01 12:00:00', 5, '/static/img/icon1.jpeg', '南瓜pum');
INSERT INTO `comments` VALUES (6, 1, 0, 50, '这个帖子太棒了，值得一看！二维若撒多撒多撒多撒多撒大所多撒大声地撒多撒打算大萨达撒打撒多撒多撒撒多所打大声道', '2023-04-01 12:00:00', 5, '/static/img/icon1.jpeg', '南瓜pum');
INSERT INTO `comments` VALUES (7, 2, 0, 45, '作者写得真好，学到了不是的撒多撒多撒多撒多撒多撒多撒多撒多东西。', '2023-04-01 12:15:00', 5, '/static/img/icon1.jpeg', '南瓜pum');
INSERT INTO `comments` VALUES (8, 3, 1, 55, '这个帖子让我想起了小时候的事。', '2023-04-01 12:30:00', 5, '/static/img/icon1.jpeg', '南瓜pum');
INSERT INTO `comments` VALUES (9, 4, 0, 60, '太棒了！作者的想象力真丰富。', '2023-04-01 12:45:00', 5, '/static/img/icon1.jpeg', '南瓜pum');
INSERT INTO `comments` VALUES (10, 5, 1, 65, '这个帖子有点意思，值得一读。', '2023-04-01 13:00:00', 5, '/static/img/icon1.jpeg', '南瓜pum');
INSERT INTO `comments` VALUES (11, 6, 0, 70, '作者的观点很独特，我赞同。', '2023-04-01 13:15:00', 5, '/static/img/icon1.jpeg', '南瓜pum');
INSERT INTO `comments` VALUES (12, 7, 1, 75, '这个帖子让我感到很温暖。', '2023-04-01 13:30:00', 5, '/static/img/icon1.jpeg', '南瓜pum');
INSERT INTO `comments` VALUES (13, 8, 0, 80, '太搞笑了！作者真是幽默大师。', '2023-04-01 13:45:00', 5, '/static/img/icon1.jpeg', '南瓜pum');
INSERT INTO `comments` VALUES (14, 9, 1, 85, '这个帖子让我学到了很多新知识。', '2023-04-01 14:00:00', 5, '/static/img/icon1.jpeg', '南瓜pum');
INSERT INTO `comments` VALUES (15, 10, 0, 90, '作者的文笔真是太好了，读起来很流畅。', '2023-04-01 14:15:00', 5, '/static/img/icon1.jpeg', '南瓜pum');
INSERT INTO `comments` VALUES (16, 11, 1, 95, '这个帖子让我想起了某部电影。', '2023-04-01 14:30:00', 5, '/static/img/icon1.jpeg', '南瓜pum');
INSERT INTO `comments` VALUES (17, 12, 0, 100, '111', '2023-04-01 14:45:00', 5, '/static/img/icon1.jpeg', '南瓜pum');
INSERT INTO `comments` VALUES (18, 13, 1, 105, '这个帖子让我感到很震撼。', '2023-04-01 15:00:00', 5, '/static/img/icon1.jpeg', '南瓜pum');
INSERT INTO `comments` VALUES (19, 14, 0, 110, '作者的观点很有道理，我同意。', '2023-04-01 15:15:00', 5, '/static/img/icon1.jpeg', '南瓜pum');
INSERT INTO `comments` VALUES (20, 15, 1, 115, '这个帖子让我学到了很多新技能。', '2023-04-01 15:30:00', 5, '/static/img/icon1.jpeg', '南瓜pum');
INSERT INTO `comments` VALUES (21, 16, 0, 120, '太搞笑了！作者真是幽默大师。', '2023-04-01 15:45:00', 5, '/static/img/icon1.jpeg', '南瓜pum');
INSERT INTO `comments` VALUES (22, 17, 1, 125, '这个帖子让我想起了某本书。', '2023-04-01 16:00:00', 5, '/static/img/icon1.jpeg', '南瓜pum');
INSERT INTO `comments` VALUES (23, 18, 0, 130, '作者的文笔真是太好了，读起来很流畅。', '2023-04-01 16:15:00', 5, '/static/img/icon1.jpeg', '南瓜pum');
INSERT INTO `comments` VALUES (24, 19, 1, 135, '这个帖子让我感到很温暖。', '2023-04-01 16:30:00', 5, '/static/img/icon1.jpeg', '南瓜pum');
INSERT INTO `comments` VALUES (25, 20, 0, 140, '太棒了！这个帖子值得一A再读。', '2023-04-01 16:45:00', 5, '/static/img/icon1.jpeg', '南瓜pum');
INSERT INTO `comments` VALUES (26, 20, 0, 52, '太棒了！这个帖子值得一A再读。', '2024-11-23 02:22:36', 5, '/static/img/icon1.jpeg', '南瓜pum');
INSERT INTO `comments` VALUES (27, 7, 0, 0, '这是一个很好的帖子', '2024-11-23 02:49:27', 5, '/static/img/icon1.jpeg', '南瓜pum');
INSERT INTO `comments` VALUES (48, 7, 0, 0, '这是一个很好的帖子', '2024-11-28 15:11:04', 6, NULL, NULL);
INSERT INTO `comments` VALUES (49, 7, 0, 0, '这是一个很好的帖子', '2024-11-28 15:12:02', 6, '/static/img/icon1.jpeg', '南瓜pum');
INSERT INTO `comments` VALUES (50, 7, 0, 0, '乃龙', '2024-11-28 15:12:31', 5, '/static/img/icon1.jpeg', '南瓜pum');
INSERT INTO `comments` VALUES (51, 7, 0, 0, '这是一个很好的帖子', '2024-11-28 15:15:28', 6, '/static/img/icon1.jpeg', '南瓜pum');
INSERT INTO `comments` VALUES (52, 7, 0, 0, '哈哈哈', '2024-11-28 15:15:54', 5, '/static/img/icon1.jpeg', '南瓜pum');
INSERT INTO `comments` VALUES (53, 7, 0, 0, '1', '2024-11-28 15:17:19', 5, '/static/img/icon1.jpeg', '南瓜pum');
INSERT INTO `comments` VALUES (54, 7, 0, 0, '1', '2024-11-28 15:18:56', 5, '/static/img/icon1.jpeg', '南瓜pum');
INSERT INTO `comments` VALUES (55, 7, 0, 0, '1111', '2024-11-28 15:19:53', 5, '/static/img/icon1.jpeg', '南瓜pum');
INSERT INTO `comments` VALUES (56, 7, 0, 0, '2', '2024-11-28 15:22:52', 5, '/static/img/icon1.jpeg', '南瓜pum');
INSERT INTO `comments` VALUES (57, 7, 0, 0, '哈哈哈', '2024-11-28 17:35:07', 5, '/static/img/icon1.jpeg', '南瓜pum');
INSERT INTO `comments` VALUES (58, 7, 0, 0, '23', '2024-11-28 22:13:46', 7, '/static/img/icon1.jpeg', '南瓜pum');
INSERT INTO `comments` VALUES (59, 7, 0, 0, '111', '2024-11-29 01:07:22', 27, '/static/img/icon1.jpeg', '南瓜pum');
INSERT INTO `comments` VALUES (60, 7, 0, 0, '2', '2024-11-29 01:09:45', 31, '/static/img/icon1.jpeg', '南瓜pum');
INSERT INTO `comments` VALUES (61, 7, 0, 0, '22', '2024-11-29 01:12:06', 31, '/static/img/icon1.jpeg', '南瓜pum');
INSERT INTO `comments` VALUES (62, 7, 0, 0, '213', '2024-11-29 01:17:07', 31, '/static/img/icon1.jpeg', '南瓜pum');
INSERT INTO `comments` VALUES (63, 7, 0, 0, 'asd', '2024-11-29 01:18:09', 31, '/static/img/icon1.jpeg', '南瓜pum');
INSERT INTO `comments` VALUES (64, 7, 0, 0, 'asd', '2024-11-29 01:18:46', 31, '/static/img/icon1.jpeg', '南瓜pum');
INSERT INTO `comments` VALUES (65, 7, 0, 0, '1', '2024-11-29 01:22:30', 31, '/static/img/icon1.jpeg', '南瓜pum');
INSERT INTO `comments` VALUES (66, 7, 0, 0, '23', '2024-11-29 01:24:40', 31, '/static/img/icon1.jpeg', '南瓜pum');
INSERT INTO `comments` VALUES (67, 7, 0, 0, '213', '2024-11-29 13:36:49', 36, '/static/img/icon1.jpeg', '南瓜pum');
INSERT INTO `comments` VALUES (68, 7, 0, 0, 'sd', '2024-11-29 13:38:57', 36, '/static/img/icon1.jpeg', '南瓜pum');
INSERT INTO `comments` VALUES (69, 7, 0, 0, 'sd', '2024-11-29 13:40:14', 36, '/static/img/icon1.jpeg', '南瓜pum');
INSERT INTO `comments` VALUES (70, 7, 0, 0, 's', '2024-11-29 13:40:42', 36, '/static/img/icon1.jpeg', '南瓜pum');
INSERT INTO `comments` VALUES (71, 7, 0, 0, '213', '2024-11-29 13:42:23', 35, '/static/img/icon1.jpeg', '南瓜pum');
INSERT INTO `comments` VALUES (72, 7, 0, 0, '3', '2024-11-29 13:42:30', 36, '/static/img/icon1.jpeg', '南瓜pum');
INSERT INTO `comments` VALUES (73, 7, 0, 0, '213', '2024-11-29 13:42:38', 36, '/static/img/icon1.jpeg', '南瓜pum');
INSERT INTO `comments` VALUES (74, 7, 0, 0, '3', '2024-11-29 13:42:41', 36, '/static/img/icon1.jpeg', '南瓜pum');
INSERT INTO `comments` VALUES (75, 7, 0, 0, 'rt', '2024-11-29 14:50:54', 36, '/static/img/icon1.jpeg', '南瓜pum');
INSERT INTO `comments` VALUES (76, 7, 0, 0, '21323', '2024-11-29 15:32:55', 36, '/static/img/icon1.jpeg', '南瓜pum');
INSERT INTO `comments` VALUES (77, 7, 0, 0, '23', '2024-11-29 15:33:02', 36, '/static/img/icon1.jpeg', '南瓜pum');
INSERT INTO `comments` VALUES (78, 7, 0, 0, '213', '2024-11-29 15:39:41', 36, '/static/img/icon1.jpeg', '南瓜pum');
INSERT INTO `comments` VALUES (79, 7, 0, 0, '32', '2024-11-29 15:40:05', 36, '/static/img/icon1.jpeg', '南瓜pum');
INSERT INTO `comments` VALUES (80, 7, 0, 0, '23', '2024-11-29 15:40:07', 36, '/static/img/icon1.jpeg', '南瓜pum');
INSERT INTO `comments` VALUES (81, 7, 0, 0, '哈哈', '2024-12-01 21:55:03', 39, '/static/img/defaultPicture.png', '南瓜pum');
INSERT INTO `comments` VALUES (82, 7, 0, 1, '哈哈', '2024-12-01 21:56:00', 39, '/static/img/defaultPicture.png', '南瓜pum');
INSERT INTO `comments` VALUES (83, 7, 0, 0, '123', '2024-12-01 22:11:30', 39, '/static/img/defaultPicture.png', '南瓜pum');

-- ----------------------------
-- Table structure for note
-- ----------------------------
DROP TABLE IF EXISTS `note`;
CREATE TABLE `note`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_img` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '用户图片',
  `content` text CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL COMMENT '话题内容',
  `is_public` tinyint NULL DEFAULT NULL COMMENT '是否公开',
  `good_num` int NULL DEFAULT 0 COMMENT '点赞数量',
  `comment_num` int NULL DEFAULT 0 COMMENT '评论数量',
  `author_name` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '作者名字',
  `create_at` datetime NULL DEFAULT NULL COMMENT '帖子创建时间',
  `update_at` datetime NULL DEFAULT NULL COMMENT '帖子修改时间',
  `recent_answer_at` datetime NULL DEFAULT NULL COMMENT '最新回复时间',
  `title` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL DEFAULT NULL COMMENT '帖子标题',
  `tags` json NULL COMMENT '帖子标签',
  `author_id` int NULL DEFAULT NULL COMMENT '作者id',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `author_id`(`author_id` ASC) USING BTREE,
  CONSTRAINT `author_id` FOREIGN KEY (`author_id`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 40 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_bin COMMENT = '信息源' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of note
-- ----------------------------
INSERT INTO `note` VALUES (5, '/static/img/icon1.jpeg', '小明在公园里散步，突然看到一只可爱的小狗在追逐蝴蝶...', 1, 5, 30, '小明', '2023-10-01 10:00:00', '2023-10-01 10:00:00', '2023-10-02 14:00:00', '真是美好的一天', '[\"编程\", \"Java\", \"Python\"]', NULL);
INSERT INTO `note` VALUES (6, '/static/img/icon1.jpeg', '小丽今天去了一家新开的咖啡馆，点了她最爱的拿铁和蛋糕...', 1, 3, 3, '小丽', '2023-10-02 12:00:00', '2023-10-02 12:00:00', '2023-10-03 10:00:00', '真是美好的一天', '[\"编程\", \"Java\", \"Python\"]', NULL);
INSERT INTO `note` VALUES (7, '/static/img/icon1.jpeg', '小强在图书馆里复习功课，突然接到朋友的电话，约他晚上一起去唱歌...', 1, 2, 1, '小强', '2023-10-03 14:00:00', '2023-10-03 14:00:00', '2023-10-04 16:00:00', '真是美好的一天', '[\"编程\", \"Java\", \"Python\"]', NULL);
INSERT INTO `note` VALUES (8, '/static/img/icon1.jpeg', '小王在超市购物时，发现了一种新口味的薯片，味道非常好。', 1, 8, 0, '小王', '2023-10-05 11:00:00', '2023-10-05 11:00:00', '2023-10-06 13:00:00', '真是美好的一天', '[\"编程\", \"Java\", \"Python\"]', NULL);
INSERT INTO `note` VALUES (9, '/static/img/icon1.jpeg', '小张在健身房锻炼时，遇到了一位健身达人，向他请教了一些锻炼技巧。', 0, 4, 0, '小张', '2023-10-06 14:00:00', '2023-10-06 14:00:00', '2024-11-23 16:19:32', '真是美好的一天', '[\"编程\", \"Java\", \"Python\"]', NULL);
INSERT INTO `note` VALUES (10, '/static/img/icon1.jpeg', '小李在电影院看了一部非常感人的电影，眼泪止不住地流了下来。', 1, 7, 0, '小李', '2023-10-07 16:00:00', '2023-10-07 16:00:00', '2023-10-08 10:00:00', '真是美好的一天', '[\"编程\", \"Java\", \"Python\"]', NULL);
INSERT INTO `note` VALUES (11, '/static/img/icon1.jpeg', '小赵在公园里骑自行车，突然看到一只松鼠在树上跳跃。', 1, 3, 0, '小赵', '2023-10-08 12:00:00', '2023-10-08 12:00:00', '2024-11-06 16:19:35', '真是美好的一天', '[\"编程\", \"Java\", \"Python\"]', NULL);
INSERT INTO `note` VALUES (12, '/static/img/icon1.jpeg', '小刘在图书馆里看书时，发现了一本非常有趣的书，决定借回家阅读。', 1, 6, 0, '小刘', '2023-10-09 13:00:00', '2023-10-09 13:00:00', '2023-10-10 15:00:00', '真是美好的一天', '[\"编程\", \"Java\", \"Python\"]', NULL);
INSERT INTO `note` VALUES (13, '/static/img/icon1.jpeg', '小陈在餐厅吃饭时，发现了一种非常美味的菜品，决定下次再来品尝。', 1, 5, 0, '小陈', '2023-10-10 14:00:00', '2023-10-10 14:00:00', '2024-11-07 16:19:38', '真是美好的一天', '[\"编程\", \"Java\", \"Python\"]', NULL);
INSERT INTO `note` VALUES (14, '/static/img/icon1.jpeg', '小林在旅行中遇到了一位热情的当地人，向他请教了一些旅游攻略。', 1, 9, 0, '小林', '2023-10-11 16:00:00', '2023-10-11 16:00:00', '2023-10-12 10:00:00', '真是美好的一天', '[\"编程\", \"Java\", \"Python\"]', NULL);
INSERT INTO `note` VALUES (15, '/static/img/icon1.jpeg', '小黄在公园里散步时，发现了一朵非常美丽的花，忍不住拍了下来。', 1, 4, 0, '小黄', '2023-10-12 12:00:00', '2023-10-12 12:00:00', '2024-10-31 16:19:41', '真是美好的一天', '[\"编程\", \"Java\", \"Python\"]', NULL);
INSERT INTO `note` VALUES (16, '/static/img/icon1.jpeg', '小周在健身房锻炼时，发现了一种新的锻炼方式，决定尝试一下。', 1, 6, 0, '小周', '2023-10-13 14:00:00', '2023-10-13 14:00:00', '2023-10-14 15:00:00', '真是美好的一天', '[\"编程\", \"Java\", \"Python\"]', NULL);
INSERT INTO `note` VALUES (17, '/static/img/icon1.jpeg', '小吴在图书馆里看书时，发现了一本非常有趣的书，决定借回家阅读。', 1, 7, 0, '小吴', '2023-10-14 16:00:00', '2023-10-14 16:00:00', '2023-10-15 10:00:00', '真是美好的一天', '[\"编程\", \"Java\", \"Python\"]', NULL);
INSERT INTO `note` VALUES (18, '/static/img/icon1.jpeg', '小郑在餐厅吃饭时，发现了一种非常美味的菜品，决定下次再来品尝。', 1, 5, 0, '小郑', '2023-10-15 14:00:00', '2023-10-15 14:00:00', '2024-11-06 16:19:44', '真是美好的一天', '[\"编程\", \"Java\", \"Python\"]', NULL);
INSERT INTO `note` VALUES (19, '/static/img/icon1.jpeg', '小冯在旅行中遇到了一位热情的当地人，向他请教了一些旅游攻略。', 1, 9, 0, '小冯', '2023-10-16 16:00:00', '2023-10-16 16:00:00', '2023-10-17 10:00:00', '真是美好的一天', '[\"编程\", \"Java\", \"Python\"]', NULL);
INSERT INTO `note` VALUES (20, '/static/img/icon1.jpeg', '小明在公园里散步，突然', 0, 1, 0, '小明', '2024-11-23 16:57:07', '2024-11-23 16:57:07', NULL, '真是美好的一天', NULL, NULL);
INSERT INTO `note` VALUES (21, '/static/img/icon1.jpeg', '小明在公园里散步，突然', 0, 0, 0, '小明', '2024-11-23 17:16:02', '2024-11-23 17:16:02', NULL, '真是美好的一天', '[\"编程\", \"k\"]', NULL);
INSERT INTO `note` VALUES (22, '/static/img/icon1.jpeg', '小明在公园里散步，突然', 0, 0, 0, '小明', '2024-11-23 22:53:25', '2024-11-23 22:53:25', NULL, '真是美好的一天', '[\"编程\", \"k2\"]', NULL);
INSERT INTO `note` VALUES (23, '/static/img/icon1.jpeg', '小明在公园里散步，突然', 0, 0, 0, '小明', '2024-11-23 22:59:44', '2024-11-23 22:59:44', NULL, '真是美好的一天', '[\"编程\", \"k2\"]', NULL);
INSERT INTO `note` VALUES (24, '/static/img/icon1.jpeg', '小明在公园里散步，突然', 0, 0, 0, '小明', '2024-11-29 00:18:54', '2024-11-29 00:18:54', '2023-10-16 16:00:00', '真是美好的一天', '[\"编程\", \"k\"]', NULL);
INSERT INTO `note` VALUES (25, '/static/img/icon1.jpeg', '小明在公园里散步，突然', 0, 0, 0, '小明', '2024-11-29 00:19:02', '2024-11-29 00:19:02', NULL, '真是美好的一天', '[\"编程\", \"k\"]', NULL);
INSERT INTO `note` VALUES (26, '/static/img/icon1.jpeg', '小明在公园里散步，突然', 0, 0, 0, '小明', '2024-11-29 00:20:17', '2024-11-29 00:20:17', '2023-10-16 16:00:00', '真是美好的一天111', '[\"编程\", \"k\"]', NULL);
INSERT INTO `note` VALUES (27, '/static/img/icon1.jpeg', '小明在公园里散asdsad步，突然', 0, 0, 1, '小明', '2024-11-29 00:51:36', '2024-11-29 00:51:36', '2023-10-16 16:00:00', '真是sadsa美好的一天111', '[\"编程\", \"k\"]', NULL);
INSERT INTO `note` VALUES (28, '/static/img/icon1.jpeg', '在公园里散asdsad步，突然', 0, 0, 0, '小明', '2024-11-29 00:53:30', '2024-11-29 00:53:30', '2023-10-16 16:00:00', '真是sadsa美好的一天111', '[\"编程\", \"k\"]', NULL);
INSERT INTO `note` VALUES (29, '/static/img/icon1.jpeg', '在公园里散asdsad步，突然', 0, 0, 0, '小明', '2024-11-29 00:53:49', '2024-11-29 00:53:49', '2023-10-16 16:00:00', 'sadsa美好的一天111', '[\"编程\", \"k\"]', NULL);
INSERT INTO `note` VALUES (30, '/static/img/icon1.jpeg', '1111', 0, 0, 0, '小明', '2024-11-29 00:59:41', '2024-11-29 00:59:41', '2023-10-16 16:00:00', '22222', '[\"编程\", \"k\"]', NULL);
INSERT INTO `note` VALUES (31, '/static/img/icon1.jpeg', '11asdasd11', 0, 0, 7, '小明', '2024-11-29 01:02:30', '2024-11-29 01:02:30', '2023-10-16 16:00:00', '2222asdasd2', '[\"编程\", \"k\"]', NULL);
INSERT INTO `note` VALUES (32, '/static/img/icon1.jpeg', '11asdasd11', 1, 0, 0, '南瓜pum', '2024-11-29 01:33:13', '2024-11-29 01:33:13', '2023-10-16 16:00:00', '2222asdasd2', '[\"编程\", \"k\"]', 7);
INSERT INTO `note` VALUES (34, '/static/img/icon1.jpeg', 'sadas', 1, 0, 0, '南瓜pum', '2024-11-29 01:39:28', '2024-11-29 01:39:28', NULL, 'dasdsa', '[\"sdsad\", \"sd\"]', 7);
INSERT INTO `note` VALUES (35, '/static/img/icon1.jpeg', 'sadsad', 1, 0, 1, '南瓜pum', '2024-11-29 01:40:04', '2024-11-29 01:40:04', NULL, 'sadsad', '[\"sad\", \"sd\"]', 7);
INSERT INTO `note` VALUES (36, '/static/img/icon1.jpeg', 'sdasd', 1, 0, 13, '南瓜pum', '2024-11-29 01:43:18', '2024-11-29 01:43:18', NULL, 'dsa', '[]', 7);
INSERT INTO `note` VALUES (37, '/static/img/icon1.jpeg', 'asdsad', 1, 0, 0, '南瓜pum', '2024-11-29 15:50:42', '2024-11-29 15:50:42', NULL, 'sadas', '[\"asd\"]', 7);
INSERT INTO `note` VALUES (38, '/static/img/icon1.jpeg', 'wqe', 1, 0, 0, '南瓜pum', '2024-11-29 15:50:56', '2024-11-29 15:50:56', NULL, '哈哈哈', '[\"we\", \"sa\"]', 7);
INSERT INTO `note` VALUES (39, '/static/img/icon1.jpeg', 'sadsdadasd', 1, 0, 3, '南瓜pum', '2024-11-29 15:53:25', '2024-11-29 15:53:25', NULL, 'sds哈哈哈', '[]', 7);

-- ----------------------------
-- Table structure for replies
-- ----------------------------
DROP TABLE IF EXISTS `replies`;
CREATE TABLE `replies`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '回复的唯一标识符',
  `comment_id` int NULL DEFAULT NULL COMMENT '回复所属的评论的 ID，外键关联到 Comments 表',
  `nickname` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '回复者的昵称',
  `user_img` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '回复者的头像 URL',
  `reply_content` text CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL COMMENT '回复的内容',
  `praise` int NULL DEFAULT 0 COMMENT '回复的点赞数，默认为 0',
  `create_at` datetime NULL DEFAULT NULL COMMENT '回复的时间',
  `user_id` int NULL DEFAULT NULL COMMENT '回复者的id',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_replies_comment`(`comment_id` ASC) USING BTREE,
  CONSTRAINT `fk_replies_comment` FOREIGN KEY (`comment_id`) REFERENCES `comments` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 20 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci COMMENT = '存储回复信息的表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of replies
-- ----------------------------
INSERT INTO `replies` VALUES (1, 5, '幽', '/static/img/icon1.jpeg', 'sadsadsadasdsa', 10, '2024-11-24 18:20:51', NULL);
INSERT INTO `replies` VALUES (2, 5, '幽', '/static/img/icon1.jpeg', 'sadsadsadasdsa', 10, '2024-11-24 18:20:51', NULL);
INSERT INTO `replies` VALUES (3, 17, '明', '/static/img/icon1.jpeg', 'sadsadsadasdsa', 1, '2024-11-26 00:41:31', NULL);
INSERT INTO `replies` VALUES (4, 17, 'wadasdsa', '/static/img/icon1.jpeg', 'sadsadsadasdsa', 0, '2024-11-26 00:42:01', NULL);
INSERT INTO `replies` VALUES (5, 17, 'wadasdsa', '/static/img/icon1.jpeg', 'sadsadsadasdsa', 0, '2024-11-26 00:42:01', NULL);
INSERT INTO `replies` VALUES (6, 17, 'wadasdsa', '/static/img/icon1.jpeg', 'sadsadsadasdsa', 0, '2024-11-26 00:42:01', NULL);
INSERT INTO `replies` VALUES (7, 5, '南瓜pum', '/static/img/defaultPicture.png', NULL, 0, '2024-12-01 23:08:12', 7);
INSERT INTO `replies` VALUES (8, 5, '南瓜pum', '/static/img/defaultPicture.png', NULL, 0, '2024-12-01 23:09:33', 7);
INSERT INTO `replies` VALUES (9, 5, '南瓜pum', '/static/img/defaultPicture.png', NULL, 0, '2024-12-01 23:10:14', 7);
INSERT INTO `replies` VALUES (10, NULL, '南瓜pum', '/static/img/defaultPicture.png', NULL, 0, '2024-12-01 23:59:31', 7);
INSERT INTO `replies` VALUES (11, 83, '南瓜pum', '/static/img/defaultPicture.png', '2', 0, '2024-12-02 00:00:51', 7);
INSERT INTO `replies` VALUES (12, 83, '南瓜pum', '/static/img/defaultPicture.png', '2', 0, '2024-12-02 00:00:54', 7);
INSERT INTO `replies` VALUES (13, 83, '南瓜pum', '/static/img/defaultPicture.png', '2', 0, '2024-12-02 00:00:56', 7);
INSERT INTO `replies` VALUES (14, 83, '南瓜pum', '/static/img/defaultPicture.png', 'hhh', 0, '2024-12-02 00:00:59', 7);
INSERT INTO `replies` VALUES (15, 83, '南瓜pum', '/static/img/defaultPicture.png', 'hhh', 0, '2024-12-02 00:01:03', 7);
INSERT INTO `replies` VALUES (16, 83, '南瓜pum', '/static/img/defaultPicture.png', '21312', 0, '2024-12-02 00:01:16', 7);
INSERT INTO `replies` VALUES (17, 83, '南瓜pum', '/static/img/defaultPicture.png', '232', 0, '2024-12-02 00:01:48', 7);
INSERT INTO `replies` VALUES (18, 83, '南瓜pum', '/static/img/defaultPicture.png', '123', 0, '2024-12-02 00:01:51', 7);
INSERT INTO `replies` VALUES (19, 83, '南瓜pum', '/static/img/defaultPicture.png', '微信小程序真好玩', 1, '2024-12-02 00:01:58', 7);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
  `openid` varchar(45) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL DEFAULT NULL COMMENT '微信用户唯一标识',
  `name` varchar(32) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL DEFAULT NULL COMMENT '姓名',
  `phone` varchar(11) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL DEFAULT NULL COMMENT '手机号',
  `sex` varchar(2) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL DEFAULT NULL COMMENT '性别',
  `id_number` varchar(18) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL DEFAULT NULL COMMENT '身份证号',
  `avatar` varchar(500) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL DEFAULT NULL COMMENT '头像',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `login_time` datetime NULL DEFAULT NULL COMMENT '登录时间',
  `person_signature` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL DEFAULT NULL COMMENT '个性签名',
  `regions` json NULL COMMENT '地区',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_bin COMMENT = '用户信息' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (7, 'o8Nv_7MwTRJ4jOFPBlUFkHLJWpy8', '南瓜pum', '18899849236', '男', NULL, '/static/img/defaultPicture.png', '2024-11-20 15:58:05', NULL, '青春由磨砺而出彩，人生因奋斗而升华！', '[\"广东\", \"揭阳\", \"惠来\"]');

-- ----------------------------
-- Table structure for userpraises
-- ----------------------------
DROP TABLE IF EXISTS `userpraises`;
CREATE TABLE `userpraises`  (
  `user_id` int NOT NULL COMMENT '点赞用户的 ID，外键关联到 Users 表',
  `comment_id` int NOT NULL COMMENT '被点赞评论的 ID，外键关联到 Comments 表',
  `is_open` tinyint NULL DEFAULT 0 COMMENT '是否对评论进行折叠操作',
  `is_liked` tinyint NULL DEFAULT 0 COMMENT '是否对评论进行点赞操作',
  `comment_level` int NOT NULL COMMENT '评论等级 1为父级，2为子级',
  PRIMARY KEY (`user_id`, `comment_id`, `comment_level`) USING BTREE COMMENT '确保每个用户对每个评论只能点赞一次',
  INDEX `comment_id`(`comment_id` ASC) USING BTREE,
  CONSTRAINT `userpraises_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci COMMENT = '存储用户点赞评论信息的表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of userpraises
-- ----------------------------
INSERT INTO `userpraises` VALUES (7, 3, 0, 1, 2);
INSERT INTO `userpraises` VALUES (7, 4, 0, 1, 2);
INSERT INTO `userpraises` VALUES (7, 5, 1, 1, 1);
INSERT INTO `userpraises` VALUES (7, 5, 0, 1, 2);
INSERT INTO `userpraises` VALUES (7, 6, 1, 1, 1);
INSERT INTO `userpraises` VALUES (7, 9, 0, 1, 1);
INSERT INTO `userpraises` VALUES (7, 16, 0, 1, 1);
INSERT INTO `userpraises` VALUES (7, 17, 0, 1, 1);
INSERT INTO `userpraises` VALUES (7, 18, 0, 1, 1);
INSERT INTO `userpraises` VALUES (7, 19, 0, 1, 1);
INSERT INTO `userpraises` VALUES (7, 19, 0, 1, 2);
INSERT INTO `userpraises` VALUES (7, 20, 0, 1, 1);
INSERT INTO `userpraises` VALUES (7, 21, 0, 1, 1);
INSERT INTO `userpraises` VALUES (7, 22, 0, 1, 1);
INSERT INTO `userpraises` VALUES (7, 23, 0, 1, 1);
INSERT INTO `userpraises` VALUES (7, 24, 0, 1, 1);
INSERT INTO `userpraises` VALUES (7, 25, 0, 1, 1);
INSERT INTO `userpraises` VALUES (7, 57, 0, 1, 1);
INSERT INTO `userpraises` VALUES (7, 61, 0, 1, 1);
INSERT INTO `userpraises` VALUES (7, 76, 0, 1, 1);
INSERT INTO `userpraises` VALUES (7, 77, 0, 1, 1);
INSERT INTO `userpraises` VALUES (7, 78, 0, 1, 1);
INSERT INTO `userpraises` VALUES (7, 79, 0, 1, 1);
INSERT INTO `userpraises` VALUES (7, 80, 0, 1, 1);
INSERT INTO `userpraises` VALUES (7, 81, 0, 1, 1);
INSERT INTO `userpraises` VALUES (7, 82, 0, 1, 1);

-- ----------------------------
-- Triggers structure for table comments
-- ----------------------------
DROP TRIGGER IF EXISTS `update_comment_num_after_insert`;
delimiter ;;
CREATE TRIGGER `update_comment_num_after_insert` AFTER INSERT ON `comments` FOR EACH ROW BEGIN
    UPDATE note
    SET comment_num = comment_num + 1
    WHERE id = NEW.note_id;
END
;;
delimiter ;

-- ----------------------------
-- Triggers structure for table comments
-- ----------------------------
DROP TRIGGER IF EXISTS `update_comment_num_after_delete`;
delimiter ;;
CREATE TRIGGER `update_comment_num_after_delete` AFTER DELETE ON `comments` FOR EACH ROW BEGIN
    UPDATE note
    SET comment_num = comment_num - 1
    WHERE id = OLD.note_id;
END
;;
delimiter ;

SET FOREIGN_KEY_CHECKS = 1;
