package mediator02;

import java.util.*;
import java.util.Random;

interface Mediator{
    public void addTarget(Target target);
    public boolean consultation(Target target);
}

class Agent implements Mediator{
    private Map<String,Target> targetMap = new HashMap<String,Target>();
    public void addTarget(Target target){
        targetMap.put(target.getName(),target);
    }
    public boolean consultation(Target target) {
         String targetName = target.getName();

         if(targetName == "TxtBox"){
             //画面条件チェック
             ChkBox   chkBox   = (ChkBox)targetMap.get("ChkBox");
             RadioButton radioButton = (RadioButton)targetMap.get("RadioButton");

             if(chkBox.onFlg   == false){ return false; }
             if(radioButton.onFlg == false){ return false; }
             
             return true;
         }

         if(targetName == "RadioButton"){

             return ((RadioButton)target).onFlg;
         }

         if(targetName == "ChkBox"){

             return ((ChkBox)target).onFlg;
         }

         return false;

    }
}

interface Target{
    public String getName();
    public boolean chkState(Mediator agent);
}

class TxtBox implements Target{
    private String name = "TxtBox";
    public boolean onFlg;
     
    public String getName(){
        return name;
    }

    public boolean chkState(Mediator agent){
        this.onFlg = agent.consultation(this);
        return this.onFlg;
    }

}

class RadioButton implements Target{
    private String name = "RadioButton";
    public boolean onFlg;
     
    public String getName(){
        return name;
    }

    public boolean chkState(Mediator agent){
        this.onFlg = agent.consultation(this);
        return this.onFlg;
    }

}

class ChkBox implements Target{
    private String name = "ChkBox";
    public boolean onFlg;
     
    public String getName(){
        return name;
    }

    public boolean chkState(Mediator agent){
        this.onFlg = agent.consultation(this);
        return this.onFlg;
    }

}

class SeikyuShoForm{
    public static void main(String args[]){
        
        TxtBox      txtBox      = new TxtBox();
        ChkBox      chkBox      = new ChkBox();
        RadioButton radioButton = new RadioButton();

        chkBox.onFlg   = Boolean.valueOf(args[0]);
        radioButton.onFlg = Boolean.valueOf(args[1]);

        Mediator agent = new Agent();
        agent.addTarget(txtBox);
        agent.addTarget(chkBox);
        agent.addTarget(radioButton);

        if(chkBox.chkState(agent)){ System.out.println("チェックボックスはオンです"); }
        else{ System.out.println("チェックボックスはオフです");}

        if(radioButton.chkState(agent)){ System.out.println("ラジオボタンはオンです"); }
        else{ System.out.println("ラジオボタンはオフです");}

        if(txtBox.chkState(agent)){ System.out.println("テキストボックスが入れられる!!"); }
        else{ System.out.println("テキストボックスが入れらない!!");}

    }
}