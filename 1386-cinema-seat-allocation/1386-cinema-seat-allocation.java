class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        Map<Integer,Set<Integer>> map = new HashMap<>();
        for(int[] r : reservedSeats){
            map.putIfAbsent(r[0],new HashSet<>());
            map.get(r[0]).add(r[1]);
        }
        int res = (n - map.size())*2;
        for(Set<Integer> set : map.values()){
            boolean begin = !set.contains(2) &&!set.contains(3)&&!set.contains(4)&&!set.contains(5);
            boolean mid = !set.contains(4) &&!set.contains(5)&&!set.contains(6)&&!set.contains(7);
            boolean last = !set.contains(6) &&!set.contains(7)&&!set.contains(8)&&!set.contains(9);
            if(begin && last){
                res += 2;
            }else if(begin || mid || last){
                res += 1;
            }
        }
        return res;
    }
}