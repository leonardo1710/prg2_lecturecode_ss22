package at.ac.fhcampuswien.threads;

import at.ac.fhcampuswien.threads.synchronisation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class App {
    public static void main(String[] args){
        //mainThreadExample();

        //showRunnableDemo();
        //showExtendingThreadDemo();

        // run this method multiple times to see results of unsychronized threads
        // order of output is unpredictable
        //showSynchronizedMethodDemo(false);
        // call the synchronized method within 2 threads
        // showSynchronizedMethodDemo(true);

        //threadPoolExample();
        threadPoolFutureExample();



        try {
            threadPoolDynamicTasksFutureExample();
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }

    }

    private static void threadPoolDynamicTasksFutureExample() throws ExecutionException, InterruptedException {
        // Returns the number of processors available to the Java virtual machine
        int numWorkers = Runtime.getRuntime().availableProcessors();
        // Creates a thread pool that reuses a fixed number of threads
        ExecutorService pool = Executors.newFixedThreadPool(numWorkers);

        List<Future<Integer>> futures = new ArrayList<>();  // create a List that holds Future results
        for(int i = 0; i < 5; i++){ // create tasks dynamically
            int idx = i;
            Callable<Integer> task = () -> doWork(idx); // pass the async function as a lambda
            futures.add(pool.submit(task)); // pool.submit returns Future objects -> add all Future objects to array
        }

        List<Integer> results = new ArrayList<>();
        for(Future<Integer> result : futures){
            if(result.get() != null){
                results.add(result.get());
            }
        }

        for(Integer result : results){
            System.out.println("Result: " + result);
        }


        // alternative
        List<Callable<Integer>> callables = new ArrayList<>();
        for(int i = 0; i < 5; i++){ // create tasks dynamically
            int idx = i;
            Callable<Integer> task = () -> doWork(idx); // pass the async function as a lambda
            callables.add(task); // pool.submit returns Future objects -> add all Future objects to array
        }

        List<Future<Integer>> allFutures = pool.invokeAll(callables);
        for(Future<Integer> f : allFutures){
            Integer result = f.get();
            System.out.println("Result: " + result);
        }

        pool.shutdown();
    }

    private static Integer doWork(int index) {
        try{
            Thread.sleep(8000);
            return index;
        } catch (InterruptedException e){
            e.printStackTrace();
            return 0;
        }
    }

    private static void threadPoolFutureExample() {
        ExecutorService pool = Executors.newFixedThreadPool(3);

        /** ExecutorService.submit(Callable)
         * Submits a value-returning task for execution and returns a
         * Future representing the pending results of the task **/
        Future<Integer> future1 = pool.submit(() -> { Thread.sleep(4000); return 1; });

        Future<String> future2 = pool.submit(() -> {
            // return Hello after 8 seconds
            Thread.sleep(8000);
            return "Hello";
        });

        while(!future2.isDone() || !future1.isDone()) {  // Returns {@code true} if this task completed.
            System.out.println("Waiting for results...");
            try {
                Thread.sleep(1000); // check if results ready every second
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        try { // get the results
            Integer result1 = future1.get();
            String result2 = future2.get();
            System.out.println(result1 + " " + result2);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } finally {
            pool.shutdown();
        }
    }

    private static void threadPoolExample() {
        /**
         * Create the Thread Pool
         **/
        // Returns the number of processors available to the Java virtual machine
        int numWorkers = Runtime.getRuntime().availableProcessors();

        // Uncomment next line to test what happens if you have less than 10 threads in the pool
        //numWorkers = 5;

        // Creates a thread pool that reuses a fixed number of threads
        ExecutorService pool = Executors.newFixedThreadPool(numWorkers);

        // Pass 10 tasks to the pool
        for(int i = 0; i < 10; i++){
            Runnable worker = new WorkerThread(i);  // create a task
            pool.execute(worker);   // pass task to ThreadPool
        }

        pool.shutdown();    // stop accepting new tasks and finish all ongoing executions

        while (!pool.isTerminated()) { }    // just wait

        System.out.println("Finished all threads");
    }

    private static void showSynchronizedMethodDemo(boolean withSynchronisation) {
        // Create an object of class Table.
        Table obj = new Table();

        if(withSynchronisation){
            obj = new TableSynchronized();
        }

        Thread1 t1 = new Thread1(obj);  // pass the same shared resource Table to both threads
        Thread2 t2 = new Thread2(obj);
        t1.start();
        t2.start();
    }

    private static void showExtendingThreadDemo() {
        ThreadClassDemo t1 = new ThreadClassDemo( "Thread 1");
        t1.start();

        ThreadClassDemo t2 = new ThreadClassDemo( "Thread 2");
        t2.start();
    }

    private static void showRunnableDemo() {
        RunnableDemo R1 = new RunnableDemo( "Thread 1");
        R1.start();

        RunnableDemo R2 = new RunnableDemo( "Thread 2");
        R2.start();
    }

    private static void mainThreadExample(){
        // The method Thread.currentThread returns the reference of main thread
        // because this is called inside the main thread (there is always 1 main thread).
        Thread thread = Thread.currentThread();

        System.out.println("Current thread is " + thread);
        System.out.println("Name of current thread is " + thread.getName());

        thread.setName("My custom thread name");
        System.out.println("New thread name is " + thread.getName());
    }
}
