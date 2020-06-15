import java.util.Date;
import java.io.Serializable;


public class Librarian implements Serializable {

	private static final long serialVersionUID = 1L;
	private String name,email,city,address,contact,password;
	private Date date;
	private int id;
	public Librarian(){
		this.id=0;
		this.setDate(new Date());
		this.name="";
		this.password="";
		this.email="";
		this.city="";
		this.address="";
		this.contact="";
	}
	
	public Librarian(int id,Date date,String name,String password,String email,String city,String address,String contact){
		this.id=id;
		this.setDate(date);
		this.name=name;
		this.password=password;
		this.email=email;
		this.city=city;
		this.address=address;
		this.contact=contact;
	}
	
	

	public String getName(){
		return name;
	}
	
	public void setName(String name){
		this.name=name;
	}
	
	public String getPassword(){
		return password;
	}
	
	public void setPassword(String password){
		this.password=password;
	}
	
	public String getEmail(){
		return email;
	}
	
	public void setEmail(String email){
		this.email=email;
	}
	
	public String getCity(){
		return city;
	}
	
	public void setCity(String city){
		this.city=city;
	}
	
	public String getAddress(){
		return address;
	}
	
	public void setAddress(String address){
		this.address=address;
	}
	
	public String getContact(){
		return contact;
	}
	
	public void setContact(String contact){
		this.contact=contact;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	
	
}
