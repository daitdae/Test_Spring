package net.softsociety.springpractice4.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.softsociety.springpractice4.dao.GuestbookDAOPr;
import net.softsociety.springpractice4.domain.GuestbookPr;

@Service
public class GuestbookServicePr {
	
	@Autowired
	GuestbookDAOPr dao;
	
	public int insert(GuestbookPr gb) {
		int n = dao.insert(gb);
		return n;
	}
	
	public ArrayList<GuestbookPr>list(){
		ArrayList<GuestbookPr> glist = dao.list();
		return glist;
	}

	public int delete(GuestbookPr gb) {
		int n = dao.delete(gb);
		return n;
	}

}
