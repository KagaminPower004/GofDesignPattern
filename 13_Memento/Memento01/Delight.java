import java.util.HashMap;
import java.util.Map;

/**
 * ひとつの計算を表すクラス。
 */
class Calc {
    private int temp = 0;

    /**
     * 足し算を実行するメソッド
     * パラメーター plus
     */
    public void plus(int plus) {
        temp += plus;
    }

    /**
     * 途中経過を Memento として取得するメソッド
     * 戻り値 memento
     */
    public Memento createMemento() {
        return new Memento(temp);
    }
 
    /**
     * Memento から計算経過を取得して、temp にセットする
     * パラメーター memento
     */
    public void setMemento(Memento memento) {
        this.temp = memento.getResult();
    }

    /**
     * 計算前にtemp に初期値をセットする
     * パラメーター temp
     */
    public void setTemp(int temp) {
        this.temp = temp;
    }

    /**
     * 計算結果を取得するメソッド
     * 戻り値 temp
     */
    public int getTemp() {
        return this.temp;
    }
}

/**
 * 途中経過を保持する Memento クラス
 */
class Memento {
        /** 計算の途中経過を表す */
        private int result = -1;

        /**
         * 計算経過を引数に受け取るコンストラクタ
         * パラメーター temp
         */
        Memento(int temp) {
            this.result = temp;
        }

        /**
         * 計算経過を取得するメソッド
         * 戻り値 result
         */
        public int getResult(){ return this.result; }
}

class Delight {
    private static Map<String,Memento> map = new HashMap<String,Memento>();

    /**
     * 計算を実行するクラス
     * '@param args[0]:誕生年 ,args[1]:経過年数
     */
    public static void main(String args[]) {
        int birthYear = Integer.parseInt(args[0]);
        int addYears  = Integer.parseInt(args[1]);

        Calc calc = new Calc();
        calc.setTemp(birthYear);
        calc.plus(addYears);

        System.out.println( "あなたの誕生年）  西暦：" + birthYear + "年");

        //計算結果メッセージ：例）『"そこから" + addYears + "年経つと西暦：●●年"』
        final String calcResultMessage = calcResultMessage(addYears,calc.getTemp());
        System.out.println( calcResultMessage );
        //Mementoインスタンスを作成してmapに格納する
        map.put( calcResultMessage, calc.createMemento());

        // プラス10歳のときの西暦を知りたい
        Calc calc2 = new Calc();
        calc2.setMemento(map.get( calcResultMessage ));
        calc2.plus(10);
        addYears = 10;

        //計算結果メッセージその②：例）『"そこから" + addYears + "年経つと西暦：●●年"』
        final String calcResultMessage2 = calcResultMessage(addYears,calc2.getTemp());
        System.out.println( calcResultMessage2 );
        //Mementoインスタンスを作成してmapに格納する
        map.put( calcResultMessage2, calc2.createMemento() );

        // プラス60歳のときの西暦を知りたい
        Calc calc3 = new Calc();
        calc3.setMemento(map.get( calcResultMessage2 ));
        calc3.plus(60);
        addYears = 60;

        //計算結果メッセージその③：例）『"そこから" + addYears + "年経つと西暦：●●年"』
        final String calcResultMessage3 = calcResultMessage(addYears,calc3.getTemp());
        System.out.println( calcResultMessage3 );
        //Mementoインスタンスを作成してmapに格納する
        map.put(calcResultMessage3, calc3.createMemento());
    }

     private static String calcResultMessage(int addYears,int resultYears){

        return "そこから" + addYears + "年経つと西暦：" + resultYears + "年";
    }
}