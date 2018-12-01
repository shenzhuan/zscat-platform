package com.zscat.common.utils;

import com.zscat.common.enums.Gender;
import org.apache.commons.codec.binary.Base64;

import java.math.BigDecimal;
import java.nio.charset.Charset;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.regex.Pattern;

public class Utils {
    private static Pattern INTEGER_PATTERN = Pattern.compile("^[-\\+]?[\\d]*$");

	public static String  calculateLevel(int score){
		if (score == 100){
			return "S+";
		}else if(95<=score&& score<100){
			return "S";
		}else if(90<=score&& score<95){
			return "A";
		}else if(80<=score&& score<90){
			return "B";
		}else if(70<=score&& score<80){
			return "C";
		}else if(0<=score&& score<70){
			return "F";
		}
		return null;
	}
	public static int calculateWeek(Date source,Date date){
		if(source.after(date)){
			return 1;
		}
		int week = 0;
		Calendar cal = Calendar.getInstance();
		cal.setTime(source);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		while(true){
			if(!calendar.before(cal)){
				cal.add(Calendar.DAY_OF_YEAR, 7);
				week++;
			}else{
				break;
			}
		}
		return week;
	}

	public static int calculateDays(Date first,Date second){
		if(second.before(first)){
			return 1;
		}
        Calendar calendar1 = Calendar.getInstance();
        calendar1.setTime(first);
        calendar1.set(Calendar.HOUR_OF_DAY, 0);
        calendar1.set(Calendar.MINUTE, 0);
        calendar1.set(Calendar.SECOND, 0);
        calendar1.set(Calendar.MILLISECOND, 0);
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTime(second);
        calendar2.set(Calendar.HOUR_OF_DAY, 0);
        calendar2.set(Calendar.MINUTE, 0);
        calendar2.set(Calendar.SECOND, 0);
        calendar2.set(Calendar.MILLISECOND, 0);
        int days = 1;
        while(calendar1.compareTo(calendar2)!=0){
            calendar1.add(Calendar.DAY_OF_YEAR, 1);
            days++;
        }
        return days;
	}

	public static int calculateBodyDataWeek(Date source,Date date){
		int week = 0;
		Calendar cal = Calendar.getInstance();
		cal.setTime(source);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.add(Calendar.DAY_OF_YEAR, 5);
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.HOUR_OF_DAY, 23);
		calendar.set(Calendar.MINUTE, 59);
		calendar.set(Calendar.SECOND, 59);
		while(true){
			if(cal.getTime().before(calendar.getTime())){
				cal.add(Calendar.DAY_OF_YEAR, 7);
				week++;
			}else{
				break;
			}
		}
		return week;
	}
	/*public static Date calculateBodyDataDateNew(Date source,int week){
		Calendar cal = Calendar.getInstance();
		cal.setTime(source);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.add(Calendar.DAY_OF_YEAR,  week  * 7);
		return cal.getTime();
	}*/
	public static int calculateBodyDataWeekNo(Date source,Date date){
		int week = 0;
		Calendar cal = Calendar.getInstance();
		cal.setTime(source);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.add(Calendar.DAY_OF_YEAR, 7);
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.HOUR_OF_DAY, 23);
		calendar.set(Calendar.MINUTE, 59);
		calendar.set(Calendar.SECOND, 59);
		while(true){
			if(cal.getTime().before(calendar.getTime())){
				cal.add(Calendar.DAY_OF_YEAR, 7);
				week++;
			}else{
				break;
			}
		}
		return week;
	}
	public static Date calculateBodyDataDate(Date source,int week){
		Calendar cal = Calendar.getInstance();
		cal.setTime(source);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		if(week==0){
			cal.add(Calendar.DAY_OF_YEAR, 5);
		}else{
			cal.add(Calendar.DAY_OF_YEAR, 5 + (week - 1) * 7);
		}
		return cal.getTime();
	}
	public static Date calculateBodyDataDateNew(Date source,int week){
		Calendar cal = Calendar.getInstance();
		cal.setTime(source);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
			cal.add(Calendar.DAY_OF_YEAR,  week  * 7);
		return cal.getTime();
	}

	public static String dateString(long timestamp, int clientTimeZoneOffset) {
		ZonedDateTime clientDateTime =  ZonedDateTime.ofInstant(Instant.ofEpochSecond(timestamp), ZoneId.of("UTC")).withZoneSameInstant(ZoneId.ofOffset("", ZoneOffset.ofTotalSeconds(-60 * clientTimeZoneOffset)));
		return clientDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
	}

	public static String dateString(int clientTimezoneOffset) {
		ZonedDateTime clientDateTime =  ZonedDateTime.now().withZoneSameInstant(ZoneId.ofOffset("", ZoneOffset.ofTotalSeconds(-60 * clientTimezoneOffset)));
		return clientDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
	}

	public static double getBmi(double height,double weight){
		BigDecimal heightM = new BigDecimal(height).divide(new BigDecimal(100), 2,BigDecimal.ROUND_HALF_DOWN);
		// 2位小数
		BigDecimal square = heightM.multiply(heightM);
		// 按2位小数计算结果
		BigDecimal bmi = new BigDecimal(weight).divide(square, 2, BigDecimal.ROUND_HALF_DOWN);
		return bmi.doubleValue();
	}

	public static double weightAvgByBMI(double height,double bmi){
		BigDecimal heightM = new BigDecimal(height).divide(new BigDecimal(100), 2,BigDecimal.ROUND_HALF_DOWN);
		BigDecimal bmiM = new BigDecimal(bmi).divide(new BigDecimal(1), 2,BigDecimal.ROUND_HALF_DOWN);
		// 2位小数
		BigDecimal square = heightM.multiply(heightM).multiply(bmiM);
		// 按2位小数计算结果
		BigDecimal weightAvg = new BigDecimal(square.doubleValue()).divide(new BigDecimal(1), 2, BigDecimal.ROUND_HALF_DOWN);
		return weightAvg.doubleValue();
	}


	public static int getBaseCalories(double weight, int height, int age, String gender) {
		Double bmr = 0d;
		if (Gender.M.name().equals(gender)) {
			bmr += 9.99F * weight + 6.25F * height - 4.92F * age + 5F;
		} else {
			bmr += 9.99F * weight + 6.25F * height - 4.92F * age - 161F;
		}
		bmr *= 1.1F;
		return bmr.intValue();
	}

	public static String xorEncrypt(String text) {
	    int key = 1945769823;
	    byte[] bytes = text.getBytes(Charset.forName("utf-8"));
	    for (int i = 0; i < bytes.length; i++) {
	      bytes[i] ^= key;
	    }
	    return Base64.encodeBase64URLSafeString(bytes);
	  }

	 public static String xorDecrypt(String text) {
	    int key = 1945769823;
	    byte[] bytes = Base64.decodeBase64(text);
	    for (int i = 0; i < bytes.length; i++) {
	      bytes[i] ^= key;
	    }
	    return new String(bytes, Charset.forName("utf-8"));
	 }

	 public static double oneDecimalDouble(double totalCalorie){

		 BigDecimal decimal = new BigDecimal(totalCalorie);
		 BigDecimal setScale = decimal.setScale(1,BigDecimal.ROUND_HALF_DOWN);
		 return setScale.doubleValue();

	 }

	public static BigDecimal oneDecimal(double totalCalorie){

		BigDecimal decimal = new BigDecimal(totalCalorie);
		BigDecimal setScale = decimal.setScale(1,BigDecimal.ROUND_HALF_DOWN);
		return setScale;

	}

	public static boolean isInteger(String str) {
		return INTEGER_PATTERN.matcher(str).matches();
	}

	public static int getRanddomCount(int count) {
		Random rand = new Random();
		return rand.nextInt(count);

	}
}
