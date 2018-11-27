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

function recordElementRepeatTimes(array, elementType) {
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

function findMostFrequentlyOccurringElement(array) {
  const elementType = findElementType(array);
  const repeatTimes = recordElementRepeatTimes(array, elementType);
  const maxRepeatTimes = Math.max(...repeatTimes);
  return elementType[repeatTimes.indexOf(maxRepeatTimes)];
}

const array = [3, 'a', 'a', 'a', 2, 3, 'a', 3, 'a', 2, 4, 9, 3];
const highFrequencyElement = findMostFrequentlyOccurringElement(array);

document.write("The array is: [" + array + "]</br>");
document.write("The most frequently occurring element in the array is: " + highFrequencyElement);