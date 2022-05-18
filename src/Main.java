import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.LongAdder;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        FoodStore store1 = new FoodStore(20_133, 1, 120);
        FoodStore store2 = new FoodStore(2_326, 1, 60);
        FoodStore store3 = new FoodStore(30_310, 2, 45);

     /*   System.out.println(store1.arrayBill());
        System.out.println(store2.arrayBill());
        System.out.println(store3.arrayBill());*/

        ExecutorService executorService =
                Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        LongAdder dailyIncome = new LongAdder();

        store1.arrayBill()
                .forEach(i -> executorService.submit(() -> dailyIncome.add(i)));
        store2.arrayBill()
                .forEach(i -> executorService.submit(() -> dailyIncome.add(i)));
        store3.arrayBill()
                .forEach(i -> executorService.submit(() -> dailyIncome.add(i)));

        executorService.awaitTermination(2, TimeUnit.SECONDS);
        System.out.println("Total daily income for your stores: USD" + dailyIncome.sum());
        executorService.shutdown();

    }
}
