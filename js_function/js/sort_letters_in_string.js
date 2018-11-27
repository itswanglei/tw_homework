function sortString(string) {
  return string.split("").sort().join("");
}

const originString = "hello";
const orderedString = sortString(originString);

document.write("The origin string is: " + originString + "</br>");
document.write("The ordered string is: " + orderedString);