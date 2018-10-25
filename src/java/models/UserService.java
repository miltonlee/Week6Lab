/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.Serializable;

/**
 *
 * @author 659159
 */
public class UserService  implements Serializable {

    String user1= "adam";
    String user2= "betty";
    String correct="password";
  


   public UserService() {
        
    }
    
    public User login(String username, String password) {

        if (password.equals(correct) &&  (username.equals(user1) || username.equals(user2))) {

            User user = new User(username, password);
            
              return user;
        }
        else{
            return null;
        }
      
    }

}
