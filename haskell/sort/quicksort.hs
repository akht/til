
-- Haskellでのクイックソート
qsort []     = []
qsort (p:xs) = qsort lt ++ [p] ++ qsort gteq
    where
    lt   = [x | x <- xs, x < p]     -- ピボットより小さいもの
    gteq = [x | x <- xs, x >= p]    -- ピボットより大きいもの
