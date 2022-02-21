package java8;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * 函数式接口
 * Supplier
 * Consumer
 * Function
 * UnaryOperator
 * BiConsumer
 *
 * @author chensy6@asiainfo.com
 * @Company 亚信科技
 * @Copyright asiainfo
 * @CreateDate 2021/5/27 14:40
 **/
public class FunctionInterfaceTest {

    public static class Person {
        private String name;
        private String age;
        private String addres;

        public Person() {

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
        //Supplier
        Supplier<String> supplier = String::new;
        supplier.get();

        Supplier<Person> personSupplier = Person::new;
        Person person = personSupplier.get();
        person.setName("zhangsan");

        //Consumer
        Consumer<Integer> consumer = x -> System.out.println(x << 1);
        consumer.accept(2);

        Consumer<Person> personConsumer = person1 -> {
            System.out.println(person1.getName());
        };
        personConsumer.accept(person);

        //Function
        Function<Integer, Integer> function = x -> x * 2;
        System.out.println(function.apply(2));

        Function<Integer, String> function1 = x -> x * 2 + "";
        System.out.println(function1.apply(3));

        System.out.println(function1.compose(function).apply(2));

    }

}
