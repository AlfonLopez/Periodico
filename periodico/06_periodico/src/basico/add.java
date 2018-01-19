package basico;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class add
 */
@WebServlet("/add")
public class add extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public add() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String mail = request.getParameter("mail");
		int categoria = Integer.parseInt(request.getParameter("idcategoria"));
		String titulo = request.getParameter("titulo");
		String contenido = request.getParameter("contenido");
		String time = request.getParameter("fecha");
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/periodico", "root", "");
			// Statement stmt = conn.createStatement();

			PreparedStatement ps = conn.

			prepareStatement("INSERT INTO noticias (mail, idcategoria, titulo, contenido, fecha ) VALUES (?,?,?,?,?)");
			
			ps.setString(1, mail);
			ps.setInt(2, categoria);
			ps.setString(3, titulo);
			ps.setString(4, contenido);
			ps.setString(5, time);

			System.out.println("Filas insertadas");
			ps.executeUpdate();
			conn.close();
			ps.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
