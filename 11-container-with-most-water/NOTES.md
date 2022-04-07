1. Store indexes of 2 bars as left and right resp. Initialise maxarea=0

2. Calculate value of bars (left,right).

3. Find out the bar with minimum height from the two(because that will be used to find the maximum area that can be oppcupied for water storage)

4. Find out distance between these two bars (index difference)

5. Multiply distance between bars with bar with minimum height (distance*minbar)

6. Use max function to repeatedly store the maximum area by comparing area initialised at the start with current area in the loop iteration. 

7. Return maximum area.
