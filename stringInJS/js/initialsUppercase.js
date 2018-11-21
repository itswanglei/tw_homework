// Change the initials of all words in the sentence to uppercase
// Method 1: Use for-loop
function convertInitialsToUppercaseForEachWord(inputSentence) {
  let words = inputSentence.split(" ");

  for (let i = 0; i < words.length; i++) {
    let initials = words[i].charAt(0);
    words[i] = words[i].replace(initials, initials.toUpperCase());
  }
  
  let outputSentence = words.join(" ");
  return outputSentence;
}

// Method 2: Use regular expression
function convertInitialsToUppercaseForEachWord_method2(inputSentence) {
  let outputSentence = inputSentence.toLowerCase().replace(/( |^)[a-z]/g, (L) => L.toUpperCase());
  return outputSentence;
}

const sentence = 'good afternoon, mr mike.';
const newSentence = convertInitialsToUppercaseForEachWord(sentence);
const newSentence2 = convertInitialsToUppercaseForEachWord_method2(sentence);
document.write(newSentence + "</br>" + newSentence2);
