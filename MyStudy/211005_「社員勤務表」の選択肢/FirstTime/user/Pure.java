package user;

import business.勤務区分問合せサービス;
import business.勤務状況サブステータス区分問合せサービス;
import java.util.ArrayList;

public class Pure {
    private static ArrayList<String> my勤務区分list = new ArrayList<>();
    private static ArrayList<String> my勤務状況サブステータス区分list = new ArrayList<>();

    public static void main(String args[]){
        final String my勤務状況 = args[0];

        勤務区分問合せ(my勤務状況);
        勤務状況サブステータス区分問合せ(my勤務状況);
    }

    private static void 勤務区分問合せ(String my勤務状況){
        System.out.println("『勤務状況』が" + my勤務状況 + "の場合、該当する『勤務区分』は");
        勤務区分問合せサービス my勤怠問合せ = new 勤務区分問合せサービス(my勤務状況);

        my勤務区分list = my勤怠問合せ.勤務区分();
        for (String s : my勤務区分list) {
            System.out.println("  ●" + s);
        }
        System.out.println("です。");
    }

    private static void 勤務状況サブステータス区分問合せ(String my勤務状況){
        System.out.println("『勤務状況』が" + my勤務状況 + "の場合、該当する『勤務状況サブステータス区分』は");
        勤務状況サブステータス区分問合せサービス my勤務状況サブステータス区分
                = new 勤務状況サブステータス区分問合せサービス(my勤務状況);

        my勤務状況サブステータス区分list = my勤務状況サブステータス区分.勤務状況サブステータス区分();
        for (String s : my勤務状況サブステータス区分list) {
            System.out.println("  ●" + s);
        }
        System.out.println("です。");
    }
}