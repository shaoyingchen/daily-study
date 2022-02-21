package java8;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Stream
 *
 * @author chensy6@asiainfo.com
 * @Company 亚信科技
 * @Copyright asiainfo
 * @CreateDate 2021/5/26 16:31
 **/
public class StreamTest {

    public static class Person {
        private String name;
        private String age;
        private String addres;

        public Person() {

        }

        public Person(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAge() {
            return age;
        }

        public void setAge(String age) {
            this.age = age;
        }

        public String getAddres() {
            return addres;
        }

        public void setAddres(String addres) {
            this.addres = addres;
        }
    }

    public static void main(String[] args) {
        //单个值操作
        List<String> collect = Stream.of("hello", "world").map(word -> word + "!").collect(Collectors.toList());
        //多个值操作
        String s = Stream.of("hello", "world").reduce("", (a, b) -> a + "_" + b);

        Integer[] arr = new Integer[]{1, 2, 3};
        Stream.of(arr).filter(x -> x.equals("1")).forEach(System.out::println);
        //[]转化List
        List<Integer> collect1 = Stream.of(arr).map(x -> x++).collect(Collectors.toList());
        //校验
        List<Person> personList = Arrays.asList(new Person("zhangsan"), new Person("lisi"), new Person("wangwu"));
        personList.stream().filter(person -> person.getName().equals("zhangsan")).collect(Collectors.toList());
        //迭代
        Stream.iterate(0, x -> ++x).limit(10).forEach(System.out::println);
        //分组
        Map<String, List<Person>> collect2 = personList.stream().collect(Collectors.groupingBy(Person::getAge));
        //根据年纪进行排序，返回年纪列表
        personList.stream().map(person -> person.getAge()).sorted().collect(Collectors.toList());
        //根据年纪进行排序，返回对象
        personList.stream().sorted(Comparator.comparing(Person::getAge));
        //给名字为zhangsand的人改地址
        Stream<Person> peek =
                personList.stream().filter(person -> person.getName().equals("zhangsan"))
                        .peek(person -> person.setAddres("zhangsandedizhi"));
        //根据姓名进行过滤
        List<String> collect3 =
                personList.stream().map(person -> person.getName()).distinct().collect(Collectors.toList());
        //返回年纪最小的
        Person person = personList.stream().min(Comparator.comparing(Person::getAge)).get();
        //Function.identity() 代表对象本身
        Arrays.asList("2","3","5","2","4").stream().max(Comparator.comparing(Function.identity()));




    }

}
