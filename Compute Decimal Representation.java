/*You are given a positive integer n.

A positive integer is a base-10 component if it is the product of a single digit from 1 to 9 and a non-negative power of 10. For example, 500, 30, and 7 are base-10 components, while 537, 102, and 11 are not.

Express n as a sum of only base-10 components, using the fewest base-10 components possible.

Return an array containing these base-10 components in descending order.

 

Example 1:

Input: n = 537

Output: [500,30,7]

Explanation:

We can express 537 as 500 + 30 + 7. It is impossible to express 537 as a sum using fewer than 3 base-10 components.*/

class Solution {
    public int[] decimalRepresentation(int n) {
        List<Integer> list=new ArrayList<>();
        int place=1;
        while(n>0){
            int num=n%10;
            if(num!=0){
                list.add(num*place);
            }
            n=n/10;
            place*=10;
        }

        Collections.sort(list,Collections.reverseOrder());
        int[] res=new int[list.size()];
        for(int i =0;i<list.size();i++){
            res[i]=list.get(i);
        }
        return res;
    }
}
