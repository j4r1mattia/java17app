package com.pluralsight.courseinfo.domain;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Optional;
import org.junit.jupiter.api.Test;

class CourseTest {

  @Test
  void shouldThrows() {
    assertThrows(IllegalArgumentException.class, () -> {
      new Course("id", "title", 0, "url", Optional.of(""));
    });
  }
}
