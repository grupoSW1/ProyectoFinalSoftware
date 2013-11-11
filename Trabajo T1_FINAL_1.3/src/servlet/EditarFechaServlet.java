package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.ParseException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import bean.FechaBean;


/**
 * Servlet implementation class EditarFechaServlet
 */
@WebServlet("/editarFecha")
public class EditarFechaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public EditarFechaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    public FechaBean obtener(int id){
    	FechaBean objfecha=null; 
		Connection con=null;
		String url="jdbc:mysql://localhost:3306/bdsistema";
		String user="root";
		String password="root";
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.
					getConnection(url, user, password);
			String sql="SELECT * FROM t_fecha WHERE idFecha=?" ;
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				objfecha= new FechaBean();
				objfecha.setIdFecha(rs.getInt("idFecha"));
				objfecha.setFecha(rs.getDate("fecha"));
				objfecha.setDescripcion(rs.getString("descripcion"));
	
			}
			return objfecha;
		}catch(Exception ex){
			ex.printStackTrace();
			try{if(con!=null)con.close();}catch(Exception e){};
		}
		return null;
    }
    
    public boolean actualizar(FechaBean objfecha){
    	int rows=-1;
    	Connection con=null;
		String url="jdbc:mysql://localhost:3306/bdsistema";
		String user="root";
		String password="root";
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.
					getConnection(url, user, password);
			String sql="UPDATE t_fecha " +
					"SET fecha=?,descripcion=?" +
					"WHERE idFecha=?";
			PreparedStatement ps=con.prepareStatement(sql);
			
			java.sql.Date sqlDate = new java.sql.Date(objfecha.getFecha().getTime());
			ps.setDate(1, sqlDate);
			ps.setString(2, objfecha.getDescripcion());
			ps.setInt(3, objfecha.getIdFecha());
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
		
		Integer id=Integer.parseInt(request.getParameter("fecha"));
		
		FechaBean objFeha=obtener(id);
		
		if(objFeha!=null){
			request.setAttribute("fecha", objFeha);
		}else{
			request.setAttribute("mensaje", "No se encontro la fehca a editar");
		}
		
		request.getRequestDispatcher("/editarFecha.jsp")
			.forward(request, response);		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Date fecha = null;
		FechaBean objfecha = new FechaBean();
		objfecha.setIdFecha(Integer.parseInt(request.getParameter("txt_id")));
		SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
		try {
			fecha =format.parse(
					request.getParameter("txt_fecha"));
			JOptionPane.showMessageDialog(null, "2_0 "+ fecha);
		} catch (ParseException e) {
			fecha= new Date();
			JOptionPane.showMessageDialog(null, "2_1 "+ fecha);
		}
		objfecha.setFecha(fecha);
		objfecha.setDescripcion(request.getParameter("txt_descripcion"));
		
		boolean respuesta=actualizar(objfecha);
		
		if(respuesta!=false){
			response.sendRedirect("listarFechas");
		}else{
			request.setAttribute("mensaje", "No se pudo actualizar la fecha");
			request.getRequestDispatcher("/editarFecha.jsp").forward(request, response);
		}
		
	
	}

	}
