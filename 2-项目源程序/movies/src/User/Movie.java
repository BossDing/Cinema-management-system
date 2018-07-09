package User;

import java.util.Date;

public class Movie {
	private String id;
	private String name;
	private String introduce;
	private String indate;
	private String outdate;
	private String time;
	private String director;
	private String star;
	private String style;
	private String kind;
	public Movie(String movieId) {
		// TODO Auto-generated constructor stub
		super();
		this.id=movieId;
	}
	public Movie() {
		// TODO Auto-generated constructor stub
		super();
	}
	public Movie(String id2, String name2, String introduce2, String indate2,
			String outdate2, String time2, String director2, String star2,
			String style2, String kind2) {
		// TODO Auto-generated constructor stub
		super();
		this.id = id2;
		this.name = name2;
		this.introduce = introduce2;
		this.indate = indate2;
		this.outdate = outdate2;
		this.time = time2;
		this.director = director2;
		this.star = star2;
		this.style = style2;
		this.kind = kind2;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIntroduce() {
		return introduce;
	}
	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}
	public String getIndate() {
		return indate;
	}
	public void setIndate(String indate) {
		this.indate = indate;
	}
	public String getOutdate() {
		return outdate;
	}
	public void setOutdate(String outdate) {
		this.outdate = outdate;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public String getStar() {
		return star;
	}
	public void setStar(String star) {
		this.star = star;
	}
	public String getStyle() {
		return style;
	}
	public void setStyle(String style) {
		this.style = style;
	}
	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
}
