package main

import (
	"fmt"
	"strings"
)

func main() {
	var s string
	fmt.Scan(&s)

	words := [4]string{"dream", "dreamer", "erase", "eraser"}
	ans := "YES"
	for s != "" {
		matched := false
		for _, word := range words {
			l := len(s)
			if strings.HasSuffix(s, word) {
				s = s[:l-len(word)]
				matched = true
				break
			}
		}

		if !matched {
			ans = "NO"
			break
		}
	}

	fmt.Println(ans)
}
