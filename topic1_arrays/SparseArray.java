import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SparseArray {

    public static List<Integer> matchingStrings(List<String> strings, List<String> queries) {
        final Map<String, Integer> mapWords = new HashMap<>();
        for (String word : strings) {
            if (mapWords.containsKey(word)) {
                mapWords.put(word, mapWords.get(word) + 1);
            } else {
                mapWords.put(word, 1);
            }
        }

        return queries.stream().map(v -> mapWords.getOrDefault(v, 0)).collect(Collectors.toList());
        //Map<String, Integer> mapa = strings.stream().distinct()
        //.collect(Collectors.toMap(Function.identity(), String::length));
        //System.out.println(map);
        //return null;
    }

    /**
     * This method construct a map with the collection of Strings and occurrence.
     */
    private static Map<String, Integer> buildCollectionOfStrings(Scanner scanner, int n) {
        final Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            final String line = scanner.nextLine();
            if (map.containsKey(line)) {
                map.put(line, map.get(line) + 1);
            } else {
                map.put(line, 1);
            }
        }
        return map;
    }

    private static void printOcurrenceOfQueries(Scanner scanner, int numberQueries, Map<String, Integer> mapWords) {
        for (int i = 0; i < numberQueries; i++) {
            // for each query, we look for how many times it occurs and we print on screen the value.
            final String line = scanner.nextLine();
            if (mapWords.containsKey(line)) {
                System.out.println(mapWords.get(line));
            } else {
                System.out.println(0);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(SparseArray.matchingStrings(List.of("aba", "baba", "aba", "xzxb"), List.of("aba", "xzxb", "ab")));

        Scanner scanner = new Scanner(System.in);
        final int totalN = Integer.parseInt(scanner.nextLine());
        final Map<String, Integer> mapWords = buildCollectionOfStrings(scanner, totalN);
        final int numberQueries = Integer.parseInt(scanner.nextLine());
        printOcurrenceOfQueries(scanner, numberQueries, mapWords);
    }
}
