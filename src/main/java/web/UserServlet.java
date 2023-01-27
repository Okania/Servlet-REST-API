package web;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import dao.UserDao;
import model.User;

public class UserServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Gson gson = null;
	
	private void sendAsJson(HttpServletResponse response, Object obj) throws IOException {
		gson = new Gson();
		
		response.setContentType("application/json");
		
		String res = gson.toJson(obj);
		
		PrintWriter pw = response.getWriter();
		
		pw.print(res);
		pw.flush();			
	}
	
	@SuppressWarnings("unlikely-arg-type")
	protected void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException{
		
		String pathInfo = req.getPathInfo();
		
		if (pathInfo == null || pathInfo == "/") {
			
			Collection<User> users = UserDao.getUsers().values();
			
			sendAsJson(res, users);
			return;			
		}
		
		String[] splits = pathInfo.split("/");
		
        if(splits.length != 2) {
			
			res.sendError(HttpServletResponse.SC_BAD_REQUEST);
			return;
		}
		
        String userId = splits[1];
        
        if (!UserDao.getUsers().containsKey(userId)) {
        	res.sendError(HttpServletResponse.SC_NOT_FOUND);
        	return;			
        }
        
        sendAsJson(res, UserDao.getUsers().get(userId));        
        
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException{
		
		String pathInfo = req.getPathInfo();
		
		if (pathInfo == null || pathInfo == "/") {
			StringBuilder buffer = new StringBuilder();
			BufferedReader reader = req.getReader();
			String line;
			
			while((line = reader.readLine()) != null) {
				buffer.append(line);				
			}
			
			String payload = buffer.toString();
			User user = gson.fromJson(payload, User.class);
			UserDao.getUsers().put(user.getId(), user);
			
			sendAsJson(res, user);		
		}
		else {
			res.sendError(HttpServletResponse.SC_BAD_REQUEST);
			return;
		}
		
	}
	@SuppressWarnings("unlikely-arg-type")
	protected void doPut(HttpServletRequest req, HttpServletResponse res)
			throws ServletException,IOException{
		
		String pathInfo = req.getPathInfo();
		if (pathInfo == null || pathInfo == "/") {
			res.sendError(HttpServletResponse.SC_BAD_REQUEST);
			return;
		}
		
		String[] splits = pathInfo.split("/");
		
        if(splits.length != 2) {			
			res.sendError(HttpServletResponse.SC_BAD_REQUEST);
			return;
		}
        
        String userId = splits[1];
        
        if (!UserDao.getUsers().containsKey(userId)) {
        	res.sendError(HttpServletResponse.SC_NOT_FOUND);
        	return;			
        }
        
        StringBuilder buffer = new StringBuilder();
		BufferedReader reader = req.getReader();
		String line;
		
		while((line = reader.readLine()) != null) {
			buffer.append(line);				
		}
		
		String payload = buffer.toString();
		User user = gson.fromJson(payload, User.class);
		UserDao.getUsers().put(user.getId(), user);
		sendAsJson(res, user);     
         
	}
	@SuppressWarnings("unlikely-arg-type")
	protected void doDelete(HttpServletRequest req, HttpServletResponse res) 
			throws IOException, ServletException{
		
		String pathInfo = req.getPathInfo();
		if (pathInfo == null || pathInfo == "/") {
			res.sendError(HttpServletResponse.SC_BAD_REQUEST);
			return;
		}
		
		String[] splits = pathInfo.split("/");
		
        if(splits.length != 2) {			
			res.sendError(HttpServletResponse.SC_BAD_REQUEST);
			return;
		}
        
        String userId = splits[1];
        
        if (!UserDao.getUsers().containsKey(userId)) {
        	res.sendError(HttpServletResponse.SC_NOT_FOUND);
        	return;			
        }
        
        User user = UserDao.getUsers().get(userId);
        UserDao.getUsers().remove(user);
        
        sendAsJson(res, user);
        return;
		
	}
	
	
	
	

}
