function sortNumber(number1, number2) {
  return number1 - number2;
}

const originArray = [5,1,8,10,4];
const newArray = originArray.sort(sortNumber);

document.write("The newArray is: [" + newArray + "]");