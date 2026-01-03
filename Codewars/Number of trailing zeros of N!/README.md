
# Trailing Zeros in a Factorial

## Problem Statement

Write a program that calculates the number of **trailing zeros** in the factorial of a given number `N`.



N! = 1 × 2 × 3 × ... × N



⚠️ **Important:**  
You are **not meant to calculate the factorial directly**.  
For example, `1000!` has **2568 digits**, making direct computation inefficient.

---

## Why Trailing Zeros Occur

A trailing zero is produced by a factor of **10**.



10 = 2 × 5



In a factorial:
- Factors of **2** are abundant
- Factors of **5** are limited

👉 Therefore, the number of trailing zeros depends entirely on the **number of times 5 appears as a factor** in numbers from `1` to `N`.

---

## Key Insight

Some numbers contribute **more than one factor of 5**:

- `5` → one factor of 5
- `25 = 5²` → two factors of 5
- `125 = 5³` → three factors of 5
- and so on...

So we count all of them.

---

## Formula



TrailingZeros(N!) =
⌊N / 5⌋ + ⌊N / 25⌋ + ⌊N / 125⌋ + ...



Stop when the divisor becomes greater than `N`.

---

## Examples

### Example 1


N = 6
6! = 720
Trailing zeros = 1



### Example 2


N = 12
12! = 479001600
Trailing zeros = 2



### Example 3


N = 1000
Trailing zeros = 249

`

---

## Algorithm

1. Initialize `zeros = 0`
2. While `N > 0`
   - Divide `N` by `5`
   - Add the result to `zeros`
3. Return `zeros`

---

## Pseudocode

text
zeros = 0
while N > 0:
    N = N // 5
    zeros += N
return zeros
`

---

## Implementations

### Java

java
public class Main {
    static long trailingZeros(long n) {
        long zeros = 0;
        while (n > 0) {
            n /= 5;
            zeros += n;
        }
        return zeros;
    }

    public static void main(String[] args) {
        System.out.println(trailingZeros(6));    // 1
        System.out.println(trailingZeros(12));   // 2
        System.out.println(trailingZeros(1000)); // 249
    }
}


---

### JavaScript (Node.js)

js
function trailingZeros(n) {
  let zeros = 0;
  while (n > 0) {
    n = Math.floor(n / 5);
    zeros += n;
  }
  return zeros;
}

console.log(trailingZeros(6));    // 1
console.log(trailingZeros(12));   // 2
console.log(trailingZeros(1000)); // 249


---

### Go

go
package main

import "fmt"

func trailingZeros(n int64) int64 {
	var zeros int64 = 0
	for n > 0 {
		n /= 5
		zeros += n
	}
	return zeros
}

func main() {
	fmt.Println(trailingZeros(6))    // 1
	fmt.Println(trailingZeros(12))   // 2
	fmt.Println(trailingZeros(1000)) // 249
}


---

## Time and Space Complexity

| Metric | Complexity  |
| ------ | ----------- |
| Time   | `O(log₅ N)` |
| Space  | `O(1)`      |

---

## Final Notes

* Never compute the factorial itself.
* Counting factors of **5** is sufficient.
* This approach is efficient and works even for very large values of `N`.

