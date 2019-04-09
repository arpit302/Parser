package com.app.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Null;

//import com.sun.istack.internal.Nullable;

@Entity
@Table(name = "user_table1")
public class User {


	@Column(name = "user_Marchex_id")
	private String Marchex_Account_id;


	@Column(name = "user_google_account_id")
	private long google_account_id;

	
	@Column(name = "user_config_id")
	private long Configuration_id;

	
	@Column(name = "user_access_profile_id")
	private long Access_profile_id;

	
	@Column(name = "user_floodLight_id")
	private long Floodlight_id;

	
	@Column(name = "user_floodlight_name")
	private String Floodlight_Name;

	
	
	@Column(name = "user_name")
	private String Name;

	
	@Column(name = "user_state")
	private String state;

	
	@Column(name = "user_region1")
	private String region1;


	@Column(name = "user_region2")
	private String region2;
	
	@Id
	@Column
	private String pk;

	
	
	
	
	
	
	public User() {
		super();
	}

	public User(User user)
	{
		super();
		Marchex_Account_id = user.Marchex_Account_id;
		this.google_account_id = user.google_account_id;
		Configuration_id = user.Configuration_id;
		Access_profile_id = user.Access_profile_id;
		Floodlight_id = user.Floodlight_id;
		Floodlight_Name = user.Floodlight_Name;
		Name = user.Name;
		this.state = user.state;
		this.region1 = user.region1;
		this.region2 = user.region2;
		this.pk = user.pk;
	}




	public User(String marchex_Account_id, long google_account_id, long configuration_id, long access_profile_id,
			long floodlight_id, String floodlight_Name, String name, String state, String region1, String region2,
			String pk) {
		super();
		Marchex_Account_id = marchex_Account_id;
		this.google_account_id = google_account_id;
		Configuration_id = configuration_id;
		Access_profile_id = access_profile_id;
		Floodlight_id = floodlight_id;
		Floodlight_Name = floodlight_Name;
		Name = name;
		this.state = state;
		this.region1 = region1;
		this.region2 = region2;
		this.pk = marchex_Account_id+configuration_id;
	}

	
	
	
	
	
	public String getMarchex_Account_id() {
		return Marchex_Account_id;
	}

	public void setMarchex_Account_id(String marchex_Account_id) {
		Marchex_Account_id = marchex_Account_id;
	}

	public long getGoogle_account_id() {
		return google_account_id;
	}

	public void setGoogle_account_id(long google_account_id) {
		this.google_account_id = google_account_id;
	}

	public long getConfiguration_id() {
		return Configuration_id;
	}

	public void setConfiguration_id(long configuration_id) {
		Configuration_id = configuration_id;
	}

	public long getAccess_profile_id() {
		return Access_profile_id;
	}

	public void setAccess_profile_id(long access_profile_id) {
		Access_profile_id = access_profile_id;
	}

	public long getFloodlight_id() {
		return Floodlight_id;
	}

	public void setFloodlight_id(long floodlight_id) {
		Floodlight_id = floodlight_id;
	}

	public String getFloodlight_Name() {
		return Floodlight_Name;
	}

	public void setFloodlight_Name(String floodlight_Name) {
		Floodlight_Name = floodlight_Name;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getRegion1() {
		return region1;
	}

	public void setRegion1(String region1) {
		this.region1 = region1;
	}

	public String getRegion2() {
		return region2;
	}

	public void setRegion2(String region2) {
		this.region2 = region2;
	}

	public String getPk() {
		return pk;
	}

	public void setPk() {
		this.pk = Marchex_Account_id+Configuration_id;
	}






	@Override
	public String toString() {
		return "Marchex_Account_id=" + Marchex_Account_id + ", google_account_id=" + google_account_id
				+ ", Configuration_id=" + Configuration_id + ", Access_profile_id=" + Access_profile_id
				+ ", Floodlight_id=" + Floodlight_id + ", Floodlight_Name=" + Floodlight_Name + ", Name=" + Name
				+ ", state=" + state + ", region1=" + region1 + ", region2=" + region2 + ", pk=" + pk;
	}
	
	
	
	
	
	

	
}
