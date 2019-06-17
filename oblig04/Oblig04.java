


import java.util.*;
import java.io.*;



public class Oblig04 {

    public static void main(String[] args) {
        
              Boyers br=new Boyers();
            
              String myhay="";
              String myNeedle="";
              
              String needleFil=args[0];
              String hayFile=args[1];
             
        try {
            Scanner needleScan=new Scanner(new File(needleFil));
            Scanner hayScan=new Scanner(new File(hayFile));
            
           while(needleScan.hasNextLine()){
                myNeedle+=needleScan.nextLine();
            }
            
            while(hayScan.hasNextLine()){
                myhay+=hayScan.nextLine();
                myhay+='\n';
            }
            } 
        catch (FileNotFoundException ex) {
            System.out.println("File not found or wrong file name ");
            System.out.println(ex);
        }
        System.out.println("my hay is " + myhay);
        System.out.println("my needle " + myNeedle);
        
        
       
            if(br.checkInfo(myNeedle,myhay)){
                 char[] ha=myhay.toCharArray();
                 char[]ne=myNeedle.toCharArray();
                 br.badshiftMaker(ne,ha);
                
                 if(br.getCounter(ne)> 0)
                    br.findWildChar(ne, ha);
                 else
                     br.findMatch(ne, ha);
                 LinkedList<Integer> mylist=br.linked();
                 if(mylist.isEmpty()){
                     System.out.println("No similarity is found");
                     System.exit(0);
                 }
                 else{

                     System.out.println("Number of similar found is " + mylist.size());
                      for(Integer i:mylist){
                 System.out.println("At pos " + i + "..." + myhay.substring(i ,i+ myNeedle.length()));
            }
                 }
               
            
            }
            
       }
    
}
