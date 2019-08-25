package main

import "fmt"

func main() {
	var n int
	var t int64
	fmt.Scan(&n, &t)

	ts := make([]int64, n)
	for i := 0; i < n; i++ {
		fmt.Scan(&ts[i])
	}

	var ans int64
	var tmp int64
	var start int64
	for i := 0; i < n; i++ {
		if i == n-1 {
			ans += tmp
			ans += t
			break
		}
		diff := int64(ts[i+1] - ts[i])
		if diff <= t {
			tmp = ts[i+1] - start
		} else {
			ans += tmp
			ans += t
			tmp = 0
			start = ts[i+1]
		}
	}
	fmt.Println(ans)
}
