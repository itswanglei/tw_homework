function multiplyElementByTwo(array) {
  let newArray = [array.length];
  for (let i = 0; i < array.length; i++) {
    newArray[i] = array[i] * 2;
  }
  return newArray;
}

const originArry = [1,2,3,4,5];
const newArray = multiplyElementByTwo(originArry);

document.write("The origin array is: [" + originArry + "]</br>");
document.write("The new array is: [" + newArray + "]");