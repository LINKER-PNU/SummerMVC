package ac.linker.service;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import org.springframework.stereotype.Service;

@Service
public class ResponseService {
    private JsonObject jsonObject = new JsonObject();
    private Gson gson = new Gson();

    public String getPhotonResponse(final int status) {
        jsonObject = new JsonObject();
        jsonObject.addProperty("State", "");
        jsonObject.addProperty("ResultCode", status);
        /*
         * 0 : OK 1 : Duplicated 2 : Over the max length 3 : User is not in table
         */
        return jsonObject.toString();
    }

    public String getResultResponse(final int result) {
        jsonObject = new JsonObject();
        jsonObject.addProperty("resultCode", result);
        /*
         * 200 : OK 400 : Not found 500 : Server query error
         */

        return gson.toJson(jsonObject);
    }

    // private String getMethodResponse(final String methodName){
    // jsonObject.addProperty("method", methodName);
    // Thread.currentThread().getStackTrace()[1].getMethodName();
    // }

}
