interface Icecream{
    public String getName();
    public String howSweet();
}

class VanillaIcecream implements Icecream{
    public String getName(){
        return "バニラアイスクリーム";
    }
    public String howSweet(){
        return "バニラ味";
    }
}

class GreenTeaIcecream implements Icecream{
    public String getName(){
        return "抹茶アイスクリーム";
    }
    public String howSweet(){
        return "抹茶味";
    }
}

class CashewNutsVanillaIcecream extends VanillaIcecream{
    public String getName(){
        return "カシューナッツ" + super.getName();
    }
}

class CashewNutsGreenTeaIcecream extends GreenTeaIcecream{
    public String getName(){
        return "カシューナッツ" + super.getName();
    }
}

class SliceAlmondCashewNutsVanillaIcecream extends CashewNutsVanillaIcecream{
    public String getName(){
        return "スライスアーモンド" + super.getName();
    }
}

class Test{
    public static void main(String args[]){
        Icecream ice1 = new CashewNutsVanillaIcecream();
        Icecream ice2 = new CashewNutsGreenTeaIcecream();
        Icecream ice3 = new SliceAlmondCashewNutsVanillaIcecream();
        System.out.println(ice1.getName());
        System.out.println(ice2.getName());
        System.out.println(ice3.getName());
    }

}
