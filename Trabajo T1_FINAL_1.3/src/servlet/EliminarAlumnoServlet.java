package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class EliminarAlumnoServlet
 */
@WebServlet("/eliminarAlumno")
public class EliminarAlumnoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public EliminarAlumnoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    public boolean eliminar(int id){
    	Connection con=null;
		String url="jdbc:mysql://localhost:3306/bdsistema";
		String user="root";
		String password="root";
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.
					getConnection(url, user, password);
			String sql="DELETE FROM t_usuario WHERE idUsuario=?" ;
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
			return true;
		}catch(Exception ex){
			ex.printStackTrace();
			try{if(con!=null)con.close();}catch(Exception e){};
		}
		return false;
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer id=Integer.parseInt(request.getParameter("codigo"));
		String grupo=request.getParameter("grupo");
		
		boolean respuesta=eliminar(id);
		
		if(respuesta!=false){
			request.setAttribute("grupo", grupo);
			request.setAttribute("mensaje", "El alumno fue eliminado satisfactoriamente");
				request.getRequestDispatcher("listarAlumnos").forward(request, response);
		}else{
			request.setAttribute("grupo", grupo);
			request.setAttribute("mensaje", "El alumno no fue eliminado satisfactoriamente");
				request.getRequestDispatcher("listarAlumnos").forward(request, response);
		}
		
	
			
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
