/**
 * 処理対象を表すインタフェース
 * Operand 意味：処理対象。今回はWordPressやnoteなど。
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
 * Ingredient 意味：材料、構成要素。今回はWordPressやnoteなど。
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
     * @return  operandString
     */
    public String getOperandString() {
        return this.operandString;
    }
}

/**
 * 処理結果を表すクラス
 * Expression 意味：表現(すること)。今回は処理後の処理対象。
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
     * @return  operandString
     */
    public String getOperandString() {
        return operator.execute().getOperandString();
    }
}

/**
 * 処理を表すインタフェース
 * Operator 意味：処理(すること)。今回は足したり、挿入したり、レビューしたり。
 */
interface Operator {
    /**
     * 実行結果の operand を返すメソッド
     * @return operand
     */
    public Operand execute();
}

/**
 * 挿入する処理を表すクラス
 */
class Add implements Operator {
    private Operand operand1 = null;
    private Operand operand2 = null;
 
    /**
     * 追加する側とされる側の２つの operand を引数に取るコンストラクタ
     * @param operand1
     * @param operand2
     */
    public Add(Operand operand1, Operand operand2) {
        this.operand1 = operand1;
        this.operand2 = operand2;
    }
 
    /**
     * 処理を実行するメソッド
     * @return string
     */
    public Operand execute() {
        return new Ingredient(operand1.getOperandString() + "に"
                + operand2.getOperandString() + "を挿入したもの");
    }
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
        return new Ingredient(operand1.getOperandString() + "に"
                + operand2.getOperandString() + "を足したもの");
    }
}

/**
 * 「レビュー」という処理を表すクラス
 */
class Review implements Operator {
 
    private int minutes = -1;
    private Operand operand = null;
 
    /**
     * 足される2つの operand を引数に取るコンストラクタ
     * @param minutes
     * @param operand
     */
    public Review(int minutes, Operand operand) {
        this.minutes = minutes;
        this.operand = operand;
    }
 
    /**
     * 処理を実行するメソッド
     * @return string
     */
    public Operand execute() {
        return new Ingredient(operand.getOperandString() + "を" + minutes
                + "分レビューしたもの");
    }
}

/**
 * 「直す」という処理を表すクラス
 */
class Fixed implements Operator {
 
    private Operand operand = null;
 
    /**
     * 1つの operand を引数に取るコンストラクタ
     * @param operand
     */
    public Fixed(Operand operand) {
        this.operand = operand;
    }
 
    /**
     * 処理を実行するメソッド
     * @return string
     */
    public Operand execute() {
        return new Ingredient(operand.getOperandString() + "に対して"
                + "ご指摘通り直したもの");
    }
}

class Pure{
    public static void main(String args[]){

        //処理途中をつど出力する
        System.out.println("--処理過程をつどSystem.out.printlnで出力--");

        //noteに漫画を挿入する
        Operand  note  = new Ingredient("noteの有料記事");
        Operand  manga = new Ingredient("漫画");
        Operator add1  = new Add(note,manga);
        note = add1.execute();

        System.out.println(note.getOperandString());

        //販促にWordPressでブログを書く
        Operand  blog   = new Ingredient("WordPressブログ");
        Operator plus1  = new Plus(note,blog);
        note = plus1.execute();

        System.out.println(note.getOperandString());

        //ビューティーさんがレビューをする
        Operator beauty = new Review(20,note);
        note = beauty.execute();

        System.out.println(note.getOperandString());

        //レビュー結果を直したもの
        Operator fixed = new Fixed(note);
        note = fixed.execute();

        System.out.println(note.getOperandString());

        //処理結果を表すクラスで再確認。
        System.out.println("\n\n--処理結果を表すExpressionクラスで再度出力--");
        System.out.println(new Expression(add1).getOperandString());
        System.out.println(new Expression(plus1).getOperandString());
        System.out.println(new Expression(beauty).getOperandString());
        System.out.println(new Expression(fixed).getOperandString());

    }
}