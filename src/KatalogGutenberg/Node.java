package KatalogGutenberg;

/**
 *
 * @author Alfian Hidayat
 */
public class Node {

    public String author;
    public String title;
    public String no;
    public String prop;
    public Node kiri, kanan;
    
    public Node (String penulis,String judul,String no,String prop){
        this.author = penulis;
        this.title = judul;
        this.no = no;
        this.prop = prop;
    }
    
}

