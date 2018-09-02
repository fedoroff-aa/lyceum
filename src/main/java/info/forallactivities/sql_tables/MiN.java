package info.forallactivities.sql_tables;

import com.fasterxml.jackson.annotation.JsonSetter;

//class to support rm request from mainpanel
public class MiN {
	private News n;
	private Menu_item mi;
	private String istorm;
	
	public MiN(Menu_item mi, String istorm) {
		this.mi = mi;
		this.istorm = istorm;
	}
	public MiN(News n, String istorm) {
		this.n = n;
		this.istorm = istorm;
	}
	public MiN() {}
	
	public String getIstorm() {
		return istorm;
	}

	@JsonSetter("istorm")
	public void setIstorm(String istorm) {
		this.istorm = istorm;
	}

	public News getN() {
		return n;
	}
	@JsonSetter("n")
	public void setN(News n) {
		this.n = n;
	}

	public Menu_item getMi() {
		return mi;
	}

	@JsonSetter("mi")
	public void setMi(Menu_item mi) {
		this.mi = mi;
	}
}
