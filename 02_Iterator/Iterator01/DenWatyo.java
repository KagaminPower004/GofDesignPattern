interface Aggregate{
    public Iterator iterator();
  }

interface Iterator{
      public boolean hasNext();
      public Object next();
    }

class Person{
    private String name;
    private String phone_number;
 
    public Person(String name,String phone_number){
        this.name = name;
        this.phone_number = phone_number;
    }
    public String getName(){
        return name;
    }
    public String getphone_number(){
        return phone_number;
    }
}

class DenWatyo implements Aggregate{
    protected Person[] Persons;
    private int last = 0;

    public DenWatyo(){}
    public DenWatyo(int PersonCount){
    this.Persons = new Person[PersonCount];
    }

    public void add(Person Person){
        Persons[last] = Person;
        last++;
    }
    public Person getPersonAt(int index){
        return Persons[index];
    }

    public int getLastNum(){
        return last;
    }

    public Iterator iterator(){
        return new DenWatyoIterator(this);
    }
}

class DenWatyoIterator implements Iterator{
    private DenWatyo DenWatyo;
    private int index;
    public DenWatyoIterator(DenWatyo denWaTyo){
        this.DenWatyo = denWaTyo;
        this.index = 0;
    }
    public boolean hasNext(){
        if(DenWatyo.getLastNum() > index){
            return true;
        }else{
            return false;
        }
    }
    public Person next(){
        Person person =  DenWatyo.getPersonAt(index);
        index++;
        return person;
    }
}

class Beauty{
    private DenWatyo denWaTyo;
    public void createDenWatyo(){
        denWaTyo = new DenWatyo(3);
        denWaTyo.add(new Person("花留 花子","090-7777-7777"));
        denWaTyo.add(new Person("島津 幸次","080-3344-4433"));
        denWaTyo.add(new Person("神田 真保","070-5555-4444"));
    }
    public void callPersons(){
        Iterator itr = denWaTyo.iterator();
        while(itr.hasNext()){
            Person person = (Person)itr.next();
            System.out.println(person.getName() + " : " + person.getphone_number());
        }
    }

    public static void main(String args[]){
        Beauty you = new Beauty();
        you.createDenWatyo();
        you.callPersons();
    }      
}
