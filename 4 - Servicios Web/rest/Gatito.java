package rest;

import java.util.Date;

//import com.fasterxml.jackson.databind.ObjectMapper; // version 2.11.1
//import com.fasterxml.jackson.annotation.JsonProperty; // version 2.11.1
/* ObjectMapper om = new ObjectMapper();
Root root = om.readValue(myJsonString), Root.class); */


public class Gatito{
	
	@Override
	public String toString() {
		return "Gatito [status=" + status + ", _id=" + _id + ", user=" + user + ", text=" + text + ", __v=" + __v
				+ ", source=" + source + ", updatedAt=" + updatedAt + ", type=" + type + ", createdAt=" + createdAt
				+ ", deleted=" + deleted + ", used=" + used + "]";
	}

	public Gatito(Status status, String _id, String user, String text, int __v, String source, Date updatedAt,
			String type, Date createdAt, boolean deleted, boolean used) {
		super();
		this.status = status;
		this._id = _id;
		this.user = user;
		this.text = text;
		this.__v = __v;
		this.source = source;
		this.updatedAt = updatedAt;
		this.type = type;
		this.createdAt = createdAt;
		this.deleted = deleted;
		this.used = used;
	}
	
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public String get_id() {
		return _id;
	}
	public void set_id(String _id) {
		this._id = _id;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public int get__v() {
		return __v;
	}
	public void set__v(int __v) {
		this.__v = __v;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public boolean isDeleted() {
		return deleted;
	}
	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}
	public boolean isUsed() {
		return used;
	}
	public void setUsed(boolean used) {
		this.used = used;
	}

	public static class Status{
		 public boolean verified;
		 public int sentCount;
	}

	 public Status status;
	 public String _id;
	 public String user;
	 public String text;
	 public int __v;
	 public String source;
	 public Date updatedAt;
	 public String type;
	 public Date createdAt;
	 public boolean deleted;
	 public boolean used;
}

