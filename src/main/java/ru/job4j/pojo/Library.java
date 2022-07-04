package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book cleanCode = new Book("Clean code", 464);
        Book headFirst = new Book("Head First Java", 635);
        Book philosophy = new Book("Филосовия Java", 1168);
        Book library = new Book("Библиотека профессионала", 864);

        Book[] books = new Book[4];
        books[0] = cleanCode;
        books[1] = headFirst;
        books[2] = philosophy;
        books[3] = library;
        System.out.println("Вывод на консоль списка книг: ");
        for (int index = 0; index < books.length; index++) {
            Book bk = books[index];
            System.out.println(bk.getName() + " - " + bk.getPages());
        }
        System.out.println("Вывод на консоль списка после перемены местами 0 и 3 индекса: ");
        Book temp;
        temp = books[0];
        books[0] = books[3];
        books[3] = temp;
        for (int index = 0; index < books.length; index++) {
            Book bk = books[index];
            System.out.println(bk.getName() + " - " + bk.getPages());
        }
        System.out.println("Вывод на консоль книги Clean code: ");
        for (int index = 0; index < books.length; index++) {
            Book bk = books[index];
            if ("Clean code".equals(bk.getName())) {
                System.out.println(bk.getName() + " - " + bk.getPages());
            }
        }
    }
}
