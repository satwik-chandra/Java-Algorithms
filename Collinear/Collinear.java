// -------------------------------------------------------------------------
/**
 *  This class contains only two static methods that search for points on the
 *  same line in three arrays of integers. 
 *
 *  @author  
 *  @version 18/09/18 12:21:09
 */
class Collinear
{

   // ----------------------------------------------------------
    /**
     * Counts for the number of non-hoizontal lines that go through 3 points in arrays a1, a2, a3.
     * This method is static, thus it can be called as Collinear.countCollinear(a1,a2,a3)
     * @param a1: An UNSORTED array of integers. Each integer a1[i] represents the point (a1[i], 1) on the plain.
     * @param a2: An UNSORTED array of integers. Each integer a2[i] represents the point (a2[i], 2) on the plain.
     * @param a3: An UNSORTED array of integers. Each integer a3[i] represents the point (a3[i], 3) on the plain.
     * @return the number of points which are collinear and do not lie on a horizontal line.
     *
     * Array a1, a2 and a3 contain points on the horizontal line y=1, y=2 and y=3, respectively.
     * A non-horizontal line will have to cross all three of these lines. Thus
     * we are looking for 3 points, each in a1, a2, a3 which lie on the same
     * line.
     *
     * Three points (x1, y1), (x2, y2), (x3, y3) are collinear (i.e., they are on the same line) if
     * 
     * x1(y2âˆ’y3)+x2(y3âˆ’y1)+x3(y1âˆ’y2)=0 
     *
     * In our case y1=1, y2=2, y3=3.
     *
     * You should implement this using a BRUTE FORCE approach (check all possible combinations of numbers from a1, a2, a3)
     *
     * ----------------------------------------------------------
     *
     * 
     *  Order of Growth
     *  -------------------------
     *
     *  Caclulate and write down the order of growth of your algorithm. You can use the asymptotic notation.
     *  You should adequately explain your answer. Answers without adequate explanation will not be counted.
     *
     *  Order of growth: N^3
     *
     *  Explanation: Since there are three 'for' loops so therefore the order of growth is Cubic
     */
    static int countCollinear(int[] a1, int[] a2, int[] a3)
    { int x1,x2,x3;
      int count=0;
      int indexA1;
      int indexA2;
      int indexA3;
      int y1=1;
      int y2=2;
      int y3=3;
      for( indexA1 = 0; indexA1<a1.length; indexA1++ ) {
    	  x1 = a1[indexA1];
    	  for(indexA2 = 0; indexA2 < a2.length; indexA2++ ) {
    		  x2 = a2[indexA2];
    		  for(indexA3 = 0; indexA3 < a3.length; indexA3++) {
    			  x3 = a3[indexA3];
    			 
    			  float checkCollinear = (x1*(y2-y3)) + (x2*(y3-y1)) + (x3*(y1-y2));
    			  if(checkCollinear == 0) count++;
    		}
    	  }
      }
    return count;
    }

    // ----------------------------------------------------------
    /**
     * Counts for the number of non-hoizontal lines that go through 3 points in arrays a1, a2, a3.
     * This method is static, thus it can be called as Collinear.countCollinearFast(a1,a2,a3)
     * @param a1: An UNSORTED array of integers. Each integer a1[i] represents the point (a1[i], 1) on the plain.
     * @param a2: An UNSORTED array of integers. Each integer a2[i] represents the point (a2[i], 2) on the plain.
     * @param a3: An UNSORTED array of integers. Each integer a3[i] represents the point (a3[i], 3) on the plain.
     * @return the number of points which are collinear and do not lie on a horizontal line.
     *
     * In this implementation you should make non-trivial use of InsertionSort and Binary Search.
     * The performance of this method should be much better than that of the above method.
     *
     *
     *  Order of Growth
     *  -------------------------
     *
     *  Caclulate and write down the order of growth of your algorithm. You can use the asymptotic notation.
     *  You should adequately explain your answer. Answers without adequate explanation will not be counted.
     *
     *  Order of Growth: Θ(N^2)
     *
     *  Explanation: the order of growth of: the two 'for' loops = Θ(N^2), BinarySearch = Θ(1 + log(N)), Insertion Sort = O(N^2), FINAL order of growth = Θ(N^2)
     *
     *
     */
    static int countCollinearFast(int[] a1, int[] a2, int[] a3)
    {
    	int x1,x2;
        float x3;
    	int y1=1;
        int y2=2;
        int y3=3;
        int count=0;
        for(  int indexA1 = 0; indexA1<a1.length; indexA1++ ) {
      	  x1 = a1[indexA1];
      	  for(int indexA2 = 0; indexA2 < a2.length; indexA2++ ) {
      		  x2 = a2[indexA2];
      		  for(int indexA3 = 0; indexA3 < a3.length; indexA3++) {
      			  if(x2==x1) break;
      			  float slope = (y2-y1)/(x2-x1);
      			  int c = y1 - ((int) slope*x1);
      			  x3 = (y1-c)/((int) slope);
      			  sort(a3);
      			  if(binarySearch(a3,(int) x3)==true) count++;
      		}
      	  }
        }
      return count;
    }

    // ----------------------------------------------------------
    /**
     * Sorts an array of integers according to InsertionSort.
     * This method is static, thus it can be called as Collinear.sort(a)
     * @param a: An UNSORTED array of integers. 
     * @return after the method returns, the array must be in ascending sorted order.
     *
     * ----------------------------------------------------------
     *
     *  Order of Growth
     *  -------------------------
     *
     *  Caclulate and write down the order of growth of your algorithm. You can use the asymptotic notation.
     *  You should adequately explain your answer. Answers without adequate explanation will not be counted.
     *
     *  Order of Growth: N^2
     *
     *  Explanation: Two linear for-loops.
     *
     */
    static void sort(int[] a)
    {
      for ( int j = 1; j<a.length; j++)
      {
        int i = j - 1;
        while(i>=0 && a[i]>a[i+1])
        {
          int temp = a[i];
          a[i] = a[i+1];
          a[i+1] = temp;
          i--;
        }
      }
    }

    // ----------------------------------------------------------
    /**
     * Searches for an integer inside an array of integers.
     * This method is static, thus it can be called as Collinear.binarySearch(a,x)
     * @param a: A array of integers SORTED in ascending order.
     * @param x: An integer.
     * @return true if 'x' is contained in 'a'; false otherwise.
     *
     * ----------------------------------------------------------
     *
     *  Order of Growth
     *  -------------------------
     *
     *  Caclulate and write down the order of growth of your algorithm. You can use the asymptotic notation.
     *  You should adequately explain your answer. Answers without adequate explanation will not be counted.
     *
     *  Order of Growth: Θ(log(N))
     *
     *  Explanation: the loop will be executed log(N) times, and everything inside the loop will execute once with order of Growth Θ(1), (log(N)) * Θ(1) = Θ(log(N))
     *
     */
    static boolean binarySearch(int[] a, int x)
    {
    	int lo = 0, hi = a.length-1;
    	 while (lo <= hi)
    	 {
    	 int mid = lo + (hi - lo) / 2;
    	 if (x < a[mid]) hi = mid - 1;
    	 else if (x > a[mid]) lo = mid + 1;
    	 else return true;
    	 }
    	 return false;
    }

}
