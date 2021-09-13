package command01;

//お鍋
class Le_Cruse {
    private double  water      = 0.0;  //水
    private double  curry_roux = 0.0;  //カレールー
    private boolean good;              //カレーがおいしくなったときtrue、まだのときfalse
   
    //コンストラクタ
    public Le_Cruse(double water, double curry_roux) {
        this.water = water;
        this.curry_roux = curry_roux;
    }

    //お鍋にカレールーを入れるメソッド
    public void addCurry_roux(double curry_roux) {
        this.curry_roux += curry_roux;
    }
    //お鍋に水を入れるメソッド
    public void addWater(double water) {
        this.water += water;
    }
    //かき混ぜるメソッド
    public void mix() {
        //水とカレールーをかき混ぜる
        //適量になったかを味見する

        //今現在のカレー汁を用意
        double nowCurryRoux  = this.curry_roux;
        double nowCurryJiru  = this.curry_roux + this.water;

        //固形カレールーの１人前は約19gがベスト♪
        //お水は大人が１杯食べるなら約200gがベスト♪
        //よって適量は[(19g ÷ (19g ＋ 200g))]♪
        double goodCurryJiru = (19.0 / (19.0 + 200.0));

         //適量との差の絶対値を求める♪
        double diff = Math.abs((nowCurryRoux / nowCurryJiru) - (goodCurryJiru));

        //適量との差が１％になるまで調整♪
        if(diff * 100 <= 1.0){
            good = true;
        }else{
            good = false;
        }
    }
    //カレールーの量を返すメソッド
    public double getCurry_roux() {
        return curry_roux;
    }
    //水の量を返すメソッド
    public double getWater() {
        return water;
    }
    //美味しくなったか調べるメソッド
    public boolean isGood() {
        return good;
    }
    //味見結果をいちいち叫ぶ
    public void sakebu() {
        System.out.println("今お水「" + water + "g」!!");
        System.out.println("今カレールー「" + curry_roux + "g」!!\n");
    }
}

//カレー汁調整のスーパークラス
abstract class Command {
    //お鍋
    protected Le_Cruse leCruse;
    //お鍋をセットするメソッド
    public void setLe_Cruse(Le_Cruse leCruse) {
         this.leCruse = leCruse;
    }
    //調理を実行する抽象メソッド
    public abstract void execute();
} 

//カレールーを5gずつ加えるコマンドクラス
class AddCurryRouxCommand extends Command {
 
    public void execute() {
        //カレールーを5gずつ加えておいしいカレー汁を作る場合
        //味が薄い間はカレールーを加える
        do {
            //味見結果をいちいち叫ぶ
            System.out.println("薄っ!!");
            leCruse.sakebu();

            leCruse.addCurry_roux(5.0); //カレールーを5g入れる
            leCruse.mix();              //かき混ぜる
        } while (!leCruse.isGood());

        //味見結果をいちいち叫ぶ
        System.out.println("うん、ちょうど良い感じ♪");
        leCruse.sakebu();
    }
}

//水を50gずつ加えるコマンドクラス
class AddWaterCommand extends Command {
    public void execute() {
        //水を50gずつ加えておいしいカレー汁を作る場合
        //味が濃い間は水を加える
        do {
            //味見結果をいちいち叫ぶ
            System.out.println("濃ゆっ!!");
            leCruse.sakebu();

            leCruse.addWater(50.0); //水を50g入れる
            leCruse.mix();          //かき混ぜる
        } while (!leCruse.isGood());

        //味見結果をいちいち叫ぶ
        System.out.println("うん、ちょうど良い感じ♪");
        leCruse.sakebu();
    }
}

//ビューティーさん
class Beauty {
    public static void main(String[] args) {

        //調理内容(コマンドオブジェクト)を用意する
        Command addCurryRoux  = new AddCurryRouxCommand();
        Command addWater      = new AddWaterCommand(); 
        
        //調理の準備をする
        addCurryRoux.setLe_Cruse(new Le_Cruse(500.0,30.0));//水500にカレールーを5gずつ加えるごとに味見する
        addWater.setLe_Cruse(new Le_Cruse(400.0,48.75));   //カレールー48.75gに水を50gずつ加えるごとに味見する
        
        //調理を実行する
        addCurryRoux.execute();
        addWater.execute();

    }
}