package com.test.hello;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class PhoneBook {
    HashMap<String, ArrayList> hashMap=new HashMap<>();
    ArrayList list = new ArrayList();

    ArrayList<String> phoneNumber = new ArrayList<>();

    public void phonesToList(){
        phoneNumber.add("+8-800-200-05-00");
        phoneNumber.add("+8-800-200-06-00");
        hashMap.put("Иванов И.И.",phoneNumber);

        phoneNumber = new ArrayList<>();
        phoneNumber.add("+8-800-200-07-00");
        hashMap.put("Петров П.П.",phoneNumber);

        phoneNumber = new ArrayList<>();
        phoneNumber.add("+8-800-200-08-00");
        phoneNumber.add("+8-800-200-09-00");
        phoneNumber.add("+8-800-200-00-00");
        hashMap.put("Сидоров С.С.",phoneNumber);

        phoneNumber = new ArrayList<>();
        hashMap.put("Лобанов Л.Л.",phoneNumber);
    }

    public String getContact(){
        Scanner in = new Scanner(System.in);
        String contactName = in.nextLine();
        return contactName;
    }

    public void checkPhone(){
        String contact = getContact();
        if (hashMap.containsKey(contact)){
            try {
                list = hashMap.get(contact);
                if (list.isEmpty()) {
                    System.out.println("Для абонента " + contact + " не заданы номера телефонов");
                } else {
                    list.forEach((x) -> System.out.println(String.valueOf(list.indexOf(x) + 1) + ". " + x));
                }
            }
            catch (Exception e){
                System.out.println("Для абонента " + contact + " не заданы номера телефонов");
            }
        }
        else{
            System.out.println("Абонент " + contact + " не найден в справочнике!");
        }
    }

    public void printHash(){
        System.out.print("Выберите один из вариантов (" + hashMap.keySet().toString().substring(1,hashMap.keySet().toString().length() - 1) + ") или введите свой: ");
    }

    public static void main(String args[]){
        PhoneBook phoneBookExample = new PhoneBook();
        phoneBookExample.phonesToList();
        phoneBookExample.printHash();
        phoneBookExample.checkPhone();
    }
}

