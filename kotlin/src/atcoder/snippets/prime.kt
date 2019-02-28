package atcoder.snippets


// 素数に関係するやつ


// 素数判定
fun isPrime(x: Int): Boolean {
    if (x <= 1) {
        return false
    }
    for (i in 2..Math.sqrt(x.toDouble()).toInt()) {
        if (x % i == 0) {
            return false
        }
    }
    return true
}

// エラトステネスの篩(n以下の素数を列挙する)
fun sieve(n: Int): Set<Int> {
    val sieve = (2..n).toMutableSet()
    var i = 2
    while (i * i <= n) {
        if (i in sieve) {
            var j = i + i
            while (j <= n) {
                if (j in sieve) {
                    sieve.remove(j)
                    j += i
                }
            }
        }
        i += i
    }
    return sieve.toSet()
}