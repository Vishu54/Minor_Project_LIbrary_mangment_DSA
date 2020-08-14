import java.util.Scanner;

class Author {					//AUTHOR CLASS
	private String name;
	private String email;
	private char gender;
	
	Scanner in=new Scanner(System.in);
	Author(String name,String email,char gender){
		this.name=name;
		this.email=email;
		this.gender=gender;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email=email;
	}

	public char getGender() {
		return gender;
	}
	
	public String toString() {
		
		 return "Author[name=" + name + ",email=" + email + ",gender=" + gender + "]";
		
	}

}

class book {						//BOOK CLASS
	private String name;
	Author author;
	private double price;
	private int qty;
	private int buid;
	
	public book (String name, Author author, double price,int buid) { 
	this.name=name;
	this.author=author;
	this.price=price;
	this.buid=buid;
	}
	
	public book (String name, Author author, double price, int qty,int buid) { 
		this.name=name;
		this.author=author;
		this.price=price;
		this.qty=qty;
		this.buid=buid;
	}
	
	public String getName() {
		return this.name;
	}
	
	public Author getAuthor() {
		return this.author;
	}
	
	public double getPrice() {
		return this.price;
	}
	
	public void setPrice(double price) {
		this.price=price;
	}

	public int getQty() {
		return this.qty;
	}

	public void setQty(int qty) {
		this.qty=qty;
	}
	public int getbuid() {
		return buid;
	}
	
		public String toString() {
			return "Book[UID "+buid+"name=" + name + " Author[" + author +"],price=" + price + ",qty=" + qty;
			
		}
}

class student{								//STUDENT CLASS
		String name;
		int roll;
		int noofbook=0;
		int issuebookuid[]=new int[5];
		Date issueDate;
		Date returnDate;
		
		Scanner in=new Scanner(System.in);
		student(){
			System.out.println("Enter your Roll no: ");
			roll=in.nextInt();
			System.out.println("Enter your Name: ");
			name=in.next();
			}
		
		void issueBook(book[] obj,int n) {								//BOOK ISSUE FUNCTION
			int i=0;
			for(;i<n;i++) {
				System.out.println(obj[i]);
			}
			System.out.println("Enter the Book Name:");
			String bookname=in.next();
			for(i=0;i<n;i++) {
			if(obj[i].getName().compareToIgnoreCase(bookname)==0 && noofbook<6 && obj[i].getQty()>0) {
				System.out.println("Book Found!!");
					noofbook++;
					int updqty=obj[i].getQty()-1;
					obj[i].setQty(updqty);
						issuebookuid[noofbook]=obj[i].getbuid();
					System.out.println("Enter Today's Date in DD/MM/YYYY format ");
					int dd=in.nextInt();
					int mm=in.nextInt();
					int yyyy=in.nextInt();
					issueDate=new Date(dd,mm,yyyy);
				}
			}
		}
		
		void depositBook(book obj[],int n) {								//BOOK DEPOSIT FUNCTION
			for(int i=0;i<n;i++) {
				for(int x=0;x<5;x++) {
			if(obj[i].getbuid()==issuebookuid[x])
			{
				System.out.println(obj[i]);
					int updqty=obj[i].getQty()+1;
					obj[i].setQty(updqty);
					System.out.println("Enter Today's Date in DD/MM/YYYY format ");
					int dd=in.nextInt();
					int mm=in.nextInt();
					int yyyy=in.nextInt();
					returnDate=new Date(dd,mm,yyyy);
			}
				}
			}
		}		
		
		public String toString() {
			
		return "roll"+roll+"Name"+name+"Total book issued:"+noofbook;
		}
}
class Date{														//DATE CLASS
	int dd,mm,yyyy;
	
	Date(int dd,int mm,int yyyy){
		this.dd=dd;
		this.mm=mm;
		this.yyyy=yyyy;
	}
	
	int getDD() {
		return dd;
	}
	
	int getMM() {
		return mm;
	}
	
	int getYYYY() {
		return yyyy;
	}
}

public class Main {											//DRIVER CLASS

	@SuppressWarnings("null")
	public static void main(String[] args) {					//MAIN FUNCTION
		Scanner in=new Scanner(System.in);
		int index=1;
		String name,authorname,email,bookauthor;
		char gen;
		double price;
		int qty;
		
		char ch='y';
		int i=0;
		int n=100;
		Author temp=new Author(null,null,' ');
		Author auth[]=new Author[n];
		book obj[]=new book[n];
		
		int x=100;
		int y=0;
		int uid=y;
		int buid;
		int id;
		ch='y';
		student std[]=new student[x];
		//student tmp1=null;
				
		while(ch=='y') {
		System.out.println("1-AUTHOR & BOOK ENTRY\n2-STUDENT ENTRY\n3-ISSUE BOOK\n4-RETURN BOOK\n5-VIEW ALL BOOK");
		int choice=in.nextInt();
		if(choice==1) {
		ch='y';
		//AUTHOR ENTRY
		while(ch=='y'&& i<n)
		{
			System.out.println("Enter the Author Name  ");
			authorname=in.next();
			System.out.println("Enter theEmail ID");
			email=in.next();
			System.out.println("Enter the Gender  ");
			gen=in.next().charAt(0);
			auth[i]=new Author(authorname,email,gen);
			i++;
			System.out.println("Press y for more entries else n");
			ch=in.next().charAt(0);
		}
		
		int tmp=i;	
		i=0;
		ch='y';
		//BOOK ENTRY
		while(ch=='y' && i<n)
		{
			System.out.println("Enter Unique Book ID");
			buid=in.nextInt();
			System.out.println("Enter the Book Name  ");
			name=in.next();
			System.out.println("Enter the Name of Author  ");
			bookauthor=in.next();
			for(index=0;index<tmp;index++) {
				if(auth[index].getName().compareToIgnoreCase(bookauthor)==0) {
					System.out.println("Author Found!!");
					temp=auth[index];
				}
			}	
			System.out.println("Enter the Price  ");
			price=in.nextDouble();
			System.out.println("Enter the Quantity  ");
			qty=in.nextInt();								
			if(qty<0)
				obj[i]=new book(name,temp,price,buid);
			else
				obj[i]=new book(name,temp,price,qty,buid);	
			System.out.println(obj[i]);
			i++;
			System.out.println("Press y for more entries else n");
			ch=in.next().charAt(0);
		 }
		}
		//STUDENT ENTRY
		else if(choice==2) {
			ch='y';
			while(ch=='y') {
			
					if(y<x) {
						uid=y;
						System.out.println("Your UID: "+uid);
						std[y]=new student();
						y++;
						}
					else
						System.out.println("Limit Exceeded!!");
				
			System.out.println("Press y for more entries else n");
			ch=in.next().charAt(0);
		}
	}	
		//BOOK ISSUE
		else if(choice==3 && y>=0) {
			ch='y';
			while(ch=='y') {
					System.out.println("Enter your UID:");
					id=in.nextInt();
						std[id].issueBook(obj,i);
						System.out.println("Press y for more books else n");
						ch=in.next().charAt(0);
					}
				}
		
		//RETURN BOOK
		else if(choice==4)
				{
				System.out.println("Enter your UID:");
				id=in.nextInt();
					std[id].depositBook(obj,i);
				}
		
		//VIEW BOOKS
		else if(choice==5) {
				for(int q=0;q<i;q++)
					System.out.println(obj[q]);
		}
			else
				System.out.println("Invalid Input");
		System.out.println("Press y to Main Menu else n to Exit");
		ch=in.next().charAt(0);
		}
		
		
	}

}
