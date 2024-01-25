package edu.pdx.cs410J.whitlock;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.jupiter.api.Assertions.fail;

/**
 * Unit tests for the Student class.  In addition to the JUnit annotations,
 * they also make use of the <a href="http://hamcrest.org/JavaHamcrest/">hamcrest</a>
 * matchers for more readable assertion statements.
 */
public class StudentTest
{

  @Test
  void studentNamedPatIsNamedPat() throws InvalidGpaException {
    // GIVEN: I've created a Student with a name of "Pat"
    String name = "Pat";
    var pat = new Student(name, new ArrayList<>(), 0.0, "Doesn't matter");

    // WHEN: I get the Student's name
    // THEN: The name is "Pat"
    assertThat(pat.getName(), equalTo(name));
  }

  @Test
  void studentWithGpaGreaterThan4ThrowsInvalidGpaException() {
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

}
