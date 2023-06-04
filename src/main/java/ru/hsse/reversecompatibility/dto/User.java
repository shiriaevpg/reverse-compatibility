package ru.hsse.reversecompatibility.dto;


public record User(
        Long id,
        String login,
        String name,
        String surname,
        int age
) {
}
