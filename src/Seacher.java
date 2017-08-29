
import java.io.File;


public class Seacher {
    private int quantity = 0;
    
    public void search(String folder){
        try{
            File file = new File(folder);
            File[] listFiles = file.listFiles();
            for(int i = 0; i < listFiles.length; i++){
                if(listFiles[i].isFile()){
                    quantity++;
                }
                if(listFiles[i].isDirectory()){
                    search(listFiles[i].getAbsolutePath());
                }
            }
        }catch(NullPointerException e2){
            System.out.println("No access to " + folder);
        }
    }

    public int getQuantity() {
        return quantity;
    }
    
}
