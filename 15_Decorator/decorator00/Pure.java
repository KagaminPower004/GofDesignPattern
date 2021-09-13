package decorator00;

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

class JavaCCNAEngineer extends CCNAEngineer{
    public String getAbility(){
        return "SJC-P/" + super.getAbility();
    }
}

class JavaOracleEngineer extends OracleEngineer{
    public String getAbility(){
        return "SJC-P/" + super.getAbility();
    }
}

class LinuxJavaCCNAEngineer extends JavaCCNAEngineer{
    public String getAbility(){
        return "Lpic/" + super.getAbility();
    }
}

class OracleLinuxJavaCCNAEngineer extends LinuxJavaCCNAEngineer{
    public String getAbility(){
        return "OracleMaster/" + super.getAbility();
    }
}

class Pure{
    public static void main(String args[]){
        Engineer eng1 = new JavaCCNAEngineer();
        Engineer eng2 = new JavaOracleEngineer();
        Engineer eng3 = new LinuxJavaCCNAEngineer();
        Engineer eng4 = new OracleLinuxJavaCCNAEngineer();
        System.out.println(eng1.getAbility());
        System.out.println(eng2.getAbility());
        System.out.println(eng3.getAbility());
        System.out.println(eng4.getAbility());
    }

}