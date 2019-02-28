main = do
    [n, k] <- map read . words <$> getLine
    let x = n `div` k
        y = (n + k `div` 2) `div` k
    if k `mod` 2 == 0
        then print $ (x ^ 3) + (y ^ 3)
        else print $ x ^ 3