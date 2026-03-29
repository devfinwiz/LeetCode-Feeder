<h2><a href="https://leetcode.com/problems/minimum-absolute-difference-between-two-values">Minimum Absolute Difference Between Two Values</a></h2> <img src='https://img.shields.io/badge/Difficulty-Easy-brightgreen' alt='Difficulty: Easy' /><hr><p>You are given an integer array <code>nums</code> consisting only of 0, 1, and 2.</p>

<p>A pair of indices <code>(i, j)</code> is called <strong>valid</strong> if <code>nums[i] == 1</code> and <code>nums[j] == 2</code>.</p>

<p>Return the <strong>minimum</strong> absolute difference between <code>i</code> and <code>j</code> among all valid pairs. If no valid pair exists, return -1.</p>

<p>The absolute difference between indices <code>i</code> and <code>j</code> is defined as <code>abs(i - j)</code>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">nums = [1,0,0,2,0,1]</span></p>

<p><strong>Output:</strong> <span class="example-io">2</span></p>

<p><strong>Explanation:</strong></p>

<p>The valid pairs are:</p>

<ul>
	<li>(0, 3) which has absolute difference of <code>abs(0 - 3) = 3</code>.</li>
	<li>(5, 3) which has absolute difference of <code>abs(5 - 3) = 2</code>.</li>
</ul>

<p>Thus, the answer is 2.</p>
</div>

<p><strong class="example">Example 2:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">nums = [1,0,1,0]</span></p>

<p><strong>Output:</strong> <span class="example-io">-1</span></p>

<p><strong>Explanation:</strong></p>

<p>There are no valid pairs in the array, thus the answer is -1.</p>
</div>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 100</code></li>
	<li><code>0 &lt;= nums[i] &lt;= 2</code></li>
</ul>
