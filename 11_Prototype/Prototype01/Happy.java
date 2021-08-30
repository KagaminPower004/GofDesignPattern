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
}

class Happy{
    public Paper[] createManyStars(){
        Paper prototype = new Paper();
        drawStar(prototype);
        cutAccordanceWithLine(prototype);
        System.out.println("やった! " + 1 + "枚できた～♪\n"); 

        Paper[] papers = new Paper[7];

        for(int n=0; n<papers.length ; n++){
            papers[n] = (Paper)prototype.createClone();
            System.out.println("１枚目の星に沿って星形に切り抜く");
            System.out.println("やった! " + (n+2) + "枚できた～♪\n");
        }
        return papers;
    }
    private void drawStar(Paper paper){
        // 描いたり消したりしながら、きれいに描くため時間がかかる
        System.out.println("とても丁寧に星を描く");
    }
    private void cutAccordanceWithLine(Paper paper){
        // 描かれた線に沿ってきれいに切るには時間がかかる
        System.out.println("描いた線に沿って星形に切り抜く");
    }

    public static void main(String[] args) {
        Happy me = new Happy();
        me.createManyStars();
    }

}