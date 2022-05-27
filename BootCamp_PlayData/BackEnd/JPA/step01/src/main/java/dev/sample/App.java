package dev.sample;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import dev.sample.model.Book;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("step01");

		// EntityManagerFactory�� ���� EntityManager ��ü ����
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();

		try {
			tx.begin();
			Book book = new Book();
			
			book.setBookName("�븣���� ��");

			// ���, em.persist(����� entity); list.add(entity);
			em.persist(book); // INSERT INTO Book ~~~~ ���� ������ �Լ�

			// ���� �޼���. UPDATE�� ����.
//			book.setBookName("�ڹ��� ����");

			Book findBook = em.find(Book.class, 1L);
			System.out.println(findBook.getBookName());
			
			em.remove(findBook);
			
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
			emf.close();
		}
	}
}
