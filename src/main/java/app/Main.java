package app;

import java.util.Date;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import app.model.Book;
import app.repository.BookDAO;

public class Main {

	public static void main(String[] args) {
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(App.class);

		BookDAO bookDAO = context.getBean(BookDAO.class);
		
		Book book = new Book();
		book.setTitle("L'Assassin royal - Tome 1");
		book.setAuthor("Robin Hobb");
		book.setNbPages(400);
		book.setPublicationDate(new Date());
		
		bookDAO.create(book);
		
		context.close();
		
	}

}
