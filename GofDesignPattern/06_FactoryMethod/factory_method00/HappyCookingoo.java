package factory_method00;

class SityuuNoGoo{

    private String ninjin   = "ニンジン";
    private String tamanegi = "タマネギ";
    private String jagaimo  = "ジャガイモ";
    private String butaniku = "ぎゅうにく";

    public SityuuNoGoo(){
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

class HappyCookingoo{

    public void wait( int minute ){
        System.out.println(minute + "分間待つ♪\n");
    }

    public void cut( SityuuNoGoo zairyo ){
        System.out.println(zairyo.getNinjin()   + "を切る♪");
        System.out.println(zairyo.getTamanegi() + "を切る♪");
        System.out.println(zairyo.getJagaimo()  + "を切る♪");
        System.out.println(zairyo.getButaniku() + "を切る♪\n");
    }

    public void niru(){
        System.out.println("全部おなべに入れて煮る♪\n");
    }

    public void mazemaze( SityuuNoGoo zairyo ){
        System.out.println(zairyo.getNinjin()   + "と♪");
        System.out.println(zairyo.getTamanegi() + "と♪");
        System.out.println(zairyo.getJagaimo()  + "と♪");
        System.out.println(zairyo.getButaniku() + "を♪");
        System.out.println("みんな入れて混ぜる♪\n");
    }

    public void makeCookingoo( int minute ){
        SityuuNoGoo zairyo = new SityuuNoGoo();

        mazemaze( zairyo );
        niru();
        wait( minute );
        cut( zairyo );

        System.out.println("あれれ??\n熱くて切れないよ～(>_<;)");
    }

    public static void main(String args[]) {
        HappyCookingoo Happy = new HappyCookingoo();
        
        //Happyがクッキング～♪
        Happy.makeCookingoo(120);
    }
}