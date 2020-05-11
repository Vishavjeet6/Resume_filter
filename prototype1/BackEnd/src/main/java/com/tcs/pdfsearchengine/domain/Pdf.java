package com.tcs.pdfsearchengine.domain;

import java.io.Serializable;

import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "province", type = "pdf")
public class Pdf implements Serializable{
	
	private static final long serialVersionUID = -1L;

	private Long id;
	private String name;
	private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
	public Pdf() {
		super();
	}

	public Pdf(Long id, String name, String description) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
	}    
}
