package pages.models;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class LoginAndPassForBruteForce {
    private List<String> loginsForBrute;
    private List<String> passwordsForBrute;


    public LoginAndPassForBruteForce() {
        try {
            setPasswordsForBrute(Files.readAllLines(Paths.get("src\\main\\resources\\passwords.txt")));
            setLoginsForBrute(Files.readAllLines(Paths.get("src\\main\\resources\\logins.txt")));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public List<String> getLoginsForBrute() {
        return loginsForBrute;
    }

    public void setLoginsForBrute(List<String> loginsForBrute) {
        this.loginsForBrute = loginsForBrute;
    }

    public List<String> getPasswordsForBrute() {
        return passwordsForBrute;
    }

    public void setPasswordsForBrute(List<String> passwordsForBrute) {
        this.passwordsForBrute = passwordsForBrute;
    }

}
