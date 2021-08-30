import java.lang.*;
import java.util.Random;

abstract class MochiTukuImple{
    public abstract void mochiTuku(String oKome);
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

class Pure{
    public static void main(String args[]){

        MochiTukuImple pure = new QuickMochiTukuImple();
        pure.mochiTuku("銀シャリのもち米!!");
        
        System.out.println("\nうぅ、腰が。。。");
        
    }
}
