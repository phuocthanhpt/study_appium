package appium_related.lab17;

import appium_related.utils.data.DataObjectBuilder;
import com.google.gson.Gson;

public class TestGSon {
    public static void main(String[] args) {
        String jsonObject = "[\n" +
                "  {\n" +
                "    \"username\": \"teo\",\n" +
                "    \"password\": \"87654321\",\n" +
                "    \"job\" : {\n" +
                "      \"position\" : \"SDET\"\n" +
                "    }\n" +
                "  },\n" +
                "  {\n" +
                "    \"username\": \"ti\",\n" +
                "    \"password\": \"12345678\",\n" +
                "    \"job\" : {\n" +
                "      \"position\" : \"QA auto\"\n" +
                "    }\n" +
                "  }\n" +
                "]";

        Gson gson = new Gson();
        LoginCredential[] loginCredential = gson.fromJson(jsonObject, LoginCredential[].class);
        for (LoginCredential cred: loginCredential) {
            System.out.println(cred);
            System.out.println(cred.getJob().getPosition());
        }

        String jsonFilePath = "/src/main/java/appium_related/lab17/LoginCredential.json";
        LoginCredential[] loginCred2 = DataObjectBuilder.buildDataObject(jsonFilePath, LoginCredential[].class);
        for (LoginCredential cred: loginCred2) {
            System.out.println(cred);
            System.out.println(cred.getJob().getPosition());
        }
    }
}
