package DBPKG;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/registration")
public class insertregistration extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		bean bean = new bean();
		bean.setCustno(request.getParameter("custno"));
		bean.setCustname(request.getParameter("custname"));
		bean.setPhone(request.getParameter("phone"));
		bean.setAddress(request.getParameter("address"));
		bean.setJoindate(request.getParameter("joindate"));
		bean.setGrade(request.getParameter("grade"));
		bean.setCity(request.getParameter("city"));
		
		Memdao.getInstance().insert(bean);
		response.sendRedirect("/hrd_01/main/index.jsp");
	}

}
