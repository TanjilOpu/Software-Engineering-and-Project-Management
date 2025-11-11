public class Tester {
    static void main(String[] args) {
        Student s1 = new Student("Opu",23044);
        Student s2 = new Student();
//        s2.name="anirban"; //this will not work as name in Student class is private
        s2.id=23043;
        s2.setName("karim");
//        System.out.println(s2.name);// this also not work here so we will use get method
        System.out.println(s2.getName());
        s1.show_details();
        s2.show_details();

    }
}
