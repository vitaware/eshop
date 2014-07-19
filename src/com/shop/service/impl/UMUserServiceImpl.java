package com.shop.service.impl;

import java.util.List;

import com.shop.dao.UMUserDao;
import com.shop.dao.impl.UMUserDaoImpl;
import com.shop.domain.User;
import com.shop.service.UMUserService;
import com.shop.utils.IdTools;
import com.shop.utils.MD5Tools;

/**
 * UserServuce Implements
 * @author Administrator
 *
 */
public class UMUserServiceImpl implements UMUserService {
	
	//鍒涘缓dao灞�绫荤殑瀵硅薄
	UMUserDao ud =new UMUserDaoImpl();
	
	/* (non-Javadoc)
	 * @see com.shop.service.impl.UserService#registUserSer(com.shop.domain.User)
	 */
	public boolean registUserSer(User user){
	
		//璋冪敤dao灞�鍒ゆ柇璇ョ敤鎴锋槸鍚﹀瓨鍦�
		 //瀛樺湪 鍒欐斁鍥瀎alse
		String uname = user.getName();
		User uresl = ud.findByName(uname);
		
		if(uresl!=null){
			return false;
		}
		
		//濡傛灉涓嶅瓨鍦ㄥ垯杩涜娉ㄥ唽
		//1銆佽灏嗗瘑鐮佽繘琛屽姞瀵�
		//2銆佹坊鍔爄d鍊�
		user.setId(IdTools.getRandomId());
	 	user.setPwd( MD5Tools.getMD5String(user.getPwd()));
		
		boolean regiterUser = ud.regiterUser(user);
		if(regiterUser){
			return true;
		}else{
			return false;
		}
		
	}

	public User loginUserSer(String name, String pwd) { 
		//璋冪敤dao灞備腑鏂规硶杩涜鍔犲瘑
		return ud.loginUser(name, MD5Tools.getMD5String(pwd));
	}
	/**
	 * 鐢ㄦ埛鏇存柊
	 */

	public boolean updateUserSer(User user) {
		return ud.updateUser(user);
	}

	public List<User> findAllSer() {
		return ud.findAll();
	}

	public User findUserByIdSer(String id) {
		return ud.findUserById(id);
	}

	
	
	
}
