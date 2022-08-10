package ru.job4j.stream;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.List;

public class Analyze {
    public static double averageScore(Stream<Pupil> stream) {
     return stream
             .flatMap(pupil -> pupil.subjects().stream())
             .mapToInt(Subject::score)
             .average()
             .orElse(0.00);
    }

    public static List<Tuple> averageScoreByPupil(Stream<Pupil> stream) {
        return stream
                .map(s -> new Tuple(s.name(), s.subjects()
                    .stream()
                    .mapToInt(Subject::score)
                    .average()
                    .orElse(0)
                ))
                .collect(Collectors.toList());
    }

    public static List<Tuple> averageScoreBySubject(Stream<Pupil> stream) {
        return stream
                .flatMap(pupil -> pupil.subjects().stream())
                .collect(Collectors.groupingBy(Subject::name, LinkedHashMap::new,
                        Collectors.averagingDouble(Subject::score)))
                .entrySet()
                .stream()
                .map(s -> new Tuple(s.getKey(), s.getValue()))
                .collect(Collectors.toList());
    }

    public static Tuple bestStudent(Stream<Pupil> stream) {
        return stream
                .map(s -> new Tuple(s.name(), s.subjects()
                        .stream()
                        .mapToInt(Subject::score)
                        .sum()
                ))
                .max(Comparator.comparing(Tuple::score)).orElse(null);
    }

    public static Tuple bestSubject(Stream<Pupil> stream) {
        return stream
                .flatMap(pupil -> pupil.subjects().stream())
                .collect(Collectors.groupingBy(Subject::name,
                        Collectors.summingDouble(Subject::score)))
                .entrySet()
                .stream()
                .map(s -> new Tuple(s.getKey(), s.getValue()))
                .max(Comparator.comparing(Tuple::score)).orElse(null);
    }
}