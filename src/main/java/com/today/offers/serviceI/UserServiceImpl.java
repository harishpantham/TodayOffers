package com.today.offers.serviceI;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.today.offers.dto.RoleDTO;
import com.today.offers.dto.UserDTO;
import com.today.offers.model.Role;
import com.today.offers.model.User;
import com.today.offers.repo.UserRepository;
import com.today.offers.utils.Messages;
import com.today.offers.utils.OffersResponse;

@Service
public class UserServiceImpl implements UserServiceI{
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	Messages messageService;

	@Override
	public OffersResponse getAllUsers() {

		List<User> userList = userRepository.findAll();
		OffersResponse offersResponse = new OffersResponse();
		if(!StringUtils.isEmpty(userList)) {
			List<UserDTO> userDTOList = getUserDTOList(userList);
			offersResponse.setMessage(messageService.getMessage("success.message"));
			offersResponse.setStatus(HttpStatus.OK.value());
			offersResponse.setPayLoad(userDTOList);
			return offersResponse;
		}
		else {
			offersResponse.setMessage(messageService.getMessage("user.no"));
			offersResponse.setStatus(HttpStatus.OK.value());
			return offersResponse;
		}
		
	}

	private List<UserDTO> getUserDTOList(List<User> userList) {
		List<UserDTO> userDTOList = new ArrayList<>();
		for(User user : userList) {
			UserDTO userDTO = new UserDTO();
			userDTO.setUserId(user.getUserId());
			userDTO.setUserName(user.getUserName());
			//userDTO.setPassword(user.getPassword());
			RoleDTO roleDTO = new RoleDTO();
			roleDTO.setRoleName(user.getRole().getRoleName());
			userDTO.setRoleDTO(roleDTO);
			userDTOList.add(userDTO);
		}
		return userDTOList;
	}

	@Override
	public OffersResponse getUserById(Long userId) {
		OffersResponse offersResponse = new OffersResponse();
		if(!StringUtils.isEmpty(userId)) {
			Optional<User> optionalUser = userRepository.findById(userId);
			if(optionalUser.isPresent()) {
				List<User> userList = new ArrayList<>();
				User user = optionalUser.get();
				userList.add(user);
				List<UserDTO> userDTOList = getUserDTOList(userList);
				offersResponse.setMessage("success.message");
				offersResponse.setStatus(HttpStatus.OK.value());
				offersResponse.setPayLoad(userDTOList);
			}
			else {
				offersResponse.setMessage(messageService.getMessage("user.no"));
				offersResponse.setStatus(HttpStatus.OK.value());
			}
		}
		else {
			offersResponse.setMessage(messageService.getMessage("invalid.data"));
			offersResponse.setStatus(HttpStatus.BAD_REQUEST.value());
		}
		
		return offersResponse;
	}

	@Override
	public OffersResponse saveUser(UserDTO userDTO) {
		OffersResponse offersResponse = new OffersResponse();
		if(userDTO != null) {
			User user = new User();
			user = getUser(userDTO,user);
			userRepository.save(user);
			offersResponse.setStatus(HttpStatus.OK.value());
			offersResponse.setMessage(messageService.getMessage("user.save"));
		}
		else {
			offersResponse.setStatus(HttpStatus.BAD_REQUEST.value());
			offersResponse.setMessage(messageService.getMessage("invalid.data"));
		}
		return offersResponse;
	}

	@Override
	public OffersResponse updateUser(UserDTO userDTO) {
		OffersResponse offersResponse = new OffersResponse();
		if(userDTO !=null) {
			Optional<User> optionalUser = userRepository.findById(userDTO.getUserId());
			if(optionalUser.isPresent()) {
				User user = getUser(userDTO, optionalUser.get());
			    userRepository.save(user);
			    offersResponse.setStatus(HttpStatus.OK.value());
			    offersResponse.setMessage(messageService.getMessage("user.update"));
			}
			else {
				offersResponse.setStatus(HttpStatus.NOT_FOUND.value());
				offersResponse.setMessage(messageService.getMessage("user.not.found"));
			}
		}
		else {
			offersResponse.setStatus(HttpStatus.BAD_REQUEST.value());
			offersResponse.setMessage(messageService.getMessage("invalid.data"));
		}
		return offersResponse;
	}

	private User getUser(UserDTO userDTO, User user) {

		if(!StringUtils.isEmpty(userDTO.getUserName())) {
			user.setUserName(userDTO.getUserName());
		}
		if(!StringUtils.isEmpty(userDTO.getPassword())) {
			user.setPassword(userDTO.getPassword());
		}
		if(!StringUtils.isEmpty(userDTO.getRoleDTO().getRoleName())) {
			Role role = new Role();
			role.setRoleName(userDTO.getRoleDTO().getRoleName());
			user.setRole(role);
		}
		return user;
	}

	@Override
	public OffersResponse deleteUser(Long userId) {
		OffersResponse offersResponse = new OffersResponse();
		userRepository.deleteById(userId);
		offersResponse.setMessage(messageService.getMessage("user.update"));
		return offersResponse;
	}

	@Override
	public OffersResponse getUserByUserNameAndPassword(UserDTO userDTO) {
		OffersResponse offersResponse = new OffersResponse();
		if(userDTO !=null) {
			Optional<User> optionalUser = userRepository.findByUserNameAndPassword(userDTO.getUserName(), userDTO.getPassword());
			if(optionalUser.isPresent()) {
				List<User> userList = new ArrayList<>();
				List<UserDTO> user = getUserDTOList(userList);
			    offersResponse.setStatus(HttpStatus.OK.value());
			    offersResponse.setMessage(messageService.getMessage("user.found"));
			}
			else {
				offersResponse.setStatus(HttpStatus.NOT_FOUND.value());
				offersResponse.setMessage(messageService.getMessage("user.not.found"));
			}
		}
		else {
			offersResponse.setStatus(HttpStatus.BAD_REQUEST.value());
			offersResponse.setMessage(messageService.getMessage("invalid.data"));
		}
		return offersResponse;
	}
	
}

