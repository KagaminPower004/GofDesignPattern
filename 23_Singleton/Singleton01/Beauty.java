class Pure{
    private static Pure pure = new Pure();

    private Pure(){}

    public static Pure getInstance(){
        return pure;
    }
}

class Beauty{
    public static void main(String args[]){

        System.out.println("～20代の頃のピュアさん～");
        Pure pure20 = Pure.getInstance();
        System.out.println("変な人だなぁ。いつも挙動不審だ。。。");

        System.out.println("\n～30代の頃のピュアさん～");
        Pure pure30 = Pure.getInstance();

        if( pure20 == pure30 ){System.out.println("変な人だなぁ。いつも挙動不審だ。。。");}
        else{System.out.println("30代らしく、責任感やリーダーシップのある人に変わったね♪♪");}

        System.out.println("\n～40代の頃のピュアさん～");
        Pure pure40 = Pure.getInstance();

        if( pure20 == pure40 ){System.out.println("変な人だなぁ。いつも挙動不審だ。。。");}
        else{System.out.println("40代になって、立派な役職もついて貫禄がついたね♪♪♪");}

    }
}