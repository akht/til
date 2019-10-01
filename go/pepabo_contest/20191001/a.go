package main

import (
	"fmt"
	"math"
)

func main() {
	var x int
	fmt.Scan(&x)

	sqrt := int(math.Sqrt(float64(x)))

	ans := 1
	for i := 2; i <= sqrt; i++ {
		for j := 1; j < 10; j++ {
			tmp := pow(i, j)
			if tmp > x {
				break
			}
			ans = max(ans, tmp)
		}
	}

	fmt.Println(ans)
}

func max(x, y int) int {
	return int(math.Max(float64(x), float64(y)))
}

func pow(x, y int) int {
	return int(math.Pow(float64(x), float64(y)))
}
