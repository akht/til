package main

import "fmt"

// https://atcoder.jp/contests/abc098/tasks/abc098_a
func main() {
	var a, b int
	fmt.Scan(&a, &b)

	sum := a + b
	sub := a - b
	mul := a * b

	fmt.Println(max(sum, sub, mul))
}

func max(args ...int) int {
	ret := -100000
	for _, v := range args {
		if ret < v {
			ret = v
		}
	}
	return ret
}
