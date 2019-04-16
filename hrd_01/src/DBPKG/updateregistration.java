package DBPKG;

import java.beans.Beans;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

/**
 * Servlet implementation class updateregistration
 */
@WebServlet("/sub/update")
public class updateregistration extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String custno = request.getParameter("custno");
		bean bean = Memdao.getInstance().getMember(custno);
		request.setAttribute("bean", bean);
		request.getRequestDispatcher("update.jsp").forward(request,response);
	}

	//수정 처리
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		bean bean = new bean();
		try {
			BeanUtils.copyProperties(bean, request.getParameterMap());
		}catch(Exception e) {
			e.printStackTrace();
		}
		Memdao.getInstance().update(bean);
		response.sendRedirect("/hrd_01/main/index.jsp");
	}

}
