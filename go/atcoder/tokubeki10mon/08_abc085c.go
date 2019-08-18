package main

import "fmt"

func main() {
	var n, y int
	fmt.Scan(&n, &y)

	a, b, c := -1, -1, -1

	for i := 0; i <= n; i++ {
		for j := 0; j <= n; j++ {
			k := n - (i + j)
			if k >= 0 && 10000*i+5000*j+1000*k == y {
				a, b, c = i, j, k
			}
		}
	}
	fmt.Printf("%d %d %d\n", a, b, c)
}
