package com.prac.core.problem;

import java.util.TreeSet;

public class Combinations {
    private StringBuilder output = new StringBuilder();
    public static TreeSet<String> hSet = new TreeSet<>();
    private final String inputstring;
    public Combinations( final String str ){
        inputstring = str;
        System.out.println("The input string  is  : " + inputstring);
    }
    
    public static void main (String args[])
    {
        Combinations combobj= new Combinations("madam");
        System.out.println("");
        System.out.println("All possible combinations are :  ");
        combobj.combine();
        System.out.println("Size: "+hSet.size());
        hSet.forEach(x-> System.out.println(x));
        
    }
    
    public void combine() { combine( 0 ); }
    
    private void combine(int start ){
        for( int i = start; i < inputstring.length(); ++i ){
        	output.append( inputstring.charAt(i) );
        	if(output.toString().length()>1) {
        		hSet.add(output.toString());	
        	}
        	
            //System.out.println( output.toString() );
            if ( i < inputstring.length() )
            combine( i + 1);
            output.setLength( output.length() - 1 );
        }
    }
    
    public TreeSet<String> getData(){
    	
    	return hSet;
    }
} 