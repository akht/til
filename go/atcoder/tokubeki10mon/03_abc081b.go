package main

import "fmt"

func isAllEven(arr []int) bool {
	for _, n := range arr {
		if n%2 != 0 {
			return false
		}
	}
	return true
}

func main() {
	var (
		n   int
		ans int
	)

	fmt.Scan(&n)
	as := make([]int, n)
	for i := 0; i < n; i++ {
		fmt.Scan(&as[i])
	}

	for isAllEven(as) {
		for i := 0; i < n; i++ {
			as[i] /= 2
		}
		ans++
	}
	fmt.Println(ans)
}
