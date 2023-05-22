package net.softsociety.springpractice4.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import net.softsociety.springpractice4.domain.GuestbookPr;

@Mapper
public interface GuestbookDAOPr {
	
	//save
	public int insert(GuestbookPr gb);
	
	//select
	public ArrayList<GuestbookPr> list();
	
	//delete
	public int delete(GuestbookPr gb);

}
