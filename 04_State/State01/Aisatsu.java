//挨拶インターフェース
interface Aisatsu{
    public String aisatsu(String Aite);
}

//ご機嫌のときの挨拶
class GokiGen implements Aisatsu{
    public String aisatsu(String Aite){
        //元気よく挨拶!
        return Aite + "大好き♪";
    }
}

//不機嫌のときの挨拶
class FkiGen implements Aisatsu{
    public String aisatsu(String Aite){
        //元気よくないけど挨拶!
        return Aite + "大嫌い!!";
    }
}

class Pure{
    public static void main(String args[]) {

        Aisatsu HenJi;
        String result;
        
        //Happyに挨拶♪
        System.out.println("お誕生日の翌朝：");
        System.out.println("Happy、おはよう!");

        HenJi = new GokiGen();
        result = HenJi.aisatsu("ぱぁぱ");

        System.out.println(result + "\r\n");

        //Happyに挨拶♪
        System.out.println("家族旅行中：");
        System.out.println("Happy、おはよう!");

        HenJi = new GokiGen();
        result = HenJi.aisatsu("ぱぁぱ");

        System.out.println(result + "\r\n");

        //Happyに挨拶♪
        System.out.println("ハッピーセットを買わなかった翌朝：");
        System.out.println("Happy、おはよう!");

        HenJi = new FkiGen();
        result = HenJi.aisatsu("ぱぁぱ");

        System.out.println(result);

    }
}