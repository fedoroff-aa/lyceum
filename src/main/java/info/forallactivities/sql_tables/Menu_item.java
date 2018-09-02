package info.forallactivities.sql_tables;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

@Entity
@Table(name="menu_content")
public class Menu_item {
	@Id
	@Column(name="sid", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long sid;
	private long mid;
	@JsonFormat(shape = Shape.STRING)
	private String content;
	
	
	
	public Menu_item(long sid, long mid, String content) {
		this.sid = sid;
		this.mid = mid;
		this.content = content;
	}
	public Menu_item() {}
	
	public long getSid() {
		return sid;
	}
	public void setSid(long sid) {
		this.sid = sid;
	}
	public long getMid() {
		return mid;
	}
	public void setMid(long mid) {
		this.mid = mid;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
}
