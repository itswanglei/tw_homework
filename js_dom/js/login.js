function isLoginSuccess(username, password) {
  return username === "123" && password === "123";
}

function showLoginResult() {
  let username = document.getElementById("username").value;
  let password = document.getElementById("password").value;
  if (isLoginSuccess(username, password)) {
    removeTips();
    creatTips("登录成功！");
  } else {
    removeTips();
    creatTips("用户名或密码错误！");
  }
}

function creatTips(tipString) {
  let tipPara = document.createElement("p");
  tipPara.setAttribute("id", "tipPara");
  let tip = document.createTextNode(tipString);
  tipPara.appendChild(tip);
  document.body.appendChild(tipPara);
}

function removeTips() {
  let tipPara = document.getElementById("tipPara");
  if (tipPara) {
    tipPara.parentNode.removeChild(tipPara);
  }
}