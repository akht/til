# &&や||を使った時必ずしも式全体の戻り値はtrue/falseにならない

# 式全体が真または偽であることが決定するまで左辺から順に式を評価する
# 式全体の真偽が確定すると式の評価を終了し、最後に評価した式の値を返す

1 && 2 && 3 #=> 3
1 && nil && 3 #=> nil
1 && false && 3 #=> false

nil || false #=> false
false || nil #=> nil
nil || false || 2 || 3 #=> 2

# Alice, Bob, Carolを順に検索し、最初に見つかったユーザー(nil/false以外の値)を変数に入れる
user = find_user('Alice') || find_user('Bob') || find_user('Carol')

# 正常なユーザーであればメールを送信する
# 左辺が偽であれば式全体が偽で確定するので右辺は実行されない
user.valid? && send_email_to(user)
