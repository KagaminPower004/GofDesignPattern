import java.util.Vector;

interface Aggregate{
    public Iterator iterator();
  }

interface Iterator{
      public boolean hasNext();
      public Object next();
    }

class Student{
    private String name;
    private int sex; //男の子:1  女の子:2
 
    public Student(String name,int sex){
        this.name = name;
        this.sex = sex;
    }
    public String getName(){
        return name;
    }
    public int getSex(){
        return sex;
    }
}

class StudentList implements Aggregate{
    protected Vector<Student> students;
    private int last = 0;

    public StudentList(){}
    public StudentList(int studentCount){
    this.students = new Vector<Student>(studentCount);
    }

    public void add(Student student){
        students.add(student);
        last++;
    }
    public Student getStudentAt(int index){
        return students.get(index);
    }

    public int getLastNum(){
        return last;
    }

    public Iterator iterator(){
        return new StudentListIterator(this);
    }
}

class StudentListIterator implements Iterator{
    private StudentList StudentList;
    private int index;
    public StudentListIterator(StudentList list){
        this.StudentList = list;
        this.index = 0;
    }
    public boolean hasNext(){
        if(StudentList.getLastNum() > index){
            return true;
        }else{
            return false;
        }
    }
    public Student next(){
        Student s =  StudentList.getStudentAt(index);
        index++;
        return s;
    }
}

class Teacher{
    private StudentList list;
    public void createStudentList(){
        list = new StudentList(3);
        list.add(new Student("中川雄介",1));
        list.add(new Student("板東恵美",2));
        list.add(new Student("水島太郎",1));
    }
    public void callStudents(){
        Iterator itr = list.iterator();
        while(itr.hasNext()){
            System.out.println(((Student)itr.next()).getName());
        }
    }

    public static void main(String args[]){
        Teacher you = new Teacher();
        you.createStudentList();
        you.callStudents();
    }      
}
