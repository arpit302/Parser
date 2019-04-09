package com.app.service;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

import com.app.pojos.User;

public class Utils {

	private static int Marchex_Account_id;
	private static int google_account_id;
	private static int Configuration_id;
	private static int Access_profile_id;
	private static int Floodlight_id;
	private static int Floodlight_Name;
	private static int Name;
	private static int state;
	private static int region1;
	private static int region2;
	private static Map<Integer, BiConsumer<User, String>> map = new HashMap<Integer, BiConsumer<User, String>>();

	public static void numberChecker(String str, int pos) {
		if (str.equals("Marchex Account ID"))
			Utils.Marchex_Account_id = pos;

		if (str.equals("google account ID"))
			Utils.google_account_id = pos;

		if (str.equals("Configuration ID"))
			Utils.Configuration_id = pos;

		if (str.equals("Access profile ID"))
			Utils.Access_profile_id = pos;

		if (str.equals("Floodlight ID"))
			Utils.Floodlight_id = pos;

		if (str.equals("Floodlight Name"))
			Utils.Floodlight_Name = pos;

		if (str.equals("Name"))
			Utils.Name = pos;

		if (str.equals("state"))
			Utils.state = pos;

		if (str.equals("region") && !str.equals(""))
			Utils.region1 = pos;

		if (str.equals("Region"))
			Utils.region2 = pos;

	}

	public static boolean validityCheck() {
		if (Marchex_Account_id == -1)
			return false;

		if (google_account_id == -1)
			return false;

		if (Configuration_id == -1)
			return false;

		if (Access_profile_id == -1)
			return false;

		if (Floodlight_id == -1)
			return false;

		if (Floodlight_Name == -1)
			return false;

		if (Name == -1)
			return false;

		if (state == -1)
			return false;

		if (region1 == -1)
			return false;

		if (region2 == -1)
			return false;

		map.put(Utils.Marchex_Account_id, (user, str) -> {
			user.setMarchex_Account_id(str);
		});

		map.put(Utils.google_account_id, (user, str) -> {
			if (str == null)
				user.setGoogle_account_id(0);
			else if (str.equals(""))
				user.setGoogle_account_id(0);
			else
				user.setGoogle_account_id((long) Double.parseDouble(str));
		});

		map.put(Utils.Configuration_id, (user, str) -> {
			if (str == null)
				user.setConfiguration_id(0);
			else if (str.equals(""))
				user.setConfiguration_id(0);
			else
				user.setConfiguration_id((long) Double.parseDouble(str));
		});

		map.put(Utils.Access_profile_id, (user, str) -> {
			if (str == null)
				user.setAccess_profile_id(0);
			else if (str.equals(""))
				user.setAccess_profile_id(0);
			else
				user.setAccess_profile_id((long) Double.parseDouble(str));
		});

		map.put(Utils.Floodlight_id, (user, str) -> {
			if (str == null)
				user.setFloodlight_id(0);
			else if (str.equals(""))
				user.setFloodlight_id(0);
			else
				user.setFloodlight_id((long) Double.parseDouble(str));
		});

		map.put(Utils.Floodlight_Name, (user, str) -> {
			user.setFloodlight_Name(str);
		});

		map.put(Utils.Name, (user, str) -> {
			user.setName(str);
		});

		map.put(Utils.state, (user, str) -> {
			user.setState(str);
		});

		
		map.put(Utils.region1, (user, str) -> {
			user.setRegion1(str);
		});

		map.put(Utils.region2, (user, str) -> {
			user.setRegion2(str);
		});
		
		return true;
	}

	public static void setObj(int pos, User user, String str) {
		// try {
		Utils.map.get(pos).accept(user, str);
		/*
		 * } catch (NullPointerException e) { e.printStackTrace(); } catch
		 * (NumberFormatException e) { e.printStackTrace(); }
		 */

	}

}
