-- CursorOnlineShoppingMall 初始化演示数据。
-- 依赖 schema.sql；密码示例为明文 "123456" 的 SHA-256 十六进制（仅演示）。
-- （由 Curosr 自动生成）

USE cursor_online_shopping_mall;

-- 演示用户：username=demo / password=123456
-- SHA-256("123456") = 8d969eef6ecad3c29a3a629280e686cf0c3f5d5a86aff3ca12020c923adc6c92
INSERT INTO mall_user (id, username, password_hash, email, nickname, avatar_url, status)
VALUES
  (1, 'demo', '8d969eef6ecad3c29a3a629280e686cf0c3f5d5a86aff3ca12020c923adc6c92',
   'demo@example.com', '演示用户', '/images/avatar-default.png', 1)
ON DUPLICATE KEY UPDATE username = VALUES(username);

INSERT INTO mall_banner (id, image_url, link_url, sort_order, status)
VALUES
  (1, '/images/banner1.jpg', '/product/101', 1, 1),
  (2, '/images/banner2.jpg', '/product/102', 2, 1)
ON DUPLICATE KEY UPDATE image_url = VALUES(image_url);

INSERT INTO mall_category (id, name, image_url, sort_order, status)
VALUES
  (1, '手机数码', '/images/c1.jpg', 1, 1),
  (2, '家用电器', '/images/c2.jpg', 2, 1),
  (3, '服装鞋帽', '/images/c3.jpg', 3, 1)
ON DUPLICATE KEY UPDATE name = VALUES(name);

INSERT INTO mall_product (id, category_id, name, image_url, price, stock, description, recommend, status)
VALUES
  (101, 1, '无线耳机', '/images/p101.jpg', 199.00, 36, '降噪无线蓝牙耳机', 1, 1),
  (102, 1, '充电宝', '/images/p102.jpg', 89.00, 80, '20000mAh 快充移动电源', 1, 1),
  (201, 1, '手机壳', '/images/p201.jpg', 29.90, 100, '透明防摔手机壳', 0, 1),
  (202, 1, '数据线', '/images/p202.jpg', 19.90, 200, 'Type-C 快充线', 0, 1),
  (301, 2, '电热水壶', '/images/p301.jpg', 129.00, 45, '1.7L 自动断电', 1, 1),
  (302, 2, '空气净化器', '/images/p302.jpg', 899.00, 12, '家用除甲醛净化器', 0, 1),
  (401, 3, '运动外套', '/images/p401.jpg', 259.00, 60, '轻薄防风运动外套', 0, 1)
ON DUPLICATE KEY UPDATE name = VALUES(name);

INSERT INTO mall_user_address (id, user_id, receiver_name, phone, detail_address, default_address)
VALUES
  (11, 1, '张三', '13800000000', '北京市朝阳区望京街道××号', 1)
ON DUPLICATE KEY UPDATE receiver_name = VALUES(receiver_name);
