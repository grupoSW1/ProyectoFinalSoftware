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
 * Servlet implementation class EliminarFechaServlet
 */
@WebServlet("/eliminarFecha")
public class EliminarFechaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public EliminarFechaServlet() {
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
			String sql="DELETE FROM t_fecha WHERE idFecha=?" ;
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
		// TODO Auto-generated method stub
		Integer id=Integer.parseInt(request.getParameter("fecha"));
		
		boolean respuesta=eliminar(id);
		
		if(respuesta!=false){
			response.sendRedirect("listarFechas");
		}else{
			request.setAttribute("mensaje", "No se pudo eliminar la fecha");
			request.getRequestDispatcher("/editarFecha.jsp").forward(request, response);
		}
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
