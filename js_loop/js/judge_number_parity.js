function isEven(number) {
  return number % 2 === 0;
}

function outputNumberParity(beginNumber, endNumber) {
  for (let i = beginNumber; i <= endNumber; i++) {
    document.write(i + (isEven(i) ? "是偶数。</br>" : "是奇数。</br>"));
  }
}
const beginNumber = 1;
const endNumber = 20;
outputNumberParity(beginNumber, endNumber);