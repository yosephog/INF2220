



import java.util.ArrayList;
public  class StringFinder {
    
    String myalphabet="abcdefghijklmnopqrstuvwxyz";
    
    ArrayList<String>allSimilarWords=new ArrayList<>();
    
   
    public ArrayList<String> allSimilarList(){
        return allSimilarWords;
    }
   
    public void similarOne(String word){
        char [] alph=word.toCharArray();
       
        
       for(int i=0;i<alph.length-1;i++){
             char [] tmp=alph.clone();
            String wo=swapOne(i,i+1,tmp);
            
            allSimilarWords.add(wo);
           }
         
    }
    public void similarTwo(String word){
        char[]myword=word.toCharArray();
        char[] myalph=myalphabet.toCharArray();
        
        
          for(int i=0;i<myword.length;i++){
             for(int j=0;j<myalph.length;j++){
               char[]tmp=myword.clone();
             String wo=swapTwo(i,j,tmp,myalph);
            
             allSimilarWords.add(wo);
             
        }
        }
       
    }
      public  void similarThree(String word){
       
         for (int i=0; i < word.length(); i++){
	String shorter=word.substring(0, i) + word.substring (i+1);
           
            allSimilarWords.add(shorter);
         }
        
    }
     public void similarFour(String word){
         char[] myword=word.toCharArray();
         char[] myalph=myalphabet.toCharArray();
         for(int i=0;i<myword.length;i++){
             for(int j=0;j<myalph.length;j++){
                 char[] temp=myword.clone();
                  allSimilarWords.add(swapFour(i,myalph[j],temp));
             }
         }
     }
     // helping method for the similarTwo method
    private String swapTwo(int a,int b,char[]word1,char[]word2){
        
         word1[a]=word2[b];
         return new String(word1);
    }
    // helping method for the similarOne method
    private String swapOne(int a,int b,char[] word){
      char tmp=word[a];
      word[a]=word[b];
      word[b]=tmp;
      return new String(word);
}
     //helping method for the similarFour method.
    // uses StringBuilder since additional character is added to the char array
   private String swapFour(int i,char insert,char[]word){
       StringBuilder ste=new StringBuilder(new String(word));
       if(i != word.length)
           ste.insert(i, insert);
       else
           ste.append(insert);
       return new String(ste);
   }
    
    
}
