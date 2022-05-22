package at.ac.fhcampuswien.threads.synchronisation;

public class Thread1 implements Runnable {
    Table table;
    private final String threadName;
    private Thread thread;

    public Thread1(Table t){
        this.table = t;
        this.threadName = this.getClass().getSimpleName();
    }

    public void run() {
        this.table.printTable(2, this.threadName);
    }

    public void start () {
        if (this.thread == null) {
            this.thread = new Thread(this, this.threadName);  // we are passing the runnable into a Thread constructor
            this.thread.start();
        }
    }
}
