class Solution {
    public int maxEnvelopes(int[][] envelopes) {
       Arrays.sort(envelopes,(a,b)->{
        if(a[0] != b[0])return a[0] - b[0];
         return b[1] - a[1];
       });
       int n = envelopes.length;
       int[] height = new int[n];
       for(int i = 0; i < n; i++){
         height[i] = envelopes[i][1];
        }
        int[] lis = new int[n];
        int size = 0;

        for(int i = 0; i < n; i++){

            int left = 0;
            int right = size;

            while(left < right){
                int mid = left + (right - left) / 2;

                if(lis[mid] >= height[i]){
                    right = mid;
                }else{
                    left = mid + 1;
                }
            }
             lis[left] = height[i];
             if(left == size){
                size++;
            }
        }
        return size;
       }
    }
