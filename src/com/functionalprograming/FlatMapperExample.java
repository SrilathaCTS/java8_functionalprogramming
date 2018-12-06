package com.functionalprograming;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
 

public class FlatMapperExample {

    public static void main(String[] args) {

        List<User> users = Arrays.asList(
                new User("Peter", 20, Arrays.asList("12342435", "768797978987")),
                new User("Sam", 40, Arrays.asList("87987987", "87987", "09-90-9-09-90")),
                new User("Ryan", 60, Arrays.asList("342535")),
                new User("Adam", 70, Arrays.asList("342535", "23466765"))
        );
        
        users.stream()
        .map(user -> user.getPhoneNumbers().stream())
        .flatMap(phoneStream -> phoneStream.filter(phoneNo -> phoneNo.equals("768797978987")))
        .forEach(System.out::println);

        Optional<String> stringOptional = users.stream()
                .map(user -> user.getPhoneNumbers().stream())
                .flatMap(phoneStream -> phoneStream.filter(phoneNo -> phoneNo.equals("342535")))
                .findAny();

        stringOptional.ifPresent(System.out::println);
    }
 
static class User {
        private String name;
        private Integer age;
        private List<String> phoneNumbers;
        
    	public User(String name, Integer age, List<String> phoneNumbers) {
			super();
			this.name = name;
			this.age = age;
			this.phoneNumbers = phoneNumbers;
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

		public List<String> getPhoneNumbers() {
			return phoneNumbers;
		}

		public void setPhoneNumbers(List<String> phoneNumbers) {
			this.phoneNumbers = phoneNumbers;
		}

    }
}