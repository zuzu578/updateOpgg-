package com.myopgg.myapp.summonerDto;

public class SummonerDto {
	
	private String accountId; // 해당 소환사의 계정 id 
	private int profileIconId; // 해당 소환사의 프로필 아이콘 id
	private long revisionDate; // 해당 소환사의 revisionDate
	private String name ; // 해당 소환사의 name 
	private String id;// 해당 소환사의 Encrypted summoner ID.
	private String puuid; // 해당 소환사의 Encrypted puuid
	private String summonerLevel; //해당 소환사의 레벨.

	public SummonerDto(int profileIconId2, String name, String puuid, long summonerLevel, long revisionDate,
			String id, String accountId) {
		// TODO Auto-generated constructor stub
	}

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public int getProfileIconId() {
		return profileIconId;
	}

	public void setProfileIconId(int profileIconId) {
		this.profileIconId = profileIconId;
	}

	public long getRevisionDate() {
		return revisionDate;
	}

	public void setRevisionDate(long revisionDate) {
		this.revisionDate = revisionDate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPuuid() {
		return puuid;
	}

	public void setPuuid(String puuid) {
		this.puuid = puuid;
	}

	public String getSummonerLevel() {
		return summonerLevel;
	}

	public void setSummonerLevel(String summonerLevel) {
		this.summonerLevel = summonerLevel;
	}

	@Override
	public String toString() {
		return "SummonerDto [accountId=" + accountId + ", profileIconId=" + profileIconId + ", revisionDate="
				+ revisionDate + ", name=" + name + ", id=" + id + ", puuid=" + puuid + ", summonerLevel="
				+ summonerLevel + "]";
	}
	
 
}
