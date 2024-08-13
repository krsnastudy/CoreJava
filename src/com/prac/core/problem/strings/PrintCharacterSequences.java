package com.prac.core.problem.strings;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class PrintCharacterSequences {
    public static Map<Character, Integer> seqMap = new HashMap<>();
    public static void main(String[] args) {
        String input = "b3c6d15"; //"a1b2c3d4e5f11";
//        convert("a1b10");
        printCharSequence_jdk8(input);
    }

    static void printCharSeq(char c, int num) {
        while (num > 1) {
            System.out.print(c);
            num--;
        }
    }

    static void convert(String str) {
        char c[] = str.toCharArray();
        for (int i = 0; i < c.length; i++) {
            int val = 0;
            if ((c[i] >= '0' && c[i] <= '9')) {
                // val=c[i]-48;
                try {
                    if (c[i + 1] >= '0' && c[i + 1] <= '9') {
                        String a1 = String.valueOf(c[i] - 48);
                        String a2 = String.valueOf(c[i + 1] - 48);
                        val = Integer.parseInt(a1 + a2);
                        // System.out.println(val);
                        printCharSeq(c[i - 1], val);
                        i++;
                    } else {
                        val = c[i] - 48;
                        printCharSeq(c[i - 1], val);
                    }
                } catch (ArrayIndexOutOfBoundsException ex) {
                    val = c[i] - 48;
                    printCharSeq(c[i - 1], val);
                }
            } else {
                System.out.print(c[i]);
                // printCharSeq(c[i], val);
            }
        }
    }

    public static void printCharSequence_jdk8(String str){
        char[] charArray = str.toCharArray();
        Character character=null;
        StringBuffer sb = new StringBuffer();
        for(int i=0; i<str.length();i++){
//            System.out.println(str.charAt(i)+"--"+Character.isAlphabetic(str.charAt(i)));
            if(Character.isAlphabetic(str.charAt(i))){
                character = str.charAt(i);
                sb = new StringBuffer();
            }else{
                sb.append(str.charAt(i));
                seqMap.put(character, Integer.parseInt(sb.toString()));
            }
        }
        System.out.println("Given String: "+str);
        System.out.println("Input Char Sequence Map: "+seqMap+"\nOutput Sequence");
        seqMap.entrySet().stream()
                         .forEach(e->{
                            IntStream.rangeClosed(1, e.getValue())
                                     .mapToObj(m->e.getKey())
                                     .forEach(System.out::print);
                         });
    }
}


/*
* https://codeproject.com/Questions/1240458/A-program-to-give-the-following-output-for-the-giv
*
*Eg 1: Input: a1b10
       Output: abbbbbbbbbb
Eg: 2: Input: b3c6d15
       Output: bbbccccccddddddddddddddd
The number varies from 1 to 99.
* */