有 n&nbsp;个活动即将举办，每个活动都有开始时间与活动的结束时间，第 i&nbsp;个活动的开始时间是 start<sub>i</sub> ,第 i&nbsp;个活动的结束时间是 end<sub>i</sub> ,举办某个活动就需要为该活动准备一个活动主持人。<br />
<br />
一位活动主持人在同一时间只能参与一个活动。并且活动主持人需要全程参与活动，换句话说，一个主持人参与了第 i&nbsp;个活动，那么该主持人在 (start<sub>i</sub>,end<sub>i</sub>)&nbsp;这个时间段不能参与其他任何活动。求为了成功举办这 n&nbsp;个活动，最少需要多少名主持人。<br />
<br />
数据范围: <img src="https://www.nowcoder.com/equation?tex=1%20%5Cle%20n%20%5Cle%2010%5E5" /> ， <img src="https://www.nowcoder.com/equation?tex=-2%5E%7B32%7D%20%5Cle%20start_i%5Cle%20end_i%20%5Cle%202%5E%7B31%7D-1" alt="-2^{32} \le start_i\le end_i \le 2^{31}-1" /><br />
<div>
	<br />
</div>
<div>
	复杂度要求：时间复杂度 <img src="https://www.nowcoder.com/equation?tex=O(n%20%5Clog%20n)" /> ，空间复杂度 <img src="https://www.nowcoder.com/equation?tex=O(n)" /> 
</div><div><br></div><div><div>Related Topics</div><div><li>贪心</li></div></div><br>示例:<br>输入:2,[[1,2],[2,3]]<br>输出:1
<br>