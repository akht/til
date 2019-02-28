fn main() {
    let s = {
        let mut s = String::new(); // バッファを確保
        std::io::stdin().read_line(&mut s).unwrap(); // 一行読む。失敗を無視
        s.trim_right().to_owned() // 改行コードが末尾にくっついてくるので削る
    };
    let s = s.chars().collect::<Vec<char>>();
    let len = s.len();
    let mut ans: u64 = 0;


    for bit in (0 .. 1 << len-1) {

        let mut tmp = s[0] as u64 - '0' as u64;

        for i in (0 .. len-1) {

            if 1 & (bit >> i) == 1 {

                ans += tmp;
                tmp = 0;

            }

            tmp = tmp * 10 + (s[i + 1] as u64 - '0' as u64);
        }

        ans += tmp;
    }

    println!("{}", ans);
}