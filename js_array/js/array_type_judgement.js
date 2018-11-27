function isArray(variables) {
  return variables instanceof Array;
}

const a = '[a, b, c, d]';
const b = [1, 2, 3, 4];

const aType = isArray(a);
const bType = isArray(b)

document.write("The type of a: " + aType + "</br>");
document.write("The type of b: " + bType);
