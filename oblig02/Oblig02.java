


import java.util.*;


public class Oblig02 {

    
    public static void main(String[] args) throws Exception {
       
        String fil=args[0];
       FileManger fm=new FileManger(fil);
       ProjectManger pm=new ProjectManger();
      
        fm.runCycle();
        if(fm.myListSize()){
            pm.calcTime();
            pm.calcSlack();
            pm.printAboutTask();
        }
        else{
	     fm.runCycle();
             
        }
        
    
   
       
    }
    
}
