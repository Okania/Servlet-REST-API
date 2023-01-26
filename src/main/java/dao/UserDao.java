package dao;

import java.util.HashMap;

import model.User;

public class UserDao {
	
	
    
    public HashMap<Integer,User> populateUsers(){
    	
    	HashMap<Integer, User> userMap = new HashMap<>();
    	
    	userMap.put(1, new User(1, "Evans", "Odhis","ICS", 21));
    	userMap.put(2, new User(2, "John", "Doe","BCOM", 20));
    	userMap.put(3, new User(1, "Naomi", "Okania","BBIT", 24));
    	userMap.put(4, new User(1, "Phil", "Foden","CNS", 23));	
    	
    }

}
