package yoffe.ufo;

public class UFOSighting {
	private String sightedAt;
	private String reportedAt;
	private String location;
	private String shape;
	private String duration;
	private String description;

	public void setSightedAt(String sightedAt) {
		this.sightedAt = sightedAt;
	}

	public void setReportedAt(String reportedAt) {
		this.reportedAt = reportedAt;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public void setShape(String shape) {
		this.shape = shape;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getSightedAt() {
		return sightedAt;
	}

	public String getReportedAt() {
		return reportedAt;
	}

	public String getShape() {
		return shape;
	}

	public String getDuration() {
		return duration;
	}

	public String getDescription() {
		return description;
	}

	public String getLocation() {
		return this.location;
	}

}
