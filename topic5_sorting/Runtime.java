import java.util.List;

public class Runtime {
    public static int run(List<Integer> arr) {

        int count = 0;
        for(int j=0; j< arr.size(); j++) {

            for(int i=j;i<arr.size();i++) {
                if (arr.get(j) > arr.get(i)) {
                    count += 1;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println( Runtime.run(List.of(2, 1, 3, 1, 2)));
        System.out.println( Runtime.run(List.of(1, 1, 2, 2, 3, 3, 5, 5, 7, 7, 9, 9)));
    }
}
