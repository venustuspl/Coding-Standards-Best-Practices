package pl.praktycznajava.module4.cleancode.challenge1;

import pl.praktycznajava.module4.cleancode.challenge1.model.*;

public class Challenge1Service {

    // -------------------------------------------------------------------------------------------------------
    // Challenge 1. Zrefaktoryzuj ciała poniższych metod w taki sposób, aby były jasne i czytelne.
    //              Wykorzystaj statyczne metody fabryczne. A także odpowiednio wydziel metody i stałe.
    // -------------------------------------------------------------------------------------------------------

    public void checkDistance1(double miles) {
        double kilometers = miles * 1.6093f;
        Distance distance = new Distance(kilometers);

        // dalsze instrukcje
    }

    public void checkDistance2(double kilometers) {
        Distance distance = new Distance(kilometers);

        // dalsze instrukcje
    }

    public void addECTSPoints(Student student, Course course, CourseStatistics courseStatistics) {
        // jeśli kurs został zaliczony, to dodaj studentowi punkty ECTS - komentarz do usunięcia
        if (courseStatistics.getAttendancePercentage() >= 50 && courseStatistics.getGradeAverage() >= 50) {
            student.addECTSPoints(course.getECTSPoints());
        }
    }

    public void buy(Product product, ShoppingCart shoppingCart) {
        if(product.getStockQuantity() > 0) {
            shoppingCart.addProduct(product);
        }
    }

    public void calculatePrice(Reservation reservation) {
        // jeśli liczba dni rezerwacji jest większa niż 4 to naliczona jest zniżka - komentarz do usunięcia
        if (reservation.getNumberOfDays() > 4) {
            // todo
        }
    }

}
