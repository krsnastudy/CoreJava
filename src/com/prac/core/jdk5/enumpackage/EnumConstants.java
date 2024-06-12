package com.prac.core.jdk5.enumpackage;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public enum EnumConstants {

	ALL("all", "all"), SUNDAY("Sunday", 0), MONDAY("Monday", 1), TUESDAY("Tuesday", 2), WEDNESDAY("Wednesday", 3),
	THURSDAY("Thursday", 4), FRIDAY("Friday", 5), SATURDAY("Saturday", 6);

	private final String key;
	private final String value;
	private final Integer intValue;
	private final LocalDate localDateValue;
	private final LocalTime localTimeValue;
	private final LocalDateTime localDateTimeValue;

	public String getKey() {
		return key;
	}

	public String getValue() {
		return value;
	}

	public Integer getIntValue() {
		return intValue;
	}

	public LocalDate getLocalDateValue() {
		return localDateValue;
	}

	public LocalTime getLocalTimeValue() {
		return localTimeValue;
	}

	public LocalDateTime getLocalDateTimeValue() {
		return localDateTimeValue;
	}

	EnumConstants(String key, String value) {
		this.key = key;
		this.value = value;
		this.intValue = null;
		this.localDateValue = null;
		this.localTimeValue = null;
		this.localDateTimeValue = null;
	}

	EnumConstants(String key, Integer intValue) {
		this.key = key;
		this.value = "";
		this.intValue = intValue;
		this.localDateValue = null;
		this.localTimeValue = null;
		this.localDateTimeValue = null;
	}

	EnumConstants(String key, LocalDate localDateValue) {
		this.key = key;
		this.value = "";
		this.intValue = null;
		this.localDateValue = localDateValue;
		this.localTimeValue = null;
		this.localDateTimeValue = null;
	}
}
