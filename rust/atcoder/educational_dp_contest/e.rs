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
        w: usize,
        wv: [(usize, usize); n],
    }

    let inf = 1_000_000_000_000_000;
    let max_v = n * 1000;

    // dp[item][v]: 価値vを超えるようにitem番目までの品物を選んだときの、重さの総和の最小値
    let mut dp = vec![vec![inf; max_v + 10]; n + 1];
    dp[0][0] = 0;

    for item in 0..n {
        for v in 0..max_v + 1 {
            let weight = wv[item].0;
            let value = wv[item].1;

            if v >= value {
                dp[item + 1][v] = std::cmp::min(dp[item + 1][v], dp[item][v - value] + weight);
            }

            dp[item + 1][v] = std::cmp::min(dp[item + 1][v], dp[item][v]);
        }
    }

    let mut ans = 0;
    for i in 0..max_v + 1 {
        if dp[n][i] <= w {
            ans = std::cmp::max(ans, i);
        }
    }

    println!("{}", ans);
}
