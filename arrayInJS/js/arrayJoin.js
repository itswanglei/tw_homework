function joinArrayWithSymbol(array, symbol) {
  return array.join(symbol);
}

const colors = ["Red", "Green", "White", "Black"];

const colorsJoinWithBlank = joinArrayWithSymbol(colors, " ");
const colorsJoinWithPlus = joinArrayWithSymbol(colors, "+");
const colorsJoinWithComma = joinArrayWithSymbol(colors, ",");

document.write("case 1 output: " + colorsJoinWithBlank + "</br>");
document.write("case 2 output: " + colorsJoinWithPlus + "</br>");
document.write("case 3 output: " + colorsJoinWithComma);
