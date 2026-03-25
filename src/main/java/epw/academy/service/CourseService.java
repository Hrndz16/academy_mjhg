package epw.academy.service;

import epw.academy.dto.CourseResponse;
import epw.academy.dto.CreateCourseRequest;

import java.util.List;

public interface CourseService {

    CourseResponse createCourse(CreateCourseRequest request);

    List<CourseResponse> listCourses();
}
