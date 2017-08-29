

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;


public class WriteResultThread extends JFrame implements Runnable{
    private final Thread thread;
    private final ArrayList<CounterThread> poolThreads;
    private final String csvFilePath;
    private boolean write;
    
    public WriteResultThread(String csvFilePath){
        this.csvFilePath = csvFilePath;
        poolThreads = new ArrayList<>();
        thread = new Thread(this);
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_ESCAPE){
                    try {
                        write = true;
                        writeResult();
                    } catch (IOException ex) {
                        Logger.getLogger(WriteResultThread.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
         }});
        setVisible(true);
    }
    
    @Override
    public void run() {
        try{
            for(CounterThread counter: poolThreads){
                counter.getThread().join();
            }
            
        }catch(InterruptedException e){
        }finally{
            if(!write){
                try {
                    writeResult();
                } catch (IOException ex) {
                    Logger.getLogger(WriteResultThread.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            System.exit(0);
        }
    }

    public Thread getThread() {
        return thread;
    }

    public ArrayList<CounterThread> getPoolThreads() {
        return poolThreads;
    }

    private void writeResult() throws IOException{
        WriteResults writeResults = new WriteResults();
        writeResults.setFileWriter(csvFilePath);
        for(CounterThread counter: poolThreads){
            if(counter.getThread().isAlive()&&!counter.isWriteInConsole()){
                ConsolResult.result(counter.getSecher(), counter.getFolder());
                counter.getThread().stop();
            }
            writeResults.writeResults( counter.getFolder(), counter.getSecher().getQuantity());
        }
        writeResults.getFileWriter().flush();
    }
}
