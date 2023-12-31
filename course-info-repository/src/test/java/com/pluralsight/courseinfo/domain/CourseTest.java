package com.pluralsight.courseinfo.domain;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class CourseTest {

  @Test
  void shouldThrows() {
    assertThrows(IllegalArgumentException.class,
        () -> {
          new Course("id", "", 0, "url");
        });
  }
}
