package step02.http.resp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/test3")
public class ServletResponsEng extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 
    	PrintWriter out = response.getWriter();
		
		// <html> </html>은 생략
    	out.print("<body>Hello</body>");
    	out.close();
    }

}
