package com.pluralsight.courseinfo.cli;

import com.pluralsight.courseinfo.cli.service.CourseRetrievalService;
import com.pluralsight.courseinfo.cli.service.PluralsightCourse;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CourseRetriever {

  private static final Logger LOG = LoggerFactory.getLogger(CourseRetriever.class);

  public static void main(String... args) {
    LOG.info("CourseRetriever started!");

    if (args.length == 0) {
      LOG.warn("Please provide an author name as first argument.");
      return;
    }

    try {
      retrieveCourses(args[0]);
    } catch (Exception e) {
      LOG.error("Unexpected error", e);
    }
  }

  private static void retrieveCourses(String author) {
    LOG.info("Retrieving courses for author '{}'", author);
    CourseRetrievalService courseRetrievalService = new CourseRetrievalService();
    List<PluralsightCourse> coursesToStore = courseRetrievalService.getCoursesFor(author);
    LOG.info("Retrieved the following {} courses {}", coursesToStore.size(),
        coursesToStore);
  }
}
