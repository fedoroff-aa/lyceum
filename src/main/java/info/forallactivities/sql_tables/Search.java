package info.forallactivities.sql_tables;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Search {
	private long id;
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd.MM.yyyy HH:mm", timezone="GMT+3")
	private Date date;

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
}
