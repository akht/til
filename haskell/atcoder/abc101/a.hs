
main :: IO ()
main = do
    xs <- getLine
    print $ foldl (\n s -> if s == '+' then succ n else pred n) 0 xs