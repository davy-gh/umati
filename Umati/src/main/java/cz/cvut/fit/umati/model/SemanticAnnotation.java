package cz.cvut.fit.umati.model;

public class SemanticAnnotation {
	/**
	 * TODO: doc it
	 * 
	 * Example: /m/04l4qhn
	 */
	private String mid;

	/**
	 * TODO: doc it
	 * 
	 * Example: /royalty/noble_rank_gender_equivalence
	 */
	private String id;

	/**
	 * TODO: doc it
	 * 
	 * Example: Noble rank gender equivalence
	 */
	private String name;

	/**
	 * TODO: doc it
	 * 
	 * Example: {name=Type, id=/type/type}
	 */
	private SemanticAnnotation notable;

	/**
	 * TODO: doc it
	 * 
	 * Example: en
	 */
	private String lang;

	/**
	 * TODO: doc it
	 * 
	 * Example: 5.07201
	 */
	private double score;

	/*
	 * Getters & Setters
	 */
	public String getMid() {
		return mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
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

	public SemanticAnnotation getNotable() {
		return notable;
	}

	public void setNotable(SemanticAnnotation notable) {
		this.notable = notable;
	}

	public String getLang() {
		return lang;
	}

	public void setLang(String lang) {
		this.lang = lang;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}

	@Override
	public String toString() {
		return "SemanticAnnotation [mid=" + mid + ", id=" + id + ", name=" + name + ", notable=" + notable + ", lang=" + lang + ", score=" + score + "]";
	}
}
