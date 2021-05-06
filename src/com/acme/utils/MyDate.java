package com.acme.utils;

public class MyDate {

	private int day;
	private int year;
	private int month;
	/*private static MyDate[] holidays={
			new MyDate(1,1,2016),
			new MyDate(9,5,2016),
			new MyDate(5,30,2016),
			new MyDate(11,24,2016),
	};*/
	private static MyDate[] holidays;
public static MyDate[] getHolidays(){
	return holidays; }
	public static void listHolidays() {System.out.println("the holidays are:");
	/*for (int x = 0; x < holidays.length; x++)
	{System.out.println(holidays[x]); }*/
		for(MyDate x: holidays)
		{System.out.println(x); }
}
	public MyDate() {
	//	this(1, 1, 1900);
	}

	public MyDate(int m, int d, int y) throws InvalidDateException{

		try{ valid(d, m, y);
			month = m;
			day = d;
			year = y;}
		catch(InvalidDateException e) {
			System.out.println("The date is invalid! Application closing.");
			throw new InvalidDateException();
			}
	}

	public String toString() {
		return month + "/" + day + "/" + year;

	}

	public void setDate(int m, int d, int y) {
		month = m;
		day = d;
		year = y;
	}

	public static void leapYears() {
		for (int i = 1752; i <= 2020; i++) {
			if (i % 4 == 0)
				System.out.println("the year " + i + " is a leap year");
		}

	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		try {valid(day, month, year);
			this.day = day;
		}catch (InvalidDateException e){
			System.out.println("The date is invalid! Application closing.");
			System.exit(0);
	}}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		try {valid(day, month, year);
			this.year = year;
		}catch (InvalidDateException e){
			System.out.println("The date is invalid! Application closing.");
			System.exit(0);
		}}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {try {valid(day, month, year);
		this.month = month;
	}catch (InvalidDateException e){
		System.out.println("The date is invalid! Application closing.");
		System.exit(0);
	}}

	private void valid(int day, int month, int year) throws InvalidDateException{
		if (day > 31 || day < 1 || month > 12 || month < 1) {
			System.out.println("Attempting to create a non-valid date " + month + "/" + day + "/" + year);
			throw new InvalidDateException();
		}
		switch (month) {
		case 4:
		case 6:
		case 9:
		case 11:
			if  (day > 30){throw new InvalidDateException();}
		case 2:
			if( (day <= 28 || (day == 29 && (year % 4==0 )))==false)
		{throw new InvalidDateException();}
		}
	}

	public boolean equals(Object o) {
		if (o instanceof MyDate) {
			MyDate d = (MyDate) o;
			if ((d.day == day) && (d.month == month) && (d.year == year)) {
				return true;
			}
		}
		return false;
	}

}
