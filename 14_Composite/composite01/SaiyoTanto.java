package composite01;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

interface CategoryEntry{
    public void hyouka();
}

class Skill implements CategoryEntry{
    private String name = null;
    public Skill(String name){
        this.name = name;
    }
    public void hyouka(){
        System.out.println("　" + name + "をプラスに評価しました");
    }
}

class Category implements CategoryEntry{
    private List<CategoryEntry> list = null;
    private String name = null;
    public Category(String name){
        this.name = name;
        list = new ArrayList<CategoryEntry>();
    }
    public void add(CategoryEntry entry){
        list.add(entry);
    }
    public void hyouka(){
        Iterator<CategoryEntry> itr = list.iterator();
        while(itr.hasNext()){
            CategoryEntry entry = itr.next();
            entry.hyouka();
        }
        System.out.println(name + "をプラスに評価しました。");
    }
}

class Age implements CategoryEntry{
    private String name = null;
    public Age(String name) {
        this.name = name;
    }
    public void hyouka(){
        System.out.println("　" + name + "をプラスに評価しました");
    }
}

class SaiyoTanto {
    public static void main(String args[]){
        Skill skill1 = new Skill("TCP/IP");
        Skill skill2 = new Skill("Linux");
        Skill skill3 = new Skill("WindowsServer");
        Category cate1 = new Category("ネットワークスキル");
        cate1.add(skill1);
        cate1.add(skill2);
        cate1.add(skill3);

        Skill skill4 = new Skill("AWS");
        Category cate2 = new Category("クラウドスキル");
        cate2.add(skill4);

        Skill skill5 = new Skill("VB.NET");
        Skill skill6 = new Skill("C#");
        Category cate3 = new Category("プログラミングスキル");
        cate3.add(skill5);
        cate3.add(skill6);

        Age age1 = new Age("40代");
        Category cate4 = new Category("ベテラン");
        cate4.add(age1);
         
        cate1.hyouka();
        cate2.hyouka();
        cate3.hyouka();
        cate4.hyouka();

    }
}