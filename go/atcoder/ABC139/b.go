package main

import "fmt"

func main() {
	var a, b int
	fmt.Scan(&a, &b)

	ans := 0
	socket := 1
	for socket < b {
		socket--
		socket += a
		ans++
	}
	fmt.Println(ans)
}
