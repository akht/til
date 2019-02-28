main = do
    [a, b] <- map read . words <$> getLine
    putStrLn $ show $ (a - 1) * (b - 1)