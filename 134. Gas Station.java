class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
		int index = -1;
		int gasRemain = 0;
        //如果找不到起点，那就返回-1
		for(int i = 0; i < cost.length; i++) {
			if(gas[i] + gasRemain < cost[i]) {
				index = -1;
                gasRemain = 0;
				continue;
			}
			else {
				if(index == -1) index = i;
				gasRemain += gas[i] - cost[i];
			}
		}
		if(index == -1) return -1;
        
        //如果找到了起点，因为经过了上面的for循环，已经到达了最后的一个点
        //也知道了gasRemain，所以只要从0到起始点能满足，最终就能满足
		else {
			for(int i = 0; i < index; i++) {
				if(gas[i] + gasRemain < cost[i]) return -1;
				else {
					gasRemain += gas[i] - cost[i];
				}
			}
			return index;
		}        
    }
}