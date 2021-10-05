package composite_org00;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

class File{
    private String name = null;
    public File(String name){
        this.name = name;
    }
    public void remove(){
        System.out.println(name + "を削除しました");
    }
}

class Directory{
    private List<Object> list = null;
    private String name = null;
    public Directory(String name){
        this.name = name;
        list = new ArrayList<Object>();
    }
    public void add(File file){
        list.add(file);
    }
    public void add(Directory dir){
        list.add(dir);
    }
    public void remove(){
        Iterator<Object> itr = list.iterator();
        while(itr.hasNext()){
            Object obj = itr.next();
            if(obj instanceof File){
                ((File)obj).remove();
            }else if(obj instanceof Directory){
                ((Directory)obj).remove();
            }else{
                System.out.println("削除できません");
            }
        }
        System.out.println(name + "を削除しました。");
    }
}

class Test {
    public static void main(String args[]){
        File file1 = new File("file1");
        File file2 = new File("file2");
        File file3 = new File("file3");
        File file4 = new File("file4");
        Directory dir1 = new Directory("dir1");
        dir1.add(file1);
        Directory dir2 = new Directory("dir2");
        dir2.add(file2);
        dir2.add(file3);
        dir1.add(dir2);
        dir1.add(file4);
         
        dir1.remove();
    }
}