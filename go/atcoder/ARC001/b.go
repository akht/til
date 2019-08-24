package main

import "fmt"

func main() {
	var a, b int
	fmt.Scan(&a, &b)

	op := []int{0, 1, 2, 3, 2, 1, 2, 3, 3, 2}

	diff := abs(a - b)
	q := diff / 10
	r := diff % 10

	ans := q + op[r]

	fmt.Println(ans)
}

func abs(x int) int {
	if x < 0 {
		return -x
	}
	return x
}
