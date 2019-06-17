


import java.util.Arrays;
import java.util.Random;


public class Myradix {
    final static int NUM_BIT=7;
    
    public double Vradix(int[] a){
           long tt = System.nanoTime();
           
         int[] b=new int[a.length];
         int maxNumber=getMax(a);
         int maxNumberBit=getBit(maxNumber); 
         int left=0;
         int right=a.length;
         int leftsort=maxNumberBit; 
         int shift=leftsort;
         
         radix(a,b,left,right,shift,Math.min(NUM_BIT, shift));
         double tid = (System.nanoTime() -tt)/1000000.0;
         testSort(a);
         
         return tid;
         
    }
    public void radix(int[]a,int[] b,int left,int right,int leftsort,int maskLen){
         int shift=leftsort -maskLen;
         int mask = (1<<maskLen) - 1; 
        int[] count=new int[mask+1];
       
        int acumVal=left,j=0;
        for(int i=left;i<right;i++){
            count[(a[i]>>shift) & mask]++;
        }
       
        for(int i=0;i<=mask;i++){
             j = count[i];
            count[i] = acumVal;
            acumVal += j;
        }
       
       
      
       for (int i = left; i < right; i++){
        b[count[(a[i]>>shift) & mask]++] = a[i];
      
    }
      
       
    for(int i=left;i<right;i++)
        a[i]=b[i];
   
     int newRight=0;
     int newLeft=left;
     
     for(int i=0;i<count.length; i++){
         
          newRight=count[i];
          if(newRight-newLeft <= maskLen){
              
               insertSort(a,newLeft,newRight);
           }
          
          if(shift <= 0 ) return;
          
          else{
            
      
            radix(a,b,newLeft,newRight,shift,Math.min(NUM_BIT, shift));
             
            newLeft=newRight;
          }
      }
   
    }
    
    public  void insertSort(int[]a,int left,int right){
       int i,t;
       int maks=right-1;
      
       
       for(int k=left;k<maks;k++){
           if(a[k]>a[k+1]){
               t=a[k+1];
               i=k;
           
           do{
               a[i+1]=a[i];
               i--;
           }while(i>= 0 && a[i]> t);
           a[i+1]=t;
       }
       }
      
      
   }
    /** 
     * this method sorts the array using Array.sort
     * and calculates the time taken and returns it.
     **/
    
    public double arraySort(int[] a){
         long tt = System.nanoTime();
           Arrays.sort(a);
          double tid = (System.nanoTime() -tt)/1000000.0;
          
          return tid;
    }
    /** 
     * returns the maximum number of a giver array
     **/
    public int getMax(int[] num){
        int max=0;
        for(int i:num){
            if(i > max) 
                max=i;
        }
        return max;
    }
    /** 
     * returns the number of bits of a given number.
     * 
     **/
    public int getBit(int num){
        int i=0;
        while(num>>i != 0)
            i++;
        return i;
    }
    /** 
     * makes a random array of given length
     * and returns the array
     **/
     public int[] makeRandomArray(int length){
         Random rd=new Random();
         int[] temp=new int[length];
         
         for(int i=0;i<temp.length;i++){
             temp[i]=rd.nextInt(length);
         }
         return temp;
     }
      public void testSort(int [] a){
        
        for (int i = 0; i< a.length-1;i++) {
        if (a[i] > a[i+1]){
        System.out.println("SorteringsFEIL på: "+
        i +" a["+i+"]:"+a[i]+" > a["+(i+1)+"]:"+a[i+1]);
        return;
}
}
         
}
      
}
