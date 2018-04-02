package com.niit.freyamiddleware.restControllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.niit.Freya.dao.ProfileUpdateDAO;
import com.niit.Freya.model.ProfilePicture;
import com.niit.Freya.model.UserDetail;

@RestController
public class PictureController 
{
	@Autowired
	ProfileUpdateDAO profileUpdateDAO;
	
	@RequestMapping(value="/doUpload",method=RequestMethod.POST)
	public ResponseEntity<?> uploadPicture(@RequestParam(value="file")CommonsMultipartFile fileupload,HttpSession session)
	{
	
		
		String userName=(String)session.getAttribute("userName");		
		System.out.println(userName);
		if(userName==null)
		{

    		return new ResponseEntity<Void>(HttpStatus.UNAUTHORIZED);

    	}
		else
		{
			System.out.println("Success");

			ProfilePicture profilePicture=new ProfilePicture();

		profilePicture.setUserName(userName);

		profilePicture.setImage(fileupload.getBytes());

		profileUpdateDAO.save(profilePicture);
		return new ResponseEntity<ProfilePicture>(profilePicture,HttpStatus.OK);
		}
	}
	@RequestMapping(value="/getProfilePicture/{userName}",method=RequestMethod.GET)

	public @ResponseBody byte[] getProfilePicture(@PathVariable String userName){

			ProfilePicture profilePicture=profileUpdateDAO.getProfilePicture(userName);

			if(profilePicture==null)
				return null;
			return profilePicture.getImage();

    	}	
	

}
