package edu.pdx.cs410J.whitlock;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.startsWith;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.jupiter.api.Assertions.fail;

/**
 * Unit tests for the Student class.  In addition to the JUnit annotations,
 * they also make use of the <a href="http://hamcrest.org/JavaHamcrest/">hamcrest</a>
 * matchers for more readable assertion statements.
 */
public class StudentTest
{

  private Student dave;

  @BeforeEach
  void createDaveStudent() throws InvalidGpaException, InvalidGenderException {
    ArrayList<String> classes = new ArrayList<>();
    classes.add("Algorithms");
    classes.add("Operating Systems");
    classes.add("Java");
    this.dave = new Student("Dave", classes, 3.64, "male");
  }

  @Test
  void studentNamedPatIsNamedPat() throws InvalidGpaException, InvalidGenderException {
    // GIVEN: I've created a Student with a name of "Pat"
    String name = "Pat";
    var pat = new Student(name, new ArrayList<>(), 0.0, "Doesn't matter");

    // WHEN: I get the Student's name
    // THEN: The name is "Pat"
    assertThat(pat.getName(), equalTo(name));
  }

  @Test
  void studentWithGpaGreaterThan4ThrowsInvalidGpaException() throws InvalidGenderException {
    // GIVEN: A student named "Sharon" who is
    //        taking "Java" and "Front End"
    //        has a GPA of 5.00
    //        has a "female" gender
    ArrayList<String> classes = new ArrayList<>();
    classes.add("Java");
    classes.add("Front End");

    // WHEN: That student is created
    // THEN: A InvalidGpaException is thrown
    try {
      new Student("Sharon", classes, 5.0, "female");
      fail("Should have thrown an InvalidGpaException");

    } catch (InvalidGpaException ex) {
      // We expect this exception
    }
  }

  @Disabled
  @Test
  void daveStudentFromTheAssignment() {
    assertThat(dave.toString(), equalTo("Dave has a GPA of 3.64 and is taking 3 classes: Algorithms, Operating Systems, and Java.  He says \"This class is too much work\"."));
  }

  @Test
  void allStudentsSayThisClassIsTooMuchWork() {
    assertThat(dave.says(), equalTo("This class is too much work"));
  }

  @Test
  void toStringContainsStudentName() {
    assertThat(dave.toString(), startsWith("Dave"));
  }

  @Test
  void toStringContainsGpa() {
    assertThat(dave.toString(), containsString("has a GPA of 3.64"));
  }

  @Disabled
  @Test
  void toStringContainsTheNumberOfClasses() {
    assertThat(dave.toString(), containsString("3"));
  }

  @Test
  void nullGenderThrowsInvalidGenderException() throws InvalidGpaException {
    try {
      new Student("Name", new ArrayList<>(), 3.5, null);
      fail("Should have thrown an InvalidGenderException");

    } catch (InvalidGenderException ex) {
      // We expect this
    }
  }

}
