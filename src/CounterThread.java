
public class CounterThread implements Runnable{
    private final Thread thread;
    private final String folder;
    private final Seacher secher;
    private boolean writeInConsole;
    
    public CounterThread(String folder){
        thread = new Thread(this);
        secher = new Seacher();
        this.folder = folder;
        thread.start();
    }
    
    @Override
    public void run() {
        secher.search(folder);
        ConsolResult.result(secher, folder);
        writeInConsole = true;
    }

    public Thread getThread() {
        return thread;
    }

    public String getFolder() {
        return folder;
    }

    public Seacher getSecher() {
        return secher;
    }

    public boolean isWriteInConsole() {
        return writeInConsole;
    }
    
}
