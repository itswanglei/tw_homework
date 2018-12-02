let displayTime = 0;
let setTiming;

function startTiming() {
  document.getElementById("result").value = displayTime;
  displayTime++;
  setTiming = setTimeout(startTiming, 1000);
}

function stopTiming() {
  if (setTiming) {
    clearTimeout(setTiming);
  }
  displayTime = 0;
}
