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
    input!{
        h: i64,
        w: i64,
        board: [chars; h],
    }

    let mut sy = 0;
    let mut sx = 0;
    let mut gy = 0;
    let mut gx = 0;

    for i in 0..h {
        for j in 0..w {
            if board[i as usize][j as usize] == 's' {
                sy = i;
                sx = j
            }
            if board[i as usize][j as usize] == 'g' {
                gy = i;
                gx = j;
            }
        }
    }

    // マスの訪問管理
    let mut visited = vec![vec![false; w as usize]; h as usize];

    dfs(sy, sx, h, w, &board, &mut visited);

    if visited[gy as usize][gx as usize] {
        println!("Yes");
    } else {
        println!("No");
    }
}

fn dfs(y: i64, x: i64, h: i64, w: i64, board: &Vec<Vec<char>>, visited: &mut Vec<Vec<bool>>) {
    if y < 0 || h <= y || x < 0 || w <= x {
        return;
    }
    if board[y as usize][x as usize] == '#' {
        return;
    }
    if visited[y as usize][x as usize] {
        return;
    }

    visited[y as usize][x as usize] = true;

    dfs(y - 1, x, h, w, board, visited);
    dfs(y + 1, x, h, w, board, visited);
    dfs(y, x - 1, h, w, board, visited);
    dfs(y, x + 1, h, w, board, visited);
}