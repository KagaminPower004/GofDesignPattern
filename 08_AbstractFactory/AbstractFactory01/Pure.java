import java.util.*;

abstract class Soup{
    public abstract String getName();
}

class CurrySoup extends Soup{

    private String name = "カレー";
    private String taste = "";

    public CurrySoup(int taste_level){

        if(taste_level == 1){ this.taste = "甘口"; }
        else if(taste_level == 2){ this.taste = "中辛"; }
        else if(taste_level == 3){ this.taste = "辛口"; }
        else { this.taste = "なぞ"; }
    }

    public String getName(){
        return taste + name;
    }
}

class SityuuSoup extends Soup{

    private String name = "シチュー";
    private String taste = "";

    public SityuuSoup(int taste_level){

        if(taste_level == 1){ this.taste = "まろやか"; }
        else if(taste_level == 2){ this.taste = "ほどよい"; }
        else if(taste_level == 3){ this.taste = "こってり"; }
        else { this.taste = "なぞ"; }
    }

    public String getName(){
        return taste + name;
    }
}

class YamiNabeSoup extends Soup{

    private String name = "闇鍋スープ";
    private String taste = "";

    public YamiNabeSoup(int taste_level){

        if(taste_level == 1){ this.taste = "ややマズ"; }
        else if(taste_level == 2){ this.taste = "マズマズ"; }
        else if(taste_level == 3){ this.taste = "激マズ"; }
        else { this.taste = "なぞ"; }
    }

    public String getName(){
        return taste + name;
    }
}

abstract class Main{
    public abstract String getName();
}

class Pork extends Main{
    private String name = "ぶたにく";
    public String getName(){
        return name;
    }
}

class Beef extends Main{
    private String name = "ぎゅうにく";
    public String getName(){
        return name;
    }
}

class Tawashi extends Main{
    private String name = "たわし";
    public String getName(){
        return name;
    }
}

abstract class Oyasai{
    public abstract String getName();
}

class Carrot extends Oyasai{

    private String name = "にんじん";
    public String getName(){
        return name;
    }
}

class Onion extends Oyasai{

    private String name = "たまねぎ";
    public String getName(){
        return name;
    }
}

class Potato extends Oyasai{

    private String name = "じゃがいも";
    public String getName(){
        return name;
    }
}

abstract class FakeOyasai extends Oyasai{
    public abstract String getName();
}

class PlasticCarrot extends FakeOyasai{

    private String name = "にんじん(※プラスチック)";
    public String getName(){
        return name;
    }
}

class PlasticOnion extends FakeOyasai{

    private String name = "たまねぎ(※プラスチック)";
    public String getName(){
        return name;
    }
}

class PlasticPotato extends FakeOyasai{

    private String name = "じゃがいも(※プラスチック)";
    public String getName(){
        return name;
    }
}

abstract class OtherGoo{
    public abstract String getName();
}

class Milk extends OtherGoo{

    private String name = "牛乳";
    public String getName(){
        return name;
    }
}

class Udon extends OtherGoo{

    private String name = "うどん";
    public String getName(){
        return name;
    }
}

class Cheese extends OtherGoo{

    private String name = "チーズ";
    public String getName(){
        return name;
    }
}

class Bread extends OtherGoo{

    private String name = "パン";
    private String taste = "";

    public Bread(int taste_level){

        if(taste_level == 1){ this.taste = "やわらか"; }
        else if(taste_level == 2){ this.taste = "さくさく"; }
        else if(taste_level == 3){ this.taste = "カリカリ"; }
        else { this.taste = "なぞ"; }
    }

    public String getName(){
        return taste + name;
    }
}

class Habanero extends OtherGoo{

    private String name = "ハバネロ";
    public String getName(){
        return name;
    }
}

class GreenJuice extends OtherGoo{

    private String name = "あおぢる";
    public String getName(){
        return name;
    }
}

class Onabe{

    private Soup soup;
    private Main niku;
    private List<Oyasai> oyasaiTachi;
    private List<OtherGoo> otherGooTachi;

    public Onabe(){ }
    public void addSoup(Soup soup){
        this.soup = soup;
    }
    public void addMain(Main niku){
        this.niku = niku;
    }
    public void addOyasaiTachi(List<Oyasai> oyasaiTachi){
        this.oyasaiTachi = oyasaiTachi;
    }
    public void addOtherGooTachi(List<OtherGoo> otherGooTachi){
        this.otherGooTachi = otherGooTachi;
    }

    public List<String> getShokuZaiList(){
        List<String> shokuZaiList = new ArrayList<String>();

        shokuZaiList.add(this.soup.getName());
        shokuZaiList.add(this.niku.getName());

        List<Oyasai> oyasaiList = this.oyasaiTachi;
        for (int i = 0; i < oyasaiList.size(); i++) {
            shokuZaiList.add(oyasaiList.get(i).getName());
        }

        List<OtherGoo> otherGooList = this.otherGooTachi;
        for (int i = 0; i < otherGooList.size(); i++) {
            shokuZaiList.add(otherGooList.get(i).getName());
        }

        return shokuZaiList;
    }
}

abstract class Factory{
    public abstract Soup getSoup();
    public abstract Main getMain();
    public abstract List<Oyasai> getOyasaiTachi();
    public abstract List<OtherGoo> getOtherGooTachi();
}

class CurryFactory extends Factory{
    public Soup getSoup(){
        return new CurrySoup(1);
    }
    public Main getMain(){
        return new Pork();
    }
    public List<Oyasai> getOyasaiTachi(){
        List<Oyasai> oyasaiTachi = new ArrayList<Oyasai>();
        oyasaiTachi.add(new Carrot());
        oyasaiTachi.add(new Onion());
        oyasaiTachi.add(new Potato());
        return oyasaiTachi;
    }
    public List<OtherGoo> getOtherGooTachi(){
        List<OtherGoo> otherGooTachi = new ArrayList<OtherGoo>();
        otherGooTachi.add(new Milk());
        otherGooTachi.add(new Udon());
        return otherGooTachi;
    }
}

class SityuuFactory extends Factory{
    public Soup getSoup(){
        return new SityuuSoup(1);
    }
    public Main getMain(){
        return new Beef();
    }

    public List<Oyasai> getOyasaiTachi(){
        List<Oyasai> oyasaiTachi = new ArrayList<Oyasai>();
        oyasaiTachi.add(new Carrot());
        oyasaiTachi.add(new Onion());
        oyasaiTachi.add(new Potato());
        return oyasaiTachi;
    }
    public List<OtherGoo> getOtherGooTachi(){
        List<OtherGoo> otherGooTachi = new ArrayList<OtherGoo>();
        otherGooTachi.add(new Cheese());
        otherGooTachi.add(new Bread(3));
        return otherGooTachi;
    }
}

class YamiNabeFactory extends Factory{
    public Soup getSoup(){
        return new YamiNabeSoup(3);
    }
    public Main getMain(){
        return new Tawashi();
    }
    public List<Oyasai> getOyasaiTachi(){
        List<Oyasai> oyasaiTachi = new ArrayList<Oyasai>();
        oyasaiTachi.add(new PlasticCarrot());
        oyasaiTachi.add(new PlasticOnion());
        oyasaiTachi.add(new PlasticPotato());
        return oyasaiTachi;
    }
    public List<OtherGoo> getOtherGooTachi(){
        List<OtherGoo> otherGooTachi = new ArrayList<OtherGoo>();
        otherGooTachi.add(new Habanero());
        otherGooTachi.add(new GreenJuice());
        return otherGooTachi;
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
        le_Creuset.addOtherGooTachi(factory.getOtherGooTachi());

        System.out.println("今日のレシピは・・・\n");

        List<String> list = le_Creuset.getShokuZaiList();
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        
        if(factory.getSoup().getName().contains("闇")){
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
