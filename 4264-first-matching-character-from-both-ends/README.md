<h2><a href="https://leetcode.com/problems/first-matching-character-from-both-ends">First Matching Character From Both Ends</a></h2> <img src='https://img.shields.io/badge/Difficulty-Easy-brightgreen' alt='Difficulty: Easy' /><hr><p>You are given a string <code>s</code> of length <code>n</code> consisting of lowercase English letters.</p>

<p>Return the smallest index <code>i</code> such that <code>s[i] == s[n - i - 1]</code>.</p>

<p>If no such index exists, return -1.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">s = &quot;abcacbd&quot;</span></p>

<p><strong>Output:</strong> <span class="example-io">1</span></p>

<p><strong>Explanation:</strong></p>

<p>At index <code>i = 1</code>, <code>s[1]</code> and <code>s[5]</code> are both <code>&#39;b&#39;</code>.</p>

<p>No smaller index satisfies the condition, so the answer is 1.</p>
</div>

<p><strong class="example">Example 2:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">s = &quot;abc&quot;</span></p>

<p><strong>Output:</strong> <span class="example-io">1</span></p>

<p><strong>Explanation:</strong></p>

<p>​​​​​​​At index <code>i = 1</code>, the two compared positions coincide, so both characters are <code>&#39;b&#39;</code>.</p>

<p>No smaller index satisfies the condition, so the answer is 1.</p>
</div>

<p><strong class="example">Example 3:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">s = &quot;abcdab&quot;</span></p>

<p><strong>Output:</strong> <span class="example-io">-1</span></p>

<p><strong>Explanation:</strong></p>

<p>​​​​​​​For every index <code>i</code>, the characters at positions <code>i</code> and <code>n - i - 1</code> are different.</p>

<p>Therefore, no valid index exists, so the answer is -1.</p>
</div>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= n == s.length &lt;= 100</code></li>
	<li><code>s</code> consists of lowercase English letters.</li>
</ul>
