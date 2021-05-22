package com.programmercommunity.hicks.user.assets;

public class Paths {
	public static class UserControllerPaths {
		public static final String GET_ALL_USERS = "user/getAll/";
		public static final String GET_USER_BY_ID = "user/get/";
		public static final String GET_USER_BY_EMAIL = "user/get/{email}";
		public static final String GET_VAILD_EMAIL = "user/validEmail/{email}";
		public static final String GET_VALID_USER = "user/validUser/";
		public static final String POST_ADD_USER = "user/add/";
		public static final String PUT_UPDATE_USER = "user/update";
		public static final String PUT_VERIFY_USER = "user/verify/{email}";
		public static final String PUT_UPDATE_USER_PASSWORD = "user/updatePassword/";
		public static final String DELETE_USER_BY_EMAIL = "user/remove/{email}";
	}
}
