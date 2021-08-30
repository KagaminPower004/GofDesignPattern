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
            System.out.println(question.question + "→" + responsiblePerson + "「誰にも判断できませんでした。やってみなさい。」");
        }
    }

    protected abstract boolean beAbleToJudge(Question question);
    protected abstract void judge(Question question);
}

class Student extends Responsible{
    private Level responsibleLevel = new Level(1);

    public Student(String responsiblePerson){
        super(responsiblePerson);
    }

    protected boolean beAbleToJudge(Question question){
        if(question.level.LessThan(responsibleLevel)){
            return true;
        }
        return false;
    }

    protected void judge(Question question){
        System.out.println(question.question + "→" + super.getResponsiblePerson() + "「ご自由に～」");
    }
}

class ClassTeacher extends Responsible{
    private Level responsibleLevel = new Level(2);

    public ClassTeacher(String responsiblePerson){
        super(responsiblePerson);
    }

    protected boolean beAbleToJudge(Question question){
        if(question.level.LessThan(responsibleLevel)){
            return true;
        }
        return false;
    }

    protected void judge(Question question){
        System.out.println(question.question + "→" + super.getResponsiblePerson()  + "「300円までかな～」");
    }
}

class ChiefTeacher extends Responsible{
    private Level responsibleLevel = new Level(3);

    public ChiefTeacher(String responsiblePerson){
        super(responsiblePerson);
    }

    protected boolean beAbleToJudge(Question question){
        if(question.level.LessThan(responsibleLevel)){
            return true;
        }
        return false;
    }

    protected void judge(Question question){
        System.out.println(question.question + "→" + super.getResponsiblePerson()  + "「自分で考えなさい!!」");
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
        System.out.println(question.question + "→" + super.getResponsiblePerson()  + "「全員一致でそれはイカンとなりました。」");
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

class Main{
    public static void main(String args[]){
        Responsible nakagawa = new Student("中川雄介");
        Responsible rookie = new ClassTeacher("新人先生");
        Responsible veteran = new ChiefTeacher("ベテラン先生");
        Responsible staffMeeting = new StaffMeeting("職員会議");
        
        nakagawa.setNext(rookie).setNext(veteran).setNext(staffMeeting);
        
        nakagawa.putQuestion(new Question("おやつはいくらまで？",new Level(1)));
        nakagawa.putQuestion(new Question("携帯電話持って行ってよい？",new Level(3)));
    }
}