package decorator01;

interface Engineer{
    public String getAbility();
}

class CCNAEngineer implements Engineer{
    public String getAbility(){
        return "CCNA取得エンジニア";
    }
}

class OracleEngineer implements Engineer{
    public String getAbility(){
        return "OracleMaster取得エンジニア";
    }
}

class plusJavaEngineer implements Engineer{
    private Engineer eng = null;
    public plusJavaEngineer(Engineer eng){
        this.eng = eng;
    }
    public String getAbility(){
        String name = "SJC-P/";
        name += eng.getAbility();
        return name;
    }
}

class plusLinuxEngineer implements Engineer{
    private Engineer eng = null;
    public plusLinuxEngineer(Engineer eng){
        this.eng = eng;
    }
    public String getAbility(){
        String name = "Lpic/";
        name += eng.getAbility();
        return name;
    }
}

class plusOracleEngineer implements Engineer{
    private Engineer eng = null;
    public plusOracleEngineer(Engineer eng){
        this.eng = eng;
    }
    public String getAbility(){
        String name = "OracleMaster/";
        name += eng.getAbility();
        return name;
    }
}

class Pure{
    public static void main(String args[]){
        
        Engineer eng1 = new plusJavaEngineer(new CCNAEngineer());
        Engineer eng2 = new plusJavaEngineer(new OracleEngineer());
        Engineer eng3 = new plusLinuxEngineer(new plusJavaEngineer(new CCNAEngineer()));
        Engineer eng4 = new plusOracleEngineer(new plusLinuxEngineer(new plusJavaEngineer(new CCNAEngineer())));
        System.out.println(eng1.getAbility());
        System.out.println(eng2.getAbility());
        System.out.println(eng3.getAbility());
        System.out.println(eng4.getAbility());
    }

}