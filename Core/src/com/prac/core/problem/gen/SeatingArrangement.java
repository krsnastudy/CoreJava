package com.prac.core.problem.gen;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class SeatingArrangement {

	public static final int NO_OF_SEATS = 12;
	public static String SEAT_TYPE = "";
	public static int BAY_INDEX = 0;
	public static int MIN_RANGE = 0;
	public static int MAX_RANGE = 0;
	public static String SEAT_TYPE_WS = "WS";
	public static String SEAT_TYPE_MS = "MS";
	public static String SEAT_TYPE_AS = "AS";

	public static void main(String[] args) {

		List<Integer> list = new ArrayList<>();
		list.add(12);
		list.add(99);
		list.add(34);
		list.add(44);
		list.add(41);

		for (Integer integer : list) {
			getOppSeat(integer);
		}
	}

	private static void getOppSeat(int seatNumber) {
		int sNumber = seatNumber;
		List<Integer> WS = new ArrayList<>();
		List<Integer> MS = new ArrayList<>();
		List<Integer> AS = new ArrayList<>();

		WS.add(1);
		WS.add(6);

		MS.add(2);
		MS.add(5);

		AS.add(3);
		AS.add(4);

		while (sNumber > 6) {
			sNumber = sNumber - 6;
		}

		if (WS.contains(sNumber)) {
			SEAT_TYPE = "WS";
		} else if (MS.contains(sNumber)) {
			SEAT_TYPE = "MS";
		} else {
			SEAT_TYPE = "AS";
		}

		if ((seatNumber % NO_OF_SEATS) == 0)
			BAY_INDEX = (seatNumber / NO_OF_SEATS);
		else
			BAY_INDEX = (seatNumber / NO_OF_SEATS) + 1;

		MAX_RANGE = BAY_INDEX * 12;
		MIN_RANGE = (MAX_RANGE - NO_OF_SEATS) + 1;

		Map<Integer, Integer> map = new LinkedHashMap<>();
		for (int i = 0; i < 12; i++) {
			map.put(MIN_RANGE + i, MAX_RANGE - i);
		}
		System.out.println("SeatNumber: " + seatNumber + " Opposite: " + map.get(seatNumber) + " " + SEAT_TYPE);
	}
}

// https://www.hackerearth.com/practice/basic-programming/input-output/basics-of-input-output/practice-problems/algorithm/seating-arrangement-1/