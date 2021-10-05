package builder02;

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

class SityuuPowderHotWater{
    public double SityuuPowder;
    public double hotWater;

    public SityuuPowderHotWater(double hotWater,double SityuuPowder){
        this.SityuuPowder = SityuuPowder;
        this.hotWater = hotWater;
    }
 
}

class SityuuPowderHotWaterBuilder implements Builder{
    private SityuuPowderHotWater SityuuPowderHotWater;
    public SityuuPowderHotWaterBuilder(){
        this.SityuuPowderHotWater = new SityuuPowderHotWater(0,0);
    }
    public void addPowder(double SityuuPowderAmount){
        SityuuPowderHotWater.SityuuPowder += SityuuPowderAmount;
    }
    public void addWater(double hotWaterAmount){
        SityuuPowderHotWater.hotWater += hotWaterAmount;
    }
    public void cutPowderHotWater(double SityuuPowderHotWaterAmount){
        double SityuuPowderCutAmount
                    = SityuuPowderHotWaterAmount
                    *
                      (SityuuPowderHotWater.SityuuPowder 
                    / (SityuuPowderHotWater.SityuuPowder + SityuuPowderHotWater.hotWater));
        double hotWaterCutAmount
                    = SityuuPowderHotWaterAmount
                    *
                      (SityuuPowderHotWater.hotWater 
                    / (SityuuPowderHotWater.SityuuPowder + SityuuPowderHotWater.hotWater));

        SityuuPowderHotWater.SityuuPowder -= SityuuPowderCutAmount;
        SityuuPowderHotWater.hotWater    -= hotWaterCutAmount;
    }
    public Object getResult(){
        return this.SityuuPowderHotWater;
    }
}

class Pure{
    public static void main(String args[]) {
        Builder builder = new SityuuPowderHotWaterBuilder();
        Director dir = new Director( builder );
        dir.constract();
        SityuuPowderHotWater SityuuPowderHotWater = (SityuuPowderHotWater)builder.getResult();
        
        System.out.println("シチュールー「" + (int)SityuuPowderHotWater.SityuuPowder + "グラム」と、\n" 
            + "「お湯" + (int)SityuuPowderHotWater.hotWater + "ミリリットル」で\nおいしいシチューができたよワーイ♪");
    }
}