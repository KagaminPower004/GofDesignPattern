package chain_of_responsibility01;

abstract class Responsible{
    private Responsible next = null;
    private String responsiblePerson = null;

    public Responsible(String responsiblePerson){
        this.responsiblePerson = responsiblePerson;
    }

    public Responsible setNext(Responsible next){
        this.next = next;
        return next;
    }
	
	public String getResponsiblePerson(){ return this.responsiblePerson;}

    public final void putQuestion(Question question){
        if(beAbleToJudge(question)){
            judge(question);
        }else if(next != null){
            next.putQuestion(question);
        }else{
            System.out.println(question.question + "→" + responsiblePerson + "「誰にも判断できませんでした。とりあえず今は保留で。」");
        }
    }

    protected abstract boolean beAbleToJudge(Question question);
    protected abstract void judge(Question question);
}

class Interviewer extends Responsible{
    private Level responsibleLevel = new Level(1);

    public Interviewer(String responsiblePerson){
        super(responsiblePerson);
    }

    protected boolean beAbleToJudge(Question question){
        if(question.level.LessThan(responsibleLevel)){
            return true;
        }
        return false;
    }

    protected void judge(Question question){
        System.out.println(question.question + "→" + super.getResponsiblePerson() + "「採用！！」");
    }
}

class SubManager extends Responsible{
    private Level responsibleLevel = new Level(2);

    public SubManager(String responsiblePerson){
        super(responsiblePerson);
    }

    protected boolean beAbleToJudge(Question question){
        if(question.level.LessThan(responsibleLevel)){
            return true;
        }
        return false;
    }

    protected void judge(Question question){
        System.out.println(question.question + "→" + super.getResponsiblePerson()  + "「まぁ採用しても良いかな～」");
    }
}

class GeneralManager extends Responsible{
    private Level responsibleLevel = new Level(3);

    public GeneralManager(String responsiblePerson){
        super(responsiblePerson);
    }

    protected boolean beAbleToJudge(Question question){
        if(question.level.LessThan(responsibleLevel)){
            return true;
        }
        return false;
    }

    protected void judge(Question question){
        System.out.println(question.question + "→" + super.getResponsiblePerson()  + "「判断が難しいところではあるが、不採用で。」");
    }
}

class StaffMeeting extends Responsible{
    private Level responsibleLevel = new Level(4);

    public StaffMeeting(String responsiblePerson){
        super(responsiblePerson);
    }

    protected boolean beAbleToJudge(Question question){
        if(question.level.LessThan(responsibleLevel)){
            return true;
        }
        return false;
    }

    protected void judge(Question question){
        System.out.println(question.question + "→" + super.getResponsiblePerson()  + "「非常に残念ではあるが、彼は不採用と決めました。」");
    }
}

class Question{
    public Level   level;
    public String  question;
    
    public Question(String question,Level level){
        this.level = level;
        this.question = question;
    }
}

class Level{
    public int level;
    
    public Level(int level){
        this.level = level;
    }

    public boolean LessThan(Level responsibleLevel){
        int lev = responsibleLevel.level;

        if(level < lev ){ return true; }
        return false;
    }
}

class HR{
    public static void main(String args[]){
        Responsible nakagawa     = new Interviewer("中川雄介");
        Responsible rookie       = new SubManager("山田太郎");
        Responsible veteran      = new GeneralManager("今泉博美");
        Responsible staffMeeting = new StaffMeeting("スタッフ会議");
        
        nakagawa.setNext(rookie).setNext(veteran).setNext(staffMeeting);
        
        nakagawa.putQuestion(new Question("鈴木さんは採用して良い？",new Level(1)));
        nakagawa.putQuestion(new Question("ピュア氏は採用して良い？",new Level(3)));
    }
}