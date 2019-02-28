use std::cmp;

fn main() {

    // https://qiita.com/bplain2/items/8e5bb79e4642368fe275


    dp_zero();

    dp_one1();

    dp_one2();
}

// 0次元DP
fn dp_zero() {
    // 以下の数字の中から最大の値を探す

    let input = vec![4,9,2,4,7,8,1,5,6,3];

    let mut max = 0;
    for i in 0..input.len() {
        max = cmp::max(max, input[i]);
    }

    println!("{}", max);
}

// 1次元DP(その1)
fn dp_one1() {
    let n = 15;

    let mut dp = [0; 15];
    dp[0] = 2;
    dp[1] = 3;

    for i in 2..n {
        dp[i] = dp[i - 1] + dp[i - 2];
    }

    println!("{}", dp[n-1]);
}

// 1次元DP(その2)
fn dp_one2() {
    // 五つの数1,6,10,50,234が与えられる。
    // 整数Nからこれらの数で引き算を繰り返して、Nを0にしたい。
    // また、五つの数字は何度でも用いて良い。
    // 最小の回数を出力せよ。(1<=N<=100000)

    // 入力
    // N=19
    // 出力
    // 4

    let n = 19;
    let an = vec![1, 6, 10, 50, 234];

    let inf = 1 << 29;

    // dp[i]: 何回か引き算してiをちょうど0にするときの最小回数
    let mut dp = vec![inf; n + 1];
    dp[0] = 0;

    for i in 1..n + 1 {
        for j in 0..an.len() {
            if i >= an[j] {
                dp[i] = cmp::min(dp[i], dp[i - an[j]] + 1);
            }
        }
    }

    println!("{}", dp[n]);
}
