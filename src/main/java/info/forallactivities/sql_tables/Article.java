package info.forallactivities.sql_tables;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="article")
public class Article {
	@Id
	@Column(name="sid", unique = true, nullable = false)
	private long sid;
	private String article_content;
	public Article() {}
	public Article(long sid, String article_content) {
		this.sid = sid;
		this.article_content = article_content;
	}
	public long getSid() {
		return sid;
	}
	public void setSid(long sid) {
		this.sid = sid;
	}
	public String getArticle_content() {
		return article_content;
	}
	public void setArticle_content(String article_content) {
		this.article_content = article_content;
	}
}
