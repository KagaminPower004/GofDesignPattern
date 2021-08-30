//本(情報)クラス
class Book{
    private String  name;
    private String  location;
    private boolean lending;
 
    public Book(String name,String location,boolean lending){
        this.name     = name;
        this.location = location;
        this.lending  = lending;
    }
    public String getName(){
        return name;
    }
    public String getLocation(){
        return location;
    }
    public boolean getLending(){
        return lending;
    }
}

interface Aggregate{
    public Iterator iterator();
}

interface Iterator{
      public boolean hasNext();
      public Object next();
}

//収蔵本ＤＢクラス
class BookDB implements Aggregate{
    protected java.util.Vector<Book> Books;
    private int last = 0;

    public BookDB(){}
    public BookDB(int BookCount){
    this.Books = new java.util.Vector<Book>(BookCount);
    }

    public void add(Book Book){
        Books.add(Book);
        last++;
    }
    public Book getBookAt(int index){
        return Books.get(index);
    }

    public int getLastNum(){
        return last;
    }

    public Iterator iterator(){
        return new BookDBIterator(this);
    }
}

class BookDBIterator implements Iterator{
    private BookDB BookDB;
    private int index;
    public BookDBIterator(BookDB BookDB){
        this.BookDB = BookDB;
        this.index = 0;
    }
    public boolean hasNext(){
        if(BookDB.getLastNum() > index){
            return true;
        }else{
            return false;
        }
    }
    public Book next(){
        Book Book =  BookDB.getBookAt(index);
        index++;
        return Book;
    }
}

interface Search{ public boolean searchBook(String bookName,BookDB bookDB); }

//所蔵本検索
class BookListSearch implements Search{
    public boolean searchBook(String bookName,BookDB bookDB) {
        String location = null;

        //収蔵本ＤＢから本の名前を探す
        Iterator itr = bookDB.iterator();
        while(itr.hasNext()){
            Book book = (Book)itr.next();
            if(book.getName().equals(bookName)){ location =  book.getLocation(); break; }
        }

        //あればtrueを、なければfalseを返す
        boolean result = false;
        if(location != null){ result = true; }
               
        return result;
    }
}

//貸出帳検索
class LendingListSearch implements Search {
    public boolean searchBook(String bookName,BookDB bookDB) {
        boolean lending = false;

        //収蔵本ＤＢから貸出中かチェックする
        Iterator itr = bookDB.iterator();
        while(itr.hasNext()){
            Book book = (Book)itr.next();
            if(book.getName().equals(bookName)){ lending =  book.getLending(); break; }
        }
        //貸出中ならtrue、そうでなければfalseを返す
        return lending;
    }
}

//図書館司書クラス
class Librarian {

    public  Librarian(){ createBookDB(); }

    private BookDB bookDB;
    public void createBookDB(){
        bookDB = new BookDB(7);
        bookDB.add(new Book("昆虫図鑑","図書館入口：科学・自然",true));
        bookDB.add(new Book("カレーの作り方","図書館中央：生活・暮らしの知恵",false));
        bookDB.add(new Book("シチューの作り方","図書館中央：生活・暮らしの知恵",false));
        bookDB.add(new Book("ジブリがいっぱい♪","図書館テラス：マンガ・アニメ",true));
        bookDB.add(new Book("読むだけでわかる！？オブジェクト指向デザインパターンの基礎の基礎～その10：Facadeパターン～"
                           ,"図書館テラス：マンガ・アニメ",false));
        bookDB.add(new Book("お鍋料理の基礎の基礎","図書館書庫：生活・暮らしの知恵",false));
        bookDB.add(new Book("ヘルシー!!煮込みお寿司","図書館書庫：生活・暮らしの知恵",false));
    }

    public String searchBook(String bookName) {
        //本を探す
        BookListSearch bookListSearch = new BookListSearch();
        boolean located = bookListSearch.searchBook(bookName,bookDB);
        //本があるとき
        if (located) {
            //貸出中かチェックする
            LendingListSearch lendingListSearch = new LendingListSearch();
            if (lendingListSearch.searchBook(bookName,bookDB)) {
                //貸出中のとき
                return "貸出中です";
            } else {
                //貸出中ではないとき
                return "お貸しできます";
            }
        //所蔵してないとき
        } else {
            return "その本は所蔵していません";
        }
    }
}

class Happy {
    public static void main(String[] args) {
        //図書館司書のフラットさんをインスタンス化
        Librarian flat = new Librarian();
        
        //フラットさんに本の場所を聞く
        String location = flat.searchBook(args[0]);
        if(location.equals("貸出中です")){
            System.out.println(location+ "\n");
            System.out.println("あるの!!");
        }else if(location.equals("その本は所蔵していません")){
            System.out.println(location+ "\n");
            System.out.println("ないの!?");
        }else{
            System.out.println(location+ "\n");
            System.out.println("ありがと♪");
        }
    }
}