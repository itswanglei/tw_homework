function count() {
  readLocalStorage();
  document.getElementById("result").value = changeNumber();
}

function readLocalStorage() {
  createLocalStorage();
  document.getElementById("result").value = localStorage.clickCount;
}

function createLocalStorage() {
  if (!localStorage.clickCount) {
    localStorage.setItem("clickCount", "0");
  }
}

function changeNumber() {
  return localStorage.clickCount = Number(localStorage.clickCount) + 1;
}
