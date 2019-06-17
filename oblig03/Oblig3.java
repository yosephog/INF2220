





public class Oblig3 {

    
    public static void main(String[] args) {
        
       Myradix rd=new Myradix();
       
       int[]temp=rd.makeRandomArray(100);
       
       System.out.println("the time for array of length " + temp.length);
       System.out.println("radix time " + rd.Vradix(temp));
       System.out.println("Arrays.sort time " + rd.arraySort(temp));
       
       System.out.println("=========================================");
         temp=rd.makeRandomArray(1000);
       System.out.println("the time for array of length " + temp.length);
       System.out.println("radix time " + rd.Vradix(temp));
       System.out.println("Arrays.sort time " + rd.arraySort(temp));
      
       
       System.out.println("=========================================");
          temp=rd.makeRandomArray(10000);     
       System.out.println("the time for array of length " + temp.length);
       System.out.println("radix time " + rd.Vradix(temp));
       System.out.println("Arrays.sort time " + rd.arraySort(temp));
       
       System.out.println("=========================================");
       temp=rd.makeRandomArray(100000);
       System.out.println("the time for array of length " + temp.length);
       System.out.println("radix time " + rd.Vradix(temp));
       System.out.println("Arrays.sort time " + rd.arraySort(temp));
       
       System.out.println("=========================================");
       temp=rd.makeRandomArray(1000000);
       System.out.println("the time for array of length " + temp.length);
       System.out.println("radix time " + rd.Vradix(temp));
       System.out.println("Arrays.sort time " + rd.arraySort(temp));
       
       System.out.println("=========================================");
       temp=rd.makeRandomArray(10000000);
       System.out.println("the time for array of length " + temp.length);
       System.out.println("radix time " + rd.Vradix(temp));
       System.out.println("Arrays.sort time " + rd.arraySort(temp));
       
       System.out.println("=========================================");
       
      
    }
    
}
