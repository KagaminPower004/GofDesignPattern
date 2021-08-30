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
        System.out.println("ピュアさんって言うんだ。初めましてだね!");

        System.out.println("\n～30代の頃のピュアさん～");
        Pure pure30 = Pure.getInstance();

        if( pure20 == pure30 ){System.out.println("30代のピュアさん、20代の頃と変わってないね!");}
        else{System.out.println("30代になって、お酒が弱い人に変わっちゃったね。。。");}

        System.out.println("\n～40代の頃のピュアさん～");
        Pure pure40 = Pure.getInstance();

        if( pure20 == pure40 ){System.out.println("40代のピュアさん、あの時と変わってないね!");}
        else{System.out.println("40代になって、髪の毛がところどころ白くなっちゃったね。。。");}

    }
}