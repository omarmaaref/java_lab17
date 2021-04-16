package com.acme.utils;

public class MyDate {

	private int day;
	private int year;
	private int month;
	private static MyDate[] holidays={
			new MyDate(1,1,2016),
			new MyDate(9,5,2016),
			new MyDate(5,30,2016),
			new MyDate(11,24,2016),
	};
public static MyDate[] getHolidays(){
	return holidays; }
	public static void listHolidays() {System.out.println("the holidays are:");
	/*for (int x = 0; x < holidays.length; x++)
	{System.out.println(holidays[x]); }*/
		for(MyDate x: holidays)
		{System.out.println(x); }
}
	public MyDate() {
		this(1, 1, 1900);
	}

	public MyDate(int m, int d, int y) {

		if (valid(d, m, y)) {
			month = m;
			day = d;
			year = y;
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
		if (valid(day, month, year)) {
			this.day = day;
		}
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		if (valid(day, month, year)) {
			this.year = year;
		}
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		if (valid(day, month, year)) {
			this.month = month;
		}
	}

	private boolean valid(int day, int month, int year) {
		if (day > 31 || day < 1 || month > 12 || month < 1) {
			System.out.println("Attempting to create a non-valid date " + month + "/" + day + "/" + year);
			return false;
		}
		switch (month) {
		case 4:
		case 6:
		case 9:
		case 11:
			return (day <= 30);
		case 2:
			return day <= 28 || (day == 29 && year % 4 == 0);
		}
		return true;
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
