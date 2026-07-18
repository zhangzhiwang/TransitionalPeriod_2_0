-- CursorWebsite 表结构（依据：网站功能规划、网站技术架构文档、网站设计图）。
-- 库名：cursor_website（模块名 CursorWebsite 的下划线形式）。
-- 使用前请先执行：
--   CREATE DATABASE IF NOT EXISTS cursor_website
--     DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
-- （由 Curosr 自动生成）

USE cursor_website;

-- ---------------------------------------------------------------------------
-- 站点键值配置：首页文案、联系方式等
-- ---------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS site_config (
  id            BIGINT       NOT NULL AUTO_INCREMENT COMMENT '主键',
  config_key    VARCHAR(100) NOT NULL COMMENT '配置键',
  config_value  VARCHAR(2000) NOT NULL COMMENT '配置值',
  PRIMARY KEY (id),
  UNIQUE KEY uk_site_config_key (config_key)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='站点键值配置';

-- ---------------------------------------------------------------------------
-- 首页产品亮点区块
-- ---------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS home_feature (
  id            BIGINT       NOT NULL AUTO_INCREMENT COMMENT '主键',
  title         VARCHAR(100) NOT NULL COMMENT '亮点标题',
  description   VARCHAR(500) NOT NULL COMMENT '亮点说明',
  image_url     VARCHAR(500) NOT NULL COMMENT '意象图 URL',
  dark          TINYINT(1)   NOT NULL DEFAULT 0 COMMENT '是否深色背景：1是0否',
  sort_order    INT          NOT NULL DEFAULT 0 COMMENT '排序，越小越靠前',
  status        VARCHAR(20)  NOT NULL DEFAULT 'published' COMMENT '状态 draft/published',
  PRIMARY KEY (id),
  KEY idx_home_feature_status_sort (status, sort_order)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='首页产品亮点';

-- ---------------------------------------------------------------------------
-- 关于我们：章节内容（Hero / 故事 / 理念 / 团队等）
-- ---------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS about_section (
  id            BIGINT       NOT NULL AUTO_INCREMENT COMMENT '主键',
  section_key   VARCHAR(50)  NOT NULL COMMENT '章节键：hero/story/value/team 等',
  title         VARCHAR(200) NOT NULL COMMENT '章节标题',
  subtitle      VARCHAR(500) DEFAULT NULL COMMENT '副标题或短说明',
  content       MEDIUMTEXT   DEFAULT NULL COMMENT '正文 HTML 或长文',
  image_url     VARCHAR(500) DEFAULT NULL COMMENT '配图 URL',
  sort_order    INT          NOT NULL DEFAULT 0 COMMENT '排序，越小越靠前',
  status        VARCHAR(20)  NOT NULL DEFAULT 'published' COMMENT '状态 draft/published',
  PRIMARY KEY (id),
  KEY idx_about_section_key_sort (section_key, sort_order),
  KEY idx_about_section_status (status)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='关于我们章节';

-- ---------------------------------------------------------------------------
-- 关于我们：发展历程时间轴
-- ---------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS about_timeline (
  id            BIGINT       NOT NULL AUTO_INCREMENT COMMENT '主键',
  event_year    VARCHAR(20)  NOT NULL COMMENT '年份或时间标签，如 2018',
  title         VARCHAR(200) NOT NULL COMMENT '节点标题',
  description   VARCHAR(500) DEFAULT NULL COMMENT '一句话说明',
  sort_order    INT          NOT NULL DEFAULT 0 COMMENT '排序，越小越靠前',
  status        VARCHAR(20)  NOT NULL DEFAULT 'published' COMMENT '状态 draft/published',
  PRIMARY KEY (id),
  KEY idx_about_timeline_status_sort (status, sort_order)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='关于我们发展历程';

-- ---------------------------------------------------------------------------
-- 产品中心
-- ---------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS product (
  id            BIGINT       NOT NULL AUTO_INCREMENT COMMENT '主键',
  name          VARCHAR(200) NOT NULL COMMENT '产品名称',
  slogan        VARCHAR(300) DEFAULT NULL COMMENT '一句卖点/定位',
  category      VARCHAR(100) DEFAULT NULL COMMENT '产品线/品类名称',
  cover_url     VARCHAR(500) DEFAULT NULL COMMENT '列表封面图',
  hero_url      VARCHAR(500) DEFAULT NULL COMMENT '详情全宽主视觉',
  summary       VARCHAR(1000) DEFAULT NULL COMMENT '列表摘要',
  content       MEDIUMTEXT   DEFAULT NULL COMMENT '详情正文 HTML',
  features_json MEDIUMTEXT   DEFAULT NULL COMMENT '特性卷轴 JSON 数组：[{title,desc,imageUrl}]',
  specs_json    MEDIUMTEXT   DEFAULT NULL COMMENT '技术规格 JSON：[{name,value}]',
  featured      TINYINT(1)   NOT NULL DEFAULT 0 COMMENT '是否旗舰/重点展示：1是0否',
  sort_order    INT          NOT NULL DEFAULT 0 COMMENT '排序，越小越靠前',
  status        VARCHAR(20)  NOT NULL DEFAULT 'draft' COMMENT '状态 draft/published',
  created_at    DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  updated_at    DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (id),
  KEY idx_product_status_sort (status, sort_order),
  KEY idx_product_category (category),
  KEY idx_product_featured (featured)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='产品';

-- ---------------------------------------------------------------------------
-- 新闻中心
-- ---------------------------------------------------------------------------
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

-- ---------------------------------------------------------------------------
-- 联系我们：咨询表单（与 guestbook 分表）
-- ---------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS contact_message (
  id            BIGINT       NOT NULL AUTO_INCREMENT COMMENT '主键',
  name          VARCHAR(50)  NOT NULL COMMENT '姓名',
  email         VARCHAR(100) NOT NULL COMMENT '邮箱',
  subject       VARCHAR(200) DEFAULT NULL COMMENT '主题',
  content       VARCHAR(2000) NOT NULL COMMENT '留言内容',
  client_ip     VARCHAR(64)  DEFAULT NULL COMMENT '提交 IP',
  status        VARCHAR(20)  NOT NULL DEFAULT 'pending' COMMENT 'pending/processed/closed',
  created_at    DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (id),
  KEY idx_contact_message_status_time (status, created_at)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='联系我们咨询';

-- ---------------------------------------------------------------------------
-- 加入我们：开放职位
-- ---------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS job (
  id            BIGINT       NOT NULL AUTO_INCREMENT COMMENT '主键',
  title         VARCHAR(200) NOT NULL COMMENT '职位名称',
  location      VARCHAR(100) DEFAULT NULL COMMENT '工作地点',
  job_type      VARCHAR(50)  DEFAULT NULL COMMENT '类型：全职/兼职/实习等',
  summary       VARCHAR(500) DEFAULT NULL COMMENT '列表一句话说明',
  responsibilities MEDIUMTEXT DEFAULT NULL COMMENT '岗位职责 HTML',
  requirements  MEDIUMTEXT   DEFAULT NULL COMMENT '任职要求 HTML',
  sort_order    INT          NOT NULL DEFAULT 0 COMMENT '排序，越小越靠前',
  status        VARCHAR(20)  NOT NULL DEFAULT 'draft' COMMENT '状态 draft/published/closed',
  created_at    DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  updated_at    DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (id),
  KEY idx_job_status_sort (status, sort_order)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='招聘职位';

-- ---------------------------------------------------------------------------
-- 加入我们：简历投递
-- ---------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS job_application (
  id            BIGINT       NOT NULL AUTO_INCREMENT COMMENT '主键',
  job_id        BIGINT       NOT NULL COMMENT '职位 ID',
  applicant_name VARCHAR(50) NOT NULL COMMENT '应聘人姓名',
  email         VARCHAR(100) NOT NULL COMMENT '邮箱',
  phone         VARCHAR(30)  DEFAULT NULL COMMENT '电话',
  resume_path   VARCHAR(500) NOT NULL COMMENT '简历文件存储路径',
  intro         VARCHAR(1000) DEFAULT NULL COMMENT '简短自荐',
  client_ip     VARCHAR(64)  DEFAULT NULL COMMENT '提交 IP',
  status        VARCHAR(20)  NOT NULL DEFAULT 'pending' COMMENT 'pending/reviewed/rejected/hired',
  created_at    DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '投递时间',
  PRIMARY KEY (id),
  KEY idx_job_application_job (job_id),
  KEY idx_job_application_status_time (status, created_at)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='职位投递记录';

-- ---------------------------------------------------------------------------
-- 友情链接（含申请待审）
-- ---------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS friend_link (
  id            BIGINT       NOT NULL AUTO_INCREMENT COMMENT '主键',
  site_name     VARCHAR(100) NOT NULL COMMENT '站点名称',
  site_url      VARCHAR(500) NOT NULL COMMENT '站点 URL',
  summary       VARCHAR(300) DEFAULT NULL COMMENT '一句话简介',
  group_name    VARCHAR(50)  DEFAULT NULL COMMENT '分组：合作伙伴/行业资源等',
  contact_email VARCHAR(100) DEFAULT NULL COMMENT '申请联系邮箱',
  sort_order    INT          NOT NULL DEFAULT 0 COMMENT '排序，越小越靠前',
  status        VARCHAR(20)  NOT NULL DEFAULT 'pending' COMMENT 'pending/published/rejected',
  created_at    DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建/申请时间',
  PRIMARY KEY (id),
  KEY idx_friend_link_status_group (status, group_name, sort_order)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='友情链接';

-- ---------------------------------------------------------------------------
-- 网站统计：按日按页面 PV 汇总（不做 IP 明细）
-- ---------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS page_view_daily (
  id            BIGINT       NOT NULL AUTO_INCREMENT COMMENT '主键',
  view_date     DATE         NOT NULL COMMENT '统计日期',
  page_path     VARCHAR(200) NOT NULL COMMENT '页面路径，如 / 或 /products.jsp',
  page_title    VARCHAR(100) DEFAULT NULL COMMENT '页面标题，便于热门列表展示',
  pv_count      INT          NOT NULL DEFAULT 0 COMMENT '当日 PV',
  PRIMARY KEY (id),
  UNIQUE KEY uk_page_view_daily (view_date, page_path),
  KEY idx_page_view_daily_date (view_date),
  KEY idx_page_view_daily_path (page_path)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='页面访问按日汇总';

-- ---------------------------------------------------------------------------
-- 网站留言板（审核后公开）
-- ---------------------------------------------------------------------------
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
