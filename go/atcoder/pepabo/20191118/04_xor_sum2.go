package main

import "fmt"

func main() {
	var n int
	fmt.Scan(&n)
	an := make([]int64, n)
	for i := 0; i < n; i++ {
		fmt.Scan(&an[i])
	}

	// 和とxorが同じになる部分列の数
	// じゃあどういう時に和とxorが一致しない？
	// => 繰り上がりが発生するとき
	// 例えば{4, 5}のとき、
	// sum：100 + 101 = 1001 = 9(10進数)
	// xor：100 xor 101 = 001 = 1(10進数)
	// つまり、和で繰り上がりが発生するときはダメ
	// 繰り上がりが発生するのは、各桁のビットが立ってる箇所が2つ以上あるとき
	// 和だと繰り上がるはずが、xorだと繰り上がらずに消されてしまうため
	// この範囲を数える
	// この区間にはどういう特徴があるか？
	// 区間が伸びれば伸びるほどダメになる可能性が高いし、
	// ある区間がダメなら、左端が同じでそれより長い区間は当然だめ(ビットの数が増えるから)
	// この区間は尺取り法で求める

	var ans, right int
	var sum int64
	for left := 0; left < n; left++ {
		for right < n && (sum+an[right]) == (sum^an[right]) {
			sum += an[right]
			right++
		}

		ans += right - left

		if right == left {
			right++
		} else {
			sum -= an[left]
		}
	}

	fmt.Println(ans)
}
