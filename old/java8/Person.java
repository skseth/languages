// http://docs.oracle.com/javase/tutorial/java/javaOO/lambdaexpressions.html#approach8

public class Person {

    public enum Sex {
        MALE, FEMALE
    }

    String name;
    LocalDate birthday;
    Sex gender;
    String emailAddress;

    public int getAge() {
        return 20;
    }

    public void printPerson() {
        System.out.println(name + ":" + age)
    }

    public static void printPersonsOlderThan(List<Person> roster, int age) {
    for (Person p : roster) {
        if (p.getAge() >= age) {
            p.printPerson();
        }
    }



}