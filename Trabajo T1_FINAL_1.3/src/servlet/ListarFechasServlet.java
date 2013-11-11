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

import bean.FechaBean;

/**
 * Servlet implementation class ListarFechasServlet
 */
@WebServlet("/listarFechas")
public class ListarFechasServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ListarFechasServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    public List<FechaBean> listar(){
    	
    	
    	Connection con=null;
		FechaBean fechabd=null;
		List<FechaBean> fechas = new ArrayList<FechaBean>();
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost/bdsistema", "root", "root");
			Statement stmt=con.createStatement();
			String sql="SELECT * FROM t_fecha";
			ResultSet rs=stmt.executeQuery(sql);
			while(rs.next()){
				fechabd = new FechaBean();
				fechabd.setIdFecha(rs.getInt("idFecha"));
				fechabd.setFecha(rs.getDate("fecha"));
				fechabd.setDescripcion(rs.getString("descripcion"));
				fechas.add(fechabd);
				
			}
			return fechas;
			
		} catch (Exception ex) {
			ex.printStackTrace();
			try{if(con!=null)con.close();}catch(Exception e){ };
		
		}
		return null;
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		List<FechaBean> objListar=listar();
		
		if(objListar!=null){
			request.setAttribute("fecha", objListar);
			
		}else{
			request.setAttribute("mensaje", "No se encuentra registrada las fechas");
		}
		request.getRequestDispatcher("/mostrarFechas.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
