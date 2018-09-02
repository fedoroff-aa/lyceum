package info.forallactivities.sql_tables;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JacksonAnnotation;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

@Entity
public class News {
	@Id
	@Column(name="nid", unique= true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long nid;
	private String header;
	@Column(columnDefinition="longtext")
	private String content;
	@JsonFormat(shape=Shape.STRING,pattern="dd.MM.yyyy HH:mm", timezone="Europe/Moscow")
	private Date date;
	
	public News(){}
	public News(Long nid, String header, String content, Date date) {
		this.nid = nid;
		this.header = header;
		this.content = content;
		this.date = date;
	}
	
	public News(Long nid, String header, Date date) {
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
		DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm");
		return dateFormat.format(date);
	}

	public void setDate(Date date) throws Exception{
		DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm");
		this.date = dateFormat.parse(date.toString());
	}

	@Override
	public String toString() {
		return "News [nid=" + nid + ", header=" + header + ", text=" + content + ", date=" + date + "]";
	}
}
