package com.Darian.springcloudhystrixclientdemo;



import java.util.Random;
import java.util.concurrent.*;

/**
 * <br>
 * <br>Darian
 **/
public class FutureDemo {

    public static void main(String[] args)  {
        Random random = new Random();

        ExecutorService service = Executors.newFixedThreadPool(1);

        Future<String> future = service.submit(() -> {
            // 如果随机事件大于 100， 那么触发容错
            int value = random.nextInt(200);
            Thread.sleep(value);
            System.out.println("Hello world() costs " + value + "ms.");


            return "hello world.";
        });

        try {
            future.get(100,TimeUnit.MILLISECONDS);
        } catch (Exception e) {
           // 超时流程
            System.out.println("超时保护！");
            return ;
        }

        service.shutdown();

    }
}
