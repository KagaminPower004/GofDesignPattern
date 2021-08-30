import java.util.*;
import java.util.Random;

interface LoveMediator{
    public void addColleague(Colleague colleague);
    public int consultation(Colleague colleagueInLove,Colleague secretLover);
}

class Saito implements LoveMediator{
    private Map<String,Colleague> colleagueMap = new HashMap<String,Colleague>();
    public void addColleague(Colleague colleague){
        colleagueMap.put(colleague.getName(),colleague);
    }
    public int consultation(Colleague colleagueInLove,Colleague secretLover) {
        int possibility= 0;
        /* さまざまな状況を考慮して、possibility を導出 */
        
        try{
            Random random = new Random();
            possibility = random.nextInt(100);
            Thread.sleep(possibility);
        }catch(InterruptedException e){}
        
        System.out.println( colleagueInLove.getName() + "さん、たぶん、" + secretLover.getName()
                          +  "さんとは成功率" + possibility + "%だと思うよ");
        
        return possibility;
    }
}

interface Colleague{
    public String getName();
    public void setSecretLover(Colleague colleague);
    public void needsAdvice();
}

class Nitta implements Colleague{
    private String name = "新田";
    private int tension;
    private Colleague secretLover = null;
    private LoveMediator mediator = new Saito();
     
    public String getName(){
        return name;
    }
    public  void setSecretLover(Colleague colleague){
        this.secretLover = colleague;
    }
    public void needsAdvice(){
        this.tension = mediator.consultation(this,secretLover);
    }
}

class Hanako implements Colleague{
    private String name = "花子";
    private int tension;
    private Colleague secretLover = null;
    private LoveMediator mediator = new Saito();
     
    public String getName(){
        return name;
    }
    public  void setSecretLover(Colleague colleague){
        this.secretLover = colleague;
    }
    public void needsAdvice(){
        this.tension = mediator.consultation(this,secretLover);
    }
}

class Test{
    public static void main(String args[]){
        Colleague nitta = new Nitta();
        Colleague hanako = new Hanako();
        nitta.setSecretLover(hanako);
        nitta.needsAdvice();
    }
}