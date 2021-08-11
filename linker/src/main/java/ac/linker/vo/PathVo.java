package ac.linker.vo;

import com.google.gson.annotations.SerializedName;

public class PathVo {
	@SerializedName("GameId")
	private String gameId;

	public String getGameId() {
		return this.gameId;
	}

	public void setGameId(String gameId) {
		this.gameId = gameId;
	}

}
