package employee;

import employee.model.*;
import employee.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.time.LocalDate;


@SpringBootApplication
@EntityScan("")
public class Lab4PartAApplication implements CommandLineRunner {
    @Autowired
    private DepartmentRepository departmentRepository;
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private PassengerRepository passengerRepository;

    @Autowired
    private SchoolRepository schoolRepository;

    @Autowired
    private StudentRepository studentRepository;

    public static void main(String[] args) {
        SpringApplication.run(Lab4PartAApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Department department = new Department("CS");
        Employee employee = new Employee("Elice");
        employee.setDepartment(department);
        department.addEmployee(employee);
        departmentRepository.save(department);
        Employee employee1 = new Employee("Regan");
        department.addEmployee(employee1);
        employee1.setDepartment(department);
        departmentRepository.save(department);
        departmentRepository.findAll().forEach(System.out::println);

        System.out.println("==================BOOKS======================");
        Publisher publisher = new Publisher("Regan");
        Book book = new Book("Programming in java","Henry");
        book.setPublisher(publisher);
        bookRepository.save(book);
        Book book1= new Book("EA","Rene ");
        book1.setPublisher(publisher);

        bookRepository.save(book1);
        bookRepository.findAll().forEach(System.out::println);
        bookRepository.findAll().forEach(System.out::println);


        System.out.println("==============PASSENGERS=================");
        Passenger passenger = new Passenger("Mary");
        Flight flight = new Flight("T20","NY","IA", LocalDate.now());
        Flight flight1 = new Flight("Y60","CD","NY",LocalDate.now());
        passenger.addFlight(flight);
        passenger.addFlight(flight1);
        passengerRepository.save(passenger);
        passengerRepository.findAll().forEach(System.out::println);


        System.out.println("=================SCHOOL==================");
        School school=  new School("MIU");
        Student student = new Student("Asma","Aouz");
        studentRepository.save(student);
        Student student1 = new Student("Bethel","Mulat");
        studentRepository.save(student);
        school.addStudent(student);
        school.addStudent(student1);
        schoolRepository.save(school);
        schoolRepository.findAll().forEach(System.out::println);



    }
}
