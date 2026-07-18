由 cursor 自动创建一个网站，实现前后端的功能。

## 技术栈（对齐架构文档）

- 前端：HTML / JSP / CSS / 原生 JS（无前端框架）
- 后端：**Spring Boot 2.7.18** + **MyBatis-Plus** + **MySQL 8**
- 启动类：`cursor.website.SiteApplication`

## 首页（已实现 · 查库）

- 页面：`GET /` 或 `GET /home` → `WEB-INF/jsp/home.jsp`
- API：`GET /api/home`、`GET /api/news?limit=3`
- 表：`site_config`、`home_feature`、`news`

## 数据库准备

1. 安装并启动 MySQL
2. 执行：

```sql
CREATE DATABASE IF NOT EXISTS cursor_website DEFAULT CHARACTER SET utf8mb4;
```

3. 修改 `src/main/resources/application.properties` 中的账号密码（默认 `root/root`）
4. 启动应用后会自动执行 `classpath:db/schema.sql` 与 `data.sql` 建表并写入演示数据

## 本地运行

```bash
cd CursorWebsite
mvn spring-boot:run
```

浏览器访问：http://localhost:8080/CursorWebsite/
