package main

import (
	"fmt"
	"strings"
)

// 愚直に数える O(n^2)でいける
// （intersectとかあったら便利なんだけど）
func main() {
	var n int
	var s string
	fmt.Scan(&n)
	fmt.Scan(&s)

	// XとYのどちらにも含まれている文字の種類数を最大化したい

	max := 0
	for i := 1; i < n; i++ {
		lhs := strings.Split(s[0:i], "")
		rhs := strings.Split(s[i:n], "")

		memo := make(map[string]int)
		count := 0
		for _, ss := range lhs {
			if contains(rhs, ss) {
				_, ok := memo[ss]
				if !ok {
					memo[ss] = 1
					count++
				}
			}
		}
		if max < count {
			max = count
		}
	}

	fmt.Println(max)
}

func contains(arr []string, str string) bool {
	for _, e := range arr {
		if e == str {
			return true
		}
	}

	return false
}
