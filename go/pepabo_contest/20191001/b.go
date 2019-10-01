package main

import (
	"fmt"
	"strconv"
	"strings"
)

func main() {
	var abcd string
	fmt.Scan(&abcd)

	arr := strings.Split(abcd, "")
	len := 4

	for bit := 0; bit < (1 << uint(len-1)); bit++ {
		expr := arr[0]
		eval, _ := strconv.Atoi(arr[0])
		for i := 0; i < len-1; i++ {
			if 1&(bit>>uint(i)) == 1 {
				expr += "+" + arr[i+1]
				tmp, _ := strconv.Atoi(arr[i+1])
				eval += tmp
			} else {
				expr += "-" + arr[i+1]
				tmp, _ := strconv.Atoi(arr[i+1])
				eval -= tmp
			}
		}

		if eval == 7 {
			fmt.Printf("%v=7\n", expr)
			return
		}
	}
}
