package main

import (
	"fmt"
	"math"
)

func main() {
	var n int
	fmt.Scan(&n)
	an := make([]int64, n)
	for i := 0; i < n; i++ {
		fmt.Scan(&an[i])
	}

	mod := int64(math.Pow(10, 9) + 7)
	var ans int64
	for d := 0; d <= 60; d++ {
		var count0 int64
		var count1 int64
		for _, a := range an {
			if (a>>uint(d))&1 == 1 {
				count1++
			} else {
				count0++
			}
		}

		keta := (1 << uint(d)) % mod
		count := (count0 * count1) * keta % mod
		ans += count
		ans %= mod
	}

	fmt.Println(ans)
}
