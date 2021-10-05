package user;

import business.勤怠問合せサービス;
import java.util.ArrayList;
import java.util.Iterator;

public class Pure {
    private static ArrayList<String> my勤務区分list = new ArrayList<>();

    public static void main(String args[]){
        勤怠問合せサービス my勤怠問合せ = new 勤怠問合せサービス();

        my勤怠問合せ.勤務状況("テレワーク");
        my勤務区分list = my勤怠問合せ.勤務区分();
        for (String s : my勤務区分list) {
            System.out.println(s);
        }
    }
}