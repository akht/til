-- Data.Foldable.concat関数の実装を学ぶ
-- https://teratail.com/questions/52419



-- ※これはこのままではエラーになる(あくまで実装の参考)

build :: forall a. (forall b. (a -> b -> b) -> b -> b) -> [a]
build g = g (:) []


concat :: Foldable t => t [a] -> [a]
concat :: build (\c n -> foldr (\x y -> foldr c y x) n xs)



