package epw.academy.service.impl;

import epw.academy.dto.CreateCourseResponse;
import epw.academy.dto.CreateCourseRequest;
import epw.academy.entity.Course;
import epw.academy.entity.Instructor;
import epw.academy.repository.CourseRepository;
import epw.academy.repository.InstructorRepository;
import epw.academy.service.CourseService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;
    private final InstructorRepository instructorRepository;

    public CourseServiceImpl(CourseRepository courseRepository, InstructorRepository instructorRepository) {
        this.courseRepository = courseRepository;
        this.instructorRepository = instructorRepository;
    }

    @Override
    public CreateCourseResponse createCourse(CreateCourseRequest request) {
        Instructor instructor = instructorRepository.findById(request.getInstructorId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Instructor not found"));

        Course course = new Course();
        course.setName(request.getName());
        course.setDescription(request.getDescription());
        course.setDurationHours(request.getDurationHours());
        course.setInstructor(instructor);

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
                course.getDurationHours(),
                course.getInstructor().getId(),
                course.getInstructor().getName()
        );
    }
}
