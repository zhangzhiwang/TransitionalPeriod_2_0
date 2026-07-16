/**
 * 曜岩智造企业官网前端交互脚本。
 * 负责导航滚动态、移动端菜单、区块滚动显现与联系表单演示提交。
 * （由 Curosr 自动生成）
 */

/**
 * 初始化站点页头交互：滚动时增强背景，并处理移动端菜单开关。
 * （由 Curosr 自动生成）
 */
function initSiteHeader() {
  var header = document.querySelector(".site-header");
  var toggle = document.querySelector(".nav-toggle");
  var links = document.querySelector(".nav-links");

  if (!header) {
    return;
  }

  /**
   * 根据页面滚动位置切换导航栏样式。
   * （由 Curosr 自动生成）
   */
  function updateHeaderState() {
    if (window.scrollY > 24) {
      header.classList.add("is-scrolled");
    } else {
      header.classList.remove("is-scrolled");
    }
  }

  updateHeaderState();
  window.addEventListener("scroll", updateHeaderState, { passive: true });

  if (toggle && links) {
    toggle.addEventListener("click", function () {
      links.classList.toggle("is-open");
    });

    links.querySelectorAll("a").forEach(function (link) {
      link.addEventListener("click", function () {
        links.classList.remove("is-open");
      });
    });
  }
}

/**
 * 为带有 .reveal 的元素启用进入视口后的渐入动画。
 * （由 Curosr 自动生成）
 */
function initRevealOnScroll() {
  var nodes = document.querySelectorAll(".reveal");
  if (!nodes.length) {
    return;
  }

  if (!("IntersectionObserver" in window)) {
    nodes.forEach(function (node) {
      node.classList.add("is-visible");
    });
    return;
  }

  var observer = new IntersectionObserver(
    function (entries) {
      entries.forEach(function (entry) {
        if (entry.isIntersecting) {
          entry.target.classList.add("is-visible");
          observer.unobserve(entry.target);
        }
      });
    },
    { threshold: 0.18, rootMargin: "0px 0px -8% 0px" }
  );

  nodes.forEach(function (node) {
    observer.observe(node);
  });
}

/**
 * 初始化联系我们页留言表单：演示环境下拦截提交并给出反馈提示。
 * （由 Curosr 自动生成）
 */
function initContactForm() {
  var form = document.getElementById("contact-form");
  var note = document.getElementById("contact-form-note");
  if (!form) {
    return;
  }

  form.addEventListener("submit", function (event) {
    event.preventDefault();
    if (!form.checkValidity()) {
      form.reportValidity();
      return;
    }
    form.reset();
    if (note) {
      note.hidden = false;
    }
  });
}

/**
 * 页面加载完成后启动全部前端交互。
 * （由 Curosr 自动生成）
 */
document.addEventListener("DOMContentLoaded", function () {
  initSiteHeader();
  initRevealOnScroll();
  initContactForm();
});
