abstract class Cookingoo{

    protected abstract void cut( OnabeNoGoo zairyo );
    protected abstract void mazemaze( OnabeNoGoo zairyo );
    protected abstract void niru();
    protected abstract void wait( int minute );

    protected OnabeNoGoo createCookingNoGooo(){
        return new CurryNoGoo();
    }

    protected void makeCookingoo( int minute ){
        OnabeNoGoo zairyo = createCookingNoGooo();

        cut( zairyo );
        mazemaze( zairyo );
        niru();
        wait( minute );
        System.out.println("出来上がり～♪♪♪");
    }
}

interface OnabeNoGoo{
    public String getGoo01();
    public String getGoo02();
    public String getGoo03();
    public String getGoo04();
}

class CurryNoGoo implements OnabeNoGoo{

    private String goo01 = "ニンジン";
    private String goo02 = "タマネギ";
    private String goo03 = "ジャガイモ";
    private String goo04 = "ぶたにく";

    public CurryNoGoo(){
    }
 
    public String getGoo01(){
        return goo01;
    }

    public String getGoo02(){
        return goo02;
    }

    public String getGoo03(){
        return goo03;
    }

    public String getGoo04(){
        return goo04;
    }
}

class SityuuNoGoo implements OnabeNoGoo{

    private String goo01 = "ニンジン";
    private String goo02 = "タマネギ";
    private String goo03 = "ジャガイモ";
    private String goo04 = "ぎゅうにく";
 
    public String getGoo01(){
        return goo01;
    }

    public String getGoo02(){
        return goo02;
    }

    public String getGoo03(){
        return goo03;
    }

    public String getGoo04(){
        return goo04;
    }
}

class HappyCookingoo extends Cookingoo{

    public void wait( int minute ){
        System.out.println(minute + "分間待つ♪\n");
    }

    public void cut( OnabeNoGoo zairyo ){
        System.out.println(zairyo.getGoo01() + "を切る♪");
        System.out.println(zairyo.getGoo02() + "を切る♪");
        System.out.println(zairyo.getGoo03() + "を切る♪");
        System.out.println(zairyo.getGoo04() + "を切る♪\n");
    }

    public void niru(){
        System.out.println("全部おなべに入れて煮る♪\n");
    }

    public void mazemaze( OnabeNoGoo zairyo ){
        System.out.println(zairyo.getGoo01() + "と♪");
        System.out.println(zairyo.getGoo02() + "と♪");
        System.out.println(zairyo.getGoo03() + "と♪");
        System.out.println(zairyo.getGoo04() + "を♪");
        System.out.println("みんな入れて混ぜる♪\n");
    }

    public OnabeNoGoo createCookingNoGooo(){
        return new SityuuNoGoo();
    }

    public static void main(String args[]) {
        Cookingoo Happy = new HappyCookingoo();
        
        //Happyがクッキング～♪
        Happy.makeCookingoo(40);
    }
}