package com.companyname.service.util;

public class SocialUtil {

	public static String buildFacebookPhotoUrl(String fbUserId) {
		if (fbUserId == null) {
			return "NO_PHOTO";
		}
		return "http://graph.facebook.com/" + fbUserId + "/picture";
	}

}
