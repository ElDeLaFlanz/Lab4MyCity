package com.example.lab4mycity.data

import com.example.lab4mycity.model.Category
import com.example.lab4mycity.model.Recommendation

object LocalCityDataProvider {

    val categories = listOf(
        Category("coffee", "Кофейни"),
        Category("parks", "Парки"),
        Category("restaurants", "Рестораны"),
        Category("malls", "ТЦ"),
        Category("pools", "Бассейны"),
        Category("gyms", "Спортзалы")
    )

    val recommendations = listOf(
        // Кофейни
        Recommendation("1", "coffee", "Coffee Like", "Быстрая кофейня"),
        Recommendation("2", "coffee", "Traveler's Coffee", "Уютное место"),
        Recommendation("3", "coffee", "Surf Coffee", "Стильное кафе"),

        // Парки
        Recommendation("4", "parks", "Центральный парк", "Прогулки"),
        Recommendation("5", "parks", "Набережная", "Вид на реку"),
        Recommendation("6", "parks", "Сквер Кирова", "Спокойный отдых"),

        // Рестораны
        Recommendation("7", "restaurants", "BBQ House", "Мясо"),
        Recommendation("8", "restaurants", "Sushi Bar", "Японская кухня"),
        Recommendation("9", "restaurants", "Italiano", "Паста и пицца"),

        // ТЦ
        Recommendation("10", "malls", "Mega", "Большой ТЦ"),
        Recommendation("11", "malls", "City Mall", "Кино + магазины"),
        Recommendation("12", "malls", "Galaxy", "Развлечения"),

        // Бассейны
        Recommendation("13", "pools", "Аквацентр", "Большой бассейн"),
        Recommendation("14", "pools", "Олимп", "Спортивный"),
        Recommendation("15", "pools", "Волна", "Для отдыха"),

        // Спортзалы
        Recommendation("16", "gyms", "Iron Gym", "Тренажеры"),
        Recommendation("17", "gyms", "Fitness Pro", "Групповые занятия"),
        Recommendation("18", "gyms", "Power Club", "Силовые тренировки")
    )
}