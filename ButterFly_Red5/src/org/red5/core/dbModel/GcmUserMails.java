package org.red5.core.dbModel;

// Generated May 25, 2014 7:06:23 PM by Hibernate Tools 4.0.0

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * GcmUserMails generated by hbm2java
 */
@Entity
@Table(name = "gcm_user_mails", uniqueConstraints = @UniqueConstraint(columnNames = "mail"))
public class GcmUserMails implements java.io.Serializable {

	private Integer id;
	private GcmUsers gcmUsers;
	private String mail;

	public GcmUserMails() {
	}

	public GcmUserMails(GcmUsers gcmUsers, String mail) {
		this.gcmUsers = gcmUsers;
		this.mail = mail;
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

	@Column(name = "mail", unique = true, length = 45)
	public String getMail() {
		return this.mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

}
