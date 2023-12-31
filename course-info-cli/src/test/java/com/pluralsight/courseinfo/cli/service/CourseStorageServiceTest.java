package com.pluralsight.courseinfo.cli.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.pluralsight.courseinfo.domain.Course;
import com.pluralsight.courseinfo.repository.CourseRepository;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class CourseStorageServiceTest {

  @Test
  void storePluralsightCourses() {
    CourseRepository repository = new InMemoryCourseRepository();
    CourseStorageService courseStorageService = new CourseStorageService(repository);

    PluralsightCourse pluralsightCourse = new PluralsightCourse("1", "Title-1", "01:40:00", "/url-1", false);
    courseStorageService.storePluralsightCourses(List.of(pluralsightCourse));

    Course expected = new Course("1", "Title-1", 100, "https://app.pluralsight.com/url-1");

    assertEquals(List.of(expected), repository.getAllCourses());
  }

  static class InMemoryCourseRepository implements CourseRepository {

    private final List<Course> courses = new ArrayList<>();

    @Override
    public List<Course> getAllCourses() {
      return courses;
    }

    @Override
    public void saveCourse(Course course) {
      courses.add(course);
    }
  }
}
