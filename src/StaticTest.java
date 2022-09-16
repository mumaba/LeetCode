import java.util.*;
import java.util.stream.Collectors;

public class StaticTest {

    static class Student{
        private  int age;
        private String name;
        public Student(int age,String name){
            this.name = name;
            this.age = age;
        }
    }

    public static void main(String[] args) {
        int i = 9;
        int j = 8;
        int n = (i | j) % (i & j);
        System.out.println(n);

//        TreeSet<Student> students = new TreeSet<>();
//
//        students.add(new Student(23,"wang"));
//        students.add(new Student(16,"zhang"));
//        students.add(new Student(25,"li"));
//        students.forEach(System.out::println);
//
//
//
//
//
//        System.out.println("hello");
//        StaticTest staticTest = new StaticTest();
//        System.out.println( staticTest.a);
//
//        int[] t = new int[]{1,5,6,4,9,7,6,4,5};
//        int[] ints = Arrays.copyOf(t, t.length);
//        int[] int2 = Arrays.copyOf(t, t.length);
//        Arrays.sort(ints);
//        Arrays.stream(ints).boxed().sorted(Comparator.reverseOrder()).forEach(System.out::println);
//        List<Integer> collect = Arrays.stream(int2).boxed().sorted(new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return o2 - o1;
//            }
//        }).collect(Collectors.toList());
//
//        System.out.println(Arrays.toString(ints));
//        System.out.println(collect);
//
//        ArrayList<Object> objects = new ArrayList<>();
//        objects.add("1");
//        objects.add("2");
//        objects.add("3");
//        objects.add("4");
//        ListIterator<Object> objectListIterator = objects.listIterator();
//        while (objectListIterator.hasNext()){
//            objectListIterator.add("a");
//            System.out.println(objectListIterator.next());
//            objectListIterator.set("a");
//        }
//        objects.stream().forEach(System.out::println);

    }

}
