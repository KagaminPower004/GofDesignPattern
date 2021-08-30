import java.lang.*;
import java.util.Random;

abstract class MochiTukuImple{
    public abstract void mochiTuku(String oKome);
}

class MochiTukuHito{
    private MochiTukuImple MochiTukuImple;
    public MochiTukuHito(MochiTukuImple MochiTukuImple){
        this.MochiTukuImple = MochiTukuImple;
    }
    public void mochiTuku(String oKome){
        MochiTukuImple.mochiTuku(oKome);
    }
}

class QuickMochiTukuImple extends MochiTukuImple{
    public void mochiTuku(String oKome){
        System.out.println(oKome + "を素早くぺったんぺったんつく!!");
        
        try{
            Random random = new Random();
            int randomValue = random.nextInt(1000);
            Thread.sleep(randomValue);
        }catch(InterruptedException e){}
    }
}

class PowerMochiTukuImple extends MochiTukuImple{
    public void mochiTuku(String oKome){
        System.out.println(oKome + "を力を込めてぺったんぺったんつく!!");
        
        try{
            Random random = new Random();
            int randomValue = random.nextInt(2000);
            Thread.sleep(randomValue);
        }catch(InterruptedException e){}
    }
}

class TimerMochiTukuHito extends MochiTukuHito{
    public TimerMochiTukuHito(MochiTukuImple MochiTukuImple){
        super(MochiTukuImple);
    }
    public void timerMochiTuku(String oKome){
        long start = System.currentTimeMillis();
        mochiTuku(oKome);
        long end = System.currentTimeMillis();
        System.out.println("完成♪\n作業時間:" + (end - start) + "秒");
    }
}

class Pure{
    public static void main(String args[]){

        TimerMochiTukuHito pure = new TimerMochiTukuHito(new QuickMochiTukuImple());
        pure.timerMochiTuku("銀シャリのもち米!!");
        
        System.out.println("\nうぅ、腰が。。。");
        
    }
}
