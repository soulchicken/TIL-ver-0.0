package dev.sample.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import dev.sample.model.Book;

// index.jsp에서 보낸 요청을 처음으로 받는 컨트롤러(servlet)
// @Controller 를 사용하면 ex1 ~ 3까지만 된다.
// ex4처럼해서 JSON 반환을 하고 싶다면 @RestController를 사용해야한다.
@RestController
public class BookController {
	// 1. spring으로 해당 페이지를 반환하는 방식
	
	@RequestMapping("/add")
	public String ex1(HttpServletRequest request, HttpServletResponse response) {
		String name = request.getParameter("name");
		String author = request.getParameter("author");
		System.out.println(name);
		System.out.println(author);
		
		// 기존의 페이지 이동
		// forward or rediract
		
		// 근데 spring은?
		return "result1.jsp";
	}
	
	// 2. ModelAndView 활용 방식
	@RequestMapping("/add2")
	public ModelAndView ex2(HttpServletRequest request, HttpServletResponse response) {
		String name = request.getParameter("name");
		// 이동할 페이지 및 페이지에 전달할 객체를 담아서 ModelAndView 객체 생성
		// Model : 페이지에 전달할 객체
		// View : 이동할 페이지 담당
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("result2.jsp"); // 이동시킬 페이지 파일명 지정
		modelAndView.addObject("bookName",name);
		return modelAndView;
	}
	
	// 3. RequestParam 활용 방식, 기존에 사용하던 HttpServletRequest,Response를 사용하지 않는 방식
	@RequestMapping("/add3")
	public ModelAndView ex3(@RequestParam("name") String name){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("result2.jsp"); // 이동시킬 페이지 파일명 지정
		modelAndView.addObject("bookName",name);
		
		return modelAndView;
	}
	
	// 4. JSON 객체 반환 방식 : 이제 프론트와 연결할 실마리가 나올 듯 하다.
	@RequestMapping("/add4")
	public Book ex4(@RequestParam("name") String name, @RequestParam("author") String author) {
		Book book = new Book();
		book.setAuthor(author);
		book.setName(name);
		System.out.println(book);
		return book;
	}

}
