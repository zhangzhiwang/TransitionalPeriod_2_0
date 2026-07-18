-- CursorWebsite 表结构。
-- 使用前请先创建：CREATE DATABASE IF NOT EXISTS cursor_website DEFAULT CHARACTER SET utf8mb4;
-- （由 Curosr 自动生成）

CREATE TABLE IF NOT EXISTS site_config (
  id            BIGINT       NOT NULL AUTO_INCREMENT COMMENT '主键',
  config_key    VARCHAR(100) NOT NULL COMMENT '配置键',
  config_value  VARCHAR(2000) NOT NULL COMMENT '配置值',
  PRIMARY KEY (id),
  UNIQUE KEY uk_site_config_key (config_key)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='站点键值配置';

CREATE TABLE IF NOT EXISTS home_feature (
  id            BIGINT       NOT NULL AUTO_INCREMENT COMMENT '主键',
  title         VARCHAR(100) NOT NULL COMMENT '亮点标题',
  description   VARCHAR(500) NOT NULL COMMENT '亮点说明',
  image_url     VARCHAR(500) NOT NULL COMMENT '意象图 URL',
  dark          TINYINT(1)   NOT NULL DEFAULT 0 COMMENT '是否深色背景：1是0否',
  sort_order    INT          NOT NULL DEFAULT 0 COMMENT '排序，越小越靠前',
  status        VARCHAR(20)  NOT NULL DEFAULT 'published' COMMENT '状态 draft/published',
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='首页产品亮点';

CREATE TABLE IF NOT EXISTS news (
  id            BIGINT       NOT NULL AUTO_INCREMENT COMMENT '主键',
  title         VARCHAR(200) NOT NULL COMMENT '标题',
  summary       VARCHAR(500) NOT NULL COMMENT '摘要',
  cover_url     VARCHAR(500) DEFAULT NULL COMMENT '封面图',
  category      VARCHAR(50)  NOT NULL COMMENT '分类',
  author        VARCHAR(50)  DEFAULT NULL COMMENT '作者',
  content       MEDIUMTEXT   COMMENT '正文 HTML',
  featured      TINYINT(1)   NOT NULL DEFAULT 0 COMMENT '是否头条：1是0否',
  view_count    INT          NOT NULL DEFAULT 0 COMMENT '阅读量',
  publish_date  DATE         NOT NULL COMMENT '发布日期',
  status        VARCHAR(20)  NOT NULL DEFAULT 'draft' COMMENT '状态 draft/published',
  PRIMARY KEY (id),
  KEY idx_news_status_date (status, publish_date),
  KEY idx_news_category (category),
  KEY idx_news_featured (featured)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='新闻';

CREATE TABLE IF NOT EXISTS guestbook (
  id            BIGINT       NOT NULL AUTO_INCREMENT COMMENT '主键',
  nickname      VARCHAR(50)  NOT NULL COMMENT '昵称',
  email         VARCHAR(100) DEFAULT NULL COMMENT '邮箱（不公开）',
  content       VARCHAR(1000) NOT NULL COMMENT '留言正文',
  reply         VARCHAR(1000) DEFAULT NULL COMMENT '管理员回复',
  reply_time    DATETIME     DEFAULT NULL COMMENT '回复时间',
  client_ip     VARCHAR(64)  DEFAULT NULL COMMENT '提交 IP',
  status        VARCHAR(20)  NOT NULL DEFAULT 'pending' COMMENT 'pending/approved/rejected',
  created_at    DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (id),
  KEY idx_guestbook_status_time (status, created_at)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='网站留言';
