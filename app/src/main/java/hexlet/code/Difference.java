package hexlet.code;

import java.util.Objects;

public final class Difference {

    private String status;
    private Object value1;
    private Object value2;

    public Difference() {
    }

    public Difference(String status, Object value1) {
        this.status = status;
        this.value1 = value1;
    }

    public Difference(String status, Object value1, Object value2) {
        this(status, value1);
        this.value2 = value2;
    }

    public String getStatus() {
        return status;
    }

    public Object getValue1() {
        return value1;
    }

    public Object getValue2() {
        return value2;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setValue1(Object value1) {
        this.value1 = value1;
    }

    public void setValue2(Object value2) {
        this.value2 = value2;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }

        if (object != null && getClass() == object.getClass()) {
            Difference that = (Difference) object;
            boolean check = Objects.equals(status, that.status);
            check &= Objects.equals(value1, that.value1);
            check &= Objects.equals(value2, that.value2);
            return check;
        }

        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(status, value1, value2);
    }

}
