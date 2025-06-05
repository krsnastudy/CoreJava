## Sudoku problem
You are given a partially filled 9x9 Sudoku board. Your task is to determine if the board is valid.

A Sudoku board is valid if:

1. Each row contains the digits 1-9 without repetition.

2. Each column contains the digits 1-9 without repetition.

3. Each of the 9 subgrids (3x3) contains the digits 1-9 without repetition.

Only the filled cells (non-"." cells) need to be validated. Empty cells (".") can be ignored.

Input:

A 9x9 grid, where each cell contains:

A digit from 1 to 9

A dot (".") representing an empty cell.

Output:

Return true if the board is valid according to the rules.

Return false if the board violates any of the rules.

Example:

Input:

board

1

Output: true