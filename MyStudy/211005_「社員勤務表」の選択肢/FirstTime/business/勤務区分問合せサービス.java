package business;

import domain.勤務状況;
import domain.勤務区分;
import java.util.ArrayList;

public class 勤務区分問合せサービス {

    private 勤務状況 my勤務状況;
    private ArrayList<String> my勤務区分list = new ArrayList<>();

    public 勤務区分問合せサービス(String my勤務状況){
        try {
            this.my勤務状況 = 勤務状況.valueOf(my勤務状況);
        } catch (IllegalArgumentException e) {
            System.out.println("その値は勤務状況には存在しません");
        }
    }
    public ArrayList<String> 勤務区分(){
        if(this.my勤務状況.equals(勤務状況.テレワーク))  { 勤務区分のテレワーク設定(); }
        if(this.my勤務状況.equals(勤務状況.出社))       { 勤務区分の出社設定(); }
        if(this.my勤務状況.equals(勤務状況.非出社))      { 勤務区分の非出社設定(); }
        return my勤務区分list;
    }
    private void 勤務区分のテレワーク設定(){
        my勤務区分list.add(勤務区分.フル出勤.toString());
        my勤務区分list.add(勤務区分.午前休.toString());
        my勤務区分list.add(勤務区分.午後休.toString());
    }

    private void 勤務区分の出社設定(){
        my勤務区分list.add(勤務区分.フル出勤.toString());
        my勤務区分list.add(勤務区分.午前休.toString());
        my勤務区分list.add(勤務区分.午後休.toString());
    }

    private void 勤務区分の非出社設定(){
        my勤務区分list.add(勤務区分.週休日.toString());
        my勤務区分list.add(勤務区分.休暇.toString());
        my勤務区分list.add(勤務区分.欠勤.toString());
    }
}