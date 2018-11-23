function findElementType(array) {
  let differentTimes = 0;
  let elementType = [];
  elementType.push(array[0]);
  for (let i = 1; i < array.length; i++) {
    for (let j = 0; j < elementType.length; j++) {
      if (array[i] != elementType[j]) {
        differentTimes++;
      }
    }
    if (differentTimes === elementType.length) {
      elementType.push(array[i]);
    }
    differentTimes = 0;
  }
  return elementType;
}

function recordElementRepeatTimes(array) {
  const elementType = findElementType(array);
  let repeatTimes = new Array(elementType.length).fill(0);
  for (let i = 0; i < array.length; i++) {
    for (let j = 0; j < elementType.length; j++) {
      if (array[i] === elementType[j]) {
        repeatTimes[j]++;
      }
    }
  }
  return repeatTimes;
}

function findMaxElementRepeatTimes(array) {
  const repeatTimes = recordElementRepeatTimes(array);
  return Math.max(...repeatTimes);
}

let a = [3, 'a', 'a', 'a', 2, 3, 'a', 3, 'a', 2, 4, 9, 3];
let maxRepeatTimes = findMaxElementRepeatTimes(a);

document.write("The array is: [" + a + "]</br>");
document.write("The most frequently occurring element in the array is: " + maxRepeatTimes);