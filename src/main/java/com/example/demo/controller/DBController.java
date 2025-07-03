package com.example.demo.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dao.FoodDao;


@Controller
public class DBController {

	// foodDao という変数名で FoodDao インターフェースを利用するための宣言
	@Autowired
	private FoodDao foodDao;
	// 検索画面の表示
	//【Ｑ１】URL「http://localhost:8080/db/search」とひもづけする
	@GetMapping("/db/search")
	public ModelAndView showSearchForm(ModelAndView mav) {
		//【Ｑ２】次に表示させるHTMLファイル名を指定する文
		mav.setViewName("search");
		return mav;
	}
	
	// 検索結果の表示
	//【Ｑ３】URL「http://localhost:8080/db/result」とひもづけする
	@GetMapping("/db/result")
	//【Ｑ４】リクエストとして送られてきた値 searchWord を引数「String searchWord」に格納する
	public ModelAndView search(@RequestParam("searchWord") String searchWord, ModelAndView mav) {
		// searchメソッドの処理内容
		ArrayList<String>foodNameList=foodDao.selectFoodName(searchWord);
		mav.addObject("foodNameList",foodNameList);
		mav.addObject("searchWord",searchWord);
		
		mav.setViewName("result");
		return mav;
	}

}
