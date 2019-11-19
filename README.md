## springboot笔记

### 6.springboot配置文件（springboot配置文件的名字是固定的）

1.application.properties

2.application.yml

springboot配置文件作用：修改springboot默认配置

YAML(YAML Ain't  Markup Language)

​	YAML A Markup Language:是一个标记于洋

​	YAML isn't Markup Language:不是一个标记语言

标记语言：

​	以前的配置文件大多是 ****.xml

​	YAML:是以数据为中心比json，xml等更适合做配置文件

```yml
server:
	port:8081
```

### xml

```xml
<server>
	<port>8081</port>
</server>
```

### YAML语法：

#### 基本语法：

key: (空格)value来表示一组键值对

一空格的缩进来表示层级关系，左对齐的一列表示同一层级	

#### 值得写法：

##### 字面量：普通的值（数字，字符串，布尔）

k: v直接来写：

​	字符串默认不用加引号。

​	“”： 双引号不会转义特殊字符

​	name: "zhangsan \n lisi" 输出 zhangsan 换行 lisi

​	‘’： 单引号会转义特殊字符

​	name: 'zhangsan \n lisi' 输出 zhangsan \n lisi

##### 对象，Map（属性和值）：

​	k: v :在下一行写属性和值

​	

```yml
frends:

	lastName: zhangsan

	age: 20
```



行内写法：

```
法人的事： {lastName: zhangsan, age: 20}
```



##### 数组（list set）:

用“-”值表示数组中的一个元素

```yml
pets:
    - cat
    - dog
    - pig
```

行内写法：

```
pets: [cat, dog, pig]
```

#### 配置文件注入：

```yml
person:
  lastName: zhangsan
  age: 20
  boos: false
  birthday: 2019/11/19
  maps: {k1: v1, k2: v2}
  lists:
    - cat
    - dog
    - pig
  dog:
    lastName: 旺财
    age: 2
```

##### @Value获取值和@ConfigurationProperties获取值比较

|                      | @ConfigurationPeoperties | @Value             |
| -------------------- | ------------------------ | ------------------ |
| 功能                 | 批量注入配置文件属性     | 一个个指定属性的值 |
| 松散绑定（松散语法） | 支持                     | 不支持             |
| spEL                 | 不支持                   | 支持               |
| jSR303数据校验       | 支持                     | 不支持             |
| 复杂类型封装         | 支持                     | 不支持             |

配置文件还是properties他们的都能获取到值；

如果说，我们只是在某个业务逻辑中需要获取配置文件中的某项之用@Value；

如果说，我们专门编写了一个javaBean来和配置文件进行映射就使用@ConfigurationProperties

#### @PropertySource and @ImportResource

@PropertySource:加载指定的配置文件

```java
@Component
@PropertySource(value = {"classpath:person.properties"})
@ConfigurationProperties(prefix = "person")
public class Person {
    private String lastName;
    private Integer age;
    private Boolean boos;
    private Date birthday;

    private Map<String, Object> maps;
    private List<Object> lists;
    private Dog dog;

    @Override
    public String toString() {
        return "Person{" +
                "lastName='" + lastName + '\'' +
                ", age=" + age +
                ", boos=" + boos +
                ", birthday=" + birthday +
                ", maps=" + maps +
                ", lists=" + lists +
                ", dog=" + dog +
                '}';
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Boolean getBoos() {
        return boos;
    }

    public void setBoos(Boolean boos) {
        this.boos = boos;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Map<String, Object> getMaps() {
        return maps;
    }

    public void setMaps(Map<String, Object> maps) {
        this.maps = maps;
    }

    public List<Object> getLists() {
        return lists;
    }

    public void setLists(List<Object> lists) {
        this.lists = lists;
    }

    public Dog getDog() {
        return dog;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }
}

```

@ImportResource:导入spring的配置文件。让配置文件生效

springboot里面没有spring的配置文件，我们自己编写的配置问阿金，也不能自动识别，想让spring的配置文件生效，加载进来的@ImportResource标注在一个配置类上

```java
@ImportResource(locations = {"classpath:beans.xml"})
```

##### springboot 推荐给容器组件的方式

使用@Bean给给springboot添加组件

```java
@Configuration
public class MyAppConfig {
    // @Bean注解讲方法的返回值添加到springboot容器中, 容器中bean的id就是方法名
    @Bean
    public HelloService helloService(){
        return new HelloService();
    }
}
```

##### 配置文件占位符

```

```

