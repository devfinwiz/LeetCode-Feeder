<h2><a href="https://leetcode.com/problems/largest-palindromic-number">Largest Palindromic Number</a></h2> <img src='https://img.shields.io/badge/Difficulty-Medium-orange' alt='Difficulty: Medium' /><hr><p>You are given a string <code>num</code> consisting of digits only.</p>

<p>Return <em>the <strong>largest palindromic</strong> integer (in the form of a string) that can be formed using digits taken from </em><code>num</code>. It should not contain <strong>leading zeroes</strong>.</p>

<p><strong>Notes:</strong></p>

<ul>
	<li>You do <strong>not</strong> need to use all the digits of <code>num</code>, but you must use <strong>at least</strong> one digit.</li>
	<li>The digits can be reordered.</li>
</ul>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> num = &quot;444947137&quot;
<strong>Output:</strong> &quot;7449447&quot;
<strong>Explanation:</strong> 
Use the digits &quot;4449477&quot; from &quot;<u><strong>44494</strong></u><u><strong>7</strong></u>13<u><strong>7</strong></u>&quot; to form the palindromic integer &quot;7449447&quot;.
It can be shown that &quot;7449447&quot; is the largest palindromic integer that can be formed.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> num = &quot;00009&quot;
<strong>Output:</strong> &quot;9&quot;
<strong>Explanation:</strong> 
It can be shown that &quot;9&quot; is the largest palindromic integer that can be formed.
Note that the integer returned should not contain leading zeroes.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= num.length &lt;= 10<sup>5</sup></code></li>
	<li><code>num</code> consists of digits.</li>
</ul>
