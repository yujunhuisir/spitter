package spittr.domain;

import java.util.Date;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class Spittle {
	private final Long id;
	private final String message;
	private final Date time;
	private Double latitude;
	private Double longitude;
	
	public Spittle(Long id,String message, Date time, Double longitude,Double latitude) {
		super();
		this.id = id;
		this.message = message;
		this.time = time;
		this.longitude = longitude;
		this.latitude = latitude;
		
	}

	public Spittle(String message,Date time) {
		this(null,message,time,null,null);
	}
	public Long getId() {
		return id;
	}

	public String getMessage() {
		return message;
	}

	public Date getTime() {
		return time;
	}

	public Double getLatitude() {
		return latitude;
	}

	public Double getLongitude() {
		return longitude;
	}
	public boolean equals(Object that) {
		return EqualsBuilder.reflectionEquals(this,that, "id","time");
	}
	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this, "id","time");
	}
}
