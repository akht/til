package main

import "fmt"

func main() {
	var n int
	fmt.Scan(&n)

	hs := make([]int64, n)
	for i := 0; i < n; i++ {
		fmt.Scan(&hs[i])
	}

	ans := 0
	tmp := 0
	for i := 0; i < n-1; i++ {
		if hs[i] >= hs[i+1] {
			tmp++
		} else {
			ans = max(ans, tmp)
			tmp = 0
		}
	}
	fmt.Println(max(ans, tmp))
}

func max(x, y int) int {
	if x < y {
		return y
	}
	return x
}
