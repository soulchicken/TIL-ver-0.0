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
		
		// �а� ������ ���� (INSERT)
		Major major1 = new Major("��ǻ�� ����");
		em.persist(major1); // entityManager�� major1�� ����ȭ(DB��) ��Ų��.
		
		// �л� ������ ����
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
		// ���ο� major �����а� ����
		// �л� 1��ȸ ��, �����а��� ����
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("step02");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		tx.begin();
		
		// ���ο� major �����а� ����
		// �а� ������ ���� (INSERT)
		Major majorKor = new Major("�����а�");
		em.persist(majorKor); // entityManager�� major1�� ����ȭ(DB��) ��Ų��.
		
		// �л� 1��ȸ ��, �����а��� ����
		Student findStudent = em.find(Student.class, 1L);
		findStudent.setMajor(majorKor);
		
		tx.commit();
	}
	
	@Test
	public void deleteRelation() {
		// �������� ����
		// �л� 1�� ������ ���� (null) : �а� ����
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
		
		// �л��鿡�� �а� ���� �뺸
		Student findStudent = em.find(Student.class, 2L);
		findStudent.setMajor(null);
		
		// �а� ����
		Major findMajor = em.find(Major.class, 1L);
		em.remove(findMajor);
		
		tx.commit();
	}
}
