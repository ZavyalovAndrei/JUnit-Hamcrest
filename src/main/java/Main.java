import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        List<Integer> intList = createArray();

        System.out.println("Результат без использования Collection API и Stream API:");
        List<Integer> positiveIntList = evenNumberFilter(positiveNumberFilter(intList));
        positiveIntList.sort(null);
        print(positiveIntList);

        print(StreamMain.streamMain(intList));
    }

    protected static List<Integer> positiveNumberFilter(List<Integer> data) {
        List<Integer> result = new ArrayList<>();
        for (int num : data) {
            if (num > 0) {
                result.add(num);
            }
        }
        return result;
    }

    static List<Integer> evenNumberFilter(List<Integer> data) {
        List<Integer> result = new ArrayList<>();
        for (int num : data) {
            if (num % 2 == 0) {
                result.add(num);
            }
        }
        return result;
    }

    private static void print(List<Integer> data) {
        Iterator<Integer> result = data.iterator();
        while (result.hasNext()) {
            System.out.println(result.next());
        }
    }

    static List<Integer> negativeNumberFilter(List<Integer> data) {
        List<Integer> result = new ArrayList<>();
        for (int num : data) {
            if (num < 0) {
                result.add(num);
            }
        }
        return result;
    }

    private static List<Integer> createArray() {
        List<Integer> list = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        String enter = "да";
        while (!enter.equals("нет")) {
            System.out.println("Введите число для добавления в массив или \"нет\" для завершения.");
            enter = scanner.nextLine();
            if (enter.equals("нет")) {
                break;
            } else {
                list.add(checkNum(enter));
            }
        }
        System.out.println("Введенный массив чисел:");
        print(list);
        return list;
    }

    static int checkNum(String data) {
        int num = 0;
        try {
            num = Integer.parseInt(data);
        } catch (NumberFormatException err) {
            System.out.println("Ошибка ввода!");
        }
        return num;
    }
}
