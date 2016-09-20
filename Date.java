public class Date{
	private int day;	
	private int month;
	private int year;

	Date(){
		year = 1000;
		month = 1;
		day = 1;
	}

	Date(int yr, int mnth, int dy){
		setYear(yr);
		setMonth(mnth);
		setDay(dy);
	}

	public int getYear(){
		return year;

	}

	public int getMonth(){
		return month;

	}

	public int getDay(){
		return day;

	}

	public void setYear(int yr){
		if(yr < 1000 || yr > 9999){
			throw new IllegalArgumentException("WRONG!");
		}

		year = yr;
	}

	public void setMonth(int mnth){
		if(mnth < 1 || mnth > 12){
			throw new IllegalArgumentException("WRONG MONTH!");
		}

		month = mnth;
	}

	public void setDay(int dy){
		if(dy < 1 || dy > 31 || (month == 2 && leapyear(year) == false && dy >= 29) 
		          || (month == 2 && leapyear(year) == true && dy > 29)){
			throw new IllegalArgumentException("either WRONG DAY input or WRONG DAY of the leap year!");
		}
		else if((month == 4 || month == 6 || month == 9 || month == 11) && dy > 30){
			throw new IllegalArgumentException("WRONG DAY! of the month");
		}
		day = dy;
	}

	public void setDate(int yr,int mnth,int dy){
		setYear(yr);
		setMonth(mnth);
		setDay(dy);			
	}

	public String toString(){
		String datee;
		datee = String.format("%02d/%02d/%d",day,month,year);

		return datee;
	}

	private boolean leapyear(int yr){
		if(yr % 4 == 0){
			if((yr % 100 == 0 && yr % 400 == 0) || yr % 100 != 0){
				return true;
			}
			else{
				return false;
			}
		}
		else{
			return false;
		} 
	}
}