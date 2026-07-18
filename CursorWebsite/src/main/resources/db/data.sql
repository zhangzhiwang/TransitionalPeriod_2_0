-- CursorWebsite 初始数据（可重复执行：先清空再插入）。
-- 依赖 schema.sql；网站地图无独立业务表，不灌数。
-- （由 Curosr 自动生成）

USE cursor_website;

SET FOREIGN_KEY_CHECKS = 0;
TRUNCATE TABLE job_application;
TRUNCATE TABLE page_view_daily;
TRUNCATE TABLE friend_link;
TRUNCATE TABLE contact_message;
TRUNCATE TABLE job;
TRUNCATE TABLE product;
TRUNCATE TABLE about_timeline;
TRUNCATE TABLE about_section;
TRUNCATE TABLE guestbook;
TRUNCATE TABLE news;
TRUNCATE TABLE home_feature;
TRUNCATE TABLE site_config;
SET FOREIGN_KEY_CHECKS = 1;

-- 站点配置：首页 + 联系我们
INSERT INTO site_config (id, config_key, config_value) VALUES
(1, 'home.brandName', '曜岩智造'),
(2, 'home.heroHeadline', '精密制造，定义下一程。'),
(3, 'home.heroSubtitle', '以工业软件与智能装备，把产线效率做得可见、可控、可进化。'),
(4, 'home.heroImageUrl', 'https://images.unsplash.com/photo-1565043666747-69f6646db940?auto=format&fit=crop&w=2000&q=80'),
(5, 'contact.phone', '+86 400-800-0000'),
(6, 'contact.email', 'hello@yaoyan.example'),
(7, 'contact.address', '上海市浦东新区张江高科技园区××路××号'),
(8, 'contact.workTime', '工作日 9:00–18:00');

INSERT INTO home_feature (id, title, description, image_url, dark, sort_order, status) VALUES
(1, '柔性产线', '模块化单元快速重组，一键切换多品类生产节拍。',
 'https://images.unsplash.com/photo-1581092918056-0c4c3acd3789?auto=format&fit=crop&w=2000&q=80', 1, 1, 'published'),
(2, '数字孪生', '产线状态实时镜像，异常在发生前被看见。',
 'https://images.unsplash.com/photo-1518770660439-4636190af475?auto=format&fit=crop&w=2000&q=80', 0, 2, 'published'),
(3, '闭环质检', '视觉与数据闭环联动，把良率提升写进每一道工序。',
 'https://images.unsplash.com/photo-1581092160562-40aa08e78837?auto=format&fit=crop&w=2000&q=80', 1, 3, 'published');

INSERT INTO about_section (id, section_key, title, subtitle, content, image_url, sort_order, status) VALUES
(1, 'hero', '关于我们', '以工程克制，做长期正确的事。', NULL,
 'https://images.unsplash.com/photo-1565043666747-69f6646db940?auto=format&fit=crop&w=2000&q=80', 1, 'published'),
(2, 'story', '我们的故事', NULL,
 '<p>曜岩智造专注工业软件与智能装备，帮助制造企业把产线从“看得见”做到“管得住”。</p>',
 'https://images.unsplash.com/photo-1581091226825-a6a2a5aee158?auto=format&fit=crop&w=1200&q=80', 2, 'published'),
(3, 'value', '专注', '把一件难而正确的事做深。', NULL, NULL, 3, 'published'),
(4, 'value', '诚实', '用数据说话，不为演示牺牲现场。', NULL, NULL, 4, 'published'),
(5, 'value', '长期', '与客户一起迭代，而不是一次性交付。', NULL, NULL, 5, 'published'),
(6, 'team', '团队', '工程师文化，现场优先。',
 '<p>产品、算法与交付一体协作，让方案在产线上真正跑起来。</p>',
 'https://images.unsplash.com/photo-1522071820081-009f0129c71c?auto=format&fit=crop&w=2000&q=80', 6, 'published');

INSERT INTO about_timeline (id, event_year, title, description, sort_order, status) VALUES
(1, '2018', '公司成立', '团队从产线数字化项目起步。', 1, 'published'),
(2, '2021', '数字孪生产品化', '首个可量产孪生平台发布。', 2, 'published'),
(3, '2024', '智慧质检规模化', '多工厂复制落地。', 3, 'published'),
(4, '2026', '联合实验室', '与高校共建工业软件实验室。', 4, 'published');

INSERT INTO product (id, name, slogan, category, cover_url, hero_url, summary, content, features_json, specs_json, featured, sort_order, status) VALUES
(1, '柔性装配线', '换型更快，节拍更稳。', '智能装备',
 'https://images.unsplash.com/photo-1581092918056-0c4c3acd3789?auto=format&fit=crop&w=1200&q=80',
 'https://images.unsplash.com/photo-1581092918056-0c4c3acd3789?auto=format&fit=crop&w=2000&q=80',
 '模块化工位，支持多品类快速切换。',
 '<p>面向离散制造的柔性装配解决方案。</p>',
 '[{"title":"模块化工位","desc":"快速重组产线","imageUrl":""},{"title":"视觉引导","desc":"降低人工对位成本","imageUrl":""}]',
 '[{"name":"节拍","value":"可配置"},{"name":"换型时间","value":"分钟级"}]',
 1, 1, 'published'),
(2, '数字孪生平台', '产线状态，实时镜像。', '工业软件',
 'https://images.unsplash.com/photo-1518770660439-4636190af475?auto=format&fit=crop&w=1200&q=80',
 'https://images.unsplash.com/photo-1518770660439-4636190af475?auto=format&fit=crop&w=2000&q=80',
 '把设备与工艺数据汇成可决策的数字镜像。',
 '<p>支持异常预警与能耗可视。</p>',
 '[{"title":"实时镜像","desc":"秒级同步","imageUrl":""}]',
 '[{"name":"接入协议","value":"多协议"},{"name":"部署","value":"本地/云"}]',
 1, 2, 'published'),
(3, '智慧质检 2.0', '缺陷更早被看见。', '视觉质检',
 'https://images.unsplash.com/photo-1581092160562-40aa08e78837?auto=format&fit=crop&w=1200&q=80',
 'https://images.unsplash.com/photo-1581092160562-40aa08e78837?auto=format&fit=crop&w=2000&q=80',
 '多光谱视觉与边缘推理结合。',
 '<p>可与 MES 闭环回传检测结果。</p>',
 '[{"title":"边缘推理","desc":"弱网可用","imageUrl":""}]',
 '[{"name":"检出率","value":"量产级"},{"name":"误报控制","value":"可调"}]',
 0, 3, 'published');

INSERT INTO news (id, title, summary, cover_url, category, author, content, featured, view_count, publish_date, status) VALUES
(1, '精密产线升级完成', '新一代柔性装配线投入试运行，节拍提升 18%。',
 'https://images.unsplash.com/photo-1581091226825-a6a2a5aee158?auto=format&fit=crop&w=1600&q=80',
 '公司动态', '曜岩智造',
 '<p>曜岩智造宣布新一代柔性装配线完成升级并进入试运行阶段。</p>',
 1, 128, '2026-07-10', 'published'),
(2, '智慧质检方案正式发布', '视觉检测与边缘计算结合，缺陷识别更稳、更准。',
 'https://images.unsplash.com/photo-1518770660439-4636190af475?auto=format&fit=crop&w=1600&q=80',
 '产品发布', '产品团队',
 '<p>智慧质检 2.0 现已面向客户开放。</p>',
 0, 86, '2026-07-05', 'published'),
(3, '工业软件趋势观察：从可见到可控', '数字孪生正从演示走向产线决策中枢。',
 'https://images.unsplash.com/photo-1581092160562-40aa08e78837?auto=format&fit=crop&w=1600&q=80',
 '行业洞察', '研究中心',
 '<p>关键在数据闭环是否足够短。</p>',
 0, 64, '2026-06-28', 'published'),
(4, '草稿新闻不展示', '该条为草稿，前台列表不应出现。',
 '', '内部', '编辑部', '<p>草稿内容。</p>', 0, 0, '2026-06-01', 'draft'),
(5, '联合实验室揭牌成立', '与高校共建工业软件与数字孪生联合实验室。',
 'https://images.unsplash.com/photo-1565043666747-69f6646db940?auto=format&fit=crop&w=1600&q=80',
 '公司动态', '品牌公关',
 '<p>首批课题已启动。</p>',
 0, 45, '2026-06-20', 'published'),
(6, '边缘网关 3.0 上线', '更轻量的边缘接入，让设备数据更快进入决策链路。',
 'https://images.unsplash.com/photo-1581092918056-0c4c3acd3789?auto=format&fit=crop&w=1600&q=80',
 '产品发布', '产品团队',
 '<p>支持更多工业协议与本地规则引擎。</p>',
 0, 52, '2026-06-12', 'published');

INSERT INTO contact_message (id, name, email, subject, content, client_ip, status, created_at) VALUES
(1, '王工', 'wang@example.com', '柔性产线咨询', '希望了解换型方案与交付周期。', '127.0.0.1', 'pending', '2026-07-15 10:00:00');

INSERT INTO job (id, title, location, job_type, summary, responsibilities, requirements, sort_order, status) VALUES
(1, 'Java 后端工程师', '上海', '全职', '负责官网与工业软件后端服务。',
 '<ul><li>接口开发与数据建模</li><li>与前端/交付协作</li></ul>',
 '<ul><li>熟悉 Spring Boot / MyBatis</li><li>了解 MySQL</li></ul>',
 1, 'published'),
(2, '前端工程师（原生）', '上海', '全职', '负责苹果风格官网页面实现。',
 '<ul><li>JSP/HTML/CSS/原生 JS</li></ul>',
 '<ul><li>不依赖前端框架亦可高质量交付</li></ul>',
 2, 'published');

INSERT INTO friend_link (id, site_name, site_url, summary, group_name, contact_email, sort_order, status, created_at) VALUES
(1, '工业互联网产业联盟', 'https://example.com/aii', '产业资讯与标准跟踪', '行业资源', NULL, 1, 'published', '2026-01-01 00:00:00'),
(2, '张江高科', 'https://example.com/zj', '园区与生态伙伴', '合作伙伴', NULL, 2, 'published', '2026-01-01 00:00:00'),
(3, '待审站点', 'https://example.com/pending', '申请中的友链', '合作伙伴', 'apply@example.com', 99, 'pending', '2026-07-16 12:00:00');

-- 近 30 日部分演示 PV（供统计页）
INSERT INTO page_view_daily (view_date, page_path, page_title, pv_count) VALUES
(CURDATE(), '/', '首页', 120),
(CURDATE(), '/products.jsp', '产品中心', 80),
(CURDATE(), '/news.jsp', '新闻中心', 55),
(DATE_SUB(CURDATE(), INTERVAL 1 DAY), '/', '首页', 110),
(DATE_SUB(CURDATE(), INTERVAL 1 DAY), '/products.jsp', '产品中心', 70),
(DATE_SUB(CURDATE(), INTERVAL 2 DAY), '/', '首页', 95),
(DATE_SUB(CURDATE(), INTERVAL 2 DAY), '/about.jsp', '关于我们', 40);

INSERT INTO guestbook (id, nickname, email, content, reply, reply_time, client_ip, status, created_at) VALUES
(1, '阿凯', NULL, '产线升级后节拍明显更稳，期待数字孪生更多案例分享。',
 '感谢认可，后续会持续更新实践文章。', '2026-07-12 10:20:00', '127.0.0.1', 'approved', '2026-07-11 09:15:00'),
(2, '林晓', 'demo@example.com', '智慧质检方案介绍很清晰，想了解边缘部署的硬件要求。',
 NULL, NULL, '127.0.0.1', 'approved', '2026-07-10 14:30:00'),
(3, '访客小周', NULL, '官网风格很干净，留言板也很好用。',
 NULL, NULL, '127.0.0.1', 'approved', '2026-07-08 18:05:00'),
(4, '待审用户', 'pending@example.com', '这条不应出现在前台列表。',
 NULL, NULL, '127.0.0.1', 'pending', '2026-07-16 11:00:00');
