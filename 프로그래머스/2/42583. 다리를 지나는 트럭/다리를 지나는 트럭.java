import java.util.*;


class Truck {
    int w, time;
    public Truck(int w, int time) {
        this.w = w;
        this.time = time;
    }    
}

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int time = 0;
        int idx = 0;  // 현재 올라갈 트럭의 인덱스
        int remainW = weight; // 현재 다리 여유 무게
        LinkedList<Truck> q = new LinkedList<>();
        
        while(idx < truck_weights.length) {
            ++time;
            int w = truck_weights[idx];
            
            if (!q.isEmpty()) {
                Truck truck = q.getFirst();
                if (time == truck.time) {
                    q.removeFirst();
                    remainW += truck.w;
                }
            }
            
            if (remainW >= w) {
                q.add(new Truck(w, time + bridge_length));
                remainW -= w;
                ++idx;
            }
        }
        
        Truck truck = q.getLast();
        time = truck.time;
        return time;
    }
}