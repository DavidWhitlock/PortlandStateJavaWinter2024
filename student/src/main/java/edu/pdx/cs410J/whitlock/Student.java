package edu.pdx.cs410J.whitlock;

import edu.pdx.cs410J.lang.Human;

import java.util.ArrayList;
                                                                                    
/**                                                                                 
 * This class is represents a <code>Student</code>.                                 
 */                                                                                 
public class Student extends Human {

  private double gpa;

  /**
   * Creates a new <code>Student</code>                                             
   *                                                                                
   * @param name                                                                    
   *        The student's name                                                      
   * @param classes                                                                 
   *        The names of the classes the student is taking.  A student              
   *        may take zero or more classes.                                          
   * @param gpa                                                                     
   *        The student's grade point average                                       
   * @param gender                                                                  
   *        The student's gender ("male", "female", or "other", case insensitive)
   */                                                                               
  public Student(String name, ArrayList<String> classes, double gpa, String gender)
    throws InvalidGpaException, InvalidGenderException {

    super(name);
    if (gpa > 4.0) {
      throw new InvalidGpaException();
    }
    this.gpa = gpa;

    if (gender == null) {
      throw new InvalidGenderException();
    }
  }

  /**                                                                               
   * All students say "This class is too much work"
   */
  @Override
  public String says() {                                                            
    return "This class is too much work";
  }
                                                                                    
  /**                                                                               
   * Returns a <code>String</code> that describes this                              
   * <code>Student</code>.                                                          
   */                                                                               
  public String toString() {
    return getName() + " has a GPA of " + getGpa();
  }

  private double getGpa() {
    return this.gpa;
  }

  /**
   * Main program that parses the command line, creates a
   * <code>Student</code>, and prints a description of the student to
   * standard out by invoking its <code>toString</code> method.
   */
  public static void main(String[] args) {
    if (args.length == 0) {
      System.err.println("Missing command line arguments");
      return;
    }

    // "Dave", "male", "three-point-six-four", "Algorithms", "Operating Systems", "Java");
    String gpaString = args[2];
    try {
      double gpa = Double.parseDouble(gpaString);

    } catch (NumberFormatException ex) {
      System.err.println("Invalid GPA datatype");
    }

  }
}