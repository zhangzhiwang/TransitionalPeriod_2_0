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

## 2026-07-17

### 会话的主要目的
- 开启当日 Cursor 学习会话，衔接前一日进度

### 完成的主要任务
1. 问候并回顾 2026-07-16 已完成内容（官网、Rules/Restore、微信包迁移）
2. 提供今日可选学习方向，等待用户选定主题

### 关键决策和解决方案
- 先对齐昨日进度再选题，避免重复讲解已覆盖概念
- 学习路径建议：Cursor 进阶 / 项目实战 / Git·PR / 自由提问

### 使用的技术栈
- 无代码变更（会话开场与学习规划）

### 修改了哪些文件
- `README.md`（追加本日开场会话总结）

### 修改文件的目的是什么
- 按项目规则累积记录会话摘要，便于后续回顾学习轨迹

---

## 2026-07-17（续：YOLO Mode 位置答疑）

### 会话的主要目的
- 解答旧版「Enable yolo mode」在新版 Cursor 中的对应设置位置

### 完成的主要任务
1. 对照用户截图中的旧 Features 设置项
2. 说明 YOLO 已演进为 Run Mode / Auto-run，并给出新版入口与选项对照

### 关键决策和解决方案
- 旧 YOLO ≈ 新版 Run Mode 中的 **Run Everything**
- 推荐学习路径：先用 Auto-review（默认），需要完全无人值守再用 Run Everything
- 入口：Cursor Settings → Agents → Run Mode

### 使用的技术栈
- Cursor IDE 设置 / Agents Run Mode / permissions.json（文档层面说明）

### 修改了哪些文件
- `README.md`（追加本条答疑总结）

### 修改文件的目的是什么
- 按项目规则累积记录 Cursor 学习答疑，便于日后查阅

---

## 2026-07-17（续：沙箱概念答疑）

### 会话的主要目的
- 解释 Cursor Agent / Auto-review 语境下「沙箱（Sandbox）」的含义

### 完成的主要任务
1. 用通俗说法说明沙箱是受限执行环境
2. 结合 Run Mode（尤其 Auto-review）说明为何需要沙箱

### 关键决策和解决方案
- 沙箱 = 隔离 + 权限收紧，不是“不能执行”，而是“有限执行”
- 典型限制：工作区外写入、危险系统调用、未授权外网等需额外批准

### 使用的技术栈
- Cursor Agent Sandbox / Run Mode（概念说明，无代码变更）

### 修改了哪些文件
- `README.md`（追加本条答疑总结）

### 修改文件的目的是什么
- 按项目规则累积记录 Cursor 学习答疑

---

## 2026-07-17（续：生成 Dog 类）

### 会话的主要目的
- 在 `cursor` 包下生成带 Lombok 注解的 `Dog` 实体类

### 完成的主要任务
1. 新建 `Dog`：字段 name、age、weight、color、variety
2. 使用 `@Getter`、`@Setter`、`@NoArgsConstructor`、`@AllArgsConstructor`
3. 在根 `pom.xml` 增加 Lombok 依赖（此前项目未引入）

### 关键决策和解决方案
- 类放在与 `Cat` 同级的 `src/main/java/cursor`
- 同时提供无参/全参构造，便于序列化与对象创建
- weight 使用 `double`，age 使用 `int`

### 使用的技术栈
- Java 8、Lombok、Maven

### 修改了哪些文件
- `src/main/java/cursor/Dog.java`（新建）
- `pom.xml`（增加 lombok 依赖）
- `README.md`（追加本条总结）

### 修改文件的目的是什么
- 完成 Dog 实体与 Lombok 样板代码生成能力，并记录学习实践

---

## 2026-07-17（续：DogTest 验证 Lombok）

### 会话的主要目的
- 生成 `DogTest`，验证 `Dog` 上 Lombok 注解是否生效

### 完成的主要任务
1. 新建 `DogTest`：覆盖无参构造+setter/getter、全参构造+getter
2. 本地用 javac + Lombok 编译并运行，结果全部通过

### 关键决策和解决方案
- 沿用 `cursor` 包内 `main` 入口自测风格，便于在 IDEA 直接运行
- 校验失败抛 `AssertionError`，成功打印通过信息

### 使用的技术栈
- Java、Lombok、javac 本地编译验证

### 修改了哪些文件
- `src/main/java/cursor/DogTest.java`（新建）
- `README.md`（追加本条总结）

### 修改文件的目的是什么
- 用可运行测试确认 Lombok 生成的构造方法与访问器可用

---

## 2026-07-17（续：白名单概念答疑）

### 会话的主要目的
- 解释 Cursor Run Mode 中「白名单（Allowlist）」的含义及与沙箱的关系

### 完成的主要任务
1. 澄清白名单是「可自动执行的命令/工具名单」
2. 对照用户理解，说明 Auto-review 下白名单、沙箱、分类器/询问的优先级关系

### 关键决策和解决方案
- 白名单命中 → 直接自动跑（通常不走沙箱门禁）
- 可沙箱 → 在沙箱里自动跑
- 其余 → 分类器或弹窗请用户确认（视 Run Mode 而定）

### 使用的技术栈
- Cursor Agents Run Mode / Allowlist / Sandbox（概念说明）

### 修改了哪些文件
- `README.md`（追加本条答疑总结）

### 修改文件的目的是什么
- 按项目规则累积记录 Cursor 学习答疑

---

## 2026-07-17（续：按实际 UI 重讲 Run Mode vs YOLO）

### 会话的主要目的
- 根据用户截图中的 Run Mode 下拉项，纠正先前对 Auto-review 可用性的说明，并重新对照旧 YOLO

### 完成的主要任务
1. 指出界面上存在灰显的 Auto-review (with Sandbox)，并非完全没有该选项
2. 按用户可见四档模式重讲行为与旧 YOLO 对应关系
3. 说明当前选中的 Allowlist (with Sandbox) 含义

### 关键决策和解决方案
- 旧 YOLO ≈ **Run Everything (Unsandboxed)**
- 学习期推荐保持 **Allowlist (with Sandbox)**；想无人值守再开 Run Everything
- Auto-review 灰显时：可悬停看原因，或检查团队策略/账号权限

### 使用的技术栈
- Cursor Agents Run Mode（概念答疑）

### 修改了哪些文件
- `README.md`（追加本条答疑总结）

### 修改文件的目的是什么
- 按实际界面修正学习笔记，避免继续引用不可用的模式说明

---

## 2026-07-17（续：Allowlist 是否一律询问）

### 会话的主要目的
- 澄清纯 Allowlist 与 Allowlist (with Sandbox) 对「非白名单」命令的处理差异

### 完成的主要任务
1. 说明纯 Allowlist：非白名单一律询问
2. 说明 Allowlist (with Sandbox)：非白名单但可沙箱的仍可自动跑

### 关键决策和解决方案
- 用户当前若选 with Sandbox，则「不在白名单=一律问」不成立

### 使用的技术栈
- Cursor Run Mode（概念答疑）

### 修改了哪些文件
- `README.md`（追加本条答疑）

### 修改文件的目的是什么
- 纠正对 Allowlist 行为的过宽理解

---

## 2026-07-17（续：澄清 Allowlist+Sandbox 无分类器）

### 会话的主要目的
- 纠正「Allowlist (with Sandbox) 是否有 AI 分类器」的误解

### 完成的主要任务
1. 明确分类器仅存在于 Auto-review
2. 说明 Allowlist (with Sandbox) 第三层是直接询问用户

### 关键决策和解决方案
- Allowlist+Sandbox：白名单 → 沙箱 → 询问（无分类器）
- Auto-review：白名单 → 沙箱 → AI 分类器 → 可能再询问

### 使用的技术栈
- Cursor Run Mode（概念答疑）

### 修改了哪些文件
- `README.md`（追加本条答疑）

### 修改文件的目的是什么
- 避免把 Auto-review 的分类器误记到 Allowlist 模式上

---

## 2026-07-17（续：确认 Auto-review 理解）

### 会话的主要目的
- 确认用户对 Auto-review (with Sandbox) 三级闸门理解是否正确

### 完成的主要任务
1. 确认：白名单 → 沙箱 → AI 分类器 的顺序
2. 补充分类器不只会「询问」，也可放行或让 Agent 换方案

### 关键决策和解决方案
- 用户理解正确；补充分类器三种结果：放行 / 换路 / 询问

### 使用的技术栈
- Cursor Auto-review（概念答疑）

### 修改了哪些文件
- `README.md`（追加本条答疑）

### 修改文件的目的是什么
- 固化 Auto-review 工作流理解

---

## 2026-07-17（续：沙箱范围是否等于当前工程）

### 会话的主要目的
- 澄清 Cursor 沙箱的默认作用范围

### 完成的主要任务
1. 说明默认以当前 workspace 为读写中心
2. 补充受保护路径、临时目录、网络、sandbox.json 扩展等边界

### 关键决策和解决方案
- 「≈ 当前工程」正确，但工程内仍有保护路径，工程外写入通常需批准

### 使用的技术栈
- Cursor Sandbox（概念答疑）

### 修改了哪些文件
- `README.md`（追加本条答疑）

### 修改文件的目的是什么
- 明确沙箱边界，避免误以为等于整机或无限工程权限

---

## 2026-07-17（续：沙箱工作范围）

### 会话的主要目的
- 说明 Cursor 沙箱的工作范围是否等于当前打开的工程目录

### 完成的主要任务
1. 确认：默认可写范围主要是当前 workspace
2. 澄清：沙箱边界还包括网络、受保护路径、临时目录及 sandbox.json 扩展路径

### 关键决策和解决方案
- 「出工程目录写文件」通常算跳出默认沙箱写范围，往往需要审批或非沙箱执行
- 但沙箱不只看目录，还看网络与敏感路径等

### 使用的技术栈
- Cursor Sandbox / sandbox.json（概念答疑）

### 修改了哪些文件
- `README.md`（追加本条答疑）

### 修改文件的目的是什么
- 明确沙箱范围，避免把「沙箱外」简单等同于「工程外」

---

## 2026-07-17（续：旧黑名单是否还在）

### 会话的主要目的
- 回答旧版 YOLO 黑名单在新版是否还存在

### 完成的主要任务
1. 说明设置里旧的命令黑名单 UI 已弱化/移除
2. 说明新版近似替代：block_instructions、内置防护、sandbox 网络拒绝等

### 关键决策和解决方案
- 「硬黑名单勾选框」基本没了；Auto-review 下用自然语言 block_instructions 软拦截

### 使用的技术栈
- Cursor permissions.json / Run Mode（概念答疑）

### 修改了哪些文件
- `README.md`（追加本条答疑）

### 修改文件的目的是什么
- 记录黑名单演进，避免继续找旧 UI

---

## 2026-07-17（续：Dog 类补充无参构造注解）

### 会话的主要目的
- 为 `Dog` 类补充 Lombok 无参构造方法注解

### 完成的主要任务
1. 在 `Dog` 上新增 `@NoArgsConstructor`，并补充对应 import

### 关键决策和解决方案
- 与已有 `@AllArgsConstructor` 并存，同时生成无参与全参构造，便于框架反序列化与手动赋值

### 使用的技术栈
- Java / Lombok（`@NoArgsConstructor`、`@AllArgsConstructor`、`@Getter`、`@Setter`）

### 修改了哪些文件
- `src/main/java/cursor/Dog.java`（新增无参构造注解）
- `README.md`（追加本条会话总结）

### 修改文件的目的是什么
- 满足实体类常见无参构造需求；按规则记录学习会话摘要

---

## 2026-07-17（续：对话记录去向答疑）

### 会话的主要目的
- 解答「今天的对话跑哪去了」：Cursor 聊天历史存放与找回方式

### 完成的主要任务
1. 说明 Agent/Chat 历史在侧边栏可回溯
2. 说明本项目另有 `README.md` 会话总结作为学习笔记备份

### 关键决策和解决方案
- UI 历史：Cursor 左侧 Chat/Agent 历史列表按时间查看
- 项目备份：根目录 `README.md` 按规则追加每日会话摘要

### 使用的技术栈
- Cursor IDE Chat History（产品说明）

### 修改了哪些文件
- `README.md`（追加本条答疑总结）

### 修改文件的目的是什么
- 按项目规则累积记录学习答疑

---

## 2026-07-17（续：实际执行 DogTest 验证）

### 会话的主要目的
- 按 README 既有条目实际生成并运行 `DogTest`，验证 Lombok 生效

### 完成的主要任务
1. 新建 `src/main/java/cursor/DogTest.java`（无参+setter/getter、全参+getter）
2. 使用 javac + Lombok 注解处理器编译并运行自测

### 关键决策和解决方案
- 沿用 `cursor` 包 `main` 自测风格；断言失败抛 `AssertionError`
- 因父工程 packaging=pom，采用本地 javac 编译验证，不依赖根模块 Maven 编译

### 使用的技术栈
- Java、Lombok 1.18.30、javac

### 修改了哪些文件
- `src/main/java/cursor/DogTest.java`（新建）
- `README.md`（追加本条执行总结）

### 修改文件的目的是什么
- 落实 README 中「DogTest 验证 Lombok」任务，确认构造方法与访问器可用

---

## 2026-07-17（续：IDEA Lombok 设置说明）

### 会话的主要目的
- 说明 IntelliJ IDEA 中 Lombok 的必要设置，确保 `Dog` 注解能正确生成代码

### 完成的主要任务
1. 整理插件启用、注解处理开关、Maven 依赖与常见排错步骤

### 关键决策和解决方案
- 关键开关：`Annotation Processors → Enable annotation processing`
- 插件：确认 Lombok 插件已启用（较新 IDEA 通常自带）
- 依赖：`pom.xml` 中已有 lombok `provided` 依赖即可

### 使用的技术栈
- IntelliJ IDEA、Lombok、Maven

### 修改了哪些文件
- `README.md`（追加本条设置说明总结）

### 修改文件的目的是什么
- 按项目规则记录 Cursor/IDEA 学习答疑，便于日后查阅

---

## 2026-07-17（续：中文语言包仍显示英文答疑）

### 会话的主要目的
- 解答已安装中文语言包但设置界面仍为英文的原因与切换方法

### 完成的主要任务
1. 区分 IntelliJ IDEA 与 Cursor（VS Code）的语言切换路径
2. 说明需「安装语言包 + 切换显示语言 + 重启」三步

### 关键决策和解决方案
- IDEA：Settings → Appearance & Behavior → System Settings → Language / Choose Language
- Cursor：命令面板 Configure Display Language → zh-cn → 重启

### 使用的技术栈
- IntelliJ IDEA / Cursor 本地化（产品设置说明）

### 修改了哪些文件
- `README.md`（追加本条答疑总结）

### 修改文件的目的是什么
- 按项目规则累积记录学习答疑

---

## 2026-07-17（续：Cursor 设置仍英文的原因）

### 会话的主要目的
- 解释用户已切换中文后，Plan & Usage 等设置页仍为英文的原因

### 完成的主要任务
1. 根据截图确认：界面主体英文，仅日期「8月12日」为中文格式
2. 澄清 Language Pack 与 Cursor 自有设置页本地化范围不同

### 关键决策和解决方案
- 判定为产品本地化覆盖不全，而非用户未切换成功
- Language Pack 主要翻译编辑器/通用 VS Code 壳；账单、Plan & Usage、部分 Agent 设置常为英文

### 使用的技术栈
- Cursor Settings / Language Pack（产品说明）

### 修改了哪些文件
- `README.md`（追加本条答疑总结）

### 修改文件的目的是什么
- 按项目规则累积记录学习答疑

---

## 2026-07-17（续：Cursor 通用设置也未翻译）

### 会话的主要目的
- 回应用户反馈：Cursor General 等设置页全部仍为英文

### 完成的主要任务
1. 区分 Cursor Settings（自有页）与 Editor Settings（VS Code 设置页）
2. 检查本机 locale/语言包配置以确认是否真正切换到 zh-cn

### 关键决策和解决方案
- Cursor Settings（General/Plan & Usage 等）当前多为英文，属产品本地化缺口
- 中文语言包主要作用于菜单栏与「Editor Settings」经典设置页

### 使用的技术栈
- Cursor / VS Code Language Pack

### 修改了哪些文件
- `README.md`（追加本条答疑总结）

### 修改文件的目的是什么
- 按项目规则累积记录学习答疑

---

## 2026-07-17（续：确认 locale 已生效但 Cursor Settings 仍英文）

### 会话的主要目的
- 回应用户「通用设置也没翻译」的质疑，核对本机语言配置

### 完成的主要任务
1. 确认 `~/.cursor/argv.json` 已设置 `"locale": "zh-cn"`
2. 确认中文语言包已安装；说明 Cursor Settings（General 等）不在语言包覆盖范围
3. 给出验证方式：菜单栏与 Editor Settings

### 关键决策和解决方案
- 判定为 Cursor 自有设置页未本地化，非用户配置失败
- 可翻译范围：菜单/命令面板/Editor Settings；不可期待：Cursor Settings 全页中文化

### 使用的技术栈
- Cursor argv.json / VS Code Language Pack

### 修改了哪些文件
- `README.md`（追加本条答疑总结）

### 修改文件的目的是什么
- 按项目规则累积记录学习答疑

---

## 2026-07-17（续：新建 CursorWebsite Web 子模块）

### 会话的主要目的
- 新建 Maven Web 子模块 `CursorWebsite`，并在模块根目录放置指定 README

### 完成的主要任务
1. 创建 `CursorWebsite`（packaging=war）并注册到父工程 `modules`
2. 生成模块根目录 `README.md`（指定文案）
3. 补齐最小 Web 骨架：`web.xml`、`index.html`、占位 Java 类

### 关键决策和解决方案
- 采用与父工程一致的 Maven 多模块结构，`war` 打包标识 Web 工程
- Servlet API 使用 `provided` 作用域，由容器运行时提供
- 先搭骨架，后续再扩展前后端业务功能

### 使用的技术栈
- Maven、Java 8、Servlet 4.0、HTML

### 修改了哪些文件
- `pom.xml`（父工程增加 CursorWebsite 模块）
- `CursorWebsite/pom.xml`（新建）
- `CursorWebsite/README.md`（新建）
- `CursorWebsite/src/main/webapp/WEB-INF/web.xml`（新建）
- `CursorWebsite/src/main/webapp/index.html`（新建）
- `CursorWebsite/src/main/java/cursor/website/CursorWebsiteApp.java`（新建）
- `README.md`（追加本条总结）

### 修改文件的目的是什么
- 落地独立 Web 子模块骨架，便于后续实现前后端网站功能

---

## 2026-07-17（续：确认 CursorWebsite 模块创建结果）

### 会话的主要目的
- 用户确认 CursorWebsite 子模块已创建完成

### 完成的主要任务
1. 确认用户已知悉模块结构与后续可扩展方向

### 关键决策和解决方案
- 无新增代码变更；等待用户下一步前后端实现需求

### 使用的技术栈
- 无

### 修改了哪些文件
- `README.md`（追加本条确认总结）

### 修改文件的目的是什么
- 按项目规则累积记录会话摘要

---

## 2026-07-17（续：创建 WEB-INF 网站相关文档目录）

### 会话的主要目的
- 在 CursorWebsite 的 WEB-INF 下创建「网站相关文档」目录

### 完成的主要任务
1. 新建 `CursorWebsite/src/main/webapp/WEB-INF/网站相关文档/`
2. 放入 `.gitkeep` 以便 Git 跟踪空目录

### 关键决策和解决方案
- 因 Git 不跟踪空目录，使用 `.gitkeep` 占位保留目录结构

### 使用的技术栈
- Maven Webapp 目录结构

### 修改了哪些文件
- `CursorWebsite/src/main/webapp/WEB-INF/网站相关文档/.gitkeep`（新建）
- `README.md`（追加本条总结）

### 修改文件的目的是什么
- 建立网站文档存放目录，便于后续放入说明材料

---

## 2026-07-17（续：技术架构文档前端改为原生）

### 会话的主要目的
- 通读并修订 `网站技术架构文档.md`，将前端从 Vue 等框架改为最简原生实现

### 完成的主要任务
1. 去掉 Vue3 / Vite / Vue Router / Axios / ECharts 等前端框架与工程化依赖
2. 统一为 HTML、JSP、原生 CSS、原生 JavaScript
3. 同步更新架构图、分层说明、各功能前端方案、部署方式与目录结构

### 关键决策和解决方案
- 页面用 JSP/HTML + `include` 复用头尾；交互用原生 JS
- 同域 war 部署，减少跨域与前端构建步骤
- 统计图改用 Canvas/CSS，不强制第三方图表库

### 使用的技术栈
- Markdown 文档修订；约定技术：HTML / JSP / CSS / JS + Java 后端

### 修改了哪些文件
- `CursorWebsite/src/main/webapp/WEB-INF/网站相关文档/网站技术架构文档.md`（全文前端相关修订）
- `README.md`（追加本条总结）

### 修改文件的目的是什么
- 使架构文档与「不用前端框架、用最原始方式实现」的要求一致，指导后续编码

---

## 2026-07-17（续：Cursor 编辑区双击标签是否最大化）

### 会话的主要目的
- 确认 Cursor 中间编辑区双击标签能否最大化该区域

### 完成的主要任务
1. 说明双击标签仅影响编辑器分组尺寸，不会隐藏左右侧栏
2. 给出 Zen Mode、隐藏侧栏、最大化编辑器组等正确放大方式与快捷键

### 关键决策和解决方案
- 双击默认按 `workbench.editor.doubleClickTabToToggleEditorGroupSizes` 调整分组；设为 `maximize` 时可在多分组时最大化当前组
- 真正扩大阅读区：Zen Mode（⌘K Z）、⌘B 藏左侧、⌘I/⌘L 藏 AI 面板

### 使用的技术栈
- Cursor / VS Code 界面与快捷键说明（无代码变更）

### 修改了哪些文件
- `README.md`（追加本条总结）

### 修改文件的目的是什么
- 按项目规则记录本会话问答结论

---

## 2026-07-17（续：实现 CursorWebsite 首页前后端）

### 会话的主要目的
- 依据网站相关文档，用 HTML/JSP/CSS/JS + Servlet 实现主页功能

### 完成的主要任务
1. 后端：Home/News 模型与 Service（内存演示数据）、HomePageServlet、/api/home、/api/news
2. 前端：苹果风首页（顶栏、Hero、亮点×3、最新动态、CTA）、公共头尾、占位页
3. 配置 web.xml 欢迎页；更新模块 README 与依赖（JSTL/Gson）

### 关键决策和解决方案
- 先用 Servlet + 内存数据落地，后续可替换 MySQL
- 入口 `entry.jsp` → `/home` → `index.jsp`，保证首页必经数据装配
- 导航：前五项平铺，后五项「更多」折叠；移动端抽屉

### 使用的技术栈
- Java 8、Servlet、JSP、JSTL、Gson、原生 CSS/JS、Maven war

### 修改了哪些文件
- `CursorWebsite/pom.xml`
- `CursorWebsite/README.md`
- `CursorWebsite/src/main/java/cursor/website/**`（common/model/service/servlet）
- `CursorWebsite/src/main/webapp/**`（css/js/jsp/页面）
- `README.md`（追加本条总结）

### 修改文件的目的是什么
- 落地文档中的首页能力，便于 Tomcat 部署预览与后续扩展其它栏目

---

## 2026-07-17（续：启用双击标签最大化编辑器组）

### 会话的主要目的
- 实现 Cursor 中双击编辑器标签以最大化

### 完成的主要任务
1. 在用户 settings.json 中将 `workbench.editor.doubleClickTabToToggleEditorGroupSizes` 设为 `maximize`
2. 说明该能力只作用于编辑器分组，不会自动隐藏左右侧栏

### 关键决策和解决方案
- 使用 VS Code/Cursor 官方设置：双击标签最大化/还原当前编辑器组
- 若需整窗专注（藏侧栏），改用 Zen Mode（⌘K Z）

### 使用的技术栈
- Cursor User settings.json

### 修改了哪些文件
- `~/Library/Application Support/Cursor/User/settings.json`（新增双击最大化配置）
- `README.md`（追加本条总结）

### 修改文件的目的是什么
- 开启双击标签最大化编辑器组行为，并记录会话结论

---

## 2026-07-17（续：首页后端迁移到 Spring Boot）

### 会话的主要目的
- 响应用户质疑：架构文档要求 Spring Boot，将首页后端从 Servlet 迁移到 Spring Boot 2.7

### 完成的主要任务
1. `pom.xml` 引入 Spring Boot 2.7.18 BOM 与 starter-web、jasper、jstl
2. 新增 `SiteApplication`、`HomeController`、`HomeApiController`
3. Service 改为 `@Service` 注入；删除原 Servlet 实现

### 关键决策和解决方案
- 承认先前为快速落地使用 Servlet，与文档不一致；现对齐文档
- 前端仍为 JSP/CSS/JS；后端统一 Spring MVC Controller + JSON API

### 使用的技术栈
- Spring Boot 2.7.18、Spring MVC、JSP、JDK 8、Maven

### 修改了哪些文件
- `CursorWebsite/pom.xml`、`SiteApplication.java`、`controller/*`、`service/*`
- 删除 `servlet/*`、`CursorWebsiteApp.java`
- `application.properties`、`web.xml`、`CursorWebsite/README.md`、根 `README.md`

### 修改文件的目的是什么
- 使实现与《网站技术架构文档》后端选型一致

---

## 2026-07-17（续：首页后端迁移到 Spring Boot）

### 会话的主要目的
- 响应用户质疑：架构文档要求 Spring Boot，将首页后端从 Servlet 迁移到 Spring Boot 2.7

### 完成的主要任务
1. `pom.xml` 引入 Spring Boot 2.7.18 BOM 与 starter-web、jasper、jstl
2. 新增 `SiteApplication`、`HomeController`、`HomeApiController`
3. Service 改为 `@Service` 注入；删除原 Servlet 实现

### 关键决策和解决方案
- 承认先前为快速落地使用 Servlet，与文档不一致；现对齐文档
- 前端仍为 JSP/CSS/JS；后端统一 Spring MVC Controller + JSON API

### 使用的技术栈
- Spring Boot 2.7.18、Spring MVC、JSP、JDK 8、Maven

### 修改了哪些文件
- `CursorWebsite/pom.xml`、`SiteApplication.java`、`controller/*`、`service/*`
- 删除 `servlet/*`、`CursorWebsiteApp.java`
- `application.properties`、`web.xml`、`CursorWebsite/README.md`、根 `README.md`

### 修改文件的目的是什么
- 使实现与《网站技术架构文档》后端选型一致

---

## 2026-07-17（续：IDEA 识别 CursorWebsite 为 Module）

### 会话的主要目的
- 说明如何在 IntelliJ IDEA 中将 CursorWebsite 识别为父工程子模块

### 完成的主要任务
1. 确认父 `pom.xml` 已包含 `<module>CursorWebsite</module>`
2. 给出 Maven 重新加载 / 添加为 Maven 项目的操作步骤

### 关键决策和解决方案
- 代码侧模块声明已就绪；需 IDEA 执行 Maven Reload 同步项目模型

### 使用的技术栈
- IntelliJ IDEA、Maven 多模块

### 修改了哪些文件
- `README.md`（追加本条说明总结）

### 修改文件的目的是什么
- 按项目规则记录答疑，便于日后查阅

---

## 2026-07-17（续：application.properties 设为 UTF-8）

### 会话的主要目的
- 将 `application.properties` 设为 UTF-8，并说明 IDEA 中如何确认/转换编码

### 完成的主要任务
1. 确认并以 UTF-8（无 BOM）重写该文件
2. 在 `.idea/encodings.xml` 中为该文件显式指定 UTF-8

### 关键决策和解决方案
- 磁盘检测已是 utf-8；同步 IDEA 项目编码配置，避免编辑器误用其它编码打开

### 使用的技术栈
- IntelliJ IDEA 文件编码、Spring Boot properties

### 修改了哪些文件
- `CursorWebsite/src/main/resources/application.properties`
- `.idea/encodings.xml`
- `README.md`（追加本条总结）

### 修改文件的目的是什么
- 保证配置文件以 UTF-8 保存与打开，避免中文注释乱码

---

## 2026-07-17（续：如何访问主页）

### 会话的主要目的
- 说明 CursorWebsite 主页的访问方式

### 完成的主要任务
1. 说明本地 Spring Boot 启动与浏览器访问地址
2. 补充 IDEA 运行与外置 Tomcat 注意点

### 关键决策和解决方案
- 默认地址：`http://localhost:8080/` 或 `/home`

### 使用的技术栈
- Spring Boot 2.7、JSP 首页

### 修改了哪些文件
- `README.md`（追加本条答疑总结）

### 修改文件的目的是什么
- 按项目规则记录学习答疑

---

## 2026-07-17（续：再次说明主页访问地址）

### 会话的主要目的
- 再次明确主页页面 URL

### 完成的主要任务
1. 给出启动后浏览器直接打开的主页地址

### 关键决策和解决方案
- 主页：`http://localhost:8080/CursorWebsite/` 或 `/home`

### 使用的技术栈
- Spring Boot + JSP

### 修改了哪些文件
- `README.md`（追加本条总结）

### 修改文件的目的是什么
- 按项目规则记录答疑

---

## 2026-07-17（续：修复主页显示 Hello World）

### 会话的主要目的
- 排查并修复访问主页却显示 Hello World 的问题

### 完成的主要任务
1. 定位原因：进程工作目录为父工程，`forward:/index.jsp` 打到父工程 `src/main/webapp/index.jsp`
2. 新增 `WebConfig` 固定 documentRoot 到 CursorWebsite/webapp
3. 首页改为 `WEB-INF/jsp/home.jsp`；静态资源同步到 `classpath:/static/`

### 关键决策和解决方案
- API 正常说明 Spring Boot 已启动；页面错是 JSP 文档根指错
- 需重启应用后访问 `/CursorWebsite/` 或 `/home`

### 使用的技术栈
- Spring Boot、JSP、内嵌 Tomcat documentRoot

### 修改了哪些文件
- `WebConfig.java`（新建）
- `HomeController.java`
- `WEB-INF/jsp/home.jsp`、`index.jsp`
- `resources/static/css|js`
- `README.md`

### 修改文件的目的是什么
- 确保主页渲染 CursorWebsite 自己的页面，而不是父工程 Hello World

---

## 2026-07-17（续：为何本模块启动却用到父工程页面）

### 会话的主要目的
- 解释：在 CursorWebsite 启动 Spring Boot，为何会访问到父工程 index.jsp

### 完成的主要任务
1. 区分 classpath（本模块代码）与 documentRoot/user.dir（JSP 查找路径）
2. 说明 IDEA 默认 Working directory 常为父工程根目录

### 关键决策和解决方案
- API 走本模块 Controller；JSP 默认相对 `user.dir` 找 `src/main/webapp`
- 解决：改 Run 配置 Working directory 为本模块，或代码里固定 documentRoot（已做）

### 使用的技术栈
- Spring Boot 内嵌 Tomcat、IDEA Run Configuration

### 修改了哪些文件
- `README.md`（追加本条答疑总结）

### 修改文件的目的是什么
- 帮助理解多模块下 JSP 与 classpath 的差异

---

## 2026-07-17（续：IDEA Working directory 位置）

### 会话的主要目的
- 说明新版 IDEA Run Configuration 中 Working directory 的入口位置

### 完成的主要任务
1. 指出需通过「Modify options」勾选后才会显示 Working directory 字段

### 关键决策和解决方案
- 路径：Edit Configurations → SiteApplication → Modify options → Working directory → 设为模块目录

### 使用的技术栈
- IntelliJ IDEA Run Configuration

### 修改了哪些文件
- `README.md`（追加本条答疑总结）

### 修改文件的目的是什么
- 按项目规则记录学习答疑

---

## 2026-07-17（续：确认 Hello World 根因归属）

### 会话的主要目的
- 确认主页 Hello World 是 IDEA 启动工作目录问题，而非 CursorWebsite 业务代码写错

### 完成的主要任务
1. 明确：API/Controller 来自本模块；错误页面来自父工程 webapp，由 Working directory 导致

### 关键决策和解决方案
- 根因归为 IDEA Run Configuration 工作目录；代码侧已做 documentRoot 兜底属加固

### 使用的技术栈
- 概念答疑（无新功能代码）

### 修改了哪些文件
- `README.md`（追加本条总结）

### 修改文件的目的是什么
- 按项目规则记录学习答疑

---

## 2026-07-17（续：线上部署是否会有 Hello World 问题）

### 会话的主要目的
- 解答：Working directory 导致的错误页面问题，线上部署是否仍会出现

### 完成的主要任务
1. 说明该问题主要存在于 IDEA 本地运行；正式 war/jar 打包只含本模块 webapp

### 关键决策和解决方案
- 线上按 CursorWebsite 产物独立部署，不会去读父工程源码目录下的 index.jsp

### 使用的技术栈
- Spring Boot war/jar 部署（概念说明）

### 修改了哪些文件
- `README.md`（追加本条答疑总结）

### 修改文件的目的是什么
- 按项目规则记录学习答疑

---

## 2026-07-17（续：CursorWebsite Java 全面改用 Lombok）

### 会话的主要目的
- 将 CursorWebsite 中可用 Lombok 的 Java 代码改为 Lombok 注解实现

### 完成的主要任务
1. 实体/响应：`@Data` `@NoArgsConstructor` `@AllArgsConstructor`
2. Controller/Service：`@RequiredArgsConstructor` 构造注入
3. 模块 pom 显式加入 lombok 与注解处理器

### 关键决策和解决方案
- `SiteApplication`/`WebConfig`/`NewsService` 无适合样板代码处保持原样
- 保留 `ApiResponse.ok` 静态工厂方法

### 使用的技术栈
- Lombok、Spring Boot、Java 8

### 修改了哪些文件
- `CursorWebsite/pom.xml`
- `common/ApiResponse.java`、`model/*`、`controller/*`、`service/HomeService.java`
- `README.md`

### 修改文件的目的是什么
- 减少样板代码，与项目 Lombok 使用约定一致

---

## 2026-07-17（续：Oracle 官网 MySQL / Java 菜单位置）

### 会话的主要目的
- 根据 Oracle 官网导航截图，确认 MySQL 与 Java 所在目录

### 完成的主要任务
1. 对照 Cloud 二级菜单说明入口位置
2. 指出 MySQL 在 Database Services，Java 在 Developer Services

### 关键决策和解决方案
- 以用户提供的官网导航截图为准作答
- MySQL：Cloud → Database Services
- Java：Cloud → Developer Services

### 使用的技术栈
- 无代码变更（官网导航说明）

### 修改了哪些文件
- `README.md`（追加本条总结）

### 修改文件的目的是什么
- 按项目规则记录本会话问答结论

---

## 2026-07-17（续：确认首页数据为内存写死）

### 会话的主要目的
- 确认当前页面数据来源是否为 Java 写死的测试内容

### 完成的主要任务
1. 说明 `HomeService`/`NewsService` 使用内存演示数据，尚未接 MySQL

### 关键决策和解决方案
- 是的：当前为写死测试数据；后续可按架构文档改为库表 + MyBatis

### 使用的技术栈
- 概念答疑

### 修改了哪些文件
- `README.md`（追加本条总结）

### 修改文件的目的是什么
- 按项目规则记录答疑

---

## 2026-07-17（续：Database Services 下 MySQL 位置）

### 会话的主要目的
- 明确 MySQL 在 Oracle 官网 Database Services 下的具体子项

### 完成的主要任务
1. 说明子项名为 MySQL HeatWave
2. 区分官网营销导航与 OCI 控制台路径

### 关键决策和解决方案
- 官网：Cloud → Database Services → MySQL HeatWave（https://www.oracle.com/mysql/）
- OCI：Databases → MySQL HeatWave → DB Systems

### 使用的技术栈
- 无代码变更（官网导航说明）

### 修改了哪些文件
- `README.md`（追加本条总结）

### 修改文件的目的是什么
- 按项目规则记录本会话问答结论

---

## 2026-07-17（续：首页数据改为 MySQL 查库）

### 会话的主要目的
- 将首页写死数据改为 MySQL + MyBatis-Plus 查询

### 完成的主要任务
1. 引入 MyBatis-Plus、MySQL 驱动与数据源配置
2. 新增表 `site_config` / `home_feature` / `news` 及初始化 SQL
3. 改造 `HomeService`、`NewsService` 为 Mapper 查库

### 关键决策和解决方案
- 启动时 `spring.sql.init` 自动建表灌数；库需事先创建 `cursor_website`
- 配置键与亮点、新闻分离，对齐架构文档

### 使用的技术栈
- Spring Boot 2.7、MyBatis-Plus 3.5.5、MySQL 8、Lombok

### 修改了哪些文件
- `CursorWebsite/pom.xml`、`application.properties`
- `db/schema.sql`、`db/data.sql`
- `model/*`、`mapper/*`、`service/*`、`SiteApplication.java`
- `CursorWebsite/README.md`、根 `README.md`

### 修改文件的目的是什么
- 首页内容从内存写死改为持久化查询，便于后续真实运维改数

---

## 2026-07-17（续：MySQL 下载链接）

### 会话的主要目的
- 说明 MySQL 官方下载入口位置

### 完成的主要任务
1. 给出社区版下载地址与导航路径
2. 区分 MySQL HeatWave 云服务与本地安装包下载

### 关键决策和解决方案
- 本地安装：https://dev.mysql.com/downloads/mysql/
- 总入口：https://dev.mysql.com/downloads/ → MySQL Community Server
- HeatWave 为云服务，非本地安装包下载页

### 使用的技术栈
- 无代码变更（官网下载说明）

### 修改了哪些文件
- `README.md`（追加本条总结）

### 修改文件的目的是什么
- 按项目规则记录本会话问答结论

---

## 2026-07-17（续：删除 WebConfig 文档根兜底）

### 会话的主要目的
- 确认 IDEA Working directory 已设为 CursorWebsite 后，是否仍需 WebConfig

### 完成的主要任务
1. 说明该配置仅为错误工作目录时的本地兜底
2. 删除 `WebConfig.java`，依赖正确的模块工作目录与 war 内 webapp

### 关键决策和解决方案
- 工作目录正确时 Spring Boot 默认 documentRoot 即本模块 webapp；线上 war 自带页面资源

### 使用的技术栈
- Spring Boot（移除自定义 WebServerFactoryCustomizer）

### 修改了哪些文件
- 删除 `CursorWebsite/.../config/WebConfig.java`
- `README.md`（追加本条总结）

### 修改文件的目的是什么
- 去掉在正确启动方式下不再需要的兜底代码

---

## 2026-07-17（续：按 service-dao 规则重构分层）

### 会话的主要目的
- 按 `.cursor/rules/service-dao.mdc` 将 Service/Dao 改为先接口后实现

### 完成的主要任务
1. Service：`service/interfaces` + `*ServiceImpl`
2. Dao：`dao/interfaces` + `*DaoImpl`（内部调用 MyBatis Mapper）
3. Controller 改为依赖 Service 接口

### 关键决策和解决方案
- Mapper 保留为 MyBatis-Plus 技术层；业务侧统一走 Dao 接口
- 实现类命名：接口名 + Impl

### 使用的技术栈
- Spring、MyBatis-Plus、分层架构

### 修改了哪些文件
- 新增 `dao/**`、`service/interfaces/**`、`*ServiceImpl.java`
- 删除旧 `HomeService.java`/`NewsService.java`
- 更新 Controller 引用；`README.md`

### 修改文件的目的是什么
- 符合项目 service-dao 编码规范

---

## 2026-07-17（续：Oracle 目录逐层点到 MySQL / 下载）

### 会话的主要目的
- 说明从 Oracle 官网菜单一层一层点到 MySQL，以及如何到达下载页

### 完成的主要任务
1. 整理 Cloud → Database Services → MySQL HeatWave 逐层路径
2. 说明本地安装包需改走 MySQL Downloads / Community 路径

### 关键决策和解决方案
- 官网产品入口：oracle.com → Products → Cloud → Database Services → MySQL HeatWave
- 社区版下载：mysql.com/downloads → Community (GPL) → MySQL Community Server；或直接 dev.mysql.com/downloads/mysql/

### 使用的技术栈
- 无代码变更（官网导航说明）

### 修改了哪些文件
- `README.md`（追加本条总结）

### 修改文件的目的是什么
- 按项目规则记录本会话问答结论

---

## 2026-07-17（续：解释 @RequiredArgsConstructor 构造注入）

### 会话的主要目的
- 解答 Controller 字段无 `@Autowired`/`@Resource` 时如何完成 Bean 注入

### 完成的主要任务
1. 说明 Lombok `@RequiredArgsConstructor` 为 `final` 字段生成构造器
2. 说明 Spring 对单构造器自动构造注入（可不写 `@Autowired`）

### 关键决策和解决方案
- 当前注入方式：构造器注入（推荐），非字段注入

### 使用的技术栈
- Spring、Lombok

### 修改了哪些文件
- `README.md`（追加本条答疑总结）

### 修改文件的目的是什么
- 按项目规则记录学习答疑

---

## 2026-07-17（续：Mapper XML 位置说明）

### 会话的主要目的
- 解答 MyBatis Mapper XML 文件放在何处

### 完成的主要任务
1. 说明当前未使用 XML：MyBatis-Plus `BaseMapper` + `LambdaQueryWrapper` 在 Java 中完成查询

### 关键决策和解决方案
- 简单 CRUD/条件查询无需 XML；复杂 SQL 时可再补 `resources/mapper/*.xml`

### 使用的技术栈
- MyBatis-Plus（无 XML）

### 修改了哪些文件
- `README.md`（追加本条答疑总结）

### 修改文件的目的是什么
- 按项目规则记录学习答疑

---

## 2026-07-17（续：LambdaQueryWrapper 等价 SQL）

### 会话的主要目的
- 将 `NewsDaoImpl.listPublished` 的 LambdaQueryWrapper 翻译为等价 SQL

### 完成的主要任务
1. 给出 `status=published` + 按发布日期倒序 + LIMIT 的等价语句

### 关键决策和解决方案
- `selectList` 对应查询实体映射列；`last(LIMIT)` 追加分页限制

### 使用的技术栈
- MyBatis-Plus / SQL

### 修改了哪些文件
- `README.md`（追加本条答疑总结）

### 修改文件的目的是什么
- 按项目规则记录学习答疑

---

## 2026-07-17（续：澄清 LambdaQueryWrapper 属 MyBatis-Plus）

### 会话的主要目的
- 确认当前写法是 MyBatis-Plus 特有能力，原生 MyBatis 不能同样使用

### 完成的主要任务
1. 对比 Plus 的 BaseMapper/LambdaQueryWrapper 与原生 MyBatis 的 XML/注解写法

### 关键决策和解决方案
- 说明：是 Plus 用法；原生 MyBatis 需 XML 或 `@Select` 等手写 SQL

### 使用的技术栈
- MyBatis vs MyBatis-Plus（概念答疑）

### 修改了哪些文件
- `README.md`（追加本条总结）

### 修改文件的目的是什么
- 按项目规则记录学习答疑

---

## 2026-07-17（续：MyBatis-Plus 是否兼容原生写法）

### 会话的主要目的
- 说明 MyBatis-Plus 能否按原始 MyBatis 方式（XML/注解）开发

### 完成的主要任务
1. 确认 Plus 兼容原生 MyBatis，可混用 BaseMapper 与 XML 自定义 SQL

### 关键决策和解决方案
- 可以；简单用 Wrapper，复杂用 XML/`@Select`，二者可并存

### 使用的技术栈
- MyBatis-Plus / MyBatis

### 修改了哪些文件
- `README.md`（追加本条答疑总结）

### 修改文件的目的是什么
- 按项目规则记录学习答疑

---

## 2026-07-17（续：Navicat Premium「已损坏」无法打开）

### 会话的主要目的
- 解决 macOS 提示 Navicat Premium.app 已损坏、无法打开的问题

### 完成的主要任务
1. 检查应用隔离属性与代码签名状态
2. 清除 `com.apple.quarantine` 后重新打开应用

### 关键决策和解决方案
- 原因主要为 Gatekeeper 隔离属性（来源 wpsoffice），另有签名资源校验异常提示
- 执行：`xattr -r -d com.apple.quarantine "/Applications/Navicat Premium.app"`
- 清除后应用已能启动；若仍失败建议从官网重下完整安装包

### 使用的技术栈
- macOS xattr / Gatekeeper；Shell

### 修改了哪些文件
- 系统侧：清除 `/Applications/Navicat Premium.app` 的 quarantine 扩展属性（未改项目代码）
- `README.md`（追加本条总结）

### 修改文件的目的是什么
- 解除误报损坏提示以便打开 Navicat；记录会话结论

---

## 2026-07-17（续：说明 schema.sql 位置）

### 会话的主要目的
- 告知 `schema.sql` 文件路径

### 完成的主要任务
1. 给出路径：`CursorWebsite/src/main/resources/db/schema.sql`

### 关键决策和解决方案
- 无代码变更，仅路径答疑

### 使用的技术栈
- Spring Boot SQL 初始化

### 修改了哪些文件
- `README.md`（追加本条总结）

### 修改文件的目的是什么
- 按项目规则记录答疑

---

## 2026-07-17（续：MacBook Neo 能否长期干重活）

### 会话的主要目的
- 评估 MacBook Neo 是否适合长期承担重度工作负载

### 完成的主要任务
1. 核对 Neo 定位与关键规格（A18 Pro、8GB 内存、无风扇）
2. 给出「轻活可以、重活不适合长期主力」的结论与替代建议

### 关键决策和解决方案
- Neo 定位入门轻办公：短时突发任务体验好，持续编译/导出/多开 IDE 会降频且易吃满 8GB
- 长期重活建议 MacBook Air/Pro（16GB+）；Neo 更适合轻办公或备用机

### 使用的技术栈
- 无代码变更（产品选型咨询）

### 修改了哪些文件
- `README.md`（追加本条总结）

### 修改文件的目的是什么
- 按项目规则记录本会话问答结论

---

## 2026-07-17（续：MacBook Neo 256GB 存储是否够用）

### 会话的主要目的
- 评估 MacBook Neo 256GB 版本存储是否够用

### 完成的主要任务
1. 结合系统占用与开发工具体积给出结论
2. 建议开发场景优先考虑 512GB 或外接盘

### 关键决策和解决方案
- 256GB：轻度办公勉强；IntelliJ/JDK/Docker/项目文件易吃紧
- 开发主力更建议 512GB，或 256GB + 外接 SSD

### 使用的技术栈
- 无代码变更（产品选型咨询）

### 修改了哪些文件
- `README.md`（追加本条总结）

### 修改文件的目的是什么
- 按项目规则记录本会话问答结论

---

## 2026-07-17（续：application.properties 改为 yml）

### 会话的主要目的
- 将 Spring Boot 配置从 properties 迁移为 YAML

### 完成的主要任务
1. 新建 `application.yml`（保留原有端口、数据源、sql.init、MyBatis-Plus 配置）
2. 删除 `application.properties`，避免双配置冲突

### 关键决策和解决方案
- 保留当前 `spring.sql.init.mode=never` 等用户已改动的取值

### 使用的技术栈
- Spring Boot YAML 配置

### 修改了哪些文件
- `CursorWebsite/src/main/resources/application.yml`（新建）
- 删除 `application.properties`
- `README.md`（追加本条总结）

### 修改文件的目的是什么
- 统一使用 yml 管理应用配置，便于阅读与维护

---

## 2026-07-17（续：修复 cursorWebsite 首页 404）

### 会话的主要目的
- 排查并修复访问 `/cursorWebsite/` 出现 Whitelabel 404

### 完成的主要任务
1. 确认 API `/cursorWebsite/api/home` 正常，问题在页面 JSP 转发
2. 发现进程工作目录再次落到父工程，导致找不到 `WEB-INF/jsp/home.jsp`
3. 恢复 `WebConfig` 固定 documentRoot

### 关键决策和解决方案
- 404 主因是 JSP 文档根指错，不是 context-path 写错（yml 已是 `/cursorWebsite`）
- 需重启应用；同时建议 IDEA Working directory 仍设为 CursorWebsite

### 使用的技术栈
- Spring Boot、JSP、内嵌 Tomcat documentRoot

### 修改了哪些文件
- `CursorWebsite/.../config/WebConfig.java`（恢复）
- `README.md`（追加本条总结）

### 修改文件的目的是什么
- 保证无论工作目录在父工程还是子模块，首页 JSP 都能被找到

---

## 2026-07-17（续：为何配置了 Working directory 仍需 WebConfig）

### 会话的主要目的
- 解释用户已设 Working directory 为 CursorWebsite，为何仍出现需 WebConfig 才能出首页

### 完成的主要任务
1. 说明此前诊断时进程实际 cwd 仍为父工程
2. 列出 IDEA 配置未生效的常见原因与自检方法

### 关键决策和解决方案
- 若 cwd 真正是 CursorWebsite，可不依赖 WebConfig；WebConfig 是兜底
- 需确认 Run 配置已 Apply、重启，且跑的是该配置

### 使用的技术栈
- IDEA Run Configuration、Spring Boot documentRoot

### 修改了哪些文件
- `README.md`（追加本条答疑总结）

### 修改文件的目的是什么
- 按项目规则记录学习答疑

---

## 2026-07-17（续：确认 Run 配置是否正确）

### 会话的主要目的
- 核对用户 SiteApplication 的 Working directory 等 Run 配置是否有问题

### 完成的主要任务
1. 确认模块、Main class、Working directory 指向 CursorWebsite 均正确
2. 说明此前 cwd 仍为父工程是旧进程未用新配置重启导致

### 关键决策和解决方案
- 配置本身无问题；需停掉旧进程后用该配置重新启动

### 使用的技术栈
- IntelliJ IDEA Run Configuration

### 修改了哪些文件
- `README.md`（追加本条答疑总结）

### 修改文件的目的是什么
- 按项目规则记录学习答疑

---

## 2026-07-17（续：去掉 @Configuration 是否失效）

### 会话的主要目的
- 确认 WebConfig 去掉 `@Configuration` 后是否不再生效

### 完成的主要任务
1. 说明无 `@Configuration`（或其它注册方式）时 `@Bean` 不会被 Spring 扫描注册

### 关键决策和解决方案
- 是的：该类将不作为配置类生效；documentRoot 定制也就不会执行

### 使用的技术栈
- Spring `@Configuration` / `@Bean`

### 修改了哪些文件
- `README.md`（追加本条答疑总结）

### 修改文件的目的是什么
- 按项目规则记录学习答疑

---

## 2026-07-17（续：删除 WebConfig）

### 会话的主要目的
- 删除不再需要的 WebConfig 及相关配置兜底

### 完成的主要任务
1. 删除 `WebConfig.java` 及空的 `config` 包目录

### 关键决策和解决方案
- 依赖 IDEA Working directory 指向 CursorWebsite；线上 war 自带 webapp，无需该类

### 使用的技术栈
- 无

### 修改了哪些文件
- 删除 `CursorWebsite/.../config/WebConfig.java`
- `README.md`（追加本条总结）

### 修改文件的目的是什么
- 去掉已确认不需要的 documentRoot 兜底代码

---

## 2026-07-17（续：技术架构文档位置）

### 会话的主要目的
- 告知《网站技术架构文档》所在路径

### 完成的主要任务
1. 指出文档位于 CursorWebsite 的 WEB-INF 网站相关文档目录

### 关键决策和解决方案
- 路径：`CursorWebsite/src/main/webapp/WEB-INF/网站相关文档/网站技术架构文档.md`

### 使用的技术栈
- 无

### 修改了哪些文件
- `README.md`（追加本条答疑总结）

### 修改文件的目的是什么
- 按项目规则记录学习答疑

---

## 2026-07-17（新闻中心前后端实现）

### 会话的主要目的
- 依据设计图、功能规划与技术架构文档，实现新闻中心列表页与详情页的前后端能力

### 完成的主要任务
1. 扩展 `news` 表结构与实体（作者、正文、头条、阅读量）及种子/升级 SQL
2. 实现 Dao / Service / 页面 Controller / REST API（列表分页+分类、详情+相关阅读+阅读量）
3. 实现新闻列表/详情 JSP、样式与「显示更多」原生 JS；旧 `news.jsp` / `news-detail.jsp` 重定向到新路由

### 关键决策和解决方案
- 页面入口：`GET /news`、`GET /news/detail?id=`（SSR）；API：`GET /api/news`、`GET /api/news/{id}`、`GET /api/news/latest`
- 列表首屏排除头条避免重复；分页优先「显示更多」拉取后续页
- 详情访问时 `view_count + 1`；已有库需执行 `upgrade_news.sql`（`sql.init.mode=never`）

### 使用的技术栈
- Spring Boot 2.7、Spring MVC、MyBatis-Plus、JSP/JSTL、原生 JS/CSS、MySQL

### 修改了哪些文件
- 后端：`News.java`、`NewsListPage`/`NewsDetailPage`、`NewsDao*`、`NewsService*`、`NewsController`、`NewsApiController`、`HomeApiController`（新闻 API 拆出）
- SQL：`schema.sql`、`data.sql`、`upgrade_news.sql`
- 前端：`WEB-INF/jsp/news.jsp`、`news-detail.jsp`；`webapp/news.jsp`、`news-detail.jsp`（兼容重定向）；`header/footer/home` 链接；`site.css`/`site.js`（含 static 同步）
- `README.md`（追加本条总结）

### 修改文件的目的是什么
- 落地文档中的新闻中心信息架构与接口约定，形成可浏览的列表/详情闭环

---

## 2026-07-17（续：新闻中心未进后台）

### 会话的主要目的
- 排查并修复点击「新闻中心」仍显示占位页、未访问后台的问题

### 完成的主要任务
1. 定位根因：`*.jsp` 由 Tomcat JspServlet 直出，不会进入 Spring `@Controller`
2. 新增 `NewsPageFilter`，在渲染 `/news.jsp`、`/news-detail.jsp` 前注入 Service 数据
3. 将真实列表/详情页写回 `webapp/news.jsp`、`news-detail.jsp`，导航改回 `.jsp` 链接

### 关键决策和解决方案
- Filter + JSP 直访保证一定走后台；`/news`、`/news/detail` 仍由 Controller 转发到 `WEB-INF/jsp`
- 需重启应用使 Filter 生效；旧库仍需执行 `upgrade_news.sql`

### 使用的技术栈
- Spring `OncePerRequestFilter`、JSP、Spring MVC

### 修改了哪些文件
- 新增 `config/NewsPageFilter.java`
- 更新 `NewsController`、`header/footer/home`、`news.jsp`、`news-detail.jsp`、`site.js`、`README.md`

### 修改文件的目的是什么
- 让点击新闻中心必定查询后台并渲染真实列表，而不再停留在占位页

---

## 2026-07-17（网站留言前后端实现）

### 会话的主要目的
- 依据设计图、功能规划与技术架构文档，实现网站留言板前后端

### 完成的主要任务
1. 新增 `guestbook` 表、种子数据与 `upgrade_guestbook.sql`
2. 实现 Dao/Service/Controller/API：已审核列表、提交待审核、敏感词与 IP 限流
3. 实现 `messages.jsp` 双栏布局、表单 AJAX 提交、列表加载更多；`GuestbookPageFilter` 保证 JSP 直访走后台

### 关键决策和解决方案
- 与联系我们分表；前台永不返回邮箱；提交默认 `pending`，列表仅 `approved`
- API：`GET/POST /api/guestbook`；页面：`/messages.jsp` 与 `/messages`
- 已有库需执行 `upgrade_guestbook.sql` 并导入种子或手工审核数据

### 使用的技术栈
- Spring Boot、MyBatis-Plus、JSP/JSTL、原生 JS/CSS、MySQL

### 修改了哪些文件
- SQL：`schema.sql`、`data.sql`、`upgrade_guestbook.sql`
- 后端：`Guestbook*` 实体/DTO/Mapper/Dao/Service/Controller/Filter/API
- 前端：`messages.jsp`、`WEB-INF/jsp/messages.jsp`、`site.css`、`site.js`
- `README.md`（追加本条总结）

### 修改文件的目的是什么
- 落地文档中的公开留言板能力（表单 + 审核后展示）

---

## 2026-07-17（续：留言时间格式化）

### 会话的主要目的
- 将留言列表中的 ISO 时间（含 `T`）格式化为可读时间

### 完成的主要任务
1. `Guestbook` 增加 `createdAtText` / `replyTimeText`，并给时间字段加 `@JsonFormat`
2. `messages.jsp` 展示改为 `createdAtText`（`yyyy-MM-dd HH:mm:ss`）

### 关键决策和解决方案
- 页面用 getter 格式化；接口 JSON 用 `@JsonFormat`，加载更多与首屏一致

### 使用的技术栈
- Java `DateTimeFormatter`、Jackson `@JsonFormat`、JSP EL

### 修改了哪些文件
- `Guestbook.java`、`messages.jsp`、`WEB-INF/jsp/messages.jsp`、`README.md`

### 修改文件的目的是什么
- 时间显示为 `2026-07-17 21:14:13` 这类可读格式

---

## 2026-07-17（续：IDEA ⌃⇧R 与 gutter Run 工作目录不同）

### 会话的主要目的
- 解释为何点击 main 旁 Run 时工作目录是 CursorWebsite，而 ⌃⇧R 时变成父工程

### 完成的主要任务
1. 说明「已保存 Run Configuration」与「Run context configuration 临时配置」的差异

### 关键决策和解决方案
- gutter / 下拉选中的 `SiteApplication` 使用已改过的 Working directory（CursorWebsite）
- ⌃⇧R 多为「按当前类生成/复用临时配置」，默认工作目录常落在多模块父工程根
- 建议：用顶部运行配置下拉启动；或把 Application 模板 Working directory 设为 `$MODULE_DIR$`

### 使用的技术栈
- IntelliJ IDEA Run Configuration

### 修改了哪些文件
- `README.md`（追加本条答疑总结）

### 修改文件的目的是什么
- 按项目规则记录学习答疑

---
## 2026-07-18（继续 Cursor 学习之旅）

### 会话的主要目的
- 用户打招呼，准备继续 Cursor 学习与网站项目推进

### 完成的主要任务
1. 回顾近期进度：首页、新闻中心、网站留言已落地
2. 确认可继续方向，等待用户指定今日学习/开发主题

### 关键决策和解决方案
- 以答疑与引导为主，不主动改业务代码；待用户明确目标后再动手

### 使用的技术栈
- 无（本回合为会话开场，未改代码）

### 修改了哪些文件
- `README.md`（追加本条总结）

### 修改文件的目的是什么
- 按项目规则记录会话开场与待续状态

---

## 2026-07-18（MacBook Neo 微信自动登录答疑）

### 会话的主要目的
- 解答 MacBook Neo 上微信是否支持自动登录

### 完成的主要任务
1. 说明 Mac 微信本身支持自动登录，并非 Neo 机型禁用
2. 归纳新机/登录态失效后需重新扫码的常见原因与处理建议

### 关键决策和解决方案
- 自动登录依赖本地登录令牌；新机、重装、退出登录、安全验证后会失效
- 建议：官网安装最新 Mac 微信、登录后开启自动登录、保持手机微信在线确认、必要时清理残留后重装

### 使用的技术栈
- 无（通用软件使用答疑，未改代码）

### 修改了哪些文件
- `README.md`（追加本条答疑总结）

### 修改文件的目的是什么
- 按项目规则记录会话答疑

---

## 2026-07-18（微信扫码无「自动登录这台设备」选项）

### 会话的主要目的
- 解释为何微信扫码确认时看不到「自动登录这台设备」勾选项

### 完成的主要任务
1. 说明该选项仅对「常用/可信设备」开放，新机或重装后通常不显示
2. 给出等待累计登录天数、保持两端最新版本等可行做法

### 关键决策和解决方案
- 属服务端风控策略，非用户设置缺失；新 Mac（如 Neo）首次使用需连续登录约 3 天至一周后才会出现勾选项
- 重装微信/系统/迁移后常用设备状态会重置，需重新积累

### 使用的技术栈
- 无（通用软件使用答疑，未改代码）

### 修改了哪些文件
- `README.md`（追加本条答疑总结）

### 修改文件的目的是什么
- 按项目规则记录会话答疑

---

## 2026-07-18（确认微信自动登录选项与使用时长关系）

### 会话的主要目的
- 确认用户理解：本机使用时间短导致无「自动登录该设备」选项

### 完成的主要任务
1. 肯定用户判断：新设备需累计登录/使用一段时间后才会出现该选项

### 关键决策和解决方案
- 无额外技术方案；继续在本机正常使用数日后复查即可

### 使用的技术栈
- 无（答疑确认，未改代码）

### 修改了哪些文件
- `README.md`（追加本条总结）

### 修改文件的目的是什么
- 按项目规则记录会话答疑

---

## 2026-07-18（Sublime Text 标签页打开新文档设置）

### 会话的主要目的
- 说明如何让 Sublime Text 以标签页形式打开新文档

### 完成的主要任务
1. 给出 Preferences 中与窗口/标签页相关的关键设置项及操作路径

### 关键决策和解决方案
- `open_files_in_new_window: false`、`show_tabs: true`；新建文档用 Cmd+N 落在当前窗口标签栏

### 使用的技术栈
- Sublime Text 用户设置（JSON）

### 修改了哪些文件
- `README.md`（追加本条答疑总结）

### 修改文件的目的是什么
- 按项目规则记录会话答疑

---

## 2026-07-18（如何让 Agent 自动 push）

### 会话的主要目的
- 了解为何需手动 push，以及如何配置让 Cursor Agent 自动提交并推送到远程

### 完成的主要任务
1. 检查仓库状态：昨日 CursorWebsite 等改动尚未 commit，本地与 `origin/master` 齐平
2. 说明默认不自动 push 的原因，以及用 Cursor Rule 开启「提交后自动 push」的做法
3. 提醒 `application.yml` 含数据库密码，上传前需确认是否纳入版本库

### 关键决策和解决方案
- 默认安全策略：未明确要求时不 commit / 不 push
- 推荐：在 `.cursor/rules/` 增加 alwaysApply 规则，约定「用户要求提交/上传时：commit 后立刻 `git push -u origin HEAD`」
- 也可用口头指令「提交并推送到远程」临时触发，无需改规则

### 使用的技术栈
- Git、GitHub、Cursor Rules（`.mdc`）

### 修改了哪些文件
- `README.md`（追加本条总结）

### 修改文件的目的是什么
- 记录 push 自动化说明与当前待上传状态

---

## 2026-07-18（提交并推送到远程仓库）

### 会话的主要目的
- 将昨日及近期本地未提交代码 commit 并 push 到 GitHub

### 完成的主要任务
1. 汇总 CursorWebsite（首页/新闻/留言等）及相关模块变更
2. 创建 commit 并推送到 `origin/master`
3. 跳过可能含本地库连接信息的 `.idea/dataSources.xml`

### 关键决策和解决方案
- 用户明确要求「提交代码到远程仓库」→ commit 后立即 push
- 学习用 `application.yml` 中的本地库密码一并纳入（非生产密钥）；IDE 数据源 XML 不提交

### 使用的技术栈
- Git、GitHub

### 修改了哪些文件
- 见本次 commit 变更清单（CursorWebsite 全量、父 pom、README、学习用 Dog 类等）
- `README.md`（追加本条总结）

### 修改文件的目的是什么
- 同步远程，便于后续继续开发与学习

---

## 2026-07-18（续：push 因认证失败未完成）

### 会话的主要目的
- 记录本地 commit 已成功、远程 push 因 GitHub 凭据不可用而失败

### 完成的主要任务
1. 本地提交：`971b6cc`（master 领先 origin 1 个提交）
2. push 失败：`could not read Username for 'https://github.com'`
3. 环境无 `gh`、无 SSH 公钥、钥匙串无 github.com 凭据

### 关键决策和解决方案
- 需用户在本机终端或 IDEA 登录 GitHub 后执行：`git push origin master`
- 可选后续：安装 GitHub CLI（`gh auth login`）或配置 SSH，便于 Agent 自动 push

### 使用的技术栈
- Git、HTTPS remote

### 修改了哪些文件
- `README.md`（追加本条说明；本条本身尚未纳入上一次 commit）

### 修改文件的目的是什么
- 如实记录 push 未完成原因与后续操作

---

## 2026-07-18（Git 推送是否每次都要输入账号密码）

### 会话的主要目的
- 解答终端 `git push` 是否每次都要输入用户名和密码

### 完成的主要任务
1. 说明 GitHub 已不支持用账户登录密码做 git 操作，需 PAT 或 SSH
2. 说明用凭据助手 / SSH 后可免重复输入

### 关键决策和解决方案
- HTTPS：用 Personal Access Token + macOS Keychain（`git config --global credential.helper osxkeychain`）保存一次即可
- SSH：生成密钥并加到 GitHub，remote 改为 SSH 地址后长期免密输入
- IDEA 登录过 GitHub 后，IDE 内 Push 通常也不用每次手输

### 使用的技术栈
- Git、GitHub HTTPS/SSH、macOS Keychain

### 修改了哪些文件
- `README.md`（追加本条答疑总结）

### 修改文件的目的是什么
- 记录认证与免重复输入的做法

---

## 2026-07-18（GitHub PAT 在哪里查看/创建）

### 会话的主要目的
- 说明 GitHub Personal Access Token 的入口与注意点

### 完成的主要任务
1. 给出 GitHub 创建 PAT 的路径
2. 说明 token 只在创建时显示一次，丢失需重建

### 关键决策和解决方案
- 路径：GitHub → Settings → Developer settings → Personal access tokens
- 推荐 Fine-grained 或 Classic；git push 至少需要 repo 相关权限
- 创建后复制保存；页面无法再次查看完整 token 明文

### 使用的技术栈
- GitHub PAT

### 修改了哪些文件
- `README.md`（追加本条答疑总结）

### 修改文件的目的是什么
- 记录 PAT 获取方式

---

## 2026-07-18（Git 每次 push 都要用户名密码）

### 会话的主要目的
- 解释为何第二次及以后 push 仍反复要求输入用户名密码

### 完成的主要任务
1. 说明原因：HTTPS 凭证未缓存，或未改用 SSH/凭据助手
2. 给出 macOS 上 osxkeychain、改用 SSH、GitHub 用 PAT 等处理办法

### 关键决策和解决方案
- 优先配置 `credential.helper=osxkeychain`；长期更推荐 SSH；GitHub/GitLab HTTPS 需用 Token 而非账户登录密码

### 使用的技术栈
- Git、HTTPS/SSH、macOS Keychain

### 修改了哪些文件
- `README.md`（追加本条答疑总结）

### 修改文件的目的是什么
- 按项目规则记录会话答疑

---

## 2026-07-18（Git 改用 SSH 推送）

### 会话的主要目的
- 指导用户将 Git 远程从 HTTPS 改为 SSH，避免每次 push 输入密码

### 完成的主要任务
1. 说明生成 SSH 密钥、写入公钥到托管平台、修改 remote URL 的完整步骤

### 关键决策和解决方案
- `ssh-keygen` 生成 ed25519 密钥 → 公钥加到 GitHub/GitLab → `git remote set-url` 改为 `git@...` 形式

### 使用的技术栈
- Git、SSH（ed25519）

### 修改了哪些文件
- `README.md`（追加本条答疑总结）

### 修改文件的目的是什么
- 按项目规则记录会话答疑

---

## 2026-07-18（解释 SSH 的 ed25519）

### 会话的主要目的
- 解释 ed25519 是什么，以及生成密钥时能否改用其他算法

### 完成的主要任务
1. 说明 ed25519 是一种 SSH 密钥算法；可改用 RSA 等替代

### 关键决策和解决方案
- 推荐继续用 ed25519；若不支持或想改，可用 `-t rsa -b 4096`

### 使用的技术栈
- SSH 密钥算法（ed25519 / RSA）

### 修改了哪些文件
- `README.md`（追加本条答疑总结）

### 修改文件的目的是什么
- 按项目规则记录会话答疑

---

## 2026-07-18（SSH 连接 GitHub Host key verification failed）

### 会话的主要目的
- 排查用户执行 `ssh -T git@github.com` 出现 Host key verification failed 的原因

### 完成的主要任务
1. 说明首次连接需对主机指纹输入 yes；未确认会导致验证失败
2. 告知指纹与 GitHub 官方一致，可安全继续

### 关键决策和解决方案
- 重新执行命令，在提示处输入完整单词 `yes`，将 github.com 写入 known_hosts 后再测连通

### 使用的技术栈
- SSH、GitHub

### 修改了哪些文件
- `README.md`（追加本条答疑总结）

### 修改文件的目的是什么
- 按项目规则记录会话答疑

---

## 2026-07-18（再次请求提交到远程：工作区已同步）

### 会话的主要目的
- 按用户要求将代码提交并推送到远程仓库

### 完成的主要任务
1. 检查本地状态：working tree clean，与 `origin/master` 已同步
2. `git fetch` 确认无未推送提交、无未提交改动
3. 远程已改为 SSH：`git@github.com:zhangzhiwang/TransitionalPeriod_2_0.git`

### 关键决策和解决方案
- 无需再次 commit/push；告知用户代码已在远程
- 本条总结写入后若产生新 diff，再单独提交（若用户需要）

### 使用的技术栈
- Git、SSH remote

### 修改了哪些文件
- `README.md`（追加本条总结）

### 修改文件的目的是什么
- 按项目规则记录本次检查结果

---

## 2026-07-18（新建子模块 CursorOnlineShoppingMall）

### 会话的主要目的
- 在父工程下新增 Maven 子模块 `CursorOnlineShoppingMall`（packaging=pom）

### 完成的主要任务
1. 创建 `CursorOnlineShoppingMall/pom.xml`（继承父工程，`packaging` 为 `pom`）
2. 在根 `pom.xml` 的 `<modules>` 中注册该子模块
3. 执行 `mvn validate` 校验模块可被 Maven 识别

### 关键决策和解决方案
- 按现有 `CursorWebsite` 风格继承 `org.example:TransitionalPeriod_2_0:1.0-SNAPSHOT`
- 预留空 `<modules>`，便于后续拆 common/api/web 等商城子工程

### 使用的技术栈
- Maven（多模块、packaging=pom）

### 修改了哪些文件
- 新增：`CursorOnlineShoppingMall/pom.xml`
- 修改：根目录 `pom.xml`、`README.md`

### 修改文件的目的是什么
- 落地在线商城 pom 子模块骨架，供后续功能扩展

---

## 2026-07-18（CursorOnlineShoppingMall 改为 Web 工程）

### 会话的主要目的
- 将 `CursorOnlineShoppingMall` 从 packaging=pom 改为 Web（war）工程

### 完成的主要任务
1. `pom.xml` 改为 `packaging=war`，引入 Spring Boot Web / JSP / MyBatis-Plus / MySQL
2. 新增启动类 `MallApplication`、`application.yml`、`web.xml`、占位 `index.jsp`
3. `mvn compile` 校验通过

### 关键决策和解决方案
- 对齐架构文档：原生 HTML/JSP + Spring Boot + MyBatis-Plus + MySQL
- 参考 `CursorWebsite` 结构；端口 `8081`、上下文 `/cursorMall`，避免与官网冲突
- 数据源默认库名 `cursor_mall`，启动 SQL 初始化为 `never`

### 使用的技术栈
- Maven war、Spring Boot 2.7、MyBatis-Plus、MySQL、JSP/JSTL

### 修改了哪些文件
- 修改：`CursorOnlineShoppingMall/pom.xml`、`README.md`
- 新增：`MallApplication.java`、`application.yml`、`WEB-INF/web.xml`、`index.jsp`

### 修改文件的目的是什么
- 落地商城 Web 工程骨架，便于后续按需求文档开发

---

## 2026-07-18（网上商城页面 UI 原型）

### 会话的主要目的
- 依据商城需求文档，按功能生成 UI 原型并放入「页面 UI 原型」目录

### 完成的主要任务
1. 新建目录 `网上商城相关文档/页面 UI 原型/`
2. 编写京东风格视觉总规范 + 13 份页面原型（含地址编辑页）
3. 每份原型含信息架构、ASCII 线框、交互说明

### 关键决策和解决方案
- 采用与 CursorWebsite 设计图一致的 Markdown 线框原型，便于评审与落地
- 色彩参考京东：主色 `#E4393C`，底色 `#F5F5F5`
- 需求中的地址编辑虽未单独编号，但流程必需，故单独出原型

### 使用的技术栈
- Markdown、Mermaid 流程图、ASCII 线框

### 修改了哪些文件
- 新增：`页面 UI 原型/00-视觉与交互总规范.md` 及 `UI原型-*.md` 共 14 个文件
- 修改：`README.md`

### 修改文件的目的是什么
- 为后续 JSP/接口开发提供一页一功能的 UI 依据

---

## 2026-07-18（网上商城前后端接口文档）

### 会话的主要目的
- 按需求文档单独编写前后端接口说明（Markdown）

### 完成的主要任务
1. 新增 `前后端接口文档.md`（与需求文档同级）
2. 覆盖认证、首页、分类、商品、购物车、地址、订单与微信支付
3. 约定统一 JSON 响应、Session 登录、页面路由与 API 对照表

### 关键决策和解决方案
- Base URL：`/cursorMall`；JSON 前缀 `/api/**`；成功码 `code=0`
- 密码仅约定服务端加密落库；注册成功异步发邮件在注册接口说明中体现
- 订单确认拆为 preview + create（含微信预支付参数）

### 使用的技术栈
- Markdown 接口文档；对齐 Spring Boot Session + REST 风格

### 修改了哪些文件
- 新增：`CursorOnlineShoppingMall/.../网上商城相关文档/前后端接口文档.md`
- 修改：`README.md`

### 修改文件的目的是什么
- 为后续实现 Controller/前端联调提供接口契约

---

## 2026-07-18（Mac 屏幕黑屏时间设置）

### 会话的主要目的
- 说明如何设置 Mac 电脑屏幕多久后黑屏

### 完成的主要任务
1. 给出系统设置中「锁定屏幕 / 显示器关闭」相关路径，以及终端 `pmset` 备选方式

### 关键决策和解决方案
- 优先用「系统设置 → 锁定屏幕 / 电池与节能」调节关闭显示器时间

### 使用的技术栈
- macOS 系统设置

### 修改了哪些文件
- `README.md`（追加本条答疑总结）

### 修改文件的目的是什么
- 按项目规则记录会话答疑

---

## 2026-07-18（网上商城库设计与建库）

### 会话的主要目的
- 按商城文档设计数据库；新建与 CursorOnlineShoppingMall 对应的下划线库名

### 完成的主要任务
1. 创建 MySQL 库 `cursor_online_shopping_mall`
2. 编写 `schema.sql` / `data.sql` 并落库执行
3. 新增《数据库设计文档.md》，更新 `application.yml` 数据源

### 关键决策和解决方案
- 库名采用模块名下划线形式；表名 `mall_*` 前缀 + 下划线字段；订单表避开保留字 `order`
- 订单/明细保留收货与商品快照，满足订单列表历史展示与微信支付字段

### 使用的技术栈
- MySQL 8、utf8mb4、InnoDB、Spring Boot datasource

### 修改了哪些文件
- `CursorOnlineShoppingMall/src/main/resources/db/schema.sql`（新建建表脚本）
- `CursorOnlineShoppingMall/src/main/resources/db/data.sql`（新建演示数据）
- `CursorOnlineShoppingMall/src/main/webapp/WEB-INF/网上商城相关文档/数据库设计文档.md`（新建设计说明）
- `CursorOnlineShoppingMall/src/main/resources/application.yml`（数据源库名改为 cursor_online_shopping_mall）
- `README.md`（追加本条总结）

### 修改文件的目的是什么
- 落地商城库表设计并与模块命名规范对齐，供后续开发使用

---

## 2026-07-18（CursorWebsite 数据库设计）

### 会话的主要目的
- 依据网站相关文档为 CursorWebsite 完成/补齐数据库设计

### 完成的主要任务
1. 按架构文档补齐 about/product/contact/job/friend_link/page_view_daily 等表
2. 更新 schema.sql、data.sql，新增《数据库设计文档.md》并落库执行

### 关键决策和解决方案
- 库名保持 `cursor_website`；表与字段全下划线命名
- 联系咨询与网站留言分表；产品特性/规格用 JSON 字段；网站地图不建表
- 统计用 `page_view_daily` 按日按页汇总，不做 IP 明细

### 使用的技术栈
- MySQL 8、utf8mb4、InnoDB

### 修改了哪些文件
- `CursorWebsite/src/main/resources/db/schema.sql`（全量建表）
- `CursorWebsite/src/main/resources/db/data.sql`（演示数据）
- `CursorWebsite/src/main/webapp/WEB-INF/网站相关文档/数据库设计文档.md`（新建设计说明）
- `README.md`（追加本条总结）

### 修改文件的目的是什么
- 覆盖规划内 10 项功能的持久化模型，供后续开发使用

---

## 2026-07-18（网上商城首页前后端预览）

### 会话的主要目的
- 按需求/接口/UI 原型实现商城首页，数据写死以便先看效果

### 完成的主要任务
1. 后端：HomeService 写死数据、HomeController 转发 JSP、HomeApiController 提供 `/api/home`
2. 前端：京东风 home.jsp + 底栏 + 轮播/加购交互
3. 启动类暂排除数据源自动配置，不连库即可预览

### 关键决策和解决方案
- 暂不强制登录拦截，方便直接打开首页
- 加购仅 toast，分类/详情链接预留路由
- 访问地址：`http://localhost:8081/cursorMall/home`

### 使用的技术栈
- Spring Boot 2.7、JSP/JSTL、原生 CSS/JS

### 修改了哪些文件
- 新增 `common/ApiResponse`、`model/*`、`HomeService(Impl)`、`HomeController`、`HomeApiController`
- 新增 `WEB-INF/jsp/home.jsp`、`tabbar.jsp`、`css/mall.css`、`js/mall.js`
- 修改 `MallApplication.java`、`index.jsp`、`README.md`

### 修改文件的目的是什么
- 落地可预览的首页效果，后续再接库与登录

---

## 2026-07-18（Redis 历史版本官网下载位置）

### 会话的主要目的
- 说明 Redis 历史版本在官网上的下载入口

### 完成的主要任务
1. 告知 Download 页与 GitHub Releases / 源码归档位置

### 关键决策和解决方案
- 官网 Download 提供版本选择；完整历史以 GitHub redis/redis Releases 或 download.redis.io 归档为准

### 使用的技术栈
- 无（答疑）

### 修改了哪些文件
- `README.md`（追加本条总结）

### 修改文件的目的是什么
- 按项目规则记录会话答疑

---

## 2026-07-18（Redis 历史版本官网点击路径）

### 会话的主要目的
- 说明从 Redis 官网一级一级点到历史版本归档的路径

### 完成的主要任务
1. 梳理 redis.io → Downloads → 源码/稳定版链接 → download.redis.io/releases 的入口关系

### 关键决策和解决方案
- 新版官网 Download 页不直接罗列全部旧版；完整历史在 download.redis.io/releases，常从「Install from source / Latest stable」相关链接进入 download.redis.io 后再进 releases

### 使用的技术栈
- 无（答疑）

### 修改了哪些文件
- `README.md`（追加本条总结）

### 修改文件的目的是什么
- 按项目规则记录会话答疑

---

## 2026-07-18（Mac 编译安装 Redis 步骤）

### 会话的主要目的
- 说明在 macOS 上从源码编译安装 Redis 的步骤

### 完成的主要任务
1. 给出下载、解压、make、安装、启动与验证的命令流程

### 关键决策和解决方案
- 以官方源码 `make` / `make install` 为主；可选 brew 作对照；说明 Apple Silicon 一般可直接编译

### 使用的技术栈
- Redis 源码、make、macOS

### 修改了哪些文件
- `README.md`（追加本条答疑总结）

### 修改文件的目的是什么
- 按项目规则记录会话答疑

---

## 2026-07-18（排查 Redis 6.2.6 Mac make 失败）

### 会话的主要目的
- 分析用户编译 redis-6.2.6 时 replication.o 报错的原因与解决办法

### 完成的主要任务
1. 判定为新版 macOS SDK 下 stat64/fstat64 宏选择错误（已知问题）
2. 给出改 config.h 补丁，或升级到 ≥6.2.14 / 更新主版本的方案

### 关键决策和解决方案
- 优先建议换 6.2.14+ 或不低于 7.2.2 的版本；若必须用 6.2.6，在 `src/config.h` 的 `__APPLE__` 分支增加 `_DARWIN_C_SOURCE`

### 使用的技术栈
- Redis 源码、Apple Clang、macOS SDK

### 修改了哪些文件
- `README.md`（追加本条答疑总结）

### 修改文件的目的是什么
- 按项目规则记录会话答疑

---

## 2026-07-18（确认 Redis config.h 补丁写法）

### 会话的主要目的
- 确认用户在 `src/config.h` 中加入 `_DARWIN_C_SOURCE` 的修改是否正确

### 完成的主要任务
1. 确认写法正确，并提示继续 `make distclean && make`

### 关键决策和解决方案
- `#ifdef __APPLE__` 下先定义 `_DARWIN_C_SOURCE` 再 include 头文件，符合官方 issue 补丁

### 使用的技术栈
- Redis 源码 config.h

### 修改了哪些文件
- `README.md`（追加本条总结）

### 修改文件的目的是什么
- 按项目规则记录会话答疑

---

## 2026-07-18（Redis make install 权限被拒）

### 会话的主要目的
- 解决 make 通过后 make install 写入 /usr/local/bin 权限不足

### 完成的主要任务
1. 说明需使用 sudo make install；pkg-config 警告可忽略或 brew 安装

### 关键决策和解决方案
- `/usr/local/bin` 需管理员权限；编译已成功，仅安装步骤缺 sudo

### 使用的技术栈
- Redis make install、macOS 权限

### 修改了哪些文件
- `README.md`（追加本条总结）

### 修改文件的目的是什么
- 按项目规则记录会话答疑

---

## 2026-07-18（Redis 安装后如何使用）

### 会话的主要目的
- 说明源码安装完成后的 Redis 基本启动与使用方法

### 完成的主要任务
1. 给出启动服务、redis-cli、常用命令与后台运行示例

### 关键决策和解决方案
- 前台 `redis-server` + 另一终端 `redis-cli`；日常可用配置文件后台启动

### 使用的技术栈
- Redis Server / redis-cli

### 修改了哪些文件
- `README.md`（追加本条总结）

### 修改文件的目的是什么
- 按项目规则记录会话答疑

---

## 2026-07-18（Redis 命令行连接与账号密码）

### 会话的主要目的
- 说明 redis-cli 如何连接，以及用户名/密码（AUTH/ACL）怎么用

### 完成的主要任务
1. 介绍默认无密码连接、requirepass、Redis 6 ACL 用户名密码用法

### 关键决策和解决方案
- 默认安装通常无认证；设置 `requirepass` 或 ACL 后再用 `-a` / `AUTH` 连接

### 使用的技术栈
- redis-cli、Redis AUTH / ACL

### 修改了哪些文件
- `README.md`（追加本条总结）

### 修改文件的目的是什么
- 按项目规则记录会话答疑

---

## 2026-07-18（Redis 删除所有 key）

### 会话的主要目的
- 说明清空当前库/全部库所有 key 的命令

### 完成的主要任务
1. 给出 FLUSHDB、FLUSHALL 及安全注意点

### 关键决策和解决方案
- 当前库用 FLUSHDB；所有库用 FLUSHALL；生产慎用

### 使用的技术栈
- Redis CLI

### 修改了哪些文件
- `README.md`（追加本条总结）

### 修改文件的目的是什么
- 按项目规则记录会话答疑

---

## 2026-07-18（Redis 查看所有 key）

### 会话的主要目的
- 说明查看当前库全部 key 的命令

### 完成的主要任务
1. 给出 KEYS * 与 SCAN 游标遍历两种方式

### 关键决策和解决方案
- 本地调试可用 KEYS *；数据量大时用 SCAN 避免阻塞

### 使用的技术栈
- Redis CLI

### 修改了哪些文件
- `README.md`（追加本条总结）

### 修改文件的目的是什么
- 按项目规则记录会话答疑

---

## 2026-07-18（给 Redis 设置密码）

### 会话的主要目的
- 说明如何为 Redis 配置访问密码

### 完成的主要任务
1. 给出 redis.conf requirepass、运行时 CONFIG SET、以及 redis-cli 认证方式

### 关键决策和解决方案
- 持久化推荐改配置文件 requirepass 后重启；临时可用 CONFIG SET requirepass

### 使用的技术栈
- Redis 配置 / AUTH

### 修改了哪些文件
- `README.md`（追加本条总结）

### 修改文件的目的是什么
- 按项目规则记录会话答疑

---

## 2026-07-18（redis-cli 指定 IP 和密码）

### 会话的主要目的
- 说明 redis-cli 连接时如何指定主机 IP 与密码

### 完成的主要任务
1. 给出 `-h` / `-p` / `-a` 及 `--user` 示例

### 关键决策和解决方案
- `redis-cli -h IP -p 端口 -a 密码`

### 使用的技术栈
- redis-cli

### 修改了哪些文件
- `README.md`（追加本条总结）

### 修改文件的目的是什么
- 按项目规则记录会话答疑

---

## 2026-07-18（商城登录注册真实写库实现）

### 会话的主要目的
- 实现 CursorOnlineShoppingMall 登录/注册模块前后端，真实写入 MySQL

### 完成的主要任务
1. 启用数据源；新增 MallUser 实体 / Mapper / Dao / AuthService / MailService
2. 实现注册（SHA-256 落库 + 异步邮件）、登录（Session）、退出、当前用户 API
3. 登录拦截器保护首页等；login.jsp / register.jsp + CSS/JS AJAX
4. 本机导入 `schema.sql` / `data.sql`；`mvn compile` 通过

### 关键决策和解决方案
- 密码 SHA-256 十六进制小写，与 data.sql 中 demo/123456 一致
- `mall.mail.enabled=false` 时邮件仅打日志，不阻断注册写库
- 接口：`POST /api/auth/register|login|logout`，`GET /api/auth/me`

### 使用的技术栈
- Spring Boot 2.7、MyBatis-Plus、Session、JSP、原生 JS、MySQL、可选 JavaMail

### 修改了哪些文件
- 新增：Auth*、MallUser*、PasswordHasher、LoginAuthInterceptor、login/register.jsp 等
- 修改：`MallApplication.java`、`pom.xml`、`application.yml`、`mall.css`、`mall.js`、`HomeController.java`、`README.md`

### 修改文件的目的是什么
- 落地需求 0.1–0.3 的登录注册与登录拦截，并保证注册真实入库

---

## 2026-07-18（配置商城 MySQL 库表与演示数据）

### 会话的主要目的
- 代用户完成 CursorOnlineShoppingMall 数据库初始化配置

### 完成的主要任务
1. 确认本机 MySQL 已运行（mysqld is alive）
2. 创建库 `cursor_online_shopping_mall` 并导入 schema.sql、data.sql
3. 验证演示用户 `demo` 已写入 mall_user

### 关键决策和解决方案
- 数据源与 `application.yml` 一致：root / 12345678 / 库名 cursor_online_shopping_mall
- 邮件仍保持 `mall.mail.enabled=false`（无真实 SMTP 账号前不启真发信）

### 使用的技术栈
- MySQL 8、SQL 脚本导入

### 修改了哪些文件
- 数据库：新建/灌入 `cursor_online_shopping_mall` 各表与演示数据
- `README.md`（追加本条总结）

### 修改文件的目的是什么
- 让登录注册可直接连库验证

---

## 2026-07-18（配置 QQ 邮箱 SMTP 发送注册邮件）

### 会话的主要目的
- 按用户提供的 QQ 邮箱与授权码，开启注册成功真实发信

### 完成的主要任务
1. 更新 `application.yml`：`smtp.qq.com:465` + SSL
2. 设置发件账号为用户 QQ 邮箱，`mall.mail.enabled=true`

### 关键决策和解决方案
- 使用 QQ 授权码而非 QQ 登录密码
- README 不记录授权码明文；提醒勿将含密钥的配置推到公开仓库

### 使用的技术栈
- Spring Mail、QQ SMTP

### 修改了哪些文件
- `CursorOnlineShoppingMall/src/main/resources/application.yml`
- `README.md`

### 修改文件的目的是什么
- 注册成功后异步向用户邮箱发送通知邮件

---

## 2026-07-18（注册改为邮箱 6 位验证码）

### 会话的主要目的
- 按更新后的需求 0.2.2：注册前向邮箱发送 6 位验证码，校验后再注册

### 完成的主要任务
1. 新增 `POST /api/auth/send-register-code` 与 `RegisterCodeStore`
2. 注册接口增加 `verifyCode` 校验（一次性、5 分钟有效、60 秒重发限制）
3. 更新注册页 UI/JS、拦截器放行、接口文档

### 关键决策和解决方案
- 验证码邮件同步发送，便于前端获知成败；注册成功不再另发成功邮件
- 验证码存内存（ConcurrentHashMap），与 QQ SMTP 已有配置配合

### 使用的技术栈
- Spring Boot、JavaMail、JSP/原生 JS

### 修改了哪些文件
- 后端：Auth*、MailService*、RegisterCodeStore、RegisterRequest、WebMvcConfig 等
- 前端：register.jsp、mall.js、mall.css
- 文档：前后端接口文档.md、README.md

### 修改文件的目的是什么
- 对齐需求文档「邮件发送 6 位验证码后完成注册」

---

## 2026-07-18（确认注册邮件发件邮箱）

### 会话的主要目的
- 确认验证码邮件是否使用用户提供的 QQ 邮箱发出

### 完成的主要任务
1. 核对 `application.yml` 中 `spring.mail.username` 与 `mall.mail.enabled`

### 关键决策和解决方案
- 发件人即为用户提供的 QQ 邮箱；收件人为注册页填写的邮箱

### 使用的技术栈
- Spring Mail / QQ SMTP

### 修改了哪些文件
- `README.md`（追加本条答疑总结）

### 修改文件的目的是什么
- 记录发件账号确认说明

---

## 2026-07-18（解决 8081 端口占用无法启动）

### 会话的主要目的
- 处理 MallApplication 启动失败：Port 8081 was already in use

### 完成的主要任务
1. 定位占用 8081 的进程：java PID 81522
2. 结束该进程，释放端口

### 关键决策和解决方案
- 多为上次未停干净的 Spring Boot 实例；`kill` 释放后可重新 Run

### 使用的技术栈
- macOS `lsof` / 进程管理

### 修改了哪些文件
- `README.md`（追加本条总结）

### 修改文件的目的是什么
- 记录端口占用排查与处理

---

## 2026-07-18（商城预览进程退出通知）

### 会话的主要目的
- 告知用户此前用于验证首页的 Spring Boot 后台任务已结束（exit 1）

### 完成的主要任务
1. 查看终端输出并简要说明进程已不在运行

### 关键决策和解决方案
- 如需再次预览首页，重新启动 `MallApplication` 或 `mvn spring-boot:run`

### 使用的技术栈
- Spring Boot / CursorOnlineShoppingMall

### 修改了哪些文件
- `README.md`（追加本条总结）

### 修改文件的目的是什么
- 按项目规则记录会话通知处理

---

## 2026-07-18（lsof 命令用法说明）

### 会话的主要目的
- 讲解 macOS/Linux 下 `lsof` 的常用用法（查端口占用）

### 完成的主要任务
1. 说明 `lsof` 含义与查监听端口、按 PID 杀进程的常用命令

### 关键决策和解决方案
- 查端口：`lsof -nP -iTCP:端口 -sTCP:LISTEN`
- 结束进程：`kill PID` 或 `kill -9 PID`

### 使用的技术栈
- 终端命令 lsof

### 修改了哪些文件
- `README.md`（追加本条答疑总结）

### 修改文件的目的是什么
- 记录学习笔记

---

## 2026-07-18（如何用 lsof 查看端口占用）

### 会话的主要目的
- 学习用 `lsof` 查看某端口被哪个进程占用

### 完成的主要任务
1. 说明常用 `lsof -iTCP:端口 -sTCP:LISTEN` 用法
2. 补充结束进程的 `kill` 示例

### 关键决策和解决方案
- 看 LISTEN 状态即可定位占用端口的服务进程；结合 PID 用 kill 释放

### 使用的技术栈
- macOS / Unix `lsof`

### 修改了哪些文件
- `README.md`（追加本条答疑总结）

### 修改文件的目的是什么
- 记录端口排查命令，便于后续自学

---

## 2026-07-18（实现退出登录 0.4）

### 会话的主要目的
- 按需求文档新增 0.4 退出登录：清 Session，昵称消失，顶部显示登录/注册

### 完成的主要任务
1. 新增 `MeController` + `me.jsp`（已登录 / 游客双态）
2. 退出按钮调用已有 `POST /api/auth/logout`，成功后回到 `/me` 游客态
3. `/me` 放行登录拦截，以便退出后停留展示登录+注册按钮

### 关键决策和解决方案
- 复用后端 logout API；前端确认后退出并刷新「我的」页
- 游客顶部展示登录+注册（对齐 0.4.1）；订单/地址入口仅登录可见

### 使用的技术栈
- Spring MVC、Session、JSP/JSTL、原生 JS/CSS

### 修改了哪些文件
- 新增：`MeController.java`、`me.jsp`
- 修改：`WebMvcConfig.java`、`mall.css`、`mall.js`、接口文档、`README.md`

### 修改文件的目的是什么
- 落地退出登录交互与游客态 UI

---

## 2026-07-18（Mac 自带快捷键设置入口）

### 会话的主要目的
- 说明 macOS 系统自带键盘快捷键的查看与自定义位置

### 完成的主要任务
1. 给出系统设置路径：键盘 → 键盘快捷键
2. 列出常用分类与注意点

### 关键决策和解决方案
- 使用「系统设置 → 键盘 → 键盘快捷键」管理；冲突时可关闭或改键

### 使用的技术栈
- macOS 系统设置

### 修改了哪些文件
- `README.md`（追加本条答疑总结）

### 修改文件的目的是什么
- 记录 Mac 快捷键设置入口，便于自学

---

## 2026-07-18（取消 / 改掉 Mac ⌘Q 退出快捷键）

### 会话的主要目的
- 说明如何避免误触 Command+Q 退出应用

### 完成的主要任务
1. 给出系统设置「App 快捷键」改绑退出菜单的步骤
2. 说明全局彻底禁用可借助 Karabiner-Elements

### 关键决策和解决方案
- 系统无「直接关闭 ⌘Q」开关；用 App 快捷键把「退出」改成更难按的组合，或用 Karabiner 拦截

### 使用的技术栈
- macOS 系统设置 /（可选）Karabiner-Elements

### 修改了哪些文件
- `README.md`（追加本条答疑总结）

### 修改文件的目的是什么
- 记录取消 ⌘Q 的可行做法

---

## 2026-07-18（Karabiner-Elements 禁用 ⌘Q 设置说明）

### 会话的主要目的
- 指导用 Karabiner-Elements 拦截 / 改写 Command+Q

### 完成的主要任务
1. 说明安装、授权与 Complex Modifications 配置步骤
2. 给出禁用 ⌘Q 的 JSON 规则示例思路

### 关键决策和解决方案
- 用 Complex Modifications 将 `command+q` 映射为无操作或其它组合键，避免误退 App

### 使用的技术栈
- Karabiner-Elements

### 修改了哪些文件
- `README.md`（追加本条答疑总结）

### 修改文件的目的是什么
- 记录 Karabiner 配置步骤

---

## 2026-07-18（Cursor MCP 是什么）

### 会话的主要目的
- 解释 Cursor 中 MCP（Model Context Protocol）的含义与用途

### 完成的主要任务
1. 说明 MCP 是模型与外部工具/数据源的标准连接协议
2. 举例常见用途（浏览器、数据库、文档、GitHub 等）

### 关键决策和解决方案
- 用「给 AI 插上外部能力插头」类比；在 Cursor Settings → MCP 中配置服务器

### 使用的技术栈
- Cursor、MCP（Model Context Protocol）

### 修改了哪些文件
- `README.md`（追加本条答疑总结）

### 修改文件的目的是什么
- 记录 MCP 概念说明，便于学习 Cursor

---

## 2026-07-18（解释 Cursor Skill 是什么）

### 会话的主要目的
- 向用户说明 Cursor Skill 的含义与用途

### 完成的主要任务
1. 基于 create-skill 文档概括 Skill 定义、存放位置与触发方式

### 关键决策和解决方案
- Skill = 可复用的代理能力说明（SKILL.md）；按任务自动或显式选用

### 使用的技术栈
- Cursor Agent Skills

### 修改了哪些文件
- `README.md`（追加本条答疑总结）

### 修改文件的目的是什么
- 按项目规则记录会话答疑

---

## 2026-07-18（Cursor Skill 教程）

### 会话的主要目的
- 为用户提供 Cursor Skill 从概念到动手的教程

### 完成的主要任务
1. 说明 Skill 是什么、目录结构、个人/项目存放位置、description 写法、触发方式与示例

### 关键决策和解决方案
- 以官方 create-skill 规范为准；示例用「会话结束追加 README」类项目习惯技能

### 使用的技术栈
- Cursor Agent Skills（SKILL.md）

### 修改了哪些文件
- `README.md`（追加本条总结）

### 修改文件的目的是什么
- 按项目规则记录教程答疑

---

## 2026-07-18（再次简述什么是 Skills）

### 会话的主要目的
- 用更短的话解释 Cursor Skills 是什么

### 完成的主要任务
1. 一句话定义 + 与 Rule 区别 + 存放位置

### 关键决策和解决方案
- Skills = Agent 可复用的任务手册（SKILL.md）

### 使用的技术栈
- Cursor Agent Skills

### 修改了哪些文件
- `README.md`（追加本条总结）

### 修改文件的目的是什么
- 按项目规则记录会话答疑

---

## 2026-07-18（Skills 是否只有 Cursor 才有）

### 会话的主要目的
- 说明 Skills 是否为 Cursor 独有

### 完成的主要任务
1. 区分「Cursor Agent Skills 产品形态」与「给 AI 挂专项能力」的通用概念

### 关键决策和解决方案
- Cursor 的 SKILL.md / 目录约定是 Cursor 体系内的；同类能力在其他产品里常有不同名字与格式

### 使用的技术栈
- Cursor Agent Skills（概念对比）

### 修改了哪些文件
- `README.md`（追加本条总结）

### 修改文件的目的是什么
- 按项目规则记录会话答疑

---

## 2026-07-18（生成 commit-helper Skill）

### 会话的主要目的
- 为用户创建可用的 Cursor commit Skill

### 完成的主要任务
1. 在 `~/.cursor/skills/commit-helper/SKILL.md` 写入提交流程、文案规范与安全约束

### 关键决策和解决方案
- 放个人技能目录，全项目可用；未设 disable-model-invocation，便于用户说「提交/commit」时自动选用
- 流程对齐既有 git 安全规则（并行 status/diff/log、HEREDOC、不擅自 push）

### 使用的技术栈
- Cursor Agent Skills、Git

### 修改了哪些文件
- `~/.cursor/skills/commit-helper/SKILL.md`（新建）
- `README.md`（追加本条总结）

### 修改文件的目的是什么
- 提供可复用的安全 commit 技能；并按规则记录会话

---

## 2026-07-18（说明 commit-helper 约束）

### 会话的主要目的
- 向用户说明刚生成的 commit-helper Skill 有哪些约束与规定

### 完成的主要任务
1. 归纳触发条件、流程、文案风格、安全禁令等要点

### 关键决策和解决方案
- 以 `~/.cursor/skills/commit-helper/SKILL.md` 原文为准作答

### 使用的技术栈
- Cursor Agent Skills

### 修改了哪些文件
- `README.md`（追加本条总结）

### 修改文件的目的是什么
- 按项目规则记录会话答疑

---

## 2026-07-18（commit-helper 强制带 issue 号）

### 会话的主要目的
- 按用户要求更新 commit-helper：提交说明必须带 issue 号

### 完成的主要任务
1. 修改 `~/.cursor/skills/commit-helper/SKILL.md`，要求 `(#N)` / `#N` / `Fixes|Closes|Refs #N`，缺失则先询问

### 关键决策和解决方案
- 不允许编造 issue 号；示例文案同步加上 issue 引用

### 使用的技术栈
- Cursor Agent Skills

### 修改了哪些文件
- `~/.cursor/skills/commit-helper/SKILL.md`
- `README.md`（追加本条总结）

### 修改文件的目的是什么
- 落实「commit 必须带 issue 号」约束

---

## 2026-07-18（澄清 commit-helper issue 号是否硬拦截）

### 会话的主要目的
- 说明「必须带 issue 号」是 Skill 对 Agent 的约束，还是 git 硬性拦截

### 完成的主要任务
1. 澄清：Skill 会让 Agent 缺号时先询问；裸 git commit 本身不会因此失败

### 关键决策和解决方案
- 若需真正提交失败拦截，需另加 commit-msg hook / CI 检查

### 使用的技术栈
- Cursor Skills vs Git hooks

### 修改了哪些文件
- `README.md`（追加本条总结）

### 修改文件的目的是什么
- 按项目规则记录会话答疑

---

## 2026-07-18（说明说「提交」时是否自动用 skill）

### 会话的主要目的
- 解释用户说「提交」时 Agent 是否自动按 commit-helper 生成 message

### 完成的主要任务
1. 说明 description 匹配后会加载 skill；生成 message 并在明确要求时执行 commit

### 关键决策和解决方案
- 点名 commit-helper 最稳；日常说「帮我 commit/#issue」通常会触发

### 使用的技术栈
- Cursor Agent Skills

### 修改了哪些文件
- `README.md`（追加本条总结）

### 修改文件的目的是什么
- 按项目规则记录会话答疑

---

## 2026-07-18（用户请求提交，等待 issue 号）

### 会话的主要目的
- 用户要求提交代码；按 commit-helper 需 issue 号，暂未执行 commit

### 完成的主要任务
1. 检查 git status/diff/log，确认有商城模块等大量已暂存/未暂存变更
2. 向用户索取 issue 号后再提交

### 关键决策和解决方案
- 遵守 commit-helper：无 issue 不提交、不编造编号

### 使用的技术栈
- Git、Cursor commit-helper Skill

### 修改了哪些文件
- `README.md`（追加本条总结）

### 修改文件的目的是什么
- 按项目规则记录会话状态

---
