package me;

public class Answer {
    private int code;                        // status
    private String body;                     // body

    public Answer(int code) {                // 单参构造
        this.code = code;
        this.body = "";
    }
    public Answer(int code, String body){    // 双参
        this.code = code;
        this.body = body;
    }

    @Override
    public boolean equals(Object o) {        // 当前对象是否等于 对象o
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Answer answer = (Answer) o;

        if (code != answer.code) return false;
        if (body != null ? !body.equals(answer.body) : answer.body != null) return false;

        return true;
    }

    @Override
    public int hashCode() {                 // 返回一个哈希码
        int result = code;
        result = 31 * result + (body != null ? body.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {              // 返回code与body的字符串表达
        return "Answer(code=" + code + ", body=" + body + ")";
    }

    public String getBody() {
        return body;
    }

    public int getCode() {
        return code;
    }

    public static Answer ok(String body) {  // 返回一个code=200，body自定义的Answer对象
        return new Answer(200, body);
    }
}
