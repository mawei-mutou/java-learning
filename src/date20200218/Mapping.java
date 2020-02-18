package date20200218;

import java.util.HashSet;
import java.util.Set;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/2/18
 * time        : 15:22
 * description :
 */
public class Mapping {
    private String name;
    private Set<String> patterns;

    public Mapping() {
        this.patterns = new HashSet<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<String> getPatterns() {
        return patterns;
    }

    public void setPatterns(Set<String> patterns) {
        this.patterns = patterns;
    }

    public void addMapping(String string) {
        this.patterns.add(string);
    }
}
