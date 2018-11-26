function JudgeParity(number) {
  let parity = "奇数";
  if (number % 2 === 0) {
    return parity = "偶数";
  }
  return parity = "奇数";
}

function outputNumberParity(beginNumber, endNumber) {
  for (let i = beginNumber; i <= endNumber; i++) {
    const parity = JudgeParity(i);
    document.write(i + "是" + parity + "。" + "</br>");
  }
}

const beginNumber = 1;
const endNumber = 20;
outputNumberParity(beginNumber,endNumber);