package step01.cookie;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SetServlet")
public class SetCookieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 서버가 클라이언트한테 응답 메시지로 보낼 데이터에 대한 부가 정보, 문자 셋
		response.setContentType("text/html;charset=UTF-8");
		
		// 쿠키 객체 생성 
		Cookie cookie1 = new Cookie("id","guest");
		
		// 쿠키는 클라이언트 측(브라우저)에 저장, 클라이언트 측에 보내기 위해서는 응답 객체(response)에 쿠키를 저장해야함
		response.addCookie(cookie1);
		
		Cookie cookie2 = new Cookie("nickName","Spiderman");
		cookie2.setMaxAge(60);
		response.addCookie(cookie2);
		
		PrintWriter out = response.getWriter();
		out.print("서버에서 생성된 쿠키가 클라이언트로 전송되었음.");
		
		// 자원 해제
		out.close();
	}

}
