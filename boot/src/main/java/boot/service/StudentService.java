package boot.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import boot.dao.StudentRepository;
import boot.model.Student;


	@Service @Transactional
	public class StudentService {
		private final StudentRepository studentRepository;

		public StudentService(StudentRepository studentRepository) {
			super();
			this.studentRepository = studentRepository;
		}
		public List<Student> findAll(){
			List<Student> students = new ArrayList<Student>();
			for (Student student : studentRepository.findAll()){
				students.add(student);
			}
			return students;
		}
		
		public void save(Student student){
			studentRepository.save(student);
		}
		
		public void delete(int studentID){
			studentRepository.delete(studentID);
		}
		
		public Student findStudent(int studentID){
			return studentRepository.findOne(studentID);
		}
	}

		
	