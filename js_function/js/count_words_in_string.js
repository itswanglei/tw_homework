function countWords(string) {
  return string.split(" ").length;
}

const string = "Good morning, I love JavaScript.";
const wordsNumber = countWords(string);

document.write("The string is: " + string + "</br>");
document.write("The words number in this string is: " + wordsNumber);