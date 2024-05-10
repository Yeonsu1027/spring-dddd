package com.callor.hello.dao;

import java.util.List;

import com.callor.hello.models.GalleryVO;

public interface GalleryDao {
	public GalleryVO findByID(String pk);

	public List<GalleryVO> selectAll();

	public int insert(GalleryVO galleryVO);
}
