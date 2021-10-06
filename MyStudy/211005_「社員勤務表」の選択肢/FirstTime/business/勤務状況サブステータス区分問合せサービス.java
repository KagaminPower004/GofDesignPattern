package business;

import domain.勤務状況;

import java.util.ArrayList;

public class 勤務状況サブステータス区分問合せサービス {

    private 勤務状況 my勤務状況;
    private ArrayList<String> my勤務状況サブステータス区分list = new ArrayList<>();

    public 勤務状況サブステータス区分問合せサービス(String my勤務状況){
        try {
            this.my勤務状況 = 勤務状況.valueOf(my勤務状況);
        } catch (IllegalArgumentException e) {
            System.out.println("その値は勤務状況には存在しません");
        }
    }
    public ArrayList<String> 勤務状況サブステータス区分(){
        if(this.my勤務状況.equals(勤務状況.テレワーク))  { 勤務区分のテレワーク設定(); }
        if(this.my勤務状況.equals(勤務状況.出社))       { 勤務区分の出社設定(); }
        if(this.my勤務状況.equals(勤務状況.非出社))      { 勤務区分の非出社設定(); }
        return my勤務状況サブステータス区分list;
    }
    private void 勤務区分のテレワーク設定(){
        my勤務状況サブステータス区分list.add(勤務状況サブステータス区分.社外.toString());
    }

    private void 勤務区分の出社設定(){
        my勤務状況サブステータス区分list.add(勤務状況サブステータス区分.社内.toString());
    }

    private void 勤務区分の非出社設定(){
        my勤務状況サブステータス区分list.add(勤務状況サブステータス区分.非稼働.toString());
    }
}