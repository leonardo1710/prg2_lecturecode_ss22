package at.ac.fhcampuswien.threads.synchronisation;

public class Table {
    // method without synchronization
    void printTable(int n, String threadname) {
        for(int i = 1; i <= 5; i++) {
            System.out.println(threadname + " " + n * i);
            try {
                Thread.sleep(400);  // causes the current thread to halt for 0.4 sec
            } catch(InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
