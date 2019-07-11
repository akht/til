package main

import (
	"fmt"
	"time"
)

func main1() {
	var msg string
	msg = "hello world"
	fmt.Println(msg)

	var msg2 = "hello world"
	fmt.Println(msg2)

	msg3 := "hello world"
	fmt.Println(msg3)

	var a, b int
	a, b = 10, 15
	fmt.Println(a, b)

	c, d := 11, 16
	fmt.Println(c, d)

	var (
		e int
		f string
	)
	e = 20
	f = "hoge"
	fmt.Println(e, f)

	var (
		g = 30
		h = "fuga"
	)
	fmt.Println(g, h)
}

func main2() {
	var a int
	var b float64
	var c string
	var d bool
	fmt.Printf("a: %d, b:%f, c:%s, d:%t\n", a, b, c, d)
}

func main3() {
	const (
		sun = iota
		mon
		tue
	)

	fmt.Println(sun, mon, tue)
}

func main4() {
	a := 5

	var pa *int
	pa = &a

	fmt.Println(pa)
	fmt.Println(*pa)
}

func main5() {
	fmt.Println(getMessage("akht"))
	fmt.Println(getHelloMessage("akht"))
}

func getMessage(name string) string {
	msg := "hi! my name is " + name
	return msg
}

// 名前付きreturn関数
func getHelloMessage(name string) (msg string) {
	msg = "hello " + name
	return
}

func main6() {
	fmt.Println(swap(4, 2))

	f := func(a int, b int) (int, int) {
		return b, a
	}

	fmt.Println(f(3, 8))

	func(msg string) {
		fmt.Println(msg)
	}("akht")
}

func swap(a int, b int) (int, int) {
	return b, a
}

func main7() {
	var a [5]int

	a[2] = 3
	a[4] = 10

	fmt.Println(a)

	b := [3]int{1, 3, 6}
	fmt.Println(b)

	c := [...]int{2, 4, 7, 5, 3}
	fmt.Println(c)
}

func main8() {
	a := [5]int{2, 10, 8, 15, 4}

	b := a[2:4]
	c := a[2:]
	d := a[:4]
	e := a[:]
	fmt.Println(b)
	fmt.Println(c)
	fmt.Println(d)
	fmt.Println(e)

	fmt.Println(len(c))

	fmt.Println(cap(c))
}

func main9() {
	s1 := make([]int, 3)

	s2 := []int{1, 3, 5}
	fmt.Println(s1)
	fmt.Println(s2)

	s3 := append(s2, 8, 2, 10)
	fmt.Println(s3)

	t := make([]int, len(s3))
	s4 := copy(t, s3)
	fmt.Println(s4)
}

func main10() {
	m := make(map[string]int)
	m["akht"] = 200
	m["hoge"] = 200

	m2 := map[string]int{"akht": 100, "fuga": 200}

	v, ok := m2["akht"]

	fmt.Println(v)
	fmt.Println(ok)

	delete(m2, "akht")
	fmt.Println(m2)
}

func main11() {
	score := 42

	if score > 40 {
		fmt.Println("great")
	} else if score > 30 {
		fmt.Println("good")
	} else {
		fmt.Println("soso")
	}

	if score2 := 42; score2 > 40 {
		fmt.Println("great")
	} else if score > 30 {
		fmt.Println("good")
	} else {
		fmt.Println("soso")
	}
}

func main12() {
	signal := "blue"

	switch signal {
	case "red":
		fmt.Println("Stop")
	case "yellow":
		fmt.Println("caution")
	case "green", "blue":
		fmt.Println("go")
	default:
		fmt.Println("wrong")
	}

	score := 42
	switch {
	case score > 40:
		fmt.Println("great")
	default:
		fmt.Println("bad")
	}
}

func main13() {
	for i := 0; i < 10; i++ {
		if i == 3 {
			continue
		} else if i == 8 {
			break
		}
		fmt.Println(i)
	}

	n := 0
	for n < 10 {
		fmt.Println(n)
		n++
	}
}

func main14() {
	s := []int{2, 3, 8}

	for i, v := range s {
		fmt.Println(i, v)
	}

	for _, v := range s {
		fmt.Println(v)
	}

	m := map[string]int{"hoge": 100, "fuga": 200}

	for k, v := range m {
		fmt.Println(k, v)
	}
}

type user struct {
	name  string
	score int
}

func main15() {
	u1 := new(user)
	u1.name = "akht"
	u1.score = 42
	fmt.Println(*u1)

	u2 := user{name: "hoge", score: 100}
	fmt.Println(u2)
}

func (u user) show() {
	fmt.Printf("name: %s, socore: %d\n", u.name, u.score)
}

func (u *user) hit() {
	u.score++
}

func main16() {
	u := user{name: "akht", score: 42}
	u.hit()
	u.show()
}

type greeter interface {
	greet()
}

type japanese struct{}
type american struct{}

func (ja japanese) greet() {
	fmt.Println("こん！")
}

func (us american) greet() {
	fmt.Println("hi")
}

func main17() {
	greeters := []greeter{japanese{}, american{}}

	for _, greeter := range greeters {
		greeter.greet()
	}
}

func aisatsu(t interface{}) {
	_, ok := t.(japanese)
	if ok {
		fmt.Println("i am japanese")
	} else {
		fmt.Println("i am not japanese")
	}

	switch t.(type) {
	case japanese:
		fmt.Println("日本人だよ")
	default:
		fmt.Println("日本人じゃないよ")
	}
}

func main18() {
	greeters := []greeter{japanese{}, american{}}

	for _, greeter := range greeters {
		greeter.greet()
		aisatsu(greeter)
	}
}

func task1() {
	time.Sleep(time.Second * 2)
	fmt.Println("task1 finished!")
}

func task2() {
	fmt.Println("task2 finished!")
}

func main19() {
	go task1()
	go task2()

	time.Sleep(time.Second * 3)
}

func task3(result chan string) {
	time.Sleep(time.Second * 2)
	fmt.Println("task3 finished!")

	result <- "task3 result"
}

func task4() {
	fmt.Println("task4 finished!")
}

func main() {
	result := make(chan string)

	go task3(result)
	go task4()

	fmt.Println("result: " + <-result)

	time.Sleep(time.Second * 3)
}
