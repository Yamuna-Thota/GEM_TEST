package DDT;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class FetchingDataFromJsonFile {

	public static void main(String[] args) throws Throwable {
		File file = new File("./src/test/resources/Json.json");
  ObjectMapper obj = new ObjectMapper();
 JsonNode data = obj.readTree(file);
 
	}

}
