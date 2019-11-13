package com.project2.Service;

import org.springframework.stereotype.Service;

@Service
public class LoginService {
public boolean validateUser(String userid, String password) {
	return userid.equalsIgnoreCase("badri")&& password.equalsIgnoreCase("12345");
}
}
