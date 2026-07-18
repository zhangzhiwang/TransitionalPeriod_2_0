-- CursorOnlineShoppingMall 表结构。
-- 库名：cursor_online_shopping_mall（模块名 CursorOnlineShoppingMall 的下划线形式）。
-- 使用前请先执行：
--   CREATE DATABASE IF NOT EXISTS cursor_online_shopping_mall
--     DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
-- （由 Curosr 自动生成）

USE cursor_online_shopping_mall;

-- ---------------------------------------------------------------------------
-- 用户表：账号密码登录 + 可选微信绑定（头像/昵称）
-- ---------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS mall_user (
  id              BIGINT       NOT NULL AUTO_INCREMENT COMMENT '主键',
  username        VARCHAR(50)  NOT NULL COMMENT '登录用户名，唯一',
  password_hash   VARCHAR(128) NOT NULL COMMENT '密码密文（MD5/SHA 等，禁止明文）',
  email           VARCHAR(100) NOT NULL COMMENT '注册邮箱，用于异步发送注册成功邮件',
  nickname        VARCHAR(100) DEFAULT NULL COMMENT '昵称（可来自微信授权）',
  avatar_url      VARCHAR(500) DEFAULT NULL COMMENT '头像 URL（可来自微信授权）',
  wechat_openid   VARCHAR(64)  DEFAULT NULL COMMENT '微信 openid，可空',
  status          TINYINT      NOT NULL DEFAULT 1 COMMENT '状态：1正常 0禁用',
  created_at      DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  updated_at      DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (id),
  UNIQUE KEY uk_mall_user_username (username),
  UNIQUE KEY uk_mall_user_email (email),
  UNIQUE KEY uk_mall_user_wechat_openid (wechat_openid)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='商城用户';

-- ---------------------------------------------------------------------------
-- 首页轮播图
-- ---------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS mall_banner (
  id              BIGINT       NOT NULL AUTO_INCREMENT COMMENT '主键',
  image_url       VARCHAR(500) NOT NULL COMMENT '轮播图片 URL',
  link_url        VARCHAR(500) DEFAULT NULL COMMENT '点击跳转链接',
  sort_order      INT          NOT NULL DEFAULT 0 COMMENT '排序，越小越靠前',
  status          TINYINT      NOT NULL DEFAULT 1 COMMENT '状态：1启用 0停用',
  created_at      DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  updated_at      DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (id),
  KEY idx_mall_banner_status_sort (status, sort_order)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='首页轮播图';

-- ---------------------------------------------------------------------------
-- 商品分类
-- ---------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS mall_category (
  id              BIGINT       NOT NULL AUTO_INCREMENT COMMENT '主键',
  name            VARCHAR(100) NOT NULL COMMENT '分类名称',
  image_url       VARCHAR(500) DEFAULT NULL COMMENT '分类图片 URL',
  sort_order      INT          NOT NULL DEFAULT 0 COMMENT '排序，越小越靠前',
  status          TINYINT      NOT NULL DEFAULT 1 COMMENT '状态：1启用 0停用',
  created_at      DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  updated_at      DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (id),
  KEY idx_mall_category_status_sort (status, sort_order)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='商品分类';

-- ---------------------------------------------------------------------------
-- 商品
-- ---------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS mall_product (
  id              BIGINT         NOT NULL AUTO_INCREMENT COMMENT '主键',
  category_id     BIGINT         NOT NULL COMMENT '所属分类 ID',
  name            VARCHAR(200)   NOT NULL COMMENT '商品名称',
  image_url       VARCHAR(500)   NOT NULL COMMENT '商品主图 URL',
  price           DECIMAL(10, 2) NOT NULL COMMENT '售价',
  stock           INT            NOT NULL DEFAULT 0 COMMENT '库存数量',
  description     TEXT           DEFAULT NULL COMMENT '商品详情描述',
  recommend       TINYINT        NOT NULL DEFAULT 0 COMMENT '是否首页推荐：1是 0否',
  status          TINYINT        NOT NULL DEFAULT 1 COMMENT '状态：1上架 0下架',
  created_at      DATETIME       NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  updated_at      DATETIME       NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (id),
  KEY idx_mall_product_category (category_id),
  KEY idx_mall_product_recommend (recommend, status),
  KEY idx_mall_product_status (status),
  CONSTRAINT fk_mall_product_category
    FOREIGN KEY (category_id) REFERENCES mall_category (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='商品';

-- ---------------------------------------------------------------------------
-- 购物车明细（同一用户同一商品唯一一行，数量累加）
-- ---------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS mall_cart_item (
  id              BIGINT       NOT NULL AUTO_INCREMENT COMMENT '主键',
  user_id         BIGINT       NOT NULL COMMENT '用户 ID',
  product_id      BIGINT       NOT NULL COMMENT '商品 ID',
  quantity        INT          NOT NULL DEFAULT 1 COMMENT '购买数量',
  selected        TINYINT      NOT NULL DEFAULT 1 COMMENT '是否勾选：1是 0否',
  created_at      DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  updated_at      DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (id),
  UNIQUE KEY uk_mall_cart_user_product (user_id, product_id),
  KEY idx_mall_cart_user (user_id),
  CONSTRAINT fk_mall_cart_user
    FOREIGN KEY (user_id) REFERENCES mall_user (id),
  CONSTRAINT fk_mall_cart_product
    FOREIGN KEY (product_id) REFERENCES mall_product (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='购物车明细';

-- ---------------------------------------------------------------------------
-- 收货地址
-- ---------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS mall_user_address (
  id                BIGINT       NOT NULL AUTO_INCREMENT COMMENT '主键',
  user_id           BIGINT       NOT NULL COMMENT '用户 ID',
  receiver_name     VARCHAR(50)  NOT NULL COMMENT '收货人',
  phone             VARCHAR(20)  NOT NULL COMMENT '联系电话',
  detail_address    VARCHAR(500) NOT NULL COMMENT '详细收货地址',
  default_address   TINYINT      NOT NULL DEFAULT 0 COMMENT '是否默认：1是 0否（同一用户最多一条为 1）',
  created_at        DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  updated_at        DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (id),
  KEY idx_mall_address_user (user_id),
  KEY idx_mall_address_user_default (user_id, default_address),
  CONSTRAINT fk_mall_address_user
    FOREIGN KEY (user_id) REFERENCES mall_user (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户收货地址';

-- ---------------------------------------------------------------------------
-- 订单主表（order 为 MySQL 保留字，使用 mall_order）
-- 收货信息下单时快照，避免地址后续修改影响历史订单展示
-- ---------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS mall_order (
  id                  BIGINT         NOT NULL AUTO_INCREMENT COMMENT '主键',
  order_no            VARCHAR(32)    NOT NULL COMMENT '业务订单号，唯一',
  user_id             BIGINT         NOT NULL COMMENT '下单用户 ID',
  status              VARCHAR(20)    NOT NULL DEFAULT 'PENDING_PAY' COMMENT 'PENDING_PAY/PAID/CANCELLED/CLOSED',
  total_amount        DECIMAL(10, 2) NOT NULL COMMENT '订单总金额',
  address_id          BIGINT         DEFAULT NULL COMMENT '下单时选用的地址 ID（可空，仅追溯）',
  receiver_name       VARCHAR(50)    NOT NULL COMMENT '收货人快照',
  phone               VARCHAR(20)    NOT NULL COMMENT '联系电话快照',
  detail_address      VARCHAR(500)   NOT NULL COMMENT '收货地址快照',
  pay_time            DATETIME       DEFAULT NULL COMMENT '支付成功时间',
  wechat_prepay_id    VARCHAR(64)    DEFAULT NULL COMMENT '微信预支付 ID',
  wechat_transaction_id VARCHAR(64)  DEFAULT NULL COMMENT '微信支付交易号',
  created_at          DATETIME       NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '下单时间',
  updated_at          DATETIME       NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (id),
  UNIQUE KEY uk_mall_order_no (order_no),
  KEY idx_mall_order_user_time (user_id, created_at),
  KEY idx_mall_order_status (status),
  CONSTRAINT fk_mall_order_user
    FOREIGN KEY (user_id) REFERENCES mall_user (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='订单主表';

-- ---------------------------------------------------------------------------
-- 订单明细（商品名称/图片/单价快照）
-- ---------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS mall_order_item (
  id              BIGINT         NOT NULL AUTO_INCREMENT COMMENT '主键',
  order_id        BIGINT         NOT NULL COMMENT '订单 ID',
  product_id      BIGINT         NOT NULL COMMENT '商品 ID',
  product_name    VARCHAR(200)   NOT NULL COMMENT '商品名称快照',
  product_image   VARCHAR(500)   NOT NULL COMMENT '商品图片快照',
  unit_price      DECIMAL(10, 2) NOT NULL COMMENT '成交单价快照',
  quantity        INT            NOT NULL COMMENT '购买数量',
  subtotal        DECIMAL(10, 2) NOT NULL COMMENT '小计金额',
  created_at      DATETIME       NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (id),
  KEY idx_mall_order_item_order (order_id),
  KEY idx_mall_order_item_product (product_id),
  CONSTRAINT fk_mall_order_item_order
    FOREIGN KEY (order_id) REFERENCES mall_order (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='订单明细';
