package com.nt.entity;

import java.util.Date;

import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
public class BaseModel {//all are optional props
	
	private Boolean isActive;
	
	private Boolean isDelete;
	
	private Integer createdBy;
	
	private Date createdOn;
	
	private Integer updateBy;
	
	private Date updateOn;
}
