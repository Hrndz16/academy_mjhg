package epw.academy.service;

import epw.academy.dto.CreateCourseResponse;
import epw.academy.dto.CreateCourseRequest;

import java.util.List;

public interface CourseService {

    CreateCourseResponse createCourse(CreateCourseRequest request);

    List<CreateCourseResponse> listCourses();
}
