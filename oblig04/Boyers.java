


import java.util.*;


public class Boyers {
    int[] badshift=new int[256];
    LinkedList<Integer> wildCards=new LinkedList<>();
      
    char pointer='_';
   
   
    public void badshiftMaker(char[]needle,char[]haystack){
         int last=needle.length-1;
         for(int i=0;i<badshift.length;i++){
             badshift[i]=needle.length;
         }
         for(int i=0;i<last;i++){
             badshift[ needle[i]]=last - i;
             //System.out.println(badshift[i]);
                     
         }
         if(getCounter(needle)> 0){
         String n="";
         for(int i=0;i<needle.length;i++){
              n+=needle[i];
              //System.out.println(n);
         }
         for(int i=0;i<badshift.length;i++){
             if(n.contains('_' + ""))
               badshift[i]=Math.max(n.indexOf('_'), 1);
              else
                 badshift[i]=n.length();
             
         }
         }
    }
   public int getCounter(char[] needle){
        int counter=0;
        for(char c:needle){
            if(c== pointer)
                counter++;
        }
        return counter;
   }
   public void findMatch(char[] needle,char[] haystack){
       int maxofseet=haystack.length - needle.length;
        int offset=0; int scan=0; int last=needle.length-1;
        while (offset <= maxofseet){
            
             for(scan=last;needle[scan]==haystack[scan+offset];scan--){
                    if(scan== 0){
                        wildCards.add(offset);
                        break;
             }
                
            }
              offset+=badshift[haystack[offset + last]];   
        }
   }
    public void findWildChar(char[] needle,char[] haystack){
        int maxofseet=haystack.length - needle.length;
        int offset=0; int scan=0; int last=needle.length-1;
        while (offset <= maxofseet){
           
             for(scan=last;needle[scan]==haystack[scan+offset] || needle[scan]==pointer;scan--){
                    if(scan== 0){
                        wildCards.add(offset);
                        break;
             }
                
            }
              offset+=badshift[haystack[offset + last]];   
        }
           
        }
   
    public boolean checkInfo(String needle,String haystack){
         if(needle.length() == 0 || haystack.length() == 0){
             System.out.println("either the needle or the haystack is empty");
             return false;
         }
         if(needle.length() > haystack.length()){
             System.out.println("the needle is larger than the hay stack EXITING");
             return false;
         }
        
         else
             return true;
         
    }
     
    
    public LinkedList<Integer> linked(){
              return wildCards;
          }
    }

