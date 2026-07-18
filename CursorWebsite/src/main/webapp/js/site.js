/**
 * 全站原生脚本：顶栏滚动、更多菜单、移动端抽屉。
 * （由 Curosr 自动生成）
 */
(function () {
  /**
   * 初始化顶栏滚动加深效果。
   * （由 Curosr 自动生成）
   */
  function initHeaderScroll() {
    var header = document.querySelector(".site-header");
    if (!header) {
      return;
    }
    function onScroll() {
      if (window.scrollY > 40) {
        header.classList.add("is-scrolled");
      } else {
        header.classList.remove("is-scrolled");
      }
    }
    onScroll();
    window.addEventListener("scroll", onScroll, { passive: true });
  }

  /**
   * 初始化桌面端「更多」下拉。
   * （由 Curosr 自动生成）
   */
  function initMoreMenu() {
    var more = document.querySelector(".nav-more");
    var btn = document.querySelector(".nav-more__btn");
    if (!more || !btn) {
      return;
    }
    btn.addEventListener("click", function (e) {
      e.stopPropagation();
      more.classList.toggle("is-open");
    });
    document.addEventListener("click", function () {
      more.classList.remove("is-open");
    });
  }

  /**
   * 初始化移动端导航抽屉。
   * （由 Curosr 自动生成）
   */
  function initMobileDrawer() {
    var toggle = document.querySelector(".nav-toggle");
    var drawer = document.querySelector(".nav-drawer");
    if (!toggle || !drawer) {
      return;
    }
    toggle.addEventListener("click", function () {
      drawer.classList.toggle("is-open");
    });
  }

  /**
   * 转义 HTML 文本，避免注入。
   * （由 Curosr 自动生成）
   *
   * @param {string} text 原始文本
   * @returns {string} 转义后文本
   */
  function escapeHtml(text) {
    if (text == null) {
      return "";
    }
    return String(text)
      .replace(/&/g, "&amp;")
      .replace(/</g, "&lt;")
      .replace(/>/g, "&gt;")
      .replace(/"/g, "&quot;");
  }

  /**
   * 渲染一条新闻网格卡片 HTML。
   * （由 Curosr 自动生成）
   *
   * @param {string} ctx 上下文路径
   * @param {object} item 新闻对象
   * @returns {string} li 节点 HTML
   */
  function renderNewsFeedItem(ctx, item) {
    var cover = item.coverUrl
      ? '<img class="news-feed-card__cover" src="' +
        escapeHtml(item.coverUrl) +
        '" alt="' +
        escapeHtml(item.title) +
        '" loading="lazy">'
      : "";
    var meta =
      '<time datetime="' +
      escapeHtml(item.publishDate) +
      '">' +
      escapeHtml(item.publishDate) +
      "</time>";
    if (item.category) {
      meta += " · " + escapeHtml(item.category);
    }
    return (
      '<li class="news-feed__item">' +
      '<a class="news-feed-card" href="' +
      ctx +
      "/news-detail.jsp?id=" +
      encodeURIComponent(item.id) +
      '">' +
      cover +
      '<div class="news-feed-card__body">' +
      '<h3 class="news-feed-card__title">' +
      escapeHtml(item.title) +
      "</h3>" +
      '<p class="news-feed-card__meta">' +
      meta +
      "</p>" +
      "</div></a></li>"
    );
  }

  /**
   * 新闻列表「显示更多」：请求下一页并追加到网格。
   * （由 Curosr 自动生成）
   */
  function initNewsLoadMore() {
    var root = document.querySelector(".news-center");
    var btn = document.getElementById("news-more-btn");
    var feed = document.getElementById("news-feed");
    if (!root || !btn || !feed) {
      return;
    }

    var ctx = root.getAttribute("data-ctx") || "";
    var category = root.getAttribute("data-category") || "all";
    var page = parseInt(root.getAttribute("data-page") || "1", 10);
    var size = parseInt(root.getAttribute("data-size") || "6", 10);
    var hasMore = root.getAttribute("data-has-more") === "true";
    var loading = false;

    function setMoreVisible(visible) {
      if (visible) {
        btn.hidden = false;
        btn.classList.remove("is-hidden");
      } else {
        btn.hidden = true;
        btn.classList.add("is-hidden");
      }
    }

    setMoreVisible(hasMore);

    btn.addEventListener("click", function () {
      if (loading || !hasMore) {
        return;
      }
      loading = true;
      btn.textContent = "加载中…";
      var nextPage = page + 1;
      var url =
        ctx +
        "/api/news?page=" +
        encodeURIComponent(nextPage) +
        "&size=" +
        encodeURIComponent(size) +
        "&category=" +
        encodeURIComponent(category);

      fetch(url)
        .then(function (res) {
          return res.json();
        })
        .then(function (json) {
          if (!json || json.code !== 0 || !json.data) {
            throw new Error((json && json.message) || "load failed");
          }
          var data = json.data;
          var items = data.items || [];
          var html = "";
          for (var i = 0; i < items.length; i++) {
            html += renderNewsFeedItem(ctx, items[i]);
          }
          if (html) {
            feed.insertAdjacentHTML("beforeend", html);
          }
          page = data.page || nextPage;
          hasMore = !!data.hasMore;
          root.setAttribute("data-page", String(page));
          root.setAttribute("data-has-more", String(hasMore));
          setMoreVisible(hasMore);
          btn.textContent = "显示更多";
        })
        .catch(function () {
          btn.textContent = "重试";
        })
        .finally(function () {
          loading = false;
        });
    });
  }

  /**
   * 格式化留言时间展示。
     * （由 Curosr 自动生成）
     *
     * @param {string} value ISO 时间
     * @returns {string} 展示文本
     */
  function formatGuestbookTime(value) {
    if (!value) {
      return "";
    }
    return String(value).replace("T", " ").substring(0, 19);
  }

  /**
   * 渲染一条公开留言 HTML。
   * （由 Curosr 自动生成）
   *
   * @param {object} item 留言对象
   * @returns {string} li HTML
   */
  function renderGuestbookItem(item) {
    var nick = escapeHtml(item.nickname || "");
    var initial = nick ? nick.charAt(0) : "?";
    var time = formatGuestbookTime(item.createdAt);
    var reply = "";
    if (item.reply) {
      reply =
        '<div class="guestbook-item__reply">' +
        '<span class="guestbook-item__reply-tag">回复</span>' +
        "<p>" +
        escapeHtml(item.reply) +
        "</p></div>";
    }
    return (
      '<li class="guestbook-item">' +
      '<div class="guestbook-item__head">' +
      '<span class="guestbook-item__avatar" aria-hidden="true">' +
      initial +
      "</span>" +
      '<div class="guestbook-item__meta">' +
      '<span class="guestbook-item__name">' +
      nick +
      "</span>" +
      '<time class="guestbook-item__time" datetime="' +
      escapeHtml(item.createdAt) +
      '">' +
      escapeHtml(time) +
      "</time></div></div>" +
      '<p class="guestbook-item__content">' +
      escapeHtml(item.content || "") +
      "</p>" +
      reply +
      "</li>"
    );
  }

  /**
   * 初始化留言板：提交表单与加载更多。
   * （由 Curosr 自动生成）
   */
  function initGuestbook() {
    var root = document.querySelector(".guestbook");
    if (!root) {
      return;
    }
    var ctx = root.getAttribute("data-ctx") || "";
    var form = document.getElementById("guestbook-form");
    var feedback = document.getElementById("guestbook-feedback");
    var submitBtn = document.getElementById("guestbook-submit");
    var list = document.getElementById("guestbook-list");
    var moreBtn = document.getElementById("guestbook-more-btn");
    var page = parseInt(root.getAttribute("data-page") || "1", 10);
    var size = parseInt(root.getAttribute("data-size") || "10", 10);
    var hasMore = root.getAttribute("data-has-more") === "true";
    var loadingMore = false;

    function showFeedback(ok, text) {
      if (!feedback) {
        return;
      }
      feedback.hidden = false;
      feedback.textContent = text;
      feedback.classList.toggle("is-ok", !!ok);
      feedback.classList.toggle("is-err", !ok);
    }

    function setMoreVisible(visible) {
      if (!moreBtn) {
        return;
      }
      if (visible) {
        moreBtn.hidden = false;
        moreBtn.classList.remove("is-hidden");
      } else {
        moreBtn.hidden = true;
        moreBtn.classList.add("is-hidden");
      }
    }

    setMoreVisible(hasMore);

    if (form) {
      form.addEventListener("submit", function (e) {
        e.preventDefault();
        var nickname = (form.nickname.value || "").trim();
        var email = (form.email.value || "").trim();
        var content = (form.content.value || "").trim();
        if (!nickname) {
          showFeedback(false, "请填写昵称");
          return;
        }
        if (!content) {
          showFeedback(false, "请填写留言内容");
          return;
        }
        if (submitBtn) {
          submitBtn.disabled = true;
        }
        fetch(ctx + "/api/guestbook", {
          method: "POST",
          headers: { "Content-Type": "application/json" },
          body: JSON.stringify({
            nickname: nickname,
            email: email || null,
            content: content,
          }),
        })
          .then(function (res) {
            return res.json();
          })
          .then(function (json) {
            if (!json || json.code !== 0) {
              throw new Error((json && json.message) || "提交失败");
            }
            form.reset();
            showFeedback(true, json.message || "已提交，审核后公开");
          })
          .catch(function (err) {
            showFeedback(false, err.message || "提交失败，请稍后重试");
          })
          .finally(function () {
            if (submitBtn) {
              submitBtn.disabled = false;
            }
          });
      });
    }

    if (moreBtn && list) {
      moreBtn.addEventListener("click", function () {
        if (loadingMore || !hasMore) {
          return;
        }
        loadingMore = true;
        moreBtn.textContent = "加载中…";
        var nextPage = page + 1;
        fetch(
          ctx +
            "/api/guestbook?page=" +
            encodeURIComponent(nextPage) +
            "&size=" +
            encodeURIComponent(size)
        )
          .then(function (res) {
            return res.json();
          })
          .then(function (json) {
            if (!json || json.code !== 0 || !json.data) {
              throw new Error((json && json.message) || "加载失败");
            }
            var data = json.data;
            var items = data.items || [];
            var empty = document.getElementById("guestbook-empty");
            if (empty) {
              empty.remove();
            }
            var html = "";
            for (var i = 0; i < items.length; i++) {
              html += renderGuestbookItem(items[i]);
            }
            if (html) {
              list.insertAdjacentHTML("beforeend", html);
            }
            page = data.page || nextPage;
            hasMore = !!data.hasMore;
            root.setAttribute("data-page", String(page));
            root.setAttribute("data-has-more", String(hasMore));
            setMoreVisible(hasMore);
            moreBtn.textContent = "显示更多";
          })
          .catch(function () {
            moreBtn.textContent = "重试";
          })
          .finally(function () {
            loadingMore = false;
          });
      });
    }
  }

  document.addEventListener("DOMContentLoaded", function () {
    initHeaderScroll();
    initMoreMenu();
    initMobileDrawer();
    initNewsLoadMore();
    initGuestbook();
  });
})();
