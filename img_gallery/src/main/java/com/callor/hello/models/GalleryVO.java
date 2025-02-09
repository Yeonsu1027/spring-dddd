package com.callor.hello.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GalleryVO {
	private String g_id ;
	private String g_email;
	private String g_password;
	private String g_date;
	private String g_time ;
	private String g_subject; 
	private String g_content; 
	private String g_origin_image; 
	private String g_up_image ;

}
