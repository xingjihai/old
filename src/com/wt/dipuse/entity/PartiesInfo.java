package com.wt.dipuse.entity;

import com.notary.framework.common.entity.BaseEntity;
import java.util.Date;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

/**
当事人基本信息
 */
@Entity
@Table(name = "wt_parties_info")
@Access(AccessType.FIELD)
@DynamicInsert
@DynamicUpdate
public class PartiesInfo extends BaseEntity implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	public static final String _T = "wt_parties_info";
	public static final String _ID = "parties_id";
	public static final String _C = "PartiesInfo";
	
	public static final int IS_DEL_NO = 0;
	public static final int IS_DEL_YES =1;
	/** 当事人id */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer parties_id;
	/** 用户id */
	public Integer user_id;
	/** 当事人类型(0-自然人 1-法人 2-非法人组织) */
	public Integer parties_type;
	/** 姓名 */
	public String name;
	/** 性别(1-男 0-女) */
	public Integer sex;
	/** 出生日期 */
	@Temporal(TemporalType.DATE)
	public Date birthday;
	/** 证件类型 */
	public Integer id_type;
	/** 身份证号 */
	public String id_number;
	/** 联系电话 */
	public String tel;
	/** 国籍 */
	public String nationality;
	/** 民族 */
	public String nation;
	/** 籍贯 */
	public String native_place;
	/** 文化程度 */
	public Integer education_level;
	/** 电子邮箱 */
	public String email;
	/** 邮编 */
	public String zip;
	/** 所在单位 */
	public String company;
	/** 职务 */
	public String position;
	/** 是否删除 */
	public Integer is_del;

	public static PartiesInfo obtain(/*Integer id*/) {
		//@formatter:off
		PartiesInfo o = new PartiesInfo();
		//@formatter:on
		return o;
	}

	public PartiesInfo() {
	}

	public Integer getParties_id() {
		return this.parties_id;
	}

	public void setParties_id(Integer parties_id) {
		this.parties_id = parties_id;
	}

	public Integer getUser_id() {
		return this.user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	public Integer getParties_type() {
		return this.parties_type;
	}

	public void setParties_type(Integer parties_type) {
		this.parties_type = parties_type;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getSex() {
		return this.sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public Date getBirthday() {
		return this.birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public Integer getId_type() {
		return this.id_type;
	}

	public void setId_type(Integer id_type) {
		this.id_type = id_type;
	}

	public String getId_number() {
		return this.id_number;
	}

	public void setId_number(String id_number) {
		this.id_number = id_number;
	}

	public String getTel() {
		return this.tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getNationality() {
		return this.nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getNation() {
		return this.nation;
	}

	public void setNation(String nation) {
		this.nation = nation;
	}

	public String getNative_place() {
		return native_place;
	}

	public void setNative_place(String native_place) {
		this.native_place = native_place;
	}

	public Integer getEducation_level() {
		return this.education_level;
	}

	public void setEducation_level(Integer education_level) {
		this.education_level = education_level;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getZip() {
		return this.zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getCompany() {
		return this.company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getPosition() {
		return this.position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public Integer getIs_del() {
		return this.is_del;
	}

	public void setIs_del(Integer is_del) {
		this.is_del = is_del;
	}
}
