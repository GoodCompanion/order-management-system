package com.github.goodcompanion.ordersystem.model.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

public class ProductTest {
    void testProductBuilder() {
        String sku = "2352362345";
        String name = "Видеокарта MSI RTX 5060 GAMING OC 8GB";
        String description = "**Видеокарта MSI RTX 5060 GAMING OC 8GB** — это мощное устройство для тех, кто ценит высокое качество графики и производительность в играх.\n" +
                "**Основные характеристики:**\n" +
                "**Производитель графического процессора:** NVIDIA.\n" +
                "**Модель графического процессора:** RTX 5060.\n" +
                "**Тип видеопамяти:** GDDR7.\n" +
                "**Объём видеопамяти:** 8 ГБ.\n" +
                "**Разрядность шины видеопамяти:** 128 бит.\n" +
                "**Заводской разгон (Overclocking):** да.\n" +
                "**Максимальное разрешение:** 7680 x 4320.\n" +
                "**Подключение и интерфейсы:**\n" +
                "**Количество DisplayPort:** 3.\n" +
                "**Количество HDMI:** 1.\n" +
                "**Разъёмы дополнительного питания:** 8pin.\n" +
                "**Количество занимаемых слотов:** 3.\n" +
                "**Длина видеокарты (PCB):** 248 мм.\n" +
                "**Охлаждение и дополнительные особенности:**\n" +
                "**Количество вентиляторов:** 2.\n" +
                "**Тип охлаждения:** активное.\n" +
                "**Преимущества:**\n" +
                "**Назначение:** игровая видеокарта, идеально подходящая для современных игр и требовательных приложений.\n" +
                "**Количество подключаемых мониторов:** до 4, что позволяет расширить рабочее пространство и улучшить игровой опыт.\n" +
                "**Низкий профиль:** нет, видеокарта имеет стандартные размеры и не предназначена для компактных систем.\n" +
                "Видеокарта MSI RTX 5060 GAMING OC 8GB обеспечит вам высокую производительность и отличное качество изображения. Она станет отличным выбором для тех, кто хочет получить максимум от своих игр.";
        String category = "Видеокарты";
        BigDecimal price = BigDecimal.valueOf(33333);
        Long stockQuantity = 30L;
        Boolean isActive = true;
        LocalDateTime createdAt = LocalDateTime.now();

        Product product = Product.builder()
                .sku(sku)
                .name(name)
                .description(description)
                .category(category)
                .price(price)
                .stockQuantity(stockQuantity)
                .isActive(isActive)
                .createdAt(createdAt)
                .build();

        assertEquals(product.getName(), name);
    }
}
