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

import bean.UserBean;
import bean.UsuarioBean;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * Servlet implementation class RecuperarContraseñaServlet
 */
@WebServlet("/recuperarContrasena")
public class RecuperarContrasenaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public RecuperarContrasenaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    public UserBean validar(int usuario,String correo){
		 
		  String sub=String.valueOf(usuario).substring(0,2);
		  
		  UserBean userdb = null;
		  Connection con=null;
			
			String url="jdbc:mysql://localhost:3306/bdsistema";
			String user="root";
			String password="root";

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
						userdb.setNombre(rs.getString("nombre"));
						userdb.setClave(rs.getString("contraseña"));
						userdb.setCorreo(rs.getString("correo"));
					}
				}catch(Exception ex){
					ex.printStackTrace();
					try{if(con!=null)con.close();}catch(Exception e){};
				}
				
				if(userdb!=null){
				
					if(userdb.getCorreo().equals(correo)){
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
						userdb.setCorreo(rs.getString("correo"));
					
					}
				}catch(Exception ex){
					ex.printStackTrace();
					try{if(con!=null)con.close();}catch(Exception e){};
				}
				
				if(userdb!=null && userdb.getCargo().equals("JP")){
					if(userdb.getCorreo().equals(correo)){
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
	}
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int usuario=Integer.parseInt(request.getParameter("txt_usuario"));
		String correo=request.getParameter("txt_correo");
		
		UserBean objuser = new UserBean();
		
		objuser=validar(usuario,correo);
		
		if(objuser!=null){
			try{
				
				Properties props = new Properties();
	            props.setProperty("mail.smtp.host", "smtp.gmail.com");
	            props.setProperty("mail.smtp.starttls.enable", "true");
	            props.setProperty("mail.smtp.port", "587");
	            props.setProperty("mail.smtp.user", "soporte.gruposw1@gmail.com");
	            props.setProperty("mail.smtp.auth", "true");

	            // Preparamos la sesion
	            Session session = Session.getDefaultInstance(props);

	            // Construimos el mensaje
	            MimeMessage message = new MimeMessage(session);
	            message.setFrom(new InternetAddress(objuser.getCorreo()));
	            message.addRecipient(
	            Message.RecipientType.TO,new InternetAddress(objuser.getCorreo()));
	          
	            message.setSubject("Recuperar Contraseña");
	            message.setText(objuser.getNombre()+" "+"su usuario es: "+objuser.getUsuario()+" y La Contraseña es :" + objuser.getClave());
	            // Lo enviamos.
	            Transport t = session.getTransport("smtp");
	            t.connect("soporte.gruposw1@gmail.com","software123");
	            t.sendMessage(message, message.getAllRecipients());
	            // Cierre.
	            t.close();
			}catch (Exception e) {
				e.printStackTrace();

			}
			request.setAttribute("mensaje", "Se envio su contraseña a su correo, verifiquelo");
		}else{
			request.setAttribute("mensaje", "Escriba correctamente sus datos");	
		}
		
		request.getRequestDispatcher("/login.jsp").
		forward(request, response);

	}


}
