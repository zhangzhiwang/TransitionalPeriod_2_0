/**
 * CursorOnlineShoppingMall 前端脚本：首页轮播、登录注册 AJAX。
 * （由 Curosr 自动生成）
 */
(function () {
  /** 应用上下文路径。 */
  var CTX = window.MALL_CTX || '';

  /**
   * 显示短暂提示。
   * （由 Curosr 自动生成）
   *
   * @param {string} message 提示文案
   */
  function showToast(message) {
    var el = document.getElementById('mallToast');
    if (!el) {
      return;
    }
    el.textContent = message;
    el.hidden = false;
    clearTimeout(showToast._timer);
    showToast._timer = setTimeout(function () {
      el.hidden = true;
    }, 1600);
  }

  /**
   * 读取 URL 查询参数。
   * （由 Curosr 自动生成）
   *
   * @param {string} name 参数名
   * @return {string|null} 参数值
   */
  function queryParam(name) {
    var search = window.location.search || '';
    if (search.charAt(0) === '?') {
      search = search.substring(1);
    }
    var parts = search.split('&');
    for (var i = 0; i < parts.length; i++) {
      var kv = parts[i].split('=');
      if (decodeURIComponent(kv[0] || '') === name) {
        return decodeURIComponent((kv[1] || '').replace(/\+/g, ' '));
      }
    }
    return null;
  }

  /**
   * 发送 JSON 请求。
   * （由 Curosr 自动生成）
   *
   * @param {string} url 相对 CTX 的路径
   * @param {string} method HTTP 方法
   * @param {Object|null} body 请求体
   * @return {Promise<Object>} 解析后的 JSON
   */
  function requestJson(url, method, body) {
    var options = {
      method: method,
      credentials: 'same-origin',
      headers: {
        'Content-Type': 'application/json;charset=UTF-8',
        'Accept': 'application/json'
      }
    };
    if (body != null) {
      options.body = JSON.stringify(body);
    }
    return fetch(CTX + url, options).then(function (res) {
      return res.json().catch(function () {
        return { code: 500, message: '服务器响应异常', data: null };
      });
    });
  }

  /**
   * 展示表单错误文案。
   * （由 Curosr 自动生成）
   *
   * @param {HTMLElement|null} el 错误节点
   * @param {string} message 文案
   */
  function showFormError(el, message) {
    if (!el) {
      return;
    }
    if (!message) {
      el.hidden = true;
      el.textContent = '';
      return;
    }
    el.textContent = message;
    el.hidden = false;
  }

  /**
   * 初始化首页轮播：自动播放 + 圆点切换 + 简易滑动。
   * （由 Curosr 自动生成）
   */
  function initBanner() {
    var root = document.getElementById('homeBanner');
    if (!root) {
      return;
    }
    var slides = root.querySelectorAll('.banner__slide');
    var dots = root.querySelectorAll('.banner__dot');
    if (!slides.length) {
      return;
    }
    var index = 0;
    var timer = null;
    var interval = parseInt(root.getAttribute('data-interval') || '4000', 10);

    /**
     * 切换到指定下标。
     * （由 Curosr 自动生成）
     *
     * @param {number} next 目标下标
     */
    function go(next) {
      index = (next + slides.length) % slides.length;
      for (var i = 0; i < slides.length; i++) {
        slides[i].classList.toggle('is-active', i === index);
        if (dots[i]) {
          dots[i].classList.toggle('is-active', i === index);
        }
      }
    }

    /**
     * 重启自动播放。
     * （由 Curosr 自动生成）
     */
    function restart() {
      clearInterval(timer);
      timer = setInterval(function () {
        go(index + 1);
      }, interval);
    }

    for (var d = 0; d < dots.length; d++) {
      (function (dotIndex) {
        dots[dotIndex].addEventListener('click', function () {
          go(dotIndex);
          restart();
        });
      })(d);
    }

    var startX = 0;
    root.addEventListener('touchstart', function (e) {
      if (!e.changedTouches || !e.changedTouches.length) {
        return;
      }
      startX = e.changedTouches[0].clientX;
    }, { passive: true });

    root.addEventListener('touchend', function (e) {
      if (!e.changedTouches || !e.changedTouches.length) {
        return;
      }
      var dx = e.changedTouches[0].clientX - startX;
      if (Math.abs(dx) < 40) {
        return;
      }
      go(dx < 0 ? index + 1 : index - 1);
      restart();
    }, { passive: true });

    restart();
  }

  /**
   * 绑定加入购物车按钮（首页阶段仅 toast，不调接口）。
   * （由 Curosr 自动生成）
   */
  function initAddCart() {
    document.addEventListener('click', function (e) {
      var btn = e.target.closest ? e.target.closest('.js-add-cart') : null;
      if (!btn) {
        return;
      }
      var name = btn.getAttribute('data-product-name') || '商品';
      showToast('已加入购物车：' + name);
    });
  }

  /**
   * 初始化登录表单。
   * （由 Curosr 自动生成）
   */
  function initLoginForm() {
    var form = document.getElementById('loginForm');
    if (!form) {
      return;
    }
    var errorEl = document.getElementById('loginError');
    var submitBtn = document.getElementById('loginSubmit');
    form.addEventListener('submit', function (e) {
      e.preventDefault();
      showFormError(errorEl, '');
      var username = (document.getElementById('username').value || '').trim();
      var password = document.getElementById('password').value || '';
      if (!username || !password) {
        showFormError(errorEl, '请输入用户名和密码');
        return;
      }
      submitBtn.disabled = true;
      requestJson('/api/auth/login', 'POST', {
        username: username,
        password: password
      }).then(function (body) {
        if (body && body.code === 0) {
          showToast(body.message || '登录成功');
          var redirect = queryParam('redirect') || '/home';
          if (redirect.charAt(0) !== '/') {
            redirect = '/home';
          }
          window.location.href = CTX + redirect;
          return;
        }
        showFormError(errorEl, (body && body.message) || '登录失败');
      }).catch(function () {
        showFormError(errorEl, '网络异常，请稍后重试');
      }).then(function () {
        submitBtn.disabled = false;
      });
    });
  }

  /**
   * 初始化注册表单（含获取 6 位邮箱验证码）。
   * （由 Curosr 自动生成）
   */
  function initRegisterForm() {
    var form = document.getElementById('registerForm');
    if (!form) {
      return;
    }
    var errorEl = document.getElementById('registerError');
    var submitBtn = document.getElementById('registerSubmit');
    var sendCodeBtn = document.getElementById('sendCodeBtn');
    var countdownTimer = null;

    /**
     * 发送验证码按钮倒计时。
     * （由 Curosr 自动生成）
     *
     * @param {number} seconds 秒数
     */
    function startCountdown(seconds) {
      var left = seconds;
      sendCodeBtn.disabled = true;
      sendCodeBtn.textContent = left + 's 后重发';
      clearInterval(countdownTimer);
      countdownTimer = setInterval(function () {
        left -= 1;
        if (left <= 0) {
          clearInterval(countdownTimer);
          sendCodeBtn.disabled = false;
          sendCodeBtn.textContent = '获取验证码';
          return;
        }
        sendCodeBtn.textContent = left + 's 后重发';
      }, 1000);
    }

    if (sendCodeBtn) {
      sendCodeBtn.addEventListener('click', function () {
        showFormError(errorEl, '');
        var email = (document.getElementById('email').value || '').trim();
        if (!email) {
          showFormError(errorEl, '请先填写邮箱');
          return;
        }
        sendCodeBtn.disabled = true;
        requestJson('/api/auth/send-register-code', 'POST', { email: email })
          .then(function (body) {
            if (body && body.code === 0) {
              showToast(body.message || '验证码已发送');
              startCountdown(60);
              return;
            }
            showFormError(errorEl, (body && body.message) || '验证码发送失败');
            sendCodeBtn.disabled = false;
            sendCodeBtn.textContent = '获取验证码';
          })
          .catch(function () {
            showFormError(errorEl, '网络异常，请稍后重试');
            sendCodeBtn.disabled = false;
            sendCodeBtn.textContent = '获取验证码';
          });
      });
    }

    form.addEventListener('submit', function (e) {
      e.preventDefault();
      showFormError(errorEl, '');
      var username = (document.getElementById('username').value || '').trim();
      var password = document.getElementById('password').value || '';
      var confirmPassword = document.getElementById('confirmPassword').value || '';
      var email = (document.getElementById('email').value || '').trim();
      var verifyCode = (document.getElementById('verifyCode').value || '').trim();
      if (!username || !password || !confirmPassword || !email || !verifyCode) {
        showFormError(errorEl, '请完整填写注册信息与验证码');
        return;
      }
      if (password !== confirmPassword) {
        showFormError(errorEl, '两次密码不一致');
        return;
      }
      if (!/^\d{6}$/.test(verifyCode)) {
        showFormError(errorEl, '请输入 6 位数字验证码');
        return;
      }
      submitBtn.disabled = true;
      requestJson('/api/auth/register', 'POST', {
        username: username,
        password: password,
        confirmPassword: confirmPassword,
        email: email,
        verifyCode: verifyCode
      }).then(function (body) {
        if (body && body.code === 0) {
          showToast(body.message || '注册成功');
          setTimeout(function () {
            window.location.href = CTX + '/login';
          }, 600);
          return;
        }
        showFormError(errorEl, (body && body.message) || '注册失败');
      }).catch(function () {
        showFormError(errorEl, '网络异常，请稍后重试');
      }).then(function () {
        submitBtn.disabled = false;
      });
    });
  }

  /**
   * 初始化「我的」页退出登录。
   * （由 Curosr 自动生成）
   */
  function initLogout() {
    var btn = document.getElementById('logoutBtn');
    if (!btn) {
      return;
    }
    btn.addEventListener('click', function () {
      if (!window.confirm('确定退出登录吗？')) {
        return;
      }
      btn.disabled = true;
      requestJson('/api/auth/logout', 'POST', null)
        .then(function (body) {
          if (body && body.code === 0) {
            showToast(body.message || '已退出登录');
            setTimeout(function () {
              // 退出后回到「我的」游客态：昵称消失，顶部显示登录/注册
              window.location.href = CTX + '/me';
            }, 400);
            return;
          }
          showToast((body && body.message) || '退出失败');
          btn.disabled = false;
        })
        .catch(function () {
          showToast('网络异常，请稍后重试');
          btn.disabled = false;
        });
    });
  }

  /**
   * 页面初始化入口。
   * （由 Curosr 自动生成）
   */
  function boot() {
    initBanner();
    initAddCart();
    initLoginForm();
    initRegisterForm();
    initLogout();
  }

  if (document.readyState === 'loading') {
    document.addEventListener('DOMContentLoaded', boot);
  } else {
    boot();
  }
})();
