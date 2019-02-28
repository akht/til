main = do
    k <- readLn::IO Int
    let o = (k + 1) `div` 2
    let e = k `div` 2
    print $ o * e