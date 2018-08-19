package info.forallactivities;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class News {
	@Id
	private int nid;
	private String header;
	private String text;
	private Date date;
	
	public News(){}
	public News(int nid, String header, String text, Date date) {
		this.nid = nid;
		this.header = header;
		this.text = text;
		this.date = date;
	}

	public int getNid() {
		return nid;
	}

	public void setNid(int nid) {
		this.nid = nid;
	}

	public String getHeader() {
		return header;
	}

	public void setHeader(String header) {
		this.header = header;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getDate() {
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm");
		return formatter.format(date).toString();
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "News [nid=" + nid + ", header=" + header + ", text=" + text + ", date=" + date + "]";
	}
}
