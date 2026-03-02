<h2><a href="https://leetcode.com/problems/merge-close-characters">Merge Close Characters</a></h2> <img src='https://img.shields.io/badge/Difficulty-Medium-orange' alt='Difficulty: Medium' /><hr><p>You are given a string <code>s</code> consisting of lowercase English letters and an integer <code>k</code>.</p>

<p>Two <strong>equal</strong> characters in the <strong>current</strong> string <code>s</code> are considered <strong>close</strong> if the distance between their indices is <strong>at most</strong> <code>k</code>.</p>

<p>When two characters are <strong>close</strong>, the right one merges into the left. Merges happen <strong>one at a time</strong>, and after each merge, the string updates until no more merges are possible.</p>

<p>Return the resulting string after performing all possible merges.</p>

<p><strong>Note</strong>: If multiple merges are possible, always merge the pair with the <strong>smallest left</strong> index. If multiple pairs share the smallest left index, choose the pair with the <strong>smallest right</strong> index.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">s = &quot;abca&quot;, k = 3</span></p>

<p><strong>Output:</strong> <span class="example-io">&quot;abc&quot;</span></p>

<p><strong>Explanation:</strong></p>

<ul>
	<li><strong>​​​​​​​</strong>Characters <code>&#39;a&#39;</code> at indices <code>i = 0</code> and <code>i = 3</code> are close as <code>3 - 0 = 3 &lt;= k</code>.</li>
	<li>Merge them into the left <code>&#39;a&#39;</code> and <code>s = &quot;abc&quot;</code>.</li>
	<li>No other equal characters are close, so no further merges occur.</li>
</ul>
</div>

<p><strong class="example">Example 2:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">s = &quot;aabca&quot;, k = 2</span></p>

<p><strong>Output:</strong> <span class="example-io">&quot;abca&quot;</span></p>

<p><strong>Explanation:</strong></p>

<ul>
	<li>Characters <code>&#39;a&#39;</code> at indices <code>i = 0</code> and <code>i = 1</code> are close as <code>1 - 0 = 1 &lt;= k</code>.</li>
	<li>Merge them into the left <code>&#39;a&#39;</code> and <code>s = &quot;abca&quot;</code>.</li>
	<li>Now the remaining <code>&#39;a&#39;</code> characters at indices <code>i = 0</code> and <code>i = 3</code> are not close as <code>k &lt; 3</code>, so no further merges occur.</li>
</ul>
</div>

<p><strong class="example">Example 3:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">s = &quot;yybyzybz&quot;, k = 2</span></p>

<p><strong>Output:</strong> <span class="example-io">&quot;ybzybz&quot;</span></p>

<p><strong>Explanation:</strong></p>

<ul>
	<li>Characters <code>&#39;y&#39;</code> at indices <code>i = 0</code> and <code>i = 1</code> are close as <code>1 - 0 = 1 &lt;= k</code>.</li>
	<li>Merge them into the left <code>&#39;y&#39;</code> and <code>s = &quot;ybyzybz&quot;</code>.</li>
	<li>Now the characters <code>&#39;y&#39;</code> at indices <code>i = 0</code> and <code>i = 2</code> are close as <code>2 - 0 = 2 &lt;= k</code>.</li>
	<li>Merge them into the left <code>&#39;y&#39;</code> and <code>s = &quot;ybzybz&quot;</code>.</li>
	<li>No other equal characters are close, so no further merges occur.</li>
</ul>
</div>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= s.length &lt;= 100</code></li>
	<li><code>1 &lt;= k &lt;= s.length</code></li>
	<li><code>s</code> consists of lowercase English letters.</li>
</ul>
