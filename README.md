# 会话总结日志

> 本文件由项目规则 `.cursor/rules/Readme.mdc` 要求累积追加（Append），记录各次会话摘要。  
> 路径：项目根目录 `README.md`

---

## 2026-07-16

### 会话的主要目的
- 继续 Cursor 学习，并将前一日相关代码推送到远程仓库
- 为企业官网增加多页面静态站点能力
- 澄清 Cursor Rules / Restore / 上下文容量等产品概念
- 落实“会话结束后写入 README 总结”的规则路径

### 完成的主要任务
1. **Git 提交与推送**
   - 本地已提交：微信登录示例迁移到 `cursor.wechat.website` 包
   - 推送曾因 HTTPS 凭据/403 失败；需用 PAT 或完善认证后在本机 `git push`
2. **企业官网（曜岩智造）**
   - 新建独立页面：首页、产品介绍、企业荣誉、联系我们
   - 共享样式与脚本，配置 `web.xml` 欢迎页为 `index.html`
3. **Cursor 学习答疑**
   - 上下文窗口有限，“近三个月全量会话”不现实，需检索/摘要
   - Restore：在 Agent 历史消息上悬停出现回退图标
   - User Rules vs Project Rules 存储位置差异
4. **会话总结落盘**
   - 确认规则文件在 `.cursor/rules/Readme.mdc`
   - 创建本 `README.md` 作为累积总结目标文件

### 关键决策和解决方案
- 官网品牌采用「曜岩智造」：深色精密制造风格（青绿强调），避免常见 AI 模板审美
- 联系页提供演示留言表单（前端拦截提交，未接后端）
- 会话总结明确写入**项目根目录 `README.md`**，与规则文件 `Readme.mdc` 区分开

### 使用的技术栈
- HTML / CSS / 原生 JavaScript（静态多页官网）
- Google Fonts（Noto Serif SC、Outfit）
- Maven Webapp 结构（`src/main/webapp`）
- Git / GitHub HTTPS 认证（PAT）
- Cursor Project Rules（`.cursor/rules/*.mdc`）

### 修改了哪些文件
- `src/main/webapp/index.html`（新建/更新导航与 CTA）
- `src/main/webapp/products.html`（新建）
- `src/main/webapp/honors.html`（新建）
- `src/main/webapp/contact.html`（新建）
- `src/main/webapp/css/style.css`（新建/扩展联系页样式）
- `src/main/webapp/js/main.js`（新建/增加联系表单逻辑）
- `src/main/webapp/WEB-INF/web.xml`（欢迎页配置）
- `.cursor/rules/Readme.mdc`（会话总结规则）
- `README.md`（本总结文件，新建并追加）
- 此前本地已提交：`src/main/java/cursor/wechat/website/*`（包迁移）

---
