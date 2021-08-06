package ac.linker.vo;

import com.google.gson.annotations.SerializedName;

public class PathVO {
    @SerializedName("GameId")
    private String gameId;

	public String getGameId() {
		return this.gameId;
	}

	public void setGameId(String gameId) {
		this.gameId = gameId;
	}

}
