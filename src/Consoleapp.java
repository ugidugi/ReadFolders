
public class Consoleapp {
    public static void main(String []arg){
        try{
            String[]args={"D:\\console\\list.txt","D:\\console\\result.csv"};
            ReadFile readFile = new ReadFile();
            WriteResultThread poolThreads = new WriteResultThread(args[1]);
            for(String str: readFile.getPathList(args[0])){
            poolThreads.getPoolThreads().add(new CounterThread(str));
            }
            poolThreads.getThread().start();
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Enter arguments");
        }
    }

}
