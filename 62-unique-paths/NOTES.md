Initialise 2D matrix (rows*cols (m*n)) as dp

We are supposed to move either right or down so intialize all cols of row 0 as 1 and initialise entire col 0 as 1    
Before: [[0,0,0,0,0,0,0],
         [0,0,0,0,0,0,0],
         [0,0,0,0,0,0,0]]
         
After: [[1,1,1,1,1,1,1],
        [1,0,0,0,0,0,0],
        [1,0,0,0,0,0,0]]

Note your iterative loops for moving with rows, cols should start with 1 as you have already initialised 1 for necessary obvious spots. 
Now we proceed by computing value for each 0. To start with (1,1), the maximum possible ways to reach (1,1) is the box just over it + the box just at the left of it. (dp[row-1][col] + dp[row][col-1]

Finally, we return value at dp[row-1][col-1] ([m-1][n-1]). -1 because for each matrix, the dest is row-1,col-1 as indexing begins with 0. Given example has 3*3 matrix, the destination position by row-col intersections comes at (2,2).

