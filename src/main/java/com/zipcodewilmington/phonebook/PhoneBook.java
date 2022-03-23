package com.zipcodewilmington.phonebook;

import java.util.*;
//import java.util.HashMap;


/**
 * Created by leon on 1/23/18.
 * Made WAY better by kristofer 6/16/20
 */
public class PhoneBook {

    private final Map<String, List<String>> phonebook;

    public PhoneBook(Map<String, List<String>> map) {
        this.phonebook = map;
    }

    public PhoneBook() {
        this.phonebook = new LinkedHashMap<>();
    }

    public void add(String name, String phoneNumber) {
        addAll(name, phoneNumber);
    }

    public void addAll(String name, String... phoneNumbers) {
        phonebook.put(name, new ArrayList<>());
        for (String number : phoneNumbers){
            phonebook.get(name).add(number);
        }
    }

    public void remove(String name) {
        phonebook.remove(name);
    }
    public String reverseLookup(String phoneNumber)  {
        for(Map.Entry<String, List<String>> contact : phonebook.entrySet()){
            if (contact.getValue().contains(phoneNumber)){
                return contact.getKey();
            }
        }
        return null;
    }
    public Boolean hasEntry(String name, String phoneNumber) {
        if(phonebook.containsKey(name) && reverseLookup(phoneNumber).equals(name)){
            return true;
        }
        return false;
    }

    public List<String> lookup(String name) {
        return phonebook.get(name);
    }


    public List<String> getAllContactNames() {
        List<String> contacts = new ArrayList<>();
        for(Map.Entry<String, List<String>> contact : phonebook.entrySet()){
            contacts.add(contact.getKey());
        }
        return contacts;
    }

    public Map<String, List<String>> getMap() {
        return phonebook;
    }
}
