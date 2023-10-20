package run;

import ra.bussinessImp.Book;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class BookManagement {
    public static List<Book> books = new ArrayList<>();
    public static Scanner scanners = new Scanner(System.in);

    public static void main(String[] args) {
        do {
            System.out.println("**************************JAVA-HACKATHON-05-BASIC-MENU**************************");
            System.out.println("1. Nhập số sách và nhập thông tin sách");
            System.out.println("2. Hiển thị thông tin các sách");
            System.out.println("3. Sắp xếp sách theo lợi nhuận giảm dần");
            System.out.println("4. Xóa sách theo mã sách");
            System.out.println("5. Tìm kiếm sách theo tên sách");
            System.out.println("6. Thay đổi trạng thái của sách theo mã sách");
            System.out.println("7. Thoát");
            System.out.print("Nhập vào lựa chọn của bạn: ");
            int choice = Integer.parseInt(scanners.nextLine());
            switch (choice) {
                case 1:
                    addBook();
                    break;
                case 2:
                    showBook();
                    break;
                case 3:
                    sortBooksInterest();
                    break;
                case 4:
                    deleteBookById();
                    break;
                case 5:
                    searchBooksName();
                    break;
                case 6:
                    changeStatusbyId();
                    break;
                case 7:
                    scanners.close();
                    System.exit(0);
                default:
                    System.out.println("xin hãy nhập lại sự lựa chọn từ bàn phím");
            }
        } while (true);
    }

    private static void addBook() {
        System.out.println("Nhập số lượng sách thêm mới");
        int numberoffbookAdd = Integer.parseInt(scanners.nextLine());
        for (int i = 0; i < numberoffbookAdd; i++) {
            Book newBook = new Book();
            newBook.inputData();
            books.add(newBook);
        }
    }


    private static void showBook() {
        System.out.println("**************************BOOK**************************");
        if (!books.isEmpty()) {
            for (Book book : books) {
                book.displayData();
            }
        } else {
            System.out.println("Hiện không có quyển sách nào cả");
        }
    }

    private static void sortBooksInterest() {
        Collections.sort(books);
        System.out.println("Đã hoàn tất sắp xếp theo thứ tự");
        showBook();

    }

    private static void deleteBookById() {
        System.out.println("Nhập mã sách bạn muốn xóa :");
        int bookDeleteId = Integer.parseInt(scanners.nextLine());
        Book bookToDelete = new Book();
        for (Book book : books) {
            if(book.getBookId() == bookDeleteId) {
                bookToDelete = book;
                break;
            }
        }
        if (bookToDelete != null) {
            books.remove(bookToDelete);
            System.out.println("Sách đã được xóa thành công!");
        } else {
            System.err.println("Không tìm thấy mã sách vừa nhập!");
        }

    }

    private static void searchBooksName() {
        System.out.println("Nhập vào tên sách để tim kiếm");
        String bookName = scanners.nextLine();
        boolean isValid = true;
        for (Book book : books) {
            if (book.getBookName().toLowerCase().contains(bookName.trim().toLowerCase())) {
                isValid = false;
                book.displayData();
            }
        }
        if (isValid) {
            System.err.println("Không tìm thấy kết quả phù hợp:");
        }
    }


    private static void changeStatusbyId() {
        System.out.print("Nhập vào mã sách để thay đổi trạng thái: ");
        int bookIdToChangeStatus = Integer.parseInt(scanners.nextLine());
        for (Book book : books) {
            if (book.getBookId() == bookIdToChangeStatus) {
                if (book.BookStatus()) {
                    book.setBookStatus(false);
                    System.out.println("Trạng thái của mã sách đã đổi thành " + book.BookStatus());
                } else {
                    book.setBookStatus(true);
                    System.out.println("Trạng thái của mã sách đã đổi thành " + book.BookStatus());

                }
            }

        }
    }

}

