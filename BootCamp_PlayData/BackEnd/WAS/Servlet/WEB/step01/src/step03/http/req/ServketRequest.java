package step03.http.req;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/test5")
public class ServketRequest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// UTF-8 문서형식, 인코딩 방식 설정
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		out.print("Server port : " + request.getServerPort() + "<br/>");
		out.print("Request URI : " + request.getRequestURI() + "<br/>");
		out.print("Request URL : " + request.getRequestURL() + "<br/>");
		out.print("Context Path : " + request.getContextPath() + "<br/>");
		out.print("Request Protocol : " + request.getProtocol() + "<br/>");
		out.print("Request Method : " + request.getMethod() + "<br/>");
		out.print("Query String : " + request.getQueryString() + "<br/>");
		
		out.close();
	}
}
