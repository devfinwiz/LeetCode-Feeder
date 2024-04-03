<h2><a href="https://leetcode.com/problems/count-and-say">Count and Say</a></h2> <img src='https://img.shields.io/badge/Difficulty-Medium-orange' alt='Difficulty: Medium' /><hr><p>The <strong>count-and-say</strong> sequence is a sequence of digit strings defined by the recursive formula:</p>

<ul>
	<li><code>countAndSay(1) = &quot;1&quot;</code></li>
	<li><code>countAndSay(n)</code> is the way you would &quot;say&quot; the digit string from <code>countAndSay(n-1)</code>, which is then converted into a different digit string.</li>
</ul>

<p>To determine how you &quot;say&quot; a digit string, split it into the <strong>minimal</strong> number of substrings such that each substring contains exactly <strong>one</strong> unique digit. Then for each substring, say the number of digits, then say the digit. Finally, concatenate every said digit.</p>

<p>For example, the saying and conversion for digit string <code>&quot;3322251&quot;</code>:</p>
<img alt="" src="https://assets.leetcode.com/uploads/2020/10/23/countandsay.jpg" style="width: 581px; height: 172px;" />
<p>Given a positive integer <code>n</code>, return <em>the </em><code>n<sup>th</sup></code><em> term of the <strong>count-and-say</strong> sequence</em>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> n = 1
<strong>Output:</strong> &quot;1&quot;
<strong>Explanation:</strong> This is the base case.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> n = 4
<strong>Output:</strong> &quot;1211&quot;
<strong>Explanation:</strong>
countAndSay(1) = &quot;1&quot;
countAndSay(2) = say &quot;1&quot; = one 1 = &quot;11&quot;
countAndSay(3) = say &quot;11&quot; = two 1&#39;s = &quot;21&quot;
countAndSay(4) = say &quot;21&quot; = one 2 + one 1 = &quot;12&quot; + &quot;11&quot; = &quot;1211&quot;
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= n &lt;= 30</code></li>
</ul>
