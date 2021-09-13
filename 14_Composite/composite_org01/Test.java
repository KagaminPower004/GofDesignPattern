package composite_org01;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

interface DirectoryEntry{
    public void remove();
}

class File implements DirectoryEntry{
    private String name = null;
    public File(String name){
        this.name = name;
    }
    public void remove(){
        System.out.println(name + "を削除しました");
    }
}

class Directory implements DirectoryEntry{
    private List<DirectoryEntry> list = null;
    private String name = null;
    public Directory(String name){
        this.name = name;
        list = new ArrayList<DirectoryEntry>();
    }
    public void add(DirectoryEntry entry){
        list.add(entry);
    }
    public void remove(){
        Iterator<DirectoryEntry> itr = list.iterator();
        while(itr.hasNext()){
            DirectoryEntry entry = itr.next();
            entry.remove();
        }
        System.out.println(name + "を削除しました。");
    }
}

class SymbolicLink implements DirectoryEntry{
    private String name = null;
    public SymbolicLink(String name) {
        this.name = name;
    }
    public void remove(){
        System.out.println(name + "を削除しました");
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
        
        SymbolicLink symbolicLink1 = new SymbolicLink("symbolicLink1");
        dir1.add(symbolicLink1);
        SymbolicLink symbolicLink2 = new SymbolicLink("symbolicLink2");
        dir2.add(symbolicLink2);
        
        
        dir1.remove();
    }
}