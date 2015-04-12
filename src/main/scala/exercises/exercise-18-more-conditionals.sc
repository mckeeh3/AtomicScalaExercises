
import com.atomicscala.AtomicTest._

// 1. Under what conditions does a Vector of length greater than one
//    equal its reverse?

val v1 = Vector(1, 2, 3, 2, 1)
v1 is v1.reverse

// 2. Palindromes are words or phrases that read the same forward and
//    backward. Some examples include “mom” and “dad.” Write a
//    method to test words or phrases for palindromes. Hint: String’s
//    reverse method may prove useful here. Use AtomicTest to check
//    your solution (remember to import it!). Satisfy the following tests:
//    isPalindrome("mom") is true
//    isPalindrome("dad") is true
//    isPalindrome("street") is false

def isPalindrome(s: String): Boolean = {
  s == s.reverse
}

isPalindrome("mom") is true
isPalindrome("dad") is true
isPalindrome("street") is false

// 3. Building on the previous exercise, ignore case when testing for
//    palindromes. Satisfy the following tests:
//    isPalIgnoreCase("Bob") is true
//    isPalIgnoreCase("DAD") is true
//    isPalIgnoreCase("Blob") is false

def isPalIgnoreCase(s: String): Boolean = {
  isPalindrome(s.toLowerCase)
}

isPalIgnoreCase("Bob") is true
isPalIgnoreCase("DAD") is true
isPalIgnoreCase("Blob") is false

// 4. Building on the previous exercise, strip out special characters
//    before palindrome testing. Here is sample code and tests: (Hint: In
//    integer values, ‘A’ is 65, ‘B’ is 66, … ‘a’ is 97 … ‘z’ is 122. ‘0’ is 48 …
//    ‘9’ is 57)
//    var createdStr = ""
//    for (c <- str) {
//      // Convert to Int for comparison:
//      val theValue = c.toInt
//      if (/* Check for letters */) {
//        createdStr += c
//      }
//      else if (/* check for numbers */) {
//        createdStr += c
//      }
//    }
//    isPalIgnoreSpecial("Madam I'm adam") is
//    true
//    isPalIgnoreSpecial("trees") is false

def isPalIgnoreSpecial(str: String): Boolean = {
  var createdStr = ""
  for (c <- str) {
    // Convert to Int for comparison:
    val theValue = c.toInt
    if (theValue >= 'a'.toInt && theValue <= 'z'.toInt ||
      theValue >= 'A'.toInt && theValue <= 'Z'.toInt) {
      createdStr += c
    }
    else if (theValue >= '0'.toInt && theValue <= '9'.toInt) {
      createdStr += c
    }
  }
  isPalIgnoreCase(createdStr)
}

isPalIgnoreSpecial("Madam I'm adam") is true
isPalIgnoreSpecial("trees") is false
isPalIgnoreSpecial("1234-5-4321") is true
isPalIgnoreSpecial("A man, a plan, a canal--Panama!") is true
isPalIgnoreSpecial("  Able was I ere I saw Elba.") is true
isPalIgnoreSpecial("  Too bad--I hid a boot.") is true
isPalIgnoreSpecial("  Do geese see God?") is true
isPalIgnoreSpecial("Murder for a jar of red rum.") is true
isPalIgnoreSpecial("  Drab as a fool, aloof as a bard.") is true
isPalIgnoreSpecial("Go deliver a dare, vile dog!") is true
