package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.UnknownHostException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;

import com.mongodb.BasicDBObject;

import bean.UsuarioBean;



import java.io.File;
import java.io.IOException;
import java.net.UnknownHostException;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.Mongo;
import com.mongodb.MongoException;
import com.mongodb.gridfs.GridFS;
import com.mongodb.gridfs.GridFSDBFile;
import com.mongodb.gridfs.GridFSInputFile;




/**
 * Servlet implementation class MongoServlet
 */
@WebServlet("/mongo")
public class MongoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	boolean validacion=false;
	Mongo m = null;  

	public MongoServlet() {

	super();

	// TODO Auto-generated constructor stub

	}

	public void init(ServletConfig config){

	try {

	m = new Mongo( "localhost" );

	System.out.println("Connected");
	} catch (UnknownHostException e) {
	// TODO Auto-generated catch block
			e.printStackTrace();
	} catch (MongoException e) {
	// TODO Auto-generated catch block
		e.printStackTrace();

	}

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	// TODO Auto-generated method stub

		


if (ServletFileUpload.isMultipartContent(request)){
  ServletFileUpload servletFileUpload = new ServletFileUpload(new DiskFileItemFactory());
  List fileItemsList = null;
try {
	fileItemsList = servletFileUpload.parseRequest(request);
} catch (FileUploadException e1) {
	// TODO Auto-generated catch block
	e1.printStackTrace();
}

  String optionalFileName = "";
  FileItem fileItem = null;

  Iterator it = fileItemsList.iterator();
  
		  while (it.hasNext()){
			    FileItem fileItemTemp = (FileItem)it.next();
			    if (fileItemTemp.isFormField()){
			
			    	JOptionPane.showMessageDialog(null, "1_0 :"+fileItemTemp.getFieldName() +",1_1 :"+fileItemTemp.getString());
			 /**
			    	fileItemTemp.getFieldName();
			    	fileItemTemp.getString();
			**/
			
			      if (fileItemTemp.getFieldName().equals("DS_ADSpruebadocx")){
			    	  JOptionPane.showMessageDialog(null, "2_1: DS_ADSpruebadocx: "+fileItemTemp.getFieldName().equals("DS_ADSpruebadocx") );
			        optionalFileName = fileItemTemp.getString();
			      }else{
			    	JOptionPane.showMessageDialog(null, "2_2: no esta en DS_ADSpruebadocx");
			      fileItem = fileItemTemp;
			      }
			
				  if (fileItem!=null){
				    String fileName = fileItem.getName();
				
				
				JOptionPane.showMessageDialog(null,"3_1 :"+fileItem.getContentType()+",3_2 :"+ fileItem.getFieldName()+",3_3 :"+fileName+"3_4  :"+fileItem.getSize() );
				
				/**fileItem.getContentType();
				fileItem.getFieldName(); 
				fileName;
				fileItem.getSize();
				**/
				
				    /* Save the uploaded file if its size is greater than 0. */
					    if (fileItem.getSize() > 0){
					    	
							      if (optionalFileName.trim().equals("")){
							        fileName = FilenameUtils.getName(fileName);
							      }else{
							    	  JOptionPane.showMessageDialog(null, "4_1 :"+optionalFileName);
							        fileName = optionalFileName;
							
							      String dirName = "c:\\file_uploads\\";
							JOptionPane.showMessageDialog(null, "5_1:"+fileName);
							      File saveTo = new File(fileName);
							      
							      //-------------------------------------------------------
							      
							      try {
							 
										Mongo mongo = new Mongo("localhost", 27017);
										DB db = mongo.getDB("test");
										DBCollection collection = db.getCollection("player");
							 
										String newFileName = fileName;
							 
										File File = saveTo;//new File("C:\\Users\\Moacy\\Pictures\\10gen_Background_3.png");
							 
										// create a "photo" namespace
										GridFS gfsPhoto = new GridFS(db, "photo");
							 
										// get image file from local drive
										GridFSInputFile gfsFile = gfsPhoto.createFile(File);
							 
										// set a new filename for identify purpose
										gfsFile.setFilename(newFileName);
							 
										// save the image file into mongoDB
										gfsFile.save();
							 
							 
									} catch (UnknownHostException e) {e.printStackTrace(); 
							        }  catch (MongoException e) {e.printStackTrace();
									} catch (IOException e) {e.printStackTrace();}
							      
							      //-------------------------------------------------------
							
							      try {fileItem.write(saveTo);}catch (Exception e){e.printStackTrace();}
							      
							      }
					    }
				  }
			}
		}	
}
//FIN DOPOST
}
	
//fin clase	
}	
