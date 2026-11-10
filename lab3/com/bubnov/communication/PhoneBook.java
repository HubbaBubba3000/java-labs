package com.bubnov.communication;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;

public class PhoneBook {
    private final Map<String, String> records = new HashMap<>();

    /**
     * Добавляет контакт. Если имя уже было в справочнике, возвращает его старый телефон.
     */
    public String addRecord(String phone, String name) {
        validateContact(phone, "Телефон");
        validateContact(name, "Имя");

        String nameForPhone = findNameByPhone(phone);
        if (nameForPhone != null && !nameForPhone.equals(name)) {
            records.remove(nameForPhone);
        }
        return records.put(name, phone);
    }

    private String findNameByPhone(String phone) {
        for (Map.Entry<String, String> record : records.entrySet()) {
            if (record.getValue().equals(phone)) {
                return record.getKey();
            }
        }
        return null;
    }

    private static void validateContact(String value, String fieldName) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException(fieldName + " не должен быть пустым");
        }
    }

    public String removeByName(String name) {
        return records.remove(name);
    }

    public String getPhone(String name) {
        return records.get(name);
    }

    public boolean containsName(String name) {
        return records.containsKey(name);
    }

    public boolean containsPhone(String phone) {
        return records.containsValue(phone);
    }

    public int getCount() {
        return records.size();
    }

    public String[] getPairs() {
        String[] pairs = new String[records.size()];
        int index = 0;
        for (Map.Entry<String, String> record : records.entrySet()) {
            pairs[index++] = record.getValue() + " - " + record.getKey();
        }
        return pairs;
    }

    public String[] getNames() {
        return records.keySet().toArray(new String[0]);
    }

    public String[] getPhones() {
        return records.values().toArray(new String[0]);
    }

    public String[] getNamesContainPart(String part) {
        if (part == null) {
            throw new IllegalArgumentException("Часть имени не должна быть null");
        }
        List<String> names = new ArrayList<>();
        for (String name : records.keySet()) {
            if (name.startsWith(part)) {
                names.add(name);
            }
        }
        return names.toArray(new String[0]);
    }

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(System.lineSeparator());
        for (String pair : getPairs()) {
            joiner.add(pair);
        }
        return joiner.toString();
    }
}
