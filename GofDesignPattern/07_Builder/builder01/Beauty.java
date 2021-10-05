package builder01;

interface Builder{
    public void addPowder(double powderAmount);
    public void addWater(double waterAmount);
    public void cutPowderHotWater(double powderHotWaterAmount);
    public Object getResult();
}

class Director{
    private Builder builder;

    public Director(Builder builder){
        this.builder = builder;
    }

    public void constract(){
        builder.addWater( 1200 );
        builder.addPowder( 120 );
        builder.cutPowderHotWater( 200 );
        builder.addWater( 80 );
        builder.addPowder( 5 );
    }
}

class CurryPowderHotWater{
    public double curryPowder;
    public double hotWater;

    public CurryPowderHotWater(double hotWater,double curryPowder){
        this.curryPowder = curryPowder;
        this.hotWater = hotWater;
    }
 
}

class CurryPowderHotWaterBuilder implements Builder{
    private CurryPowderHotWater curryPowderHotWater;
    public CurryPowderHotWaterBuilder(){
        this.curryPowderHotWater = new CurryPowderHotWater(0,0);
    }
    public void addPowder(double curryPowderAmount){
        curryPowderHotWater.curryPowder += curryPowderAmount;
    }
    public void addWater(double hotWaterAmount){
        curryPowderHotWater.hotWater += hotWaterAmount;
    }
    public void cutPowderHotWater(double curryPowderHotWaterAmount){
        double curryPowderCutAmount
                    = curryPowderHotWaterAmount
                    *
                      (curryPowderHotWater.curryPowder 
                    / (curryPowderHotWater.curryPowder + curryPowderHotWater.hotWater));
        double hotWaterCutAmount
                    = curryPowderHotWaterAmount
                    *
                      (curryPowderHotWater.hotWater 
                    / (curryPowderHotWater.curryPowder + curryPowderHotWater.hotWater));

        curryPowderHotWater.curryPowder -= curryPowderCutAmount;
        curryPowderHotWater.hotWater    -= hotWaterCutAmount;
    }
    public Object getResult(){
        return this.curryPowderHotWater;
    }
}

class Beauty{
    public static void main(String args[]) {
        Builder builder = new CurryPowderHotWaterBuilder();
        Director dir = new Director( builder );
        dir.constract();
        CurryPowderHotWater curryPowderHotWater = (CurryPowderHotWater)builder.getResult();
        
        System.out.println("カレー粉「" + (int)curryPowderHotWater.curryPowder + "グラム」と、\n" 
            + "「お湯" + (int)curryPowderHotWater.hotWater + "ミリリットル」で\nおいしいカレーができたわ♪");
    }
}