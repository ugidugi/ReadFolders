

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class ReadFile {
    
    private ArrayList<String> pathList;
    private BufferedReader read;
    private String line;

    public ArrayList<String> getPathList(String optionalFilePath) {
        
        try{
            File file = new File(optionalFilePath);
            read = new BufferedReader(new FileReader(file));
            List list = new ArrayList<>();
            
            while( (line = read.readLine() )!= null){
                list.add(line);
            }
            
            pathList = new ArrayList<>(list);
        }catch(FileNotFoundException e1){
            System.out.println("Optional file not found!");
        }catch(IOException e2){
            System.out.println("Error read list file!");
        }
        
        return pathList;
    }
    
    
}
