import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

class PhoneBook {
    private static HashMap<String, PhoneEntry> phoneBook = new HashMap<>();

    // Внутренний класс для хранения записей телефонной книги
    static class PhoneEntry {
        String name;
        ArrayList<Integer> phoneNumbers;

        PhoneEntry(String name) {
            this.name = name;
            this.phoneNumbers = new ArrayList<>();
        }

        void addPhoneNumber(Integer phoneNum) {
            phoneNumbers.add(phoneNum);
        }

        void removePhoneNumber(Integer phoneNum) {
            phoneNumbers.remove(phoneNum);
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            PhoneEntry that = (PhoneEntry) obj;
            return name.equals(that.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name);
        }

        @Override
        public String toString() {
            return name + ": " + phoneNumbers;
        }
    }

    // Метод для добавления номера телефона в запись
    public void addPhoneNumber(String name, Integer phoneNum) {
        phoneBook.computeIfAbsent(name, k -> new PhoneEntry(name)).addPhoneNumber(phoneNum);
    }

    // Метод для удаления номера телефона из записи
    public void removePhoneNumber(String name, Integer phoneNum) {
        PhoneEntry entry = phoneBook.get(name);
        if (entry != null) {
            entry.removePhoneNumber(phoneNum);
        }
    }

    // Метод для вывода всего списка, отсортированного по количеству номеров телефона по убыванию
    public void printAll() {
        List<PhoneEntry> entries = new ArrayList<>(phoneBook.values());
        entries.sort((entry1, entry2) -> Integer.compare(entry2.phoneNumbers.size(), entry1.phoneNumbers.size()));

        for (PhoneEntry entry : entries) {
            System.out.println(entry);
        }
    }
}
