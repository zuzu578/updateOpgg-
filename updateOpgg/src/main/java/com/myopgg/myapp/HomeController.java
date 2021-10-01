package com.myopgg.myapp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.myopgg.myapp.summonerDto.SummonerDto;

@Controller
public class HomeController {
	
	final static String API_KEY = "RGAPI-b2f4dc60-f934-4afe-91ea-d9ec18c35685";
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	/**
	 * @author lee 
	 * apiKey 는 유효기간이 있으므로 갱신해주어야합니다!
	 * @return 
	 */
	
	/**
	 * @description : 소환사아이디를 입력하면 해당 소환사의 정보를 가져오게됩니다.
	 * @param req
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String searchSummoner(HttpServletRequest req ,  Model model) {
		SummonerDto summonerDto = null; // 소환사 정보 dto class 
		String summonerName = req.getParameter("summonerName");
		String result = "";
		String line;
		logger.debug(summonerName);
		BufferedReader br = null;
		try {
			String urlstr = "https://kr.api.riotgames.com/lol/summoner/v4/summoners/by-name/"+
					summonerName.replace(" ", "")		+"?api_key="+API_KEY;
			URL url = new URL(urlstr);
			HttpURLConnection urlconnection = (HttpURLConnection) url.openConnection();
			urlconnection.setRequestMethod("GET"); // get 방식으로 데이터를 가져옵니다.
			br = new BufferedReader(new InputStreamReader(urlconnection.getInputStream(),"UTF-8")); //utf-8로 인코딩!
			
			while((line = br.readLine()) != null) { 
				result = result + line;
			}
			JsonParser jsonParser = new JsonParser(); // json 으로 받아온 객체들을 parsing 해줍니다.
			JsonObject jResult =  (JsonObject) jsonParser.parse(result);
			int profileIconId = jResult.get("profileIconId").getAsInt(); // 소환사 profileIconId! 
			String name = jResult.get("name").getAsString(); // 소환사 name!
			String puuid = jResult.get("puuid").getAsString(); //소환사 puuid ! 
			long summonerLevel = jResult.get("summonerLevel").getAsLong(); // 소환사레벨! 
			long revisionDate = jResult.get("revisionDate").getAsLong(); // 소환사 revisionDate! 
			String id = jResult.get("id").getAsString(); // 소환사 id! 
			String accountId = jResult.get("accountId").getAsString(); // 소환사 account ID!
	
			summonerDto = new SummonerDto(profileIconId,name,puuid,summonerLevel,revisionDate,id,accountId); // 가져온객체를 생성자에 전달 
			
			model.addAttribute("SummonerName",summonerName);
			model.addAttribute("profileIconId",profileIconId);
			model.addAttribute("name",name);
			model.addAttribute("puuid",puuid);
			model.addAttribute("summonerLevel",summonerLevel);
			model.addAttribute("revisionDate",revisionDate);
			model.addAttribute("id",id);
			model.addAttribute("accountId",accountId);
			
		}catch(Exception e) {
			System.out.println(e);
		}
		
		return "home";
	}
	
}
