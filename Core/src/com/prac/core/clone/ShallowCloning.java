package com.prac.core.clone;

public class ShallowCloning 
{
 
    public static void main(String[] args) throws CloneNotSupportedException
    {
        Department dept = new Department(1, "Human Resource");
        Employee original = new Employee(1, "Admin", dept);

        System.out.println("Before Modification: ");
        System.out.println("Original Object: "+original.toString());
        
        //Lets create a clone of original object
        Employee sCopy = (Employee) original.clone();
        System.out.println("  Cloned Object: "+sCopy.toString());
        
        //Let verify using employee id, if cloning actually worked
//        System.out.println("Cloned EmployeeId: "+sCopy.getEmpoyeeId());
 
        //Verify JDK's rules
        System.out.println();
        //Must be true and objects must have different memory addresses
        System.out.println("Comparing memory addresses: "+(original != sCopy));
 
        //As we are returning same class; so it should be true
        System.out.println("Both return same class: "+(original.getClass() == sCopy.getClass()));
 
        //Default equals method checks for references so it should be false. If we want to make it true,
        //then we need to override equals method in Employee class.
        System.out.println("Default equals method checks for references: "+(original.equals(sCopy)));
        
        //Let change the department name in cloned object and we will verify in original object
        sCopy.getDepartment().setName("Finance");
 
//        System.out.println("\nOriginal Dept Name: "+original.getDepartment().getName());
//        System.out.println("Cloned Dept Name: "+sCopy.getDepartment().getName());
        System.out.println("\nAfter Modification: ");
        System.out.println("Original Object: "+original.toString());
        System.out.println("  Cloned Object: "+sCopy.toString());
    }
    
    
}
