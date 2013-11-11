package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.UsuarioBean;

/**
 * Servlet implementation class ListarlAlumnosServlet
 */
@WebServlet("/listarAlumnos")
public class ListarAlumnosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ListarAlumnosServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    public List<UsuarioBean> listar(){
    	UsuarioBean usuariobd=null;
		Connection con= null;
		List<UsuarioBean> alumnos = new ArrayList<UsuarioBean>();
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			 String url="jdbc:mysql://localhost:3306/bdsistema";
			  con= DriverManager.getConnection(url,"root","root");
			 
			 Statement stmt= con.createStatement();
			 
			 String sql="SELECT * FROM t_usuario where cargo='JP'";
			 
			 ResultSet rs=stmt.executeQuery(sql);
			 
			
			 while(rs.next()){
				 	usuariobd = new UsuarioBean();
				 	usuariobd.setUsuario(rs.getInt("idUsuario"));
				 	usuariobd.setNombre(rs.getString("nombre"));
				 	usuariobd.setClave(rs.getString("contraseña"));
				 	usuariobd.setGrupo(rs.getString("grupo"));
				 	usuariobd.setSeccion(rs.getString("seccion"));
				 	usuariobd.setCargo(rs.getString("cargo"));
					alumnos.add(usuariobd);
				
			 }
			 return alumnos;
			 
		
			
		} catch (Exception ex) {
			ex.printStackTrace();
			try{if(con!=null)con.close();}catch(Exception e){};
		}
		return null;
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		PrintWriter out = response.getWriter();
	
		List<UsuarioBean> objLista=listar();
		if(objLista!=null){
			request.setAttribute("alumnos",objLista);
		}else{
			request.setAttribute("mensaje", "Registro de alumnos vacio");
		}

		 request.getRequestDispatcher("/listadoAlumnos.jsp").forward(request,response);
		 
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
