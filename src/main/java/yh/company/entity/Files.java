package yh.company.entity;

public class Files {
    private int file_id;
    private String time;
    private String file_name;
    private long fuid;

    public int getFile_id() {
        return file_id;
    }

    public void setFile_id(int file_id) {
        this.file_id = file_id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getFile_name() {
        return file_name;
    }

    public void setFile_name(String file_name) {
        this.file_name = file_name;
    }

    public long getFuid() {
        return fuid;
    }

    public void setFuid(long fuid) {
        this.fuid = fuid;
    }

    @Override
    public String toString() {
        return "Files{" +
                "file_id=" + file_id +
                ", time='" + time + '\'' +
                ", file_name='" + file_name + '\'' +
                ", fuid=" + fuid +
                '}';
    }
}
