class Paper{}

class Happy{
    public Paper[] createManyStars(){
        Paper[] papers = new Paper[8];
        for(int n=0; n<papers.length ; n++){
            drawStar(papers[n]);  // 時間がかかる
            cutAccordanceWithLine(papers[n]);  // 時間がかかる
            System.out.println("やった! " + (n+1) + "枚できた～♪\n");
        }
        return papers;
    }
    private void drawStar(Paper paper){
        // きれいに描くため時間がかかる
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