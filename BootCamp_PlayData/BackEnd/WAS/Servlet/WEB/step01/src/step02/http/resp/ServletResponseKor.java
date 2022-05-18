package step02.http.resp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/test4")
public class ServletResponseKor extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 문서 형식, 인코딩 방식 변경
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		// <html> </html> 생략
    	out.print("<body>�ȳ�?</body>");
    	out.close();
	}

}
