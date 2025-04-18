package com.prac.core.jdks.jdk8.stream.employee.data;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Department {
	  private static final Random RANDOM = new Random();
	  private static final List<DepartmentCode> VALUES = Collections.unmodifiableList(Arrays.asList(DepartmentCode.values()));
	  private static final int SIZE = VALUES.size();
	  
	  public static DepartmentCode getRandomDepartment()  {
	    return VALUES.get(RANDOM.nextInt(SIZE));
	  }
	  
	  public enum DepartmentCode{ Admin, Finance, IT, Travel, Infra; }
 }
	