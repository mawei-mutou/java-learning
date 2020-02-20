package date20200219;

import java.util.ArrayList;
import java.util.List;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/2/19
 * time        : 9:46
 * description :
 */
public class Mapping {
    private List<String> patterns = new ArrayList<>();
    private String name;

    public Mapping() {
    }

    public Mapping(List<String> patterns, String name) {

        this.patterns = patterns;
        this.name = name;
    }

    public List<String> getPatterns() {
        return patterns;
    }

    public void setPatterns(List<String> patterns) {
        this.patterns = patterns;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addPatterns(String pattern) {
        patterns.add(pattern);
    }
}
