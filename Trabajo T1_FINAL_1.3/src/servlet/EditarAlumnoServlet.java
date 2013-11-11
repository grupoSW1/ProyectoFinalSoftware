package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import bean.UsuarioBean;

/**
 * Servlet implementation class EditarUsuarioServlet
 */
@WebServlet("/editarAlumno")
public class EditarAlumnoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public EditarAlumnoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    public UsuarioBean listar(int id){
    	UsuarioBean objusuario=null; 
		Connection con=null;
		String url="jdbc:mysql://localhost:3306/bdsistema";
		String user="root";
		String password="root";
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.
					getConnection(url, user, password);
			String sql="SELECT * FROM t_usuario WHERE idUsuario=?" ;
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				objusuario= new UsuarioBean();
				objusuario.setUsuario(rs.getInt("idUsuario"));
				objusuario.setNombre(rs.getString("nombre"));
				objusuario.setClave(rs.getString("contraseña"));
				objusuario.setGrupo(rs.getString("grupo"));
				objusuario.setSeccion(rs.getString("seccion"));
				objusuario.setCargo(rs.getString("cargo"));
				objusuario.setCorreo(rs.getString("correo"));
			}
			return objusuario;
		}catch(Exception ex){
			ex.printStackTrace();
			try{if(con!=null)con.close();}catch(Exception e){};
		}
		return null;
    }
    
    public boolean actualizar(UsuarioBean objusuario){
    	int rows=-1;
		Connection con=null;
		String url="jdbc:mysql://localhost:3306/bdsistema";
		String user="root";
		String password="root";
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.
					getConnection(url, user, password);
			String sql="UPDATE t_usuario " +
					"SET nombre=?,contraseña=?,grupo=?," +
					"seccion=?,cargo=?,correo=? " +
					"WHERE idUsuario=?";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, objusuario.getNombre());
			ps.setString(2, objusuario.getClave());
			ps.setString(3, objusuario.getGrupo());
			ps.setString(4, objusuario.getSeccion());
			ps.setString(5, objusuario.getCargo());
			ps.setString(6, objusuario.getCorreo());
			ps.setInt(7, objusuario.getUsuario());
			rows=ps.executeUpdate();
			if(rows!=-1){
				return true;
			}else{
				return false;
			}
		}catch(Exception ex){
			ex.printStackTrace();
			try{if(con!=null)con.close();}catch(Exception e){};
		}
		
		return false;
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Integer id=Integer.parseInt(request.getParameter("codigo"));
		UsuarioBean objusuario=listar(id);
		
		if(objusuario!=null){
			request.setAttribute("alumno", objusuario);
		}else{
			request.setAttribute("mensaje", "No se puede cargar los datos del alumnos");
		}

		request.getRequestDispatcher("/editarAlumno.jsp")
			.forward(request, response);		
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		UsuarioBean objusuario= new UsuarioBean();
		objusuario.setUsuario(Integer.parseInt(request.getParameter("txt_id")));
		objusuario.setNombre(request.getParameter("txt_nombre"));
		objusuario.setClave(request.getParameter("txt_contraseña"));
		objusuario.setGrupo(request.getParameter("txt_grupo"));
		objusuario.setSeccion(request.getParameter("txt_seccion"));
		objusuario.setCargo(request.getParameter("selec_cargo"));
		objusuario.setCorreo(request.getParameter("txt_correo"));
		
		boolean respuesta=actualizar(objusuario);
		
		if(respuesta!=false){
			request.setAttribute("grupo", objusuario.getGrupo());
			request.setAttribute("mensaje", "Se pudo actualizar correctmante al alumno");
			request.getRequestDispatcher("mostrarDetalle").forward(request, response);
		}
		
		else{
			request.setAttribute("grupo", objusuario.getGrupo());
			request.setAttribute("mensaje", "No se pudo actualizar al alumno");
			request.getRequestDispatcher("mostrarDetalle").forward(request, response);
		}
		

		
	}

}
