package step02.session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LoginTest")
public class LoginLogoutSession extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 서버 응답 시 클라이언트에게 메타정보 전달
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		HttpSession session =request.getSession();
		
		if (session != null && session.getAttribute("id") != null) {
			session.invalidate();
			out.print("로그아웃 하셨습니다.");
		} else {
			out.print("로그인 상태가 아닌걸?");
		}
		
		out.close();
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 서버 응답 시 클라이언트에게 메타정보 전달
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		// 클라이언트에서 입력한 id, pw값 받기
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		
		// id, pwd 중 하나라도 입력 안하면 돌려보냄.
		if (id.isEmpty()|| pwd.isEmpty()) {
			out.print("아이디 및 비밀번호를 입력해주세요");
			return;
		}
		
		HttpSession session = request.getSession();
		
		if (session.isNew() || session.getAttribute("id") == null) {
			session.setAttribute("id", id); // 세션에 "id"라는 키값에 id 값 저장
			out.print("로그인 완료");
		} else {
			out.print("현재 로그인 상태입니다.");
		}
		out.close();
	}

}
