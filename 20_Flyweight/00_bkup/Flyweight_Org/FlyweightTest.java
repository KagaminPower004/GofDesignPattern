import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

class Stamp {
    char type;
    Stamp(char type){
        this.type = type;
    }
    void print(){
        System.out.print(this.type);
    }
}

class StampFactory {
    Map<Character, Stamp> pool;
    StampFactory(){
        this.pool = new HashMap<Character, Stamp>();
    }
    Stamp get(char type){
        Stamp stamp = this.pool.get(type);
        if(stamp == null) {
            stamp = new Stamp(type);
            this.pool.put(type, stamp);
        }
        return stamp;
    }
}

class FlyweightTest {
    public static void main(String[] args) {
        StampFactory factory = new StampFactory();
        List<Stamp> stamps = new ArrayList<Stamp>();
        stamps.add(factory.get('た'));
        stamps.add(factory.get('か'));
        stamps.add(factory.get('い'));
        stamps.add(factory.get('た'));
        stamps.add(factory.get('け'));
        stamps.add(factory.get('た'));
        stamps.add(factory.get('て'));
        stamps.add(factory.get('か'));
        stamps.add(factory.get('け'));
        stamps.add(factory.get('た'));

        for(Stamp s : stamps){
            s.print();
        }
    }
}