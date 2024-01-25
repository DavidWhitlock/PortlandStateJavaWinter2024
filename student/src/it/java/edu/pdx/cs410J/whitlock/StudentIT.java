package edu.pdx.cs410J.whitlock;

import edu.pdx.cs410J.InvokeMainTestCase;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.StringContains.containsString;

/**
 * Integration tests for the <code>Student</code> class's main method.
 * These tests extend <code>InvokeMainTestCase</code> which allows them
 * to easily invoke the <code>main</code> method of <code>Student</code>.
 */
class StudentIT extends InvokeMainTestCase {

  @Test
  void invokingMainWithNoArgumentsPrintsMissingArgumentsToStandardError() {
    InvokeMainTestCase.MainMethodResult result = invokeMain(Student.class);
    assertThat(result.getTextWrittenToStandardError(), containsString("Missing command line arguments"));
  }

  @Test
  void invalidGpaPrintsErrorToStandardError() {
    InvokeMainTestCase.MainMethodResult result = invokeMain(Student.class, "Dave", "male", "three-point-six-four", "Algorithms", "Operating Systems", "Java");
    assertThat(result.getTextWrittenToStandardError(), containsString("Invalid GPA datatype"));
  }

  @Test
  void missingGpaArgumentPrintsErrorToStandardError() {
    InvokeMainTestCase.MainMethodResult result = invokeMain(Student.class, "Dave", "male");
    assertThat(result.getTextWrittenToStandardError(), containsString("GPA required"));
  }

  @Test
  void missingGenderArgumentPrintsErrorToStandardError() {
    InvokeMainTestCase.MainMethodResult result = invokeMain(Student.class, "Dave");
    assertThat(result.getTextWrittenToStandardError(), containsString("Gender required"));
  }

  @Test
  void gpaGreaterThan40() {
    InvokeMainTestCase.MainMethodResult result = invokeMain(Student.class, "Dave", "male", "5.0");
    assertThat(result.getTextWrittenToStandardError(), containsString("Invalid GPA"));
  }
}
