class Solution {
    Map<String, PriorityQueue<String>> flights = new HashMap<>();
    LinkedList<String> res = new LinkedList<>();
    public List<String> findItinerary(List<List<String>> tickets) {
        for(List<String> l : tickets) {
            flights.putIfAbsent(l.get(0), new PriorityQueue<>());
            flights.get(l.get(0)).add(l.get(1));
        }
        DFS("JFK");
        return res;
    }
    public void DFS(String str) {
        PriorityQueue pq = flights.get(str);
        while(pq != null && pq.size() != 0) {
            DFS(String.valueOf(pq.poll()));
        }
        res.addFirst(str);
    }
}