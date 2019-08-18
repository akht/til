package main

import (
	"fmt"
	"math"
	"sort"
)

func main() {
	var n int
	fmt.Scan(&n)

	arr := make([]int, n)
	for i := 0; i < n; i++ {
		fmt.Scan(&arr[i])
	}

	sort.Ints(arr)

	ans := 0
	for i := 0; i < n; i++ {
		if i%2 == 0 {
			ans += arr[i]
		} else {
			ans -= arr[i]
		}
	}

	fmt.Println(math.Abs(float64(ans)))
}
