package template_method01;

abstract class Cookingoo{

    public abstract void cut( CurryNoGoo zairyo );
    public abstract void mazemaze( CurryNoGoo zairyo );
    public abstract void niru();
    public abstract void wait( int minute );

    public void makeCookingoo( int minute ){
        CurryNoGoo zairyo = new CurryNoGoo();

        cut( zairyo );
        mazemaze( zairyo );
        niru();
        wait( minute );
        System.out.println("出来上がり～♪♪♪");
    }
}

class CurryNoGoo{

    private String ninjin   = "ニンジン";
    private String tamanegi = "タマネギ";
    private String jagaimo  = "ジャガイモ";
    private String butaniku = "ぶたにく";

    public CurryNoGoo(){
    }
    
    public String getNinjin(){
        return ninjin;
    }

    public String getTamanegi(){
        return tamanegi;
    }

    public String getJagaimo(){
        return jagaimo;
    }

    public String getButaniku(){
        return butaniku;
    }
}

class HappyCookingoo extends Cookingoo{

    public void wait( int minute ){
        System.out.println(minute + "分間待つ♪\n");
    }

    public void cut( CurryNoGoo zairyo ){
        System.out.println(zairyo.getNinjin()   + "を切る♪");
        System.out.println(zairyo.getTamanegi() + "を切る♪");
        System.out.println(zairyo.getJagaimo()  + "を切る♪");
        System.out.println(zairyo.getButaniku() + "を切る♪\n");
    }

    public void niru(){
        System.out.println("全部おなべに入れて煮る♪\n");
    }

    public void mazemaze( CurryNoGoo zairyo ){
        System.out.println(zairyo.getNinjin()   + "と♪");
        System.out.println(zairyo.getTamanegi() + "と♪");
        System.out.println(zairyo.getJagaimo()  + "と♪");
        System.out.println(zairyo.getButaniku() + "を♪");
        System.out.println("みんな入れて混ぜる♪\n");
    }

    public static void main(String args[]) {
        Cookingoo Happy = new HappyCookingoo();
        
        //Happyがクッキング～♪
        Happy.makeCookingoo(40);
    }
}