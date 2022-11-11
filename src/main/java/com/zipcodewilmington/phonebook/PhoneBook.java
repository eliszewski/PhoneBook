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
        this(new LinkedHashMap<String, List<String>>());
    }

    public void add(String name, String phoneNumber) {
        List<String> phoneNumbers = this.phonebook.get(name);
        if(phoneNumbers == null){
            phoneNumbers = new ArrayList<>();
        }
        phoneNumbers.add(phoneNumber);
        phonebook.put(name,phoneNumbers);
    }

    public void addAll(String name, String... phoneNumbers) {
        for (String number:phoneNumbers
             ) {
            this.add(name,number);
        }
    }

    public void remove(String name) {
        phonebook.remove(name);
    }

    public Boolean hasEntry(String name) {
        return phonebook.containsKey(name);
    }

    public Boolean hasEntry(String name, String phoneNumber){
        return phonebook.containsKey(name) && phonebook.get(name).contains(phoneNumber);

    }

    public List<String> lookup(String name) {
        return phonebook.get(name);
    }

    public String reverseLookup(String phoneNumber)  {
        for (String name:this.getAllContactNames()
             ) {
            if(lookup(name).contains(phoneNumber)) return name;
        }
        return null;
    }

    public List<String> getAllContactNames() {
        List<String> allContacts = new ArrayList<>();
        for (String name:phonebook.keySet()
             ) {
            allContacts.add(name);
        }
        return allContacts;
    }

    public Map<String, List<String>> getMap() {
        return phonebook;
    }
}
