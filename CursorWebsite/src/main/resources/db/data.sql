-- CursorWebsite 初始数据（可重复执行，键冲突则忽略）。
-- （由 Curosr 自动生成）

truncate table site_config;
truncate table home_feature;
truncate table news;
truncate table guestbook;
INSERT IGNORE INTO site_config (id, config_key, config_value) VALUES
(1, 'home.brandName', '曜岩智造'),
(2, 'home.heroHeadline', '精密制造，定义下一程。'),
(3, 'home.heroSubtitle', '以工业软件与智能装备，把产线效率做得可见、可控、可进化。'),
(4, 'home.heroImageUrl', 'https://images.unsplash.com/photo-1565043666747-69f6646db940?auto=format&fit=crop&w=2000&q=80');

INSERT IGNORE INTO home_feature (id, title, description, image_url, dark, sort_order, status) VALUES
(1, '柔性产线', '模块化单元快速重组，一键切换多品类生产节拍。',
 'https://images.unsplash.com/photo-1581092918056-0c4c3acd3789?auto=format&fit=crop&w=2000&q=80', 1, 1, 'published'),
(2, '数字孪生', '产线状态实时镜像，异常在发生前被看见。',
 'https://images.unsplash.com/photo-1518770660439-4636190af475?auto=format&fit=crop&w=2000&q=80', 0, 2, 'published'),
(3, '闭环质检', '视觉与数据闭环联动，把良率提升写进每一道工序。',
 'https://images.unsplash.com/photo-1581092160562-40aa08e78837?auto=format&fit=crop&w=2000&q=80', 1, 3, 'published');

INSERT IGNORE INTO news (id, title, summary, cover_url, category, author, content, featured, view_count, publish_date, status) VALUES
(1, '精密产线升级完成', '新一代柔性装配线投入试运行，节拍提升 18%。',
 'https://images.unsplash.com/photo-1581091226825-a6a2a5aee158?auto=format&fit=crop&w=1600&q=80',
 '公司动态', '曜岩智造',
 '<p>曜岩智造宣布新一代柔性装配线完成升级并进入试运行阶段。通过模块化工位与数字孪生联动，产线换型时间显著缩短，综合节拍提升约 18%。</p><p>本次升级覆盖视觉引导、力矩监控与质量闭环三个核心能力，已在试点工厂稳定运行四周。</p>',
 1, 128, '2026-07-10', 'published'),
(2, '智慧质检方案正式发布', '视觉检测与边缘计算结合，缺陷识别更稳、更准。',
 'https://images.unsplash.com/photo-1518770660439-4636190af475?auto=format&fit=crop&w=1600&q=80',
 '产品发布', '产品团队',
 '<p>智慧质检 2.0 现已面向客户开放。方案将多光谱视觉与边缘推理结合，在线检出率与误报控制均达到产线可量产标准。</p><p>客户可按工位灵活部署，并与现有 MES 完成结果回传。</p>',
 0, 86, '2026-07-05', 'published'),
(3, '工业软件趋势观察：从可见到可控', '数字孪生正从演示走向产线决策中枢。',
 'https://images.unsplash.com/photo-1581092160562-40aa08e78837?auto=format&fit=crop&w=1600&q=80',
 '行业洞察', '研究中心',
 '<p>过去一年，越来越多制造企业把数字孪生从“可视化大屏”推进到“可决策系统”。关键不在模型漂亮，而在数据闭环是否足够短。</p><p>我们观察到，质检、能耗与排程三类场景最先产生可量化收益。</p>',
 0, 64, '2026-06-28', 'published'),
(4, '草稿新闻不展示', '该条为草稿，前台列表不应出现。',
 '', '内部', '编辑部', '<p>草稿内容。</p>', 0, 0, '2026-06-01', 'draft'),
(5, '联合实验室揭牌成立', '与高校共建工业软件与数字孪生联合实验室。',
 'https://images.unsplash.com/photo-1565043666747-69f6646db940?auto=format&fit=crop&w=1600&q=80',
 '公司动态', '品牌公关',
 '<p>曜岩智造与合作高校正式揭牌联合实验室，聚焦工业软件、数字孪生与智能质检方向的产学研协同。</p><p>首批课题已启动，预计年内完成两项原型验证。</p>',
 0, 45, '2026-06-20', 'published'),
(6, '边缘网关 3.0 上线', '更轻量的边缘接入，让设备数据更快进入决策链路。',
 'https://images.unsplash.com/photo-1581092918056-0c4c3acd3789?auto=format&fit=crop&w=1600&q=80',
 '产品发布', '产品团队',
 '<p>边缘网关 3.0 支持更多工业协议与本地规则引擎，可在弱网环境下完成关键事件上报与缓存。</p>',
 0, 52, '2026-06-12', 'published');

INSERT IGNORE INTO guestbook (id, nickname, email, content, reply, reply_time, client_ip, status, created_at) VALUES
(1, '阿凯', NULL, '产线升级后节拍明显更稳，期待数字孪生更多案例分享。',
 '感谢认可，后续会持续更新实践文章。', '2026-07-12 10:20:00', '127.0.0.1', 'approved', '2026-07-11 09:15:00'),
(2, '林晓', 'demo@example.com', '智慧质检方案介绍很清晰，想了解边缘部署的硬件要求。',
 NULL, NULL, '127.0.0.1', 'approved', '2026-07-10 14:30:00'),
(3, '访客小周', NULL, '官网风格很干净，留言板也很好用。',
 NULL, NULL, '127.0.0.1', 'approved', '2026-07-08 18:05:00'),
(4, '待审用户', 'pending@example.com', '这条不应出现在前台列表。',
 NULL, NULL, '127.0.0.1', 'pending', '2026-07-16 11:00:00');
