package main

import (
	"fmt"
)

func main() {
	var n int
	fmt.Scan(&n)

	input := make([][3]int64, n)
	for i := 0; i < n; i++ {
		var x, y, h int64
		fmt.Scan(&x, &y, &h)
		input[i] = [3]int64{x, y, h}
	}

	for x := 0; x <= 100; x++ {
		for y := 0; y <= 100; y++ {
			point := [3]int64{0, 0, 0}
			for i := 0; i < n; i++ {
				xyh := input[i]
				if xyh[2] != 0 {
					point = xyh
					break
				}
			}

			h := abs(int64(x)-point[0]) + abs(int64(y)-point[1]) + point[2]
			allOk := true
			for i := 0; i < n; i++ {
				xyh := input[i]
				height := max(h-abs(int64(x)-xyh[0])-abs(int64(y)-xyh[1]), 0)
				if xyh[2] != height {
					allOk = false
					break
				}
			}

			if allOk {
				fmt.Printf("%d %d %d\n", x, y, h)
				break
			}
		}
	}
}

func abs(x int64) int64 {
	if x < 0 {
		return -x
	}
	return x
}

func max(x, y int64) int64 {
	if x > y {
		return x
	}
	return y
}
