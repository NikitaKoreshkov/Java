package com.example;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController // Аннотация обозначает, что это контроллер, который будет обрабатывать HTTP-запросы
public class DemoController {

    // 1. Метод для получения текущего времени в Алматы.
    @GetMapping("/currentTime") // Этот метод обрабатывает GET-запрос по URL "/currentTime"
    public String getCurrentTime() {
        // Возвращает текущее время в часовом поясе Алматы
        return "Current Time in Almaty: " + LocalDateTime.now(ZoneId.of("Asia/Almaty")).toString();
    }

    // 2. Метод для получения списка чисел от 1 до n.
    // Параметр 'q' передается через запрос, и метод возвращает список чисел от 1 до этого числа.
    @GetMapping("/api") // Этот метод обрабатывает GET-запрос по URL "/api" с параметром запроса 'q'
    public List<Integer> getNumbers(@RequestParam("q") int n) {
        List<Integer> numbers = new ArrayList<>();
        // Цикл добавляет числа от 1 до n в список
        for (int i = 1; i <= n; i++) {
            numbers.add(i);
        }
        // Возвращает список чисел
        return numbers;
    }

    // 3. Метод возвращает строку с числом 690. Этот метод просто возвращает фиксированное число.
    @GetMapping("/number690") // Этот метод обрабатывает GET-запрос по URL "/number690"
    public String getNumber690() {
        // Возвращает строку "Number: 690"
        return "Number: 690";
    }

    // 4. Метод генерирует случайное число от 1 до 77.
    @GetMapping("/random_number") // Этот метод обрабатывает GET-запрос по URL "/random_number"
    public String getRandomNumber() {
        Random random = new Random(); // Создает объект Random для генерации случайных чисел
        int randomNumber = random.nextInt(77) + 1; // Генерирует случайное число от 1 до 77
        // Возвращает строку с случайным числом
        return "Random Number: " + randomNumber;
    }


    // 6. Метод для возврата строки "Hello my name is Nikita" в обратном порядке.
    @GetMapping("/reverse") // Этот метод обрабатывает GET-запрос по URL "/reverse"
    public String reverseString() {
        String originalString = "Hello my name is Nikita"; // Оригинальная строка
        // Возвращает строку в обратном порядке
        return "Reversed String: " + new StringBuilder(originalString).reverse().toString();
    }
}
