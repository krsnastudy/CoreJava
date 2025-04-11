package com.prac.core.problem.gen;

import java.util.*;
import java.util.stream.IntStream;

public class TrainSeatingArrangement_JDK8 {

    private static final int SEATS_PER_BAY = 12;
    private static final Set<Integer> WS = Set.of(1, 6);
    private static final Set<Integer> MS = Set.of(2, 5);
//    private static final Set<Integer> AS = Set.of(3, 4);

    public static void main(String[] args) {
        List<Integer> seatNumbers = Arrays.asList(12, 99, 34, 44, 41);
        seatNumbers.forEach(TrainSeatingArrangement_JDK8::printOppositeSeatDetails);
    }

    private static void printOppositeSeatDetails(int seatNumber) {
        // Compute bay range
        int bayIndex = (seatNumber - 1) / SEATS_PER_BAY;
        int minRange = bayIndex * SEATS_PER_BAY + 1;
        int maxRange = minRange + SEATS_PER_BAY - 1;

        // Create map of original to opposite using reverse indexing
        Map<Integer, Integer> seatMap = IntStream.range(0, SEATS_PER_BAY)
                .boxed()
                .collect(LinkedHashMap::new,
                        (m, i) -> m.put(minRange + i, maxRange - i),
                        LinkedHashMap::putAll);

        // Get seat type based on 6-seat module position
        int positionInModule = (seatNumber - 1) % 6 + 1;
        String seatType = getSeatType(positionInModule);

        // Output
        System.out.printf("SeatNumber: %d Opposite: %d %s%n",
                seatNumber,
                seatMap.get(seatNumber),
                seatType);
    }

    private static String getSeatType(int seatPos) {
        if (WS.contains(seatPos)) return "Window Seat";
        if (MS.contains(seatPos)) return "Middle Seat";
        return "Aisle Seat";
    }
}