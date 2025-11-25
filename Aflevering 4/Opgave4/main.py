# The program must print the lines given in the file main.txt

# The function play(s, n) takes the initial string with cells alive
# and the number of iterations, but must stop if no cells are alive

# The function show(a) takes a list of lists as printed in main.txt
# where the initial string with cells alive are placed from index 0

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
