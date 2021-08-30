import java.util.*;

interface Cloneable{
    public Cloneable createClone();
}

class Paper implements Cloneable{
    private String name;
    public Paper(){}
    public Paper(String name){
        this.name = name;
    }
    public Cloneable createClone(){
        Paper newPaper = new Paper();
        newPaper.name = this.name;
        // newPaper と this を重ねて、this の形に切り抜く
        return newPaper;
    }

    public String getName(){ return this.name; }
}
 
class PrototypeKeeper{
    private Map<String,Cloneable> map;
    public PrototypeKeeper(){
        this.map = new HashMap<String,Cloneable> ();
    }
    public void addCloneable(String key,Cloneable prototype){
        map.put( key , prototype );
    }
    public Cloneable getClone(String key){
        Cloneable chozohin = map.get(key);
        return chozohin;
    }
}

class Happy{
    public Paper[] createManyShapes(Paper prototype){

        drawShape(prototype);
        cutAccordanceWithLine(prototype);
        System.out.println("やった! " + 1 + "枚できた～♪\n"); 

        Paper[] papers = new Paper[2];

        for(int n=0; n<papers.length ; n++){
            papers[n] = (Paper)prototype.createClone();
            System.out.println("１枚目の" + papers[n].getName() + "に沿って"
                               + papers[n].getName() + "形に切り抜く");
            System.out.println("やった! " + (n+2) + "枚できた～♪\n");
        }
        return papers;
    }
    private void drawShape(Paper paper){
        // 描いたり消したりしながら、きれいに描くため時間がかかる
        System.out.println("とても丁寧に" + paper.getName() + "を描く");
    }
    private void cutAccordanceWithLine(Paper paper){
        // 描かれた線に沿ってきれいに切るには時間がかかる
        System.out.println("描いた線に沿って" + paper.getName() + "形に切り抜く");
    }



    public static void main(String[] args) {

        PrototypeKeeper myKeep = new PrototypeKeeper();
        
        Paper[] prototypes =  new Paper[3];
        prototypes[0] = new Paper("ヤマアラシのような星!!");
        myKeep.addCloneable(prototypes[0].getName(),prototypes[0]);
        
        prototypes[1] = new Paper("お母さんのようなホウキ!!");
        myKeep.addCloneable(prototypes[1].getName(),prototypes[1]);
        
        prototypes[2] = new Paper("お父さんのメガネ!!");
        myKeep.addCloneable(prototypes[2].getName(),prototypes[2]);
        
        Happy me = new Happy();
        me.createManyShapes((Paper)myKeep.getClone(args[0]));


    }

}