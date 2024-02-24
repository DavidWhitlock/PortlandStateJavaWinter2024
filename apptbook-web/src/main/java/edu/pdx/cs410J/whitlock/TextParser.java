package edu.pdx.cs410J.whitlock;

import edu.pdx.cs410J.AppointmentBookParser;
import edu.pdx.cs410J.ParserException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextParser implements AppointmentBookParser<AppointmentBook> {
  private final Reader reader;

  public TextParser(Reader reader) {
    this.reader = reader;
  }

  @Override
  public AppointmentBook parse() throws ParserException {
    Pattern pattern = Pattern.compile("(.*) : (.*)");

    try (
      BufferedReader br = new BufferedReader(this.reader)
    ) {

      for (String line = br.readLine(); line != null; line = br.readLine()) {
        Matcher matcher = pattern.matcher(line);
        if (!matcher.find()) {
          throw new ParserException("Unexpected text: " + line);
        }

        String owner = matcher.group(1);
        String description = matcher.group(2);

        AppointmentBook book = new AppointmentBook(owner);
        book.addAppointment(new Appointment(description));
        return book;
      }

    } catch (IOException e) {
      throw new ParserException("While parsing appointment book", e);
    }

    return null;
  }
}
