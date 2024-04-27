package dev.lpa;

public class Main {
    public static void main(String[] args) {

        Thread threadWConstructorEven = new Thread(() ->{
           for (int i=2; i<=10; i+=2){
               System.out.println(i);
           }
        });


        Thread threadWRunnableOdds = new Thread(new myRunnable());

        threadWConstructorEven.start();
        threadWRunnableOdds.start();

    }

    private static class myRunnable implements Runnable{

        @Override
        public void run() {
            for (int i=1; i<=9; i+=2){
                System.out.println(i);
            }
        }
    }
}