package net.skhu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import net.skhu.dto.User;
import net.skhu.mapper.UserMapper;
import net.skhu.model.UserSignUp;

@Service
public class UserService {

	@Autowired
	public UserMapper userMapper;

	public List<User> findAll() {
		return userMapper.findAll();
	}

	public User findByLoginName(String loginName) {
		return userMapper.findByLoginName(loginName);
	}

	public boolean hasErrors(UserSignUp userSignUp, BindingResult bindingResult) {
		if (bindingResult.hasErrors())
			return true;
		if (userSignUp.getPasswd1().equals(userSignUp.getPasswd2()) == false) {
			bindingResult.rejectValue("passwd2", null, "비밀번호가 일치하지 않습니다.");
			return true;
		}
		User user = userMapper.findByLoginName(userSignUp.getLoginName());
		if (user != null) {
			bindingResult.rejectValue("loginName", null, "로그인 네임이 중복됩니다.");
			return true;
		}
		return false;
	}

	// 소문자로 고치기
	public User createDto(UserSignUp UserSignUp) {
		User user = new User();
		user.setLoginName(UserSignUp.getLoginName());
		user.setPassword(UserSignUp.getPasswd1());
		user.setName(UserSignUp.getName());
		user.setEmail(UserSignUp.getEmail());
		user.setEnabled(true);
		user.setUserType("학생");
		if (UserSignUp.getDepartmentId() != 0)
			user.setDepartmentId(UserSignUp.getDepartmentId());
		return user;
	}

	public void insert(UserSignUp UserSignUp) {
		User user = createDto(UserSignUp);
		userMapper.insert(user);
	}

}
