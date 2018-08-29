package info.forallactivities.sql_tables;

//class to support rm request from mainpanel
public class NewsRMs {
	private News news;
	private String istorm;
	
	public NewsRMs() {}
	
	public NewsRMs(String istorm, News news) {
		this.news = news;
		this.istorm = istorm;
	}
	
	public News getNews() {
		return news;
	}
	public void setNews(News news) {
		this.news = news;
	}
	public String getIstorm() {
		return istorm;
	}
	public void setIstorm(String istorm) {
		this.istorm = istorm;
	}
}
