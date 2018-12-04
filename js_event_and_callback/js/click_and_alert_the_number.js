let list = document.getElementsByTagName("li");

// Method 1
function clickList() {
  for (let i = 0; i < list.length; i++) {
    list[i].onclick = function () {
      alert(list[i].innerHTML);
    }
  }
}

clickList();

// Method 2: Use event delegation
document.getElementById("no").addEventListener("click", function (e) {
  if (e.target && e.target.nodeName == "LI") {
    alert(e.target.innerHTML);
  }
});