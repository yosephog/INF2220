


import java.util.*;


public class Task {
    
    int time,manpower,earlyStart,lateStart,taskId;
    String name;
    ArrayList<Task> dependency;
    ArrayList<Task> neighbor;
    int defSize;
    int started=-1;
    int visited=0;
    int checkLoop=0;
    Task previous=null;
    int isCritical,slack;
    public Task(int taskId,String name,int time,int manpower){
        this.taskId=taskId;
        this.name=name;
        this.time=time;
        this.manpower=manpower;
      dependency=new ArrayList<>();
       neighbor=new ArrayList<>();
       
    }
    // prints out any given taskArrayList and prints
    // out its taskId.
   public void printArray(ArrayList<Task> temp){
       for(Task t:temp)
           System.out.print(t.getTaskId() + " , ");
   }
    public int getSlack(){
        return this.slack;
    }
    public int getCritical(){
        return this.isCritical;
    }
    public void addDependancy(Task t){
        dependency.add(t);
    }
    public void addNeighbour(Task t){
        neighbor.add(t);
    }
    public void settTaskId(int id){
        this.taskId=id;
    }
     public void settTaskName(String id){
        this.name=id;
    }
      public void settTime(int id){
        this.time=id;
    }
       public void settTaskManPoser(int id){
        this.manpower=id;
    }
    public int getTaskId(){
        return this.taskId;
    }
    public String getTaskName(){
        return this.name;
    }
    public int getTime(){
        return this.time;
    }
    public int getManPower(){
        return this.manpower;
    }
    public ArrayList<Task> getDepenndancy(){
        return this.dependency;
    }
    public ArrayList<Task> getNeighbour(){
        return this.neighbor;
    }
    public void setEarlyStart(int early){
        earlyStart=early;
    }
    public void setLateStart(int late){
        this.lateStart=late;
    }
    public int getEarlyStart(){
        return this.earlyStart;
    }
    public int getLateStart(){
        return this.lateStart;
    }
    public void defaultSize(){
        defSize=dependency.size();
    }
   public int stopTime(){
       return time + started;
   }
}
