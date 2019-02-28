import Control.Applicative ((<$>))
import System.Environment (getArgs)

hanoi :: Int -> Int
hanoi 0 = 0
hanoi x = (hanoi (x - 1)) + 1 + (hanoi (x - 1))

hanoiStep :: Int -> String -> String -> String -> [String]
hanoiStep 0 _ _ _ = []
hanoiStep x from to using = hanoiStep (x - 1) from using to ++ [from ++ "->" ++ to] ++ hanoiStep (x - 1) using to from


doHanoi :: Int -> [([Int], [Int], [Int])]
doHanoi 0 = [([], [], [])]
doHanoi n =
    map (\(xs, ys, zs) -> (xs ++ [n], zs, ys)) (doHanoi (n - 1)) ++
    map (\(xs, ys, zs) -> (ys, xs, zs ++ [n])) (doHanoi (n - 1))

-- 実行方法
-- > mapM_ print $ doHanoi 3