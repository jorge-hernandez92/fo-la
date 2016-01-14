package com.twobig.sivale.bd.to;
// Generated 20/11/2015 02:09:49 PM by Hibernate Tools 4.3.1


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

/**
 * TUsers generated by hbm2java
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
@Table(name="t_users"
    ,catalog="lealtad_schema"
)
public class TUser  implements java.io.Serializable {

	private static final long serialVersionUID = 491334447509871158L;
	private Integer userId;
     private int catProfile;
 	 private int company;
     private String userLogin;
     private String password;
     private String email;
     
     private String fullName;   
     private String firstName; 
     private String lastName1; 
     private String lastName2;
     
     
     private String tjCardNumber;
     private String tjAccountNumber;
     private String tjEmployer;
     private String tjOrigin;
     private String tjCardType;
     private String tjProduct;
     private String tjReference;
     private String tjAccountStatus;
     private String tjCardStatus;
     
     
 	public static final String FIELD_USER_ID = "userId";
 	public static final String FIELD_USER_FIRST_NAME = "firstName";
 	public static final String FIELD_USER_CARD_NUMBER = "tjCardNumber";
 	public static final String FIELD_USER_USER = "userLogin";
 	public static final String FIELD_USER_PASS = "password";
 	public static final String FIELD_USER_COMPANY = "tCompany";
 	public static final String FIELD_USER_CAT_PROFILE = "catProfile";
 	public static final String FIELD_USER_ACCOUNT_NUMBER = "accountNumber";
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="user_id", unique=true, nullable=false)
    public Integer getUserId() {
        return this.userId;
    }
    
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    
    @Column(name="user_login", nullable=false, length=45)
    public String getUserLogin() {
        return this.userLogin;
    }
    
    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
    }

    
    @Column(name="password", length=45)
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }

    
    @Column(name="email", length=45)
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }

    
    @Column(name="full_name", length=100)
    public String getFullName() {
        return this.fullName;
    }
    
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    
    @Column(name="first_name", length=45)
    public String getFirstName() {
        return this.firstName;
    }
    
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    
    @Column(name="last_name_1", length=45)
    public String getLastName1() {
        return this.lastName1;
    }
    
    public void setLastName1(String lastName1) {
        this.lastName1 = lastName1;
    }

    
    @Column(name="last_name_2", length=45)
    public String getLastName2() {
        return this.lastName2;
    }
    
    public void setLastName2(String lastName2) {
        this.lastName2 = lastName2;
    }

    
    @Column(name="tj_card_number", length=45)
    public String getTjCardNumber() {
        return this.tjCardNumber;
    }
    
    public void setTjCardNumber(String tjCardNumber) {
        this.tjCardNumber = tjCardNumber;
    }

    
    @Column(name="tj_account_number", length=45)
    public String getTjAccountNumber() {
        return this.tjAccountNumber;
    }
    
    public void setTjAccountNumber(String tjAccountNumber) {
        this.tjAccountNumber = tjAccountNumber;
    }

    
    @Column(name="tj_employer", length=45)
    public String getTjEmployer() {
        return this.tjEmployer;
    }
    
    public void setTjEmployer(String tjEmployer) {
        this.tjEmployer = tjEmployer;
    }

    
    @Column(name="tj_origin", length=45)
    public String getTjOrigin() {
        return this.tjOrigin;
    }
    
    public void setTjOrigin(String tjOrigin) {
        this.tjOrigin = tjOrigin;
    }

    
    @Column(name="tj_card_type", length=45)
    public String getTjCardType() {
        return this.tjCardType;
    }
    
    public void setTjCardType(String tjCardType) {
        this.tjCardType = tjCardType;
    }

    
    @Column(name="tj_product", length=45)
    public String getTjProduct() {
        return this.tjProduct;
    }
    
    public void setTjProduct(String tjProduct) {
        this.tjProduct = tjProduct;
    }

    
    @Column(name="tj_reference", length=45)
    public String getTjReference() {
        return this.tjReference;
    }
    
    public void setTjReference(String tjReference) {
        this.tjReference = tjReference;
    }

    
    @Column(name="tj_account_status", length=45)
    public String getTjAccountStatus() {
        return this.tjAccountStatus;
    }
    
    public void setTjAccountStatus(String tjAccountStatus) {
        this.tjAccountStatus = tjAccountStatus;
    }

    
    @Column(name="tj_card_status", length=45)
    public String getTjCardStatus() {
        return this.tjCardStatus;
    }
    
    public void setTjCardStatus(String tjCardStatus) {
        this.tjCardStatus = tjCardStatus;
    }


    @Column(name = "fk_profile", nullable = false)
    public int getCatProfile() {
      return this.catProfile;
    }

    public void setCatProfile(int catProfile) {
      this.catProfile = catProfile;
    }

    @Column(name = "fk_company", nullable = false)
    public int getCompany() {
      return this.company;
    }

    public void setCompany(int company) {
      this.company = company;
    }

	@Override
	public String toString() {
		return "TUser [userId=" + userId + ", catProfile=" + catProfile + ", company=" + company + ", userLogin="
				+ userLogin + ", password=" + password + ", firstName=" + firstName + ", lastName1=" + lastName1
				+ ", lastName2=" + lastName2 + ", tjCardNumber=" + tjCardNumber + "]";
	}
}


