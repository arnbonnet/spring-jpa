package app.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import app.model.Book;

@Repository
@Transactional
public class BookDAO {

	@PersistenceContext
	protected EntityManager em;

	public BookDAO() {
	}

	public void create(Book book) {
		em.persist(book);
	}

	public void update(Book book) {
		em.merge(book);
	}

	public void delete(Book book) {
		em.remove(book);
	}

	public List<Book> getAll() {
		TypedQuery<Book> query = em.createQuery("select b from Book b", Book.class);

		List<Book> books = query.getResultList();

		return books;
	}

	public Book getById(Long id) {
		TypedQuery<Book> query = em.createQuery("select b from Book b where b.id =:bookId ", Book.class)
									.setParameter("bookId", id);

		return query.getSingleResult();
	}

}