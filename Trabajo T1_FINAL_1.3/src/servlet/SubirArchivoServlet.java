package servlet;

import java.io.File;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.io.IOException;
import java.net.UnknownHostException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import javax.swing.JOptionPane;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.Mongo;
import com.mongodb.MongoException;
import com.mongodb.gridfs.GridFS;
import com.mongodb.gridfs.GridFSDBFile;
import com.mongodb.gridfs.GridFSInputFile;

/**
 * Servlet implementation class SubirArchivoServlet
 */
@WebServlet("/subirArchivo")
public class SubirArchivoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    


	Mongo m = null;  

    public SubirArchivoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	public void init(ServletConfig config){

		try {
				m = new Mongo( "localhost" );
				System.out.println("Connected");
		} catch (UnknownHostException e) {e.printStackTrace();
		} catch (MongoException e) {e.printStackTrace();}

	}
    
	public int validar(String nombreArchivo){
		
			 if(nombreArchivo.substring(nombreArchivo.lastIndexOf(".")).equals(".doc")||nombreArchivo.substring(nombreArchivo.lastIndexOf(".")).equals(".docx")){
	   	    	
		       	  if(nombreArchivo.lastIndexOf("\\")==-1){
		       		  
					        		  if(nombreArchivo.substring(0, 2).equalsIgnoreCase("DS")){
					            		   
					    					if(nombreArchivo.substring(0, 5).equalsIgnoreCase("DS_RS")||
					    					   nombreArchivo.substring(0, 6).equalsIgnoreCase("DS_ADS")||
					    					   nombreArchivo.substring(0, 5).equalsIgnoreCase("DS_DS")||
					    					   nombreArchivo.substring(0, 5).equalsIgnoreCase("DS_IP")||
					    					   nombreArchivo.substring(0, 6).equalsIgnoreCase("DS_EMP")){
					  
					    						return 1;
					    					}else{
					    						return -1;
					    					}
					    					
					        		 }else if(nombreArchivo.substring(0, 2).equalsIgnoreCase("GP")){
					    					
					        					if(nombreArchivo.substring(0, 5).equalsIgnoreCase("GP_PP")||
					        					   nombreArchivo.substring(0, 6).equalsIgnoreCase("GP_EJP")||
					        					   nombreArchivo.substring(0, 6).equalsIgnoreCase("GP_EVP")||
					        					   nombreArchivo.substring(0, 5).equalsIgnoreCase("GP_CP")){
					        						
					        						return 2;

						    					}else{
						    						return -1;
						    					}
					    				
					        		 }else{
					        			 return -1;
					    			 }	
		             	 
		             }else{
		            	 
		           	  nombreArchivo = nombreArchivo.substring(nombreArchivo.lastIndexOf("\\"));
		  
				            	  if(nombreArchivo.substring(1, nombreArchivo.lastIndexOf(".")).substring(0, 2).equalsIgnoreCase("DS")){
				            		
				    					if(nombreArchivo.substring(1, nombreArchivo.lastIndexOf(".")).substring(0, 5).equalsIgnoreCase("DS_RS")||
				    					   nombreArchivo.substring(1, nombreArchivo.lastIndexOf(".")).substring(0, 6).equalsIgnoreCase("DS_ADS")||
				    					   nombreArchivo.substring(1, nombreArchivo.lastIndexOf(".")).substring(0, 5).equalsIgnoreCase("DS_DS")||
				    					   nombreArchivo.substring(1, nombreArchivo.lastIndexOf(".")).substring(0, 5).equalsIgnoreCase("DS_IP")||
				    					   nombreArchivo.substring(1, nombreArchivo.lastIndexOf(".")).substring(0, 6).equalsIgnoreCase("DS_EMP")){
				    					
				    						return 1;

				    					}else{
				    						return -1;
				    					}
				    					
				    				}else if(nombreArchivo.substring(1, nombreArchivo.lastIndexOf(".")).substring(0, 2).equalsIgnoreCase("GP")){
				    					
				    					if(nombreArchivo.substring(1, nombreArchivo.lastIndexOf(".")).substring(0, 5).equalsIgnoreCase("GP_PP")||
				    					   nombreArchivo.substring(1, nombreArchivo.lastIndexOf(".")).substring(0, 6).equalsIgnoreCase("GP_EJP")||
				    					   nombreArchivo.substring(1, nombreArchivo.lastIndexOf(".")).substring(0, 6).equalsIgnoreCase("GP_EVP")||
				    					   nombreArchivo.substring(1, nombreArchivo.lastIndexOf(".")).substring(0, 5).equalsIgnoreCase("GP_CP")){
				    						
				    						return 2;
				    					}else{
				    						return -1;
				    					}
				    					
				    				}else{
				    					return -1;
				    				}	
		             }
	
	     }else{
	    	 return -1;
	     }
		

	}
	
	public boolean cargar(List<FileItem> fileItemsList,int respuesta){
		

			  String optionalFileName = "";
			  FileItem fileItem = null;

			  Iterator it = fileItemsList.iterator();
			  while (it.hasNext()){
			    FileItem fileItemTemp = (FileItem)it.next();
			    if (fileItemTemp.isFormField()){

			    	JOptionPane.showMessageDialog(null, "1_"+fileItemTemp.getFieldName() +"2_"+fileItemTemp.getString());
			 /**
			    	fileItemTemp.getFieldName();
			    	fileItemTemp.getString();
			**/

					      if (fileItemTemp.getFieldName().equals("DS_ADSpruebadocx"))
					        optionalFileName = fileItemTemp.getString();
			    }else
			      fileItem = fileItemTemp;
			  }

			  if (fileItem!=null){
			    String fileName = fileItem.getName();


			JOptionPane.showMessageDialog(null,"1_"+fileItem.getContentType()+"2_"+ fileItem.getFieldName()+"3_"+fileName+"4_"+fileItem.getSize() );

			/**fileItem.getContentType();
			fileItem.getFieldName(); 
			fileName;
			fileItem.getSize();
			**/

			    /* Save the uploaded file if its size is greater than 0. */
			    if (fileItem.getSize() > 0){
			      if (optionalFileName.trim().equals(""))
			        fileName = FilenameUtils.getName(fileName);
			      else
			        fileName = optionalFileName;

			      String dirName = "c:\\file_uploads\\";

			      File saveTo = new File(dirName + fileName);
			      
			      //-------------------------------------------------------
			      
			      try {
			 
						Mongo mongo = new Mongo("localhost", 27017);
						DB db = mongo.getDB("test");
						DBCollection collection = db.getCollection("player");
			 
						String newFileName = fileName;
			 
						File File = saveTo;//new File("C:\\Users\\Moacy\\Pictures\\10gen_Background_3.png");
			 
						// create a "photo" namespace
						switch (respuesta) {
						case 1:
							GridFS gfsPhoto1 = new GridFS(db, "DS");
							 
							// get image file from local drive
							GridFSInputFile gfsFile1 = gfsPhoto1.createFile(File);
				 
							// set a new filename for identify purpose
							gfsFile1.setFilename(newFileName);
				 
							// save the image file into mongoDB
							gfsFile1.save();
							break;

						case 2:
							GridFS gfsPhoto2 = new GridFS(db, "GP");
						 
							// get image file from local drive
							GridFSInputFile gfsFile2 = gfsPhoto2.createFile(File);
				 
							// set a new filename for identify purpose
							gfsFile2.setFilename(newFileName);
				 
							// save the image file into mongoDB
							gfsFile2.save();
							break;
						}


			 
			 
					} catch (UnknownHostException e) {
						e.printStackTrace();
					} catch (MongoException e) {
						e.printStackTrace();
					} catch (IOException e) {
						e.printStackTrace();
					}
			      
			      //-------------------------------------------------------

			      try {
			        fileItem.write(saveTo);

			      }
			      catch (Exception e){
			    	  e.printStackTrace();




			      }
			      return true;
			    }else{
			    	return false;
			    }
			    }else{
			    	return false;
			    }
 }
		
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			PrintWriter out = response.getWriter();
			int usuario=10333;
			
			if (ServletFileUpload.isMultipartContent(request)){
				  ServletFileUpload servletFileUpload = new ServletFileUpload(new DiskFileItemFactory());
				  List<FileItem> fileItemsList=null;
				try {
					fileItemsList = servletFileUpload.parseRequest(request);
				} catch (FileUploadException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				  FileItem item = fileItemsList.get(0);
					
			
				//fileItemsList.get(0);
				 String nombreArchivo = item.getName();
				 
				 int respuesta=validar(nombreArchivo);
				 
				 if(respuesta!=-1){
						boolean respuesta2=cargar(fileItemsList,respuesta);
						if(respuesta2!=false){
							request.setAttribute("mensaje", "El documento fue subido correctamente");
						}else{
							request.setAttribute("mensaje", "El documento no se subió correctamente");
						}

				
				 }else{
					 request.setAttribute("mensaje", "Documento no valido");
				 }
				 
				 
				 request.getRequestDispatcher("/subirArchivo.jsp").forward(request, response);
			}
	}

//FIN DE LA CLASE
}
