def partition(array, left, right)
    pivot = (left + right) / 2
    pv = array[pivot]
    lp = left;
    rp = right;
    while true
        while array[lp] < pv
            lp += 1
        end
        while array[rp] > pv
            rp -= 1
        end
        if lp > rp
            return lp
        end

        temp = array[lp]
        array[lp] = array[rp]
        array[rp] = temp
        lp += 1
        rp -= 1
    end
end

def quicksort(array, left, right)
    if left == right
        return
    end
    lp = partition(array, left, right)
    quicksort(array, left, lp-1)
    quicksort(array, lp, right)
end

array = [16, 5, 3, 2, 21, 10, 4, 6, 7, 9, 18]
p array
quicksort(array, 0, array.size-1)
p array
