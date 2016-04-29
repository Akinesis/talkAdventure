package robots;

import org.alicebot.ab.Bot;
import org.alicebot.ab.Chat;

public class BotsManager {

	private String botName;
	private String path;
	private Bot bot;
	private Chat chatSession;

	public BotsManager(){
		botName = "common"; 
		path = "C:/Users/joachim/workspace/talkAdventure";
		bot = new Bot(botName, path);
		chatSession = new Chat(bot);

	}

	public String dialogue(){
		return chatSession.multisentenceRespond("hello"); 
	}

}
