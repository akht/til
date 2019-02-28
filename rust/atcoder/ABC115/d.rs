#[allow(unused_macros)]
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
        x: i64,
    }

    let mut ls: Vec<i64> = Vec::new();
    ls.push(1);
    let mut l = 1_i64;

    let mut ps: Vec<i64> = Vec::new();
    ps.push(1);
    let mut p = 1_i64;

    for i in 0..50 {
        l = 2 * ls[i] + 3;
        ls.push(l);

        p = 2 * ps[i] + 1;
        ps.push(p);
    }

    println!("{}", count(n, x, ls, ps));
}

fn count(n: usize, x: i64, ls: Vec<i64>, ps: Vec<i64>) -> i64 {
    if x == 0 {
        return 0;
    }
    if n == 0 {
        return 1;
    }

    let size = ls[n];
    let half = size / 2 + 1;
    if x < half {
        count(n - 1, x - 1, ls, ps)
    } else if x == half {
        ps[n - 1] + 1
    } else {
        ps[n - 1] + 1 + count(n - 1, x - half, ls, ps)
    }
}