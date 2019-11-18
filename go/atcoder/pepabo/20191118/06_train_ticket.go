package main

import "fmt"

// abcdに演算子が入る箇所は3箇所ある
// その3箇所それぞれについて'+'か'-'を入れてみて実際に計算して7になるかどうか調べる
// それぞれについて「+」「-」の2つの状態を表すのには01つまりバイナリで表す
// 一般化すると、ある要素について「あり」「なし」とかの2つの状態を表したいときがある
// N個のものを「取る」「取らない」とかの、2^Nを表すもの
// この全探索を簡単に行えるのがいわゆるビット全探索
// Go(1.6)だとビットシフトするときにuintじゃないとCEになる。。
func main() {
	var abcd string
	fmt.Scan(&abcd)

	len := 3
	count := 0
	for bit := 0; bit < (1 << uint(len)); bit++ {
		count++
		exp := abcd[0:1]
		eval := int(abcd[0] - '0')
		for i := 0; i < len; i++ {
			literal := abcd[i+1 : i+2]
			value := int(abcd[i+1] - '0')
			if (1 & (bit >> uint(i))) == 1 {
				exp += "+" + literal
				eval += value
			} else {
				exp += "-" + abcd[i+1:i+2]
				eval -= value
			}
		}

		if eval == 7 {
			fmt.Printf("%s=7\n", exp)
			return
		}
	}
}
