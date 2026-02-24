<h2><a href="https://leetcode.com/problems/first-element-with-unique-frequency">First Element with Unique Frequency</a></h2> <img src='https://img.shields.io/badge/Difficulty-Medium-orange' alt='Difficulty: Medium' /><hr><p>You are given an integer array <code>nums</code>.</p>

<p>Return an integer denoting the <strong>first</strong> element (scanning from left to right) in <code>nums</code> whose <strong>frequency</strong> is <strong>unique</strong>. That is, no other integer appears the same number of times in <code>nums</code>. If there is no such element, return -1.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">nums = [20,10,30,30]</span></p>

<p><strong>Output:</strong> <span class="example-io">30</span></p>

<p><strong>Explanation:</strong></p>

<ul>
	<li>20 appears once.</li>
	<li>10 appears once.</li>
	<li>30 appears twice.</li>
	<li>The frequency of 30 is unique because no other integer appears exactly twice.</li>
</ul>
</div>

<p><strong class="example">Example 2:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">nums = [20,20,10,30,30,30]</span></p>

<p><strong>Output:</strong> <span class="example-io">20</span></p>

<p><strong>Explanation:</strong></p>

<ul>
	<li>20 appears twice.</li>
	<li>10 appears once.</li>
	<li>30 appears 3 times.</li>
	<li>The frequency of 20, 10, and 30 are unique. The first element that has unique frequency is 20.</li>
</ul>
</div>

<p><strong class="example">Example 3:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">nums = [10,10,20,20]</span></p>

<p><strong>Output:</strong> <span class="example-io">-1</span></p>

<p><strong>Explanation:</strong></p>

<ul>
	<li>10 appears twice.</li>
	<li>20 appears twice.</li>
	<li>No element has a unique frequency.</li>
</ul>
</div>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 10<sup>5</sup></code></li>
	<li><code>1 &lt;= nums[i] &lt;= 10<sup>5</sup></code></li>
</ul>
