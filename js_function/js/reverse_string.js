function reverseString(string) {
  let stringContentArray = new Array(string.length);
  for (let i = 0; i < string.length; i++) {
    stringContentArray[string.length - i -1] = string[i];
  }
  return stringContentArray.join("");
}

const inputString = "hello";
const outputString = reverseString(inputString);
document.write("The origin string is: " + inputString + "</br>");
document.write("The reverse string is: " + outputString + "</br>");