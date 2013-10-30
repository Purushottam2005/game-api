package com.firstProject.model;

import com.firstProject.validation.annotations.MaxThisYear;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Version;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * Author: Øyvind Bjerke
 * Date: 10/17/13
 * Time: 9:38 AM
 */
@Entity
//@Unique("name")
public class Game extends AbstractPersistable<Long> {

	@NotEmpty
	@Length(max = 32)
	@Column(unique = true)
	private String name;

	@NotNull
	@Min(1)
	@Max(1000)
	private Float price;

	@NotNull
	@MaxThisYear
	@Min(1950)
	private Integer year;

	@Version
	private int version;

	public Game() {
	}

	public Game(String name, Float price) {
		this.name = name;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}
}
