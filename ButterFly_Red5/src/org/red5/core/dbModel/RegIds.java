package org.red5.core.dbModel;
// default package
// Generated Mar 29, 2014 3:32:38 PM by Hibernate Tools 4.0.0

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * RegIds generated by hbm2java
 */
@Entity
@Table(name = "reg_ids")
public class RegIds implements java.io.Serializable {

	private Integer id;
	private GcmUsers gcmUsers;
	private String gcmRegId;

	public RegIds() {
	}

	public RegIds(String gcmRegId) {
		this.gcmRegId = gcmRegId;
	}

	public RegIds(GcmUsers gcmUsers, String gcmRegId) {
		this.gcmUsers = gcmUsers;
		this.gcmRegId = gcmRegId;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	public GcmUsers getGcmUsers() {
		return this.gcmUsers;
	}

	public void setGcmUsers(GcmUsers gcmUsers) {
		this.gcmUsers = gcmUsers;
	}

	@Column(name = "gcm_reg_id", nullable = false)
	public String getGcmRegId() {
		return this.gcmRegId;
	}

	public void setGcmRegId(String gcmRegId) {
		this.gcmRegId = gcmRegId;
	}

}
