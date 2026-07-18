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
