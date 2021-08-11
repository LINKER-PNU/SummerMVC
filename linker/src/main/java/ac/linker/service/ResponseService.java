package ac.linker.service;

import com.google.gson.JsonObject;

import org.springframework.stereotype.Service;

@Service
public class ResponseService {
    private JsonObject jsonObject = new JsonObject();
    public String getPhotonResponse(final int status) {
        jsonObject = new JsonObject();
        jsonObject.addProperty("State", "");
        jsonObject.addProperty("ResultCode", status);
        /*
         * 0 : OK 1 : Duplicated 2 : Over the max length
         */
        return jsonObject.toString();
    }

    public String getResultResponse(final boolean result){
        jsonObject = new JsonObject();
        jsonObject.addProperty("result", result);

        return jsonObject.toString();
    }

    // private String getMethodResponse(final String methodName){
    //     jsonObject.addProperty("method", methodName);
    //     Thread.currentThread().getStackTrace()[1].getMethodName();
    // }

    
}
