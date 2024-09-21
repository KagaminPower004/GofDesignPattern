package flyweight01;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.lang.*;

class Oshigoto {
    String type;
    Oshigoto(String type){

        this.type = type;
        //待機時間を設ける
        try{
            Thread.sleep(1000);
        }catch(InterruptedException e){}
    }
    void print(){
        System.out.print(this.type);
    }
}

class OshigotoFactory {
    Map<String, Oshigoto> pool;
    OshigotoFactory(){
        this.pool = new HashMap<String, Oshigoto>();
    }
    Oshigoto get(String type){

        Oshigoto oshigoto = this.pool.get(type);
        if(oshigoto  == null) {
            oshigoto = new Oshigoto(type);
            this.pool.put(type, oshigoto);
        }        
        return oshigoto;
    }
}

class Pure {
    public static void main(String[] args) {

        long start = System.currentTimeMillis();

        OshigotoFactory factory = new OshigotoFactory();
        List<Oshigoto> oshigotoTachi = new ArrayList<Oshigoto>();
        oshigotoTachi.add(factory.get("設計"));
        oshigotoTachi.add(factory.get("議事録"));
        oshigotoTachi.add(factory.get("プレゼン"));
        oshigotoTachi.add(factory.get("設計"));
        oshigotoTachi.add(factory.get("打合せ"));
        oshigotoTachi.add(factory.get("設計"));
        oshigotoTachi.add(factory.get("業務分析"));
        oshigotoTachi.add(factory.get("議事録"));
        oshigotoTachi.add(factory.get("打合せ"));
        oshigotoTachi.add(factory.get("設計"));

        for(Oshigoto s : oshigotoTachi){
            s.print();
            System.out.println("!!");
        }

        long end = System.currentTimeMillis();
        System.out.println("(処理時間:" + (end - start) + "ミリ秒)");

    }
}