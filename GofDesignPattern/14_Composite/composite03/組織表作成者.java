package composite03;

import java.util.*;

interface 組織階層{
    public void 組織一覧表();
}

class 社長 implements 組織階層{

    private List<組織階層> list = null;
    private int level = 1;
    private String 階層名 = null;
    private String 組織名 = null;

    public 社長(int level, String 階層名, String 組織名){
        this.level = level;
        this.階層名 = 階層名;
        this.組織名 = 組織名;
        list = new ArrayList<組織階層>();
    }

    public int 階層数(){return this.level;}

    public void add(事業部 entry){
        list.add(entry);
    }

    public void 組織一覧表(){

        System.out.println(
                new 樹形図作成(this.level,this.階層名,this.組織名).実行()
        );

        new 組織一覧表作成(list).実行();
    }
}

class 事業部 implements 組織階層{

    private List<組織階層> list = null;
    private int level = 2;
    private String 階層名 = null;
    private String 組織名 = null;

    public 事業部(int level ,String 階層名, String 組織名){
        this.level = level;
        this.階層名 = 階層名;
        this.組織名 = 組織名;
        list = new ArrayList<組織階層>();
    }

    public int 階層数(){return this.level;}

    public void add(地域 entry){
        list.add(entry);
    }

    public void 組織一覧表(){

        System.out.println(
                new 樹形図作成(this.level,this.階層名,this.組織名).実行()
        );

        new 組織一覧表作成(list).実行();
    }
}

class 地域 implements 組織階層{

    private List<組織階層> list = null;
    private int level = 3;
    private String 階層名 = null;
    private String 組織名 = null;

    public 地域( int level, String 階層名, String 組織名){

        if(new 地域チェック(組織名).判定() == false){
            throw new RuntimeException("地域名が間違っております");
        }

        this.level = level;
        this.階層名 = 階層名;
        this.組織名 = 組織名;
        list = new ArrayList<組織階層>();

    }

    public int 階層数(){return this.level;}

    public void add(部門 entry){
        list.add(entry);
    }

    public void 組織一覧表(){

        System.out.println(
                new 樹形図作成(this.level,this.階層名,this.組織名).実行()
        );

        new 組織一覧表作成(list).実行();
    }
}

class 部門 implements 組織階層{

    private List<組織階層> list = null;
    private int level = 4;
    private String 階層名 = null;
    private String 組織名 = null;

    public 部門( int level, String 階層名, String 組織名){
        this.level = level;
        this.階層名 = 階層名;
        this.組織名 = 組織名;
    }

    public int 階層数(){return this.level;}

    public void add(組織階層 entry){
        list.add(entry);
    }

    public void 組織一覧表(){

        System.out.println(
                new 樹形図作成(this.level,this.階層名,this.組織名).実行()
        );

        new 組織一覧表作成(list).実行();
    }
}

class 地域チェック{
    String 地域名 = null;

    地域チェック(String 地域名){ this.地域名 = 地域名; }

    public boolean 判定(){
        Boolean 判定結果 = false;

        switch (地域名){
            case "北海道":
                判定結果=true;
                break;
            case "東北":
                判定結果=true;
                break;
            case "北陸":
                判定結果=true;
                break;
            case "北関東":
                判定結果=true;
                break;
            case "南関東":
                判定結果=true;
                break;
        }

        return 判定結果;
    }
}

class 樹形図作成{

    private int level = 0;
    private String 階層名 = null;
    private String 組織名 = null;

    樹形図作成(int level,String 階層名,String 組織名){
        this.level = level;
        this.階層名 = 階層名;
        this.組織名 = 組織名;
    }

    public String 実行(){
        String Branch = null;
        String leaf = 階層名 + ":" + 組織名;
        String root = 組織名;

        switch (level){
            case 1:
                Branch = root;
                break;
            case 2:
                Branch = "\t" + leaf;
                break;
            case 3:
                Branch = "\t" + "\t" + leaf;
                break;
            case 4:
                Branch = "\t" + "\t" + "\t" + leaf;
                break;
        }
        return  Branch;
    }
}

class 組織一覧表作成 {
    private List<組織階層> list = null;

    組織一覧表作成(List<組織階層> list){
        this.list = list;
    }

    public void 実行(){
        if(list == null){ return; }

        Iterator<組織階層> itr = list.iterator();
        while(itr.hasNext()){
            組織階層 entry = itr.next();
            entry.組織一覧表();
        }
    }
}

class 組織表作成者 {
    public static void main(String args[]){

        部門   部門_営業部門 = new 部門(4,"部門","営業部門");
        部門   部門_生産部門 = new 部門(4,"部門","生産部門");

        地域   地域_北海道   = new 地域(3,"地域","北海道");
        地域   地域_東北     = new 地域(3,"地域","東北");
        地域   地域_北陸     = new 地域(3,"地域","北陸");

        事業部 事業部_環境デザイン事業部  = new 事業部(2,"事業部","環境デザイン事業部");
        事業部 事業部_IoT推進事業部     = new 事業部(2,"事業部","Iot推進事業部");
        事業部 事業部_クラウド事業部     = new 事業部(2,"事業部","クラウド事業部");

        社長   社長 = new 社長(1,"","社長");

        地域_北海道.add(部門_営業部門);
        地域_東北.add(部門_営業部門);
        地域_東北.add(部門_生産部門);
        地域_北陸.add(部門_営業部門);

        事業部_環境デザイン事業部.add(地域_東北);
        事業部_IoT推進事業部.add(地域_北海道);
        事業部_IoT推進事業部.add(地域_東北);
        事業部_クラウド事業部.add(地域_北海道);
        事業部_クラウド事業部.add(地域_東北);
        事業部_クラウド事業部.add(地域_北陸);

        社長.add(事業部_環境デザイン事業部);
        社長.add(事業部_IoT推進事業部);
        社長.add(事業部_クラウド事業部);

        //組織一覧表を作成!!
        社長.組織一覧表();
    }
}