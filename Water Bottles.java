class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int totalDrank = 0;
        int empty = 0;
        
        int full = numBottles;
        while (full > 0) 
            totalDrank += full;
            empty += full;
            full = 0;
            
            if (empty >= numExchange) {
                full = empty / numExchange;
                empty = empty % numExchange;
            }
        }
        
        return totalDrank;
    }
}
