# The Size of
## Easy 
<div class="problem-statement">
                <p></p><p><span style="font-size:18px">Now, we'll learn the use of <strong>sizeof </strong>operator in CPP. This operator is a<strong> unary type</strong>--it takes only one operand as input and outputs the <strong>size in bytes of the operand</strong>.<br>
You will be given four different variables of different data types: <strong>a (int)</strong>, <strong>b (float)</strong>, <strong>c (double)</strong>, <strong>l (long long)</strong>, <strong>d (string)</strong>. Your task is to do step-wise operations as given below:<br>
1. Divide <strong>b</strong> <strong>by c</strong>.<br>
2. Divide <strong>b</strong> <strong>by a</strong>.<br>
3. Divide <strong>c</strong> <strong>by a</strong>.<br>
4. Add result at step 3 with <strong>l</strong>.<br>
5. Print the <strong>sizeof(result) of each step in a single line</strong>. The outputs should be separated by spaces.<br>
6. Print the <strong>sizeof(d) and sizeof(d[3]) separated by a space</strong>.</span></p>

<p><span style="font-size:18px"><strong>Example:</strong></span></p>

<pre><span style="font-size:18px"><strong>Input:</strong>
a = 1 
b = 2
c = 3
l = 5
d = gfgc
<strong>Output:
</strong>4 8 4 8
32 1
<strong>Explanation:
</strong>b/c = 2/3 =&gt;sizeof(2/3)=&gt;float size is 4 bytes.
b/a = 2/1 =&gt;sizeof(2/1)=&gt;double size is 8 bytes.
c/a = 3/1 =&gt;sizeof(3/1)=&gt;integer size is 4 bytes.
(c/a)+l =3+5= 8 =&gt;sizeof(8)=&gt;long long size is 
8 bytes.</span>
<span style="font-size:18px"><strong>sizeof(gfgc) = 32 =&gt; It is not 4 because of 
the reason listed </strong><strong><a href="https://stackoverflow.com/questions/3770781/why-is-sizeofstring-32" target="_blank">here</a>.</strong></span>
<span style="font-size:18px">sizeof(c) = 1 as it is just a character.</span>
</pre>

<p><span style="font-size:18px"><strong>User Task: </strong><br>
Your task is to complete the provided function . </span></p>

<p><span style="font-size:18px"><strong>Constraints:</strong><br>
1 &lt;= a, b, c &lt;= 10<sup>6</sup><br>
1 &lt;= l &lt;= 10<sup>18</sup></span></p>
 <p></p>
            </div>