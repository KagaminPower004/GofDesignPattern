class OujiSama{
 
    private String name   = "名無し";
    private int    weight =  -1;
    private int    height =  -1;
    private int    age    =  -1;

    public OujiSama(String name,int weight,int height,int age){
        this.name = name;
        this.weight = weight;
        this.height = height;
        this.age = age;
    }
    
    public String getName(){
        return name;
    }

    public int getHeight(){
        return height;
    }

    public int getWeight(){
        return weight;
    }

    public int getAge(){
        return age;
    }
    
}

//比較クラス
class Comparator{
    private String ComparatorType = "";
    
    //コンストラクタに比較方法を設定
    public Comparator(String ComparatorType){
        this.ComparatorType = ComparatorType;
    }
    
    public String compare(OujiSama o1,OujiSama o2){
        if(ComparatorType == "体重"){
            //痩せてる人が好き♪
            if(o1.getWeight() < o2.getWeight()){
                return o1.getName();
            }else if(o1.getWeight() == o2.getWeight()){
                return "両方とも";
            }else{
                return o2.getName();
            }

        }else if(ComparatorType == "身長"){
            //背が高い人が好き♪
            if(o1.getHeight() > o2.getHeight()){
                return o1.getName();
            }else if(o1.getHeight() == o2.getHeight()){
                return "両方とも";
            }else{
                return o2.getName();
            }
        }else{
            return "ほかの人";
        }
    }
}

class Happy{
    public static void main(String args[]) {
        OujiSama Ouji1 = new OujiSama("じぃじ",68,180,70);
        OujiSama Ouji2 = new OujiSama("ぱぁぱ",71,172,41);
        
        //背が高い人が好き♪
        Comparator Chk = new Comparator("身長");
        String result = Chk.compare(Ouji1, Ouji2);

        System.out.println(result + "大好き♪");

    }
}

class Beauty{
    public static void main(String args[]) {
        OujiSama Ouji1 = new OujiSama("じぃじ",68,180,70);
        OujiSama Ouji2 = new OujiSama("ぱぁぱ",71,172,41);

        //痩せてる人が好き♪
        Comparator Chk = new Comparator("体重");
        String result = Chk.compare(Ouji1, Ouji2);

        System.out.println(result + "大好き♪");

    }
}