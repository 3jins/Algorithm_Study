'''
09:29 ~
Never sort dictionary by value...!!
'''

# quick sort
def sort_score_list(unsorted, key_idx, sorting):
    pivot = unsorted[0][key_idx]
    l = m = r = 0
    left = []
    mid = []
    right = []

    if sorting == 'dsc':    # 내림차순
        for idx, score in enumerate(unsorted):
            if score[key_idx] > pivot:
                l += 1
                left.append(score)
            elif score[key_idx] < pivot:
                r += 1
                right.append(score)
            else:
                m += 1
                mid.append(score)
    elif sorting == 'asc':  # 오름차순
        for idx, score in enumerate(unsorted):
            if score[key_idx] < pivot:
                l += 1
                left.append(score)
            elif score[key_idx] > pivot:
                r += 1
                right.append(score)
            else:
                m += 1
                mid.append(score)
    else:
        return []

    if l > 1:
        left = sort_score_list(left, key_idx, sorting)
    if r > 1:
        right = sort_score_list(right, key_idx, sorting)

    return left + mid + right


# sort order : Kor dsc -> Eng asc -> math dsc -> name asc
def sort_by_law(score_list):
    score_list = sort_score_list(score_list, 0, 'asc')  # name
    score_list = sort_score_list(score_list, 3, 'dsc')  # math
    score_list = sort_score_list(score_list, 2, 'asc')  # English
    score_list = sort_score_list(score_list, 1, 'dsc')  # Korean
    return score_list


if __name__ == "__main__":
    num_rows = int(input())
    names = []
    score_list = []

    # input
    for row in range(num_rows):
        score_list.append(input().split(' '))
        score_list[row][1:4] = list(map(int, score_list[row][1:4]))

    # sort
    score_list = sort_by_law(score_list)

    # output
    for score in score_list:
        print(score[0])
