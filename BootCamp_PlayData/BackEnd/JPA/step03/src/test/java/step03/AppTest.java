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
		 * 1. �а� ������ ����(��ǻ�� ���а�), ����
		 * 
		 * 2. �л� ������ ����(�л�1 Yoo, �л�2 Kang) �� ��ǻ�� ���а��� �������踦 ���� �� ����
		 */
		
		tx.begin();
		
		// 1.
		Major major1 = new Major("��ǻ�� ����");
		em.persist(major1);
		
		// 2-1. �л� 1 ����, ���� 
		Student student1 = new Student("Kim");
		student1.setMajor(major1); // �������� ����
		em.persist(student1);
		
		// 2-2. �л� 2 ����, ����
		Student student2 = new Student("Dong");
		student2.setMajor(major1); // �������� ����
		em.persist(student2);
		
		tx.commit();
		// SELECT * FROM stduent; major_id �� ����� �� Ȯ��
	}
	
	@Test
	public void readStudents() {
		// JPA�� �л� ����Ʈ ��ȸ
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("step03");
		EntityManager em = emf.createEntityManager();
		
		/*
		 * 1. ���� ���̺� �����ͼ� �ش� �а� �л��� �� �����ͺ���
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
		Major major1 = new Major("��ǻ�� ����");
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
		// ������ ��ü���� �ڵ忡�� �������� ����
		Major major1 = new Major("��ǻ�� ����");
		
		Student student1 = new Student("Kim");
		student1.setMajor(major1);
		Student student2 = new Student("Dong");
		student2.setMajor(major1);
		
		List<Student> students = major1.getStudents();
		System.out.println(students.size());
	}
	
	@Test
	public void biWithPureOOP() {
		// ������ ��ü���� �ڵ忡�� ����� �������� ����
		Major major1 = new Major("��ǻ�� ����");
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
		// JPA�� Ȱ���� ����� ����
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("step03");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();

		tx.begin();
		Major major1 = new Major("������");
		em.persist(major1);
		List<Student> students = major1.getStudents();
		
		Student student1 = new Student("kim");
		student1.setMajor(major1);
		em.persist(student1);

		students.add(student1);
		
		// �л�2 ���� �� �������� ����, ���ӱ���
		Student student2 = new Student("dong");
		student2.setMajor(major1);
		em.persist(student2);

		students.add(student2);
		
		tx.commit();
		// SELECT s.* m.major_name from student s join major m on s.major_id = m.major_id where s.major_id = 1;
	}
	
	@Test
	public void jpqlTest() {
		// select ����
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("step03");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();

		tx.begin();
		Major major1 = new Major("������");
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
		// select + where ����
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("step03");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();

		tx.begin();
		Major major1 = new Major("������");
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
		// select + where �ε�, typeQuery ���� Query ����
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("step03");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();

		tx.begin();
		Major major1 = new Major("������");
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
		// �Ķ���͸� Ȱ���ϱ�.
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("step03");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();

		tx.begin();
		Major major1 = new Major("������");
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
			System.out.println("id�� "+ i + "�� �л��� ����!    "+jpqlResult.get(0));
		}
		
		tx.commit();
	}
	
	@Test
	public void jpqlJoinTest() {
		// JOIN ����غ���.
		// ������ �������� kim,kin�� ����ϱ� (�������� kim2�� �ȳ�����)
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("step03");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();

		tx.begin();
		Major major1 = new Major("������");
		em.persist(major1);
		
		Major major2 = new Major("������");
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
									  .setParameter(1, "������");
		List<Student> jpqlResult = query.getResultList();
		for (Student student : jpqlResult) {
			System.out.println("�����а� �л� ���� :" + student);
		}
		
		tx.commit();
	}
}