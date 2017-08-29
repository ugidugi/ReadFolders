


public class ConsolResult {    
    private static int queue = 0;
    
    public static synchronized void result(Seacher seacher,String folder){
        queue++;
        System.out.println(queue + "\t" + folder + "\t" + seacher.getQuantity());
    }
}
