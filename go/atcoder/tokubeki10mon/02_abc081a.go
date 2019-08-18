package main

import "fmt"

func main() {
	var (
		a   string
		ans = 0
	)
	fmt.Scan(&a)
	for i := 0; i < len(a); i++ {
		if a[i] == '1' {
			ans++
		}
	}
	fmt.Println(ans)
}
