function insertionSort(array) {
  let i, j, temp;
  for (i = 0; i < array.length; i++) {
    temp = array[i];
    for (j = i - 1; j > -1 && array[j] > temp; j--) {
      array[j + 1] = array[j];
    }
    array[j + 1] = temp;
  }
  return array;
}
let array = [2, 3, 1, 5, 4];
let sortedArray = insertionSort(array);
console.log(sortedArray);