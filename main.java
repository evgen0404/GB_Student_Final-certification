import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Collections;
import java.util.Objects;


    // Основной метод для тестирования функциональности класса PhoneBook
    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();

        // Добавляем номера телефонов в телефонную книгу
        phoneBook.addPhoneNumber("John", 123456789);
        phoneBook.addPhoneNumber("John", 987654321);
        phoneBook.addPhoneNumber("John", 555555555);
        phoneBook.addPhoneNumber("Alice", 111111111);
        phoneBook.addPhoneNumber("Bob", 222222222);
        phoneBook.addPhoneNumber("Alice", 333333333);

       

        // удаление из списка
        phoneBook.removePhoneNumber("Bob", 222222222);
        phoneBook.printAll();

        //вывод отсортированного списка
        phoneBook.printAll();
    }


