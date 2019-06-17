


import java.util.Scanner;
import java.io.File;

public class YosephogOblig01 {

    
    public static void main(String[] args){
      
            BinaryTree bt=new BinaryTree();
           
            String fil="dictionary.txt";
            try {
                 Scanner in=new Scanner(new File(fil));
            while(in.hasNext()){
            bt.insert(in.next());
            }
            in.close();
            }
            catch(Exception ex){
               System.out.println("ERROR No file found exiting the programm");
               System.out.println(ex);
               System.exit(0);
            }
           
           
            
            
            Scanner input=new Scanner(System.in);
            System.out.println("enter word to search or q to exit");
            String word=input.nextLine().toLowerCase();
            
            while(!word.equalsIgnoreCase("q")){
                 if(bt.find(word)!=null)
                     System.out.println("the word is found");
                 else{
                   
                   bt.similarWord(word);
                 }
                 
                 System.out.println("enter word to search or q to exit");
                 word=input.nextLine().toLowerCase();
            }
            // this indented part is used for the utskrift.txt
            /**
            String word1=bt.find("achiev");
            String word2=bt.find("achiese");
            String word3=bt.find("achievee");
            String word4=bt.find("ahcieve");
            
            if(word1==null)
                bt.similarWord("achiev");
            if(word2==null)
                bt.similarWord("achiese");
            if(word3==null)
                bt.similarWord("achievee");
            if(word4==null)
                bt.similarWord("ahcieve");
            **/
            int dept=bt.getDepth(bt.root) - 1;
            System.out.println("the depth is " + dept);
            
           
            bt.firstAndLast();
           
            System.out.println("the time ellapsed in Millis is  " + bt.getTimeEllapsed());
            bt.printNodesPerLevelAndAverage();
            
      
            
          
   }
   
    
    }
    
    
  
      
    
    

