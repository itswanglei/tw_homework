function verifyUsernameAndPassword() {
  let username = document.getElementById("username").value;
  let password = document.getElementById("password").value;
  if (username != "123" || password != "123") {
    alert("用户名或密码错误！");
    document.getElementById("password").value = "";
  } else {
    alert("登录成功！")
  }
}