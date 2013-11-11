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
import javax.swing.JOptionPane;

import bean.UsuarioBean;

/**
 * Servlet implementation class AgregarAlumnoServlet
 */
@WebServlet("/agregarAlumno")
public class AgregarAlumnoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AgregarAlumnoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    public boolean registrar(UsuarioBean objusuario){
    		int rows=-1;
    	int id=0;
		Connection con=null;
		String url="jdbc:mysql://localhost:3306/bdsistema";
		String user="root";
		String password="root";
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.
					getConnection(url, user, password);
			String sql="INSERT INTO " +
					"t_usuario (idUsuario,nombre,contraseña,grupo,seccion,cargo,correo) " +
							"VALUES(?,?,?,?,?,?,?)";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1, objusuario.getUsuario());
			ps.setString(2, objusuario.getNombre());
			ps.setString(3, objusuario.getClave());
			ps.setString(4, objusuario.getGrupo());
			ps.setString(5, objusuario.getSeccion());
			ps.setString(6, objusuario.getCargo());
			ps.setString(7, objusuario.getCorreo());
			
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
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		UsuarioBean objusuario=new UsuarioBean();
		
		objusuario.setUsuario( (int)(Math.round(Math.random() * (99999999-10000000))) + 10000000);
		objusuario.setNombre(request.getParameter("txt_nombre"));
		objusuario.setClave(request.getParameter("txt_contraseña"));
		objusuario.setGrupo(request.getParameter("txt_grupo"));
		objusuario.setSeccion(request.getParameter("txt_seccion"));
		objusuario.setCargo(request.getParameter("selec_cargo"));
		objusuario.setCorreo(request.getParameter("txt_correo"));
		boolean respuesta=registrar(objusuario);
		if(respuesta!=false){
			request.setAttribute("mensaje", "Se inserto correctamente al usuario");
			request.setAttribute("grupo", objusuario.getGrupo());
			request.getRequestDispatcher("mostrarDetalle").forward(request, response);
		}else{
			request.setAttribute("mensaje", "No se inserto correctamente al usuario");
			request.setAttribute("grupo", objusuario.getGrupo());
			request.getRequestDispatcher("mostrarDetalle").forward(request, response);
		}
	}

}
