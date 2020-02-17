class MinHeap
  def initialize(source)
    @arr = []
    source.each do |e|
      push(e)
    end
  end

  def size
    @arr.size
  end

  def empty?
    @arr.empty?
  end

  # ヒープの最小値を返す(削除しない)
  def top
    @arr.first
  end

  # ヒープに値を追加する
  def push(value)
    @arr << value     # 最後尾に追加
    i = @arr.size - 1 # 追加されたノード番号

    # 親子関係を修復していく
    while i > 0
      parent = (i - 1) / 2 # 親のノード番号

      # 親子関係が逆転してなかったら終了
      break if @arr[parent] <= value

      # 親と自分をswap
      @arr[parent], @arr[i] = @arr[i], @arr[parent]

      i = parent
    end

    # 追加したい値は最終的にこの位置に決定する
    @arr[i] = value
  end

  # ヒープから最小値を取り出す
  def pop
    min = top # 最小値 = 返り値

    # ここからヒープを再構築する
    # ひとまず最後尾をルートノードにもっていくる
    tmp_node = @arr.last
    @arr.pop

    # ルートノードから降ろしていく
    i = 0
    while (i * 2 + 1) < size
      # 左側の子が配列のサイズを超えるまで
      # = 左側の子が配列サイズを超えているということは、
      # そのノードには子が存在しないということになる

      # 左右の子ノードの値を比較して小さい方をmin_childとする
      lhs_child = i * 2 + 1 # 左側の子
      rhs_child = i * 2 + 2 # 右側の子
      min_child = lhs_child # とりあえず左側が小さいと仮定しておく(右側の子が存在しないこともあるため)

      if rhs_child < size
        # 右側の子のインデックスが配列のサイズを超えていないとき
        # = 超えているということは、右側の子は存在しないということ
        # => その場合は左側の子が採用される

        if @arr[lhs_child] > @arr[rhs_child]
          min_child = rhs_child
        end
      end

      # 逆転していなければ終了
      break if @arr[min_child] >= tmp_node

      # 自分のノードを子の値にする
      @arr[i] = @arr[min_child]
      i = min_child
    end

    # 選んだノードは最終的にこの位置に決定(空なら最後の要素だったということなのでセット不要)
    @arr[i] = tmp_node unless empty?

    min
  end
end

heap = MinHeap.new([3, 3, 2, 5, 6, 0, 1, 4])
heap.size.times do
  puts heap.pop
end
