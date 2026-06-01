import java.util.TreeMap;

public class ParkingBTree {

    public static void main(String[] args) {

        TreeMap<Integer,String> records =
                new TreeMap<>();

        records.put(101,"KA01AB1234");
        records.put(102,"TS09XY5678");
        records.put(103,"AP22CD9876");
        records.put(104,"KA05MN4321");
        records.put(105,"TS10PQ1111");

        System.out.println(
        "===== ParkSmart B-Tree Indexing =====");

        System.out.println("\nParking Records:");

        for(Integer id : records.keySet()) {

            System.out.println(
            id + " -> " + records.get(id));
        }

        System.out.println(
        "\nSimulated B-Tree Structure");

        System.out.println(
        "         [103]");

        System.out.println(
        "      /         \\");

        System.out.println(
        "[101 102]   [104 105]");

        System.out.println(
        "\nSearch Record ID 104");

        if(records.containsKey(104))
            System.out.println("Record Found");
        else
            System.out.println("Record Not Found");
    }
}