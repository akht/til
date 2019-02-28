{-|
  Description: ブラックジャックの手札の合計点数を計算するmodule
-}
module BlackJack
  (
    Card(A, J, Q, K)

  , deck
  , heartSuit
  , diaSuit
  , cloverSuit
  , spadeSuit
  , sumHand
  ) where

import Data.List.NonEmpty (NonEmpty((:|)))
import qualified Data.List.NonEmpty as NonEmpty
import Data.Semigroup (sconcat)



--data Card =
--  A | N2 | N3 | N4 | N5 | N6 | N7 | N8 | N9 | N10 | J | Q | K deriving (Eq, Show)

-- Cardの定義を直和型で書き直す(N2～N10までが冗長なので)
data Card =
  A | N Int | J | Q | K deriving (Eq, Show)


-- 手札の合計を求める関数
sumHand :: [Card] -> Int
sumHand cards =
  let possiblePoints  = map toPoint cards
      scoreCandidates = foldl plusEach [0] possiblePoints
      noBust          = filter (<= 21) scoreCandidates
  in
    if null noBust
      then head scoreCandidates
      else maximum noBust


-- Card型を変換して取りうる値にする関数
toPoint :: Card -> [Int]
toPoint A     = [1, 11]   -- Aの場合は1と11を取りうる
toPoint (N n) = [n]       -- 通常の数字カードはその数字のみ
toPoint _     = [10]      -- そのほかは10

-- ふたつのリストを受け取って、すべての組み合わせの和のリストを返す
plusEach :: [Int] -> [Int] -> [Int]
plusEach list1 list2 = concatMap (\x -> map (\y -> x + y) list2) list1

-- plusEachをアプリカティブスタイルで書く
plusEach' :: [Int] -> [Int] -> [Int]
plusEach' list1 list2 = (+) <$> list1 <*> list2



-- ↓NonEmpty型を使って、型レベルで空リストを返さないことを保証したバージョン

-- NonEmpty型を扱えるようにしたもの
sumHand' :: [Card] -> Int
sumHand' cards =
  let possiblePoints  = map toPoint' cards
      scoreCandidates = foldl plusEach'' (0 :| []) possiblePoints
      noBust          = NonEmpty.filter (<= 21) scoreCandidates
  in
    if null noBust
      then NonEmpty.head scoreCandidates
      else maximum noBust

-- toPoint関数を書き換えたもの
-- このリストが必ず空でないリストを返すことを型レベルで保証したいのでNonEmpty型を使う
toPoint' :: Card -> NonEmpty Int
toPoint' A      = 1 :| [11]
toPoint' (N n)  = n :| []
toPoint' _      = 10 :| []

-- plusEach関数でNonEmpty型を扱えるようにしたもの
plusEach'' :: NonEmpty Int -> NonEmpty Int -> NonEmpty Int
plusEach'' list1 list2 = sconcat $ NonEmpty.map (\x -> NonEmpty.map (\y -> x + y) list2 ) list1

-- plusEach''関数をアプリカティブスタイルで書いたもの(実装を変える必要がない。アプリカティブスタイルすごい)
plusEach''' :: NonEmpty Int -> NonEmpty Int -> NonEmpty Int
plusEach''' list1 list2 = (+) <$> list1 <*> list2


suit, heartSuit, diaSuit, cloverSuit, spadeSuit :: [Card]
suit = [A] ++ map N [2..10] ++ [J, Q, K]

heartSuit = suit
diaSuit = suit
cloverSuit = suit
spadeSuit = suit

deck :: [Card]
deck = heartSuit ++ diaSuit ++ cloverSuit ++ spadeSuit
