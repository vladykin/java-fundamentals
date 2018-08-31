package ru.compscicenter.java.demos.d03;

public class InitializerBlock {

    public static void main(String[] args) {
        Person person = new Person() {{
            setFirstName("Foo");
            setLastName("Bar");
        }};

        System.out.println(person.getFirstName());
        System.out.println(person.getClass().getName());
    }


    private static class Person {
        private String firstName;
        private String lastName;

        {
            setFirstName("Ivan");
            setLastName("Ivanov");
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }
    }
}
