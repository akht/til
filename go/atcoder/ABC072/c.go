package main

import (
	"fmt"
	"sort"
)

func main() {
	var n int
	fmt.Scan(&n)
	an := make([]int, n)
	for i := 0; i < n; i++ {
		fmt.Scan(&an[i])
	}
	sort.Ints(an)

	len := 0
	left := 0
	right := 0
	for ; left < n; left++ {
		for ; right < n; right++ {
			lhs := an[left]
			rhs := an[right]
			diff := rhs - lhs
			if diff <= 2 {
				count := right - left + 1
				if len < count {
					len = count
				}
			} else {
				break
			}
		}
	}
	fmt.Println(len)
}
