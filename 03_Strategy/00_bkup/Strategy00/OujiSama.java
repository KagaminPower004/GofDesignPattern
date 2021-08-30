class OujiSama{
 
    private String name   = "名無し";
    private int    weight = -1;
    private int    height = -1;
    private int    age    = -1;
    public  int    point  = 0;
 
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

class Happy{
    public static void main(String args[]) {
        OujiSama Ouji1 = new OujiSama("じぃじ",68,180,70);
        OujiSama Ouji2 = new OujiSama("ぱぁぱ",71,172,41);

         //痩せてる人が好き♪
        if(Ouji1.getWeight() < Ouji2.getWeight()){
            Ouji1.point += 1;
        }else if(Ouji1.getWeight() == Ouji2.getWeight()){
            Ouji1.point += 0;
            Ouji2.point += 0;
        }else{
            Ouji2.point += 1;
        }

        //背が高い人が好き♪
        if(Ouji1.getHeight() > Ouji2.getHeight()){
            Ouji1.point += 1;
        }else if(Ouji1.getHeight() == Ouji2.getHeight()){
            Ouji1.point += 0;
            Ouji2.point += 0;
        }else{
            Ouji2.point += 1;
        }

        if(Ouji1.point > Ouji2.point) {
        
            System.out.println(Ouji1.getName() + "が大好き♪");
        
        }else if(Ouji1.point == Ouji2.point) {
        
            System.out.println("2人とも大好き♪");
        
        }else {
            System.out.println(Ouji2.getName() + "が大好き♪");
        }
    }
}