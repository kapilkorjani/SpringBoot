package com.lorrymgmtsyst.resource;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lorrymgmtsyst.model.AuthenticationResponse;
import com.lorrymgmtsyst.model.User;
import com.lorrymgmtsyst.services.MyUserDetailsService;
import com.lorrymgmtsyst.util.JwtUtil;

@RestController
@SuppressWarnings("unchecked")
public class UserResource {

	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private MyUserDetailsService userDetailService;

	@Autowired
	private JwtUtil jwtTokenUtil;
	
	@PostMapping(path = "/authenticate")
	public ResponseEntity<?> createAuthenticationToken(@RequestBody User user) throws Exception{
	
		try {
		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
		}
		catch (BadCredentialsException e) {
			throw new Exception("Incorrect username or password ", e);
		}
		final UserDetails userDetails = userDetailService.loadUserByUsername(user.getUsername());
		
		final String jwt = jwtTokenUtil.generateToken(userDetails);
		
		return ResponseEntity.ok(new AuthenticationResponse(jwt));
	}
	
	@PostMapping(path = "/register")
	public ResponseEntity<?> registerUser(@RequestBody User user){
	
			User u = userDetailService.registerUser(user);
			if(u != null) {
				JSONObject msg = new JSONObject();
				msg.put("success", "user Registered successfully");
				return ResponseEntity.ok(msg);
			}
			else
			{
				JSONObject msg = new JSONObject();
				msg.put("error", "username already exists");
				return ResponseEntity.badRequest().body(msg);
			}
	}
	
}
