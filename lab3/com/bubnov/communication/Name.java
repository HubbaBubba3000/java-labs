package com.bubnov.communication;
public class Name {
    private final String lastname;
    private final String firstname;
    private final String patronymic;

    private boolean isEmpty(String s){
        return s == null || s.isBlank();
    }

    public Name(String firstName, String lastName, String patronymic) {
        if (isEmpty(firstName) && isEmpty(lastName) && isEmpty(patronymic)) {
            throw new IllegalArgumentException("имя не указано");
        }
        this.firstname  = firstName;
        this.lastname   = lastName;
        this.patronymic = patronymic;
    }

    public Name(String firstName) {
        this(firstName, null, null);
    }

    public Name(String firstName, String lastName) {
        this(firstName, lastName, null);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        appendPart(sb, this.lastname);
        appendPart(sb, this.firstname);
        appendPart(sb, this.patronymic);
        return sb.toString();
    }

    private void appendPart(StringBuilder sb, String part) {
        if (part != null && !part.isBlank()) {
            if (sb.length() > 0) {
                sb.append(' ');
            }
            sb.append(part);
        }
    }
}
