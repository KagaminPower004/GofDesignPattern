package adapter00;

class CallCenter{
    public void CallTokyo03(){
        System.out.println("お電話ありがとうございます。");
    }
}

class Beauty{
    public static void main(String args[]){

        CallCenter callcenter = new CallCenter();
        callcenter.CallTokyo03();
    }
}