package com.coffre;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import com.coffe.controller.Controller;
import com.coffe.VO.CoffeOrderVO;
import com.coffe.VO.CoffeSaleVO;

public class Program {

	
	
	
	

		public static void main(String[] args) {
			
			Scanner sc = new Scanner(System.in);
			boolean  run = true;
			
			System.out.println("1. 사용자  2. 운영자");
			String mode = sc.nextLine();
			Controller cc = new Controller();
			List<HashMap<String, Object>>list= new ArrayList<HashMap<String, Object>>();
			
			switch (mode) {
			case "1":
				while(run) {
					cc.getCoffeList();
					int order = sc.nextInt();   //메뉴 선택
					System.out.println("몇잔을 주문하시겠습니까? 1~10");
					int cnt = sc.nextInt();    // 잔수 선택
					System.out.println("더 주문하시겠습니까? Y, N");
					String more = sc.next(); //추가 주문 선택
					
					HashMap<String, Object> map = new HashMap<String, Object>();
					
					map.put("coffeId", order);
					map.put("orderCnt", cnt);
					map.put("flag", more);
					
					//CoffeOrderVO cov = new CoffeOrderVO(order, more, cnt);
					
					list = cc.setOrderMenu(map);
					
					for(HashMap<String, Object> cv : list) {
						int coffid = (int) cv.get("coffeId");
						HashMap<String, Object> csv = cc.getCoffeNm(coffid);
						String orderNm =(String) csv.get("coffeNm");
						int orderPrice = (int) csv.get("price");

						System.out.println(orderNm +" || " + (int)cv.get("orderCnt") +" || " + orderPrice * (int)cv.get("orderCnt"));
					}
					//System.out.println(coffeNm + "가" + cnt + "잔 주문되었습니다.");
				}
				break;
			
			case "2":
				//1. 일자별 매출현황
				//2.메뉴추가
				
				break;

			default:
				break;
			}
				while(run) {
			}

		}
	}