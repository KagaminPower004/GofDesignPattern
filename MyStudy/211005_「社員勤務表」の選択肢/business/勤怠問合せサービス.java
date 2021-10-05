package business;

import domain.*;
import java.util.ArrayList;

public class 勤怠問合せサービス {

    private 勤務状況 my勤務状況;
    private 勤務区分 my勤務区分;
    private 場所区分 my場所区分;
    private 状態区分 my状態区分;
    private ArrayList<String> my勤務区分list = new ArrayList<>();

    public void 勤務状況(String my勤務状況) {
        try {
            this.my勤務状況 = 勤務状況.valueOf(my勤務状況);
        } catch (IllegalArgumentException e) {
            System.out.println("その値は勤務状況には存在しません");
        }
   }
    public ArrayList<String> 勤務区分(){
        String my勤務状況 = this.my勤務状況.toString();
        if(my勤務状況.equals(勤務状況.テレワーク)){ 勤務区分のテレワーク設定(); };
        if(my勤務状況.equals(勤務状況.出社)){};
        if(my勤務状況.equals(勤務状況.非出社)){};
        return my勤務区分list;
    }
    private void 勤務区分のテレワーク設定(){
        my勤務区分list.add(勤務区分.フル出勤.toString());
        my勤務区分list.add(勤務区分.午前休.toString());
        my勤務区分list.add(勤務区分.午後休.toString());
    }

}