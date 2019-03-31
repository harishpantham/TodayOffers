package com.today.offers.serviceI;

import com.today.offers.dto.UserDTO;
import com.today.offers.utils.OffersResponse;

public interface UserServiceI {
	
	OffersResponse getAllUsers();
	OffersResponse getUserById(Long  userId);
	OffersResponse saveUser(UserDTO userDTO);
	OffersResponse updateUser(UserDTO userDTO);
	OffersResponse deleteUser(Long  userId);
	OffersResponse getUserByUserNameAndPassword(UserDTO userDTO);

}
