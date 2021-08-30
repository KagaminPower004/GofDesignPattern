import java.util.*;

interface Observer{
    public String getName();
    public void upDate(int count);
    public void shout();
}

class Rookie implements Observer{

    private String name = "新人先生";
    private int count = 0;

    public String getName(){
        return name;
    }

    public void upDate(int count){this.count += count;}

    public void shout(){System.out.println("先生：みなさん今日は、" + this.count + "週走りました!");}
}

abstract class Subject{
    public abstract void addObserver(Observer observer);
    public abstract void notifyObservers();
    public abstract void run(int count);

}

class Taro extends Subject{

    private Map<String,Observer> observerMap = new HashMap<String,Observer>();
    private int count = 0;

    public void addObserver(Observer observer){
        this.observerMap.put(observer.getName(),observer);
    }

    public void notifyObservers(){
        this.observerMap.forEach((key, value) -> value.upDate(this.count));
    }

    public void run(int count){
        this.count = count;
        System.out.println("太郎：僕は" + this.count + "週走りました!");
    }

}

class Hanako extends Subject{

    private Map<String,Observer> observerMap = new HashMap<String,Observer>();
    private int count = 0;

    public void addObserver(Observer observer){
        this.observerMap.put(observer.getName(),observer);
    }

    public void notifyObservers(){
        this.observerMap.forEach((key, value) -> value.upDate(this.count));
    }

    public void run(int count){
        this.count = count;
        System.out.println("花子：私は" + this.count + "週走りました!");
    }

}

class Test{
    public static void main(String args[]){
        Observer rookie = new Rookie();

        Subject taro = new Taro();
        taro.addObserver(rookie);
        taro.run(15);
        taro.notifyObservers();

        Subject hanako = new Hanako();
        hanako.addObserver(rookie);
        hanako.run(5);
        hanako.notifyObservers();

        taro.addObserver(rookie);
        taro.run(20);
        taro.notifyObservers();

        rookie.shout();
    }
}