package com.callor.gallery.models;

import groovy.transform.ToString;
import groovy.transform.builder.Builder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GalleryVO {
	
	private String	g_id;	//VARCHAR(125)
	private String	g_date;//	VARCHAR(10)
	private String g_time;//	VARCHAR(10)
	private String g_author;//	VARCHAR(20)
	private String g_subject;//	VARCHAR(20)
	private String g_content;	//VARCHAR(100)
	private String g_image;	//LONGTEXT


}
