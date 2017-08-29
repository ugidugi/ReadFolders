
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class WriteResults {
    private BufferedWriter fileWriter = null;
    public void writeResults( String folder,int quantity) {
        try {
            fileWriter.write(folder+";");
            fileWriter.write(quantity+";");
            fileWriter.write("\n");
        } catch (IOException ex) {
            System.out.println("Write error!");
        }
    }
    
    public void setFileWriter(String resultFilePath){
        try {
            fileWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(resultFilePath), "UTF-8"));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(WriteResults.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(WriteResults.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public BufferedWriter getFileWriter() {
        return fileWriter;
    }
    
    
}
