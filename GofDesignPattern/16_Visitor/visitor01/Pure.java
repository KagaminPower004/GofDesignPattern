package visitor01;

//面接官クラス

abstract class MensetsuKan{

    public abstract void visit(Phone smartPhone);
    public abstract void visit(PurePhone smartPhone);
    public abstract void visit(SuzukiPhone smartPhone);
    public abstract void visit(TanakaPhone smartPhone);

}

//アマポン面接官クラス
class AmaponMensetsuKan extends MensetsuKan{

    public void visit(Phone smartPhone){
        System.out.println("こんにちは");
    }

    public void visit(PurePhone smartPhone){
        smartPhone.aisatsu();
    }

    public void visit(SuzukiPhone smartPhone){
        smartPhone.shitsumon();
    }

    public void visit(TanakaPhone smartPhone){
        smartPhone.shitsumon();
    }

}

//業務システムズ面接官クラス
class GyoumuSystemsMensetsuKan extends MensetsuKan{

    public void visit(Phone smartPhone){
        System.out.println("こんにちは");
    }

    public void visit(PurePhone smartPhone){
        smartPhone.aisatsu();
    }

    public void visit(SuzukiPhone smartPhone){
        smartPhone.shitsumon();
    }

    public void visit(TanakaPhone smartPhone){
        smartPhone.shitsumon();
    }

}

//電話クラス
abstract class Phone{
    public abstract Object shitsumon();
    public abstract Object aisatsu();
}

//面接官受け入れインタフェース
interface MensetsuKanAcceptor{
    public void accept(MensetsuKan MensetsuKan);
}

//ピュアさんの電話
class PurePhone extends Phone implements MensetsuKanAcceptor{
    public Object shitsumon(){
        System.out.println("    その案件については・・・");
        return null;
    }
    public Object aisatsu(){
        System.out.println("    この度は面接の機会を下さり誠にありがとうございます!!");
 
        return null;
    }
    /**
     * 訪問者を受け入れるメソッド
     */
    public void accept(MensetsuKan MensetsuKan){
        MensetsuKan.visit(this);
    }
}

//鈴木さんの電話
class SuzukiPhone extends Phone implements MensetsuKanAcceptor{
    public Object shitsumon(){
        System.out.println("わかりません!!");
        return null;
    }
    public Object aisatsu(){
        System.out.println("ありがとうございます。");
 
        return null;
    }
    /**
     * 訪問者を受け入れるメソッド
     */
    public void accept(MensetsuKan MensetsuKan){
        MensetsuKan.visit(this);
    }
}

//田中さんの電話
class TanakaPhone extends Phone implements MensetsuKanAcceptor{
    public Object shitsumon(){
        System.out.println("・・・・・・");
        return null;
    }
    public Object aisatsu(){
        System.out.println("・・・・・・");
 
        return null;
    }
    /**
     * 訪問者を受け入れるメソッド
     */
    public void accept(MensetsuKan MensetsuKan){
        MensetsuKan.visit(this);
    }
}

class Pure{
    public static void main(String args[]){

        MensetsuKanAcceptor pure = new PurePhone();
        
        MensetsuKan amapon = new AmaponMensetsuKan();
        System.out.println("アマポンから電話面接の電話が来たとき：");
        pure.accept(amapon);

        MensetsuKan gyoumsystems = new GyoumuSystemsMensetsuKan();
        System.out.println("業務システムズから電話面接の電話が来たとき：");
        pure.accept(gyoumsystems);
    }
}