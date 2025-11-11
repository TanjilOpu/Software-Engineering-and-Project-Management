public class Student {
    private String name;
    public int id;

    public Student(String name, int id)
    {
        this.name= name;
        this.id= id;
    }
    public Student()
    {

    }
    public void setName(String nm)
    {
        name=nm;
    }
    public String getName()
    {
        return name;
    }

    // set + get method is called encaptulation
    public void show_details()
    {
        System.out.println("name : "+name+"\n "+"id: "+id);
    }
}
