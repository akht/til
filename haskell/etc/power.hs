-- 累乗を計算する

-- 単純な再帰 O(n)
power _ 0 = 1
power x n = x * power x (n - 1)



-- 工夫したもの O(nlogn)
-- X^nにおいてnが偶数の時、「X^n = (X^2)^n/2」となることを利用
-- (例) 3^6 = 9^3, 9^8 = 81^4
-- こうすることで、毎回半分になるので計算量はO(nlogn)になる
-- nが奇数の場合はpower2 x (n-1)都することで次のステップでは必ず偶数になる
power2 x n
    | n == 0 = 1
    | n `mod` 2 == 0 = power2 (x * x) (n `div` 2)
    | otherwise = x * power2 x (n - 1)
