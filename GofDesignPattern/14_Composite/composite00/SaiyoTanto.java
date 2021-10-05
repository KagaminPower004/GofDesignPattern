package composite00;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

class Skill{
    private String name = null;
    public Skill(String name){
        this.name = name;
    }
    public void hyouka(){
        System.out.println("　" + name + "をプラスに評価しました");
    }
}

class Category{
    private List<Object> list = null;
    private String name = null;
    public Category(String name){
        this.name = name;
        list = new ArrayList<Object>();
    }
    public void add(Skill Skill){
        list.add(Skill);
    }
    public void add(Category dir){
        list.add(dir);
    }
    public void hyouka(){
        Iterator<Object> itr = list.iterator();
        while(itr.hasNext()){
            Object obj = itr.next();
            if(obj instanceof Skill){
                ((Skill)obj).hyouka();
            }else if(obj instanceof Category){
                ((Category)obj).hyouka();
            }else{
                System.out.println("プラスに評価できません");
            }
        }
        System.out.println(name + "をプラスに評価しました。");
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
         
        cate1.hyouka();
        cate2.hyouka();
        cate3.hyouka();
    }
}