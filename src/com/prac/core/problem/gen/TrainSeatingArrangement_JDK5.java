package com.prac.core.problem.gen;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class TrainSeatingArrangement_JDK5 {

    public static final int NO_OF_SEATS = 12; // Number of seats in a train bay
    public static String SEAT_TYPE = "";      // Type of the seat: WS, MS, AS
    public static int BAY_INDEX = 0;          // Bay index of the seat (1-based)
    public static int MIN_RANGE = 0;          // Starting seat number in the bay
    public static int MAX_RANGE = 0;          // Ending seat number in the bay

    // Seat types
    public static String SEAT_TYPE_WS = "WS"; // Window Seat
    public static String SEAT_TYPE_MS = "MS"; // Middle Seat
    public static String SEAT_TYPE_AS = "AS"; // Aisle Seat

    public static void main(String[] args) {

        // Sample list of seat numbers
        List<Integer> list = new ArrayList<>();
        list.add(12);
        list.add(99);
        list.add(34);
        list.add(44);
        list.add(41);

        // Process each seat number to get its opposite seat and type
        for (Integer integer : list) {
            getOppSeat(integer);
        }
    }

    private static void getOppSeat(int seatNumber) {
        int sNumber = seatNumber;

        // Define seat types based on position in each set of 6
        List<Integer> WS = new ArrayList<>(); // Window seats
        List<Integer> MS = new ArrayList<>(); // Middle seats
        List<Integer> AS = new ArrayList<>(); // Aisle seats

        // In every 6-seat group, positions 1 and 6 are WS
        WS.add(1);
        WS.add(6);

        // Positions 2 and 5 are MS
        MS.add(2);
        MS.add(5);

        // Positions 3 and 4 are AS
        AS.add(3);
        AS.add(4);

        // Reduce seat number to its equivalent position within a 6-seat set
        while (sNumber > 6) {
            sNumber = sNumber - 6;
        }

        // Determine seat type based on its reduced position
        if (WS.contains(sNumber)) {
            SEAT_TYPE = "WS";
        } else if (MS.contains(sNumber)) {
            SEAT_TYPE = "MS";
        } else {
            SEAT_TYPE = "AS";
        }

        // Calculate bay index for the given seat (1-based)
        if ((seatNumber % NO_OF_SEATS) == 0)
            BAY_INDEX = (seatNumber / NO_OF_SEATS);
        else
            BAY_INDEX = (seatNumber / NO_OF_SEATS) + 1;

        // Calculate the min and max seat numbers for the current bay
        MAX_RANGE = BAY_INDEX * 12;
        MIN_RANGE = (MAX_RANGE - NO_OF_SEATS) + 1;

        // Map each seat in the bay to its opposite seat
        Map<Integer, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < 12; i++) {
            map.put(MIN_RANGE + i, MAX_RANGE - i);
        }

        // Print the seat number, its opposite, and its type
        System.out.println("SeatNumber: " + seatNumber + " Opposite: " + map.get(seatNumber) + " " + SEAT_TYPE);
    }
}
/**
 * https://www.hackerearth.com/practice/basic-programming/input-output/basics-of-input-output/practice-problems/algorithm/seating-arrangement-1/
 * <p>
 * TL;DR Summary:
 * Each train bay has 12 seats.
 * <p>
 * Opposite seat logic is symmetrical within the bay (e.g., 1↔12, 2↔11, ..., 6↔7).
 * <p>
 * The seat type (WS/MS/AS) is derived from the reduced position within a 6-seat module.
 * <p>
 * A Map is used to find the opposite seat in constant time for each bay.
 **/
