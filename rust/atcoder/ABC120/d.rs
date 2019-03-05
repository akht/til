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
        m: usize,
        v: [(usize1, usize1); m],
    }

    let mut uf = UnionFind::new(n);

    let mut ans = vec![];
    let mut cur: i64 = (n as i64 * (n - 1) as i64) / 2;

    for (a, b) in v.into_iter().rev() {
        ans.push(cur);
        
        if uf.is_same(a, b) {
            continue;
        }

        let size_a = uf.size(a);
        let size_b = uf.size(b);
        cur -= (size_a * size_b) as i64;

        uf.merge(a, b);
    }

    ans.reverse();

    for a in ans {
        println!("{}", a);
    }
}

struct UnionFind {
    parent: Vec<i32>,
}

impl UnionFind {
    fn new(n: usize) -> UnionFind {
        // let mut v = vec![-1, n];
        UnionFind { parent: vec![-1; n] }
    }

    fn root(&mut self, x: usize) -> usize {
        if self.parent[x] < 0 {
            x as usize
        } else {
            let x2 = self.parent[x] as usize;
            self.parent[x] = self.root(x2) as i32;
            self.parent[x] as usize
        }
    }

    fn is_same(&mut self, x: usize, y: usize) -> bool {
        self.root(x) == self.root(y)
    }

    fn merge(&mut self, x: usize, y: usize) -> bool {
        let mut x_root = self.root(x);
        let mut y_root = self.root(y);
        if x_root == y_root {
            return false;
        }

        // merge technique
        if self.parent[x_root] > self.parent[y_root] {
            let tmp = x_root;
            x_root = y_root;
            y_root = tmp;
        }

        self.parent[x_root] += self.parent[y_root];
        self.parent[y_root] = x_root as i32;
        return true;
    }

    fn size(&mut self, x: usize) -> usize {
        let root = self.root(x);
        -self.parent[root] as usize
    }

    fn print(&mut self) {
        println!("{:?}", self.parent);
    }
}