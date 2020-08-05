package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.JoinDaoImpl;
import model.Member;
import service.JoinService;
import service.JoinServiceImpl;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("euc-kr");
		response.setContentType("text/html; charset=EUC-KR");
		response.setCharacterEncoding("euc-kr");
		
		// 기능을 제공할 서비스 객체 생성
		JoinDaoImpl service = new JoinDaoImpl();
		
		boolean flag = false;
		
		// 세션 생성
		HttpSession session = request.getSession();
		
		// 로그인에 필요한 요청 파라메터를 읽는다.
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		
		
		// id로 맴버 검색
		Member m = service.select(id);
		
		
		//id와 비밀번호가 db의 값과 동일하면 로그인 성공
		if(m != null && pwd.equals(m.getPwd())) {
			// 로그인 성공한 id를 세션에 저장
			session.setAttribute("id", id);
			
			// 로그인 성공 여부를 flag에 저장
			flag = true;
		}
		
		// 세션에 로그인 "성공 여부"를 저장
		session.setAttribute("flag", flag);
		
		// 메뉴 페이지로 이동
		RequestDispatcher dispatcher = request.getRequestDispatcher("/member/result.jsp");
		if(dispatcher != null) {
			dispatcher.forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
