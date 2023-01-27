package dao;

import java.util.HashMap;
import java.util.Map;

import model.User;

public class UserDao {	
	
	static HashMap<Integer, User> userMap = new HashMap<>();
	
	private UserDao() {
		userMap.put(1, new User(1, "Evans", "Odhis","ICS", 21));
		userMap.put(2, new User(2, "John", "Doe","BCOM", 20));
		userMap.put(3, new User(3, "Naomi", "Okania","BBIT", 24));
		userMap.put(4, new User(4, "Phil", "Foden","CNS", 23));	
	}    
    
    public static Map<Integer, User> getUsers(){
    	return userMap;    	
    }
    

}
