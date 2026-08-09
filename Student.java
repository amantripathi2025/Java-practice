public class Student {

    public static class Students{
        String name;
        int marks;
        int rollnumber;
    }

    public static void main(String[] args) {
        Students s1 = new Students();
        s1.name="Jack";
        s1.marks=100;
        s1.rollnumber=10;

        Students s2 = new Students();
        s2.name="Jack";
        s2.marks=100;
        s2.rollnumber=10;

        System.out.println(s1.name+" "+s1.marks+" "+s1.rollnumber);
        System.out.println(s2.name+" "+s2.marks+" "+s2.rollnumber);
    }
}
