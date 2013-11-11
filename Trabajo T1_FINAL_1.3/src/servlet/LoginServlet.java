package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.AdminBean;
import bean.UserBean;
import bean.UsuarioBean;

import java.sql.*;
/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	String pagina="/login.jsp";
	
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	public UserBean validar(int usuario,String contraseña){
		
	//	if(usuario>10000000 && usuario<99999999){
		  String sub=String.valueOf(usuario).substring(0,2);
		  
		  UserBean userdb = null;
		  Connection con=null;
			
			String url="jdbc:mysql://localhost:3306/bdsistema";
			String user="root";
			String password="root";
			pagina="/login.jsp";
			
				 
			
			if(sub.equals("20")){
				
				//ACA ES ADMIN
				try{
					
					Class.forName("com.mysql.jdbc.Driver");
					con=DriverManager.
							getConnection(url, user, password);
					String sql="SELECT * FROM t_admin WHERE idAdmin=?";
					PreparedStatement ps=con.prepareStatement(sql);
					ps.setInt(1, usuario);
					ResultSet rs=ps.executeQuery();
					while(rs.next()){
						userdb = new UserBean();
						userdb.setUsuario(rs.getInt("idAdmin"));
						userdb.setClave(rs.getString("contraseña"));
						userdb.setNombre(rs.getString("nombre"));
						userdb.setCorreo(rs.getString("correo"));
					}
				}catch(Exception ex){
					ex.printStackTrace();
					try{if(con!=null)con.close();}catch(Exception e){};
				}
				
				if(userdb!=null){
				
					if(userdb.getClave().equals(contraseña)){
						pagina="/adminIndex.jsp";
							return userdb;
					}else{
						return null;
					}
				}else{
						return null;
				}


			}else if(sub.equals("10")){
				//ACA ES USUARIO
				
				try{
					Class.forName("com.mysql.jdbc.Driver");
					con=DriverManager.
							getConnection(url, user, password);
					String sql="SELECT * FROM t_usuario WHERE idUsuario=?";
					PreparedStatement ps=con.prepareStatement(sql);
					ps.setInt(1, usuario);
					ResultSet rs=ps.executeQuery();
					while(rs.next()){
						userdb = new UserBean();
						userdb.setUsuario(rs.getInt("idUsuario"));
						userdb.setNombre(rs.getString("nombre"));
						userdb.setClave(rs.getString("contraseña"));
						userdb.setCargo(rs.getString("cargo"));
					
					}
				}catch(Exception ex){
					ex.printStackTrace();
					try{if(con!=null)con.close();}catch(Exception e){};
				}
				
				if(userdb!=null && userdb.getCargo().equals("JP")){
					if(userdb.getClave().equals(contraseña)){
						pagina="/usuarioIndex.jsp";
						return userdb;
					}else{
							return null;

					}
				}else{
					return null;		
				}
		  
			  }else{
				  return null;
			  }
			//}return null;
		
 }
		
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		HttpSession sesion=request.getSession();
		
		sesion.removeAttribute("user");
		
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int usuario=Integer.parseInt(request.getParameter("txt_usuario"));
		String contraseña=request.getParameter("txt_contraseña");
		UserBean objuser = new UserBean();
		
		objuser=validar(usuario,contraseña);
		
		
		if(objuser!=null){
			HttpSession session= request.getSession(true);
			session.setAttribute("user", objuser);
			request.getRequestDispatcher(pagina).
			forward(request, response);
		}else{
			request.setAttribute("mensaje", "Escriba correctamente sus datos");
			request.getRequestDispatcher(pagina).
				forward(request, response);
		}
			
	
		
	}

}
