package main

import "fmt"

// https://atcoder.jp/contests/abc098/tasks/abc098_b
func main() {
	var n int
	var s string
	fmt.Scan(&n)
	fmt.Scan(&s)

	for i := 0; i < n; i++ {

	}
}

func count(s string, begin, end int) int {
	memo := make(map[int]int)
	fmt.Println(s[begin])

	for i := begin; i < end; i++ {

	}

	value, ok := memo[begin]

	return 0
}

func max(x, y int) int {
	if x < y {
		return y
	}
	return x
}
