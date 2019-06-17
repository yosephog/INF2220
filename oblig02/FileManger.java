


import java.io.*;
import java.util.*;
/**
 * this class read the file and create's its data
 * stracture and check if it have loop.
 * if it have loop it prints it out.
 * @author yoseph
 */

class FileManger {
    // to hold the taskList to be used in the ProjectManger class
    static Task[] taskList;
    int taskAmount;
    // to hold all the tasks that have zero dependancy
    static ArrayList<Task> zeroDependancy=new ArrayList<>();
   
    // if this list is empty then there is no loop
    ArrayList<Task> mylist=new ArrayList<>();
    public FileManger(String fil){
        
        try(Scanner in = new Scanner(new File(fil))) {
	    taskAmount=in.nextInt();
       
	    taskList=new Task[taskAmount]; 
	    for(int i=1;i<=taskList.length;i++)
		taskList[i-1]=new Task(0," ",0,0);
	    in.nextLine(); // empty line in the file
	    in.nextLine();// empty line in the file
	    int taskId;
	    for(Task t:taskList){
		String tx=in.nextLine();
		// System.out.println(tx);
		if(tx.equals(""))
		    continue;
		String[] val=tx.split("\\s+");
		taskId=Integer.parseInt(val[0]);
          
		t.settTaskId(taskId);
		t.settTaskName(val[1]);
		t.settTime(Integer.parseInt(val[2]));
		t.settTaskManPoser(Integer.parseInt(val[3]));
           
         
            
		for(int i=4;i<val.length;i++){
		    int temp=Integer.parseInt(val[i]);
		    if(temp != 0){
			taskList[taskId-1].addDependancy(taskList[temp-1]);
			taskList[temp-1].addNeighbour(taskList[taskId-1]);
		    }
		}
           
            
           
	    }
	    for (taskId = 0; taskId < taskList.length; taskId++) {
		taskList[taskId].defaultSize();  
			
	    }
        }
        catch(FileNotFoundException | NumberFormatException ex){
            //System.out.println(ex);
            System.out.println(" the file isn't found");
        }
       
    }
    public boolean cycle(Task t){
	/**
	 * three state is needed to found cycle that is 
	 * 0 for not visited
	 * 1 for being visited
	 * 2 for done visited
	 * visited is set to 0 at first
	 **/
	if(t.visited== 1) return true;
     
	if(t.visited == 2){
	    System.out.println("cycle is found and it's path is");
	    printCycle(t);
	    return true;
	}
     
	t.visited=2;
	for(Task ts:t.getNeighbour()){
	    ts.previous=t;
	    if(!cycle(ts))
		return false;
	}
	t.visited=1;
	return true;
    }
    
    public boolean runCycle() {
        for (Task taskList1 : taskList) {
            if (!cycle(taskList1)) {
                return false;
            }
        }
	return true;
    }
 
    // return true if list is empty so there is noLoop
    // going to be used in the mainclass to differncate cycle/Nocylcle
  
    public boolean myListSize(){
	return mylist.isEmpty();
    }	
	
    public void printCycle(Task t){
     
	Task temp = t;
		
	mylist.add(temp);
	t=t.previous;
	while(t != temp){
                    
	    mylist.add(t);
	    t=t.previous;
	}
		
	for(Task ts:mylist) {
			
	    System.out.print(ts.getTaskId()+" ==> ");
	}
	/** am using this line inorder to display the end of the loop
	 * since my while loop won't insert a task that is already
	 * there. in short without this line my loop will be
	 *  1==>6==>3==>2  not 1==>6==3==>2==1 for buildhouse2.txt
	 */
	System.out.print(mylist.get(0).getTaskId());
	System.out.println();
      
     
        
    }
    // returns a list of task with zero dependancies or
    // zero indegree
    public static ArrayList<Task> getZeroIndegree(){
       
	for(int i=0;i<taskList.length;i++){
	    if(taskList[i].getDepenndancy().isEmpty()){
		zeroDependancy.add(taskList[i]);
	    }
	}
	return zeroDependancy;
    }
    // return the taskList to be used in the projectManger class
    public static Task[] getTaskList(){
	return taskList;
    }
}

