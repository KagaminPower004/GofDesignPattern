package adapter02;

class CallCenter{

    public void CallTokyo03(){
        System.out.println("お電話ありがとうございます。");
    }

}

interface FreeDial{
    public void CallFreeDial();
}

class NewCallCenter implements FreeDial{

    private CallCenter callcenter;

    public NewCallCenter(){
        callcenter = new CallCenter();
    }

    public void CallFreeDial(){
        callcenter.CallTokyo03();
    }
}

class Beauty{
    public static void main(String args[]){

        FreeDial newCallCenter = new NewCallCenter();
        newCallCenter.CallFreeDial();
    }
}