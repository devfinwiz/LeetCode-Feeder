<h2><a href="https://leetcode.com/problems/smallest-pair-with-different-frequencies">Smallest Pair With Different Frequencies</a></h2> <img src='https://img.shields.io/badge/Difficulty-Easy-brightgreen' alt='Difficulty: Easy' /><hr><p>You are given an integer array <code>nums</code>.</p>

<p>Consider all pairs of <strong>distinct</strong> values <code>x</code> and <code>y</code> from <code>nums</code> such that:</p>

<ul>
	<li><code>x &lt; y</code></li>
	<li><code>x</code> and <code>y</code> have different <span data-keyword="frequency-array">frequencies</span> in <code>nums</code>.</li>
</ul>

<p>Among all such pairs:</p>

<ul>
	<li>Choose the pair with the smallest possible value of <code>x</code>.</li>
	<li>If multiple pairs have the same <code>x</code>, choose the one with the smallest possible value of <code>y</code>.</li>
</ul>

<p>Return an integer array <code>[x, y]</code>. If no valid pair exists, return <code>[-1, -1]</code>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">nums = [1,1,2,2,3,4]</span></p>

<p><strong>Output:</strong> <span class="example-io">[1,3]</span></p>

<p><strong>Explanation:</strong></p>

<p>The smallest value is 1 with a frequency of 2, and the smallest value greater than 1 that has a different frequency from 1 is 3 with a frequency of 1. Thus, the answer is <code>[1, 3]</code>.</p>
</div>

<p><strong class="example">Example 2:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">nums = [1,5]</span></p>

<p><strong>Output:</strong> <span class="example-io">[-1,-1]</span></p>

<p><strong>Explanation:</strong></p>

<p>Both values have the same frequency, so no valid pair exists. Return <code>[-1, -1]</code>.</p>
</div>

<p><strong class="example">Example 3:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">nums = [7]</span></p>

<p><strong>Output:</strong> <span class="example-io">[-1,-1]</span></p>

<p><strong>Explanation:</strong></p>

<p>There is only one value in the array, so no valid pair exists. Return <code>[-1, -1]</code>.</p>
</div>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 100</code></li>
	<li><code>1 &lt;= nums[i] &lt;= 100</code></li>
</ul>
