package com.niit.freyamiddleware.restControllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.niit.Freya.dao.UserDetailDAO;
import com.niit.Freya.model.UserDetail;

@RestController
public class UserController {
	@Autowired
	UserDetailDAO userDetailDAO;
	
	@PostMapping(value="/login")
	public ResponseEntity<UserDetail> checkLogin(@RequestBody UserDetail userDetail,HttpSession session)
	{
		if(userDetailDAO.checkLogin(userDetail))
		{
			UserDetail tempUser=(UserDetail)userDetailDAO.getUserDetail(userDetail.getUserName());
			userDetailDAO.updateOnlineStatus("Y",tempUser);
			session.setAttribute("userName", tempUser.getUserName());

	    	session.setAttribute("role", tempUser.getRole());

	    	
			return new ResponseEntity<UserDetail>(tempUser,HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<UserDetail>(userDetail,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	

		@PostMapping(value = "/registerUser")

		public ResponseEntity<String> registerUser(@RequestBody UserDetail user) {

			

			user.setRole("USER");

			if (userDetailDAO.registerUser(user)) {

				return new ResponseEntity<String>("User Registered Successfully", HttpStatus.OK);

			} else {

				return new ResponseEntity<String>("User registration failed", HttpStatus.NOT_FOUND);

			}

		}


		@RequestMapping(value="/logout",method=RequestMethod.GET)

	    public ResponseEntity<?> logout(HttpSession session){

	    	if(session.getAttribute("userName")==null){


	    		return new ResponseEntity<Void>(HttpStatus.UNAUTHORIZED);

	    	}

	    	String userName=(String)session.getAttribute("userName");

	    	UserDetail userDetails=userDetailDAO.getUserDetail(userName);

			userDetailDAO.updateOnlineStatus("Y",userDetails);

	    	session.removeAttribute("userName");

	    	session.invalidate();

	    	return new ResponseEntity<Void>(HttpStatus.OK);

	    }
		

		@PutMapping(value = "/updateUser/{userName}")

		public ResponseEntity<String> updateUser(@PathVariable("userName") String userName, @RequestBody UserDetail userDetail) {

			System.out.println("In updating user " + userName);

			UserDetail mUser = userDetailDAO.getUserDetail(userName);

			if (mUser == null) {

				System.out.println("No user found with userName " + userName);

				return new ResponseEntity<String>("No user found", HttpStatus.NOT_FOUND);

			}


			userDetailDAO.updateUserDetail(userDetail);

			return new ResponseEntity<String>("User updated successfully", HttpStatus.OK);

		}




		@GetMapping(value = "/listUsers")

		public ResponseEntity<List<UserDetail>> listUsers() {

			List<UserDetail> listUsers = userDetailDAO.listUser();

			if (listUsers.size() != 0) {

				return new ResponseEntity<List<UserDetail>>(listUsers, HttpStatus.OK);

			}

			return new ResponseEntity<List<UserDetail>>(listUsers, HttpStatus.NOT_FOUND);

		}




		@GetMapping(value = "/getUser/{userName}")

		public ResponseEntity<UserDetail> getUser(@PathVariable("userName") String userName) {

			UserDetail user = userDetailDAO.getUserDetail(userName);

			if (user == null) {

				System.out.println("No user found");

				return new ResponseEntity<UserDetail>(user, HttpStatus.NOT_FOUND);

			} else {

				return new ResponseEntity<UserDetail>(user, HttpStatus.OK);

			}

		}



		@DeleteMapping(value = "/deleteUser/{userName}")

		public ResponseEntity<String> deleteUser(@PathVariable("userName") String userName) {

			System.out.println("In delete user" + userName);

			UserDetail user = userDetailDAO.getUserDetail(userName);

			if (user == null) {

				System.out.println("No user with userName " + userName + " found to delete");

				return new ResponseEntity<String>("No user found to delete", HttpStatus.NOT_FOUND);

			} else {

				userDetailDAO.deleteUserDetail(user);

				return new ResponseEntity<String>("User with userName " + userName + " deleted successfully", HttpStatus.OK);

			}

		}
}
