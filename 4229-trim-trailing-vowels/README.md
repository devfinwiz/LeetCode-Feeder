<h2><a href="https://leetcode.com/problems/trim-trailing-vowels">Trim Trailing Vowels</a></h2> <img src='https://img.shields.io/badge/Difficulty-Easy-brightgreen' alt='Difficulty: Easy' /><hr><p>You are given a string <code>s</code> that consists of lowercase English letters.</p>

<p>Return the string obtained by removing <strong>all</strong> trailing <strong>vowels</strong> from <code>s</code>.</p>

<p>The <strong>vowels</strong> consist of the characters <code>&#39;a&#39;</code>, <code>&#39;e&#39;</code>, <code>&#39;i&#39;</code>, <code>&#39;o&#39;</code>, and <code>&#39;u&#39;</code>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">s = &quot;idea&quot;</span></p>

<p><strong>Output:</strong> <span class="example-io">&quot;id&quot;</span></p>

<p><strong>Explanation:</strong></p>

<p>Removing <code>&quot;id<u><strong>ea</strong></u>&quot;</code>, we obtain the string <code>&quot;id&quot;</code>.</p>
</div>

<p><strong class="example">Example 2:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">s = &quot;day&quot;</span></p>

<p><strong>Output:</strong> <span class="example-io">&quot;day&quot;</span></p>

<p><strong>Explanation:</strong></p>

<p>There are no trailing vowels in the string <code>&quot;day&quot;</code>.</p>
</div>

<p><strong class="example">Example 3:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">s = &quot;aeiou&quot;</span></p>

<p><strong>Output:</strong> <span class="example-io">&quot;&quot;</span></p>

<p><strong>Explanation:</strong></p>

<p>Removing <code>&quot;<u><strong>aeiou</strong></u>&quot;</code>, we obtain the string <code>&quot;&quot;</code>.</p>
</div>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= s.length &lt;= 100</code></li>
	<li><code>s</code> consists of only lowercase English letters.</li>
</ul>
