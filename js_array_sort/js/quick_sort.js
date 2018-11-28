function quickSort(array) {
  if (array.length < 2) {
    return array;
  }
  let pivotIndex = Math.floor(array.length / 2);
  let pivot = array.splice(pivotIndex, 1)[0];
  let leftPart = [];
  let rightPart = [];
  for (let i = 0; i < array.length; i++) {
    if (array[i] <= pivot) {
      leftPart.push(array[i]);
    } else {
      rightPart.push(array[i]);
    }
  }
  return quickSort(leftPart).concat([pivot], quickSort(rightPart));
}

let array = [2, 5, 3, 4, 1];
let sortedArray = quickSort(array);
console.log(sortedArray);