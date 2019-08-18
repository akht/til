package main

import "fmt"

func main() {
	var n int
	fmt.Scan(&n)

	ans := 0
	memo := map[int]bool{}
	for i := 0; i < n; i++ {
		var mochi int
		fmt.Scan(&mochi)
		if !memo[mochi] {
			memo[mochi] = true
			ans++
		}
	}

	fmt.Println(ans)
}
