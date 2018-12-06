package com.functionalprograming;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MapperIntExample {

    public static void main(String[] args) {

        List<String> names = Arrays.asList("sri", "venu", "yansh", "sathvik");

        System.out.println("Imperative Style: ");

        for (String name : names) {
            if (!name.equals("Sam")) {
                Employee user = new Employee(name);
                System.out.println(user);
            }
        }

        System.out.println("Functional Style: ");

        names.stream()
                .filter(MapperIntExample::isNotSam)
                .map(Employee::new)
                .forEach(System.out::println);

        List<Employee> empList = names.stream()
                .filter(MapperIntExample::isNotSam)
                .map(Employee::new)
                .collect(Collectors.toList());

        int sum = empList.stream()
                .mapToInt(Employee::getAge)
                .sum();

        System.out.println(sum);
        
    }

    private static boolean isNotSam(String name) {
        return !name.equals("Sam");
    }

    static class Employee {
        private String name;
        private Integer age = 30;

        public Employee(String name) {
            this.name = name;
        }

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public Integer getAge() {
			return age;
		}

		public void setAge(Integer age) {
			this.age = age;
		}
        
    }
}