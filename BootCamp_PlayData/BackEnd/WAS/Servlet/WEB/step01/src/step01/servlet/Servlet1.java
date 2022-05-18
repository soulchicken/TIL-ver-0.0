package step01.servlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet("/test1")
public class Servlet1 extends HttpServlet{
	
	@Override
	public void init(ServletConfig config) {
		System.out.println("init() �����");
	}

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		System.out.println("service() �����");
	}

	@Override
	public void destroy() {
		System.out.println("destroy() �����");
		System.out.println("���� �Ҵ� �ڿ� ����");
	}
}
