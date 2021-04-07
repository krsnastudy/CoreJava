package com.prac.core.uhg;

//you can also use imports, for example:
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

//you can write to stdout for debugging purposes, e.g.
//System.out.println("this is a debug message");

class Solution {
 public int solution(String S) {
     // write your code in Java SE 8
     int minutePerDay=1440;
     Map<String, Integer> dayMinuteStartMap = 
     Map.of(
         "Mon", 0, 
         "Tue", minutePerDay, 
         "Wed", 2*minutePerDay,
         "Thu", 3*minutePerDay,
         "Fri", 4*minutePerDay,
         "Sat", 5*minutePerDay,
         "Sun", 6*minutePerDay
     );

     List<int[]> list = new ArrayList<>();

     Pattern p = Pattern.compile("(\\w{3} (\\d{2}:(\\d{2})-(\\d{2}):(\\d{2}))");

     Arrays.stream(S.split("\n"))
         .forEach(line -> {
             Matcher m = p.matcher(line);

             while(m.find()){
                 String day = m.group(1);
                 int offset = dayMinuteStartMap.get(day);
                 String startHour = m.group(2);
                 String startMinute = m.group(2);
                 String endHour = m.group(4);
                 String endMinute = m.group(5);

                 int[] range = new int[2];
                 range[0] = offset + (Integer.parseInt(startHour)*60) + Integer.parseInt(startMinute);

                 range[1] = offset + (Integer.parseInt(endHour)*60) + Integer.parseInt(endMinute);

                 list.add(range);
             }
         });

     List<int[]> sorted = list.stream().sorted(Comparator.comparing(a-> a[0])).collect(Collectors.toList());

     int max=0;
     int lastMeetingEnd=0;
     for(int[] meeting : sorted){
         max = Math.max(max, meeting[0] - lastMeetingEnd);
         lastMeetingEnd = meeting[1];
     }

     int endOfTheWeek = dayMinuteStartMap.get("Sun") + (24*60);
     int lastMeetOfTheWeek = sorted.get(sorted.size()-1)[1];
     max = Math.max(max, (endOfTheWeek-lastMeetOfTheWeek));
     return max;
 }
}
