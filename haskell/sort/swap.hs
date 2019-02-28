-- http://jutememo.blogspot.jp/2011/04/haskell-swap-9.html

-- haskellでswapを実装

-- (x:xs)とtake、drop関数を使用する
swap1 list@(x : xs) 0 j = list !! j : take (j-1) xs ++ [x] ++ drop (j+1) list
swap1 xs i j
    | i > j = swap1 xs j i
    | otherwise = swap1 xs (i-1) (j-1)


slice i j = snd . splitAt i . fst . splitAt (j+1)
