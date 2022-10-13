package sky.pro.java;

import java.io.PrintStream;
import java.time.LocalDate;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    //Task №1:
    System.out.println("Task №1");
    int year = 2028;
    if (checkYear(year)) {
      System.out.printf("Год %d является високосным \n", year);
    } else {
      System.out.printf("Год %d не является високосным \n", year);
    }
    //Task №2:
    System.out.println("Task №2");
    Scanner scan = new Scanner(System.in);
    System.out.println("Нажмите 0, если у Вас iOS\nНажмите 1, если у Вас Android");
    int clientOS = scan.nextInt();
    System.out.println("Введите год выпуска Вашего устройства в формате: 2021");
    int clientDeviceYear = scan.nextInt();
    checkDevice(clientOS, clientDeviceYear);
    //Task №3:
    System.out.println("Task №3");
    int deliveryDistance = 55;
    int oneDay = 1;
    numberOfDeliveryDays(deliveryDistance, oneDay);
  }

  //Task №1
  public static boolean checkYear(int year) {
    return (year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0);
  }

  //Task №2
  public static void checkDevice(int clientOS, int clientDeviceYear) {
    if (clientOS == 0 && clientDeviceYear < LocalDate.now().getYear()) {
      System.out.println("Установите облегченную версию приложения для iOS по ссылке");
    } else if (clientOS == 0 && clientDeviceYear >= LocalDate.now().getYear()) {
      System.out.println("Установите версию приложения для iOS по ссылке");
    } else if (clientOS == 1 && clientDeviceYear < LocalDate.now().getYear()) {
      System.out.println("Установите облегченную версию приложения для Android по ссылке");
    } else {
      System.out.println("Установите версию приложения для Android по ссылке");
    }
  }

  //Task №3
  public static PrintStream numberOfDeliveryDays(int deliveryDistance, int oneDay) {
    if (deliveryDistance > 20) {
      oneDay++;
    }
    if (deliveryDistance > 60) {
      oneDay++;
    }
    return System.out.printf("Потребуется %d дней доставки ", oneDay);
  }
}
