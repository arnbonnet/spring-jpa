package app;

import java.util.Date;
import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import app.model.Book;
import app.repository.BookDAO;

public class Main {

	public static void main(String[] args) {
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(App.class);

		BookDAO bookDAO = context.getBean(BookDAO.class);
		
		Book book = new Book();
		book.setId(1L);
		book.setTitle("L'Assassin royal - Tome 1");
		book.setAuthor("Robin Hobb");
		book.setNbPages(400);
		book.setPublicationDate(new Date());
		

		Book book2 = new Book();
		book2.setId(2L);
		book2.setTitle("L'Assassin royal - Tome 2");
		book2.setAuthor("Robin Hobb");
		book2.setNbPages(400);
		book2.setPublicationDate(new Date());
		
		Book book3 = new Book();
		book3.setId(3L);
		book3.setTitle("L'Assassin royal - Tome 3");
		book3.setAuthor("Robin Hobb");
		book3.setNbPages(400);
		book3.setPublicationDate(new Date());
		
//		bookDAO.create(book);
//		bookDAO.create(book2);
//		bookDAO.create(book3);
		
//		book.setNbPages(367);
//		bookDAO.update(book);
		
		//bookDAO.delete(book);
		
		List<Book> books = bookDAO.getAll();
		System.out.println("===== get all ======");
		for(Book b : books) {
			System.out.println(b);
		}
		
		System.out.println();
		System.out.println("===== getById =====");
		System.out.println(bookDAO.getById(3L));
		context.close();
		
	}

}
