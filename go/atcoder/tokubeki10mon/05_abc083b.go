package main

import "fmt"

func calc(x int) int {
	sum := 0
	for x > 0 {
		sum += x % 10
		x /= 10
	}
	return sum
}

func main() {
	var n, a, b, ans int
	fmt.Scan(&n, &a, &b)

	for i := 1; i <= n; i++ {
		sum := calc(i)
		if sum >= a && sum <= b {
			ans += i
		}
	}

	fmt.Println(ans)
}
