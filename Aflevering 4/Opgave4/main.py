# The program must print the lines given in the file main.txt

# The function play(s, n) takes the initial string with cells alive
# and the number of iterations, but must stop if no cells are alive

# The function show(a) takes a list of lists as printed in main.txt
# where the initial string with cells alive are placed from index 0

def play(s, n):
    res = []
    current_state = []
    for i in range(len(s)):
        if s[i] == "*":
            current_state.append(i)
    res.append(current_state)

    for iteration in range(n-1):
        next_state = []
        for i in range(res[-1][0]-2, res[-1][-1]+2):
            neighbors = 0
            for j in range(1, 3):
                if i + j in res[-1]:
                    neighbors += 1
                if i - j in res[-1]:
                    neighbors += 1
            if not i in res[-1]:
                if neighbors == 2 or neighbors == 3:
                    next_state.append(i)
            elif neighbors == 2 or neighbors == 4:
                next_state.append(i)
        if next_state == []:
            return res
        res.append(next_state)
    return res

        
def show(a):
    min_val = 0
    for line in a:
        if min(line) < min_val:
            min_val = min(line)
    
    for line in a:
        line_res = ""
        for i in range(min_val,max(line)+1):
            if i in line:
                line_res += "*"
            else:
                line_res += " "
        print(line_res)

def main():
    print("Welcome to One-Dimensional Game of Life")
    print()
    for s in "* **", "* ***", "******", "*******":
        a = play(s, len(s) ** 2)
        print("List length", len(a))
        for x in a:
            print(x)
        print()
        show(a)
        print()
    print("Shows Flipflop, Glider, Spider and Face")

# The above lines for the function main() must not be changed

main()
