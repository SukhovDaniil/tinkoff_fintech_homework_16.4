package petstore.api.models;

import java.util.Objects;

public class ResponseBody {
    private int code;
    private String type;
    private String message;

    /**
     * @return Код ответа.
     */
    public int getCode() {
        return code;
    }

    /**
     * @param code Код ответа.
     */
    public void setCode(final int code) {
        this.code = code;
    }

    /**
     * @return Тип ответа.
     */
    public String getType() {
        return type;
    }

    /**
     * @param type Тип ответа.
     */
    public void setType(final String type) {
        this.type = type;
    }

    /**
     * @return Сообщение ответа.
     */
    public String getMessage() {
        return message;
    }

    /**
     * @param message Сообщение ответа.
     */
    public void setMessage(final String message) {
        this.message = message;
    }

    /**
     * @param o Ответ, с которым сравнивается текущий.
     * @return True - одинаковые, False - разные.
     */
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ResponseBody)) {
            return false;
        }
        ResponseBody that = (ResponseBody) o;
        return code == that.code && Objects.equals(type, that.type) && Objects.equals(message, that.message);
    }

    /**
     * @return Хеш-код ответа.
     */
    @Override
    public int hashCode() {
        return Objects.hash(code, type, message);
    }
}
