/**
 * 処理対象を表すインタフェース
 */
interface Operand {
    /**
     * 処理対象を表す文字列を返すメソッドです。
     * @return operandString
     */
    public String getOperandString();
 
}

/**
 * 処理対象を表すクラス
 */
class Ingredient implements Operand {
    /**
     * この処理対象を表す文字列
     */
    private String operandString = null;
 
    /**
     * 処理対象を表す文字列を引数に取るコンストラクタ
     * @param operandString
     */
    public Ingredient(String operandString) {
        this.operandString = operandString;
    }
 
    /**
     * 処理対象を表す文字列を返すメソッド
     * @return　operandString
     */
    public String getOperandString() {
        return this.operandString;
    }
}

/**
 * 処理結果を表すクラス
 */
class Expression implements Operand {
    /**
     * operator
     */
    private Operator operator = null;
 
    /**
     * 処理内容を表す operator を引数に取るコンストラクタ
     * @param operator
     */
    public Expression(Operator operator) {
        this.operator = operator;
    }
 
    /**
     * 処理の結果得られる Operand の文字列表現を返すメソッド
     * @return　operandString
     */
    public String getOperandString() {
        return operator.execute().getOperandString();
    }
}

/**
 * 処理を表すインタフェース
 */
interface Operator {
    /**
     * 実行結果の operand を返すメソッド
     * @return operand
     */
    public Operand execute();
}

/**
 * 足し合わせる処理を表すクラス
 */
class Plus implements Operator {
    private Operand operand1 = null;
    private Operand operand2 = null;
 
    /**
     * 足される2つの operand を引数に取るコンストラクタ
     * @param operand1
     * @param operand2
     */
    public Plus(Operand operand1, Operand operand2) {
        this.operand1 = operand1;
        this.operand2 = operand2;
    }
 
    /**
     * 処理を実行するメソッド
     * @return string
     */
    public Operand execute() {
        return new Ingredient(operand1.getOperandString() + "と"
                + operand2.getOperandString() + "を足したもの");
    }
}

/**
 * 「待つ」という処理を表すクラス
 */
class Wait implements Operator {
 
    private int minutes = -1;
    private Operand operand = null;
 
    /**
     * 足される2つの operand を引数に取るコンストラクタ
     * @param minutes
     * @param operand
     */
    public Wait(int minutes, Operand operand) {
        this.minutes = minutes;
        this.operand = operand;
    }
 
    /**
     * 処理を実行するメソッド
     * @return string
     */
    public Operand execute() {
        return new Ingredient(operand.getOperandString() + "を" + minutes
                + "分置いたもの");
    }
}

class Test{
    public static void main(String args[]){
        //カップ麺に粉末スープを入れる
        Operand  cupMen   = new Ingredient("カップ麺");
        Operand  funMatsu = new Ingredient("粉末スープ");
        Operator plus1     = new Plus(cupMen,funMatsu);
        cupMen = plus1.execute();

        System.out.println(cupMen.getOperandString());

        Operand  oYu   = new Ingredient("お湯");
        Operator plus2     = new Plus(cupMen,oYu);
        cupMen = plus2.execute();

        System.out.println(cupMen.getOperandString());

        Operator wait     = new Wait(3,cupMen);
        cupMen = wait.execute();

        Operand  siRu = new Ingredient("液体スープ");
        Operator plus3     = new Plus(cupMen,siRu);
        cupMen = plus3.execute();

        System.out.println(cupMen.getOperandString());

    }
}