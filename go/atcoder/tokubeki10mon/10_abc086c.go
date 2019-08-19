package main

import (
	"fmt"
)

func isReachable(cur, next [3]int) bool {
	curT, curX, curY := cur[0], cur[1], cur[2]
	nextT, nextX, nextY := next[0], next[1], next[2]
	dist := abs(curX-nextX) + abs(curY-nextY)

	if dist > nextT-curT {
		return false
	}

	parity := (nextT - curT) - dist
	return parity%2 == 0
}

func abs(x int) int {
	if x < 0 {
		return -x
	}
	return x
}

func main() {
	var n int
	fmt.Scan(&n)

	ans := "Yes"

	curT, curX, curY := 0, 0, 0
	for i := 0; i < n; i++ {
		var nextT, nextX, nextY int
		fmt.Scan(&nextT, &nextX, &nextY)

		cur := [3]int{curT, curX, curY}
		next := [3]int{nextT, nextX, nextY}
		if !isReachable(cur, next) {
			ans = "No"
		}
		curT, curX, curY = nextT, nextX, nextY
	}

	fmt.Println(ans)
}
