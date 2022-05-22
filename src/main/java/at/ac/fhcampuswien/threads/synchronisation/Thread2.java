package at.ac.fhcampuswien.threads.synchronisation;

public class Thread2 implements Runnable{
    Table table;
    private final String threadName;
    private Thread thread;

    public Thread2(Table t){
        this.table = t;
        this.threadName = this.getClass().getSimpleName();
    }

    public void run() {
        table.printTable(10, this.threadName);
    }

    public void start () {
        if (this.thread == null) {
            this.thread = new Thread(this, this.threadName);  // we are passing the runnable into a Thread constructor
            this.thread.start();
        }
    }
}