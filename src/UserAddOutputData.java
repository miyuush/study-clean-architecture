public class UserAddOutputData implements OutputData {
    private String createId;

    public UserAddOutputData(String createId) {
        this.createId = createId;
    }

    public String getCreateId() { return createId; }
}
