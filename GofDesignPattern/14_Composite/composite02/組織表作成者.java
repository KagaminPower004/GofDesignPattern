package composite02;

import java.util.*;

interface 組織階層{
    public void 組織一覧表();
}

class 組織 implements 組織階層{

    private List<組織階層> list = null;
    private int level = 0;
    private String 階層名 = null;
    private String 組織名 = null;

    public 組織(int level,String 階層名,String 組織名){
        this.level = level;
        this.階層名 = 階層名;
        this.組織名 = 組織名;
        list = new ArrayList<組織階層>();
    }

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
        Iterator<組織階層> itr = list.iterator();
        while(itr.hasNext()){
            組織階層 entry = itr.next();
            entry.組織一覧表();
        }
    }
}

class 組織表作成者 {
    public static void main(String args[]){

        組織 階層4_組織1 = new 組織(4,"部門","営業部門");
        組織 階層4_組織2 = new 組織(4,"部門","生産部門");

        組織 階層3_組織1 = new 組織(3,"地域","北海道");
        組織 階層3_組織2 = new 組織(3,"地域","東北");
        組織 階層3_組織3 = new 組織(3,"地域","北陸");

        階層3_組織1.add(階層4_組織1);
        階層3_組織2.add(階層4_組織1);
        階層3_組織2.add(階層4_組織2);
        階層3_組織3.add(階層4_組織1);

        組織 階層2_組織1 = new 組織(2,"事業部","環境デザイン事業部");
        組織 階層2_組織2 = new 組織(2,"事業部","Iot推進事業部");
        組織 階層2_組織3 = new 組織(2,"事業部","クラウド事業部");

        階層2_組織1.add(階層3_組織2);
        階層2_組織2.add(階層3_組織1);
        階層2_組織2.add(階層3_組織2);
        階層2_組織3.add(階層3_組織1);
        階層2_組織3.add(階層3_組織2);
        階層2_組織3.add(階層3_組織3);

        組織 階層1 = new 組織(1,"","社長");

        階層1.add(階層2_組織1);
        階層1.add(階層2_組織2);
        階層1.add(階層2_組織3);

        階層1.組織一覧表();
    }
}