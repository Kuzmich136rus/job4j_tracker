package ru.job4j.map;

import java.util.*;

public class AnalyzeByMap {
    public static double averageScore(List<Pupil> pupils) {
        double currSum = 0;
        int count = 0;
        for (Pupil currPupil : pupils) {
            for (Subject currSubject : currPupil.subjects()) {
                currSum += currSubject.score();
                count++;
            }
        }
        return currSum / count;
    }

    public static List<Label> averageScoreByPupil(List<Pupil> pupils) {
        double currPupilSum;
        List<Label> scorePupil = new ArrayList<>();
        for (Pupil currPupil : pupils) {
            currPupilSum = 0;
            for (Subject currSubject : currPupil.subjects()) {
                currPupilSum += currSubject.score();
            }
            scorePupil.add(new Label(currPupil.name(), currPupilSum / currPupil.subjects().size()));
        }
        return scorePupil;
    }

    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        List<Label> scoreSubject = new ArrayList<>();
        Map<String, Integer> temp = new LinkedHashMap<>();
        for (Pupil currPupil : pupils) {
            for (Subject currSubject : currPupil.subjects()) {
                temp.merge(currSubject.name(), currSubject.score(), Integer::sum);
            }
        }
        for (Map.Entry<String, Integer> entry : temp.entrySet()) {
            String key = entry.getKey();
            int score = entry.getValue() / pupils.size();
            scoreSubject.add(new Label(key, score));
        }
        return scoreSubject;
    }

    public static Label bestStudent(List<Pupil> pupils) {
        double currPupilSum;
        List<Label> bestPupil = new ArrayList<>();
        for (Pupil currPupil : pupils) {
            currPupilSum = 0;
            for (Subject currSubject : currPupil.subjects()) {
                currPupilSum += currSubject.score();
            }
            bestPupil.add(new Label(currPupil.name(), currPupilSum));
        }
        bestPupil.sort(Comparator.naturalOrder());
        return bestPupil.get(bestPupil.size() - 1);
    }

    public static Label bestSubject(List<Pupil> pupils) {
        List<Label> bestSubject = new ArrayList<>();
        Map<String, Integer> temp = new LinkedHashMap<>();
        for (Pupil currPupil : pupils) {
            for (Subject currSubject : currPupil.subjects()) {
                temp.merge(currSubject.name(), currSubject.score(), Integer::sum);
            }
        }
        for (Map.Entry<String, Integer> entry : temp.entrySet()) {
            String key = entry.getKey();
            int score = entry.getValue();
            bestSubject.add(new Label(key, score));
        }
        bestSubject.sort(Comparator.naturalOrder());
        return bestSubject.get(bestSubject.size() - 1);
    }
}
