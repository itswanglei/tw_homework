// Method 1
function reverseString(string) {
  let stringContentArray = new Array(string.length);
  for (let i = 0; i < string.length; i++) {
    stringContentArray[string.length - i -1] = string[i];
  }
  return stringContentArray.join("");
}

// Method 2: reverse string by convert string to array
function reverseStringByArrayReverse(string) {
  return string.split("").reverse().join("");
}

const inputString = "hello";
const outputString = reverseString(inputString);
document.write("The origin string is: " + inputString + "</br>");
document.write("The reverse string is: " + outputString + "</br>");