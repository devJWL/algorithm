import java.util.*;

class Solution {
	
	class Info implements Comparable<Info>{
		int pri, index;
		public Info(int pri, int index) {
			this.pri = pri;
			this.index = index;
		}
		
		@Override
		public int compareTo(Solution.Info o) {
			return o.pri - this.pri;
		}
		
		public String toString() {
			return pri + " " + index;
		}

	}
	
    public int solution(int[] priorities, int location) {
        int answer = 0;
        
        PriorityQueue<Info> pq = new PriorityQueue<>();
        Queue<Info> q = new LinkedList<>();
        for (int i = 0; i < priorities.length; ++i) {
        	pq.add(new Info(priorities[i], i));
        	q.add(new Info(priorities[i], i));
        }
        
        while(!q.isEmpty()) {
        	Info data = q.poll();
        	
        	if (data.pri == pq.peek().pri) {
        		{
               		++answer;
            		if (data.index == location) {
            			break;
            		}
            		pq.poll();
        		}
        	}
        	else {
        		q.add(data);
        	}
        }
        return answer;
    }
}