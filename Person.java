package in.kgcoding.challange81;

    import java.util.Objects;

    public class Person {
        private String name;
        private int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        @Override
        public boolean equals(Object obj) {
            // 1. Check if it's the same object reference
            if (this == obj) {
                return true;
            }

            // 2. Check if obj is null or of different class
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }

            // 3. Cast to Person and compare attributes
            Person other = (Person) obj;

            // 4. Compare age (primitive type)
            if (age != other.age) {
                return false;
            }

            // 5. Compare name (could be null)
            return Objects.equals(name, other.name);
        }

        @Override
        public int hashCode() {
            // Use Objects.hash() which handles null values properly
            // It combines the hash codes of all specified attributes
            return Objects.hash(name, age);
        }

        @Override
        public String toString() {
            return "Person[name=" + name + ", age=" + age + "]";
        }

        // Test the implementation
        public static void main(String[] args) {
            Person person1 = new Person("Aman", 18);
            Person person2 = new Person("Priyanshu", 17);
            Person person3 = new Person("Divyanshu", 18);

            // Test equals() method
            System.out.println("person1.equals(person2): " + person1.equals(person2)); // true
            System.out.println("person1.equals(person3): " + person1.equals(person3)); // false
            System.out.println("person1.equals(null): " + person1.equals(null)); // false
            System.out.println("person1.equals(\"Alice\"): " + person1.equals("Alice")); // false

            // Test hashCode() consistency
            System.out.println("\nHash codes:");
            System.out.println("person1.hashCode(): " + person1.hashCode());
            System.out.println("person2.hashCode(): " + person2.hashCode());
            System.out.println("person1.hashCode() == person2.hashCode(): " +
                    (person1.hashCode() == person2.hashCode())); // true

            // Verify contract: equal objects must have equal hash codes
            System.out.println("\nContract verification:");
            System.out.println("If person1.equals(person2) is true, then");
            System.out.println("person1.hashCode() == person2.hashCode() is " +
                    (person1.hashCode() == person2.hashCode())); // true
        }
    }

