package at.ac.fhcampuswien.threads.synchronisation;

public class TableSynchronized extends Table {
    /***
     *
     * Synchronized Method example
     *
     * **/
    synchronized void printTable(int n, String threadname) {
        for(int i = 1; i <= 5; i++) {
            System.out.println(threadname + " " + n * i);
            try {
                Thread.sleep(400);  // causes the current thread to halt for 0.4 sec
            } catch(InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    /***
     *
     * Synchronized block example
     *
     * **/
    /*
    void printTable(int n, String threadname) {
        System.out.println("printTable called by " + threadname);
        synchronized(this){
            System.out.println(threadname + " inside synchronized block.");
            for(int i = 1; i <= 5; i++) {
                System.out.println(threadname + " " + n * i);
                try {
                    Thread.sleep(400);  // causes the current thread to halt for 0.4 sec
                } catch(InterruptedException e) {
                    System.out.println(e);
                }
            }
        }
        System.out.println(threadname + " after synchronized block");
    }
    */
}
