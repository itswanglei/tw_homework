// Method 1
function palindrome(string) {
  for (let i = 0; i < string.length; i++) {
    if (string[i] != string[string.length - i - 1]) {
      return false;
    }
  }
  return true;
}

// Method 2
function isPalindrome(string) {
  return (string.split("").reverse().join("") === string);
}

document.write("Is 'hello' palindrome? " + palindrome("hello") + "</br>");
document.write("Is 'abcba' palindrome? " + palindrome("abcba"));