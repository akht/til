# バッカスナウア記法(BNF)

```BNF
<expr>  ::= <var> | (<var> + <var>) | <var> * <var>
<var>   ::= A | B | C | D
```

この生成規則から以下の式が生成できるか？

```
ア. A + (B + C) * D
イ. (A + B) + (C + D)
ウ. (A + B) * (C + D)
エ. (A * B) + (C * D)
```

## まず定義の確認

`<expr>`というのは以下の３つのどれか(どれでもいい)
- `<var>`　　　　　　　 ...①
- `(<expr> + <expr>)`　...②
- `<expr> * <expr>`　　...③

`<var>`というのは以下の４つのどれか(どれでもいい)
- A
- B
- C
- D

## 解釈

演算子`+`と`*`に注目する。

### ア. A + (B + C) * D
Aのあとに`+`があるので、②のパターン。
しかしアは全体が()で括られていないので②の定義とは一致しない。
よってアは生成できない。

### イ. (A + B) + (C + D)
`(A + B)`と`(C + D)`の部分が②の`(<expr> + <expr>)`で表せる。
なので置き換えてみると、`<expr> + <expr>`になる（`(<expr> + <expr>)`は<expr>なのでさらに置き換えられる）
`<expr> + <expr>`は定義にない。
よって生成できない。

### ウ. (A + B) * (C + D)
`(A + B)`と`(C + D)`を`(<expr> + <expr>)`で表せる。
なので置き換えてみると、`<expr> * <expr>`となり、これは③のパターンと一致する。
よって生成できる。

### エ. (A * B) + (C * D)
中央に`+`があるので②のパターンとして考えてみると、
`A * B`と`C * D`の部分が``<expr> * <expr>`とみなせるので
`(<expr> * <expr>) + (<expr> * <expr>)`となるが、これは定義にない。
よって生成できない。


## EBNF(拡張バッカスナウア記法)
上の生成規則をEBNFにすると以下になる。

```BNF
expr  ::= var | "(" var "+" var ")" | var "*" var
var   ::= "A" | "B" | "C" | "D"
```

### 基本

```BNF
digit_excluding_zero  = "1" | "2" | "3" | "4" | "5" | "6" | "7" | "8" | "9" ;
digit                 = "0" | digit_excluding_zero ;
```

`digit_excluding_zero`は1から9のいずれか、`digit`は0または`digit_excluding_zero`のどちらか。

カンマで区切ることで並びを含むことができる。
```BNF
twelve                          = "1" , "2" ;
two_hundred_one                 = "2" , "0" , "1" ;
three_hundred_twelve            = "3" , twelve ;
twelve_thousand_two_hundred_one = twelve , two_hundred_one ;
```

省略可能かつ繰り返し可能な部分は中括弧{}で表す。
```BNF
自然数
natural_number = digit_excluding_zero , { digit } ;
```

省略可能な部分は大括弧[]で表す。
```BNF
整数
integer = "0" | [ "-" ] , natural_number ;
```
この場合、integerは0かnatural_number(自然数)であり、natural_numberにはオプションとしてマイナス符号を付けられる。
