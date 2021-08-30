import java.util.*;
 
class Onabe{
 
    private String soup;
    private String niku;
    private List<String> oyasaiTachi;
    private List<String> otherGoo;

    public Onabe(){ }
    public void addSoup(String soup){
        this.soup = soup;
    }
    public void addMain(String niku){
        this.niku = niku;
    }
    public void addOyasaiTachi(List<String> oyasaiTachi){
        this.oyasaiTachi = oyasaiTachi;
    }
    public void addOtherGoo(List<String> otherGoo){
        this.otherGoo = otherGoo;
    }

    public List<String> getShokuZaiList(){
        List<String> shokuZaiList = new ArrayList<String>();

        shokuZaiList.add(this.soup);
        shokuZaiList.add(this.niku);
        shokuZaiList.addAll(this.oyasaiTachi);
        shokuZaiList.addAll(this.otherGoo);

        return shokuZaiList;
    }
}

abstract class Factory{
    public abstract String getSoup();
    public abstract String getMain();
    public abstract List<String> getOyasaiTachi();
    public abstract List<String> getOtherGoo();
}

class CurryFactory extends Factory{
    public String getSoup(){
        return "甘口カレー";
    }
    public String getMain(){
        return "ぶたにく";
    }
    public List<String> getOyasaiTachi(){
        List<String> oyasaiTachi = new ArrayList<String>();
        oyasaiTachi.add("にんじん");
        oyasaiTachi.add("たまねぎ");
        oyasaiTachi.add("じゃがいも");
        return oyasaiTachi;
    }
    public List<String> getOtherGoo(){
        List<String> otherGoo = new ArrayList<String>();
        otherGoo.add("牛乳");
        otherGoo.add("うどん");
        return otherGoo;
    }
}

class SityuuFactory extends Factory{
    public String getSoup(){
        return "まろやかシチュー";
    }
    public String getMain(){
        return "ぎゅうにく";
    }
    public List<String> getOyasaiTachi(){
        List<String> oyasaiTachi = new ArrayList<String>();
        oyasaiTachi.add("にんじん");
        oyasaiTachi.add("たまねぎ");
        oyasaiTachi.add("じゃがいも");
        return oyasaiTachi;
    }
    public List<String> getOtherGoo(){
        List<String> otherGoo = new ArrayList<String>();
        otherGoo.add("チーズ");
        otherGoo.add("カリカリぱん");
        return otherGoo;
    }
}

class YamiNabeFactory extends Factory{
    public String getSoup(){
        return "カガミ家恐怖の闇鍋";
    }
    public String getMain(){
        return "たわし";
    }
    public List<String> getOyasaiTachi(){
        List<String> oyasaiTachi = new ArrayList<String>();
        oyasaiTachi.add("にんじん(プラスチック)");
        oyasaiTachi.add("たまねぎ(プラスチック)");
        oyasaiTachi.add("じゃがいも(プラスチック)");
        return oyasaiTachi;
    }
    public List<String> getOtherGoo(){
        List<String> otherGoo = new ArrayList<String>();
        otherGoo.add("ハバネロ");
        otherGoo.add("青汁");
        return otherGoo;
    }
}

class Pure{
    public static void main(String args[]){
        String menu = args[0];

        Onabe le_Creuset = new Onabe();
        Factory factory = createFactory(menu);

        le_Creuset.addSoup(factory.getSoup());
        le_Creuset.addMain(factory.getMain());
        le_Creuset.addOyasaiTachi(factory.getOyasaiTachi());
        le_Creuset.addOtherGoo(factory.getOtherGoo());

        System.out.println("今日のレシピは・・・\n");

        List<String> list = le_Creuset.getShokuZaiList();
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        
        if(factory.getSoup().contains("闇")){
            System.out.println("\n・・・でした(T∀T)");
        }else{
            System.out.println("\n・・・でした♪");
        }
    }
    private static Factory createFactory(String str){
        if("カレー鍋".equals(str)){
            return new CurryFactory();
        }else if("シチュー鍋".equals(str)){
            return new SityuuFactory();
        }else{
            return new YamiNabeFactory();
        }
    }
}
