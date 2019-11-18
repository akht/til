package main

import "fmt"

func main() {
	var n int
	var s string
	fmt.Scan(&n)
	fmt.Scan(&s)

	// memo[i]は、i人目をリーダーとして選んだ時の、向く方向を変える必要がある人数
	memo := make([]int, n)

	// 初期値として2人目以降のEの数を数える
	for i := 1; i < n; i++ {
		if s[i] == 'E' {
			memo[0]++
		}
	}

	for i := 1; i < n; i++ {
		if s[i] == 'E' {
			memo[i] = memo[i-1] - 1
		} else {
			memo[i] = memo[i-1]
		}

		if s[i-1] == 'W' {
			memo[i]++
		}
	}

	fmt.Println(min(memo))
}

func min(arr []int) int {
	min := 100000000
	for _, v := range arr {
		if v < min {
			min = v
		}
	}
	return min
}
