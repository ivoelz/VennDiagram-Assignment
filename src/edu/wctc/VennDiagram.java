package edu.wctc;

import java.util.HashSet;
import java.util.Set;

public class VennDiagram<T> {

    private String label1;
    private String label2;
    private String label3;
    private Set<T> circleOne;
    private Set<T> circleTwo;
    private Set<T> circleThree;

    public VennDiagram(String one, String two, String three) {
        this.circleOne = new HashSet<>();
        this.circleTwo = new HashSet<>();
        this.circleThree = new HashSet<>();
        this.label1 = one;
        this.label2 = two;
        this.label3 = three;
    }

    private Set<T> getCircleForLabel(String label) {
        if (label.equals(label1)) {
            return circleOne;
        }
        else if (label.equals(label2)) {
            return circleTwo;
        }
        else if (label.equals(label3)) {
            return circleThree;
        }
        else return null;
    }

    public void add(T item, String... labels) {
        for (int i = 0; i < labels.length; i++) {
            getCircleForLabel(labels[i]).add(item);
        }
    }

    public Set<T> unionOf(String first, String second) {
        Set<T> unionSet = new HashSet<>(getCircleForLabel(first));
        unionSet.addAll(getCircleForLabel(second));
        return unionSet;
    }

    public Set<T> intersectionOf(String first, String second) {
        Set<T> intersectionSet = new HashSet<>(getCircleForLabel(first));
        intersectionSet.retainAll(getCircleForLabel(second));
        return intersectionSet;
    }

    public Set<T> complementOf(String first, String second) {
        Set<T> complementSet = new HashSet<>(getCircleForLabel(first));
        complementSet.removeAll(getCircleForLabel(second));
        return complementSet;
    }

    public Set<T> diagramCenter() {
        Set<T> allLabels = new HashSet<>(getCircleForLabel(label1));
        allLabels.retainAll(getCircleForLabel(label2));
        allLabels.retainAll(getCircleForLabel(label3));
        return allLabels;
    }

}
