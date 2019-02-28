# HAVING句

https://codezine.jp/article/detail/652


## 連番に歯抜けを探す

### 連番に歯抜けがあるかどうか

```sql
SELECT 'あり'
  FROM table
HAVING COUNT(*) <> MAX(seq)
```


### 歯抜けの最小値を探す

```sql
SELECT MIN(id)
  FROM table
 WHERE (id + 1) NOT IN (SELECT id FROM table)
```




## 最頻値(モード:mode)を求める

**最頻値 = もっともよく現れる値のこと**

memberテーブル
|name|income|
|:--:|--:|
|サンプソン|400,000|
|マイク|30,000|
|ホワイト|20,000|
|アーノルド|20,000|
|スミス|20,000|
|ロレンス|15,000|
|ハドソン|15,000|
|ケント|10,000|
|ベッカー|10,000|
|スコット|10,000|


値でグルーピングして、その個数が最大のグループを返せばいい

その１ ALLを使う
ALL (select ~)の部分で、各income値の出現回数が返るので、それらすべて以上ならそれが最大といえる
```sql
  SELECT income
    FROM member
GROUP BY income
  HAVING COUNT(*) >= ALL ( SELECT COUNT(*) FROM member GROUP BY income )
```

その２ MAXを使う
```sql
  SELECT income
    FROM member
GROUP BY income
  HAVING COUNT(*) >= ( SELECT MAX(sub.cnt) FROM ( SELECT COUNT(*) AS cnt FROM member GROUP BY income ) AS sub )
```


## 中央値(メジアン:median)を求める

```sql
SELECT AVG(DISTINCT sub.income)
  FROM (  SELECT t1.income
            FROM member AS t1, member AS t2
        GROUP BY t1.income
          HAVING SUM(CASE WHEN t2.income >= t1.income THEN 1 ELSE 0 END) >= COUNT(*) / 2
             AND SUM(CASE WHEN t2.income <= t1.income THEN 1 ELSE 0 END) >= COUNT(*) / 2) AS sub
```



