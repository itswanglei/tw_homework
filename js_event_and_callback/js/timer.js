let start = document.getElementById("start");
let stop = document.getElementById("stop");

function timing() {
  let displayTime = 0;
  let setTiming;
  start.onclick = function StartTiming() {
    document.getElementById("result").value = displayTime;
    displayTime ++;
    setTiming = setTimeout(StartTiming, 1000);
  }
  stop.onclick = function stopTiming() {
    clearTimeout(setTiming);
    displayTime = 0;
  }
}

timing();