package java8;

import java.time.*;
import java.time.format.*;

public class Dates {

	public static void main(String[] args) {
		
		LocalDate today = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		System.out.println(today);
		
		LocalDate pastDay = LocalDate.of(2016, Month.JUNE, 5);
		int years = pastDay.getYear() - today.getYear();
		System.out.println(years);
		
		System.out.println("--------------------");
		System.out.println("Using Period");
		Period period = Period.between(today, pastDay);
		System.out.println("Years: " + period.getYears());
		System.out.println("Months: " + period.getMonths());
		System.out.println("Days: " + period.getDays());
		
		System.out.println("--------------------");
		System.out.println("Using minusDate()");
		System.out.println("1 year before: " + today.minusYears(1));
		System.out.println("1 month before: " + today.minusMonths(1));
		System.out.println("yesterday: " + today.minusDays(1));
		
		System.out.println("--------------------");
		System.out.println("Using plusDate()");
		System.out.println("1 year after: " + today.plusYears(1));
		System.out.println("1 month after: " + today.plusMonths(1));
		System.out.println("tomorrow: " + today.plusDays(1));
		
		//API of dates are not imutable, so...
		System.out.println("--------------------");
		System.out.println("ALERT: API Dates are not imutable");
		LocalDate nextYear = today.plusYears(1);
		String nextYearFormated = nextYear.format(formatter);
		System.out.println(nextYearFormated);
		
		//Using formatter
		System.out.println("--------------------");
		System.out.println("Using Formatter");
		LocalDate nextYear2 = today.plusYears(1);
		String nextYearFormated2 = nextYear.format(formatter);
		System.out.println(nextYearFormated2);
		
		//Using LocalDateTime
		System.out.println("--------------------");
		System.out.println("Using LocalDateTime and formatter");
		DateTimeFormatter formatterFull = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm:ss");
		LocalDateTime todayFull = LocalDateTime.now();
		System.out.println(todayFull.format(formatterFull));
		
		//Taking the break
		System.out.println("--------------------");
		System.out.println("Taking the break");
		LocalTime pause = LocalTime.of(12,30);
		System.out.println(pause);
	}

}
