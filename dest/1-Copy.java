();
        int aa = dis.readInt();
        boolean f = dis.readBoolean();
        char p = dis.readChar();
        Object pp = dis.readObject();
        Object date = dis.readObject();
        Object person2 = dis.readObject();
        dis.close();
        if (pp instanceof String) {
            System.out.println((String) pp);
        }
        if (date instanceof Date) {
            System.out.println((Date) date);
        }
        if (person2 instanceof Person2) {
            Person2 man = (Person2) person2;
            System.out.println("姓名：" + man.getName() + "\t年龄：" + man.getAge() + "\t工资：" + man.getSalary());
        }

    }
}