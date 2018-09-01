package info.forallactivities.sql_tables;

public class Article {
	private String pagename;
	private String pagecontent;
	
	public Article(String pagename, String pagecontent) {
		this.pagename = pagename;
		this.pagecontent = pagecontent;
	}
	public Article(String pagename) {
		this.pagename = pagename;
	}
	public Article() {}
	
	public String getPagename() {
		return pagename;
	}
	public void setPagename(String pagename) {
		this.pagename = pagename;
	}
	public String getPagecontent() {
		return pagecontent;
	}
	public void setPagecontent(String pagecontent) {
		this.pagecontent = pagecontent;
	}
	
	
}
