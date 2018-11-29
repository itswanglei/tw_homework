// Creat an empty object and change its attributes
let user = {};
user.name = "John";
user.surname = "Mike";
user.name = "Peter";
delete user.name;

// Count fruit
let fruit = {
  apple: 20,
  pear: 20,
  peach: 10,
};

let fruitNumber = 0;
for(fruitTypes in fruit) {
    fruitNumber += fruit[fruitTypes];
}

console.log(fruitNumber);