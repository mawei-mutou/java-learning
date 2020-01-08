## 简介
LocalDateTime是Java8中添加的类,用于补充java在日期处理的短处，常用的类还有LocalDate,LocalTime,Duration,Period,

## 常用API
包括获取当前时间，指定特定时间。进行时间的加减等
```java
LocalDateTime localDateTime3 = LocalDateTime.now();
LocalDate.now();
LocalTime.now();
localDateTime3.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
LocalDateTime localDateTime4 = localDateTime3.minus(23,ChronoUnit.MONTHS);
localDateTime4.atZone(ZoneId.systemDefault());
localDateTime4 = localDateTime4.withHour(3);
localDateTime4 = localDateTime4.withYear(2016);
localDateTime4 = localDateTime4.with(ChronoField.MONTH_OF_YEAR,3);
```
## 间隔计算
使用Duration进行 day,hour,minute,second等的计算
使用Period进行Year,Month的计算
```java
Duration duration = Duration.between(localDateTime,localDateTime4);
duration.toDays();
duration.toHours();
duration.toMinutes();
Period period2 = Period.between(localDateTime.toLocalDate(),localDateTime4.toLocalDate());
period2.getYears();
period2.getMonths();
period2.toTotalMonths();
```
## 与Date的转化，format为String
```java
Date date = Date.from(localDateTime4.atZone(ZoneId.systemDefault()).toInstant());
LocalDateTime dateTime = LocalDateTime.ofInstant(date.toInstant(),ZoneId.systemDefault());

localDateTime3.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
```

## 关于毫秒
在秒与毫秒之间需添加间隔，否则会转化失败，应该是个bug
```
DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss.SSS");
String lastUpdateTime = updateTimeService.getUpdateTimeByType(tableType.getShortName());
try {
    lastUpdate = LocalDateTime.parse(lastUpdateTime, formatter);
} catch (RuntimeException e) {
    log.warn("failed to parse last update time, use last hour instead.");
}
```

## 为什么日期类型字段不在mysql里用date类型？
使用字符可在数据库端，后端，前端保持一致性。避免前后端数据库之间来回转换，提高效率，对于字段操作不频繁的，使用字符串代替，在需要的地方进行转换即可。

## MyBatis的自动封装
在Mybatis中会自动处理，将java.util.Date与MySQL的date类型关联。(事实编程标准)