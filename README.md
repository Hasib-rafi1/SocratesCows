# SocratesCows
Socrates’ cows are grazing in meadows. At each sunset Socrates blows a special whistle and the cows come back to the stable. Socrates wants to know which cow(s) reaches the stable the fastest. Each cow is in some meadow and some meadows might not have any cows. There are paths between
some pair of meadows (it is possible that two meadows have more than one path connecting them.) Starting from any meadow a cow can reach the meadow in which the stable resides. Socrates’ cows are smart and they always choose the shortest path to the stable. All cows move with a same constant speed, and multiple cows can use a same path at the same time. The meadows names are a small or capital English letter, i.e. a . . . z and A . . . Z . Before the whistle blows, a meadow has a capital letter name if and only if a cow reside in it. The stable is in meadow z and there is no cow in it before the whistle blows.

# Input
• Line 1: Integer number P. (Number of paths that connect the meadows.)
• Lines 2 to P+1: Two letters and an integer number in each line, representing a path and the time it takes
the cows to pass it.
1 ≤ P ≤ 104 1 ≤ distance ≤ 103

# Output
One line containing one letter and one integer number, representing any meadow whose cow(s) reaches the
stable the fastest (therefore definitely a capital letter) and the amount of time it take these cow(s) to reach the
stable.

# Sample Test Cases
Input:
5
A d 9
B d 3
C e 9
d z 8
e z 3

Output:
B 11
