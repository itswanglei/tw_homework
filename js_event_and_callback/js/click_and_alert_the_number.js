let list = document.getElementsByTagName("li");

function clickList() {
  for (let i = 0; i < list.length; i++) {
    list[i].onclick = function () {
      alert(list[i].innerHTML);
    }
  }
}

clickList();