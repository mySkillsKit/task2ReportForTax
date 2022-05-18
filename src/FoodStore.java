import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class FoodStore {

    private int size;
    private int minBill;
    private int maxBill;

    public FoodStore(int size, int minBill, int maxBill) {
        this.size = size;
        this.minBill = minBill;
        this.maxBill = maxBill;
    }

    public List<Integer> arrayBill() {
        List<Integer> intList = new Random().ints(size, minBill, maxBill)
                .boxed()
                .collect(Collectors.toList());
        return intList;
    }
}
