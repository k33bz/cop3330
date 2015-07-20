package midterm;

public class Overloaded
{
	public void compute(int num) {} 
	public int compute(double num) {
		return 0;}	
	 
	public void move(double length) {} 
	public void move( ) {} 	
	 
	public int adjust(double amount) {
		return 0;} 
	public void adjust(double amount, double charge) {} 

	public void doWork( ) {} 
	public void doWork(String name) {} 
	public int doWork(double num) {
		return 0;}
	
	String[] monthName = {	"January", "February", "March",                        "April", "May", "June", "July",                        "August", "September", "October",                        "November", "December" };
	
}
