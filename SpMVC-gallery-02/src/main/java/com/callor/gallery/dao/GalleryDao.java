package com.callor.gallery.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.callor.gallery.models.GalleryVO;

public interface GalleryDao extends GenericDao<GalleryVO, String>{
	
	public GalleryVO findByID(String pk);

}
