package epw.academy.service.impl;

import epw.academy.dto.CreateCourseResponse;
import epw.academy.dto.CreateCourseRequest;
import epw.academy.entity.Course;
import epw.academy.repository.CourseRepository;
import epw.academy.service.CourseService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;

    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public CreateCourseResponse createCourse(CreateCourseRequest request) {
        Course course = new Course();
        course.setName(request.getName());
        course.setDescription(request.getDescription());
        course.setDurationHours(request.getDurationHours());

        Course savedCourse = courseRepository.save(course);
        return toResponse(savedCourse);
    }

    @Override
    public List<CreateCourseResponse> listCourses() {
        return courseRepository.findAll()
                .stream()
                .map(this::toResponse)
                .toList();
    }

    private CreateCourseResponse toResponse(Course course) {
        return new CreateCourseResponse(
                course.getId(),
                course.getName(),
                course.getDescription(),
                course.getDurationHours()
        );
    }
}
