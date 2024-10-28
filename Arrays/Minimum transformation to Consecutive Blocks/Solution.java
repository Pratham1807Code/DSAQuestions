public class Solution {
  public int minTransforms(String blocks, int k) {
      int n = blocks.length();
      int zero = 0;
      int one = 0;
  
      for (int i=0; i<k; i++) {
          if (blocks.charAt(i) == '0') {
              zero++;
          } else {
              one++;
          }
      }
  
      int min_0 = zero;
  
      for (int i=0; i<n-k; i++) {
          if (blocks.charAt(i) == '0') {
              zero--;
          } else {
              one--;
          }
          if (blocks.charAt(i+k) == '0') {
              zero++;
          } else {
              one++;
          }
          min_0 = Math.min(min_0, zero);
      }
  
      return min_0;
  }
}
