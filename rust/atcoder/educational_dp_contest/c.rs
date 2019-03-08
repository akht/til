macro_rules! input {
    (source = $s:expr, $($r:tt)*) => {
        let mut iter = $s.split_whitespace();
        let mut next = || { iter.next().unwrap() };
        input_inner!{next, $($r)*}
    };
    ($($r:tt)*) => {
        let stdin = std::io::stdin();
        let mut bytes = std::io::Read::bytes(std::io::BufReader::new(stdin.lock()));
        let mut next = move || -> String{
            bytes
                .by_ref()
                .map(|r|r.unwrap() as char)
                .skip_while(|c|c.is_whitespace())
                .take_while(|c|!c.is_whitespace())
                .collect()
        };
        input_inner!{next, $($r)*}
    };
}

macro_rules! input_inner {
    ($next:expr) => {};
    ($next:expr, ) => {};

    ($next:expr, $var:ident : $t:tt $($r:tt)*) => {
        let $var = read_value!($next, $t);
        input_inner!{$next $($r)*}
    };
}

macro_rules! read_value {
    ($next:expr, ( $($t:tt),* )) => {
        ( $(read_value!($next, $t)),* )
    };

    ($next:expr, [ $t:tt ; $len:expr ]) => {
        (0..$len).map(|_| read_value!($next, $t)).collect::<Vec<_>>()
    };

    ($next:expr, chars) => {
        read_value!($next, String).chars().collect::<Vec<char>>()
    };

    ($next:expr, usize1) => {
        read_value!($next, usize) - 1
    };

    ($next:expr, $t:ty) => {
        $next().parse::<$t>().expect("Parse error")
    };
}

fn main() {
    input! {
        n: usize,
        abc: [[i64; 3]; n],
    }

    // dp[i]だけだとi日目になにをしたかの情報が足りないので添え字を追加する
    // dp[i][j]: i日目にj(0:海 1:山 2:宿題)をやったときの、それまでの幸福度の総和の最大値
    let mut dp = vec![vec![0; 3]; n];
    dp[0][0] = abc[0][0];
    dp[0][1] = abc[0][1];
    dp[0][2] = abc[0][2];

    for i in 1..n {
        for j in 0..3 {
            for k in 0..3 {
                // ２日連続で同じことはできない
                if j == k {
                    continue;
                }
                dp[i][j] = std::cmp::max(dp[i][j], dp[i - 1][k] + abc[i][j]);
            }
        }
    }

    println!("{}", dp[n - 1].iter().max().unwrap());
}