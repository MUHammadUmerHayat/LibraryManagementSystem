import java.io.Serializable;


public class Booksdata implements Serializable{

	private static final long serialVersionUID = 1L;
	private int quantity;
	private String callno,bookname,author,publisher;
	private int id;
	private String name;
	
	
		public Booksdata() {
			this.id=0;
			this.name="";
			this.callno="";
			this.bookname="";
			this.author="";
			this.publisher="";
			this.quantity=0;	
		}
	
	public Booksdata(int id, String name,String callno,String bookname,String author,String publisher,int quantity){
		this.id=id;
		this.name=name;
		this.callno=callno;
		this.bookname=bookname;
		this.author=author;
		this.publisher=publisher;
		this.quantity=quantity;
		
	}
	
	public void setId(int id){
		this.id=id;
	}
	
	public int getId(){
		return id;
	}
	
	public void setName(String name){
		this.name=name;
	}
	
	public String getName(){
		return name;
	}
		
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getCallno() {
		return callno;
	}
	public void setCallno(String callno) {
		this.callno = callno;
	}
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	
}
