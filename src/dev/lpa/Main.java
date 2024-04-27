package dev.lpa;

public class Main {
    public static void main(String[] args) {

        Thread threadWConstructorEven = new Thread(() ->{
           for (int i=2; i<=10; i+=2){
               try {
                   Thread.sleep(250);
               } catch (InterruptedException e) {
                   System.out.println("Thread interrupted, exiting gracefully");
               }
               System.out.println(i);
           }
        });


        Thread threadWRunnableOdds = new Thread(new myRunnable());

        threadWRunnableOdds.start();
        threadWConstructorEven.start();

        try {
            Thread.sleep(250);  // Corrected line: use sleep instead of wait
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        threadWRunnableOdds.interrupt();

    }

    private static class myRunnable extends Thread{

        @Override
        public void run() {
            for (int i=1; i<=9; i+=2){
                try {
                    Thread.sleep(250);
                } catch (InterruptedException e) {
                    System.out.println("Thread interrupted, exiting gracefully");
                    return;
                }
                System.out.println(i);
            }
        }
    }
}