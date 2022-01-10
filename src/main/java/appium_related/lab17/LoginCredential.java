package appium_related.lab17;

public class LoginCredential {
    private String username;
    private String password;
    private Job job;

    public LoginCredential(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Job getJob() {
        return job;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static class Job{
        private String position;

        public String getPosition() {
            return position;
        }

        @Override
        public String toString() {
            return "Job{" +
                    "position='" + position + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "LoginCredential{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", job=" + job +
                '}';
    }
}
