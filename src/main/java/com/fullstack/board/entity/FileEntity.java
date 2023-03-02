package com.fullstack.board.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Entity
@NoArgsConstructor
@Table(name="file")
public class FileEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Long id;
	private String orgNm;
	private String savedNm;
	private String savedPath;
	
	@Builder
	public FileEntity(Long id, String orgNm, String savedNm, String savedPath) {
		this.id = id;
		this.orgNm = orgNm;
		this.savedNm = savedNm;
		this.savedPath = savedPath;
	}
	
}
