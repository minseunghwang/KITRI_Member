package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.JoinDaoImpl;
import model.Member;

/**
 * Servlet implementation class UpdateController
 */
@WebServlet("/UpdateController")
public class SearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchController() {
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
				
		// 정보수정 필요한 요청 파라메터를 읽는다.
		String id = request.getParameter("updid");
		String pwd = request.getParameter("updpwd");
		String name = request.getParameter("updname");
		String email = request.getParameter("updemail");
		
		// 파라메터 모아서 Member 객체로만들어서(JoinDaoImpl update 함수의 매개변수가 Member이기때문)
		Member m = new Member(id,pwd,name,email);
		
		// DB업데이트!
		service.update(m);
		
		// 메뉴 페이지로 이동
		RequestDispatcher dispatcher = request.getRequestDispatcher("/member/memberInfo.jsp");
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
