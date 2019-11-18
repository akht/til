package main

import "fmt"

// 単純にadd, sub, mulを計算してその最大値を出力する
// 可変長引数を取れるmax関数があると便利
func maini() {
	var a, b int
	fmt.Scan(&a, &b)

	add := a + b
	sub := a - b
	mul := a * b

	fmt.Println(max(add, sub, mul))
}

func max(args ...int) int {
	max := -100000000
	for _, v := range args {
		if max < v {
			max = v
		}
	}
	return max
}
