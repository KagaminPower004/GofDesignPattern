package adapter01;

class CallCenter{

    public void CallTokyo03(){
        System.out.println("お電話ありがとうございます。");
    }

}

interface FreeDial{
    public void CallFreeDial();
}

class NewCallCenter extends CallCenter implements FreeDial{
    public void CallFreeDial(){
        CallTokyo03();
    }
}

class Beauty{
    public static void main(String args[]){

        FreeDial newCallCenter = new NewCallCenter();
        newCallCenter.CallFreeDial();
    }
}