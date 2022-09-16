package test;

import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.FutureTask;

import static java.lang.Thread.sleep;

public class TestThread {
    static CountDownLatch  latch = new CountDownLatch(2);
    static class mythreada implements Callable{

        @Override
        public Object call() throws Exception {

            sleep(10 * 1000);
            latch.countDown();
            return 1;
        }
    }
    static class mythreadb implements Callable{

        @Override
        public Object call() throws Exception {

            sleep(7 * 1000);

            latch.countDown();

            return 2;
        }
    }
    static class mythreadc implements Callable{
        int a;
        int b;
        mythreadc(int a, int b){
            this.a = a;
            this.b = b;
        }
        @Override
        public Object call() throws Exception {
            latch.await();

            return a + b;
        }
    }
    public static int solution(int a, int b){

        int resulta = 0;
        int resultb = 0;
        int resultc = 0;

        FutureTask futureTask = new FutureTask<>(new mythreada());
        Thread thread = new Thread(futureTask);
        thread.start();


        FutureTask futureTaskb = new FutureTask<>(new mythreadb());
        Thread threadb = new Thread(futureTaskb);
        threadb.start();
        try {
             resulta =  (int)futureTask.get();
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
             resultb =  (int)futureTaskb.get();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("1111");
        FutureTask futureTaskc = new FutureTask<>(new mythreadc(resulta,resultb));
        Thread threadc = new Thread(futureTaskc);
        threadc.start();
        try {
             resultc =  (int)futureTaskc.get();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return resultc;
    }


    public static void main(String[] args) {
        int solution = solution(1, 2);
        System.out.println(solution);

    }
}
