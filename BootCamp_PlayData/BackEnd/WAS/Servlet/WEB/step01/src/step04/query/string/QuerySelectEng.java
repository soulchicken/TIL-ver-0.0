package step04.query.string;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/queryTestEng")
public class QuerySelectEng extends HttpServlet {
	private static final long serialVersionUID = 1L;



	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 서버에서 클라이언트로 응답할 때 참고로 안내할 응답한 문서(html)의 타입, 문자셋 지정
		response.setContentType("text/html;charset=UTF-8");
		
		// 출력에 의한 PrintWriter 객체 생성
		PrintWriter out = response.getWriter();
		
		// 출력문으로 <h1>GET 방식으로 요청되었음</h1>
		out.print("<h1>GET 방식으로 요청되었음</h1>");
		
		// 클라이언트(브라우저)에서 입력한 값 추출(꺼내기)
		String id = request.getParameter("id");
		String password = request.getParameter("pwd");
		String name = request.getParameter("name");

		out.print("ID : " + id + "<br/>");
		out.print("비밀번호 : " + password + "<br/>");
		out.print("이름 : " + name + "<br/>");
	
		// checkbox 값 받기 (중복선택값이기 때문에 배열로 받음)
		String[] hobbies = request.getParameterValues("hobby");
		String gender = request.getParameter("gender");
		String country = request.getParameter("country");
		String introduction = request.getParameter("introduction");
		
		out.print("성별 : " + gender + "<br/>");
		out.print("나라 : " + country + "<br/>");
		out.print("소개 : " + introduction + "<br/>");
		for (String hobby : hobbies) {
			out.print("취미 : " + hobby + "<br/>");			
		}
		
		
		
		// 자원 해제
		out.close();
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		// 서버에서 클라이언트로 응답할 때 참고로 안내할 응답한 문서(html)의 타입, 문자셋 지정
		response.setContentType("text/html;charset=UTF-8");
		// 출력에 의한 PrintWriter 객체 생성
		PrintWriter out = response.getWriter();
		
		// 출력문으로 <h1>POST 방식으로 요청되었음</h1>
		out.print("<h1>POST 방식으로 요청되었음</h1>");
		
		// 클라이언트(브라우저)에서 입력한 값 추출(꺼내기)
		String id = request.getParameter("id");
		String password = request.getParameter("pwd");
		String name = request.getParameter("name");

		out.print("ID : " + id + "<br/>");
		out.print("비밀번호 : " + password + "<br/>");
		out.print("이름 : " + name + "<br/>");
	
		// checkbox 값 받기 (중복선택값이기 때문에 배열로 받음)
		String[] hobbies = request.getParameterValues("hobby");
		String gender = request.getParameter("gender");
		String country = request.getParameter("country");
		String introduction = request.getParameter("introduction");
		
		out.print("성별 : " + gender + "<br/>");
		out.print("나라 : " + country + "<br/>");
		out.print("소개 : " + introduction + "<br/>");
		for (String hobby : hobbies) {
			out.print("취미 : " + hobby + "<br/>");			
		}
				
	}

}
