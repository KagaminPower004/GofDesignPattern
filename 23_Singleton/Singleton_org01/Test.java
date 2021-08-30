class RegisterNote{
    private static RegisterNote registerNote = new RegisterNote();

    private RegisterNote(){}

    public static RegisterNote getInstance(){
        return registerNote;
    }
}

class Test{
    public static void main(String args[]){
        RegisterNote reg1 = RegisterNote.getInstance();
        RegisterNote reg2 = RegisterNote.getInstance();
        RegisterNote reg3 = RegisterNote.getInstance();

        if( reg1 == reg2 ){System.out.println("reg1 == reg2");}
        else{System.out.println("reg1 != reg2");}
    }
}