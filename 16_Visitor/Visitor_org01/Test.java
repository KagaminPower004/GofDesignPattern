//先生クラス
import java.util.List;
 
abstract class Teacher{

    public abstract void visit(Home studentHome);
    public abstract void visit(TanakaHome studentHome);
    public abstract void visit(SuzukiHome studentHome);

}

//新人先生クラス
class RookieTeacher extends Teacher{

    public void visit(Home studentHome){
        System.out.println("こんにちは");
    }
    public void visit(TanakaHome studentHome){
        studentHome.praisedChild();
    }
    public void visit(SuzukiHome studentHome){
        studentHome.reprovedChild();
    }
}

//家庭クラス
abstract class Home{
    public abstract Object praisedChild();
    public abstract Object reprovedChild();
}

//受け入れインタフェース
interface TeacherAcceptor{
    public void accept(Teacher teacher);
}

//鈴木さんの家庭
class SuzukiHome extends Home implements TeacherAcceptor{
    public Object praisedChild(){
        System.out.println("あら、先生ったらご冗談を");
        return null;
    }
    public Object reprovedChild(){
        System.out.println("うちの子に限ってそんなことは・・・。");
 
        return null;
    }
    /**
     * 訪問者を受け入れるメソッド
     */
    public void accept(Teacher teacher){
        teacher.visit(this);
    }
}

//田中さんの家庭
class TanakaHome extends Home implements TeacherAcceptor{
    public Object praisedChild(){
        System.out.println("まぁ、嬉しい!!");
        return null;
    }
    public Object reprovedChild(){
        System.out.println("いつもご迷惑をおかけして申し訳ございません。。。");
 
        return null;
    }
    /**
     * 訪問者を受け入れるメソッド
     */
    public void accept(Teacher teacher){
        teacher.visit(this);
    }
}

class Test{
    public static void main(String args[]){
        
        Teacher RT = new RookieTeacher();
        TeacherAcceptor suzuki = new SuzukiHome();
        suzuki.accept(RT);
        
        TeacherAcceptor tanaka = new TanakaHome();
        tanaka.accept(RT);
    }
}
