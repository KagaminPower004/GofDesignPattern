//挨拶クラス
class Aisatsu{

    public String aisatsu(String Aite,String Kibun){

        if(Kibun == "ご機嫌"){
            //元気よく挨拶!
            return Aite + "大好き♪";
        }else if(Kibun == "不機嫌"){
            //元気よくないけど挨拶!
            return Aite + "大嫌い!!";
        }else{
            //よくわからない気持ち
            return "微妙。。。";
        }
    }
}

class Pure{
    public static void main(String args[]) {
        
        Aisatsu HenJi;
        String result;

        //Happyに挨拶♪
        System.out.println("お誕生日の翌朝：");
        System.out.println("Happy、おはよう!");

        HenJi = new Aisatsu();
        result = HenJi.aisatsu("ぱぁぱ","ご機嫌");

        System.out.println(result + "\r\n");

        //Happyに挨拶♪
        System.out.println("家族旅行中：");
        System.out.println("Happy、おはよう!");

        HenJi = new Aisatsu();
        result = HenJi.aisatsu("ぱぁぱ","ご機嫌");

        System.out.println(result + "\r\n");

        //Happyに挨拶♪
        System.out.println("ハッピーセットを買わなかった翌朝：");
        System.out.println("Happy、おはよう!");

        HenJi = new Aisatsu();
        result = HenJi.aisatsu("ぱぁぱ","不機嫌");

        System.out.println(result);

    }
}