package edu.pdx.cs410J.whitlock;

import edu.pdx.cs410J.ParserException;
import edu.pdx.cs410J.web.HttpRequestHelper;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.StringWriter;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AppointmentBookRestClientTest {

  private HttpRequestHelper.Response appointmentBookAsText(AppointmentBook book) {
    StringWriter writer = new StringWriter();
    new TextDumper(writer).dump(book);

    return new HttpRequestHelper.Response(writer.toString());
  }
}
