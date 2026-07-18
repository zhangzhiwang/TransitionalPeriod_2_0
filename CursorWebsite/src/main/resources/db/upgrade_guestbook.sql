-- 已有库升级：创建网站留言表（可重复执行）。
-- （由 Curosr 自动生成）

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
