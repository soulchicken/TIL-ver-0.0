package step02;

import static org.junit.Assert.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.junit.Test;

import dev.sample.model.Major;
import dev.sample.model.Student;

public class AppTest {
	
	@Test
	public void testSave() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("step02");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		tx.begin();
		
		// 학과 데이터 저장 (INSERT)
		Major major1 = new Major("컴퓨터 공학");
		em.persist(major1); // entityManager가 major1을 영속화(DB로) 시킨다.
		
		// 학생 데이터 저장
		Student student1 = new Student("kim");
		student1.setMajor(major1);
		Student student2 = new Student("dong");
		student2.setMajor(major1);
		em.persist(student1);
		em.persist(student2);
		
		Student findStudent = em.find(Student.class, 1L);
		System.out.println(findStudent);
		
		tx.commit();
		
	}
	
	@Test
	public void updateRelation() {
		// 새로운 major 국문학과 생성
		// 학생 1조회 후, 국문학과로 전과
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("step02");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		tx.begin();
		
		// 새로운 major 국문학과 생성
		// 학과 데이터 저장 (INSERT)
		Major majorKor = new Major("국문학과");
		em.persist(majorKor); // entityManager가 major1을 영속화(DB로) 시킨다.
		
		// 학생 1조회 후, 국문학과로 전과
		Student findStudent = em.find(Student.class, 1L);
		findStudent.setMajor(majorKor);
		
		tx.commit();
	}
	
	@Test
	public void deleteRelation() {
		// 연관관계 제거
		// 학생 1의 전공을 제거 (null) : 학과 제적
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("step02");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		
		tx.begin();
		
		Student findStudent = em.find(Student.class, 1L);
		findStudent.setMajor(null);
		
		tx.commit();
	}
	
	@Test
	public void deleteEntity() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("step02");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		tx.begin();
		
		// 학생들에게 학과 폐지 통보
		Student findStudent = em.find(Student.class, 2L);
		findStudent.setMajor(null);
		
		// 학과 폐지
		Major findMajor = em.find(Major.class, 1L);
		em.remove(findMajor);
		
		tx.commit();
	}
}
