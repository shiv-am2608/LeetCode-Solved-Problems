# Word Break (Trie)
## Hard 
<div class="problem-statement">
                <p></p><p><span style="font-size:18px">Given a string <strong>A </strong>and a dictionary of n words <strong>B</strong>, find out if A&nbsp;can be segmented into a space-separated sequence of dictionary words.&nbsp;</span></p>

<p><br>
<span style="font-size:18px"><strong>Example 1:</strong></span></p>

<pre><span style="font-size:18px"><strong>Input:</strong>
n = 12
B = { "i", "like", "sam", "sung", "samsung",
"mobile","ice","cream", "icecream", "man",
"go", "mango" }, A = "ilike"
<strong>Output:</strong> 1
<strong>Explanation: </strong>The string can be segmented as 
"i like".
</span></pre>

<p><br>
<span style="font-size:18px">â€‹<strong>Example 2:</strong></span></p>

<pre><span style="font-size:18px"><strong>Input</strong>:
n = 12
B = { "i", "like", "sam", "sung", 
"samsung", "mobile","ice","cream", "icecream",
"man", "go", "mango" }, A = "ilikesamsung"
<strong>Output:</strong> 1
<strong>Explanation</strong>: The string can be segmented as 
"i like samsung" or "i like sam sung".
</span></pre>

<p>&nbsp;</p>

<p><span style="font-size:18px"><strong>Your Task:</strong><br>
Complete&nbsp;<strong>wordBreak()</strong>&nbsp;function which takes a string and list of strings as a parameter&nbsp;and returns 1 if it is possible to break words, else return&nbsp;0. You don't need to read any input or print any output, it is done by driver code.</span></p>

<p><br>
<span style="font-size:18px"><strong>Expected time complexity:&nbsp;</strong>O(n*l) wwhere l is the leght of longest string present in dictionary</span><br>
<span style="font-size:18px"><strong>â€‹Expected auxiliary space:</strong>&nbsp;O(|A| + k) , where k = sum of length of all strings present in B</span></p>

<p>&nbsp;</p>

<p><span style="font-size:18px"><strong>Constraints</strong>:<br>
1 &lt;= N &lt;= 12<br>
1 &lt;= s &lt;=1000 , where s =&nbsp;length of string A<br>
&nbsp;The length of each word is less than 15.</span></p>

<p>&nbsp;</p>
 <p></p>
            </div>