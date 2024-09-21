package flyweight_org;

import java.util.HashMap;
import java.util.Map;

class HumanLetter{
    String letter;
    HumanLetter(String letter){
        this.letter = letter;
    }
    String getLetter(){return this.letter;}
}

/**
 * 人文字を管理するクラス。
 * Singleton とする。
 */
class HumanLetterFactory {
    /**
     * 人文字のマップ
     */
    Map<String,HumanLetter> map = new HashMap<String,HumanLetter>();

    /**
     * Singleton の生成
     */
    private static HumanLetterFactory singleton = new HumanLetterFactory();

    /**
     * Singleton パターン
     */
    private HumanLetterFactory() {}

    /**
     * インスタンスを取得するメソッド
     * 唯一のインスタンスが返される。
     * @return singleton
     */
    public HumanLetterFactory getInstance() {
        return singleton;
    }

    /**
     * 人文字を取得するメソッド。
     * すでに持っているものであれば、map から返す。
     * map に持っていないものは生成して map への登録を行った後に返り値として返す。
     *
     * @param letter
     * @return humanLetter
     */
    public synchronized HumanLetter getHumanLetter(String letter) {
        HumanLetter humanLetter = map.get(letter);
        if (humanLetter == null) {
            humanLetter = new HumanLetter(letter);
            map.put(letter, humanLetter);
        }
        return humanLetter;
    }

}

/**
 * 人文字を作成して出力するクラス。
 */
public class Main {
    /**
     * 人文字を作成するメイン関数
     * @param args
     */
    public static void main(String args[]) {

        long start = System.currentTimeMillis();

        HumanLetter あ = new HumanLetter("あ");
        takeAPhoto(あ);
        HumanLetter い = new HumanLetter("い");
        takeAPhoto(い);
        HumanLetter は = new HumanLetter("は");
        takeAPhoto(は);
        takeAPhoto(あ);
        takeAPhoto(い);
        HumanLetter よ = new HumanLetter("よ");
        takeAPhoto(よ);
        HumanLetter り = new HumanLetter("り");
        takeAPhoto(り);
        HumanLetter も = new HumanLetter("も");
        takeAPhoto(も);
        takeAPhoto(あ);
        HumanLetter お = new HumanLetter("お");
        takeAPhoto(お);
        takeAPhoto(い);

        long end = System.currentTimeMillis();
        System.out.println("(処理時間:" + (end - start) + "ミリ秒)");
    }

    /**
     * 写真を撮るメソッド
     * @param letter
     */
    private static void takeAPhoto(HumanLetter letter) {
        System.out.println(letter.getLetter());
    }

}

/**
 * 人文字を作成して出力するクラス。
 */
class Main2 {
    /**
     * 人文字を作成するメイン関数
     * @param args
     */
    public static void main(String args[]) {

        long start = System.currentTimeMillis();

        HumanLetter あ = new HumanLetter("あ");
        takeAPhoto(あ);
        HumanLetter い = new HumanLetter("い");
        takeAPhoto(い);
        HumanLetter は = new HumanLetter("は");
        takeAPhoto(は);
        HumanLetter あ2 = new HumanLetter("あ");
        takeAPhoto(あ2);
        HumanLetter い2 = new HumanLetter("い");
        takeAPhoto(い2);
        HumanLetter よ = new HumanLetter("よ");
        takeAPhoto(よ);
        HumanLetter り = new HumanLetter("り");
        takeAPhoto(り);
        HumanLetter も = new HumanLetter("も");
        takeAPhoto(も);
        HumanLetter あ3 = new HumanLetter("あ");
        takeAPhoto(あ3);
        HumanLetter お = new HumanLetter("お");
        takeAPhoto(お);
        HumanLetter い3 = new HumanLetter("い");
        takeAPhoto(い3);

        long end = System.currentTimeMillis();
        System.out.println("(処理時間:" + (end - start) + "ミリ秒)");
    }

    /**
     * 写真を撮るメソッド
     * @param letter
     */
    private static void takeAPhoto(HumanLetter letter) {
        System.out.println(letter.getLetter());
    }

}


