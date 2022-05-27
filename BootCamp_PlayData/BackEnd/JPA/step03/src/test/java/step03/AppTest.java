package step03;

import static org.junit.Assert.fail;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.junit.Test;

import dev.sample.model.Major;
import dev.sample.model.Student;

public class AppTest {

	@Test
	public void test() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testSave() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("step03");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		/*
		 * 1. 학과 데이터 생성(컴퓨터 공학과), 저장
		 * 
		 * 2. 학생 데이터 생성(학생1 Yoo, 학생2 Kang) 및 컴퓨터 공학과와 연관관계를 설정 후 저장
		 */
		
		tx.begin();
		
		// 1.
		Major major1 = new Major("컴퓨터 공학");
		em.persist(major1);
		
		// 2-1. 학생 1 생성, 저장 
		Student student1 = new Student("Kim");
		student1.setMajor(major1); // 연관관계 설정
		em.persist(student1);
		
		// 2-2. 학생 2 생성, 저장
		Student student2 = new Student("Dong");
		student2.setMajor(major1); // 연관관계 설정
		em.persist(student2);
		
		tx.commit();
		// SELECT * FROM stduent; major_id 값 적용된 것 확인
	}
	
	@Test
	public void readStudents() {
		// JPA로 학생 리스트 조회
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("step03");
		EntityManager em = emf.createEntityManager();
		
		/*
		 * 1. 전공 테이블 가져와서 해당 학과 학생들 쭉 가져와보기
		 */
		
		Major major = em.find(Major.class,1L);
//		System.out.println(major.getStudents());
		List<Student> students = major.getStudents();
		for (Student student : students) {
			System.out.println(student);
		}
	}
	
	@Test
	public void testSaveNonOwerWithJPA() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("step03");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();

		tx.begin();
		Major major1 = new Major("컴퓨터 공학");
		em.persist(major1);
		
		List<Student> students = major1.getStudents();
		Student student1 = new Student("kim");
		students.add(student1);
		em.persist(student1);

		Student student2 = new Student("dong");
		students.add(student2);
		em.persist(student2);

		tx.commit();

	}
	
	@Test
	public void testSaveOwnerWithOOP() {
		// 순수한 객체지향 코드에서 연관관계 설정
		Major major1 = new Major("컴퓨터 공학");
		
		Student student1 = new Student("Kim");
		student1.setMajor(major1);
		Student student2 = new Student("Dong");
		student2.setMajor(major1);
		
		List<Student> students = major1.getStudents();
		System.out.println(students.size());
	}
	
	@Test
	public void biWithPureOOP() {
		// 순수한 객체지향 코드에서 양방향 연관관계 적용
		Major major1 = new Major("컴퓨터 공학");
		List<Student> students = major1.getStudents();
		
		Student student1 = new Student("Kim");
		student1.setMajor(major1);
		students.add(student1);
		
		Student student2 = new Student("Dong");
		student2.setMajor(major1);
		students.add(student2);
		
		System.out.println(students.size());
	}
	@Test
	public void biWithJPA() {
		// JPA를 활용한 양방향 맵핑
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("step03");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();

		tx.begin();
		Major major1 = new Major("국문학");
		em.persist(major1);
		List<Student> students = major1.getStudents();
		
		Student student1 = new Student("kim");
		student1.setMajor(major1);
		em.persist(student1);

		students.add(student1);
		
		// 학생2 생성 및 연관관계 설정, 영속까지
		Student student2 = new Student("dong");
		student2.setMajor(major1);
		em.persist(student2);

		students.add(student2);
		
		tx.commit();
		// SELECT s.* m.major_name from student s join major m on s.major_id = m.major_id where s.major_id = 1;
	}
	
	@Test
	public void jpqlTest() {
		// select 성공
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("step03");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();

		tx.begin();
		Major major1 = new Major("국문학");
		em.persist(major1);
		List<Student> students = major1.getStudents();
		
		Student student1 = new Student("kim");
		student1.setMajor(major1);
		em.persist(student1);
		students.add(student1);
		
		Student student2 = new Student("kim2");
		student2.setMajor(major1);
		em.persist(student2);
		students.add(student2);

		Student student3 = new Student("kin");
		student3.setMajor(major1);
		em.persist(student3);
		students.add(student3);
		
		String jpql = "select s from Student s";
		TypedQuery<Student> typedQuery = em.createQuery(jpql, Student.class);
		List<Student> jpqlResult = typedQuery.getResultList();
		for (Student student : jpqlResult) {
			System.out.println(student);
		}
		tx.commit();
	}
	
	@Test
	public void jpqlTest2() {
		// select + where 성공
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("step03");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();

		tx.begin();
		Major major1 = new Major("국문학");
		em.persist(major1);
		
		Student student1 = new Student("kim");
		student1.setMajor(major1);
		em.persist(student1);
		
		Student student2 = new Student("kim2");
		student2.setMajor(major1);
		em.persist(student2);

		Student student3 = new Student("kin");
		student3.setMajor(major1);
		em.persist(student3);
		
		String jpql = "select s from Student s where s.id < 3";
		TypedQuery<Student> typedQuery = em.createQuery(jpql, Student.class);
		List<Student> jpqlResult = typedQuery.getResultList();
		for (Student student : jpqlResult) {
			System.out.println(student);
		}
		tx.commit();
	}
	
	@Test
	public void jpqlTest3() {
		// select + where 인데, typeQuery 말고 Query 성공
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("step03");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();

		tx.begin();
		Major major1 = new Major("국문학");
		em.persist(major1);
		
		Student student1 = new Student("kim");
		student1.setMajor(major1);
		em.persist(student1);
		
		Student student2 = new Student("kim2");
		student2.setMajor(major1);
		em.persist(student2);

		Student student3 = new Student("kin");
		student3.setMajor(major1);
		em.persist(student3);
		
		String jpql = "select s from Student s where s.id < 3";
		Query query = em.createQuery(jpql);
		List<Student> jpqlResult = query.getResultList();
		for (Student student : jpqlResult) {
			System.out.println(student);
		}
		tx.commit();
	}
	
	@Test
	public void jpqlSetParameterTest() {
		// 파라미터를 활용하기.
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("step03");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();

		tx.begin();
		Major major1 = new Major("국문학");
		em.persist(major1);
		
		Student student1 = new Student("kim");
		student1.setMajor(major1);
		em.persist(student1);
		
		Student student2 = new Student("kim2");
		student2.setMajor(major1);
		em.persist(student2);

		Student student3 = new Student("kin");
		student3.setMajor(major1);
		em.persist(student3);
		
		
		String jpql = "select s from Student s where s.id = ?1";
		TypedQuery<Student> query = em.createQuery(jpql, Student.class);
		for (Long i = 1L; i < 4; i++) {
			query.setParameter(1, i);
			List<Student> jpqlResult = query.getResultList();
			System.out.println("id가 "+ i + "인 학생의 정보!    "+jpqlResult.get(0));
		}
		
		tx.commit();
	}
	
	@Test
	public void jpqlJoinTest() {
		// JOIN 사용해보기.
		// 전공이 국문학인 kim,kin을 출력하기 (영문학은 kim2는 안나오기)
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("step03");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();

		tx.begin();
		Major major1 = new Major("국문학");
		em.persist(major1);
		
		Major major2 = new Major("영문학");
		em.persist(major2);
		
		Student student1 = new Student("kim");
		student1.setMajor(major1);
		em.persist(student1);
		
		Student student2 = new Student("kim2");
		student2.setMajor(major2);
		em.persist(student2);

		Student student3 = new Student("kin");
		student3.setMajor(major1);
		em.persist(student3);
		
		String jpql = "select s from Student s join Major m on s.major = m.id where m.majorName = ?1";
		TypedQuery<Student> query = em.createQuery(jpql, Student.class)
									  .setParameter(1, "국문학");
		List<Student> jpqlResult = query.getResultList();
		for (Student student : jpqlResult) {
			System.out.println("국문학과 학생 정보 :" + student);
		}
		
		tx.commit();
	}
}