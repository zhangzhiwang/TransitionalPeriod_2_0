-- 已有库升级：为 news 表补充新闻中心所需字段（可重复执行需人工判断）。
-- （由 Curosr 自动生成）

ALTER TABLE news
  ADD COLUMN author VARCHAR(50) DEFAULT NULL COMMENT '作者' AFTER category,
  ADD COLUMN content MEDIUMTEXT COMMENT '正文 HTML' AFTER author,
  ADD COLUMN featured TINYINT(1) NOT NULL DEFAULT 0 COMMENT '是否头条：1是0否' AFTER content,
  ADD COLUMN view_count INT NOT NULL DEFAULT 0 COMMENT '阅读量' AFTER featured;
