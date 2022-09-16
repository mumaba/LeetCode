import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static Scanner in = new Scanner(new InputStreamReader(System.in));
    //        读取整数，回车，空格，tab停止

    public static void main(String[] args) {

        HashMap<String,Integer> map = new HashMap<>();
        map.put("a",2);
        map.put("d",2);
        map.put("b",2);
        map.put("c",1);
        map.put("f",3);
        map.put("e",3);
        map.put("cd",2);

        //转换成List排序时，hashmap的key不能相同
        List<Map.Entry<String, Integer>> list = new ArrayList<Map.Entry<String, Integer>>(map.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                if (o1.getValue() != o2.getValue()) {
                    return o1.getValue() - o2.getValue();
                } else {
                    return o1.getKey().compareTo(o2.getKey()) ;
                }
            }
        });
        for (Map.Entry<String, Integer> integerIntegerEntry : list) {
            System.out.print( integerIntegerEntry.getKey() + " ");
            System.out.println( integerIntegerEntry.getValue());
        }


        System.out.print("------------------------------\n");
        Map<String, Integer> sortedByCount = map.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

        for (Map.Entry<String, Integer> stringIntegerEntry : sortedByCount.entrySet()) {
             System.out.print( stringIntegerEntry.getKey() + " ");
             System.out.println( stringIntegerEntry.getValue());
        }

        System.out.print("------------------------------\n");
        Map<String, Integer> sortedByKey = map.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

        for (Map.Entry<String, Integer> stringIntegerEntry : sortedByKey.entrySet()) {
            System.out.print( stringIntegerEntry.getKey() + " ");
            System.out.println( stringIntegerEntry.getValue());
        }
//        List<Person> result = persons.stream().sorted(Comparator.comparing(Person::getNamePinyin).thenComparing(Person::getAge)).collect(Collectors.toList());



//            HashMap<String,Integer> B = new HashMap<>();
//            Map<String, Integer> sortedByCount = map.entrySet()
//                    .stream()
//                    .sorted(Map.Entry.comparingByValue())
//                    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
//
//            List<Person> result = persons.stream().sorted(Comparator.comparing(Person::getNamePinyin).thenComparing(Person::getAge)).collect(Collectors.toList());
//

//
//            map.entrySet().stream().sorted((e1, e2) -> e1.getValue().compareTo(e2.getValue())).collect(Collectors.toList());
//            map.entrySet().stream().sorted(Comparator.comparing(Map.Entry::getValue)).collect(Collectors.toList());

    }}

