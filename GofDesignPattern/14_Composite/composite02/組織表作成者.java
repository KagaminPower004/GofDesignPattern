package composite02;

import java.util.*;

interface 組織階層{
    public void 組織一覧表();
}

class 組織名 implements 組織階層{
    private List<組織階層> list = null;
    private String name = null;

    public 組織名(String name){
        this.name = name;
        list = new ArrayList<組織階層>();
        Collections.sort(list,null);
    }

    public void add(組織階層 entry){
        list.add(entry);
    }

    public void 組織一覧表(){
        System.out.println( name );

        Iterator<組織階層> itr = list.iterator();
        while(itr.hasNext()){
            組織階層 entry = itr.next();
            entry.組織一覧表();
        }
    }
}

class 組織表作成者 {
    public static void main(String args[]){

        組織名 階層4_組織1 = new 組織名("      営業部門");
        組織名 階層4_組織2 = new 組織名("      生産部門");

        組織名 階層3_組織1 = new 組織名("    北海道");
        組織名 階層3_組織2 = new 組織名("    東北");
        組織名 階層3_組織3 = new 組織名("    北陸");
        階層3_組織1.add(階層4_組織1);
        階層3_組織2.add(階層4_組織1);
        階層3_組織2.add(階層4_組織2);
        階層3_組織3.add(階層4_組織1);

        組織名 階層2_組織名1 = new 組織名("  環境デザイン事業部");
        組織名 階層2_組織名2 = new 組織名("  Iot推進事業部");
        組織名 階層2_組織名3 = new 組織名("  クラウド事業部");
        階層2_組織名1.add(階層3_組織2);
        階層2_組織名2.add(階層3_組織1);
        階層2_組織名2.add(階層3_組織2);
        階層2_組織名3.add(階層3_組織1);
        階層2_組織名3.add(階層3_組織2);
        階層2_組織名3.add(階層3_組織3);

        組織名 階層1 = new 組織名("社長");
        階層1.add(階層2_組織名1);
        階層1.add(階層2_組織名2);
        階層1.add(階層2_組織名3);

        階層1.組織一覧表();

    }
}