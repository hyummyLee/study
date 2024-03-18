package com.coffe.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import com.coffe.DAO.CoffeDAO;
import com.coffe.VO.CoffeOrderVO;
import com.coffe.VO.CoffeSaleVO;

public class Controller {

	CoffeDAO cd = new CoffeDAO();
	List<HashMap<String, Object>> orderList = new ArrayList<HashMap<String, Object>>();

	// coffe menu 출력
	public void getCoffeList() {
		List<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
		list = cd.getCoffeList();

		System.out.println("===================================");
		System.out.println("메뉴를 선택하세요. ");

		Iterator<HashMap<String, Object>> iterator = list.iterator();

		// iterator 를 사용한 방법
		while (iterator.hasNext()) {
			HashMap<String, Object> map = iterator.next();
			int coffeId = (int) map.get("coffeId");
			String coffeNm = (String) map.get("coffeNm");
			int price = (int) map.get("price");
			System.out.println(" | " + (coffeId + "|" + coffeNm + "|" + price + " | "));
		}

		// foreach 를 사용한 방법
//			for(HashMap<String, Object> map : list) {
//				int coffeId = (int) map.get("coffeId");
//				String coffeNm = (String) map.get("coffeNm");
//				int price = (int) map.get("price");
//				System.out.println(" | " + (coffeId +"|"+  coffeNm  +"|" +  price + " | " ) );
//			}
		System.out.println("===================================");
	}

	public HashMap<String, Object> getCoffeNm(int coffeId) {

        HashMap<String, Object> csv = cd.getCoffeInfo(coffeId);
        return csv;
    }
	

	// coffe 주문서 입력
	public List<HashMap<String, Object>> setOrderMenu(HashMap<String, Object> map) {
		orderList.add(map);

		if (map.get("flag").equals("N")) {
			cd.setOrderMenu(orderList);
		}
		return orderList;
	}

	// 오늘 매상값 출력
	public void getDaliySales() {

		for (HashMap<String, Object> cv: cd.getDaliySales()) {
			int coffeId = (int) cv.get("coffeId");
			String coffeNm = (String) cv.get("CoffeNm");
			int price = (int) cv.get("Price");
			int saleCnt = (int) cv.get("SaleCnt");
			Date saleDate = (Date) cv.get("SaleDate");

			System.out.println(" | " + (coffeNm + "|" + price + "|" + saleCnt + "|" + saleDate + " | "));
		}
	}

}