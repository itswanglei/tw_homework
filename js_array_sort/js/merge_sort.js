function mergeSort(array) {
  if (array.length < 2) {
    return array;
  }
  let arrayMiddle = Math.floor(array.length / 2);
  let leftPart = array.slice(0, arrayMiddle);
  let rightPart = array.slice(arrayMiddle);
  return merge(mergeSort(leftPart), mergeSort(rightPart));
}

function merge(leftPart, rightPart) {
  let sortedArray = [];
  while (leftPart.length && rightPart.length) {
    if (leftPart[0] <= rightPart[0]) {
      sortedArray.push(leftPart.shift());
    } else {
      sortedArray.push(rightPart.shift());
    }
  }
  while (leftPart.length) {
    sortedArray.push(leftPart.shift());
  }
  while (rightPart.length) {
    sortedArray.push(rightPart.shift());
  }
  return sortedArray;
}

const array = [4, 3, 1, 5, 6];
const sortedArray = mergeSort(array);
console.log(sortedArray);