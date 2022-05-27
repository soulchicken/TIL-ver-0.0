package dev.sample.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import dev.sample.model.Book;

// index.jsp���� ���� ��û�� ó������ �޴� ��Ʈ�ѷ�(servlet)
// @Controller �� ����ϸ� ex1 ~ 3������ �ȴ�.
// ex4ó���ؼ� JSON ��ȯ�� �ϰ� �ʹٸ� @RestController�� ����ؾ��Ѵ�.
@RestController
public class BookController {
	// 1. spring���� �ش� �������� ��ȯ�ϴ� ���
	
	@RequestMapping("/add")
	public String ex1(HttpServletRequest request, HttpServletResponse response) {
		String name = request.getParameter("name");
		String author = request.getParameter("author");
		System.out.println(name);
		System.out.println(author);
		
		// ������ ������ �̵�
		// forward or rediract
		
		// �ٵ� spring��?
		return "result1.jsp";
	}
	
	// 2. ModelAndView Ȱ�� ���
	@RequestMapping("/add2")
	public ModelAndView ex2(HttpServletRequest request, HttpServletResponse response) {
		String name = request.getParameter("name");
		// �̵��� ������ �� �������� ������ ��ü�� ��Ƽ� ModelAndView ��ü ����
		// Model : �������� ������ ��ü
		// View : �̵��� ������ ���
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("result2.jsp"); // �̵���ų ������ ���ϸ� ����
		modelAndView.addObject("bookName",name);
		return modelAndView;
	}
	
	// 3. RequestParam Ȱ�� ���, ������ ����ϴ� HttpServletRequest,Response�� ������� �ʴ� ���
	@RequestMapping("/add3")
	public ModelAndView ex3(@RequestParam("name") String name){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("result2.jsp"); // �̵���ų ������ ���ϸ� ����
		modelAndView.addObject("bookName",name);
		
		return modelAndView;
	}
	
	// 4. JSON ��ü ��ȯ ��� : ���� ����Ʈ�� ������ �Ǹ����� ���� �� �ϴ�.
	@RequestMapping("/add4")
	public Book ex4(@RequestParam("name") String name, @RequestParam("author") String author) {
		Book book = new Book();
		book.setAuthor(author);
		book.setName(name);
		System.out.println(book);
		return book;
	}

}
