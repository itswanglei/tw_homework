function count() {
  readLocalStorage();
  document.getElementById("result").value = changeNumber();
}

function readLocalStorage() {
  creatLocalStorage();
  document.getElementById("result").value = localStorage.clickCount;
}

function creatLocalStorage() {
  if (!localStorage.clickCount) {
    localStorage.setItem("clickCount", "0");
  }
}

function changeNumber() {
  localStorage.clickCount = Number(localStorage.clickCount) + 1;
  return localStorage.clickCount;
}
