package basico;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Consultar
 */
@WebServlet("/Consultar")
public class Consultar extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Consultar() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		//getServletConfig().getServletContext().getRequestDispatcher("/leer.jsp").forward(request, response);
		
		
		try {
			PrintWriter wr = response.getWriter();
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/periodico", "root", "");

			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM noticias");
		
			String resultado = "";
			
			resultado+="<table class=\"striped\"> <td>Mail</td> <td>Categoria</td> <td>Titulo</td> <td>Contenido</td> <td>Fecha de publicacion</td>";
			while (rs.next()) {	
				resultado+="<tr>";
				resultado+="<td>";
				resultado+=rs.getString(2);
				resultado+="</td>";
				resultado+="<td>";
				resultado+=rs.getString(3);
				resultado+="</td>";
				resultado+="<td>";
				resultado+=rs.getString(4);
				resultado+="</td>";
				resultado+="<td>";
				resultado+=rs.getString(5);
				resultado+="</td>";
				resultado+="</tr>";
				
//				writerA.println(rs.getString(4));
			}
			resultado+="<table>";
			request.getSession().setAttribute("servletMsg", resultado);
			response.sendRedirect("leer.jsp");
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
