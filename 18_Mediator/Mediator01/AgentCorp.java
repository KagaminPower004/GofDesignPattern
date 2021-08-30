import java.util.*;
import java.util.Random;

interface Mediator{
    public void addTarget(Target target);
    public int consultation(Target changingJobs,Target kibouTarget);
}

class Agent implements Mediator{
    private Map<String,Target> targetMap = new HashMap<String,Target>();
    public void addTarget(Target target){
        targetMap.put(target.getName(),target);
    }
    public int consultation(Target changingJobs,Target kibouTarget) {
        //希望の会社に問合せをする
        int possibility = kibouTarget.getAnswer();
        
        //エージェントの経験からプラスアルファを提案する
        try{
            Random random = new Random();
            possibility += random.nextInt(20);
            Thread.sleep(possibility);
        }catch(InterruptedException e){}
        
        //成功率について回答をする
        System.out.println( changingJobs.getName() + "さん、たぶん、" + kibouTarget.getName()
                          +  "さんとは成功率" + possibility + "%だと思います。");
        
        return possibility;
    }
}

interface Target{
    public String getName();
    public void setKibouTarget(Target target);
    public void needsAdvice();
    public int getAnswer();
}

class Pure implements Target{
    private String name = "ピュア";
    private int tension;
    private Target kibouTarget = null;
    private Mediator agent = new Agent();
     
    public String getName(){
        return name;
    }
    public  void setKibouTarget(Target target){
        this.kibouTarget = target;
    }
    public void needsAdvice(){
        this.tension = agent.consultation(this,kibouTarget);
    }

    public int getAnswer(){
        int possibility= 0;
        try{
            Random random = new Random();
            possibility = random.nextInt(80);
            Thread.sleep(possibility);
        }catch(InterruptedException e){}
        
        return possibility;
    }
}

class Tanaka implements Target{
    private String name = "田中";
    private int tension;
    private Target kibouTarget = null;
    private Mediator agent = new Agent();
     
    public String getName(){
        return name;
    }
    public  void setKibouTarget(Target target){
        this.kibouTarget = target;
    }
    public void needsAdvice(){
        this.tension = agent.consultation(this,kibouTarget);
    }

    public int getAnswer(){
        int possibility= 0;
        try{
            Random random = new Random();
            possibility = random.nextInt(100);
            Thread.sleep(possibility);
        }catch(InterruptedException e){}
        
        return possibility;
    }
}

class NCCDATA implements Target{
    private String name = "NCCDATA";
    private int tension;
    private Target kibouTarget = null;
    private Mediator agent = new Agent();
     
    public String getName(){
        return name;
    }
    public  void setKibouTarget(Target target){
        this.kibouTarget = target;
    }
    public void needsAdvice(){
        this.tension = agent.consultation(this,kibouTarget);
    }

    public int getAnswer(){
        int possibility= 0;
        try{
            Random random = new Random();
            possibility = random.nextInt(30);
            Thread.sleep(possibility);
        }catch(InterruptedException e){}
        
        return possibility;
    }
}

class Galaxy implements Target{
    private String name = "ギャラクシーシステムズ";
    private int tension;
    private Target kibouTarget = null;
    private Mediator agent = new Agent();
     
    public String getName(){
        return name;
    }
    public  void setKibouTarget(Target target){
        this.kibouTarget = target;
    }
    public void needsAdvice(){
        this.tension = agent.consultation(this,kibouTarget);
    }

    public int getAnswer(){
        int possibility= 0;
        try{
            Random random = new Random();
            possibility = random.nextInt(60);
            Thread.sleep(possibility);
        }catch(InterruptedException e){}
        
        return possibility;
    }
}

class Sonson implements Target{
    private String name = "Sonson株式会社";
    private int tension;
    private Target kibouTarget = null;
    private Mediator agent = new Agent();
     
    public String getName(){
        return name;
    }
    public  void setKibouTarget(Target target){
        this.kibouTarget = target;
    }
    public void needsAdvice(){
        this.tension = agent.consultation(this,kibouTarget);
    }

    public int getAnswer(){
        int possibility= 0;
        try{
            Random random = new Random();
            possibility = random.nextInt(40);
            Thread.sleep(possibility);
        }catch(InterruptedException e){}
        
        return possibility;
    }
}

class Combo implements Target{
    private String name = "コンボシステムズ";
    private int tension;
    private Target kibouTarget = null;
    private Mediator agent = new Agent();
     
    public String getName(){
        return name;
    }
    public  void setKibouTarget(Target target){
        this.kibouTarget = target;
    }
    public void needsAdvice(){
        this.tension = agent.consultation(this,kibouTarget);
    }

    public int getAnswer(){
        int possibility= 0;
        try{
            Random random = new Random();
            possibility = random.nextInt(70);
            Thread.sleep(possibility);
        }catch(InterruptedException e){}
        
        return possibility;
    }
}

class GooKle implements Target{
    private String name = "グークル";
    private int tension;
    private Target kibouTarget = null;
    private Mediator agent = new Agent();
     
    public String getName(){
        return name;
    }
    public  void setKibouTarget(Target target){
        this.kibouTarget = target;
    }
    public void needsAdvice(){
        this.tension = agent.consultation(this,kibouTarget);
    }

    public int getAnswer(){
        int possibility= 0;
        try{
            Random random = new Random();
            possibility = random.nextInt(10);
            Thread.sleep(possibility);
        }catch(InterruptedException e){}
        
        return possibility;
    }
}

class Bizsys implements Target{
    private String name = "日本ビズシステムズ";
    private int tension;
    private Target kibouTarget = null;
    private Mediator agent = new Agent();
     
    public String getName(){
        return name;
    }
    public  void setKibouTarget(Target target){
        this.kibouTarget = target;
    }
    public void needsAdvice(){
        this.tension = agent.consultation(this,kibouTarget);
    }

    public int getAnswer(){
        int possibility= 0;
        try{
            Random random = new Random();
            possibility = random.nextInt(30);
            Thread.sleep(possibility);
        }catch(InterruptedException e){}
        
        return possibility;
    }
}

class Sales implements Target{
    private String name = "セールスコース株式会社";
    private int tension;
    private Target kibouTarget = null;
    private Mediator agent = new Agent();
     
    public String getName(){
        return name;
    }
    public  void setKibouTarget(Target target){
        this.kibouTarget = target;
    }
    public void needsAdvice(){
        this.tension = agent.consultation(this,kibouTarget);
    }

    public int getAnswer(){
        int possibility= 0;
        try{
            Random random = new Random();
            possibility = random.nextInt(20);
            Thread.sleep(possibility);
        }catch(InterruptedException e){}
        
        return possibility;
    }
}

class AgentCorp{
    public static void main(String args[]){
        Target pure = new Pure();
        
        Target nccdata  = new NCCDATA();
        Target galaxy   = new Galaxy();
        Target combo    = new Combo();
        Target gookle   = new GooKle();
        Target biz      = new Bizsys();
        Target sales    = new Sales();
        Target sonson   = new Sonson();
        
        pure.setKibouTarget(nccdata);
        pure.needsAdvice();
        pure.setKibouTarget(galaxy);
        pure.needsAdvice();
        pure.setKibouTarget(combo);
        pure.needsAdvice();
        pure.setKibouTarget(gookle);
        pure.needsAdvice();
        pure.setKibouTarget(biz);
        pure.needsAdvice();
        pure.setKibouTarget(sales);
        pure.needsAdvice();
        pure.setKibouTarget(sonson);
        pure.needsAdvice();
    }
}