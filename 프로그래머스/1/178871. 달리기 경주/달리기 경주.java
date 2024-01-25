import java.util.*;


class Solution {
    public String[] solution(String[] players, String[] callings) {
        Map<String, Integer> name_rank = new HashMap<>();

        for (int i = 0; i < players.length; ++i){
            String name = players[i];
            name_rank.put(name, i);
        }
        
        for (String name : callings){
            int rank = name_rank.get(name);
            name_rank.put(name, rank - 1);
            name_rank.put(players[rank - 1], rank);
            players[rank] = players[rank - 1];
            players[rank - 1] = name;
        }
        return players;
    }
}