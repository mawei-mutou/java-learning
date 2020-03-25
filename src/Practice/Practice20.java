package Practice;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/3/20
 * time        : 20:02
 * description :Valid Parentheses
 */
public class Practice20 {

    public static void main(String[] args) {
        String st = "{()}";
        String st1 = "(}";
        System.out.println(isValid(st1));
    }
    public  static boolean isValid(String s) {
        int count = 0;
        String[] left = new String[s.length() / 2];
        if (s.length() % 2 != 0) {
            return false;
        }
        for (int i = 0; (i < s.length()); i++) {
            if (count  <= s.length() / 2) {
                String temp = s.substring(i, i + 1);
                System.out.println(temp);
                if ((temp.equals("(") || temp.equals("{") || temp.equals("["))&&(count<s.length()/2)) {
                    left[count] = temp;
                    count++;
                } else if (count - 1 >= 0) {
                    switch (temp) {
                        case ")":
                            if (left[count - 1].equals("(")) {
                                count--;
                                break;
                            } else {
                                return false;
                            }

                        case "]":
                            if (left[count - 1].equals("[")) {
                                count--;
                                break;
                            } else {
                                return false;
                            }
                        case "}":
                            if (left[count - 1].equals("{")) {

                                count--;
                                break;
                            } else {
                                return false;
                            }
                    }
                } else {
                    return false;
                }
            } else {
                return false;
            }

        }
        if (count == 0) {
            return true;

        } else {
            return false;
        }
    }
}
