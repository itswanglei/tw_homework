'use strict';

var s = 'Hello';

function greet(name) {
  console.log(s + ', ' + name + '!');
}

function sayGoodbye() {
  console.log('Goodbye!');
}

module.exports = {
  greet: greet,
  sayGoodbye: sayGoodbye,
};