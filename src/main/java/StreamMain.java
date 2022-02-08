import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StreamMain {
    public static List<Integer> streamMain(List<Integer> list) {
        System.out.println("\nРезультат с использованием стримов из библиотеки Stream API:");
        List<Integer> numList = list.stream()
                .filter(x -> x > 0)
                .filter(x -> x % 2 == 0)
                .sorted(Comparator.naturalOrder())
                .collect(Collectors
                .toCollection(ArrayList::new));
        return numList;
    }
}
