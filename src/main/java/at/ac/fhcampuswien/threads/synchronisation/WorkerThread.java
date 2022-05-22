package at.ac.fhcampuswien.threads.synchronisation;

public class WorkerThread implements Runnable {
    private int index;

    public WorkerThread(int index){
        this.index = index;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " Start. Index = " + index);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " End.");
    }
}
