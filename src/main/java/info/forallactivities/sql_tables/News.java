package info.forallactivities.sql_tables;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class News {
	@Id
	@Column(name="nid", unique= true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long nid;
	private String header;
	@Column(columnDefinition="longtext")
	private String content;
	@DateTimeFormat(pattern="dd-MM-yyyy HH:mm")
	private String date;
	
	public News(){}
	public News(Long nid, String header, String content, String date) {
		this.nid = nid;
		this.header = header;
		this.content = content;
		this.date = date;
	}
	
	public News(Long nid, String header, String date) {
		this.nid = nid;
		this.header = header;
		this.date = date;
	}
	
	public News(Long nid) {
		this.nid = nid;
	}

	public Long getNid() {
		return nid;
	}

	public void setNid(Long nid) {
		this.nid = nid;
	}

	public String getHeader() {
		return header;
	}

	public void setHeader(String header) {
		this.header = header;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "News [nid=" + nid + ", header=" + header + ", text=" + content + ", date=" + date + "]";
	}
}
