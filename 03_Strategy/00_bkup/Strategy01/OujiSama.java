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

interface Comparator{
    public void compare(OujiSama o1,OujiSama o2);
}

class WeightComparator implements Comparator{
    public void compare(OujiSama o1 , OujiSama o2){
        //痩せてる人が好き♪
        if(o1.getWeight() < o2.getWeight()){
            o1.point += 1;
        }else if(o1.getWeight() == o2.getWeight()){
            o1.point += 0;
            o2.point += 0;
        }else{
            o2.point += 1;
        }
    }
}

class HeightComparator implements Comparator{
    public void compare(OujiSama o1,OujiSama o2){
        //背が高い人が好き♪
        if(o1.getHeight() > o2.getHeight()){
            o1.point += 1;
        }else if(o1.getHeight() == o2.getHeight()){
            o1.point += 0;
            o2.point += 0;
        }else{
            o2.point += 1;
        }
    }
}

class Happy{
    public static void main(String args[]) {
        OujiSama Ouji1 = new OujiSama("じぃじ",68,180,70);
        OujiSama Ouji2 = new OujiSama("ぱぁぱ",71,172,41);
        
        Comparator Chk1 = new WeightComparator();
        Comparator Chk2 = new HeightComparator();
      
        Chk1.compare(Ouji1, Ouji2);
        Chk2.compare(Ouji1, Ouji2);    
        
        if(Ouji1.point > Ouji2.point) {
        
            System.out.println(Ouji1.getName() + "が大好き♪");
        
        }else if(Ouji1.point == Ouji2.point) {
        
            System.out.println("2人とも大好き♪");
        
        }else {
            System.out.println(Ouji2.getName() + "が大好き♪");
        }
    }
}