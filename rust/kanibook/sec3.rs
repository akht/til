fn main() {
    let mut sieve = [true; 10000];
    for i in 2..100 {
        if sieve[i] {
            let mut j = i * i;
            while j < 10000 {
                sieve[j] = false;
                j += i;
            }
        }
    }

    assert!(sieve[211]);
    assert!(!sieve[9876]);

    // 配列
    let mut chaos = [3, 5, 4, 1, 2];
    chaos.sort();
    assert_eq!(chaos, [1,2,3,4,5]);

    // ベクタ
    let mut v = vec![2, 3, 5, 7];
    assert_eq!(v.iter().fold(1, |a, b| a * b), 210);
    v.push(11);
    v.push(13);
    assert_eq!(v.iter().fold(1, |a, b| a * b), 30030);    

    // 空のベクタを作ってから要素を追加する
    let mut v2 = Vec::new();
    v2.push("step");
    v2.push("on");
    v2.push("no");
    v2.push("pets");
    assert_eq!(v2, vec!["step", "on", "no", "pets"]);

    // イテレータをcollect()してベクタを生成する
    let v3: Vec<i32> = (0..5).collect();
    assert_eq!(v3, [0, 1, 2, 3, 4]);


    // 回文
    let mut v4 = vec!["a man", "a plan", "a canal", "panama"];
    v4.reverse();
    assert_eq!(v4, vec!["panama", "a canal", "a plan", "a man"]);


    let mut v5 = Vec::with_capacity(2);
    assert_eq!(v5.len(), 0);
    assert_eq!(v5.capacity(), 2);

    v5.push(1);
    v5.push(2);
    assert_eq!(v5.len(), 2);
    assert_eq!(v5.capacity(), 2);

    v5.push(3);
    assert_eq!(v5.len(), 3);
    assert_eq!(v5.capacity(), 4);


    let mut v6 = vec!["carmen", "miranda"];
    assert_eq!(v6.pop(), Some("miranda"));
    assert_eq!(v6.pop(), Some("carmen"));
    assert_eq!(v6.pop(), None);
}

// fn new_pixel(rows: usize, cols: usize) -> Vec<u8> {
//     vec![0; rows * cols]
// }