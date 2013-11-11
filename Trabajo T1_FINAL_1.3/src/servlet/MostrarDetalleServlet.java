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
 * Servlet implementation class MostrarDetalleServlet
 */
@WebServlet("/mostrarDetalle")
public class MostrarDetalleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MostrarDetalleServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    public List<UsuarioBean> listar(String grupo){
    	UsuarioBean userbd=null;
		Connection con= null;
		List<UsuarioBean> alumnos = new ArrayList<UsuarioBean>();
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			 String url="jdbc:mysql://localhost:3306/bdsistema";
			  con= DriverManager.getConnection(url,"root","root");
			  
			 String sql="SELECT * FROM t_usuario WHERE grupo='"+grupo+"'";
			 Statement ps=con.createStatement();
			 ResultSet rs=ps.executeQuery(sql);

			 while(rs.next()){
				 	userbd = new UsuarioBean();
					userbd.setUsuario(rs.getInt("idUsuario"));
					userbd.setNombre(rs.getString("nombre"));
					userbd.setClave(rs.getString("contraseña"));
					userbd.setGrupo(rs.getString("grupo"));
					userbd.setSeccion(rs.getString("seccion"));
					userbd.setCargo(rs.getString("cargo"));
					alumnos.add(userbd);
				
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
		String grupo=request.getParameter("grupo");
	
		List<UsuarioBean> objAlumnos=listar(grupo);
		if(objAlumnos!=null){
			 request.setAttribute("alumnos",objAlumnos);
		}else{
			request.setAttribute("mensaje", "El detalle del grupo no fue cargada satisfactoriamente");
		}
		
		 request.getRequestDispatcher("/detalleGrupo.jsp").forward(request,response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String grupo=(String) request.getAttribute("grupo") ;
		String mensaje=(String)request.getAttribute("mensaje");
		PrintWriter out = response.getWriter();
		UsuarioBean userbd=null;
		Connection con= null;
		List<UsuarioBean> alumnos = new ArrayList<UsuarioBean>();
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			 String url="jdbc:mysql://localhost:3306/bdsistema";
			  con= DriverManager.getConnection(url,"root","root");
			  
			 String sql="SELECT * FROM t_usuario WHERE grupo='"+grupo+"'";
			 Statement ps=con.createStatement();
			 ResultSet rs=ps.executeQuery(sql);

			 while(rs.next()){
				 	userbd = new UsuarioBean();
					userbd.setUsuario(rs.getInt("idUsuario"));
					userbd.setNombre(rs.getString("nombre"));
					userbd.setClave(rs.getString("contraseña"));
					userbd.setGrupo(rs.getString("grupo"));
					userbd.setSeccion(rs.getString("seccion"));
					userbd.setCargo(rs.getString("cargo"));
					alumnos.add(userbd);
				
			 }
			 request.setAttribute("mensaje", mensaje);
			 request.setAttribute("alumnos",alumnos);

			 
			 request.getRequestDispatcher("/detalleGrupo.jsp").forward(request,response);
			 
			
			
		} catch (Exception ex) {
			ex.printStackTrace();
			out.print(ex.getMessage());
			try{if(con!=null)con.close();}catch(Exception e){out.print(e.getMessage());};
		}
		
		
	}

}
