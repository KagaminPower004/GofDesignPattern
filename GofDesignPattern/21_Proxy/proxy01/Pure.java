package proxy01;

//SEインターフェース
interface SystemEngineer {
    public void question1();
    public void question2();
    public void question3();
}

//内藤SEクラス(本人オブジェクト)
class Naito implements SystemEngineer {
 
    public void question1() { System.out.print("B-TreeIndexを追加すること"); }
 
    public void question2() { System.out.print("BitMapインデックスをすること"); }
 
    public void question3() {
        System.out.print("別途ログを出すプログラムを追加すること");
    }
 
}

//PureSEクラス(代理人オブジェクト)
class Pure implements SystemEngineer {
    private SystemEngineer naito = new Naito();
 
    public void question1() {
        System.out.println("それはB-TreeIndexの追加が有効です。");
    }
 
    public void question2() { System.out.println("それはBitMapインデックスが有効です。"); }
 
    public void question3() {
        System.out.print("答えは「");
        //PureSEには答えられないので、内藤SEに聞く
         naito.question3();
        System.out.println("」となります。");
    }
 
}
//クライアント
class Client{
 
    public static void main(String[] args) {
        SystemEngineer pure = new Pure();
         
        //質問1
        pure.question1();
        //質問2
        pure.question2();
        //質問3
        pure.question3();
         
    }
}