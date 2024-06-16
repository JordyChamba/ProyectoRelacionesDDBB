package ec.edu.uce.ProyectoRelacionesDDBB;

import ec.edu.uce.ProyectoRelacionesDDBB.ManytoMany.model.CourseManyToMany;
import ec.edu.uce.ProyectoRelacionesDDBB.ManytoMany.model.StudentManyToMany;
import ec.edu.uce.ProyectoRelacionesDDBB.ManytoMany.service.CourseManyToManyService;
import ec.edu.uce.ProyectoRelacionesDDBB.ManytoMany.service.StudentManyToManyService;
import ec.edu.uce.ProyectoRelacionesDDBB.ManytoOne.model.GradeManyToOne;
import ec.edu.uce.ProyectoRelacionesDDBB.ManytoOne.model.StudentManyToOne;
import ec.edu.uce.ProyectoRelacionesDDBB.ManytoOne.service.GradeManyToOneService;
import ec.edu.uce.ProyectoRelacionesDDBB.ManytoOne.service.StudentManyToOneService;
import ec.edu.uce.ProyectoRelacionesDDBB.OnetoMany.model.GradeOnetoMany;
import ec.edu.uce.ProyectoRelacionesDDBB.OnetoMany.model.StudentOnetoMany;
import ec.edu.uce.ProyectoRelacionesDDBB.OnetoMany.service.GradeServiceOnetoMany;
import ec.edu.uce.ProyectoRelacionesDDBB.OnetoMany.service.StudentServiceOnetoMany;
import ec.edu.uce.ProyectoRelacionesDDBB.OnetoOne.Model.CourseOnetoOne;
import ec.edu.uce.ProyectoRelacionesDDBB.OnetoOne.Model.StudentOnetoOne;
import ec.edu.uce.ProyectoRelacionesDDBB.OnetoOne.Service.StudentServiceOneToOne;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class ProyectoRelacionesDdbbApplication implements CommandLineRunner {

	@Autowired
	private StudentServiceOneToOne oneToOneStudentServiceOneToOne;

	@Autowired
	private StudentServiceOnetoMany oneToManyStudentService;
	@Autowired
	private GradeServiceOnetoMany oneToManyGradeService;
	@Autowired
	private StudentManyToOneService studentManyToOneService;

	@Autowired
	private GradeManyToOneService gradeManyToOneService;
	@Autowired
	private StudentManyToManyService studentManyToManyService;
	@Autowired
	private CourseManyToManyService courseManyToManyService;

	public static void main(String[] args) {
		SpringApplication.run(ProyectoRelacionesDdbbApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.println("Seleccione una opción:");
			System.out.println("1. One-to-One");
			System.out.println("2. One-to-Many");
			System.out.println("3. Many-to-One");
			System.out.println("4. Many-to-Many");
			System.out.println("5. Salir");
			int choice = scanner.nextInt();
			scanner.nextLine(); // consume newline

			switch (choice) {
				case 1:
					exampleOneToOne();
					break;
				case 2:
					exampleOneToMany();
					break;
				case 3:
					exampleManyToOne();
					break;
				case 4:
					exampleManyToMany();
					break;
				case 5:
					System.out.println("Saliendo...");
					return;
				default:
					System.out.println("Opción no válida. Intente de nuevo.");
			}
		}
	}

	private void exampleOneToOne() {
		CourseOnetoOne courseOnetoOne1 = new CourseOnetoOne(null, "Math 101", null);
		StudentOnetoOne studentOnetoOne1 = new StudentOnetoOne(null, "Juan Orlando", courseOnetoOne1);
		courseOnetoOne1.setStudentOnetoOne(studentOnetoOne1);

		CourseOnetoOne courseOnetoOne2 = new CourseOnetoOne(null, "History 202", null);
		StudentOnetoOne studentOnetoOne2 = new StudentOnetoOne(null, "Pedro Bolivar", courseOnetoOne2);
		courseOnetoOne2.setStudentOnetoOne(studentOnetoOne2);

		oneToOneStudentServiceOneToOne.createStudent(studentOnetoOne1);
		oneToOneStudentServiceOneToOne.createStudent(studentOnetoOne2);

		oneToOneStudentServiceOneToOne.getAllStudents().forEach(studentOnetoOne -> {
			System.out.println(studentOnetoOne.toString());
		});
	}

	private void exampleOneToMany() {
		// Crear estudiantes
		StudentOnetoMany student1 = new StudentOnetoMany(null, "Juan Pérez", null);
		StudentOnetoMany student2 = new StudentOnetoMany(null, "María Garcia", null);

		// Guardar estudiantes
		oneToManyStudentService.saveStudent(student1);
		oneToManyStudentService.saveStudent(student2);

		// Crear y guardar calificaciones
		GradeOnetoMany grade1 = new GradeOnetoMany(null, "Math", 90.0, student1);
		GradeOnetoMany grade2 = new GradeOnetoMany(null, "History", 85.0, student1);
		GradeOnetoMany grade3 = new GradeOnetoMany(null, "Math", 78.0, student2);
		GradeOnetoMany grade4 = new GradeOnetoMany(null, "History", 92.0, student2);

		oneToManyGradeService.saveGrade(grade1);
		oneToManyGradeService.saveGrade(grade2);
		oneToManyGradeService.saveGrade(grade3);
		oneToManyGradeService.saveGrade(grade4);

		// Obtener todos los estudiantes con sus calificaciones
		List<StudentOnetoMany> students = oneToManyStudentService.getAllStudentsWithGrades();

		for (StudentOnetoMany student : students) {
			System.out.println(student.toString());
		}
	}



	private void exampleManyToOne() {
		// Crear estudiantes
		StudentManyToOne student1 = new StudentManyToOne(null, "Juan Pérez", null);
		StudentManyToOne student2 = new StudentManyToOne(null, "María Garcia", null);

		// Crear calificaciones
		GradeManyToOne grade1 = new GradeManyToOne(null, "Math", 90.0, student1);
		GradeManyToOne grade2 = new GradeManyToOne(null, "History", 85.0, student1);
		GradeManyToOne grade3 = new GradeManyToOne(null, "Math", 78.0, student2);
		GradeManyToOne grade4 = new GradeManyToOne(null, "History", 92.0, student2);

		// Guardar estudiantes
		studentManyToOneService.saveStudent(student1);
		studentManyToOneService.saveStudent(student2);

		// Guardar calificaciones
		gradeManyToOneService.saveGrade(grade1);
		gradeManyToOneService.saveGrade(grade2);
		gradeManyToOneService.saveGrade(grade3);
		gradeManyToOneService.saveGrade(grade4);

		// Obtener estudiantes con sus calificaciones
		List<StudentManyToOne> students = studentManyToOneService.getAllStudentsWithGrades();

		for (StudentManyToOne student : students) {
			System.out.println("Student: " + student.getName());
			System.out.println("Grades:");
			for (GradeManyToOne grade : student.getGrades()) {
				System.out.println(grade.toString());
			}
			System.out.println();
		}
	}

	private void exampleManyToMany() {
		CourseManyToMany course1 = new CourseManyToMany("Math 101");
		CourseManyToMany course2 = new CourseManyToMany("History 202");

		courseManyToManyService.createCourse(course1);
		courseManyToManyService.createCourse(course2);

		StudentManyToMany student1 = new StudentManyToMany("Juan Pérez");
		StudentManyToMany student2 = new StudentManyToMany("María Garcia");

		student1.getCourses().add(course1);
		student1.getCourses().add(course2);

		student2.getCourses().add(course1);
		student2.getCourses().add(course2);

		studentManyToManyService.createStudent(student1);
		studentManyToManyService.createStudent(student2);

		List<StudentManyToMany> students = studentManyToManyService.getAllStudentsWithCourses();

		for (StudentManyToMany student : students) {
			System.out.println("Student: " + student.getName());
			System.out.println("Courses:");
			for (CourseManyToMany course : student.getCourses()) {
				System.out.println(course.toString());
			}
			System.out.println();
		}
	}
}
