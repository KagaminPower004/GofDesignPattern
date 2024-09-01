package observer01;

import java.util.*;

interface Observer{
    String getName();
    void upDate(boolean result,String name);
}

class AtPipe implements Observer{

    private String name = "@パイプ";

    public String getName(){
        return name;
    }

    public void upDate(boolean result,String name){
        if(result){System.out.println(this.name + "より：" + name + "から『採用』の通知が来ました!");}
        else      {System.out.println(this.name + "より：" + name + "から不採用の通知が来ました。");}
    }
}

class FindBob implements Observer{

    private String name = "FindBob";

    public String getName(){
        return name;
    }

    public void upDate(boolean result,String name){
        if(result){System.out.println(this.name + "より：" + name + "から『採用』の通知が来ました!");}
        else      {System.out.println(this.name + "より：" + name + "から不採用の通知が来ました!!!");}
    }
}

abstract class Subject{
    private Map<String,Observer> observerMap = new HashMap<String,Observer>();
    private boolean result = false;

    public abstract String getName();

    public void addObserver(Observer observer){

        this.observerMap.put(observer.getName(),observer);
    }

    public void notifyObservers(){

        this.observerMap.forEach((key, value) -> value.upDate(this.result,getName()));
    }

    public void reply(boolean result){

        this.result = result;
    }

}

class GyoumuSystems extends Subject{

    private String name = "業務システムズ";

    public String getName(){
        return name;
    }

}

class NCCDATA extends Subject{

    private String name = "NCCDATA";
    public String getName(){
        return name;
    }

}

class Galaxy extends Subject{

    private String name = "ギャラクシーシステムズ";
    public String getName(){
        return name;
    }

}

class Combo extends Subject{

    private String name = "コンボシステムズ";
    public String getName(){
        return name;
    }

}

class GooKle extends Subject{

    private String name = "グークル";
    public String getName(){
        return name;
    }

}

class Bizsys extends Subject{

    private String name = "日本ビズシステムズ";
    public String getName(){
        return name;
    }

}

class Sales extends Subject{

    private String name = "セールスコース株式会社";
    public String getName(){
        return name;
    }

}

class Sonson extends Subject{

    private String name = "Sonson株式会社";
    public String getName(){
        return name;
    }

}

class Pure{
    public static void main(String args[]){
        Observer pipe = new AtPipe();
        Observer bob = new FindBob();

        Subject nccdata = new NCCDATA();
        nccdata.addObserver(pipe);
        nccdata.reply(false);
        nccdata.notifyObservers();

        Subject galaxy = new Galaxy();
        galaxy.addObserver(pipe);
        galaxy.reply(false);
        galaxy.notifyObservers();

        Subject sonson = new Sonson();
        sonson.addObserver(pipe);
        sonson.reply(false);
        sonson.notifyObservers();

        Subject biz = new Bizsys();
        biz.addObserver(pipe);
        biz.reply(false);
        biz.notifyObservers();

        Subject sales = new Sales();
        sales.addObserver(pipe);
        sales.reply(false);
        sales.notifyObservers();

        Subject combo = new Combo();
        combo.addObserver(bob);
        combo.reply(false);
        combo.notifyObservers();

        Subject gookle = new GooKle();
        gookle.addObserver(pipe);
        gookle.addObserver(bob);
        gookle.reply(false);
        gookle.notifyObservers();

        Subject gyoumuSystems = new GyoumuSystems();
        gyoumuSystems.addObserver(bob);
        gyoumuSystems.reply(true);
        gyoumuSystems.notifyObservers();
    }
}