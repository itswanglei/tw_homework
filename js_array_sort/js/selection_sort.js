function selectionSort(array) {
  for (let i = 0; i < array.length; i++) {
    let minIndex = i;
    let temp = array[i];
    for (let j = i + 1; j < array.length; j++) {
      if (array[j] < array[i]) {
        minIndex = j;
      }
    }
    array[i] = array[minIndex];
    array[minIndex] = temp;
  }
  return array;
}
let array = [2, 1, 4, 6, 3];
console.log(selectionSort(array));